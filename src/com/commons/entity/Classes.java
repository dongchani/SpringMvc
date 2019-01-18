package com.commons.entity;

public class Classes {
    private Integer id;

    private String clzName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClzName() {
        return clzName;
    }

    public void setClzName(String clzName) {
        this.clzName = clzName == null ? null : clzName.trim();
    }
}