/*
 * Created on 6 Jan 2016 ( Time 15:18:51 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.trams.junggu.bean;

import java.io.Serializable;

import javax.validation.constraints.*;

import java.util.Date;

public class Store implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Integer id;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Size( max = 255 )
    private String name;

    @Size( max = 255 )
    private String tag;

    @Size( max = 255 )
    private String serviceHours;

    @Size( max = 255 )
    private String holiday;

    @Size( max = 65535 )
    private String buildingForm;

    @Size( max = 255 )
    private String floor;

    @Size( max = 65535 )
    private String facilityList;

    @Size( max = 255 )
    private String representative;

    @Size( max = 255 )
    private String phone;

    @Size( max = 255 )
    private String address;


    private Date monitoringDate;

    @Size( max = 255 )
    private String monitoringMan;

    @Size( max = 255 )
    private String monitoringManPhone;

    @Size( max = 255 )
    private String fieldList;

    @Size( max = 65535 )
    private String imageBaseAttach;

    @Size( max = 300 )
    private String storeName;

    @Size( max = 300 )
    private String storeExit;

    @Size( max = 300 )
    private String storeElevatorPositon;

    @Size( max = 65535 )
    private String distance;

    @Size( max = 65535 )
    private String buildingStructure;

    @Size( max = 65535 )
    private String parkingArea;

    @Size( max = 65535 )
    private String entranceStatus;

    @Size( max = 65535 )
    private String livingFacility;

    @Size( max = 65535 )
    private String space;

    @Size( max = 65535 )
    private String purposeNote;

    @Size( max = 65535 )
    private String roomOfRefector;

    @Size( max = 65535 )
    private String toiletteForDefector;

    @Size( max = 65535 )
    private String mainGoodService;

    @Size( max = 65535 )
    private String staffHelpDefector;

    @Size( max = 65535 )
    private String imageExtendAttach;

    @Size( max = 500 )
    private String grade;

    @Size( max = 65535 )
    private String accessibilityList;

    @Size( max = 100 )
    private String longitude;

    @Size( max = 100 )
    private String latitude;


    private Integer isDelete;


    private Date createDate;


    private Date updateDate;


    private Integer catId;


    private Integer userId;


    private Integer catid;

    @Size( max = 65535 )
    private String description;


    private Integer reported;



    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setId( Integer id ) {
        this.id = id ;
    }

    public Integer getId() {
        return this.id;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setName( String name ) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setTag( String tag ) {
        this.tag = tag;
    }
    public String getTag() {
        return this.tag;
    }

    public void setServiceHours( String serviceHours ) {
        this.serviceHours = serviceHours;
    }
    public String getServiceHours() {
        return this.serviceHours;
    }

    public void setHoliday( String holiday ) {
        this.holiday = holiday;
    }
    public String getHoliday() {
        return this.holiday;
    }

    public void setBuildingForm( String buildingForm ) {
        this.buildingForm = buildingForm;
    }
    public String getBuildingForm() {
        return this.buildingForm;
    }

    public void setFloor( String floor ) {
        this.floor = floor;
    }
    public String getFloor() {
        return this.floor;
    }

    public void setFacilityList( String facilityList ) {
        this.facilityList = facilityList;
    }
    public String getFacilityList() {
        return this.facilityList;
    }

    public void setRepresentative( String representative ) {
        this.representative = representative;
    }
    public String getRepresentative() {
        return this.representative;
    }

    public void setPhone( String phone ) {
        this.phone = phone;
    }
    public String getPhone() {
        return this.phone;
    }

    public void setAddress( String address ) {
        this.address = address;
    }
    public String getAddress() {
        return this.address;
    }

    public void setMonitoringDate( Date monitoringDate ) {
        this.monitoringDate = monitoringDate;
    }
    public Date getMonitoringDate() {
        return this.monitoringDate;
    }

    public void setMonitoringMan( String monitoringMan ) {
        this.monitoringMan = monitoringMan;
    }
    public String getMonitoringMan() {
        return this.monitoringMan;
    }

    public void setMonitoringManPhone( String monitoringManPhone ) {
        this.monitoringManPhone = monitoringManPhone;
    }
    public String getMonitoringManPhone() {
        return this.monitoringManPhone;
    }

    public void setFieldList( String fieldList ) {
        this.fieldList = fieldList;
    }
    public String getFieldList() {
        return this.fieldList;
    }

    public void setImageBaseAttach( String imageBaseAttach ) {
        this.imageBaseAttach = imageBaseAttach;
    }
    public String getImageBaseAttach() {
        return this.imageBaseAttach;
    }

    public void setStoreName( String storeName ) {
        this.storeName = storeName;
    }
    public String getStoreName() {
        return this.storeName;
    }

    public void setStoreExit( String storeExit ) {
        this.storeExit = storeExit;
    }
    public String getStoreExit() {
        return this.storeExit;
    }

    public void setStoreElevatorPositon( String storeElevatorPositon ) {
        this.storeElevatorPositon = storeElevatorPositon;
    }
    public String getStoreElevatorPositon() {
        return this.storeElevatorPositon;
    }

    public void setDistance( String distance ) {
        this.distance = distance;
    }
    public String getDistance() {
        return this.distance;
    }

    public void setBuildingStructure( String buildingStructure ) {
        this.buildingStructure = buildingStructure;
    }
    public String getBuildingStructure() {
        return this.buildingStructure;
    }

    public void setParkingArea( String parkingArea ) {
        this.parkingArea = parkingArea;
    }
    public String getParkingArea() {
        return this.parkingArea;
    }

    public void setEntranceStatus( String entranceStatus ) {
        this.entranceStatus = entranceStatus;
    }
    public String getEntranceStatus() {
        return this.entranceStatus;
    }

    public void setLivingFacility( String livingFacility ) {
        this.livingFacility = livingFacility;
    }
    public String getLivingFacility() {
        return this.livingFacility;
    }

    public void setSpace( String space ) {
        this.space = space;
    }
    public String getSpace() {
        return this.space;
    }

    public void setPurposeNote( String purposeNote ) {
        this.purposeNote = purposeNote;
    }
    public String getPurposeNote() {
        return this.purposeNote;
    }

    public void setRoomOfRefector( String roomOfRefector ) {
        this.roomOfRefector = roomOfRefector;
    }
    public String getRoomOfRefector() {
        return this.roomOfRefector;
    }

    public void setToiletteForDefector( String toiletteForDefector ) {
        this.toiletteForDefector = toiletteForDefector;
    }
    public String getToiletteForDefector() {
        return this.toiletteForDefector;
    }

    public void setMainGoodService( String mainGoodService ) {
        this.mainGoodService = mainGoodService;
    }
    public String getMainGoodService() {
        return this.mainGoodService;
    }

    public void setStaffHelpDefector( String staffHelpDefector ) {
        this.staffHelpDefector = staffHelpDefector;
    }
    public String getStaffHelpDefector() {
        return this.staffHelpDefector;
    }

    public void setImageExtendAttach( String imageExtendAttach ) {
        this.imageExtendAttach = imageExtendAttach;
    }
    public String getImageExtendAttach() {
        return this.imageExtendAttach;
    }

    public void setGrade( String grade ) {
        this.grade = grade;
    }
    public String getGrade() {
        return this.grade;
    }

    public void setAccessibilityList( String accessibilityList ) {
        this.accessibilityList = accessibilityList;
    }
    public String getAccessibilityList() {
        return this.accessibilityList;
    }

    public void setLongitude( String longitude ) {
        this.longitude = longitude;
    }
    public String getLongitude() {
        return this.longitude;
    }

    public void setLatitude( String latitude ) {
        this.latitude = latitude;
    }
    public String getLatitude() {
        return this.latitude;
    }

    public void setIsDelete( Integer isDelete ) {
        this.isDelete = isDelete;
    }
    public Integer getIsDelete() {
        return this.isDelete;
    }

    public void setCreateDate( Date createDate ) {
        this.createDate = createDate;
    }
    public Date getCreateDate() {
        return this.createDate;
    }

    public void setUpdateDate( Date updateDate ) {
        this.updateDate = updateDate;
    }
    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setCatId( Integer catId ) {
        this.catId = catId;
    }
    public Integer getCatId() {
        return this.catId;
    }

    public void setUserId( Integer userId ) {
        this.userId = userId;
    }
    public Integer getUserId() {
        return this.userId;
    }

    public void setCatid( Integer catid ) {
        this.catid = catid;
    }
    public Integer getCatid() {
        return this.catid;
    }

    public void setDescription( String description ) {
        this.description = description;
    }
    public String getDescription() {
        return this.description;
    }

    public void setReported( Integer reported ) {
        this.reported = reported;
    }
    public Integer getReported() {
        return this.reported;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 
        public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(id);
        sb.append("|");
        sb.append(name);
        sb.append("|");
        sb.append(tag);
        sb.append("|");
        sb.append(serviceHours);
        sb.append("|");
        sb.append(holiday);
        // attribute 'buildingForm' not usable (type = String Long Text)
        sb.append("|");
        sb.append(floor);
        // attribute 'facilityList' not usable (type = String Long Text)
        sb.append("|");
        sb.append(representative);
        sb.append("|");
        sb.append(phone);
        sb.append("|");
        sb.append(address);
        sb.append("|");
        sb.append(monitoringDate);
        sb.append("|");
        sb.append(monitoringMan);
        sb.append("|");
        sb.append(monitoringManPhone);
        sb.append("|");
        sb.append(fieldList);
        // attribute 'imageBaseAttach' not usable (type = String Long Text)
        sb.append("|");
        sb.append(storeName);
        sb.append("|");
        sb.append(storeExit);
        sb.append("|");
        sb.append(storeElevatorPositon);
        // attribute 'distance' not usable (type = String Long Text)
        // attribute 'buildingStructure' not usable (type = String Long Text)
        // attribute 'parkingArea' not usable (type = String Long Text)
        // attribute 'entranceStatus' not usable (type = String Long Text)
        // attribute 'livingFacility' not usable (type = String Long Text)
        // attribute 'space' not usable (type = String Long Text)
        // attribute 'purposeNote' not usable (type = String Long Text)
        // attribute 'roomOfRefector' not usable (type = String Long Text)
        // attribute 'toiletteForDefector' not usable (type = String Long Text)
        // attribute 'mainGoodService' not usable (type = String Long Text)
        // attribute 'staffHelpDefector' not usable (type = String Long Text)
        // attribute 'imageExtendAttach' not usable (type = String Long Text)
        sb.append("|");
        sb.append(grade);
        // attribute 'accessibilityList' not usable (type = String Long Text)
        sb.append("|");
        sb.append(longitude);
        sb.append("|");
        sb.append(latitude);
        sb.append("|");
        sb.append(isDelete);
        sb.append("|");
        sb.append(createDate);
        sb.append("|");
        sb.append(updateDate);
        sb.append("|");
        sb.append(catId);
        sb.append("|");
        sb.append(userId);
        sb.append("|");
        sb.append(catid);
        // attribute 'description' not usable (type = String Long Text)
        sb.append("|");
        sb.append(reported);
        return sb.toString(); 
    } 


}
