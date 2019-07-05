package com.smsm.model;

public class JobSeeker {
    private String jobSeekerId;

    private String jobSeekerName;

    private String jobSeekerSex;

    private Integer resumeNum;

    private String userId;

    public String getJobSeekerId() {
        return jobSeekerId;
    }

    public void setJobSeekerId(String jobSeekerId) {
        this.jobSeekerId = jobSeekerId == null ? null : jobSeekerId.trim();
    }

    public String getJobSeekerName() {
        return jobSeekerName;
    }

    public void setJobSeekerName(String jobSeekerName) {
        this.jobSeekerName = jobSeekerName == null ? null : jobSeekerName.trim();
    }

    public String getJobSeekerSex() {
        return jobSeekerSex;
    }

    public void setJobSeekerSex(String jobSeekerSex) {
        this.jobSeekerSex = jobSeekerSex == null ? null : jobSeekerSex.trim();
    }

    public Integer getResumeNum() {
        return resumeNum;
    }

    public void setResumeNum(Integer resumeNum) {
        this.resumeNum = resumeNum;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}