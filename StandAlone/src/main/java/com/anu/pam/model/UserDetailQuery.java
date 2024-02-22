package com.anu.pam.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



@Entity
@NamedQuery(name="UserDetailQuery.byId", query="from UserDetailQuery where userId=?")
@NamedNativeQuery(name="UserDetailQuery.byName",query="select * from USER_DETAIL_QUERY where userName = ?",resultClass=UserDetailQuery.class)
@Table(name="USER_DETAIL_QUERY")
public class UserDetailQuery {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
