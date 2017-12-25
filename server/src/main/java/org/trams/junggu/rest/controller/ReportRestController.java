/*
 * Created on 10 Nov 2015 ( Time 09:59:46 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.trams.junggu.rest.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.trams.junggu.bean.Report;
import org.trams.junggu.bean.Store;
import org.trams.junggu.bean.jpa.ReportEntity;
import org.trams.junggu.bean.jpa.UserEntity;
import org.trams.junggu.business.service.ReportService;
import org.trams.junggu.business.service.StoreService;
import org.trams.junggu.business.service.UserService;
import org.trams.junggu.common.mail.Mail;
import org.trams.junggu.rest.common.Message;
import org.trams.junggu.rest.common.ReturnValue;
import org.trams.junggu.rest.item.UserItem;
import org.trams.junggu.web.common.Login;
import org.trams.junggu.web.common.Utils;
import org.trams.junggu.common.mail.*;

/**
 * Spring MVC controller for 'Comment' management.
 */
@Controller
public class ReportRestController {

	@Resource
	private ReportService reportService;
	
	@Resource
	private StoreService storeService;
	
	@Resource
	private UserService userService;
	 
	@RequestMapping( value="/api/report",
			//method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ReturnValue create(@RequestBody Report report) {
		ReturnValue rv = new ReturnValue();
		try {
			//UserItem user = Login.getUserLogined(session);
		//report.getUserId();
		//userService.findById(report.getUserId());
		
	
				List<ReportEntity> reportItem = reportService.listByStore(report.getStoreId());
				
				if(reportItem!=null && reportItem.size() > 0){
					Store store = storeService.findById(report.getStoreId());
					if(store != null){
						
						//Report createReport = reportService.create(report);
						//String content = "휴대폰번호:"+report.getPhoneNumber();
						//content += "\n신고내용:"+report.getDetails();
						
						try {
					    if(org.trams.junggu.common.mail.Utils.sendMail("jgcil@hanmail.net",store.getName(), report.getPhoneNumber(), report.getDetails()))
							System.out.println("email sended-case1");
						} catch (Exception e) {
							
						}
						rv.ReturningString(Message.USER_REPORT_SUCCESS, Message.SUCCESS_CODE);
						return rv;
					}
				}else {
					Store store = storeService.findById(report.getStoreId());
					if(store != null){
						report.setUserId(0);
						report.setId(0);
						report.setIsDelete(0);
						report.setCreateDate(new Date());
						report.setUpdateDate(new Date());
						Report createReport = reportService.create(report);
						try {
						if(org.trams.junggu.common.mail.Utils.sendMail("jgcil@hanmail.net",store.getName(), report.getPhoneNumber(), report.getDetails()))
							System.out.println("email sended-case2");
						} catch (Exception e) {
													
												}
						if(createReport != null){ 
							rv.ReturningValue(createReport, Message.USER_REPORT_SUCCESS, Message.SUCCESS_CODE);
						}else{
							rv.ReturningString(Message.USER_REPORT_ERROR, Message.REPORT_ERROR_CODE);
						}
						
						return rv;
					}
				}
		} catch (Exception e) {
			 rv.ReturningException();
			 return rv;
		}
		
		return rv;
	}
	
	@RequestMapping( value="/api/check_report",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ReturnValue checkExistReport(@RequestBody String json
			) {
		ReturnValue rv = new ReturnValue();
		try {
			JSONParser parser = new JSONParser();
			JSONObject jsonObj = (JSONObject) parser.parse(json);
			Integer storeId = Utils.parseInt(jsonObj.get("storeId"));
			//Integer userId = Utils.parseInt(jsonObj.get("userId"));
			List<ReportEntity> reportItem = reportService.listByStore(storeId);
			JSONObject obj = new JSONObject();
				if(reportItem!=null && reportItem.size()>0){
					obj.put("is_report", 1);
					rv.ReturningValue(obj,Message.STORE_REPORT_EXIST,Message.SUCCESS_CODE);
					return rv;
				}else {
					obj.put("is_report", 0);
					rv.ReturningValue(obj,Message.STORE_REPORT_NOT_EXIST,Message.SUCCESS_CODE);
					return rv;
				}

		} catch (Exception e) {
			System.out.println(e);
			 rv.ReturningException();
			 return rv;
		}
	}
}