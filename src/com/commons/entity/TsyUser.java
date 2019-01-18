package com.commons.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TsyUser  implements UserDetails {
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<>();
        for (TsyRole role :this.getRoles()){
            list.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return list;

    }

    /**
     * 获取父级根目录
     * @return
     */
    public List<TsyMenu> getHierarchicalMenu() {
        List<TsyMenu> mainMenu = new ArrayList<>();
        List<TsyMenu> allMenus = getMenus();
        for (TsyMenu menu : allMenus) {
            if (menu.getParentId().intValue() == 0 ){
                mainMenu.add(menu);
                foreach(menus, menu, menu.getMenuId());

            }
        }
        return mainMenu;
    }

    /**
     * 获取父级的子级目录
     * @param menus
     * @param root
     * @param id
     */
    private void foreach(List<TsyMenu> menus, TsyMenu root, Integer id) {
        for (TsyMenu tSysMenu : menus) {
            if (tSysMenu.getParentId().intValue() == id.intValue()) {
                foreach(menus, tSysMenu, tSysMenu.getMenuId());
                root.getChildren().add(tSysMenu);
            }
        }
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.status.intValue()==1;
    }

    @Override
    public boolean isAccountNonLocked() {
        return  this.status.intValue()==1;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return  this.status.intValue()==1;
    }

    @Override
    public boolean isEnabled() {
        return  this.status.intValue()==1;
    }

    private Integer id;

    private String username;

    private String password;

    private String phone;

    private String email;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<TsyRole> getRoles() {
        return roles;
    }

    public void setRoles(List<TsyRole> roles) {
        this.roles = roles;
    }

    private List<TsyRole> roles = new ArrayList<>();

    public List<TsyMenu> getMenus() {
        return menus;
    }

    public void setMenus(List<TsyMenu> menus) {
        this.menus = menus;
    }

    private List<TsyMenu> menus = new ArrayList<>();
}