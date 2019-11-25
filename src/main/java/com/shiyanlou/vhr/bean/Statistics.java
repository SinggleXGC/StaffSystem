package com.shiyanlou.vhr.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Statistics {

    private Long id;
    private Long eid;
    private String type;
    private Date tDate;
    private String remark;

    public void settDate(Date tDate) {
        this.tDate = tDate;
    }

    public Date gettDate(){
        return tDate;
    }
}
