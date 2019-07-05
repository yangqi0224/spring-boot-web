package com.smsm.model;

import java.util.Date;

public class ToEmploy {
    private String toEmployId;
    private String jobSeekerId;

    private String resumeId;

    private String recruitmentId;

    private String jobSeekerName;

    private String companyName;

    private Integer exceptionSalary;
    
    private String toEmployDate;

    private String recruitmentCreateTime;
    
    private String userName;
    
    private String resumeName;

    private Recruitment recruitment;

    private int state;

    private String updateTime;
    @Override
    public String toString() {
        return "ToEmploy{" +
                "toEmployId='" + toEmployId + '\'' +
                ", jobSeekerId='" + jobSeekerId + '\'' +
                ", resumeId='" + resumeId + '\'' +
                ", recruitmentId='" + recruitmentId + '\'' +
                ", jobSeekerName='" + jobSeekerName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", exceptionSalary=" + exceptionSalary +
                ", toEmployDate='" + toEmployDate + '\'' +
                ", recruitmentCreateTime='" + recruitmentCreateTime + '\'' +
                ", userName='" + userName + '\'' +
                ", resumeName='" + resumeName + '\'' +
                ", recruitment=" + recruitment +
                ", state=" + state +
                '}';
    }


    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Recruitment getRecruitment() {
        return recruitment;
    }

    public void setRecruitment(Recruitment recruitment) {
        this.recruitment = recruitment;
    }

    public String getJobSeekerId() {
        return jobSeekerId;
    }

    public void setJobSeekerId(String jobSeekerId) {
        this.jobSeekerId = jobSeekerId == null ? null : jobSeekerId.trim();
    }

    public String getResumeId() {
        return resumeId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId == null ? null : resumeId.trim();
    }

    public String getToEmployId() {
        return toEmployId;
    }

    public void setToEmployId(String toEmployId) {
        this.toEmployId = toEmployId;
    }

    public String getRecruitmentId() {
        return recruitmentId;
    }

    public void setRecruitmentId(String recruitmentId) {
        this.recruitmentId = recruitmentId;
    }

    public String getJobSeekerName() {
        return jobSeekerName;
    }

    public void setJobSeekerName(String jobSeekerName) {
        this.jobSeekerName = jobSeekerName == null ? null : jobSeekerName.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public Integer getExceptionSalary() {
        return exceptionSalary;
    }

    public void setExceptionSalary(Integer exceptionSalary) {
        this.exceptionSalary = exceptionSalary;
    }


	public String getToEmployDate() {
		return toEmployDate;
	}

	public void setToEmployDate(String toEmployDate) {
		this.toEmployDate = toEmployDate;
	}

	public String getRecruitmentCreateTime() {
		return recruitmentCreateTime;
	}

	public void setRecruitmentCreateTime(String recruitmentCreateTime) {
		this.recruitmentCreateTime = recruitmentCreateTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getResumeName() {
		return resumeName;
	}

	public void setResumeName(String resumeName) {
		this.resumeName = resumeName;
	}
}