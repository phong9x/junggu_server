package org.trams.junggu.rest.item;

import java.util.Date;

import org.trams.junggu.bean.User;
import org.trams.junggu.bean.jpa.UserEntity;

public class UserItem implements RestItem<User,UserEntity>{
    private Integer id;
    private String username; 
    private String password;
    private String nickname;
    private String fullname;
    private Integer role;
    private String sex;
    private String phone;
    private String email;
    private Integer age;
    private String sessionId;
    private Integer isDelete;
    private String scrap;
    private Date createDate;
    private Date updateDate;
    
	@Override
	public void parserBean(User b) {
		   this.id = b.getId();
		   this.username = b.getUsername();
		   this.password = b.getPassword();
		   this.nickname = b.getNickname();
		   this.fullname = b.getFullname();
		   this.role = b.getRole();
		   this.sex = b.getSex();
		   this.phone = b.getPhone();
		   this.email = b.getEmail();
		   this.age = b.getAge();
		   this.isDelete = b.getIsDelete();
		   this.scrap = b.getScrap();
		   this.createDate = b.getCreateDate();
		   this.updateDate = b.getUpdateDate();
	}
	@Override
	public void parserEntity(UserEntity b) {
		   this.id = b.getId();
		   this.username = b.getUsername();
		   this.password = b.getPassword();
		   this.nickname = b.getNickname();
		   this.fullname = b.getFullname();
		   this.role = b.getRole();
		   this.sex = b.getSex();
		   this.phone = b.getPhone();
		   this.email = b.getEmail();
		   this.age = b.getAge();
		   this.isDelete = b.getIsDelete();
		   this.scrap = b.getScrap();
		   this.createDate = b.getCreateDate();
		   this.updateDate = b.getUpdateDate();
	}
	
	public User getBean(){
		User b = new User();
		b.setId(this.id);
		b.setUsername(this.username);
		b.setPassword(this.password);
		b.setNickname(this.nickname);
		b.setFullname(this.fullname);
		b.setRole(this.role);
		b.setSex(this.sex);
		b.setPhone(this.phone);
		b.setEmail(this.email);
		b.setAge(this.age);
		b.setIsDelete(this.isDelete);
		b.setScrap(this.scrap);
		b.setCreateDate(this.createDate);
		b.setUpdateDate(this.updateDate);
		return b;
	}
    
	public String getScrap() {
		return scrap;
	}
	public void setScrap(String scrap) {
		this.scrap = scrap;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public Integer getRole() {
		return role;
	}
	public void setRole(Integer role) {
		this.role = role;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
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
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	
}
