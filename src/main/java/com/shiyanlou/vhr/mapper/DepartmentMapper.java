package com.shiyanlou.vhr.mapper;

import com.shiyanlou.vhr.bean.Department;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentMapper {
    //通过pid获取部门
    List<Department> getDepByPid(Long pid);
    //获取所有部门
    List<Department> getAllDeps();

    //添加部门
    void addDep(@Param("dep") Department department);
    //删除部门
    void deleteDep(@Param("dep") Department department);

}
