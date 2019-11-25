package com.shiyanlou.vhr.mapper;

import com.shiyanlou.vhr.bean.Position;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionMapper {
    //添加职位
    int addPos(@Param("pos") Position pos);
    //获取职位
    Position getPosByName(String name);
    //获取所有职位
    List<Position> getAllPos();
    //删除职位
    int deletePosById(@Param("pids") String[] pids);
    //修改职位
    int updatePosById(@Param("pos") Position position);
}
