package com.smsm.model;

public class User {
    private String userId;

    private String userName;

    private String userPhone;

    private String userType;

    private String userPwd;
    
    private String jobId;

    private String companyId;

    private String jobName;

    private Integer jobSalary;

    private String exceptionEducation;

    private String companyName;

    private String companyLocation;
    
    private String jobSeekerId;

    private Company company;

	@Override
	public String toString() {
		return "User{" +
				"userId='" + userId + '\'' +
				", userName='" + userName + '\'' +
				", userPhone='" + userPhone + '\'' +
				", userType='" + userType + '\'' +
				", userPwd='" + userPwd + '\'' +
				", jobId='" + jobId + '\'' +
				", companyId='" + companyId + '\'' +
				", jobName='" + jobName + '\'' +
				", jobSalary=" + jobSalary +
				", exceptionEducation='" + exceptionEducation + '\'' +
				", companyName='" + companyName + '\'' +
				", companyLocation='" + companyLocation + '\'' +
				", jobSeekerId='" + jobSeekerId + '\'' +
				", company=" + company +
				'}';
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyLocation() {
		return companyLocation;
	}

	public void setCompanyLocation(String companyLocation) {
		this.companyLocation = companyLocation;
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

	public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd == null ? null : userPwd.trim();
    }

	public String getJobSeekerId() {
		return jobSeekerId;
	}

	public void setJobSeekerId(String jobSeekerId) {
		this.jobSeekerId = jobSeekerId;
	}
}