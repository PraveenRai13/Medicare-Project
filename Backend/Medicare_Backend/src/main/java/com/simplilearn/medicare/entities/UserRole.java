package com.simplilearn.medicare.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserRole {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private int userRoleId;
@ManyToOne(fetch = FetchType.EAGER)
	private User user;
@ManyToOne
private Role role;
public UserRole() {
	// TODO Auto-generated constructor stub
}
public UserRole(int userRoleId, User user, Role role) {
	super();
	this.userRoleId = userRoleId;
	this.user = user;
	this.role = role;
}
public int getUserRoleId() {
	return userRoleId;
}
public void setUserRoleId(int userRoleId) {
	this.userRoleId = userRoleId;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Role getRole() {
	return role;
}
public void setRole(Role role) {
	this.role = role;
}
}
