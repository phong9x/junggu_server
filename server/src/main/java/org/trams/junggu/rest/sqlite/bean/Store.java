package org.trams.junggu.rest.sqlite.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.trams.junggu.bean.jpa.StoreEntity;
import org.trams.junggu.web.common.DataUtils;
import org.trams.junggu.web.common.Utils;
import org.trams.junggu.web.item.response.ImageExtend;

public class Store implements Sqlite<StoreEntity, org.trams.junggu.bean.Store>{
	    private Integer id;
	    private String name;
	    private String tag;
	    private String serviceHours;
	    private String holiday;
	    private String buildingForm;
	    private String floor;
	    private String facilityList;
	    private String representative;
	    private String phone;
	    private String address;
	    private Date monitoringDate;
	    private String monitoringMan;
	    private String monitoringManPhone;
	    private String fieldList;
	    private String imageBaseAttach;
	    
	    private String imageExtendAttach;
	    private String grade;
	    private String accessibilityList;
	    private String longitude;
	    private String latitude;
	    private Date createDate;
	    private Date updateDate;
	    private Integer userId;
	    private Integer catId;
	    private String otherInfo = "";
	    private Integer isDelete;
	    private String description;
	    private Integer countExtendTab;
	    private Integer countComment;
	    
		@Override
		public void parserBean(org.trams.junggu.bean.Store b) {
		   this.id = b.getId();
		   this.name = b.getName();
		   this.tag = b.getTag();
		   this.serviceHours = b.getServiceHours();
		   this.holiday = b.getHoliday();
		   this.buildingForm = DataUtils.getArrays(b.getBuildingForm(), "building_form");
		   this.floor = b.getFloor();
		   this.facilityList = DataUtils.getArrays(b.getFacilityList(),"facility_list");
		   this.representative = b.getRepresentative();
		   this.phone = b.getPhone();
		   this.address = b.getAddress();
		   this.monitoringDate = b.getMonitoringDate();
		   this.monitoringMan = DataUtils.getArrays(b.getMonitoringMan(),"monitoring_man");
		   this.monitoringManPhone = DataUtils.getArrays(b.getMonitoringManPhone(),"monitoring_man_phone");
		   this.fieldList = DataUtils.getArrays(b.getFieldList(),"field_list");
		   this.imageBaseAttach = DataUtils.getArrays(b.getImageBaseAttach(),"image_base_attach");
		   this.imageExtendAttach = DataUtils.getArrays(b.getImageExtendAttach(),"image_extend_attach");
		   this.grade = b.getGrade();
		   this.accessibilityList = DataUtils.getArrays(b.getAccessibilityList(),"accessibility_list");
		   this.longitude = b.getLongitude();
		   this.latitude = b.getLatitude();
		   this.createDate = b.getCreateDate();
		   this.updateDate = b.getUpdateDate();
		   this.userId = b.getUserId();
		   this.catId = b.getCatId();
		   this.isDelete = b.getIsDelete();
		   this.description = b.getDescription();
		   List<ImageExtend> imageExtend=new ArrayList<>();
			imageExtend=Utils.ConvertJsonTo_ListExtendImage(b.getImageExtendAttach());
		   this.countExtendTab=imageExtend.size();
		   JSONObject jsonObject = (JSONObject) JSONValue.parse(b.getGrade());
		   this.countComment=Utils.parseInt(jsonObject.get("total_rate"));
		}
		@Override
		public void parserEntity(StoreEntity b) {
			   this.id = b.getId();
			   this.name = b.getName();
			   this.tag = b.getTag();
			   this.serviceHours = b.getServiceHours();
			   this.holiday = b.getHoliday();
			   this.buildingForm = DataUtils.getArrays(b.getBuildingForm(), "building_form");
			   this.floor = b.getFloor();
			   this.facilityList = DataUtils.getArrays(b.getFacilityList(),"facility_list");
			   this.representative = b.getRepresentative();
			   this.phone = b.getPhone();
			   this.address = b.getAddress();
			   this.monitoringDate = b.getMonitoringDate();
			   this.monitoringMan = DataUtils.getArrays(b.getMonitoringMan(),"monitoring_man");
			   this.monitoringManPhone = DataUtils.getArrays(b.getMonitoringManPhone(),"monitoring_man_phone");
			   this.fieldList = DataUtils.getArrays(b.getFieldList(),"field_list");
			   this.imageBaseAttach = DataUtils.getArrays(b.getImageBaseAttach(),"image_base_attach");
			   this.imageExtendAttach = DataUtils.getArrays(b.getImageExtendAttach(),"image_extend_attach");
			   this.grade = b.getGrade();
			   this.accessibilityList = DataUtils.getArrays(b.getAccessibilityList(),"accessibility_list");
			   this.longitude = b.getLongitude();
			   this.latitude = b.getLatitude();
			   this.createDate = b.getCreateDate();
			   this.updateDate = b.getUpdateDate();
			   this.userId = b.getUserId();
			   this.catId = b.getCatId();
			   this.isDelete = b.getIsDelete();
			   this.description = b.getDescription();
		}
 
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Integer getCatId() {
			return catId;
		}
		public void setCatId(Integer catId) {
			this.catId = catId;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getTag() {
			return tag;
		}
		public void setTag(String tag) {
			this.tag = tag;
		}
		public String getServiceHours() {
			return serviceHours;
		}
		public void setServiceHours(String serviceHours) {
			this.serviceHours = serviceHours;
		}
		public String getHoliday() {
			return holiday;
		}
		public void setHoliday(String holiday) {
			this.holiday = holiday;
		}
		public String getBuildingForm() {
			return buildingForm;
		}
		public void setBuildingForm(String buildingForm) {
			this.buildingForm = buildingForm;
		}
		public String getFloor() {
			return floor;
		}
		public void setFloor(String floor) {
			this.floor = floor;
		}
		public String getFacilityList() {
			return facilityList;
		}
		public void setFacilityList(String facilityList) {
			this.facilityList = facilityList;
		}
		public String getRepresentative() {
			return representative;
		}
		public void setRepresentative(String representative) {
			this.representative = representative;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		
		public String getAddress() {
			return address;
		}
		public void setAddress(String address1) {
			this.address = address1;
		}
	
		public Date getMonitoringDate() {
			return monitoringDate;
		}
		public void setMonitoringDate(Date monitoringDate) {
			this.monitoringDate = monitoringDate;
		}
		public String getMonitoringMan() {
			return monitoringMan;
		}
		public void setMonitoringMan(String monitoringMan) {
			this.monitoringMan = monitoringMan;
		}
		public String getMonitoringManPhone() {
			return monitoringManPhone;
		}
		public void setMonitoringManPhone(String monitoringManPhone) {
			this.monitoringManPhone = monitoringManPhone;
		}
		public String getFieldList() {
			return fieldList;
		}
		public void setFieldList(String fieldList) {
			this.fieldList = fieldList;
		}
		public String getImageBaseAttach() {
			return imageBaseAttach;
		}
		public void setImageBaseAttach(String imageBaseAttach) {
			this.imageBaseAttach = imageBaseAttach;
		}
		public String getImageExtendAttach() {
			return imageExtendAttach;
		}
		public void setImageExtendAttach(String imageExtendAttach) {
			this.imageExtendAttach = imageExtendAttach;
		}
		public String getGrade() {
			return grade;
		}
		public void setGrade(String grade) {
			this.grade = grade;
		}
		public String getAccessibilityList() {
			return accessibilityList;
		}
		public void setAccessibilityList(String accessibilityList) {
			this.accessibilityList = accessibilityList;
		}
		public String getLongitude() {
			return longitude;
		}
		public void setLongitude(String longitude) {
			this.longitude = longitude;
		}
		public String getLatitude() {
			return latitude;
		}
		public void setLatitude(String latitude) {
			this.latitude = latitude;
		}
		public Date getCreateDate() {
			return createDate;
		}
		public void setCreateDate(Date createDate) {
			this.createDate = createDate;
		}
		public Date getUpdateDate() {
			return updateDate;
		}
		public void setUpdateDate(Date updateDate) {
			this.updateDate = updateDate;
		}
		public Integer getUserId() {
			return userId;
		}
		public void setUserId(Integer userId) {
			this.userId = userId;
		}
		public String getOtherInfo() {
			return otherInfo;
		}
		public void setOtherInfo(String otherInfo) {
			this.otherInfo = otherInfo;
		}
		public Integer getIsDelete() {
			return isDelete;
		}
		public void setIsDelete(Integer isDelete) {
			this.isDelete = isDelete;
		}
		public Integer getCountExtendTab() {
			return countExtendTab;
		}
		public void setCountExtendTab(Integer countExtendTab) {
			this.countExtendTab = countExtendTab;
		}
		public Integer getCountComment() {
			return countComment;
		}
		public void setCountComment(Integer countComment) {
			this.countComment = countComment;
		}
		
}

