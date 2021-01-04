package com.shu.copartner.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProProjectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProProjectExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(Long value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(Long value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(Long value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(Long value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(Long value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(Long value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<Long> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<Long> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(Long value1, Long value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(Long value1, Long value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectCreaterIsNull() {
            addCriterion("project_creater is null");
            return (Criteria) this;
        }

        public Criteria andProjectCreaterIsNotNull() {
            addCriterion("project_creater is not null");
            return (Criteria) this;
        }

        public Criteria andProjectCreaterEqualTo(String value) {
            addCriterion("project_creater =", value, "projectCreater");
            return (Criteria) this;
        }

        public Criteria andProjectCreaterNotEqualTo(String value) {
            addCriterion("project_creater <>", value, "projectCreater");
            return (Criteria) this;
        }

        public Criteria andProjectCreaterGreaterThan(String value) {
            addCriterion("project_creater >", value, "projectCreater");
            return (Criteria) this;
        }

        public Criteria andProjectCreaterGreaterThanOrEqualTo(String value) {
            addCriterion("project_creater >=", value, "projectCreater");
            return (Criteria) this;
        }

        public Criteria andProjectCreaterLessThan(String value) {
            addCriterion("project_creater <", value, "projectCreater");
            return (Criteria) this;
        }

        public Criteria andProjectCreaterLessThanOrEqualTo(String value) {
            addCriterion("project_creater <=", value, "projectCreater");
            return (Criteria) this;
        }

        public Criteria andProjectCreaterLike(String value) {
            addCriterion("project_creater like", value, "projectCreater");
            return (Criteria) this;
        }

        public Criteria andProjectCreaterNotLike(String value) {
            addCriterion("project_creater not like", value, "projectCreater");
            return (Criteria) this;
        }

        public Criteria andProjectCreaterIn(List<String> values) {
            addCriterion("project_creater in", values, "projectCreater");
            return (Criteria) this;
        }

        public Criteria andProjectCreaterNotIn(List<String> values) {
            addCriterion("project_creater not in", values, "projectCreater");
            return (Criteria) this;
        }

        public Criteria andProjectCreaterBetween(String value1, String value2) {
            addCriterion("project_creater between", value1, value2, "projectCreater");
            return (Criteria) this;
        }

        public Criteria andProjectCreaterNotBetween(String value1, String value2) {
            addCriterion("project_creater not between", value1, value2, "projectCreater");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNull() {
            addCriterion("endtime is null");
            return (Criteria) this;
        }

        public Criteria andEndtimeIsNotNull() {
            addCriterion("endtime is not null");
            return (Criteria) this;
        }

        public Criteria andEndtimeEqualTo(Date value) {
            addCriterion("endtime =", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotEqualTo(Date value) {
            addCriterion("endtime <>", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThan(Date value) {
            addCriterion("endtime >", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("endtime >=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThan(Date value) {
            addCriterion("endtime <", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeLessThanOrEqualTo(Date value) {
            addCriterion("endtime <=", value, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeIn(List<Date> values) {
            addCriterion("endtime in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotIn(List<Date> values) {
            addCriterion("endtime not in", values, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeBetween(Date value1, Date value2) {
            addCriterion("endtime between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andEndtimeNotBetween(Date value1, Date value2) {
            addCriterion("endtime not between", value1, value2, "endtime");
            return (Criteria) this;
        }

        public Criteria andProjectFollowersIsNull() {
            addCriterion("project_followers is null");
            return (Criteria) this;
        }

        public Criteria andProjectFollowersIsNotNull() {
            addCriterion("project_followers is not null");
            return (Criteria) this;
        }

        public Criteria andProjectFollowersEqualTo(String value) {
            addCriterion("project_followers =", value, "projectFollowers");
            return (Criteria) this;
        }

        public Criteria andProjectFollowersNotEqualTo(String value) {
            addCriterion("project_followers <>", value, "projectFollowers");
            return (Criteria) this;
        }

        public Criteria andProjectFollowersGreaterThan(String value) {
            addCriterion("project_followers >", value, "projectFollowers");
            return (Criteria) this;
        }

        public Criteria andProjectFollowersGreaterThanOrEqualTo(String value) {
            addCriterion("project_followers >=", value, "projectFollowers");
            return (Criteria) this;
        }

        public Criteria andProjectFollowersLessThan(String value) {
            addCriterion("project_followers <", value, "projectFollowers");
            return (Criteria) this;
        }

        public Criteria andProjectFollowersLessThanOrEqualTo(String value) {
            addCriterion("project_followers <=", value, "projectFollowers");
            return (Criteria) this;
        }

        public Criteria andProjectFollowersLike(String value) {
            addCriterion("project_followers like", value, "projectFollowers");
            return (Criteria) this;
        }

        public Criteria andProjectFollowersNotLike(String value) {
            addCriterion("project_followers not like", value, "projectFollowers");
            return (Criteria) this;
        }

        public Criteria andProjectFollowersIn(List<String> values) {
            addCriterion("project_followers in", values, "projectFollowers");
            return (Criteria) this;
        }

        public Criteria andProjectFollowersNotIn(List<String> values) {
            addCriterion("project_followers not in", values, "projectFollowers");
            return (Criteria) this;
        }

        public Criteria andProjectFollowersBetween(String value1, String value2) {
            addCriterion("project_followers between", value1, value2, "projectFollowers");
            return (Criteria) this;
        }

        public Criteria andProjectFollowersNotBetween(String value1, String value2) {
            addCriterion("project_followers not between", value1, value2, "projectFollowers");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(Integer value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(Integer value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(Integer value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(Integer value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Integer value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<Integer> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<Integer> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(Integer value1, Integer value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(Integer value1, Integer value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsLockIsNull() {
            addCriterion("is_lock is null");
            return (Criteria) this;
        }

        public Criteria andIsLockIsNotNull() {
            addCriterion("is_lock is not null");
            return (Criteria) this;
        }

        public Criteria andIsLockEqualTo(Integer value) {
            addCriterion("is_lock =", value, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockNotEqualTo(Integer value) {
            addCriterion("is_lock <>", value, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockGreaterThan(Integer value) {
            addCriterion("is_lock >", value, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_lock >=", value, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockLessThan(Integer value) {
            addCriterion("is_lock <", value, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockLessThanOrEqualTo(Integer value) {
            addCriterion("is_lock <=", value, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockIn(List<Integer> values) {
            addCriterion("is_lock in", values, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockNotIn(List<Integer> values) {
            addCriterion("is_lock not in", values, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockBetween(Integer value1, Integer value2) {
            addCriterion("is_lock between", value1, value2, "isLock");
            return (Criteria) this;
        }

        public Criteria andIsLockNotBetween(Integer value1, Integer value2) {
            addCriterion("is_lock not between", value1, value2, "isLock");
            return (Criteria) this;
        }

        public Criteria andPlanUrlIsNull() {
            addCriterion("plan_url is null");
            return (Criteria) this;
        }

        public Criteria andPlanUrlIsNotNull() {
            addCriterion("plan_url is not null");
            return (Criteria) this;
        }

        public Criteria andPlanUrlEqualTo(String value) {
            addCriterion("plan_url =", value, "planUrl");
            return (Criteria) this;
        }

        public Criteria andPlanUrlNotEqualTo(String value) {
            addCriterion("plan_url <>", value, "planUrl");
            return (Criteria) this;
        }

        public Criteria andPlanUrlGreaterThan(String value) {
            addCriterion("plan_url >", value, "planUrl");
            return (Criteria) this;
        }

        public Criteria andPlanUrlGreaterThanOrEqualTo(String value) {
            addCriterion("plan_url >=", value, "planUrl");
            return (Criteria) this;
        }

        public Criteria andPlanUrlLessThan(String value) {
            addCriterion("plan_url <", value, "planUrl");
            return (Criteria) this;
        }

        public Criteria andPlanUrlLessThanOrEqualTo(String value) {
            addCriterion("plan_url <=", value, "planUrl");
            return (Criteria) this;
        }

        public Criteria andPlanUrlLike(String value) {
            addCriterion("plan_url like", value, "planUrl");
            return (Criteria) this;
        }

        public Criteria andPlanUrlNotLike(String value) {
            addCriterion("plan_url not like", value, "planUrl");
            return (Criteria) this;
        }

        public Criteria andPlanUrlIn(List<String> values) {
            addCriterion("plan_url in", values, "planUrl");
            return (Criteria) this;
        }

        public Criteria andPlanUrlNotIn(List<String> values) {
            addCriterion("plan_url not in", values, "planUrl");
            return (Criteria) this;
        }

        public Criteria andPlanUrlBetween(String value1, String value2) {
            addCriterion("plan_url between", value1, value2, "planUrl");
            return (Criteria) this;
        }

        public Criteria andPlanUrlNotBetween(String value1, String value2) {
            addCriterion("plan_url not between", value1, value2, "planUrl");
            return (Criteria) this;
        }

        public Criteria andPrimaryJobIsNull() {
            addCriterion("primary_job is null");
            return (Criteria) this;
        }

        public Criteria andPrimaryJobIsNotNull() {
            addCriterion("primary_job is not null");
            return (Criteria) this;
        }

        public Criteria andPrimaryJobEqualTo(String value) {
            addCriterion("primary_job =", value, "primaryJob");
            return (Criteria) this;
        }

        public Criteria andPrimaryJobNotEqualTo(String value) {
            addCriterion("primary_job <>", value, "primaryJob");
            return (Criteria) this;
        }

        public Criteria andPrimaryJobGreaterThan(String value) {
            addCriterion("primary_job >", value, "primaryJob");
            return (Criteria) this;
        }

        public Criteria andPrimaryJobGreaterThanOrEqualTo(String value) {
            addCriterion("primary_job >=", value, "primaryJob");
            return (Criteria) this;
        }

        public Criteria andPrimaryJobLessThan(String value) {
            addCriterion("primary_job <", value, "primaryJob");
            return (Criteria) this;
        }

        public Criteria andPrimaryJobLessThanOrEqualTo(String value) {
            addCriterion("primary_job <=", value, "primaryJob");
            return (Criteria) this;
        }

        public Criteria andPrimaryJobLike(String value) {
            addCriterion("primary_job like", value, "primaryJob");
            return (Criteria) this;
        }

        public Criteria andPrimaryJobNotLike(String value) {
            addCriterion("primary_job not like", value, "primaryJob");
            return (Criteria) this;
        }

        public Criteria andPrimaryJobIn(List<String> values) {
            addCriterion("primary_job in", values, "primaryJob");
            return (Criteria) this;
        }

        public Criteria andPrimaryJobNotIn(List<String> values) {
            addCriterion("primary_job not in", values, "primaryJob");
            return (Criteria) this;
        }

        public Criteria andPrimaryJobBetween(String value1, String value2) {
            addCriterion("primary_job between", value1, value2, "primaryJob");
            return (Criteria) this;
        }

        public Criteria andPrimaryJobNotBetween(String value1, String value2) {
            addCriterion("primary_job not between", value1, value2, "primaryJob");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNull() {
            addCriterion("project_name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_name not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNull() {
            addCriterion("starttime is null");
            return (Criteria) this;
        }

        public Criteria andStarttimeIsNotNull() {
            addCriterion("starttime is not null");
            return (Criteria) this;
        }

        public Criteria andStarttimeEqualTo(Date value) {
            addCriterion("starttime =", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotEqualTo(Date value) {
            addCriterion("starttime <>", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThan(Date value) {
            addCriterion("starttime >", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("starttime >=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThan(Date value) {
            addCriterion("starttime <", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeLessThanOrEqualTo(Date value) {
            addCriterion("starttime <=", value, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeIn(List<Date> values) {
            addCriterion("starttime in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotIn(List<Date> values) {
            addCriterion("starttime not in", values, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeBetween(Date value1, Date value2) {
            addCriterion("starttime between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andStarttimeNotBetween(Date value1, Date value2) {
            addCriterion("starttime not between", value1, value2, "starttime");
            return (Criteria) this;
        }

        public Criteria andProjectStatusIsNull() {
            addCriterion("project_status is null");
            return (Criteria) this;
        }

        public Criteria andProjectStatusIsNotNull() {
            addCriterion("project_status is not null");
            return (Criteria) this;
        }

        public Criteria andProjectStatusEqualTo(String value) {
            addCriterion("project_status =", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusNotEqualTo(String value) {
            addCriterion("project_status <>", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusGreaterThan(String value) {
            addCriterion("project_status >", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusGreaterThanOrEqualTo(String value) {
            addCriterion("project_status >=", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusLessThan(String value) {
            addCriterion("project_status <", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusLessThanOrEqualTo(String value) {
            addCriterion("project_status <=", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusLike(String value) {
            addCriterion("project_status like", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusNotLike(String value) {
            addCriterion("project_status not like", value, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusIn(List<String> values) {
            addCriterion("project_status in", values, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusNotIn(List<String> values) {
            addCriterion("project_status not in", values, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusBetween(String value1, String value2) {
            addCriterion("project_status between", value1, value2, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectStatusNotBetween(String value1, String value2) {
            addCriterion("project_status not between", value1, value2, "projectStatus");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIsNull() {
            addCriterion("project_type is null");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIsNotNull() {
            addCriterion("project_type is not null");
            return (Criteria) this;
        }

        public Criteria andProjectTypeEqualTo(String value) {
            addCriterion("project_type =", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotEqualTo(String value) {
            addCriterion("project_type <>", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeGreaterThan(String value) {
            addCriterion("project_type >", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeGreaterThanOrEqualTo(String value) {
            addCriterion("project_type >=", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLessThan(String value) {
            addCriterion("project_type <", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLessThanOrEqualTo(String value) {
            addCriterion("project_type <=", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeLike(String value) {
            addCriterion("project_type like", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotLike(String value) {
            addCriterion("project_type not like", value, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeIn(List<String> values) {
            addCriterion("project_type in", values, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotIn(List<String> values) {
            addCriterion("project_type not in", values, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeBetween(String value1, String value2) {
            addCriterion("project_type between", value1, value2, "projectType");
            return (Criteria) this;
        }

        public Criteria andProjectTypeNotBetween(String value1, String value2) {
            addCriterion("project_type not between", value1, value2, "projectType");
            return (Criteria) this;
        }

        public Criteria andVideoUrlIsNull() {
            addCriterion("video_url is null");
            return (Criteria) this;
        }

        public Criteria andVideoUrlIsNotNull() {
            addCriterion("video_url is not null");
            return (Criteria) this;
        }

        public Criteria andVideoUrlEqualTo(String value) {
            addCriterion("video_url =", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotEqualTo(String value) {
            addCriterion("video_url <>", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlGreaterThan(String value) {
            addCriterion("video_url >", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("video_url >=", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlLessThan(String value) {
            addCriterion("video_url <", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlLessThanOrEqualTo(String value) {
            addCriterion("video_url <=", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlLike(String value) {
            addCriterion("video_url like", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotLike(String value) {
            addCriterion("video_url not like", value, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlIn(List<String> values) {
            addCriterion("video_url in", values, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotIn(List<String> values) {
            addCriterion("video_url not in", values, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlBetween(String value1, String value2) {
            addCriterion("video_url between", value1, value2, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andVideoUrlNotBetween(String value1, String value2) {
            addCriterion("video_url not between", value1, value2, "videoUrl");
            return (Criteria) this;
        }

        public Criteria andProjectPeopleIsNull() {
            addCriterion("project_people is null");
            return (Criteria) this;
        }

        public Criteria andProjectPeopleIsNotNull() {
            addCriterion("project_people is not null");
            return (Criteria) this;
        }

        public Criteria andProjectPeopleEqualTo(String value) {
            addCriterion("project_people =", value, "projectPeople");
            return (Criteria) this;
        }

        public Criteria andProjectPeopleNotEqualTo(String value) {
            addCriterion("project_people <>", value, "projectPeople");
            return (Criteria) this;
        }

        public Criteria andProjectPeopleGreaterThan(String value) {
            addCriterion("project_people >", value, "projectPeople");
            return (Criteria) this;
        }

        public Criteria andProjectPeopleGreaterThanOrEqualTo(String value) {
            addCriterion("project_people >=", value, "projectPeople");
            return (Criteria) this;
        }

        public Criteria andProjectPeopleLessThan(String value) {
            addCriterion("project_people <", value, "projectPeople");
            return (Criteria) this;
        }

        public Criteria andProjectPeopleLessThanOrEqualTo(String value) {
            addCriterion("project_people <=", value, "projectPeople");
            return (Criteria) this;
        }

        public Criteria andProjectPeopleLike(String value) {
            addCriterion("project_people like", value, "projectPeople");
            return (Criteria) this;
        }

        public Criteria andProjectPeopleNotLike(String value) {
            addCriterion("project_people not like", value, "projectPeople");
            return (Criteria) this;
        }

        public Criteria andProjectPeopleIn(List<String> values) {
            addCriterion("project_people in", values, "projectPeople");
            return (Criteria) this;
        }

        public Criteria andProjectPeopleNotIn(List<String> values) {
            addCriterion("project_people not in", values, "projectPeople");
            return (Criteria) this;
        }

        public Criteria andProjectPeopleBetween(String value1, String value2) {
            addCriterion("project_people between", value1, value2, "projectPeople");
            return (Criteria) this;
        }

        public Criteria andProjectPeopleNotBetween(String value1, String value2) {
            addCriterion("project_people not between", value1, value2, "projectPeople");
            return (Criteria) this;
        }

        public Criteria andMainPeopleIsNull() {
            addCriterion("main_people is null");
            return (Criteria) this;
        }

        public Criteria andMainPeopleIsNotNull() {
            addCriterion("main_people is not null");
            return (Criteria) this;
        }

        public Criteria andMainPeopleEqualTo(String value) {
            addCriterion("main_people =", value, "mainPeople");
            return (Criteria) this;
        }

        public Criteria andMainPeopleNotEqualTo(String value) {
            addCriterion("main_people <>", value, "mainPeople");
            return (Criteria) this;
        }

        public Criteria andMainPeopleGreaterThan(String value) {
            addCriterion("main_people >", value, "mainPeople");
            return (Criteria) this;
        }

        public Criteria andMainPeopleGreaterThanOrEqualTo(String value) {
            addCriterion("main_people >=", value, "mainPeople");
            return (Criteria) this;
        }

        public Criteria andMainPeopleLessThan(String value) {
            addCriterion("main_people <", value, "mainPeople");
            return (Criteria) this;
        }

        public Criteria andMainPeopleLessThanOrEqualTo(String value) {
            addCriterion("main_people <=", value, "mainPeople");
            return (Criteria) this;
        }

        public Criteria andMainPeopleLike(String value) {
            addCriterion("main_people like", value, "mainPeople");
            return (Criteria) this;
        }

        public Criteria andMainPeopleNotLike(String value) {
            addCriterion("main_people not like", value, "mainPeople");
            return (Criteria) this;
        }

        public Criteria andMainPeopleIn(List<String> values) {
            addCriterion("main_people in", values, "mainPeople");
            return (Criteria) this;
        }

        public Criteria andMainPeopleNotIn(List<String> values) {
            addCriterion("main_people not in", values, "mainPeople");
            return (Criteria) this;
        }

        public Criteria andMainPeopleBetween(String value1, String value2) {
            addCriterion("main_people between", value1, value2, "mainPeople");
            return (Criteria) this;
        }

        public Criteria andMainPeopleNotBetween(String value1, String value2) {
            addCriterion("main_people not between", value1, value2, "mainPeople");
            return (Criteria) this;
        }

        public Criteria andProjectTeacherIsNull() {
            addCriterion("project_teacher is null");
            return (Criteria) this;
        }

        public Criteria andProjectTeacherIsNotNull() {
            addCriterion("project_teacher is not null");
            return (Criteria) this;
        }

        public Criteria andProjectTeacherEqualTo(String value) {
            addCriterion("project_teacher =", value, "projectTeacher");
            return (Criteria) this;
        }

        public Criteria andProjectTeacherNotEqualTo(String value) {
            addCriterion("project_teacher <>", value, "projectTeacher");
            return (Criteria) this;
        }

        public Criteria andProjectTeacherGreaterThan(String value) {
            addCriterion("project_teacher >", value, "projectTeacher");
            return (Criteria) this;
        }

        public Criteria andProjectTeacherGreaterThanOrEqualTo(String value) {
            addCriterion("project_teacher >=", value, "projectTeacher");
            return (Criteria) this;
        }

        public Criteria andProjectTeacherLessThan(String value) {
            addCriterion("project_teacher <", value, "projectTeacher");
            return (Criteria) this;
        }

        public Criteria andProjectTeacherLessThanOrEqualTo(String value) {
            addCriterion("project_teacher <=", value, "projectTeacher");
            return (Criteria) this;
        }

        public Criteria andProjectTeacherLike(String value) {
            addCriterion("project_teacher like", value, "projectTeacher");
            return (Criteria) this;
        }

        public Criteria andProjectTeacherNotLike(String value) {
            addCriterion("project_teacher not like", value, "projectTeacher");
            return (Criteria) this;
        }

        public Criteria andProjectTeacherIn(List<String> values) {
            addCriterion("project_teacher in", values, "projectTeacher");
            return (Criteria) this;
        }

        public Criteria andProjectTeacherNotIn(List<String> values) {
            addCriterion("project_teacher not in", values, "projectTeacher");
            return (Criteria) this;
        }

        public Criteria andProjectTeacherBetween(String value1, String value2) {
            addCriterion("project_teacher between", value1, value2, "projectTeacher");
            return (Criteria) this;
        }

        public Criteria andProjectTeacherNotBetween(String value1, String value2) {
            addCriterion("project_teacher not between", value1, value2, "projectTeacher");
            return (Criteria) this;
        }

        public Criteria andProjectNeedIsNull() {
            addCriterion("project_need is null");
            return (Criteria) this;
        }

        public Criteria andProjectNeedIsNotNull() {
            addCriterion("project_need is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNeedEqualTo(String value) {
            addCriterion("project_need =", value, "projectNeed");
            return (Criteria) this;
        }

        public Criteria andProjectNeedNotEqualTo(String value) {
            addCriterion("project_need <>", value, "projectNeed");
            return (Criteria) this;
        }

        public Criteria andProjectNeedGreaterThan(String value) {
            addCriterion("project_need >", value, "projectNeed");
            return (Criteria) this;
        }

        public Criteria andProjectNeedGreaterThanOrEqualTo(String value) {
            addCriterion("project_need >=", value, "projectNeed");
            return (Criteria) this;
        }

        public Criteria andProjectNeedLessThan(String value) {
            addCriterion("project_need <", value, "projectNeed");
            return (Criteria) this;
        }

        public Criteria andProjectNeedLessThanOrEqualTo(String value) {
            addCriterion("project_need <=", value, "projectNeed");
            return (Criteria) this;
        }

        public Criteria andProjectNeedLike(String value) {
            addCriterion("project_need like", value, "projectNeed");
            return (Criteria) this;
        }

        public Criteria andProjectNeedNotLike(String value) {
            addCriterion("project_need not like", value, "projectNeed");
            return (Criteria) this;
        }

        public Criteria andProjectNeedIn(List<String> values) {
            addCriterion("project_need in", values, "projectNeed");
            return (Criteria) this;
        }

        public Criteria andProjectNeedNotIn(List<String> values) {
            addCriterion("project_need not in", values, "projectNeed");
            return (Criteria) this;
        }

        public Criteria andProjectNeedBetween(String value1, String value2) {
            addCriterion("project_need between", value1, value2, "projectNeed");
            return (Criteria) this;
        }

        public Criteria andProjectNeedNotBetween(String value1, String value2) {
            addCriterion("project_need not between", value1, value2, "projectNeed");
            return (Criteria) this;
        }

        public Criteria andProjectMatchIsNull() {
            addCriterion("project_match is null");
            return (Criteria) this;
        }

        public Criteria andProjectMatchIsNotNull() {
            addCriterion("project_match is not null");
            return (Criteria) this;
        }

        public Criteria andProjectMatchEqualTo(String value) {
            addCriterion("project_match =", value, "projectMatch");
            return (Criteria) this;
        }

        public Criteria andProjectMatchNotEqualTo(String value) {
            addCriterion("project_match <>", value, "projectMatch");
            return (Criteria) this;
        }

        public Criteria andProjectMatchGreaterThan(String value) {
            addCriterion("project_match >", value, "projectMatch");
            return (Criteria) this;
        }

        public Criteria andProjectMatchGreaterThanOrEqualTo(String value) {
            addCriterion("project_match >=", value, "projectMatch");
            return (Criteria) this;
        }

        public Criteria andProjectMatchLessThan(String value) {
            addCriterion("project_match <", value, "projectMatch");
            return (Criteria) this;
        }

        public Criteria andProjectMatchLessThanOrEqualTo(String value) {
            addCriterion("project_match <=", value, "projectMatch");
            return (Criteria) this;
        }

        public Criteria andProjectMatchLike(String value) {
            addCriterion("project_match like", value, "projectMatch");
            return (Criteria) this;
        }

        public Criteria andProjectMatchNotLike(String value) {
            addCriterion("project_match not like", value, "projectMatch");
            return (Criteria) this;
        }

        public Criteria andProjectMatchIn(List<String> values) {
            addCriterion("project_match in", values, "projectMatch");
            return (Criteria) this;
        }

        public Criteria andProjectMatchNotIn(List<String> values) {
            addCriterion("project_match not in", values, "projectMatch");
            return (Criteria) this;
        }

        public Criteria andProjectMatchBetween(String value1, String value2) {
            addCriterion("project_match between", value1, value2, "projectMatch");
            return (Criteria) this;
        }

        public Criteria andProjectMatchNotBetween(String value1, String value2) {
            addCriterion("project_match not between", value1, value2, "projectMatch");
            return (Criteria) this;
        }

        public Criteria andProjectCooperationIsNull() {
            addCriterion("project_cooperation is null");
            return (Criteria) this;
        }

        public Criteria andProjectCooperationIsNotNull() {
            addCriterion("project_cooperation is not null");
            return (Criteria) this;
        }

        public Criteria andProjectCooperationEqualTo(String value) {
            addCriterion("project_cooperation =", value, "projectCooperation");
            return (Criteria) this;
        }

        public Criteria andProjectCooperationNotEqualTo(String value) {
            addCriterion("project_cooperation <>", value, "projectCooperation");
            return (Criteria) this;
        }

        public Criteria andProjectCooperationGreaterThan(String value) {
            addCriterion("project_cooperation >", value, "projectCooperation");
            return (Criteria) this;
        }

        public Criteria andProjectCooperationGreaterThanOrEqualTo(String value) {
            addCriterion("project_cooperation >=", value, "projectCooperation");
            return (Criteria) this;
        }

        public Criteria andProjectCooperationLessThan(String value) {
            addCriterion("project_cooperation <", value, "projectCooperation");
            return (Criteria) this;
        }

        public Criteria andProjectCooperationLessThanOrEqualTo(String value) {
            addCriterion("project_cooperation <=", value, "projectCooperation");
            return (Criteria) this;
        }

        public Criteria andProjectCooperationLike(String value) {
            addCriterion("project_cooperation like", value, "projectCooperation");
            return (Criteria) this;
        }

        public Criteria andProjectCooperationNotLike(String value) {
            addCriterion("project_cooperation not like", value, "projectCooperation");
            return (Criteria) this;
        }

        public Criteria andProjectCooperationIn(List<String> values) {
            addCriterion("project_cooperation in", values, "projectCooperation");
            return (Criteria) this;
        }

        public Criteria andProjectCooperationNotIn(List<String> values) {
            addCriterion("project_cooperation not in", values, "projectCooperation");
            return (Criteria) this;
        }

        public Criteria andProjectCooperationBetween(String value1, String value2) {
            addCriterion("project_cooperation between", value1, value2, "projectCooperation");
            return (Criteria) this;
        }

        public Criteria andProjectCooperationNotBetween(String value1, String value2) {
            addCriterion("project_cooperation not between", value1, value2, "projectCooperation");
            return (Criteria) this;
        }

        public Criteria andProjectActivityIsNull() {
            addCriterion("project_activity is null");
            return (Criteria) this;
        }

        public Criteria andProjectActivityIsNotNull() {
            addCriterion("project_activity is not null");
            return (Criteria) this;
        }

        public Criteria andProjectActivityEqualTo(String value) {
            addCriterion("project_activity =", value, "projectActivity");
            return (Criteria) this;
        }

        public Criteria andProjectActivityNotEqualTo(String value) {
            addCriterion("project_activity <>", value, "projectActivity");
            return (Criteria) this;
        }

        public Criteria andProjectActivityGreaterThan(String value) {
            addCriterion("project_activity >", value, "projectActivity");
            return (Criteria) this;
        }

        public Criteria andProjectActivityGreaterThanOrEqualTo(String value) {
            addCriterion("project_activity >=", value, "projectActivity");
            return (Criteria) this;
        }

        public Criteria andProjectActivityLessThan(String value) {
            addCriterion("project_activity <", value, "projectActivity");
            return (Criteria) this;
        }

        public Criteria andProjectActivityLessThanOrEqualTo(String value) {
            addCriterion("project_activity <=", value, "projectActivity");
            return (Criteria) this;
        }

        public Criteria andProjectActivityLike(String value) {
            addCriterion("project_activity like", value, "projectActivity");
            return (Criteria) this;
        }

        public Criteria andProjectActivityNotLike(String value) {
            addCriterion("project_activity not like", value, "projectActivity");
            return (Criteria) this;
        }

        public Criteria andProjectActivityIn(List<String> values) {
            addCriterion("project_activity in", values, "projectActivity");
            return (Criteria) this;
        }

        public Criteria andProjectActivityNotIn(List<String> values) {
            addCriterion("project_activity not in", values, "projectActivity");
            return (Criteria) this;
        }

        public Criteria andProjectActivityBetween(String value1, String value2) {
            addCriterion("project_activity between", value1, value2, "projectActivity");
            return (Criteria) this;
        }

        public Criteria andProjectActivityNotBetween(String value1, String value2) {
            addCriterion("project_activity not between", value1, value2, "projectActivity");
            return (Criteria) this;
        }

        public Criteria andProjectServiceIsNull() {
            addCriterion("project_service is null");
            return (Criteria) this;
        }

        public Criteria andProjectServiceIsNotNull() {
            addCriterion("project_service is not null");
            return (Criteria) this;
        }

        public Criteria andProjectServiceEqualTo(String value) {
            addCriterion("project_service =", value, "projectService");
            return (Criteria) this;
        }

        public Criteria andProjectServiceNotEqualTo(String value) {
            addCriterion("project_service <>", value, "projectService");
            return (Criteria) this;
        }

        public Criteria andProjectServiceGreaterThan(String value) {
            addCriterion("project_service >", value, "projectService");
            return (Criteria) this;
        }

        public Criteria andProjectServiceGreaterThanOrEqualTo(String value) {
            addCriterion("project_service >=", value, "projectService");
            return (Criteria) this;
        }

        public Criteria andProjectServiceLessThan(String value) {
            addCriterion("project_service <", value, "projectService");
            return (Criteria) this;
        }

        public Criteria andProjectServiceLessThanOrEqualTo(String value) {
            addCriterion("project_service <=", value, "projectService");
            return (Criteria) this;
        }

        public Criteria andProjectServiceLike(String value) {
            addCriterion("project_service like", value, "projectService");
            return (Criteria) this;
        }

        public Criteria andProjectServiceNotLike(String value) {
            addCriterion("project_service not like", value, "projectService");
            return (Criteria) this;
        }

        public Criteria andProjectServiceIn(List<String> values) {
            addCriterion("project_service in", values, "projectService");
            return (Criteria) this;
        }

        public Criteria andProjectServiceNotIn(List<String> values) {
            addCriterion("project_service not in", values, "projectService");
            return (Criteria) this;
        }

        public Criteria andProjectServiceBetween(String value1, String value2) {
            addCriterion("project_service between", value1, value2, "projectService");
            return (Criteria) this;
        }

        public Criteria andProjectServiceNotBetween(String value1, String value2) {
            addCriterion("project_service not between", value1, value2, "projectService");
            return (Criteria) this;
        }

        public Criteria andProjectFinanceIsNull() {
            addCriterion("project_finance is null");
            return (Criteria) this;
        }

        public Criteria andProjectFinanceIsNotNull() {
            addCriterion("project_finance is not null");
            return (Criteria) this;
        }

        public Criteria andProjectFinanceEqualTo(String value) {
            addCriterion("project_finance =", value, "projectFinance");
            return (Criteria) this;
        }

        public Criteria andProjectFinanceNotEqualTo(String value) {
            addCriterion("project_finance <>", value, "projectFinance");
            return (Criteria) this;
        }

        public Criteria andProjectFinanceGreaterThan(String value) {
            addCriterion("project_finance >", value, "projectFinance");
            return (Criteria) this;
        }

        public Criteria andProjectFinanceGreaterThanOrEqualTo(String value) {
            addCriterion("project_finance >=", value, "projectFinance");
            return (Criteria) this;
        }

        public Criteria andProjectFinanceLessThan(String value) {
            addCriterion("project_finance <", value, "projectFinance");
            return (Criteria) this;
        }

        public Criteria andProjectFinanceLessThanOrEqualTo(String value) {
            addCriterion("project_finance <=", value, "projectFinance");
            return (Criteria) this;
        }

        public Criteria andProjectFinanceLike(String value) {
            addCriterion("project_finance like", value, "projectFinance");
            return (Criteria) this;
        }

        public Criteria andProjectFinanceNotLike(String value) {
            addCriterion("project_finance not like", value, "projectFinance");
            return (Criteria) this;
        }

        public Criteria andProjectFinanceIn(List<String> values) {
            addCriterion("project_finance in", values, "projectFinance");
            return (Criteria) this;
        }

        public Criteria andProjectFinanceNotIn(List<String> values) {
            addCriterion("project_finance not in", values, "projectFinance");
            return (Criteria) this;
        }

        public Criteria andProjectFinanceBetween(String value1, String value2) {
            addCriterion("project_finance between", value1, value2, "projectFinance");
            return (Criteria) this;
        }

        public Criteria andProjectFinanceNotBetween(String value1, String value2) {
            addCriterion("project_finance not between", value1, value2, "projectFinance");
            return (Criteria) this;
        }

        public Criteria andProjectIncomeIsNull() {
            addCriterion("project_income is null");
            return (Criteria) this;
        }

        public Criteria andProjectIncomeIsNotNull() {
            addCriterion("project_income is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIncomeEqualTo(String value) {
            addCriterion("project_income =", value, "projectIncome");
            return (Criteria) this;
        }

        public Criteria andProjectIncomeNotEqualTo(String value) {
            addCriterion("project_income <>", value, "projectIncome");
            return (Criteria) this;
        }

        public Criteria andProjectIncomeGreaterThan(String value) {
            addCriterion("project_income >", value, "projectIncome");
            return (Criteria) this;
        }

        public Criteria andProjectIncomeGreaterThanOrEqualTo(String value) {
            addCriterion("project_income >=", value, "projectIncome");
            return (Criteria) this;
        }

        public Criteria andProjectIncomeLessThan(String value) {
            addCriterion("project_income <", value, "projectIncome");
            return (Criteria) this;
        }

        public Criteria andProjectIncomeLessThanOrEqualTo(String value) {
            addCriterion("project_income <=", value, "projectIncome");
            return (Criteria) this;
        }

        public Criteria andProjectIncomeLike(String value) {
            addCriterion("project_income like", value, "projectIncome");
            return (Criteria) this;
        }

        public Criteria andProjectIncomeNotLike(String value) {
            addCriterion("project_income not like", value, "projectIncome");
            return (Criteria) this;
        }

        public Criteria andProjectIncomeIn(List<String> values) {
            addCriterion("project_income in", values, "projectIncome");
            return (Criteria) this;
        }

        public Criteria andProjectIncomeNotIn(List<String> values) {
            addCriterion("project_income not in", values, "projectIncome");
            return (Criteria) this;
        }

        public Criteria andProjectIncomeBetween(String value1, String value2) {
            addCriterion("project_income between", value1, value2, "projectIncome");
            return (Criteria) this;
        }

        public Criteria andProjectIncomeNotBetween(String value1, String value2) {
            addCriterion("project_income not between", value1, value2, "projectIncome");
            return (Criteria) this;
        }

        public Criteria andProjectCompanyIsNull() {
            addCriterion("project_company is null");
            return (Criteria) this;
        }

        public Criteria andProjectCompanyIsNotNull() {
            addCriterion("project_company is not null");
            return (Criteria) this;
        }

        public Criteria andProjectCompanyEqualTo(String value) {
            addCriterion("project_company =", value, "projectCompany");
            return (Criteria) this;
        }

        public Criteria andProjectCompanyNotEqualTo(String value) {
            addCriterion("project_company <>", value, "projectCompany");
            return (Criteria) this;
        }

        public Criteria andProjectCompanyGreaterThan(String value) {
            addCriterion("project_company >", value, "projectCompany");
            return (Criteria) this;
        }

        public Criteria andProjectCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("project_company >=", value, "projectCompany");
            return (Criteria) this;
        }

        public Criteria andProjectCompanyLessThan(String value) {
            addCriterion("project_company <", value, "projectCompany");
            return (Criteria) this;
        }

        public Criteria andProjectCompanyLessThanOrEqualTo(String value) {
            addCriterion("project_company <=", value, "projectCompany");
            return (Criteria) this;
        }

        public Criteria andProjectCompanyLike(String value) {
            addCriterion("project_company like", value, "projectCompany");
            return (Criteria) this;
        }

        public Criteria andProjectCompanyNotLike(String value) {
            addCriterion("project_company not like", value, "projectCompany");
            return (Criteria) this;
        }

        public Criteria andProjectCompanyIn(List<String> values) {
            addCriterion("project_company in", values, "projectCompany");
            return (Criteria) this;
        }

        public Criteria andProjectCompanyNotIn(List<String> values) {
            addCriterion("project_company not in", values, "projectCompany");
            return (Criteria) this;
        }

        public Criteria andProjectCompanyBetween(String value1, String value2) {
            addCriterion("project_company between", value1, value2, "projectCompany");
            return (Criteria) this;
        }

        public Criteria andProjectCompanyNotBetween(String value1, String value2) {
            addCriterion("project_company not between", value1, value2, "projectCompany");
            return (Criteria) this;
        }

        public Criteria andProjectElseInfoIsNull() {
            addCriterion("project_else_info is null");
            return (Criteria) this;
        }

        public Criteria andProjectElseInfoIsNotNull() {
            addCriterion("project_else_info is not null");
            return (Criteria) this;
        }

        public Criteria andProjectElseInfoEqualTo(String value) {
            addCriterion("project_else_info =", value, "projectElseInfo");
            return (Criteria) this;
        }

        public Criteria andProjectElseInfoNotEqualTo(String value) {
            addCriterion("project_else_info <>", value, "projectElseInfo");
            return (Criteria) this;
        }

        public Criteria andProjectElseInfoGreaterThan(String value) {
            addCriterion("project_else_info >", value, "projectElseInfo");
            return (Criteria) this;
        }

        public Criteria andProjectElseInfoGreaterThanOrEqualTo(String value) {
            addCriterion("project_else_info >=", value, "projectElseInfo");
            return (Criteria) this;
        }

        public Criteria andProjectElseInfoLessThan(String value) {
            addCriterion("project_else_info <", value, "projectElseInfo");
            return (Criteria) this;
        }

        public Criteria andProjectElseInfoLessThanOrEqualTo(String value) {
            addCriterion("project_else_info <=", value, "projectElseInfo");
            return (Criteria) this;
        }

        public Criteria andProjectElseInfoLike(String value) {
            addCriterion("project_else_info like", value, "projectElseInfo");
            return (Criteria) this;
        }

        public Criteria andProjectElseInfoNotLike(String value) {
            addCriterion("project_else_info not like", value, "projectElseInfo");
            return (Criteria) this;
        }

        public Criteria andProjectElseInfoIn(List<String> values) {
            addCriterion("project_else_info in", values, "projectElseInfo");
            return (Criteria) this;
        }

        public Criteria andProjectElseInfoNotIn(List<String> values) {
            addCriterion("project_else_info not in", values, "projectElseInfo");
            return (Criteria) this;
        }

        public Criteria andProjectElseInfoBetween(String value1, String value2) {
            addCriterion("project_else_info between", value1, value2, "projectElseInfo");
            return (Criteria) this;
        }

        public Criteria andProjectElseInfoNotBetween(String value1, String value2) {
            addCriterion("project_else_info not between", value1, value2, "projectElseInfo");
            return (Criteria) this;
        }

        public Criteria andProjectActivitiStateIsNull() {
            addCriterion("project_activiti_state is null");
            return (Criteria) this;
        }

        public Criteria andProjectActivitiStateIsNotNull() {
            addCriterion("project_activiti_state is not null");
            return (Criteria) this;
        }

        public Criteria andProjectActivitiStateEqualTo(String value) {
            addCriterion("project_activiti_state =", value, "projectActivitiState");
            return (Criteria) this;
        }

        public Criteria andProjectActivitiStateNotEqualTo(String value) {
            addCriterion("project_activiti_state <>", value, "projectActivitiState");
            return (Criteria) this;
        }

        public Criteria andProjectActivitiStateGreaterThan(String value) {
            addCriterion("project_activiti_state >", value, "projectActivitiState");
            return (Criteria) this;
        }

        public Criteria andProjectActivitiStateGreaterThanOrEqualTo(String value) {
            addCriterion("project_activiti_state >=", value, "projectActivitiState");
            return (Criteria) this;
        }

        public Criteria andProjectActivitiStateLessThan(String value) {
            addCriterion("project_activiti_state <", value, "projectActivitiState");
            return (Criteria) this;
        }

        public Criteria andProjectActivitiStateLessThanOrEqualTo(String value) {
            addCriterion("project_activiti_state <=", value, "projectActivitiState");
            return (Criteria) this;
        }

        public Criteria andProjectActivitiStateLike(String value) {
            addCriterion("project_activiti_state like", value, "projectActivitiState");
            return (Criteria) this;
        }

        public Criteria andProjectActivitiStateNotLike(String value) {
            addCriterion("project_activiti_state not like", value, "projectActivitiState");
            return (Criteria) this;
        }

        public Criteria andProjectActivitiStateIn(List<String> values) {
            addCriterion("project_activiti_state in", values, "projectActivitiState");
            return (Criteria) this;
        }

        public Criteria andProjectActivitiStateNotIn(List<String> values) {
            addCriterion("project_activiti_state not in", values, "projectActivitiState");
            return (Criteria) this;
        }

        public Criteria andProjectActivitiStateBetween(String value1, String value2) {
            addCriterion("project_activiti_state between", value1, value2, "projectActivitiState");
            return (Criteria) this;
        }

        public Criteria andProjectActivitiStateNotBetween(String value1, String value2) {
            addCriterion("project_activiti_state not between", value1, value2, "projectActivitiState");
            return (Criteria) this;
        }

        public Criteria andProjectStateTokenIsNull() {
            addCriterion("project_state_token is null");
            return (Criteria) this;
        }

        public Criteria andProjectStateTokenIsNotNull() {
            addCriterion("project_state_token is not null");
            return (Criteria) this;
        }

        public Criteria andProjectStateTokenEqualTo(String value) {
            addCriterion("project_state_token =", value, "projectStateToken");
            return (Criteria) this;
        }

        public Criteria andProjectStateTokenNotEqualTo(String value) {
            addCriterion("project_state_token <>", value, "projectStateToken");
            return (Criteria) this;
        }

        public Criteria andProjectStateTokenGreaterThan(String value) {
            addCriterion("project_state_token >", value, "projectStateToken");
            return (Criteria) this;
        }

        public Criteria andProjectStateTokenGreaterThanOrEqualTo(String value) {
            addCriterion("project_state_token >=", value, "projectStateToken");
            return (Criteria) this;
        }

        public Criteria andProjectStateTokenLessThan(String value) {
            addCriterion("project_state_token <", value, "projectStateToken");
            return (Criteria) this;
        }

        public Criteria andProjectStateTokenLessThanOrEqualTo(String value) {
            addCriterion("project_state_token <=", value, "projectStateToken");
            return (Criteria) this;
        }

        public Criteria andProjectStateTokenLike(String value) {
            addCriterion("project_state_token like", value, "projectStateToken");
            return (Criteria) this;
        }

        public Criteria andProjectStateTokenNotLike(String value) {
            addCriterion("project_state_token not like", value, "projectStateToken");
            return (Criteria) this;
        }

        public Criteria andProjectStateTokenIn(List<String> values) {
            addCriterion("project_state_token in", values, "projectStateToken");
            return (Criteria) this;
        }

        public Criteria andProjectStateTokenNotIn(List<String> values) {
            addCriterion("project_state_token not in", values, "projectStateToken");
            return (Criteria) this;
        }

        public Criteria andProjectStateTokenBetween(String value1, String value2) {
            addCriterion("project_state_token between", value1, value2, "projectStateToken");
            return (Criteria) this;
        }

        public Criteria andProjectStateTokenNotBetween(String value1, String value2) {
            addCriterion("project_state_token not between", value1, value2, "projectStateToken");
            return (Criteria) this;
        }

        public Criteria andProjectAuditMsgIsNull() {
            addCriterion("project_audit_msg is null");
            return (Criteria) this;
        }

        public Criteria andProjectAuditMsgIsNotNull() {
            addCriterion("project_audit_msg is not null");
            return (Criteria) this;
        }

        public Criteria andProjectAuditMsgEqualTo(String value) {
            addCriterion("project_audit_msg =", value, "projectAuditMsg");
            return (Criteria) this;
        }

        public Criteria andProjectAuditMsgNotEqualTo(String value) {
            addCriterion("project_audit_msg <>", value, "projectAuditMsg");
            return (Criteria) this;
        }

        public Criteria andProjectAuditMsgGreaterThan(String value) {
            addCriterion("project_audit_msg >", value, "projectAuditMsg");
            return (Criteria) this;
        }

        public Criteria andProjectAuditMsgGreaterThanOrEqualTo(String value) {
            addCriterion("project_audit_msg >=", value, "projectAuditMsg");
            return (Criteria) this;
        }

        public Criteria andProjectAuditMsgLessThan(String value) {
            addCriterion("project_audit_msg <", value, "projectAuditMsg");
            return (Criteria) this;
        }

        public Criteria andProjectAuditMsgLessThanOrEqualTo(String value) {
            addCriterion("project_audit_msg <=", value, "projectAuditMsg");
            return (Criteria) this;
        }

        public Criteria andProjectAuditMsgLike(String value) {
            addCriterion("project_audit_msg like", value, "projectAuditMsg");
            return (Criteria) this;
        }

        public Criteria andProjectAuditMsgNotLike(String value) {
            addCriterion("project_audit_msg not like", value, "projectAuditMsg");
            return (Criteria) this;
        }

        public Criteria andProjectAuditMsgIn(List<String> values) {
            addCriterion("project_audit_msg in", values, "projectAuditMsg");
            return (Criteria) this;
        }

        public Criteria andProjectAuditMsgNotIn(List<String> values) {
            addCriterion("project_audit_msg not in", values, "projectAuditMsg");
            return (Criteria) this;
        }

        public Criteria andProjectAuditMsgBetween(String value1, String value2) {
            addCriterion("project_audit_msg between", value1, value2, "projectAuditMsg");
            return (Criteria) this;
        }

        public Criteria andProjectAuditMsgNotBetween(String value1, String value2) {
            addCriterion("project_audit_msg not between", value1, value2, "projectAuditMsg");
            return (Criteria) this;
        }

        public Criteria andPeopleTimeIsNull() {
            addCriterion("people_time is null");
            return (Criteria) this;
        }

        public Criteria andPeopleTimeIsNotNull() {
            addCriterion("people_time is not null");
            return (Criteria) this;
        }

        public Criteria andPeopleTimeEqualTo(Date value) {
            addCriterion("people_time =", value, "peopleTime");
            return (Criteria) this;
        }

        public Criteria andPeopleTimeNotEqualTo(Date value) {
            addCriterion("people_time <>", value, "peopleTime");
            return (Criteria) this;
        }

        public Criteria andPeopleTimeGreaterThan(Date value) {
            addCriterion("people_time >", value, "peopleTime");
            return (Criteria) this;
        }

        public Criteria andPeopleTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("people_time >=", value, "peopleTime");
            return (Criteria) this;
        }

        public Criteria andPeopleTimeLessThan(Date value) {
            addCriterion("people_time <", value, "peopleTime");
            return (Criteria) this;
        }

        public Criteria andPeopleTimeLessThanOrEqualTo(Date value) {
            addCriterion("people_time <=", value, "peopleTime");
            return (Criteria) this;
        }

        public Criteria andPeopleTimeIn(List<Date> values) {
            addCriterion("people_time in", values, "peopleTime");
            return (Criteria) this;
        }

        public Criteria andPeopleTimeNotIn(List<Date> values) {
            addCriterion("people_time not in", values, "peopleTime");
            return (Criteria) this;
        }

        public Criteria andPeopleTimeBetween(Date value1, Date value2) {
            addCriterion("people_time between", value1, value2, "peopleTime");
            return (Criteria) this;
        }

        public Criteria andPeopleTimeNotBetween(Date value1, Date value2) {
            addCriterion("people_time not between", value1, value2, "peopleTime");
            return (Criteria) this;
        }

        public Criteria andMatchTimeIsNull() {
            addCriterion("match_time is null");
            return (Criteria) this;
        }

        public Criteria andMatchTimeIsNotNull() {
            addCriterion("match_time is not null");
            return (Criteria) this;
        }

        public Criteria andMatchTimeEqualTo(Date value) {
            addCriterion("match_time =", value, "matchTime");
            return (Criteria) this;
        }

        public Criteria andMatchTimeNotEqualTo(Date value) {
            addCriterion("match_time <>", value, "matchTime");
            return (Criteria) this;
        }

        public Criteria andMatchTimeGreaterThan(Date value) {
            addCriterion("match_time >", value, "matchTime");
            return (Criteria) this;
        }

        public Criteria andMatchTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("match_time >=", value, "matchTime");
            return (Criteria) this;
        }

        public Criteria andMatchTimeLessThan(Date value) {
            addCriterion("match_time <", value, "matchTime");
            return (Criteria) this;
        }

        public Criteria andMatchTimeLessThanOrEqualTo(Date value) {
            addCriterion("match_time <=", value, "matchTime");
            return (Criteria) this;
        }

        public Criteria andMatchTimeIn(List<Date> values) {
            addCriterion("match_time in", values, "matchTime");
            return (Criteria) this;
        }

        public Criteria andMatchTimeNotIn(List<Date> values) {
            addCriterion("match_time not in", values, "matchTime");
            return (Criteria) this;
        }

        public Criteria andMatchTimeBetween(Date value1, Date value2) {
            addCriterion("match_time between", value1, value2, "matchTime");
            return (Criteria) this;
        }

        public Criteria andMatchTimeNotBetween(Date value1, Date value2) {
            addCriterion("match_time not between", value1, value2, "matchTime");
            return (Criteria) this;
        }

        public Criteria andCooperationTimeIsNull() {
            addCriterion("cooperation_time is null");
            return (Criteria) this;
        }

        public Criteria andCooperationTimeIsNotNull() {
            addCriterion("cooperation_time is not null");
            return (Criteria) this;
        }

        public Criteria andCooperationTimeEqualTo(Date value) {
            addCriterion("cooperation_time =", value, "cooperationTime");
            return (Criteria) this;
        }

        public Criteria andCooperationTimeNotEqualTo(Date value) {
            addCriterion("cooperation_time <>", value, "cooperationTime");
            return (Criteria) this;
        }

        public Criteria andCooperationTimeGreaterThan(Date value) {
            addCriterion("cooperation_time >", value, "cooperationTime");
            return (Criteria) this;
        }

        public Criteria andCooperationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("cooperation_time >=", value, "cooperationTime");
            return (Criteria) this;
        }

        public Criteria andCooperationTimeLessThan(Date value) {
            addCriterion("cooperation_time <", value, "cooperationTime");
            return (Criteria) this;
        }

        public Criteria andCooperationTimeLessThanOrEqualTo(Date value) {
            addCriterion("cooperation_time <=", value, "cooperationTime");
            return (Criteria) this;
        }

        public Criteria andCooperationTimeIn(List<Date> values) {
            addCriterion("cooperation_time in", values, "cooperationTime");
            return (Criteria) this;
        }

        public Criteria andCooperationTimeNotIn(List<Date> values) {
            addCriterion("cooperation_time not in", values, "cooperationTime");
            return (Criteria) this;
        }

        public Criteria andCooperationTimeBetween(Date value1, Date value2) {
            addCriterion("cooperation_time between", value1, value2, "cooperationTime");
            return (Criteria) this;
        }

        public Criteria andCooperationTimeNotBetween(Date value1, Date value2) {
            addCriterion("cooperation_time not between", value1, value2, "cooperationTime");
            return (Criteria) this;
        }

        public Criteria andActivityTimeIsNull() {
            addCriterion("activity_time is null");
            return (Criteria) this;
        }

        public Criteria andActivityTimeIsNotNull() {
            addCriterion("activity_time is not null");
            return (Criteria) this;
        }

        public Criteria andActivityTimeEqualTo(Date value) {
            addCriterion("activity_time =", value, "activityTime");
            return (Criteria) this;
        }

        public Criteria andActivityTimeNotEqualTo(Date value) {
            addCriterion("activity_time <>", value, "activityTime");
            return (Criteria) this;
        }

        public Criteria andActivityTimeGreaterThan(Date value) {
            addCriterion("activity_time >", value, "activityTime");
            return (Criteria) this;
        }

        public Criteria andActivityTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activity_time >=", value, "activityTime");
            return (Criteria) this;
        }

        public Criteria andActivityTimeLessThan(Date value) {
            addCriterion("activity_time <", value, "activityTime");
            return (Criteria) this;
        }

        public Criteria andActivityTimeLessThanOrEqualTo(Date value) {
            addCriterion("activity_time <=", value, "activityTime");
            return (Criteria) this;
        }

        public Criteria andActivityTimeIn(List<Date> values) {
            addCriterion("activity_time in", values, "activityTime");
            return (Criteria) this;
        }

        public Criteria andActivityTimeNotIn(List<Date> values) {
            addCriterion("activity_time not in", values, "activityTime");
            return (Criteria) this;
        }

        public Criteria andActivityTimeBetween(Date value1, Date value2) {
            addCriterion("activity_time between", value1, value2, "activityTime");
            return (Criteria) this;
        }

        public Criteria andActivityTimeNotBetween(Date value1, Date value2) {
            addCriterion("activity_time not between", value1, value2, "activityTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeIsNull() {
            addCriterion("service_time is null");
            return (Criteria) this;
        }

        public Criteria andServiceTimeIsNotNull() {
            addCriterion("service_time is not null");
            return (Criteria) this;
        }

        public Criteria andServiceTimeEqualTo(Date value) {
            addCriterion("service_time =", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeNotEqualTo(Date value) {
            addCriterion("service_time <>", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeGreaterThan(Date value) {
            addCriterion("service_time >", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("service_time >=", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeLessThan(Date value) {
            addCriterion("service_time <", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeLessThanOrEqualTo(Date value) {
            addCriterion("service_time <=", value, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeIn(List<Date> values) {
            addCriterion("service_time in", values, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeNotIn(List<Date> values) {
            addCriterion("service_time not in", values, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeBetween(Date value1, Date value2) {
            addCriterion("service_time between", value1, value2, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andServiceTimeNotBetween(Date value1, Date value2) {
            addCriterion("service_time not between", value1, value2, "serviceTime");
            return (Criteria) this;
        }

        public Criteria andFinanceTimeIsNull() {
            addCriterion("finance_time is null");
            return (Criteria) this;
        }

        public Criteria andFinanceTimeIsNotNull() {
            addCriterion("finance_time is not null");
            return (Criteria) this;
        }

        public Criteria andFinanceTimeEqualTo(Date value) {
            addCriterion("finance_time =", value, "financeTime");
            return (Criteria) this;
        }

        public Criteria andFinanceTimeNotEqualTo(Date value) {
            addCriterion("finance_time <>", value, "financeTime");
            return (Criteria) this;
        }

        public Criteria andFinanceTimeGreaterThan(Date value) {
            addCriterion("finance_time >", value, "financeTime");
            return (Criteria) this;
        }

        public Criteria andFinanceTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("finance_time >=", value, "financeTime");
            return (Criteria) this;
        }

        public Criteria andFinanceTimeLessThan(Date value) {
            addCriterion("finance_time <", value, "financeTime");
            return (Criteria) this;
        }

        public Criteria andFinanceTimeLessThanOrEqualTo(Date value) {
            addCriterion("finance_time <=", value, "financeTime");
            return (Criteria) this;
        }

        public Criteria andFinanceTimeIn(List<Date> values) {
            addCriterion("finance_time in", values, "financeTime");
            return (Criteria) this;
        }

        public Criteria andFinanceTimeNotIn(List<Date> values) {
            addCriterion("finance_time not in", values, "financeTime");
            return (Criteria) this;
        }

        public Criteria andFinanceTimeBetween(Date value1, Date value2) {
            addCriterion("finance_time between", value1, value2, "financeTime");
            return (Criteria) this;
        }

        public Criteria andFinanceTimeNotBetween(Date value1, Date value2) {
            addCriterion("finance_time not between", value1, value2, "financeTime");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeIsNull() {
            addCriterion("income_time is null");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeIsNotNull() {
            addCriterion("income_time is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeEqualTo(Date value) {
            addCriterion("income_time =", value, "incomeTime");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeNotEqualTo(Date value) {
            addCriterion("income_time <>", value, "incomeTime");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeGreaterThan(Date value) {
            addCriterion("income_time >", value, "incomeTime");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("income_time >=", value, "incomeTime");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeLessThan(Date value) {
            addCriterion("income_time <", value, "incomeTime");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeLessThanOrEqualTo(Date value) {
            addCriterion("income_time <=", value, "incomeTime");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeIn(List<Date> values) {
            addCriterion("income_time in", values, "incomeTime");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeNotIn(List<Date> values) {
            addCriterion("income_time not in", values, "incomeTime");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeBetween(Date value1, Date value2) {
            addCriterion("income_time between", value1, value2, "incomeTime");
            return (Criteria) this;
        }

        public Criteria andIncomeTimeNotBetween(Date value1, Date value2) {
            addCriterion("income_time not between", value1, value2, "incomeTime");
            return (Criteria) this;
        }

        public Criteria andCompanyTimeIsNull() {
            addCriterion("company_time is null");
            return (Criteria) this;
        }

        public Criteria andCompanyTimeIsNotNull() {
            addCriterion("company_time is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyTimeEqualTo(Date value) {
            addCriterion("company_time =", value, "companyTime");
            return (Criteria) this;
        }

        public Criteria andCompanyTimeNotEqualTo(Date value) {
            addCriterion("company_time <>", value, "companyTime");
            return (Criteria) this;
        }

        public Criteria andCompanyTimeGreaterThan(Date value) {
            addCriterion("company_time >", value, "companyTime");
            return (Criteria) this;
        }

        public Criteria andCompanyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("company_time >=", value, "companyTime");
            return (Criteria) this;
        }

        public Criteria andCompanyTimeLessThan(Date value) {
            addCriterion("company_time <", value, "companyTime");
            return (Criteria) this;
        }

        public Criteria andCompanyTimeLessThanOrEqualTo(Date value) {
            addCriterion("company_time <=", value, "companyTime");
            return (Criteria) this;
        }

        public Criteria andCompanyTimeIn(List<Date> values) {
            addCriterion("company_time in", values, "companyTime");
            return (Criteria) this;
        }

        public Criteria andCompanyTimeNotIn(List<Date> values) {
            addCriterion("company_time not in", values, "companyTime");
            return (Criteria) this;
        }

        public Criteria andCompanyTimeBetween(Date value1, Date value2) {
            addCriterion("company_time between", value1, value2, "companyTime");
            return (Criteria) this;
        }

        public Criteria andCompanyTimeNotBetween(Date value1, Date value2) {
            addCriterion("company_time not between", value1, value2, "companyTime");
            return (Criteria) this;
        }

        public Criteria andElseInfoTimeIsNull() {
            addCriterion("else_info_time is null");
            return (Criteria) this;
        }

        public Criteria andElseInfoTimeIsNotNull() {
            addCriterion("else_info_time is not null");
            return (Criteria) this;
        }

        public Criteria andElseInfoTimeEqualTo(Date value) {
            addCriterion("else_info_time =", value, "elseInfoTime");
            return (Criteria) this;
        }

        public Criteria andElseInfoTimeNotEqualTo(Date value) {
            addCriterion("else_info_time <>", value, "elseInfoTime");
            return (Criteria) this;
        }

        public Criteria andElseInfoTimeGreaterThan(Date value) {
            addCriterion("else_info_time >", value, "elseInfoTime");
            return (Criteria) this;
        }

        public Criteria andElseInfoTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("else_info_time >=", value, "elseInfoTime");
            return (Criteria) this;
        }

        public Criteria andElseInfoTimeLessThan(Date value) {
            addCriterion("else_info_time <", value, "elseInfoTime");
            return (Criteria) this;
        }

        public Criteria andElseInfoTimeLessThanOrEqualTo(Date value) {
            addCriterion("else_info_time <=", value, "elseInfoTime");
            return (Criteria) this;
        }

        public Criteria andElseInfoTimeIn(List<Date> values) {
            addCriterion("else_info_time in", values, "elseInfoTime");
            return (Criteria) this;
        }

        public Criteria andElseInfoTimeNotIn(List<Date> values) {
            addCriterion("else_info_time not in", values, "elseInfoTime");
            return (Criteria) this;
        }

        public Criteria andElseInfoTimeBetween(Date value1, Date value2) {
            addCriterion("else_info_time between", value1, value2, "elseInfoTime");
            return (Criteria) this;
        }

        public Criteria andElseInfoTimeNotBetween(Date value1, Date value2) {
            addCriterion("else_info_time not between", value1, value2, "elseInfoTime");
            return (Criteria) this;
        }

        public Criteria andProjectPeopleNewIsNull() {
            addCriterion("project_people_new is null");
            return (Criteria) this;
        }

        public Criteria andProjectPeopleNewIsNotNull() {
            addCriterion("project_people_new is not null");
            return (Criteria) this;
        }

        public Criteria andProjectPeopleNewEqualTo(String value) {
            addCriterion("project_people_new =", value, "projectPeopleNew");
            return (Criteria) this;
        }

        public Criteria andProjectPeopleNewNotEqualTo(String value) {
            addCriterion("project_people_new <>", value, "projectPeopleNew");
            return (Criteria) this;
        }

        public Criteria andProjectPeopleNewGreaterThan(String value) {
            addCriterion("project_people_new >", value, "projectPeopleNew");
            return (Criteria) this;
        }

        public Criteria andProjectPeopleNewGreaterThanOrEqualTo(String value) {
            addCriterion("project_people_new >=", value, "projectPeopleNew");
            return (Criteria) this;
        }

        public Criteria andProjectPeopleNewLessThan(String value) {
            addCriterion("project_people_new <", value, "projectPeopleNew");
            return (Criteria) this;
        }

        public Criteria andProjectPeopleNewLessThanOrEqualTo(String value) {
            addCriterion("project_people_new <=", value, "projectPeopleNew");
            return (Criteria) this;
        }

        public Criteria andProjectPeopleNewLike(String value) {
            addCriterion("project_people_new like", value, "projectPeopleNew");
            return (Criteria) this;
        }

        public Criteria andProjectPeopleNewNotLike(String value) {
            addCriterion("project_people_new not like", value, "projectPeopleNew");
            return (Criteria) this;
        }

        public Criteria andProjectPeopleNewIn(List<String> values) {
            addCriterion("project_people_new in", values, "projectPeopleNew");
            return (Criteria) this;
        }

        public Criteria andProjectPeopleNewNotIn(List<String> values) {
            addCriterion("project_people_new not in", values, "projectPeopleNew");
            return (Criteria) this;
        }

        public Criteria andProjectPeopleNewBetween(String value1, String value2) {
            addCriterion("project_people_new between", value1, value2, "projectPeopleNew");
            return (Criteria) this;
        }

        public Criteria andProjectPeopleNewNotBetween(String value1, String value2) {
            addCriterion("project_people_new not between", value1, value2, "projectPeopleNew");
            return (Criteria) this;
        }

        public Criteria andIsGoingIsNull() {
            addCriterion("is_going is null");
            return (Criteria) this;
        }

        public Criteria andIsGoingIsNotNull() {
            addCriterion("is_going is not null");
            return (Criteria) this;
        }

        public Criteria andIsGoingEqualTo(String value) {
            addCriterion("is_going =", value, "isGoing");
            return (Criteria) this;
        }

        public Criteria andIsGoingNotEqualTo(String value) {
            addCriterion("is_going <>", value, "isGoing");
            return (Criteria) this;
        }

        public Criteria andIsGoingGreaterThan(String value) {
            addCriterion("is_going >", value, "isGoing");
            return (Criteria) this;
        }

        public Criteria andIsGoingGreaterThanOrEqualTo(String value) {
            addCriterion("is_going >=", value, "isGoing");
            return (Criteria) this;
        }

        public Criteria andIsGoingLessThan(String value) {
            addCriterion("is_going <", value, "isGoing");
            return (Criteria) this;
        }

        public Criteria andIsGoingLessThanOrEqualTo(String value) {
            addCriterion("is_going <=", value, "isGoing");
            return (Criteria) this;
        }

        public Criteria andIsGoingLike(String value) {
            addCriterion("is_going like", value, "isGoing");
            return (Criteria) this;
        }

        public Criteria andIsGoingNotLike(String value) {
            addCriterion("is_going not like", value, "isGoing");
            return (Criteria) this;
        }

        public Criteria andIsGoingIn(List<String> values) {
            addCriterion("is_going in", values, "isGoing");
            return (Criteria) this;
        }

        public Criteria andIsGoingNotIn(List<String> values) {
            addCriterion("is_going not in", values, "isGoing");
            return (Criteria) this;
        }

        public Criteria andIsGoingBetween(String value1, String value2) {
            addCriterion("is_going between", value1, value2, "isGoing");
            return (Criteria) this;
        }

        public Criteria andIsGoingNotBetween(String value1, String value2) {
            addCriterion("is_going not between", value1, value2, "isGoing");
            return (Criteria) this;
        }

        public Criteria andFollowDateIsNull() {
            addCriterion("follow_date is null");
            return (Criteria) this;
        }

        public Criteria andFollowDateIsNotNull() {
            addCriterion("follow_date is not null");
            return (Criteria) this;
        }

        public Criteria andFollowDateEqualTo(Date value) {
            addCriterion("follow_date =", value, "followDate");
            return (Criteria) this;
        }

        public Criteria andFollowDateNotEqualTo(Date value) {
            addCriterion("follow_date <>", value, "followDate");
            return (Criteria) this;
        }

        public Criteria andFollowDateGreaterThan(Date value) {
            addCriterion("follow_date >", value, "followDate");
            return (Criteria) this;
        }

        public Criteria andFollowDateGreaterThanOrEqualTo(Date value) {
            addCriterion("follow_date >=", value, "followDate");
            return (Criteria) this;
        }

        public Criteria andFollowDateLessThan(Date value) {
            addCriterion("follow_date <", value, "followDate");
            return (Criteria) this;
        }

        public Criteria andFollowDateLessThanOrEqualTo(Date value) {
            addCriterion("follow_date <=", value, "followDate");
            return (Criteria) this;
        }

        public Criteria andFollowDateIn(List<Date> values) {
            addCriterion("follow_date in", values, "followDate");
            return (Criteria) this;
        }

        public Criteria andFollowDateNotIn(List<Date> values) {
            addCriterion("follow_date not in", values, "followDate");
            return (Criteria) this;
        }

        public Criteria andFollowDateBetween(Date value1, Date value2) {
            addCriterion("follow_date between", value1, value2, "followDate");
            return (Criteria) this;
        }

        public Criteria andFollowDateNotBetween(Date value1, Date value2) {
            addCriterion("follow_date not between", value1, value2, "followDate");
            return (Criteria) this;
        }

        public Criteria andMyFollowIsNull() {
            addCriterion("my_follow is null");
            return (Criteria) this;
        }

        public Criteria andMyFollowIsNotNull() {
            addCriterion("my_follow is not null");
            return (Criteria) this;
        }

        public Criteria andMyFollowEqualTo(String value) {
            addCriterion("my_follow =", value, "myFollow");
            return (Criteria) this;
        }

        public Criteria andMyFollowNotEqualTo(String value) {
            addCriterion("my_follow <>", value, "myFollow");
            return (Criteria) this;
        }

        public Criteria andMyFollowGreaterThan(String value) {
            addCriterion("my_follow >", value, "myFollow");
            return (Criteria) this;
        }

        public Criteria andMyFollowGreaterThanOrEqualTo(String value) {
            addCriterion("my_follow >=", value, "myFollow");
            return (Criteria) this;
        }

        public Criteria andMyFollowLessThan(String value) {
            addCriterion("my_follow <", value, "myFollow");
            return (Criteria) this;
        }

        public Criteria andMyFollowLessThanOrEqualTo(String value) {
            addCriterion("my_follow <=", value, "myFollow");
            return (Criteria) this;
        }

        public Criteria andMyFollowLike(String value) {
            addCriterion("my_follow like", value, "myFollow");
            return (Criteria) this;
        }

        public Criteria andMyFollowNotLike(String value) {
            addCriterion("my_follow not like", value, "myFollow");
            return (Criteria) this;
        }

        public Criteria andMyFollowIn(List<String> values) {
            addCriterion("my_follow in", values, "myFollow");
            return (Criteria) this;
        }

        public Criteria andMyFollowNotIn(List<String> values) {
            addCriterion("my_follow not in", values, "myFollow");
            return (Criteria) this;
        }

        public Criteria andMyFollowBetween(String value1, String value2) {
            addCriterion("my_follow between", value1, value2, "myFollow");
            return (Criteria) this;
        }

        public Criteria andMyFollowNotBetween(String value1, String value2) {
            addCriterion("my_follow not between", value1, value2, "myFollow");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andSupervisorIdIsNull() {
            addCriterion("supervisor_id is null");
            return (Criteria) this;
        }

        public Criteria andSupervisorIdIsNotNull() {
            addCriterion("supervisor_id is not null");
            return (Criteria) this;
        }

        public Criteria andSupervisorIdEqualTo(Long value) {
            addCriterion("supervisor_id =", value, "supervisorId");
            return (Criteria) this;
        }

        public Criteria andSupervisorIdNotEqualTo(Long value) {
            addCriterion("supervisor_id <>", value, "supervisorId");
            return (Criteria) this;
        }

        public Criteria andSupervisorIdGreaterThan(Long value) {
            addCriterion("supervisor_id >", value, "supervisorId");
            return (Criteria) this;
        }

        public Criteria andSupervisorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("supervisor_id >=", value, "supervisorId");
            return (Criteria) this;
        }

        public Criteria andSupervisorIdLessThan(Long value) {
            addCriterion("supervisor_id <", value, "supervisorId");
            return (Criteria) this;
        }

        public Criteria andSupervisorIdLessThanOrEqualTo(Long value) {
            addCriterion("supervisor_id <=", value, "supervisorId");
            return (Criteria) this;
        }

        public Criteria andSupervisorIdIn(List<Long> values) {
            addCriterion("supervisor_id in", values, "supervisorId");
            return (Criteria) this;
        }

        public Criteria andSupervisorIdNotIn(List<Long> values) {
            addCriterion("supervisor_id not in", values, "supervisorId");
            return (Criteria) this;
        }

        public Criteria andSupervisorIdBetween(Long value1, Long value2) {
            addCriterion("supervisor_id between", value1, value2, "supervisorId");
            return (Criteria) this;
        }

        public Criteria andSupervisorIdNotBetween(Long value1, Long value2) {
            addCriterion("supervisor_id not between", value1, value2, "supervisorId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}