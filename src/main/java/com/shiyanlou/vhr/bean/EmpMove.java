package com.shiyanlou.vhr.bean;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class EmpMove {
    private Long id;
    private Long eid;
    private Long afterDepId;
    private Long afterJobId;
    private Date removeDate;
    private String reason;
    private String remark;
}
