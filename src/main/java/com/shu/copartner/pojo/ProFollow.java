package com.shu.copartner.pojo;

import java.io.Serializable;
import java.util.Date;

public class ProFollow implements Serializable {
    private Long followId;

    private Long projectId;

    private String follower;

    private Date followTime;

    private Date unfollowTime;

    private Integer isDelete;

    private static final long serialVersionUID = 1L;

    public Long getFollowId() {
        return followId;
    }

    public void setFollowId(Long followId) {
        this.followId = followId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getFollower() {
        return follower;
    }

    public void setFollower(String follower) {
        this.follower = follower == null ? null : follower.trim();
    }

    public Date getFollowTime() {
        return followTime;
    }

    public void setFollowTime(Date followTime) {
        this.followTime = followTime;
    }

    public Date getUnfollowTime() {
        return unfollowTime;
    }

    public void setUnfollowTime(Date unfollowTime) {
        this.unfollowTime = unfollowTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}