package com.shiyanlou.vhr.mapper;

import com.shiyanlou.vhr.bean.JobLevel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobLevelMapper {
    //通过名字获取职称
    JobLevel getJobLevelByName(String name);
    //添加职称
    int addJobLevel(@Param("jobLevel") JobLevel jobLevel);
    //获取所有职称
    List<JobLevel> getAllJobLevels();
    //删除职称
    int deleteJobLevelById(@Param("ids") String[] ids);
    //修改职称
    int updateJobLevel(@Param("jobLevel") JobLevel jobLevel);
}
