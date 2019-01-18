package com.commons.entity;

import java.util.ArrayList;
import java.util.List;

public class TsyMenu {
    private Integer menuId;

    private String menuName;

    private String menuUrl;

    private Integer parentId;

    private Integer ordered;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    public Integer getParentId() {
            return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getOrdered() {
        return ordered;
    }

    public void setOrdered(Integer ordered) {
        this.ordered = ordered;
    }

    public List<TsyMenu> getMenus() {
        return menus;
    }

    public void setMenus(List<TsyMenu> menus) {
        this.menus = menus;
    }

    public List<TsyMenu> getChildren() {
        return children;
    }

    public void setChildren(List<TsyMenu> children) {
        this.children = children;
    }

    private List<TsyMenu> menus = new ArrayList<>();
    private List<TsyMenu> children = new ArrayList<>();

    public TsyMenu getParent() {
        return parent;
    }

    public void setParent(TsyMenu parent) {
        this.parent = parent;
    }

    private TsyMenu parent;
}