package com.smsm.model;

import java.util.List;

public class Company {
    private String companyId;
    private String companyName;
    private List<Recruitment> recruitments;
    private String companyField;
    private String userId;
    private String companyLocation;
    private String userPhone;
    private String companySize;
    private String companyHome;
    private String companyPresent;
    private String companyTag;
    private String companyStage;
    private String companyMerit;
    private String imgName;


    @Override
    public String toString() {
        return "Company{" +
                "companyId='" + companyId + '\'' +
                ", companyName='" + companyName + '\'' +
                ", recruitments=" + recruitments +
                ", companyField='" + companyField + '\'' +
                ", userId='" + userId + '\'' +
                ", companyLocation='" + companyLocation + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", companySize='" + companySize + '\'' +
                ", companyHome='" + companyHome + '\'' +
                ", companyPresent='" + companyPresent + '\'' +
                ", companyTag='" + companyTag + '\'' +
                ", companyStage='" + companyStage + '\'' +
                ", companyMerit='" + companyMerit + '\'' +
                ", imgName='" + imgName + '\'' +
                '}';
    }

    public String getCompanySize() {
        return companySize;
    }

    public void setCompanySize(String companySize) {
        this.companySize = companySize;
    }

    public String getCompanyHome() {
        return companyHome;
    }

    public void setCompanyHome(String companyHome) {
        this.companyHome = companyHome;
    }

    public String getCompanyPresent() {
        return companyPresent;
    }

    public void setCompanyPresent(String companyPresent) {
        this.companyPresent = companyPresent;
    }

    public String getCompanyTag() {
        return companyTag;
    }

    public void setCompanyTag(String companyTag) {
        this.companyTag = companyTag;
    }

    public String getCompanyStage() {
        return companyStage;
    }

    public void setCompanyStage(String companyStage) {
        this.companyStage = companyStage;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public String getCompanyMerit() {
        return companyMerit;
    }

    public void setCompanyMerit(String companyMerit) {
        this.companyMerit = companyMerit;
    }

    public List<Recruitment> getRecruitments() {
        return recruitments;
    }

    public void setRecruitments(List<Recruitment> recruitments) {
        this.recruitments = recruitments;
    }

    public String getCompanyField() {
        return companyField;
    }

    public void setCompanyField(String companyField) {
        this.companyField = companyField;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getCompanyLocation() {
        return companyLocation;
    }

    public void setCompanyLocation(String companyLocation) {
        this.companyLocation = companyLocation == null ? null : companyLocation.trim();
    }

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
}