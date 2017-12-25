/*
 * Created on 10 Nov 2015 ( Time 09:59:46 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.trams.junggu.rest.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.trams.junggu.bean.Comment;
import org.trams.junggu.bean.Store;
import org.trams.junggu.bean.jpa.CommentEntity;
import org.trams.junggu.bean.jpa.UserEntity;
import org.trams.junggu.business.service.CommentService;
import org.trams.junggu.business.service.StoreService;
import org.trams.junggu.rest.common.Message;
import org.trams.junggu.rest.common.ReturnValue;
import org.trams.junggu.rest.item.UserItem;
import org.trams.junggu.web.common.Login;
import org.trams.junggu.web.common.Utils;
import org.trams.junggu.web.listitem.CommentListItem;

/**
 * Spring MVC controller for 'Comment' management.
 */
@Controller
public class CommentRestController {

	@Resource
	private CommentService commentService;
	
	@Resource
	private StoreService storeService;
	 
	
	@RequestMapping( value="/api/comment/{id}/{page}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ReturnValue findOne(@PathVariable("id") Integer id,@PathVariable("page") Integer page) {
		ReturnValue rv = new ReturnValue();
		try {
			Map<String,Object> listData = new HashMap<>();
				Page<CommentEntity> commentList = commentService.findAllByStore(id, page, 10);
				if(commentList != null){
					//set Store Object id null
					Integer grade = 0;
					for (CommentEntity commentEntity : commentList.getContent()) {
						grade += commentEntity.getGrade();
					}
					listData.put("total", commentList.getTotalElements());
					listData.put("grade", grade);
					listData.put("list_comment", commentList.getContent());
					
					rv.ReturningObject(listData);
				}
		} catch (Exception e) {
			 rv.ReturningException();
		}
		return rv;
	}
	
	@RequestMapping( value="/api/comment",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ReturnValue create(@RequestBody Comment comment,HttpSession session) {
		ReturnValue rv = new ReturnValue();
		Comment result = new Comment();
		Store store = storeService.findById(comment.getStoreId());
		List<Integer[]> list = commentService.getSumGradeByStoreId(comment.getStoreId());
		try {
			UserItem user = Login.getUserLogined(session);
			if(user != null){
				CommentEntity checkExitsComment = commentService.checkExitsComment(user.getId(), comment.getStoreId());
				if(checkExitsComment!=null){
					rv.ReturningString(Message.USER_COMMENT_ERROR, Message.COMMENT_ERROR_CODE);
					return rv;
				}else {
					Integer commentCount  = 0;
					Integer sumGrade = 0;
					try {
						Object[] data = list.get(0);
						if(data != null){
							commentCount = Utils.parseInt(data[0]);
							sumGrade = Utils.parseInt(data[1]);
						}	
					} catch (Exception e) {
					}
					comment.setId(0);
					comment.setUserId(user.getId());
					comment.setUserUsername(user.getUsername());
					comment.setCreateDate(new Date());
					comment.setUpdateDate(new Date());
					comment.setIsDelete(0);
					
					commentCount +=1;
					sumGrade +=comment.getGrade();
					
					JSONObject obj = new JSONObject();
					try {
						obj.put("grade", sumGrade);
						obj.put("total_rate", commentCount);
					} catch (Exception e) {
					}
					store.setGrade(obj.toJSONString());
					store.setUpdateDate(new Date());
					result = commentService.create(comment);
					if(result!=null){
						rv.ReturningValue(result, Message.USER_COMMENT_SUCCESS, Message.SUCCESS_CODE);
						storeService.update(store);
					}
					return rv;
				}

			}else{
				rv.ReturningString(Message.LOGIN_REQUIRE_MESS, Message.LOGIN_REQUIRE_CODE);
			}
		} catch (Exception e) {
			 rv.ReturningException();
			 return rv;
		}
		
		return rv;
	}



	@RequestMapping( value="/api/comment/delete/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ReturnValue delete(@PathVariable("id") Integer id) {
		ReturnValue rv = new ReturnValue();
		try {
			
			Comment commentObj = commentService.findById(id);
			commentService.delete(id);
			
			List<Integer[]> list = commentService.getSumGradeByStoreId(commentObj.getStoreId());
			Integer commentCount  = 0;
			Integer sumGrade = 0;
			try {
				Object[] data = list.get(0);
				if(data != null){
					commentCount = Utils.parseInt(data[0]);
					sumGrade = Utils.parseInt(data[1]);
				}	
			} catch (Exception e) {
			}
			
			Store store = storeService.findById(commentObj.getStoreId());
			
			store.setGrade("{\"grade\":\""+sumGrade+"\",\"total_rate\":\""+commentCount+"\"}");
			store.setUpdateDate(new Date());
			storeService.update(store);
			
			rv.ReturningValue(1, Message.SUCCES, Message.SUCCESS_CODE);
		} catch (Exception e) {
		}
		return rv;
	}
}