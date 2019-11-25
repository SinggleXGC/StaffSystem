package com.shiyanlou.vhr.mapper;

import com.shiyanlou.vhr.bean.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatisticsMapper {
    //获取相应部门的入职人数
    int getJoinCount(Long depId);
    //获取部门总人数
    int getAllPeoplebyDepId(Long depId);
    //获取所有的部门
    List<Department> getAllDeps();
}
