package com.shiyanlou.vhr.mapper;

import com.shiyanlou.vhr.bean.Employee;
import com.shiyanlou.vhr.bean.Nation;
import com.shiyanlou.vhr.bean.PoliticsStatus;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EmpMapper {
    //获取所有的民族
    List<Nation> getAllNations();
    //获取所有的政治角色
    List<PoliticsStatus> getAllPolitics();
    //获取工号
    Long getMaxWorkID();
    //添加员工
    int addEmp(Employee employee);
    //更新员工
    int updateEmp(@Param("emp") Employee employee);
    //删除员工
    int deleteEmpById(@Param("ids") String[] ids);
    //获取所有员工，分页
    List<Employee> getEmployeeByPage(@Param("start") Integer start,@Param("size") Integer size,
                                     @Param("keywords") String keywords, @Param("politicId") Long politicId,
                                     @Param("nationId") Long nationId, @Param("posId") Long posId,
                                     @Param("jobLevelId") Long jobLevelId, @Param("engageForm") String engageForm,
                                     @Param("departmentId")Long  departmentId, @Param("startBeginDate") Date startBeginDate,
                                     @Param("endBeginDate") Date endBeginDate
                                     );
    //获取员工总数通过关键字
    Long getCountByKeywords(@Param("keywords") String keywords, @Param("politicId") Long politicId,
                            @Param("nationId") Long nationId, @Param("posId") Long posId,
                            @Param("jobLevelId") Long jobLevelId, @Param("engageForm") String engageForm,
                            @Param("departmentId")Long  departmentId, @Param("startBeginDate") Date startBeginDate,
                            @Param("endBeginDate") Date endBeginDate);
    //批量增加员工
    int addEmps(@Param("emps") List<Employee> emps);
}
