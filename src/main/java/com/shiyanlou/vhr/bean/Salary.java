package com.shiyanlou.vhr.bean;

import lombok.Data;

import java.util.Date;

/**
 * 工资表
 */
@Data
public class Salary {
    private Integer id;
    private Integer bonus;
    private Integer lunchSalary;
    private Integer trafficSalary;
    private Integer basicSalary;
    private Integer allSalary;
    private Integer pensionBase;
    private Float pensionPer;
    private Date createDate;
    private Integer medicalBase;
    private Float medicalPer;
    private Integer accumulationFundBase;
    private Float accumulationFundPer;
    private String name;

}
