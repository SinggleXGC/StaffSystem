package com.shiyanlou.vhr.mapper;

import com.shiyanlou.vhr.bean.Salary;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryMapper {
    //添加工资账套
    int addSalary(@Param("salary") Salary salary);
    //获取所有的工资账套
    List<Salary> getAllSalary();
    //更新工资账套
    int updateSalary(@Param("salary") Salary salary);
    //删除工资账套
    int deleteSalary(@Param("ids") String[] ids);
    //通过员工编号删除工资账套
    int deleteSalaryByEid(@Param("eid") Long eid);
    //增加工资账套id和员工id
    int addSidAndEid(@Param("sid") Integer sid, @Param("eid") Long eid);

}
