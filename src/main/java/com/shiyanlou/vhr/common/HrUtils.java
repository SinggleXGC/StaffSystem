package com.shiyanlou.vhr.common;

import com.shiyanlou.vhr.bean.Hr;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 返回当前正在操作的用户
 */
public class HrUtils {
    public static Hr getCurrentHr(){
        return (Hr) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
