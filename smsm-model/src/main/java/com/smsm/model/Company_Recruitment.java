package com.smsm.model;

import java.util.List;

public class Company_Recruitment {

	private String jobId;

    private String companyId;

    private String jobName;

    private Integer jobSalary;

    private String exceptionEducation;
    
    private String createTime;
    
    private String jobCondition;
    
    private String companyName;
    
    private String companyLocation;

    private String jobCity;

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

	public int getJobYear() {
		return jobYear;
	}

	public void setJobYear(int jobYear) {
		this.jobYear = jobYear;
	}

	public String getJobTempt() {
		return jobTempt;
	}

	public void setJobTempt(String jobTempt) {
		this.jobTempt = jobTempt;
	}

	private List<String> descList;

    private List<String> conList;

	public List<String> getDescList() {
		return descList;
	}

	public void setDescList(List<String> descList) {
		this.descList = descList;
	}

	private String jobDesc;

    private int jobYear;

    private String jobTempt;

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

	public Integer getJobSalary() {
		return jobSalary;
	}

	public void setJobSalary(Integer jobSalary) {
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
}
