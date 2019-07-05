package com.smsm.model;

public class ProjectExp {
    private String projectExpId;
    private String resumeId;
    private String projectExpName;
    private String projectExpDuty;
    private String beginTimeYear;
    private String beginTimeMonth;
    private String endTimeYear;
    private String endTimeMonth;
    private String updateTime;
    private String createTime;
    private String dutyContent;
    private String startDate;
    private String endDate;


    @Override
    public String toString() {
        return "ProjectExp{" +
                "projectExpId='" + projectExpId + '\'' +
                ", resumeId='" + resumeId + '\'' +
                ", projectExpName='" + projectExpName + '\'' +
                ", projectExpDuty='" + projectExpDuty + '\'' +
                ", beginTimeYear='" + beginTimeYear + '\'' +
                ", beginTimeMonth='" + beginTimeMonth + '\'' +
                ", endTimeYear='" + endTimeYear + '\'' +
                ", endTimeMonth='" + endTimeMonth + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", createTime='" + createTime + '\'' +
                ", dutyContent='" + dutyContent + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }


    public String getStartDate() {
        return beginTimeYear+'.'+beginTimeMonth;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        if (endTimeYear.equals("至今"))
            return "至今";
        return endTimeYear+'.'+endTimeMonth;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDutyContent() {
        return dutyContent;
    }

    public void setDutyContent(String dutyContent) {
        this.dutyContent = dutyContent;
    }

    public String getProjectExpId() {
        return projectExpId;
    }

    public void setProjectExpId(String projectExpId) {
        this.projectExpId = projectExpId;
    }

    public String getResumeId() {
        return resumeId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId;
    }

    public String getProjectExpName() {
        return projectExpName;
    }

    public void setProjectExpName(String projectExpName) {
        this.projectExpName = projectExpName;
    }

    public String getProjectExpDuty() {
        return projectExpDuty;
    }

    public void setProjectExpDuty(String projectExpDuty) {
        this.projectExpDuty = projectExpDuty;
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
}
