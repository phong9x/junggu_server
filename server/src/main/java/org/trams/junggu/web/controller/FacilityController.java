/*
 * Created on 29 Oct 2015 ( Time 14:20:18 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.trams.junggu.web.controller;

import java.util.List;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
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
import org.trams.junggu.web.common.Login;
import org.trams.junggu.web.common.Message;
import org.trams.junggu.web.common.MessageType;
import org.trams.junggu.bean.jpa.FacilityEntity;
import org.trams.junggu.bean.jpa.FieldEntity;
//--- Entities
import org.trams.junggu.bean.Facility;

//--- Services 
import org.trams.junggu.business.service.FacilityService;


/**
 * Spring MVC controller for 'Facility' management.
 */
@Controller
@RequestMapping("/facility")
public class FacilityController extends AbstractController {

	//--- Variables names ( to be used in JSP with Expression Language )
	private static final String MAIN_ENTITY_NAME = "facility";
	private static final String MAIN_LIST_NAME = "list";

	private static final String TOTAL_PAGE   = "pages";

	private static final String CURRENT_PAGE   = "pageNumber";

	private static final String LIST_PAGES   = "listPages";

	private static final Integer PAGE_SIZE   = 15;

	private static String nav = "facility";

	//--- JSP pages names ( View name in the MVC model )
	private static final String JSP_FORM   = "facility/form";
	private static final String JSP_LIST   = "facility/list";
	private static final String JSP_PAGING   = "facility";
	private static final String JSP_DETAIL   = "facility/detail";
	private static final String JSP_LOGIN   = "login";

	//--- SAVE ACTION ( in the HTML form )
	private static final String SAVE_ACTION_CREATE   = "/facility/create";
	private static final String SAVE_ACTION_UPDATE   = "/facility/update";

	//--- Main entity service
	@Resource
    private FacilityService facilityService; // Injected by Spring
	//--- Other service(s)

	//--------------------------------------------------------------------------------------
	/**
	 * Default constructor
	 */
	public FacilityController() {
		super(FacilityController.class, MAIN_ENTITY_NAME );
		log("FacilityController created.");
	}
	@RequestMapping("/list")
	public String list(
			@RequestParam(value="page",defaultValue="1") Integer page, 
			@RequestParam(value="search",defaultValue="0") Integer search, 
			@RequestParam(value="key",defaultValue="") String key, 
			HttpSession session,
			Model model) {
		if(Login.checkLogin(session)=="0")
			return JSP_LOGIN;
		if(key==null){
			key="";
		}
		if(search==1){
			page=1;
		}
		Page<FacilityEntity> listPage=facilityService.listPaging("%"+key+"%",page, PAGE_SIZE);
		model.addAttribute("activePage", nav);
		model.addAttribute("key", key);
		model.addAttribute("pagination_navigator", "/facility/list");
		new Pager<FacilityEntity>(listPage).setSetting(model, "key="+key+"&amp;");	
		return JSP_LIST;
	}
}
