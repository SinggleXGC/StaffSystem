package com.shiyanlou.vhr.bean;

import lombok.Data;

@Data
public class SalaryMan {

    private Long id;
    private Long eid;
    private String name;
    private String workID;
    private Integer lateCount;
    private Integer leaveCount;
    private Integer overtime;

}
