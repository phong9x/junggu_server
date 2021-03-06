/*
 * Created on 29 Oct 2015 ( Time 14:20:19 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.trams.junggu.rest.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.trams.junggu.bean.Store;
import org.trams.junggu.bean.User;
import org.trams.junggu.bean.jpa.CommentEntity;
import org.trams.junggu.business.service.CommentService;
import org.trams.junggu.business.service.StoreService;
import org.trams.junggu.business.service.UserService;
import org.trams.junggu.rest.common.Message;
import org.trams.junggu.rest.common.ReturnValue;
import org.trams.junggu.rest.item.UserItem;
import org.trams.junggu.web.common.Login;
import org.trams.junggu.web.common.Utils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
/**
 * Spring MVC controller for 'Store' management.
 */
@Controller
public class StoreRestController {

	@Resource
	private StoreService storeService;
	@Resource
    private CommentService commentService;
	@Resource
	private UserService userService;
//	@RequestMapping( value="/items/store",
//			method = RequestMethod.GET,
//			produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseStatus(HttpStatus.OK)
//	@ResponseBody
//	public List<StoreListItem> findAllAsListItems() {
//		List<Store> list = storeService.findAll();
//		List<StoreListItem> items = new LinkedList<StoreListItem>();
//		for ( Store store : list ) {
//			items.add(new StoreListItem( store ) );
//		}
//		return items;
//	}
	
	@RequestMapping( value="/items/store",
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
			
			List<Store> list = storeService.findAllUpdate(dateUpdate);
			if(list != null && list.size()>0){
				List<org.trams.junggu.rest.sqlite.bean.Store> storeSqlite = new ArrayList<>();
				for (Store store : list) {
						org.trams.junggu.rest.sqlite.bean.Store storeItem = new org.trams.junggu.rest.sqlite.bean.Store();
						storeItem.setOtherInfo(Utils.getOtherInfomation(store));
						storeItem.parserBean(store);
						storeSqlite.add(storeItem);
				}
				rv.ReturningObject(storeSqlite);
			} else{
				rv.ReturningString(Message.LIST_UPDATE_FAIL, Message.LIST_UPDATE_ZERO_CODE);
			}
			return rv;
		} catch(Exception e)
		{
			System.out.println(e);
			rv.ReturningException();
			return rv;
		}
	}
	@RequestMapping( value="/items/store/user_comment",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ReturnValue findAllUserCommtentStore(@RequestBody String json) {
		ReturnValue rv =  new ReturnValue();
		try {
			JSONParser parser = new JSONParser();
			JSONObject jsonObj = (JSONObject) parser.parse(json);
			Integer userId = org.trams.junggu.web.common.Utils.parseInt(jsonObj.get("user_id"));
			
			List<CommentEntity> list = commentService.findAllByUser(userId);

			if(list != null && list.size()>0){
				List<Integer> storeSqlite = new ArrayList<>();
				for (CommentEntity comment : list) {
					if(comment.getIsDelete() != 1){
						storeSqlite.add(comment.getStoreId());
					}
				}
				rv.ReturningObject(storeSqlite);
			} else{
				rv.ReturningString(Message.LIST_UPDATE_FAIL, Message.LIST_UPDATE_ZERO_CODE);
			}
			return rv;
		} catch(Exception e)
		{
			rv.ReturningException();
			return rv;
		}
	}
	
	@RequestMapping( value="/items/store/google_map",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ReturnValue google_map(
			@RequestParam(value = "address", defaultValue = "") String fullAddress,
			HttpSession session
			) {
		ReturnValue rv =  new ReturnValue();
		try {
			fullAddress = fullAddress.replace(",", "+");
			fullAddress = fullAddress.replace(" ", "+");
			fullAddress = fullAddress.replace(" ", "");
		    String[] latitude= Utils.getLatLongPositions(fullAddress);
		    rv.ReturningValue(latitude[0], latitude[1], 0);
			return rv;
		} catch(Exception e)
		{
			rv.ReturningException();
			System.out.println(e);
			return rv;
		}
		
	}
	
	
	@RequestMapping( value="/items/store/scrap_status",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ReturnValue scrapStatus(@RequestBody String json,HttpSession session) {
		ReturnValue rv =  new ReturnValue();
		try {
			JSONParser parser = new JSONParser();
			JSONObject jsonObj = (JSONObject) parser.parse(json);
			Integer storeId = org.trams.junggu.web.common.Utils.parseInt(jsonObj.get("store_id"));
			
			UserItem user = Login.getUserLogined(session);
			if(user != null){
				
				Map<String,Object> listScrap = Utils.convertJsonArrayToMap(user.getScrap());
				
				if(listScrap.containsKey(storeId.toString())){
					//unscrap
					listScrap.remove(storeId.toString());
				}else{
					//scrap
					listScrap.put(storeId.toString(), storeId);
				}
				
				user.setScrap(Utils.convertMapToJson(listScrap));
				User u = user.getBean();
				User update = userService.update(u);
				if(update != null){
					UserItem userItem = new UserItem();
					userItem.parserBean(update);
					userItem.setSessionId("JSESSIONID="+session.getId());
					rv.ReturningObject(user);
				}else{
					
					UserItem userX = Login.getUserLogined(session);
					rv.ReturningObject(userX);
				}
			}else{
				rv.ReturningString(Message.LOGIN_REQUIRE_MESS, Message.LOGIN_REQUIRE_CODE);
			}
			
			return rv;
		} catch(Exception e)
		{
			rv.ReturningException();
			return rv;
		}
	}
}
