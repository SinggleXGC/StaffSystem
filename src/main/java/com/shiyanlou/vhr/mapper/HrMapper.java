package com.shiyanlou.vhr.mapper;

import com.shiyanlou.vhr.bean.Hr;
import com.shiyanlou.vhr.bean.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface HrMapper {

    //通过名字查找
    Hr loadUserByUsername(@Param("username") String username);

    //通过Hr的id查找角色
    List<Role> getRolesByHrId(Long id);
}
