/*
 * Created on 9 Nov 2015 ( Time 15:37:49 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.trams.junggu.web.controller;

import java.util.List;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//--- Common classes
import org.trams.junggu.web.common.AbstractController;
import org.trams.junggu.web.common.FileUtils;
import org.trams.junggu.web.common.FormMode;
import org.trams.junggu.web.common.Pager;
import org.trams.junggu.web.common.Login;
import org.trams.junggu.web.common.Message;
import org.trams.junggu.web.common.MessageType;
import org.trams.junggu.bean.jpa.IntroEntity;
import org.trams.junggu.bean.jpa.ReportEntity;
import org.trams.junggu.bean.Info;
//--- Entities
import org.trams.junggu.bean.Intro;
import org.trams.junggu.business.service.InfoService;
//--- Services 
import org.trams.junggu.business.service.IntroService;


/**
 * Spring MVC controller for 'Intro' management.
 */
@Controller
@RequestMapping("")
public class IntroController extends AbstractController {

	//--- Variables names ( to be used in JSP with Expression Language )
	private static final String MAIN_ENTITY_NAME = "intro";
	private static final String MAIN_LIST_NAME = "list";

	private static final String TOTAL_PAGE   = "pages";

	private static final String CURRENT_PAGE   = "pageNumber";

	private static final String LIST_PAGES   = "listPages";

	private static final Integer PAGE_SIZE   = 15;

	private static String nav = "intro";

	//--- JSP pages names ( View name in the MVC model )
	private static final String JSP_FORM   = "intro/form";
	private static final String JSP_LIST   = "intro/list";
	private static final String JSP_PAGING   = "intro";
	private static final String JSP_DETAIL   = "intro";
	private static final String JSP_LOGIN   = "login";

	//--- SAVE ACTION ( in the HTML form )
	private static final String SAVE_ACTION_CREATE   = "/intro/create";
	private static final String SAVE_ACTION_UPDATE   = "/intro/update";

	//--- Main entity service
	@Resource
    private IntroService introService; // Injected by Spring
	@Resource
    private InfoService infoService; // Injected by Spring
	//--- Other service(s)
	@Autowired 
	ServletContext servletContext;
	//--------------------------------------------------------------------------------------
	/**
	 * Default constructor
	 */
	public IntroController() {
		super(IntroController.class, MAIN_ENTITY_NAME );
		log("IntroController created.");
	}
	
	@RequestMapping(value="/intro", method=RequestMethod.GET)
	public String infoGet(
			
			Model model,HttpSession session) {
		if(Login.checkLogin(session)=="0")
			return JSP_LOGIN;
		List<Intro> list= introService.findAll();
		model.addAttribute("list",list);
		Info info=infoService.findById(1);
		model.addAttribute("info",info);
		
		if(list.size()>0){
		model.addAttribute("intro",list.get(0));
		}
		model.addAttribute("activePage", nav);
		return JSP_DETAIL;
	}
	
	@RequestMapping(value="/intro", method=RequestMethod.POST)
	public String infoPost(
			@RequestParam(value="address1",defaultValue="") String address1,
			@RequestParam(value="address2",defaultValue="") String address2,
			@RequestParam(value="contact_number",defaultValue="") String contact_number,
			@RequestParam(value="fax",defaultValue="") String fax,
			@RequestParam(value="email",defaultValue="") String email,
			@RequestParam(value="link",defaultValue="") String link,
			@RequestParam(value="description",defaultValue="") String[] description,
			@RequestParam(value="id_intro",defaultValue="") Integer[] id,
			@RequestParam(value="file") MultipartFile[] file,
			Model model,HttpSession session) {
		if(Login.checkLogin(session)=="0")
			return JSP_LOGIN;
		//save info 
		Info info=infoService.findById(1);
		
			//update
			info.setAddress1(address1);
			info.setAddress2(address2);
			info.setContactNumber(contact_number);
			info.setFax(fax);
			info.setEmail(email);
			info.setLink(link);
			info.setUpdateDate(new Date());
			infoService.update(info);
		
		List<Intro> list=new ArrayList<>();
		try {
		for(int i=0;i<description.length;i++){
			if(description[i]!=null && description[i]!=""){
					Intro intro=null;
					if(id[i]!=null && id[i]>0){
						 	intro = introService.findById(id[i]);
						 	intro.setTitle("Image");
						 	intro.setDescription(description[i]);
						 	if(file[i].getSize()>0){
						 		String path=FileUtils.saveFileOrigin(file[i], servletContext);
								intro.setImageUrl(path);
						 	}
							intro.setUpdateDate(new Date());
							intro.setCreateDate(new Date());
							intro.setId(null);
							intro.setIsDelete(0);
							list.add(intro);
					}else{
						if(file[i].getSize()>0){
							intro= new Intro();
							intro.setTitle("Image");
							intro.setDescription(description[i]);
							String path=FileUtils.saveFileOrigin(file[i], servletContext);
							intro.setImageUrl(path);
							intro.setCreateDate(new Date());
							intro.setUpdateDate(new Date());
							intro.setIsDelete(0);
							list.add(intro);
						}
					}
				
				}
		}
		} catch (Exception e) {
			System.out.println(e);
		}
		introService.deleteAll();
		for (Intro intro : list) {
			introService.create(intro);
		}
		list= introService.findAll();
		
		model.addAttribute("activePage", nav);
		model.addAttribute("list",list);
		model.addAttribute("info",info);
		if(list.size()>0){
			model.addAttribute("intro",list.get(0));
			}
		return JSP_DETAIL;
	}
	
	
	@RequestMapping(value="/mobile_intro", method=RequestMethod.GET)
	public String mobile_intro(
			Model model) {
		List<Intro> list= introService.findAll();
		model.addAttribute("list",list);
		model.addAttribute("activePage", nav);
		return "mobile_intro";
	}
}
