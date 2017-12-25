/*
 * Created on 29 Oct 2015 ( Time 14:20:20 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.trams.junggu.web.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//--- Common classes
import org.trams.junggu.web.common.AbstractController;
import org.trams.junggu.web.common.FileUtils;
import org.trams.junggu.web.common.Utils;
import org.trams.junggu.bean.Accessibility;
import org.trams.junggu.bean.Category;
import org.trams.junggu.bean.Facility;
import org.trams.junggu.bean.Field;
import org.trams.junggu.bean.Notice;
import org.trams.junggu.bean.Store;
import org.trams.junggu.bean.User;
import org.trams.junggu.bean.Version;
//--- Entities
import org.trams.junggu.business.service.AccessibilityService;
import org.trams.junggu.business.service.CategoryService;
import org.trams.junggu.business.service.CommentService;
import org.trams.junggu.business.service.FacilityService;
import org.trams.junggu.business.service.FieldService;
import org.trams.junggu.business.service.NoticeService;
import org.trams.junggu.business.service.StoreService;
import org.trams.junggu.business.service.UserService;
//--- Services 
import org.trams.junggu.business.service.VersionService;

/**
 * Spring MVC controller for 'Version' management.
 */
@Controller
@RequestMapping("/version")
public class VersionController extends AbstractController {

	// --- Variables names ( to be used in JSP with Expression Language )
	private static final String MAIN_ENTITY_NAME = "version";

	// --- JSP pages names ( View name in the MVC model )
	private static final String JSP_LOGIN = "login";

	// --- Main entity service
	@Resource
	private VersionService versionService; // Injected by Spring
	@Resource
	private NoticeService noticeService; // Injected by Spring
	@Resource
	private CategoryService categoryService; // Injected by Spring
	@Resource
	private StoreService storeService; // Injected by Spring
	@Resource
	private UserService userService; // Injected by Spring
	@Resource
	private CommentService commentService; // Injected by Spring
	@Resource
	private FacilityService facilityService; // Injected by Spring
	@Resource
	private AccessibilityService accessbilityService; // Injected by Spring
	@Resource
	private FieldService fieldService; // Injected by Spring
	@Autowired
	ServletContext servletContext = null;

	// --------------------------------------------------------------------------------------
	/**
	 * Default constructor
	 */
	public VersionController() {
		super(VersionController.class, MAIN_ENTITY_NAME);
		log("VersionController created.");
	}

	@RequestMapping(value = "/generator") // GET or POST
	public String generator(RedirectAttributes redirectAttributes) throws SQLException, ClassNotFoundException {

		log("Action 'generator'");
		Class.forName("org.sqlite.JDBC");
		String path = servletContext.getRealPath("/db");

		Connection connection = (Connection) DriverManager.getConnection("jdbc:sqlite:" + path + "/database.sqlite");
		try {

			// insert user
			//List<User> users = userService.findAll();
			PreparedStatement statement_user = (PreparedStatement) connection.prepareStatement("DELETE FROM USER");
			statement_user.executeUpdate();
//			for (User obj : users) {
//				statement_user = (PreparedStatement) connection.prepareStatement(
//						"INSERT INTO USER (_id,USERNAME,PASSWORD,NICKNAME,FULLNAME,ROLE,SEX,PHONE,EMAIL,AGE,SCRAP,CREATE_DATE,UPDATE_DATE)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
//				statement_user.setInt(1, obj.getId());
//				statement_user.setString(2, obj.getUsername());
//				statement_user.setString(3, obj.getPassword());
//				statement_user.setString(4, obj.getNickname());
//				statement_user.setString(5, obj.getFullname());
//				statement_user.setInt(6, Utils.parseInt(obj.getRole()));
//				statement_user.setString(7, obj.getSex());
//				statement_user.setString(8, obj.getPhone());
//				statement_user.setString(9, obj.getEmail());
//				statement_user.setInt(10, Utils.parseInt(obj.getAge()));
//				statement_user.setString(11, obj.getScrap());
//				statement_user.setLong(12, Utils.convertFromTime(obj.getCreateDate()));
//				statement_user.setLong(13, Utils.convertFromTime(obj.getUpdateDate()));
//				statement_user.executeUpdate();
//			}
			// insert Store
			List<Store> stores = storeService.findAll();
			if (stores != null && stores.size() > 0) {
				List<org.trams.junggu.rest.sqlite.bean.Store> storeSqlite = new ArrayList<>();
				for (Store store : stores) {
					if (store.getIsDelete() != 1) {
						org.trams.junggu.rest.sqlite.bean.Store storeItem = new org.trams.junggu.rest.sqlite.bean.Store();
						storeItem.parserBean(store);
						storeSqlite.add(storeItem);
					}
				}
				
				PreparedStatement statement_category = (PreparedStatement) connection.prepareStatement("DELETE FROM STORE");
				statement_category.executeUpdate();
				
				for (org.trams.junggu.rest.sqlite.bean.Store obj : storeSqlite) {
					statement_category = (PreparedStatement) connection.prepareStatement(
							"INSERT INTO STORE (_id,NAME,TAG,SERVICE_HOURS,HOLIDAY,BUILDING_FORM,FLOOR,FACILITY_LIST,REPRESENTATIVE,PHONE,ADDRESS,MONITORING_DATE,MONITORING_MAN,MONITORING_MAN_PHONE,FIELD_LIST,IMAGE_BASE_ATTACH,IMAGE_EXTEND_ATTACH,GRADE,ACCESSIBILITY_LIST,LONGITUDE,LATITUDE,CREATE_DATE,UPDATE_DATE,CAT_ID,USER_ID,OTHER_INFO,IS_DELETE)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
					statement_category.setInt(1, obj.getId());
					statement_category.setString(2, obj.getName());
					statement_category.setString(3, obj.getTag());
					statement_category.setString(4, obj.getServiceHours());
					statement_category.setString(5, obj.getHoliday());
					statement_category.setString(6, obj.getBuildingForm());
					statement_category.setString(7, obj.getFloor());
					statement_category.setString(8, obj.getFacilityList());
					statement_category.setString(9, obj.getRepresentative());
					statement_category.setString(10, obj.getPhone());
					statement_category.setString(11, obj.getAddress());
					statement_category.setLong(12, Utils.convertFromTime(obj.getMonitoringDate()));
					statement_category.setString(13, obj.getMonitoringMan());
					statement_category.setString(14, obj.getMonitoringManPhone());
					statement_category.setString(15, obj.getFieldList());
					statement_category.setString(16, obj.getImageBaseAttach());
					statement_category.setString(17, obj.getImageExtendAttach());
					statement_category.setString(18, obj.getGrade());
					statement_category.setString(19, obj.getAccessibilityList());
					statement_category.setString(20, obj.getLongitude());
					statement_category.setString(21, obj.getLatitude());
					statement_category.setLong(22, Utils.convertFromTime(obj.getCreateDate()));
					statement_category.setLong(23, Utils.convertFromTime(obj.getUpdateDate()));
					statement_category.setInt(24, obj.getCatId());
					statement_category.setInt(25, obj.getUserId());
					statement_category.setString(26, obj.getOtherInfo());
					statement_category.setInt(27, obj.getIsDelete());
					statement_category.executeUpdate();
				}
			}

			// insert Accessbility
			List<Accessibility> accessibility = accessbilityService.findAll();
			PreparedStatement statement_accessbility = (PreparedStatement) connection
					.prepareStatement("DELETE FROM ACCESSIBILITY");
			statement_accessbility.executeUpdate();
			
			for (Accessibility obj : accessibility) {
				statement_accessbility = (PreparedStatement) connection.prepareStatement(
						"INSERT INTO ACCESSIBILITY (_id,NAME,DESCRIPTION,CREATE_DATE,UPDATE_DATE,SELECTED)VALUES(?,?,?,?,?,?)");
				statement_accessbility.setInt(1, obj.getId());
				statement_accessbility.setString(2, obj.getMobileName());
				statement_accessbility.setString(3, obj.getDescription());
				statement_accessbility.setLong(4, Utils.convertFromTime(obj.getCreateDate()));
				statement_accessbility.setLong(5, Utils.convertFromTime(obj.getUpdateDate()));
				statement_accessbility.setInt(6, obj.getSelected());
				statement_accessbility.executeUpdate();
			}

			// insert Category
			List<Category> categories = categoryService.findAll();
			PreparedStatement statement_category = (PreparedStatement) connection
					.prepareStatement("DELETE FROM CATEGORY");
			statement_category.executeUpdate();
			
			for (Category obj : categories) {

				statement_category = (PreparedStatement) connection.prepareStatement(
						"INSERT INTO CATEGORY (_id,CAT_NAME,PARENT_ID,CREATE_DATE,UPDATE_DATE)VALUES(?,?,?,?,?)");
				statement_category.setInt(1, obj.getId());
				statement_category.setString(2, obj.getCatName());
				statement_category.setInt(3, obj.getParentId());
				statement_category.setLong(4, Utils.convertFromTime(obj.getCreateDate()));
				statement_category.setLong(5, Utils.convertFromTime(obj.getUpdateDate()));
				statement_category.executeUpdate();
			}
			// insert Facility
			List<Facility> facilities = facilityService.findAll();
			
			PreparedStatement statement_facility = (PreparedStatement) connection
					.prepareStatement("DELETE FROM FACILITY");
			statement_facility.executeUpdate();
			
			for (Facility obj : facilities) {

				statement_facility = (PreparedStatement) connection.prepareStatement(
						"INSERT INTO FACILITY (_id,NAME,DESCRIPTION,CREATE_DATE,UPDATE_DATE)VALUES(?,?,?,?,?)");
				statement_facility.setInt(1, obj.getId());
				statement_facility.setString(2, obj.getName());
				statement_facility.setString(3, obj.getDescription());
				statement_facility.setLong(4, Utils.convertFromTime(obj.getCreateDate()));
				statement_facility.setLong(5, Utils.convertFromTime(obj.getUpdateDate()));
				statement_facility.executeUpdate();
			}
			// insert Notice
			List<Notice> notices = noticeService.findAll();
			PreparedStatement statement_notice = (PreparedStatement) connection
					.prepareStatement("DELETE FROM NOTICE");
			statement_notice.executeUpdate();
			
			for (Notice obj : notices) {
				if (obj.getIsDelete() != 1) {
					statement_notice = (PreparedStatement) connection.prepareStatement(
							"INSERT INTO NOTICE (_id,TITLE,CONTENT,NOTICE_TYPE,CREATE_DATE,UPDATE_DATE,USER_ID)VALUES(?,?,?,?,?,?,?)");
					statement_notice.setInt(1, obj.getId());
					statement_notice.setString(2, obj.getTitle());
					statement_notice.setString(3, obj.getContent());
					statement_notice.setInt(4, obj.getNoticeType());
					statement_notice.setLong(5, Utils.convertFromTime(obj.getCreateDate()));
					statement_notice.setLong(6, Utils.convertFromTime(obj.getCreateDate()));
					statement_notice.setInt(7, obj.getUserId());
					statement_notice.executeUpdate();
				}
			}
			// insert Field
			List<Field> field = fieldService.findAll();
			PreparedStatement statement_field = (PreparedStatement) connection
					.prepareStatement("DELETE FROM FIELD");
			statement_field.executeUpdate();
			
			for (Field obj : field) {
				statement_field = (PreparedStatement) connection.prepareStatement(
							"INSERT INTO FIELD (_id,NAME,DESCRIPTION,CREATE_DATE,UPDATE_DATE)VALUES(?,?,?,?,?)");
				statement_field.setInt(1, obj.getId());
				statement_field.setString(2, obj.getName());
				statement_field.setString(3, obj.getDescription());
				statement_field.setLong(4, Utils.convertFromTime(obj.getCreateDate()));
				statement_field.setLong(5, Utils.convertFromTime(obj.getUpdateDate()));
				statement_field.executeUpdate();
			}

			Version ver = new Version();
			ver.setId(0);
			ver.setName("Junggu SQLite");
			ver.setStatus("1");
			ver.setEtc("1");
			ver.setUpdateDate(new Date());
			ver.setCreateDate(new Date());

			Version verNew = versionService.create(ver);

			if (verNew != null) {
				try {
					File file = new File(path + "/db.zip");
					file.delete();
				} catch (Exception x) {
				    System.err.println(x);
				}

				FileUtils.zip(path + "/database.sqlite", path + "/db.zip");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "version/list";
	}

}
