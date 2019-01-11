package com.commons.entity;

public class Life {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private  int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private  String name;

    public void init(){
        System.out.println("init...");
    }
}
