package com.shiyanlou.vhr.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 角色表，name字段表示角色的英文名称，按照SpringSecurity的规范
 * 将以ROLE_开始，nameZh字段表示角色的中文名称
 */
@Data
public class Role implements Serializable {
    private Long id;
    private String name;
    private String nameZh;
}
