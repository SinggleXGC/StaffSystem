package com.shiyanlou.vhr.bean;

import lombok.Data;

import java.util.Date;

/**
 * 系统消息
 */
@Data
public class MsgContent {
    private Long id;
    private String message;
    private String title;
    private Date createDate;
}

