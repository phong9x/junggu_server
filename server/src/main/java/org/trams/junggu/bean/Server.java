/*
 * Created on 22 Feb 2016 ( Time 14:37:23 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.trams.junggu.bean;

import java.io.Serializable;

import javax.validation.constraints.*;

import java.util.Date;

public class Server implements Serializable {

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
    @Size( min = 1, max = 2000 )
    private String name;

    @NotNull
    @Size( min = 1, max = 2000 )
    private String url;

    @Size( max = 2000 )
    private String image;
    
    @Size( max = 2000 )
    private String map;
    
    @Size( max = 2000 )
    private String clientKey;

    @Size( max = 65535 )
    private String description;

    @NotNull
    private Date createDate;

    @NotNull
    private Date updateDate;

    @NotNull
    
    private Integer isDeleted;



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

    public void setUrl( String url ) {
        this.url = url;
    }
    public String getUrl() {
        return this.url;
    }

    public void setImage( String image ) {
        this.image = image;
    }
    public String getImage() {
        return this.image;
    }
    
    public void setMap( String map ) {
        this.map = map;
    }
    public String getMap() {
        return this.map;
    }
    
    public void setClientKey( String clientKey ) {
        this.clientKey = clientKey;
    }
    public String getClientKey() {
        return this.clientKey;
    }

    public void setDescription( String description ) {
        this.description = description;
    }
    public String getDescription() {
        return this.description;
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

    public void setIsDeleted( Integer isDeleted ) {
        this.isDeleted = isDeleted;
    }
    public Integer getIsDeleted() {
        return this.isDeleted;
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
        sb.append(url);
        sb.append("|");
        sb.append(image);
        sb.append("|");
        sb.append(map);
        sb.append("|");
        sb.append("clientKey");
        sb.append("|");
        sb.append(createDate);
        sb.append("|");
        sb.append(updateDate);
        sb.append("|");
        sb.append(isDeleted);
        return sb.toString(); 
    } 


}
