package com.shiyanlou.vhr.bean;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class AdjustSalary {
    private Long id;
    private Long eid;
    private Date asDate;
    private Integer beforeSalary;
    private Integer afterSalary;
    private String reason;
    private String remark;
}
