package com.shiyanlou.vhr.bean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class InfoStatistics {

    private Integer id;
    private String depName;
    private Integer peopleCount;
    private Integer joinCount;

}
