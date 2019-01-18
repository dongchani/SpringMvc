package com.app.service;

import com.app.dao.TsyMenuMapper;
import com.app.dao.TsyUserMapper;
import com.commons.entity.TsyMenu;
import com.commons.entity.TsyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.ws.Action;
import java.util.List;

@Service
public class MenuSerice {
    @Autowired
    TsyMenuMapper tsyMenuMapper;
    public TsyMenu getbyid(Integer id){
       TsyMenu tsyMenu =tsyMenuMapper.selectByPrimaryKey(id);
       List<TsyMenu> menus=getchildren(tsyMenu,tsyMenu.getMenuId());
       tsyMenu.getChildren().addAll(menus);
      return  tsyMenu;
    }

    public List<TsyMenu> getchildren(TsyMenu root,Integer id){

        List<TsyMenu> menus =this.tsyMenuMapper.selectByParentId(id);
        for (TsyMenu menu:menus){
            menu.setParent(root);
            //每个子菜单递归调用本方法来获取所有子菜单
          List<TsyMenu> children =getchildren(menu,menu.getMenuId());
            //将递归遍历的子菜单添加到当前菜单中
            menu.getChildren().addAll(children);
        }
        return menus;
    }
}
