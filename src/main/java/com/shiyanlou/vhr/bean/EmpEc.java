package com.shiyanlou.vhr.bean;

import lombok.Data;

import java.util.Date;

@Data
public class EmpEc {
    private Long id;
    private Long eid;
    private Date ecDate;
    private String ecReason;
    private int ecType;
    private String rmark;
}
