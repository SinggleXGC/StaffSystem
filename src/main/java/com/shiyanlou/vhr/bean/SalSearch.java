package com.shiyanlou.vhr.bean;

import lombok.Data;

@Data
public class SalSearch {

    private Long id;
    private Long eid;
    private String name;
    private String workID;
    private Integer bonus;
    private Integer fine;
    private Integer payment;

}
