package com.shiyanlou.vhr.mapper;

import com.shiyanlou.vhr.bean.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 菜单栏管理
 */
@Repository
public interface MenuMapper {
    //获取所有的菜单
    List<Menu> getAllMenu();
    //通过hrid来查找相应的菜单
    List<Menu> getMenusByHrId(Long hrId);

    List<Menu> menuTree();
    //Rid来获取MenusID
    List<Long> getMenusByRid(Long rid);

}
