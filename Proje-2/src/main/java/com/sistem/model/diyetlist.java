package com.sistem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class diyetlist {
	private Long dlistid;
	private Long uyid;
	private Long dytid;
	private String info;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getDlistid() {
		return dlistid;
	}
	public void setDlistid(Long dlistid) {
		this.dlistid = dlistid;
	}
	public Long getUyid() {
		return uyid;
	}
	public void setUyid(Long uyid) {
		this.uyid = uyid;
	}
	public Long getDytid() {
		return dytid;
	}
	public void setDytid(Long dytid) {
		this.dytid = dytid;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	
	
	
}
