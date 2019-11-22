package com.shiyanlou.vhr.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 部门类
 */
@Data
@NoArgsConstructor
public class Department {
    private Long id;
    private String name;
    private Long parentId;
    private String depPath;
    private boolean enabled;
    private boolean isParent;

    public Department(String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass())  return false;

        Department that = (Department)obj;

        return name!=null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    //存储过程执行结果
    private Integer result;
    private List<Department> children = new ArrayList<>();

    @JsonIgnore
    public Integer getResult(){
        return result;
    }

    @JsonIgnore
    public String getDepPath(){
        return depPath;
    }
}
