package com.shiyanlou.vhr.bean;

import lombok.Data;

/**
 * 为menu类进行补充的类，方便管理
 */
@Data
public class MenuMeta {

    private boolean keepAlive;
    private boolean requireAuth;

}
