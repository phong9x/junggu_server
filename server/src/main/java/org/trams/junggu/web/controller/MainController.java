/*
 * Created on 29 Oct 2015 ( Time 14:20:20 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.trams.junggu.web.controller;

import java.util.List;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.groups.Default;

//import org.junit.runner.Request;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//--- Common classes
import org.trams.junggu.web.common.AbstractController;
import org.trams.junggu.web.common.FormMode;
import org.trams.junggu.web.common.Pager;
import org.trams.junggu.web.common.Utils;
import org.trams.junggu.web.common.Login;
import org.trams.junggu.web.common.Message;
import org.trams.junggu.web.common.MessageType;
import org.trams.junggu.bean.jpa.UserEntity;

//--- Entities
import org.trams.junggu.bean.User;

//--- Services 
import org.trams.junggu.business.service.UserService;
import org.trams.junggu.rest.item.UserItem;

/**
 * Spring MVC controller for 'User' management.
 */
@Controller
@RequestMapping("")
public class MainController extends AbstractController {

	// --- Variables names ( to be used in JSP with Expression Language )
	private static final String MAIN_ENTITY_NAME = "user";
	private static final String MAIN_LIST_NAME = "list";

	private static final String TOTAL_PAGE = "pages";

	private static final String CURRENT_PAGE = "pageNumber";

	private static final String LIST_PAGES = "listPages";

	private static final Integer PAGE_SIZE = 15;

	private static String nav = "main";

	// --- JSP pages names ( View name in the MVC model )

	private static final String JSP_LOGIN = "login";
	private static final String JSP_LOGOUT = "logout";
	private static final String JSP_MAIN = "/";
	// --- SAVE ACTION ( in the HTML form )
	private static final String SAVE_ACTION_CREATE = "/user/create";
	private static final String SAVE_ACTION_UPDATE = "/user/update";

	// --- Main entity service
	@Resource
	private UserService userService; // Injected by Spring
	// --- Other service(s)

	// --------------------------------------------------------------------------------------
	/**
	 * Default constructor
	 */
	public MainController() {
		super(MainController.class, MAIN_ENTITY_NAME);
		log("UserController created.");
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam(value = "username", defaultValue = "") String username,
			@RequestParam(value = "password", defaultValue = "") String password,
			@RequestParam(value = "remember", defaultValue = "") String remember, HttpSession session,
			HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			if (username != null && password != null && username != "" && password != "") {
				String md5 = Utils.getMD5(password);
				UserEntity user = userService.login(username, md5, 1);

				if (user != null) {
					UserItem userItem = new UserItem();
					userItem.parserEntity(user);
					Login.save(userItem, session);
					if (remember != null && remember.equalsIgnoreCase("on")) {
						Cookie name = new Cookie("username", username);
						Cookie pass = new Cookie("password", password);
						// Set expiry date after 24 Hrs for both the cookies.
						name.setMaxAge(60 * 60 * 24);
						pass.setMaxAge(60 * 60 * 24);
						// Add both the cookies in the response header.
						response.addCookie(name);
						response.addCookie(pass);
						model.addAttribute("user", user);
					}
					return "redirect:/store/list";

				} else {
					model.addAttribute("err", "nouser");
					model.addAttribute("username_history", username);
					model.addAttribute("activePage", nav);
					return JSP_LOGIN;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
			model.addAttribute("err", "err");
			return JSP_LOGIN;
		}
		return JSP_LOGIN;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login3(HttpSession session, HttpServletRequest servletRequest,Model model) {
		if (Login.checkLogin(session) == "0") {
			Cookie[] cookies = servletRequest.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("username")) {
							model.addAttribute("username",cookie.getValue());
					}
					if (cookie.getName().equals("password")) {
						model.addAttribute("password",cookie.getValue());
					}
				}
			}
			return JSP_LOGIN;

		} else {

			return "redirect:/store/list";
		}

	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("login");
		return "redirect:/";
	}

	@RequestMapping(value = "/index")
	public String index(HttpSession session) {
		return "redirect:/login";
	}

	@RequestMapping("")
	public String login2(HttpSession session) {
		if (Login.checkLogin(session) == "0") {
			return "redirect:/login";
		} else {
			return "redirect:/store/list";
		}

	}

	@RequestMapping("/")
	public String login4(HttpSession session) {
		if (Login.checkLogin(session) == "0") {
			return "redirect:/login";
		} else {
			return "redirect:/store/list";
		}
	}

}
