package com.sistem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class uyeler {
	private Long uid;
	private Long tckimlik;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	private String password;
	
	public uyeler() {
		
	}
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Long getTckimlik() {
		return tckimlik;
	}

	public void setTckimlik(Long tckimlik) {
		this.tckimlik = tckimlik;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
