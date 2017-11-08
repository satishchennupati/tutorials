package org.baeldung.model;

import org.springframework.beans.factory.annotation.Autowired;

public class UserEvaluation {
	
	private String uid;
	private String name;
	private UserAddressEvaluation userAddress;
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public UserAddressEvaluation getUserAddress() {
		return this.userAddress;
	}
	
	//dependency injection by setting method
	@Autowired
	 public void setUserAddress(UserAddressEvaluation userAddress) {
	    this.userAddress = userAddress;
	 }

}
