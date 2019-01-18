package com.app.service;

import com.app.dao.TsyUserMapper;
import com.commons.entity.TsyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService1 implements UserDetailsService {
    @Autowired
   private TsyUserMapper tsyUserMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TsyUser tsyUser =tsyUserMapper.selectUsername1(username);
        if (tsyUser == null){
             throw new UsernameNotFoundException("用户不存在");
        }
        return tsyUser;
    }
}
