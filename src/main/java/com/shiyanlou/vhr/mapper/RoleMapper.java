package com.shiyanlou.vhr.mapper;

import com.shiyanlou.vhr.bean.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {
    //获取所有的角色
    List<Role> roles();
    //添加新角色
    int addNewRole(@Param("role") String role, @Param("roleZh") String roleZh);
    //删除角色
    int deleteRoleById(Long rid);

}
