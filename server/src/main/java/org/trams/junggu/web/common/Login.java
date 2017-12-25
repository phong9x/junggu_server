package org.trams.junggu.web.common;

import javax.servlet.http.HttpSession;

//import org.hsqldb.rights.User;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.trams.junggu.bean.jpa.UserEntity;
import org.trams.junggu.business.service.UserService;
import org.trams.junggu.rest.item.UserItem;

public class Login {

	String password;
	String username;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String username) {
		this.username = username;
	}

	public static String checkLogin(HttpSession session) {
		 
		if (session.getAttribute("login") != null && session.getAttribute("login")!="") {
			return "1";
		} 
			return "0";
	}
	public static void  save(UserItem user,HttpSession session) {
		session.setAttribute("login", user);
	}
	public static UserItem getUserLogined(HttpSession session) {
		 
		if (session.getAttribute("login") != null) {
			UserItem entity = (UserItem) session.getAttribute("login");
			return entity;
		} else{
			return null;
		}
			
	}
	public static String checkLogin() {
		 
		
			return "0";
	}
	
	
	
	
	
}
