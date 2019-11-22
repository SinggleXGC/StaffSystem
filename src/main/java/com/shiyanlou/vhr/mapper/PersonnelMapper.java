package com.shiyanlou.vhr.mapper;

import com.shiyanlou.vhr.bean.AdjustSalary;
import com.shiyanlou.vhr.bean.EmpEc;
import com.shiyanlou.vhr.bean.EmpMove;
import com.shiyanlou.vhr.bean.EmpTrain;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonnelMapper {
    //添加员工奖惩
    int addEc(EmpEc empEc);
    //添加员工培训
    int addEmpTrain(@Param("empTrain") EmpTrain empTrain);
    //更新员工培训
    int updateEmpTrain(@Param("empTrain") EmpTrain empTrain);
    //删除员工培训
    int deleteEmpTrain(@Param("ids") String[] ids);
    //获取所有的员工培训信息
    List<EmpTrain> getAllEmpTrains();

    int addAdjustSalary(@Param("adjustSalary") AdjustSalary adjustSalary);
    //修改员工调薪
    int updateAdjustSalary(@Param("adjustSalary") AdjustSalary adjustSalary);
    //删除员工调薪
    int deleteAdjustSalary(@Param("ids") String[] ids);
    //获取所有的调薪信息
    List<AdjustSalary> getAllAdjustSalary();



    //添加员工调动
    int addEmpMove(@Param("empMove") EmpMove empMove);
    //更新员工调动
    int updateEmpMove(@Param("empMove") EmpMove empMove);
    //获取所有的员工调动信息
    List<EmpMove> getAllEmpMove();
    //更新员工的部门和职称
    int updateDepIdAndJobId(@Param("empMove") EmpMove empMove);

}
