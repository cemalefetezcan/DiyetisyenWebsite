package com.sistem.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class diyetisyen {
	private Long dyid;
	private Long tckimlik;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	private String password;
	private String cv;
	private String uniname;
	private String graduateyear;
	private String sesfee;
	
	
	public diyetisyen() {
		
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getDyid() {
		return dyid;
	}


	public void setDyid(Long dyid) {
		this.dyid = dyid;
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


	public String getCv() {
		return cv;
	}


	public void setCv(String cv) {
		this.cv = cv;
	}


	public String getUniname() {
		return uniname;
	}


	public void setUniname(String uniname) {
		this.uniname = uniname;
	}


	public String getGraduateyear() {
		return graduateyear;
	}


	public void setGraduateyear(String graduateyear) {
		this.graduateyear = graduateyear;
	}


	public String getSesfee() {
		return sesfee;
	}


	public void setSesfee(String sesfee) {
		this.sesfee = sesfee;
	}

	
	
	
}
