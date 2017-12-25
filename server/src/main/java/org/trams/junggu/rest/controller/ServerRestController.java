/*
 * Created on 22 Feb 2016 ( Time 14:37:23 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.trams.junggu.rest.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.trams.junggu.bean.Category;
import org.trams.junggu.bean.Server;
import org.trams.junggu.bean.Store;
import org.trams.junggu.bean.Version;
import org.trams.junggu.business.service.ServerService;
import org.trams.junggu.rest.common.Message;
import org.trams.junggu.rest.common.ReturnValue;
import org.trams.junggu.web.common.Utils;
import org.trams.junggu.web.listitem.ServerListItem;

/**
 * Spring MVC controller for 'Server' management.
 */
@Controller
public class ServerRestController {

	@Resource
	private ServerService serverService;
	
	@RequestMapping(value = "/items/server", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ReturnValue findAllAsListItems(@RequestBody String json) {
		ReturnValue rv = new ReturnValue();
		try {
			
			JSONParser parser = new JSONParser();
			JSONObject jsonObj = (JSONObject) parser.parse(json);
			Long updateDate = org.trams.junggu.web.common.Utils.parseLong(jsonObj.get("updateDate"));
			
			Date dateUpdate = new Date(updateDate);

			List<Server> list = serverService.findAllUpdate(dateUpdate);
			if (list.size() > 0) {
				rv.ReturningObject(list);
			} else {
				rv.ReturningString(Message.LIST_UPDATE_FAIL, Message.LIST_UPDATE_ZERO_CODE);
			}
		} catch (Exception e) {
			rv.ReturningException();
		}
		return rv;
	}
}