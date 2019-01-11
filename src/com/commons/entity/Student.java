package com.commons.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.sql.Timestamp;
import java.util.Collection;

@Data
public class Student extends User {
  public Student(String username, String password, Collection <? extends GrantedAuthority> authorities) {
    super(username, password, authorities);
  }

  private int id;
  private String stuName;
  private String password;
  private Timestamp joinTime;
  private int clzId;


}
