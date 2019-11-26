package com.shiyanlou.vhr.bean;

import lombok.Data;

/**
 * 系统消息
 */
@Data
public class SysMsg {
    private Long id;
    private Long mid;
    private Integer type;
    private Long hrid;
    private Integer state;
    private MsgContent msgContent;

}
