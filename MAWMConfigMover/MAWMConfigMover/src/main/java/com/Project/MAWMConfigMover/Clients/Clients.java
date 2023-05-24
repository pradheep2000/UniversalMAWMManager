package com.Project.MAWMConfigMover.Clients;

import javax.persistence.*;

@Entity
@Table(name = "wmclients")
public class Clients {
    @Id
    @Column(name = "sl_no")
    private int SlNo;

    @Column(name = "client_code")
    private String clientCode;

    @Column(name = "clientdescription")
    private String clientdescription;

    public Clients() {
    }

    public Clients(int slNo, String clientCode, String clientdescription) {
        this.SlNo = slNo;
        this.clientCode = clientCode;
        this.clientdescription = clientdescription;
    }

    public int getSlNo() {
        return SlNo;
    }

    public void setSlNo(int slNo) {
        SlNo = slNo;
    }

    public String getClientdescription() {
        return clientdescription;
    }

    public void setClientdescription(String clientdescription) {
        this.clientdescription = clientdescription;
    }

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    @Override
    public String toString() {
        return "Clients{" + "SlNo=" + SlNo + ", clientCode='" + clientCode + '\'' + ", clientdescription='" + clientdescription + '\'' + '}';
    }
}
