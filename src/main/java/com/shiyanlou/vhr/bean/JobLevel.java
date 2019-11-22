package com.shiyanlou.vhr.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * 职位等级类
 */
@Data
@NoArgsConstructor
public class JobLevel {
    private Long id;
    private String name;
    private String titleLevel;
    private Timestamp createDate;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        JobLevel jobLevel = (JobLevel)obj;

        return name!=null ? name.equals(jobLevel.name) : jobLevel.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public JobLevel(String name){
        this.name=name;
    }
}
