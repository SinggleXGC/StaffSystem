package com.shiyanlou.vhr.controller;

import com.shiyanlou.vhr.bean.Hr;
import com.shiyanlou.vhr.bean.Menu;
import com.shiyanlou.vhr.common.HrUtils;
import com.shiyanlou.vhr.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 获取到系统菜单和当前管理员的信息
 */
@RestController
@RequestMapping("/config")
public class ConfigController {

    @Autowired
    MenuService menuService;

    @RequestMapping("/sysmenu")
    public List<Menu> sysmenu(){
        return menuService.getMenusByHrId();
    }

    @RequestMapping("/hr")
    public Hr currentUser(){
        return HrUtils.getCurrentHr();
    }

}
