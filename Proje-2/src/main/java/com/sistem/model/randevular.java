package com.sistem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class randevular {
	private Long ranid;
	private Long uyid;
	private Long dytid;
	private String date;
	private String durum;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getRanid() {
		return ranid;
	}
	public void setRanid(Long ranid) {
		this.ranid = ranid;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDurum() {
		return durum;
	}
	public void setDurum(String durum) {
		this.durum = durum;
	}
	
	
	
	
}
