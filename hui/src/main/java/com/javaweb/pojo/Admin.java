package com.javaweb.pojo;

import javax.servlet.http.HttpServlet;
import java.io.Serializable;
import java.util.Date;

public class Admin implements Serializable{
    private static final long serialVersionUID = -4727003480344940759L;
    private Integer ID;
    private String name;
    private Integer password;
    private Date createDate;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Admin() {
    }

    public Admin(Integer ID, String name, Integer password, Date createDate) {
        this.ID = ID;
        this.name = name;
        this.password = password;
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", password=" + password +
                ", createDate=" + createDate +
                '}';
    }
}
