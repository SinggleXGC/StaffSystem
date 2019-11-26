package com.shiyanlou.vhr.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 聊天消息
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChatResp {

    private String msg;
    private String from;

}

