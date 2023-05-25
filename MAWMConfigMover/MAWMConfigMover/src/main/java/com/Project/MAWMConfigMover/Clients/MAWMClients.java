package com.Project.MAWMConfigMover.Clients;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "mawmclients")
public class MAWMClients {
    @Id
    public String facility;
    public String clientcode;
    public String org;
    public String longitude;
    public String latitude;
    public Date golivedate;

    public String getClientCode() {
        return clientcode;
    }

    public void setClientCode(String clientCode) {
        this.clientcode = clientCode;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Date getGoLiveDate() {
        return golivedate;
    }

    public void setGoLiveDate(Date goLiveDate) {
        this.golivedate = goLiveDate;
    }

    public MAWMClients(String clientCode, String org, String facility, String longitude, String latitude, Date goLiveDate) {
        this.clientcode = clientCode;
        this.org = org;
        this.facility = facility;
        this.longitude = longitude;
        this.latitude = latitude;
        this.golivedate = goLiveDate;
    }

    public MAWMClients() {
    }
}
