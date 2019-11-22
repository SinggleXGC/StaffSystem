package com.shiyanlou.vhr.mapper;

import com.shiyanlou.vhr.bean.EmpEc;
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

}
