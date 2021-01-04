package com.shu.copartner.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProLogExample() {
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

        public Criteria andLogIdIsNull() {
            addCriterion("log_id is null");
            return (Criteria) this;
        }

        public Criteria andLogIdIsNotNull() {
            addCriterion("log_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogIdEqualTo(Long value) {
            addCriterion("log_id =", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotEqualTo(Long value) {
            addCriterion("log_id <>", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThan(Long value) {
            addCriterion("log_id >", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThanOrEqualTo(Long value) {
            addCriterion("log_id >=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThan(Long value) {
            addCriterion("log_id <", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThanOrEqualTo(Long value) {
            addCriterion("log_id <=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdIn(List<Long> values) {
            addCriterion("log_id in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotIn(List<Long> values) {
            addCriterion("log_id not in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdBetween(Long value1, Long value2) {
            addCriterion("log_id between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotBetween(Long value1, Long value2) {
            addCriterion("log_id not between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andLogTypeIsNull() {
            addCriterion("log_type is null");
            return (Criteria) this;
        }

        public Criteria andLogTypeIsNotNull() {
            addCriterion("log_type is not null");
            return (Criteria) this;
        }

        public Criteria andLogTypeEqualTo(String value) {
            addCriterion("log_type =", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotEqualTo(String value) {
            addCriterion("log_type <>", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeGreaterThan(String value) {
            addCriterion("log_type >", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeGreaterThanOrEqualTo(String value) {
            addCriterion("log_type >=", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLessThan(String value) {
            addCriterion("log_type <", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLessThanOrEqualTo(String value) {
            addCriterion("log_type <=", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeLike(String value) {
            addCriterion("log_type like", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotLike(String value) {
            addCriterion("log_type not like", value, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeIn(List<String> values) {
            addCriterion("log_type in", values, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotIn(List<String> values) {
            addCriterion("log_type not in", values, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeBetween(String value1, String value2) {
            addCriterion("log_type between", value1, value2, "logType");
            return (Criteria) this;
        }

        public Criteria andLogTypeNotBetween(String value1, String value2) {
            addCriterion("log_type not between", value1, value2, "logType");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
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

        public Criteria andLogOperatorIsNull() {
            addCriterion("log_operator is null");
            return (Criteria) this;
        }

        public Criteria andLogOperatorIsNotNull() {
            addCriterion("log_operator is not null");
            return (Criteria) this;
        }

        public Criteria andLogOperatorEqualTo(String value) {
            addCriterion("log_operator =", value, "logOperator");
            return (Criteria) this;
        }

        public Criteria andLogOperatorNotEqualTo(String value) {
            addCriterion("log_operator <>", value, "logOperator");
            return (Criteria) this;
        }

        public Criteria andLogOperatorGreaterThan(String value) {
            addCriterion("log_operator >", value, "logOperator");
            return (Criteria) this;
        }

        public Criteria andLogOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("log_operator >=", value, "logOperator");
            return (Criteria) this;
        }

        public Criteria andLogOperatorLessThan(String value) {
            addCriterion("log_operator <", value, "logOperator");
            return (Criteria) this;
        }

        public Criteria andLogOperatorLessThanOrEqualTo(String value) {
            addCriterion("log_operator <=", value, "logOperator");
            return (Criteria) this;
        }

        public Criteria andLogOperatorLike(String value) {
            addCriterion("log_operator like", value, "logOperator");
            return (Criteria) this;
        }

        public Criteria andLogOperatorNotLike(String value) {
            addCriterion("log_operator not like", value, "logOperator");
            return (Criteria) this;
        }

        public Criteria andLogOperatorIn(List<String> values) {
            addCriterion("log_operator in", values, "logOperator");
            return (Criteria) this;
        }

        public Criteria andLogOperatorNotIn(List<String> values) {
            addCriterion("log_operator not in", values, "logOperator");
            return (Criteria) this;
        }

        public Criteria andLogOperatorBetween(String value1, String value2) {
            addCriterion("log_operator between", value1, value2, "logOperator");
            return (Criteria) this;
        }

        public Criteria andLogOperatorNotBetween(String value1, String value2) {
            addCriterion("log_operator not between", value1, value2, "logOperator");
            return (Criteria) this;
        }

        public Criteria andLogSupervisorIdIsNull() {
            addCriterion("log_supervisor_id is null");
            return (Criteria) this;
        }

        public Criteria andLogSupervisorIdIsNotNull() {
            addCriterion("log_supervisor_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogSupervisorIdEqualTo(Long value) {
            addCriterion("log_supervisor_id =", value, "logSupervisorId");
            return (Criteria) this;
        }

        public Criteria andLogSupervisorIdNotEqualTo(Long value) {
            addCriterion("log_supervisor_id <>", value, "logSupervisorId");
            return (Criteria) this;
        }

        public Criteria andLogSupervisorIdGreaterThan(Long value) {
            addCriterion("log_supervisor_id >", value, "logSupervisorId");
            return (Criteria) this;
        }

        public Criteria andLogSupervisorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("log_supervisor_id >=", value, "logSupervisorId");
            return (Criteria) this;
        }

        public Criteria andLogSupervisorIdLessThan(Long value) {
            addCriterion("log_supervisor_id <", value, "logSupervisorId");
            return (Criteria) this;
        }

        public Criteria andLogSupervisorIdLessThanOrEqualTo(Long value) {
            addCriterion("log_supervisor_id <=", value, "logSupervisorId");
            return (Criteria) this;
        }

        public Criteria andLogSupervisorIdIn(List<Long> values) {
            addCriterion("log_supervisor_id in", values, "logSupervisorId");
            return (Criteria) this;
        }

        public Criteria andLogSupervisorIdNotIn(List<Long> values) {
            addCriterion("log_supervisor_id not in", values, "logSupervisorId");
            return (Criteria) this;
        }

        public Criteria andLogSupervisorIdBetween(Long value1, Long value2) {
            addCriterion("log_supervisor_id between", value1, value2, "logSupervisorId");
            return (Criteria) this;
        }

        public Criteria andLogSupervisorIdNotBetween(Long value1, Long value2) {
            addCriterion("log_supervisor_id not between", value1, value2, "logSupervisorId");
            return (Criteria) this;
        }

        public Criteria andLogSupervisorNameIsNull() {
            addCriterion("log_supervisor_name is null");
            return (Criteria) this;
        }

        public Criteria andLogSupervisorNameIsNotNull() {
            addCriterion("log_supervisor_name is not null");
            return (Criteria) this;
        }

        public Criteria andLogSupervisorNameEqualTo(String value) {
            addCriterion("log_supervisor_name =", value, "logSupervisorName");
            return (Criteria) this;
        }

        public Criteria andLogSupervisorNameNotEqualTo(String value) {
            addCriterion("log_supervisor_name <>", value, "logSupervisorName");
            return (Criteria) this;
        }

        public Criteria andLogSupervisorNameGreaterThan(String value) {
            addCriterion("log_supervisor_name >", value, "logSupervisorName");
            return (Criteria) this;
        }

        public Criteria andLogSupervisorNameGreaterThanOrEqualTo(String value) {
            addCriterion("log_supervisor_name >=", value, "logSupervisorName");
            return (Criteria) this;
        }

        public Criteria andLogSupervisorNameLessThan(String value) {
            addCriterion("log_supervisor_name <", value, "logSupervisorName");
            return (Criteria) this;
        }

        public Criteria andLogSupervisorNameLessThanOrEqualTo(String value) {
            addCriterion("log_supervisor_name <=", value, "logSupervisorName");
            return (Criteria) this;
        }

        public Criteria andLogSupervisorNameLike(String value) {
            addCriterion("log_supervisor_name like", value, "logSupervisorName");
            return (Criteria) this;
        }

        public Criteria andLogSupervisorNameNotLike(String value) {
            addCriterion("log_supervisor_name not like", value, "logSupervisorName");
            return (Criteria) this;
        }

        public Criteria andLogSupervisorNameIn(List<String> values) {
            addCriterion("log_supervisor_name in", values, "logSupervisorName");
            return (Criteria) this;
        }

        public Criteria andLogSupervisorNameNotIn(List<String> values) {
            addCriterion("log_supervisor_name not in", values, "logSupervisorName");
            return (Criteria) this;
        }

        public Criteria andLogSupervisorNameBetween(String value1, String value2) {
            addCriterion("log_supervisor_name between", value1, value2, "logSupervisorName");
            return (Criteria) this;
        }

        public Criteria andLogSupervisorNameNotBetween(String value1, String value2) {
            addCriterion("log_supervisor_name not between", value1, value2, "logSupervisorName");
            return (Criteria) this;
        }

        public Criteria andLogSupervisorAchievementIsNull() {
            addCriterion("log_supervisor_achievement is null");
            return (Criteria) this;
        }

        public Criteria andLogSupervisorAchievementIsNotNull() {
            addCriterion("log_supervisor_achievement is not null");
            return (Criteria) this;
        }

        public Criteria andLogSupervisorAchievementEqualTo(String value) {
            addCriterion("log_supervisor_achievement =", value, "logSupervisorAchievement");
            return (Criteria) this;
        }

        public Criteria andLogSupervisorAchievementNotEqualTo(String value) {
            addCriterion("log_supervisor_achievement <>", value, "logSupervisorAchievement");
            return (Criteria) this;
        }

        public Criteria andLogSupervisorAchievementGreaterThan(String value) {
            addCriterion("log_supervisor_achievement >", value, "logSupervisorAchievement");
            return (Criteria) this;
        }

        public Criteria andLogSupervisorAchievementGreaterThanOrEqualTo(String value) {
            addCriterion("log_supervisor_achievement >=", value, "logSupervisorAchievement");
            return (Criteria) this;
        }

        public Criteria andLogSupervisorAchievementLessThan(String value) {
            addCriterion("log_supervisor_achievement <", value, "logSupervisorAchievement");
            return (Criteria) this;
        }

        public Criteria andLogSupervisorAchievementLessThanOrEqualTo(String value) {
            addCriterion("log_supervisor_achievement <=", value, "logSupervisorAchievement");
            return (Criteria) this;
        }

        public Criteria andLogSupervisorAchievementLike(String value) {
            addCriterion("log_supervisor_achievement like", value, "logSupervisorAchievement");
            return (Criteria) this;
        }

        public Criteria andLogSupervisorAchievementNotLike(String value) {
            addCriterion("log_supervisor_achievement not like", value, "logSupervisorAchievement");
            return (Criteria) this;
        }

        public Criteria andLogSupervisorAchievementIn(List<String> values) {
            addCriterion("log_supervisor_achievement in", values, "logSupervisorAchievement");
            return (Criteria) this;
        }

        public Criteria andLogSupervisorAchievementNotIn(List<String> values) {
            addCriterion("log_supervisor_achievement not in", values, "logSupervisorAchievement");
            return (Criteria) this;
        }

        public Criteria andLogSupervisorAchievementBetween(String value1, String value2) {
            addCriterion("log_supervisor_achievement between", value1, value2, "logSupervisorAchievement");
            return (Criteria) this;
        }

        public Criteria andLogSupervisorAchievementNotBetween(String value1, String value2) {
            addCriterion("log_supervisor_achievement not between", value1, value2, "logSupervisorAchievement");
            return (Criteria) this;
        }

        public Criteria andLogProjectIdIsNull() {
            addCriterion("log_project_id is null");
            return (Criteria) this;
        }

        public Criteria andLogProjectIdIsNotNull() {
            addCriterion("log_project_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogProjectIdEqualTo(Long value) {
            addCriterion("log_project_id =", value, "logProjectId");
            return (Criteria) this;
        }

        public Criteria andLogProjectIdNotEqualTo(Long value) {
            addCriterion("log_project_id <>", value, "logProjectId");
            return (Criteria) this;
        }

        public Criteria andLogProjectIdGreaterThan(Long value) {
            addCriterion("log_project_id >", value, "logProjectId");
            return (Criteria) this;
        }

        public Criteria andLogProjectIdGreaterThanOrEqualTo(Long value) {
            addCriterion("log_project_id >=", value, "logProjectId");
            return (Criteria) this;
        }

        public Criteria andLogProjectIdLessThan(Long value) {
            addCriterion("log_project_id <", value, "logProjectId");
            return (Criteria) this;
        }

        public Criteria andLogProjectIdLessThanOrEqualTo(Long value) {
            addCriterion("log_project_id <=", value, "logProjectId");
            return (Criteria) this;
        }

        public Criteria andLogProjectIdIn(List<Long> values) {
            addCriterion("log_project_id in", values, "logProjectId");
            return (Criteria) this;
        }

        public Criteria andLogProjectIdNotIn(List<Long> values) {
            addCriterion("log_project_id not in", values, "logProjectId");
            return (Criteria) this;
        }

        public Criteria andLogProjectIdBetween(Long value1, Long value2) {
            addCriterion("log_project_id between", value1, value2, "logProjectId");
            return (Criteria) this;
        }

        public Criteria andLogProjectIdNotBetween(Long value1, Long value2) {
            addCriterion("log_project_id not between", value1, value2, "logProjectId");
            return (Criteria) this;
        }

        public Criteria andLogProjectNameIsNull() {
            addCriterion("log_project_name is null");
            return (Criteria) this;
        }

        public Criteria andLogProjectNameIsNotNull() {
            addCriterion("log_project_name is not null");
            return (Criteria) this;
        }

        public Criteria andLogProjectNameEqualTo(String value) {
            addCriterion("log_project_name =", value, "logProjectName");
            return (Criteria) this;
        }

        public Criteria andLogProjectNameNotEqualTo(String value) {
            addCriterion("log_project_name <>", value, "logProjectName");
            return (Criteria) this;
        }

        public Criteria andLogProjectNameGreaterThan(String value) {
            addCriterion("log_project_name >", value, "logProjectName");
            return (Criteria) this;
        }

        public Criteria andLogProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("log_project_name >=", value, "logProjectName");
            return (Criteria) this;
        }

        public Criteria andLogProjectNameLessThan(String value) {
            addCriterion("log_project_name <", value, "logProjectName");
            return (Criteria) this;
        }

        public Criteria andLogProjectNameLessThanOrEqualTo(String value) {
            addCriterion("log_project_name <=", value, "logProjectName");
            return (Criteria) this;
        }

        public Criteria andLogProjectNameLike(String value) {
            addCriterion("log_project_name like", value, "logProjectName");
            return (Criteria) this;
        }

        public Criteria andLogProjectNameNotLike(String value) {
            addCriterion("log_project_name not like", value, "logProjectName");
            return (Criteria) this;
        }

        public Criteria andLogProjectNameIn(List<String> values) {
            addCriterion("log_project_name in", values, "logProjectName");
            return (Criteria) this;
        }

        public Criteria andLogProjectNameNotIn(List<String> values) {
            addCriterion("log_project_name not in", values, "logProjectName");
            return (Criteria) this;
        }

        public Criteria andLogProjectNameBetween(String value1, String value2) {
            addCriterion("log_project_name between", value1, value2, "logProjectName");
            return (Criteria) this;
        }

        public Criteria andLogProjectNameNotBetween(String value1, String value2) {
            addCriterion("log_project_name not between", value1, value2, "logProjectName");
            return (Criteria) this;
        }

        public Criteria andLogProjectDescriptionIsNull() {
            addCriterion("log_project_description is null");
            return (Criteria) this;
        }

        public Criteria andLogProjectDescriptionIsNotNull() {
            addCriterion("log_project_description is not null");
            return (Criteria) this;
        }

        public Criteria andLogProjectDescriptionEqualTo(String value) {
            addCriterion("log_project_description =", value, "logProjectDescription");
            return (Criteria) this;
        }

        public Criteria andLogProjectDescriptionNotEqualTo(String value) {
            addCriterion("log_project_description <>", value, "logProjectDescription");
            return (Criteria) this;
        }

        public Criteria andLogProjectDescriptionGreaterThan(String value) {
            addCriterion("log_project_description >", value, "logProjectDescription");
            return (Criteria) this;
        }

        public Criteria andLogProjectDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("log_project_description >=", value, "logProjectDescription");
            return (Criteria) this;
        }

        public Criteria andLogProjectDescriptionLessThan(String value) {
            addCriterion("log_project_description <", value, "logProjectDescription");
            return (Criteria) this;
        }

        public Criteria andLogProjectDescriptionLessThanOrEqualTo(String value) {
            addCriterion("log_project_description <=", value, "logProjectDescription");
            return (Criteria) this;
        }

        public Criteria andLogProjectDescriptionLike(String value) {
            addCriterion("log_project_description like", value, "logProjectDescription");
            return (Criteria) this;
        }

        public Criteria andLogProjectDescriptionNotLike(String value) {
            addCriterion("log_project_description not like", value, "logProjectDescription");
            return (Criteria) this;
        }

        public Criteria andLogProjectDescriptionIn(List<String> values) {
            addCriterion("log_project_description in", values, "logProjectDescription");
            return (Criteria) this;
        }

        public Criteria andLogProjectDescriptionNotIn(List<String> values) {
            addCriterion("log_project_description not in", values, "logProjectDescription");
            return (Criteria) this;
        }

        public Criteria andLogProjectDescriptionBetween(String value1, String value2) {
            addCriterion("log_project_description between", value1, value2, "logProjectDescription");
            return (Criteria) this;
        }

        public Criteria andLogProjectDescriptionNotBetween(String value1, String value2) {
            addCriterion("log_project_description not between", value1, value2, "logProjectDescription");
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