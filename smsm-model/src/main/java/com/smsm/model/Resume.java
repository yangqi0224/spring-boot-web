package com.smsm.model;

import java.util.List;

public class Resume {
    private String resumeId;
    
    private String resumeName;

	private String jobSeekerId;

    private String name;

    private String sex;

    private Integer age;

    private String phone;

    private String email;

    private String education;

    private String exceptionJob;

    private String jobExp;
    
    private String createTime;
    
    private String updateTime;
    
    private String userId;

    private String exceptionCity;
    private String exceptionType;
    private String exceptionSalary;
    private String currentState;

    private String university;
    private String major;
    private String startTime;
    private String endTime;
    private WorkHistory workHistory;
    private List<WorkHistory> workHistories;
    private List<ProjectExp> projectExps;
    private ProjectExp projectExp;
    private String imgName;


    @Override
    public String toString() {
        return "Resume{" +
                "resumeId='" + resumeId + '\'' +
                ", resumeName='" + resumeName + '\'' +
                ", jobSeekerId='" + jobSeekerId + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", education='" + education + '\'' +
                ", exceptionJob='" + exceptionJob + '\'' +
                ", jobExp='" + jobExp + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", userId='" + userId + '\'' +
                ", exceptionCity='" + exceptionCity + '\'' +
                ", exceptionType='" + exceptionType + '\'' +
                ", exceptionSalary='" + exceptionSalary + '\'' +
                ", currentState='" + currentState + '\'' +
                ", university='" + university + '\'' +
                ", major='" + major + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", workHistory=" + workHistory +
                ", workHistories=" + workHistories +
                ", projectExps=" + projectExps +
                ", projectExp=" + projectExp +
                ", imgName='" + imgName + '\'' +
                '}';
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public ProjectExp getProjectExp() {
        return projectExp;
    }

    public void setProjectExp(ProjectExp projectExp) {
        this.projectExp = projectExp;
    }


    public List<WorkHistory> getWorkHistories() {
        return workHistories;
    }

    public void setWorkHistories(List<WorkHistory> workHistories) {
        this.workHistories = workHistories;
    }

    public List<ProjectExp> getProjectExps() {
        return projectExps;
    }

    public void setProjectExps(List<ProjectExp> projectExps) {
        this.projectExps = projectExps;
    }
    public WorkHistory getWorkHistory() {
        return workHistory;
    }

    public void setWorkHistory(WorkHistory workHistory) {
        this.workHistory = workHistory;
    }

    public String getResumeName() {
  		return resumeName;
  	}

  	public void setResumeName(String resumeName) {
  		this.resumeName = resumeName;
  	}
    
    public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

    public String getResumeId() {
        return resumeId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId == null ? null : resumeId.trim();
    }

    public String getJobSeekerId() {
        return jobSeekerId;
    }

    public void setJobSeekerId(String jobSeekerId) {
        this.jobSeekerId = jobSeekerId == null ? null : jobSeekerId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getExceptionJob() {
        return exceptionJob;
    }

    public void setExceptionJob(String exceptionJob) {
        this.exceptionJob = exceptionJob == null ? null : exceptionJob.trim();
    }

    public String getJobExp() {
        return jobExp;
    }

    public void setJobExp(String jobExp) {
        this.jobExp = jobExp == null ? null : jobExp.trim();
    }

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

    public String getExceptionCity() {
        return exceptionCity;
    }

    public void setExceptionCity(String exceptionCity) {
        this.exceptionCity = exceptionCity;
    }

    public String getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(String exceptionType) {
        this.exceptionType = exceptionType;
    }

    public String getExceptionSalary() {
        return exceptionSalary;
    }

    public void setExceptionSalary(String exceptionSalary) {
        this.exceptionSalary = exceptionSalary;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }


}