package com.shiyanlou.vhr.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRoleMapper {
    //通过角色删除对应的菜单
    int deleteMenuByRid(@Param("rid") Long rid);
    //添加菜单
    int addMenu(@Param("rid") Long rid, @Param("mids") Long[] mids);
}
