package com.app.dao;


import com.commons.entity.User;
import sun.security.util.Password;

import java.util.List;

public interface UsersDao {
    public User print(String UserName,String Password);
    public  int insert(User user);
    int user();
    int upDateById(User user);

}
