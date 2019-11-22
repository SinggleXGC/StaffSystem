package com.shiyanlou.vhr.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

/**
 * 员工表
 */
@Data
public class Employee {

    private Long id;
    private String name;
    private String gender;
    private Date birthday;
    private String idCard;
    private String wedlock;
    private Long nationId;
    private String nationName;
    private String nativePlace;
    private String politicName;
    private Long politicId;
    private String email;
    private String phone;
    private String address;
    private Long departmentId;
    private String departmentName;
    private Long jobLevelId;
    private String jobLevelName;
    private Long posId;
    private String posName;
    private String engageForm;
    private String tiptopDegree;
    private String specialty;
    private String school;
    private Date beginDate;
    private String workState;
    private String workID;
    private Double contractTerm;
    private Date conversionTime;
    private Date notWorkDate;
    private Date beginContract;
    private Date endContract;
    private Integer workAge;
    private Department department;
    private Nation nation;
    private JobLevel jobLevel;
    private Position position;
    private PoliticsStatus politicsStatus;
    private Salary salary;

    @JsonIgnore
    public Long getNationId(){
        return nationId;
    }

    @JsonIgnore
    public String getNationName() {
        return nationName;
    }

    @JsonIgnore
    public String getPoliticName(){
        return politicName;
    }

    @JsonIgnore
    public Long getPoliticId() {
        return politicId;
    }

    @JsonIgnore
    public Long getDepartmentId() {
        return departmentId;
    }

    @JsonIgnore
    public String getDepartmentName() {
        return departmentName;
    }

    @JsonIgnore
    public Long getJobLevelId() {
        return jobLevelId;
    }

    @JsonIgnore
    public String getJobLevelName() {
        return jobLevelName;
    }

    @JsonIgnore
    public Long getPosId() {
        return posId;
    }


}
