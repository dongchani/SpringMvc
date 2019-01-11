package com.commons.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {

  //private Integer id;
  //private String userCode;
 // @NotNull(message = "userName属性不能为空")
  private String userName;
 // @NotNull(message = "userPassword属性不能为空")
  private String userPassword;

  public Ponit getPonit() {
    return ponit;
  }

  public void setPonit(Ponit ponit) {
    this.ponit = ponit;
  }

  private Ponit ponit;
//  private Integer gender;
//  private Date birthday;
//  private String phone;
//  private String address;
//  private Integer userRole;
//  private Integer createdBy;
//  private Date creationDate;
//  private Integer modifyBy;
//  private Date modifyDate;


}
