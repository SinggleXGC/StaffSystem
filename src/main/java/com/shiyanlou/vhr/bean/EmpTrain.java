package com.shiyanlou.vhr.bean;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class EmpTrain {

    private Long id;
    private Long eid;
    private Date trainDate;
    private String trainContent;
    private String remark;

}
