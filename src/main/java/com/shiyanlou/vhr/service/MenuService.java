package com.shiyanlou.vhr.service;

import com.shiyanlou.vhr.bean.Menu;
import com.shiyanlou.vhr.common.HrUtils;
import com.shiyanlou.vhr.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用于获取不同角色的菜单资源，通过HrUtils可以获取到当前用户的角色，
 * 从而显示不同的菜单页面
 */
@Service
@Transactional
@CacheConfig(cacheNames = "menus cache")
public class MenuService {

    @Autowired
    MenuMapper menuMapper;

    public List<Menu> getAllMenu(){
        return menuMapper.getAllMenu();
    }

    public List<Menu> getMenusByHrId(){
        return menuMapper.getMenusByHrId(HrUtils.getCurrentHr().getId());
    }

    public List<Menu> menuTree(){
        return menuMapper.menuTree();
    }

    public List<Long> getMenusByRid(Long rid){
        return menuMapper.getMenusByRid(rid);
    }


}
