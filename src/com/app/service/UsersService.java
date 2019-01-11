package com.app.service;

import com.commons.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UsersService implements UserDetailsService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User .UserBuilder users= User.withDefaultPasswordEncoder();
        Map<String,Object> map = jdbcTemplate.queryForMap("select t.clz_name,t1.stuName,t1.password,t1.joinTime from student t1 inner  join classes t on t.id=t1.clz_id where stuName=?",s);
        Timestamp joinTime=null;
        if (map!=null&& map.size()>0){
            String stuName=(String) map.get("stuName");
            String password=(String) map.get("password");
            joinTime=(Timestamp) map.get("joinTime");
            String clzName=(String) map.get("clz_name");
            users.password(password);
            users.username(stuName);
            SimpleGrantedAuthority authority =new SimpleGrantedAuthority(clzName);
            List<GrantedAuthority> list= new ArrayList <>();
            list.add(authority);
            users.authorities(list);
        }
         UserDetails userDetails =users.build();
        Student student = new Student(userDetails.getUsername(),userDetails.getPassword(),userDetails.getAuthorities());
        //        UserDetails userDetails = User.withDefaultPasswordEncoder().
       student.setJoinTime(joinTime);
        return student;
    }
}
