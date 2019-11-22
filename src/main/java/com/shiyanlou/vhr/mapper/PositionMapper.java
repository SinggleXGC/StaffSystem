package com.shiyanlou.vhr.mapper;

import com.shiyanlou.vhr.bean.Position;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionMapper {
    //获取所有的职位
    List<Position> getAllPos();
}
