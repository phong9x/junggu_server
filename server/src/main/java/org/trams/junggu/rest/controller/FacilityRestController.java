/*
 * Created on 29 Oct 2015 ( Time 14:20:18 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.trams.junggu.rest.controller;

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
import org.trams.junggu.bean.Accessibility;
import org.trams.junggu.bean.Facility;
import org.trams.junggu.business.service.FacilityService;
import org.trams.junggu.rest.common.Message;
import org.trams.junggu.rest.common.ReturnValue;
import org.trams.junggu.web.listitem.FacilityListItem;

/**
 * Spring MVC controller for 'Facility' management.
 */
@Controller
public class FacilityRestController {

	@Resource
	private FacilityService facilityService;
	
//	@RequestMapping( value="/items/facility",
//			method = RequestMethod.GET,
//			produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.OK)
//	@ResponseBody
//	public List<FacilityListItem> findAllAsListItems() {
//		List<Facility> list = facilityService.findAll();
//		List<FacilityListItem> items = new LinkedList<FacilityListItem>();
//		for ( Facility facility : list ) {
//			items.add(new FacilityListItem( facility ) );
//		}
//		return items;
//	}
	@RequestMapping( value="/items/facility",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ReturnValue findAllAsListItems(@RequestBody String json) {
		
		ReturnValue rv =  new ReturnValue();
		try {
			JSONParser parser = new JSONParser();
			JSONObject jsonObj = (JSONObject) parser.parse(json);
			Long updateDate = org.trams.junggu.web.common.Utils.parseLong(jsonObj.get("updateDate"));
			
			Date dateUpdate = new Date(updateDate);
			
			List<Facility> list = facilityService.findAllUpdate(dateUpdate);
			if(list.size()>0)
				rv.ReturningObject(list);
			else
				rv.ReturningString(Message.LIST_UPDATE_FAIL, Message.LIST_UPDATE_ZERO_CODE);
			return rv;
		} catch (Exception e) {
			rv.ReturningException();
			return rv;
		}
	}
//	
//	@RequestMapping( value="/facility",
//			method = RequestMethod.GET,
//			produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.OK)
//	@ResponseBody
//	public List<Facility> findAll() {
//		return facilityService.findAll();
//	}
//
//	@RequestMapping( value="/facility/{id}",
//			method = RequestMethod.GET,
//			produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.OK)
//	@ResponseBody
//	public Facility findOne(@PathVariable("id") Integer id) {
//		return facilityService.findById(id);
//	}
//	
//	@RequestMapping( value="/facility",
//			method = RequestMethod.POST,
//			produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.OK)
//	@ResponseBody
//	public Facility create(@RequestBody Facility facility) {
//		return facilityService.create(facility);
//	}
//
//	@RequestMapping( value="/facility/{id}",
//			method = RequestMethod.PUT,
//			produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.OK)
//	@ResponseBody
//	public Facility update(@PathVariable("id") Integer id, @RequestBody Facility facility) {
//		return facilityService.update(facility);
//	}
//
//	@RequestMapping( value="/facility/{id}",
//			method = RequestMethod.DELETE,
//			produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.OK)
//	@ResponseBody
//	public void delete(@PathVariable("id") Integer id) {
//		facilityService.delete(id);
//	}
//	
}
