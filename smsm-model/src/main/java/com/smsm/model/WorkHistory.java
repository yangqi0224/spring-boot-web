package com.smsm.model;

import java.util.Objects;

public class WorkHistory {
    private String workHistoryId;
    private String resumeId;
    private String companyName;
    private String jobName;
    private String beginTimeYear ;
    private String beginTimeMonth;
    private String endTimeYear;
    private String endTimeMonth;
    private String updateTime;
    private String startDate;
    private String endDate;


    @Override
    public String toString() {
        return "WorkHistory{" +
                "workHistoryId='" + workHistoryId + '\'' +
                ", resumeId='" + resumeId + '\'' +
                ", companyName='" + companyName + '\'' +
                ", jobName='" + jobName + '\'' +
                ", beginTimeYear='" + beginTimeYear + '\'' +
                ", beginTimeMonth='" + beginTimeMonth + '\'' +
                ", endTimeYear='" + endTimeYear + '\'' +
                ", endTimeMoth='" + endTimeMonth + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }

    public String getStartDate() {
        return beginTimeYear+'.'+beginTimeMonth;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        if(endTimeYear.equals("至今"))
            return "至今";
        return endTimeYear+'.'+endTimeMonth;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getWorkHistoryId() {
        return workHistoryId;
    }

    public void setWorkHistoryId(String workHistoryId) {
        this.workHistoryId = workHistoryId;
    }

    public String getResumeId() {
        return resumeId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getBeginTimeYear() {
        return beginTimeYear;
    }

    public void setBeginTimeYear(String beginTimeYear) {
        this.beginTimeYear = beginTimeYear;
    }

    public String getBeginTimeMonth() {
        return beginTimeMonth;
    }

    public void setBeginTimeMonth(String beginTimeMonth) {
        this.beginTimeMonth = beginTimeMonth;
    }

    public String getEndTimeYear() {
        return endTimeYear;
    }

    public void setEndTimeYear(String endTimeYear) {
        this.endTimeYear = endTimeYear;
    }

    public String getEndTimeMonth() {
        return endTimeMonth;
    }

    public void setEndTimeMonth(String endTimeMonth) {
        this.endTimeMonth = endTimeMonth;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    private String createTime;
}
