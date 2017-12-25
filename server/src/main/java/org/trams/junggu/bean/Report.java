/*
 * Created on 11 Dec 2015 ( Time 20:38:28 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.trams.junggu.bean;

import java.io.Serializable;

import javax.validation.constraints.*;

import java.util.Date;

public class Report implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @NotNull
    private Integer id;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @NotNull
    @Size( min = 1, max = 200 )
    private String phoneNumber;

    @NotNull
    @Size( min = 1, max = 1000 )
    private String details;

    @NotNull
    private Integer userId;

    @NotNull
    private Integer storeId;


    private Date createDate;


    private Date updateDate;


    private Integer isDelete;



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
    public void setPhoneNumber( String phoneNumber ) {
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setDetails( String details ) {
        this.details = details;
    }
    public String getDetails() {
        return this.details;
    }

    public void setUserId( Integer userId ) {
        this.userId = userId;
    }
    public Integer getUserId() {
        return this.userId;
    }

    public void setStoreId( Integer storeId ) {
        this.storeId = storeId;
    }
    public Integer getStoreId() {
        return this.storeId;
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

    public void setIsDelete( Integer isDelete ) {
        this.isDelete = isDelete;
    }
    public Integer getIsDelete() {
        return this.isDelete;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 
        public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(id);
        sb.append("|");
        sb.append(phoneNumber);
        sb.append("|");
        sb.append(details);
        sb.append("|");
        sb.append(userId);
        sb.append("|");
        sb.append(storeId);
        sb.append("|");
        sb.append(createDate);
        sb.append("|");
        sb.append(updateDate);
        sb.append("|");
        sb.append(isDelete);
        return sb.toString(); 
    } 


}