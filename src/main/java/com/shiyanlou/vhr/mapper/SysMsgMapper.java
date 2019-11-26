package com.shiyanlou.vhr.mapper;

import com.shiyanlou.vhr.bean.Hr;
import com.shiyanlou.vhr.bean.MsgContent;
import com.shiyanlou.vhr.bean.SysMsg;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysMsgMapper {
    //发送消息
    int sendMsg(MsgContent msg);
    //添加消息给所有hr
    int addMsg2AllHr(@Param("hrs") List<Hr> hrs, @Param("mid") Long mid);
    //获取所有的系统消息
    List<SysMsg> getSysMsg(@Param("start") int start, @Param("size") Integer size, @Param("hrid") Long hrid);
    //标记已读
    int markRead(@Param("flag") Long flag, @Param("hrid") Long hrid);
}
