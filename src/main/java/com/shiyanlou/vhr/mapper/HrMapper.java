package com.shiyanlou.vhr.mapper;

import com.shiyanlou.vhr.bean.Hr;
import com.shiyanlou.vhr.bean.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HrMapper {
    //获取对应的用户
    Hr loadUserByUsername(String username);
    //获取对应的角色
    List<Role> getRolesByHrId(Long id);
    //获取hr
    Hr getHrById(Long hrId);
    //删除hr
    int deleteHr(Long hrId);
    //修改hr
    int updateHr(Hr hr);
    //删除hr的角色
    int deleteRoleByHrId(Long hrId);
    //添加hr的角色
    int addRolesForHr(@Param("hrId") Long hrId, @Param("rids") Long[] rids);
    //通过关键字查找hr
    List<Hr> getHrsByKeywords(@Param("keywords") String keywords);

    int hrReg(@Param("username") String username, @Param("password") String password);

    //获取所有的 hr
    List<Hr> getAllHr(@Param("currentId") Long currentId);
}
