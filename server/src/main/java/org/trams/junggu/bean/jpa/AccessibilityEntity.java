/*
 * Created on 11 Dec 2015 ( Time 20:38:34 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package org.trams.junggu.bean.jpa;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "accessibility"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="accessibility", catalog="junggutwo" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="AccessibilityEntity.countAll", query="SELECT COUNT(x) FROM AccessibilityEntity x" )
} )
public class AccessibilityEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="_id", nullable=false)
    private Integer    id           ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="NAME", nullable=false, length=255)
    private String     name         ;

    @Column(name="MOBILE_NAME", nullable=false, length=255)
    private String     mobileName   ;

    @Column(name="DESCRIPTION", nullable=false, length=255)
    private String     description  ;

    @Column(name="IMAGE", length=500)
    private String     image        ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CREATE_DATE")
    private Date       createDate   ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="UPDATE_DATE")
    private Date       updateDate   ;

    @Column(name="SELECTED")
    private Integer    selected     ;

    @Column(name="IS_DELETE")
    private Integer    isDelete     ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public AccessibilityEntity() {
		super();
    }
    
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
    //--- DATABASE MAPPING : NAME ( VARCHAR ) 
    public void setName( String name ) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    //--- DATABASE MAPPING : MOBILE_NAME ( VARCHAR ) 
    public void setMobileName( String mobileName ) {
        this.mobileName = mobileName;
    }
    public String getMobileName() {
        return this.mobileName;
    }

    //--- DATABASE MAPPING : DESCRIPTION ( VARCHAR ) 
    public void setDescription( String description ) {
        this.description = description;
    }
    public String getDescription() {
        return this.description;
    }

    //--- DATABASE MAPPING : IMAGE ( VARCHAR ) 
    public void setImage( String image ) {
        this.image = image;
    }
    public String getImage() {
        return this.image;
    }

    //--- DATABASE MAPPING : CREATE_DATE ( DATETIME ) 
    public void setCreateDate( Date createDate ) {
        this.createDate = createDate;
    }
    public Date getCreateDate() {
        return this.createDate;
    }

    //--- DATABASE MAPPING : UPDATE_DATE ( DATETIME ) 
    public void setUpdateDate( Date updateDate ) {
        this.updateDate = updateDate;
    }
    public Date getUpdateDate() {
        return this.updateDate;
    }

    //--- DATABASE MAPPING : SELECTED ( INT ) 
    public void setSelected( Integer selected ) {
        this.selected = selected;
    }
    public Integer getSelected() {
        return this.selected;
    }

    //--- DATABASE MAPPING : IS_DELETE ( INT ) 
    public void setIsDelete( Integer isDelete ) {
        this.isDelete = isDelete;
    }
    public Integer getIsDelete() {
        return this.isDelete;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(id);
        sb.append("]:"); 
        sb.append(name);
        sb.append("|");
        sb.append(mobileName);
        sb.append("|");
        sb.append(description);
        sb.append("|");
        sb.append(image);
        sb.append("|");
        sb.append(createDate);
        sb.append("|");
        sb.append(updateDate);
        sb.append("|");
        sb.append(selected);
        sb.append("|");
        sb.append(isDelete);
        return sb.toString(); 
    } 

}
