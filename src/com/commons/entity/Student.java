package com.commons.entity;

import java.util.Date;

public class Student {
    private Integer id;

    private String stuname;

    private String password;

    private Date jointime;

    private Integer clzId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname == null ? null : stuname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getJointime() {
        return jointime;
    }

    public void setJointime(Date jointime) {
        this.jointime = jointime;
    }

    public Integer getClzId() {
        return clzId;
    }

    public void setClzId(Integer clzId) {
        this.clzId = clzId;
    }
}