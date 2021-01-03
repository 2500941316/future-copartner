package com.shu.copartner.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class ProProject implements Serializable {
    private Long projectId;

    private String projectCreater;

    private String description;

    private Date endtime;

    private String projectFollowers;

    private Integer isDeleted;

    private Integer isLock;

    private String planUrl;

    private String primaryJob;

    private String projectName;

    private Date starttime;

    private String projectStatus;

    private String projectType;

    private String videoUrl;

    private String projectPeople;

    private String mainPeople;

    private String projectTeacher;

    private String projectNeed;

    private String projectMatch;

    private String projectCooperation;

    private String projectActivity;

    private String projectService;

    private String projectFinance;

    private String projectIncome;

    private String projectCompany;

    private String projectElseInfo;

    private String projectActivitiState;

    private String projectStateToken;

    private String projectAuditMsg;

    private Date peopleTime;

    private Date matchTime;

    private Date cooperationTime;

    private Date activityTime;

    private Date serviceTime;

    private Date financeTime;

    private Date incomeTime;

    private Date companyTime;

    private Date elseInfoTime;

    private String projectPeopleNew;

    private String isGoing;

    private Date focusTime;

    private String myFocus;

    // 关注项目的时间
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date followTime;

    private String follower;

    public String getFollower() {
        return follower;
    }

    public void setFollower(String follower) {
        this.follower = follower;
    }

    public Date getFollowTime() {
        return followTime;
    }

    public void setFollowTime(Date followTime) {
        this.followTime = followTime;
    }

    private static final long serialVersionUID = 1L;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public String getProjectCreater() {
        return projectCreater;
    }

    public void setProjectCreater(String projectCreater) {
        this.projectCreater = projectCreater == null ? null : projectCreater.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public String getProjectFollowers() {
        return projectFollowers;
    }

    public void setProjectFollowers(String projectFollowers) {
        this.projectFollowers = projectFollowers == null ? null : projectFollowers.trim();
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getIsLock() {
        return isLock;
    }

    public void setIsLock(Integer isLock) {
        this.isLock = isLock;
    }

    public String getPlanUrl() {
        return planUrl;
    }

    public void setPlanUrl(String planUrl) {
        this.planUrl = planUrl == null ? null : planUrl.trim();
    }

    public String getPrimaryJob() {
        return primaryJob;
    }

    public void setPrimaryJob(String primaryJob) {
        this.primaryJob = primaryJob == null ? null : primaryJob.trim();
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus == null ? null : projectStatus.trim();
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType == null ? null : projectType.trim();
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl == null ? null : videoUrl.trim();
    }

    public String getProjectPeople() {
        return projectPeople;
    }

    public void setProjectPeople(String projectPeople) {
        this.projectPeople = projectPeople == null ? null : projectPeople.trim();
    }

    public String getMainPeople() {
        return mainPeople;
    }

    public void setMainPeople(String mainPeople) {
        this.mainPeople = mainPeople == null ? null : mainPeople.trim();
    }

    public String getProjectTeacher() {
        return projectTeacher;
    }

    public void setProjectTeacher(String projectTeacher) {
        this.projectTeacher = projectTeacher == null ? null : projectTeacher.trim();
    }

    public String getProjectNeed() {
        return projectNeed;
    }

    public void setProjectNeed(String projectNeed) {
        this.projectNeed = projectNeed == null ? null : projectNeed.trim();
    }

    public String getProjectMatch() {
        return projectMatch;
    }

    public void setProjectMatch(String projectMatch) {
        this.projectMatch = projectMatch == null ? null : projectMatch.trim();
    }

    public String getProjectCooperation() {
        return projectCooperation;
    }

    public void setProjectCooperation(String projectCooperation) {
        this.projectCooperation = projectCooperation == null ? null : projectCooperation.trim();
    }

    public String getProjectActivity() {
        return projectActivity;
    }

    public void setProjectActivity(String projectActivity) {
        this.projectActivity = projectActivity == null ? null : projectActivity.trim();
    }

    public String getProjectService() {
        return projectService;
    }

    public void setProjectService(String projectService) {
        this.projectService = projectService == null ? null : projectService.trim();
    }

    public String getProjectFinance() {
        return projectFinance;
    }

    public void setProjectFinance(String projectFinance) {
        this.projectFinance = projectFinance == null ? null : projectFinance.trim();
    }

    public String getProjectIncome() {
        return projectIncome;
    }

    public void setProjectIncome(String projectIncome) {
        this.projectIncome = projectIncome == null ? null : projectIncome.trim();
    }

    public String getProjectCompany() {
        return projectCompany;
    }

    public void setProjectCompany(String projectCompany) {
        this.projectCompany = projectCompany == null ? null : projectCompany.trim();
    }

    public String getProjectElseInfo() {
        return projectElseInfo;
    }

    public void setProjectElseInfo(String projectElseInfo) {
        this.projectElseInfo = projectElseInfo == null ? null : projectElseInfo.trim();
    }

    public String getProjectActivitiState() {
        return projectActivitiState;
    }

    public void setProjectActivitiState(String projectActivitiState) {
        this.projectActivitiState = projectActivitiState == null ? null : projectActivitiState.trim();
    }

    public String getProjectStateToken() {
        return projectStateToken;
    }

    public void setProjectStateToken(String projectStateToken) {
        this.projectStateToken = projectStateToken == null ? null : projectStateToken.trim();
    }

    public String getProjectAuditMsg() {
        return projectAuditMsg;
    }

    public void setProjectAuditMsg(String projectAuditMsg) {
        this.projectAuditMsg = projectAuditMsg == null ? null : projectAuditMsg.trim();
    }

    public Date getPeopleTime() {
        return peopleTime;
    }

    public void setPeopleTime(Date peopleTime) {
        this.peopleTime = peopleTime;
    }

    public Date getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(Date matchTime) {
        this.matchTime = matchTime;
    }

    public Date getCooperationTime() {
        return cooperationTime;
    }

    public void setCooperationTime(Date cooperationTime) {
        this.cooperationTime = cooperationTime;
    }

    public Date getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(Date activityTime) {
        this.activityTime = activityTime;
    }

    public Date getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(Date serviceTime) {
        this.serviceTime = serviceTime;
    }

    public Date getFinanceTime() {
        return financeTime;
    }

    public void setFinanceTime(Date financeTime) {
        this.financeTime = financeTime;
    }

    public Date getIncomeTime() {
        return incomeTime;
    }

    public void setIncomeTime(Date incomeTime) {
        this.incomeTime = incomeTime;
    }

    public Date getCompanyTime() {
        return companyTime;
    }

    public void setCompanyTime(Date companyTime) {
        this.companyTime = companyTime;
    }

    public Date getElseInfoTime() {
        return elseInfoTime;
    }

    public void setElseInfoTime(Date elseInfoTime) {
        this.elseInfoTime = elseInfoTime;
    }

    public String getProjectPeopleNew() {
        return projectPeopleNew;
    }

    public void setProjectPeopleNew(String projectPeopleNew) {
        this.projectPeopleNew = projectPeopleNew == null ? null : projectPeopleNew.trim();
    }

    public String getIsGoing() {
        return isGoing;
    }

    public void setIsGoing(String isGoing) {
        this.isGoing = isGoing == null ? null : isGoing.trim();
    }

    public Date getFocusTime() {
        return focusTime;
    }

    public void setFocusTime(Date focusTime) {
        this.focusTime = focusTime;
    }

    public String getMyFocus() {
        return myFocus;
    }

    public void setMyFocus(String myFocus) {
        this.myFocus = myFocus == null ? null : myFocus.trim();
    }

    @Override
    public String toString() {
        return "ProProject{" +
                "projectId=" + projectId +
                ", projectCreater='" + projectCreater + '\'' +
                ", description='" + description + '\'' +
                ", endtime=" + endtime +
                ", projectFollowers='" + projectFollowers + '\'' +
                ", isDeleted=" + isDeleted +
                ", isLock=" + isLock +
                ", planUrl='" + planUrl + '\'' +
                ", primaryJob='" + primaryJob + '\'' +
                ", projectName='" + projectName + '\'' +
                ", starttime=" + starttime +
                ", projectStatus='" + projectStatus + '\'' +
                ", projectType='" + projectType + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", projectPeople='" + projectPeople + '\'' +
                ", mainPeople='" + mainPeople + '\'' +
                ", projectTeacher='" + projectTeacher + '\'' +
                ", projectNeed='" + projectNeed + '\'' +
                ", projectMatch='" + projectMatch + '\'' +
                ", projectCooperation='" + projectCooperation + '\'' +
                ", projectActivity='" + projectActivity + '\'' +
                ", projectService='" + projectService + '\'' +
                ", projectFinance='" + projectFinance + '\'' +
                ", projectIncome='" + projectIncome + '\'' +
                ", projectCompany='" + projectCompany + '\'' +
                ", projectElseInfo='" + projectElseInfo + '\'' +
                ", projectActivitiState='" + projectActivitiState + '\'' +
                ", projectStateToken='" + projectStateToken + '\'' +
                ", projectAuditMsg='" + projectAuditMsg + '\'' +
                ", peopleTime=" + peopleTime +
                ", matchTime=" + matchTime +
                ", cooperationTime=" + cooperationTime +
                ", activityTime=" + activityTime +
                ", serviceTime=" + serviceTime +
                ", financeTime=" + financeTime +
                ", incomeTime=" + incomeTime +
                ", companyTime=" + companyTime +
                ", elseInfoTime=" + elseInfoTime +
                ", projectPeopleNew='" + projectPeopleNew + '\'' +
                ", isGoing='" + isGoing + '\'' +
                ", focusTime=" + focusTime +
                ", myFocus='" + myFocus + '\'' +
                '}';
    }
}