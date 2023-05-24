package com.Project.MAWMConfigMover.Clients;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="viav")
public class Viav {
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLiveSites() {
		return liveSites;
	}
	public void setLiveSites(String liveSites) {
		this.liveSites = liveSites;
	}
	public Date getGolivedate() {
		return golivedate;
	}
	public void setGolivedate(Date golivedate) {
		this.golivedate = golivedate;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	@Id
	private String id;	
	private String longitude;	
	private String liveSites;
	private Date golivedate;
	private String latitude ;
	
	
	public Viav() {
		
	}
	public Viav(String id, String longitude, String liveSites, Date golivedate,String latitude) {
		super();
		this.id = id;
		this.liveSites = liveSites;
		this.longitude=longitude;
		this.latitude=latitude;
		this.golivedate=golivedate;
	}
	

}
