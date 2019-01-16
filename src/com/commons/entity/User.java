package com.commons.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

@Data
public class User  {


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    //private Integer id;
  //private String userCode;
 // @NotNull(message = "userName属性不能为空")
  private String userName;

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

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
