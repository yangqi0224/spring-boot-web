package com.smsm.model;

import java.util.List;

public class Recruitment {
    private String jobId;

    private String recruitmentId;

    private String jobType;

    private String companyId;

    private String jobName;

    private String jobSalary;

    private String exceptionEducation;

    private String createTime;

    private String jobCondition;

    private String companyName;

    private String companyLocation;

    private String jobCity;

    private String jobDesc;

    private Integer salaryMax;

    private Integer salaryMin;
    private String jobYear;

    private String jobTempt;

    private String jobAddr;

    private String jobPro;

    private String department;

    private Company company;

    private int num;

    private int state;

    private List<String> descList;

    private List<String> conList;

    private String hrName;

    @Override
    public String toString() {
        return "Recruitment{" +
                "jobId='" + jobId + '\'' +
                ", recruitmentId='" + recruitmentId + '\'' +
                ", jobType='" + jobType + '\'' +
                ", companyId='" + companyId + '\'' +
                ", jobName='" + jobName + '\'' +
                ", jobSalary='" + jobSalary + '\'' +
                ", exceptionEducation='" + exceptionEducation + '\'' +
                ", createTime='" + createTime + '\'' +
                ", jobCondition='" + jobCondition + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyLocation='" + companyLocation + '\'' +
                ", jobCity='" + jobCity + '\'' +
                ", jobDesc='" + jobDesc + '\'' +
                ", salaryMax=" + salaryMax +
                ", salaryMin=" + salaryMin +
                ", jobYear='" + jobYear + '\'' +
                ", jobTempt='" + jobTempt + '\'' +
                ", jobAddr='" + jobAddr + '\'' +
                ", jobPro='" + jobPro + '\'' +
                ", department='" + department + '\'' +
                ", company=" + company +
                ", num=" + num +
                ", state=" + state +
                ", descList=" + descList +
                ", conList=" + conList +
                '}';
    }

    public String getHrName() {
        return hrName;
    }

    public void setHrName(String hrName) {
        this.hrName = hrName;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getJobAddr() {
        return jobAddr;
    }

    public void setJobAddr(String jobAddr) {
        this.jobAddr = jobAddr;
    }

    public String getRecruitmentId() {
        return recruitmentId;
    }

    public void setRecruitmentId(String recruitmentId) {
        this.recruitmentId = recruitmentId;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public List<String> getConList() {
        return conList;
    }

    public void setConList(List<String> conList) {
        this.conList = conList;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public String getJobYear() {
        return jobYear;
    }

    public void setJobYear(String jobYear) {
        this.jobYear = jobYear;
    }

    public String getJobTempt() {
        return jobTempt;
    }

    public void setJobTempt(String jobTempt) {
        this.jobTempt = jobTempt;
    }

    public List<String> getDescList() {
        return descList;
    }

    public void setDescList(List<String> descList) {
        this.descList = descList;
    }


    public String getJobPro() {
        return jobPro;
    }

    public void setJobPro(String jobPro) {
        this.jobPro = jobPro;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobSalary() {
        return jobSalary;
    }

    public void setJobSalary(String jobSalary) {
        this.jobSalary = jobSalary;
    }

    public String getExceptionEducation() {
        return exceptionEducation;
    }

    public void setExceptionEducation(String exceptionEducation) {
        this.exceptionEducation = exceptionEducation;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getJobCondition() {
        return jobCondition;
    }

    public void setJobCondition(String jobCondition) {
        this.jobCondition = jobCondition;
    }

    public String getJobCity() {
        return jobCity;
    }

    public void setJobCity(String jobCity) {
        this.jobCity = jobCity;
    }

    public Integer getSalaryMax() {
        return salaryMax;
    }

    public void setSalaryMax(Integer salaryMax) {
        this.salaryMax = salaryMax;
    }

    public Integer getSalaryMin() {
        return salaryMin;
    }

    public void setSalaryMin(Integer salaryMin) {
        this.salaryMin = salaryMin;
    }
}