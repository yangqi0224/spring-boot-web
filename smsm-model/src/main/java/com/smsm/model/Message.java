package com.smsm.model;

import java.util.Date;

public class Message {
    private String mId;

    private Boolean mStatus;

    private Date mTime;

    private String mFromUserId;

    private String mToUserId;

    private String mContent;

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId == null ? null : mId.trim();
    }

    public Boolean getmStatus() {
        return mStatus;
    }

    public void setmStatus(Boolean mStatus) {
        this.mStatus = mStatus;
    }

    public Date getmTime() {
        return mTime;
    }

    public void setmTime(Date mTime) {
        this.mTime = mTime;
    }

    public String getmFromUserId() {
        return mFromUserId;
    }

    public void setmFromUserId(String mFromUserId) {
        this.mFromUserId = mFromUserId == null ? null : mFromUserId.trim();
    }

    public String getmToUserId() {
        return mToUserId;
    }

    public void setmToUserId(String mToUserId) {
        this.mToUserId = mToUserId == null ? null : mToUserId.trim();
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent == null ? null : mContent.trim();
    }
}