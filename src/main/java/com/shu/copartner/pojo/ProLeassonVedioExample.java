package com.shu.copartner.pojo;

import java.util.ArrayList;
import java.util.List;

public class ProLeassonVedioExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProLeassonVedioExample() {
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

        public Criteria andCourseVedioIdIsNull() {
            addCriterion("course_vedio_id is null");
            return (Criteria) this;
        }

        public Criteria andCourseVedioIdIsNotNull() {
            addCriterion("course_vedio_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourseVedioIdEqualTo(Long value) {
            addCriterion("course_vedio_id =", value, "courseVedioId");
            return (Criteria) this;
        }

        public Criteria andCourseVedioIdNotEqualTo(Long value) {
            addCriterion("course_vedio_id <>", value, "courseVedioId");
            return (Criteria) this;
        }

        public Criteria andCourseVedioIdGreaterThan(Long value) {
            addCriterion("course_vedio_id >", value, "courseVedioId");
            return (Criteria) this;
        }

        public Criteria andCourseVedioIdGreaterThanOrEqualTo(Long value) {
            addCriterion("course_vedio_id >=", value, "courseVedioId");
            return (Criteria) this;
        }

        public Criteria andCourseVedioIdLessThan(Long value) {
            addCriterion("course_vedio_id <", value, "courseVedioId");
            return (Criteria) this;
        }

        public Criteria andCourseVedioIdLessThanOrEqualTo(Long value) {
            addCriterion("course_vedio_id <=", value, "courseVedioId");
            return (Criteria) this;
        }

        public Criteria andCourseVedioIdIn(List<Long> values) {
            addCriterion("course_vedio_id in", values, "courseVedioId");
            return (Criteria) this;
        }

        public Criteria andCourseVedioIdNotIn(List<Long> values) {
            addCriterion("course_vedio_id not in", values, "courseVedioId");
            return (Criteria) this;
        }

        public Criteria andCourseVedioIdBetween(Long value1, Long value2) {
            addCriterion("course_vedio_id between", value1, value2, "courseVedioId");
            return (Criteria) this;
        }

        public Criteria andCourseVedioIdNotBetween(Long value1, Long value2) {
            addCriterion("course_vedio_id not between", value1, value2, "courseVedioId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNull() {
            addCriterion("course_id is null");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNotNull() {
            addCriterion("course_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourseIdEqualTo(Long value) {
            addCriterion("course_id =", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotEqualTo(Long value) {
            addCriterion("course_id <>", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThan(Long value) {
            addCriterion("course_id >", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThanOrEqualTo(Long value) {
            addCriterion("course_id >=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThan(Long value) {
            addCriterion("course_id <", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThanOrEqualTo(Long value) {
            addCriterion("course_id <=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIn(List<Long> values) {
            addCriterion("course_id in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotIn(List<Long> values) {
            addCriterion("course_id not in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdBetween(Long value1, Long value2) {
            addCriterion("course_id between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotBetween(Long value1, Long value2) {
            addCriterion("course_id not between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseVedioNumberIsNull() {
            addCriterion("course_vedio_number is null");
            return (Criteria) this;
        }

        public Criteria andCourseVedioNumberIsNotNull() {
            addCriterion("course_vedio_number is not null");
            return (Criteria) this;
        }

        public Criteria andCourseVedioNumberEqualTo(Integer value) {
            addCriterion("course_vedio_number =", value, "courseVedioNumber");
            return (Criteria) this;
        }

        public Criteria andCourseVedioNumberNotEqualTo(Integer value) {
            addCriterion("course_vedio_number <>", value, "courseVedioNumber");
            return (Criteria) this;
        }

        public Criteria andCourseVedioNumberGreaterThan(Integer value) {
            addCriterion("course_vedio_number >", value, "courseVedioNumber");
            return (Criteria) this;
        }

        public Criteria andCourseVedioNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_vedio_number >=", value, "courseVedioNumber");
            return (Criteria) this;
        }

        public Criteria andCourseVedioNumberLessThan(Integer value) {
            addCriterion("course_vedio_number <", value, "courseVedioNumber");
            return (Criteria) this;
        }

        public Criteria andCourseVedioNumberLessThanOrEqualTo(Integer value) {
            addCriterion("course_vedio_number <=", value, "courseVedioNumber");
            return (Criteria) this;
        }

        public Criteria andCourseVedioNumberIn(List<Integer> values) {
            addCriterion("course_vedio_number in", values, "courseVedioNumber");
            return (Criteria) this;
        }

        public Criteria andCourseVedioNumberNotIn(List<Integer> values) {
            addCriterion("course_vedio_number not in", values, "courseVedioNumber");
            return (Criteria) this;
        }

        public Criteria andCourseVedioNumberBetween(Integer value1, Integer value2) {
            addCriterion("course_vedio_number between", value1, value2, "courseVedioNumber");
            return (Criteria) this;
        }

        public Criteria andCourseVedioNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("course_vedio_number not between", value1, value2, "courseVedioNumber");
            return (Criteria) this;
        }

        public Criteria andCourseVedioIntroductionIsNull() {
            addCriterion("course_vedio_introduction is null");
            return (Criteria) this;
        }

        public Criteria andCourseVedioIntroductionIsNotNull() {
            addCriterion("course_vedio_introduction is not null");
            return (Criteria) this;
        }

        public Criteria andCourseVedioIntroductionEqualTo(String value) {
            addCriterion("course_vedio_introduction =", value, "courseVedioIntroduction");
            return (Criteria) this;
        }

        public Criteria andCourseVedioIntroductionNotEqualTo(String value) {
            addCriterion("course_vedio_introduction <>", value, "courseVedioIntroduction");
            return (Criteria) this;
        }

        public Criteria andCourseVedioIntroductionGreaterThan(String value) {
            addCriterion("course_vedio_introduction >", value, "courseVedioIntroduction");
            return (Criteria) this;
        }

        public Criteria andCourseVedioIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("course_vedio_introduction >=", value, "courseVedioIntroduction");
            return (Criteria) this;
        }

        public Criteria andCourseVedioIntroductionLessThan(String value) {
            addCriterion("course_vedio_introduction <", value, "courseVedioIntroduction");
            return (Criteria) this;
        }

        public Criteria andCourseVedioIntroductionLessThanOrEqualTo(String value) {
            addCriterion("course_vedio_introduction <=", value, "courseVedioIntroduction");
            return (Criteria) this;
        }

        public Criteria andCourseVedioIntroductionLike(String value) {
            addCriterion("course_vedio_introduction like", value, "courseVedioIntroduction");
            return (Criteria) this;
        }

        public Criteria andCourseVedioIntroductionNotLike(String value) {
            addCriterion("course_vedio_introduction not like", value, "courseVedioIntroduction");
            return (Criteria) this;
        }

        public Criteria andCourseVedioIntroductionIn(List<String> values) {
            addCriterion("course_vedio_introduction in", values, "courseVedioIntroduction");
            return (Criteria) this;
        }

        public Criteria andCourseVedioIntroductionNotIn(List<String> values) {
            addCriterion("course_vedio_introduction not in", values, "courseVedioIntroduction");
            return (Criteria) this;
        }

        public Criteria andCourseVedioIntroductionBetween(String value1, String value2) {
            addCriterion("course_vedio_introduction between", value1, value2, "courseVedioIntroduction");
            return (Criteria) this;
        }

        public Criteria andCourseVedioIntroductionNotBetween(String value1, String value2) {
            addCriterion("course_vedio_introduction not between", value1, value2, "courseVedioIntroduction");
            return (Criteria) this;
        }

        public Criteria andCourseVedioUrlIsNull() {
            addCriterion("course_vedio_url is null");
            return (Criteria) this;
        }

        public Criteria andCourseVedioUrlIsNotNull() {
            addCriterion("course_vedio_url is not null");
            return (Criteria) this;
        }

        public Criteria andCourseVedioUrlEqualTo(String value) {
            addCriterion("course_vedio_url =", value, "courseVedioUrl");
            return (Criteria) this;
        }

        public Criteria andCourseVedioUrlNotEqualTo(String value) {
            addCriterion("course_vedio_url <>", value, "courseVedioUrl");
            return (Criteria) this;
        }

        public Criteria andCourseVedioUrlGreaterThan(String value) {
            addCriterion("course_vedio_url >", value, "courseVedioUrl");
            return (Criteria) this;
        }

        public Criteria andCourseVedioUrlGreaterThanOrEqualTo(String value) {
            addCriterion("course_vedio_url >=", value, "courseVedioUrl");
            return (Criteria) this;
        }

        public Criteria andCourseVedioUrlLessThan(String value) {
            addCriterion("course_vedio_url <", value, "courseVedioUrl");
            return (Criteria) this;
        }

        public Criteria andCourseVedioUrlLessThanOrEqualTo(String value) {
            addCriterion("course_vedio_url <=", value, "courseVedioUrl");
            return (Criteria) this;
        }

        public Criteria andCourseVedioUrlLike(String value) {
            addCriterion("course_vedio_url like", value, "courseVedioUrl");
            return (Criteria) this;
        }

        public Criteria andCourseVedioUrlNotLike(String value) {
            addCriterion("course_vedio_url not like", value, "courseVedioUrl");
            return (Criteria) this;
        }

        public Criteria andCourseVedioUrlIn(List<String> values) {
            addCriterion("course_vedio_url in", values, "courseVedioUrl");
            return (Criteria) this;
        }

        public Criteria andCourseVedioUrlNotIn(List<String> values) {
            addCriterion("course_vedio_url not in", values, "courseVedioUrl");
            return (Criteria) this;
        }

        public Criteria andCourseVedioUrlBetween(String value1, String value2) {
            addCriterion("course_vedio_url between", value1, value2, "courseVedioUrl");
            return (Criteria) this;
        }

        public Criteria andCourseVedioUrlNotBetween(String value1, String value2) {
            addCriterion("course_vedio_url not between", value1, value2, "courseVedioUrl");
            return (Criteria) this;
        }

        public Criteria andCourseVedioNameIsNull() {
            addCriterion("course_vedio_name is null");
            return (Criteria) this;
        }

        public Criteria andCourseVedioNameIsNotNull() {
            addCriterion("course_vedio_name is not null");
            return (Criteria) this;
        }

        public Criteria andCourseVedioNameEqualTo(String value) {
            addCriterion("course_vedio_name =", value, "courseVedioName");
            return (Criteria) this;
        }

        public Criteria andCourseVedioNameNotEqualTo(String value) {
            addCriterion("course_vedio_name <>", value, "courseVedioName");
            return (Criteria) this;
        }

        public Criteria andCourseVedioNameGreaterThan(String value) {
            addCriterion("course_vedio_name >", value, "courseVedioName");
            return (Criteria) this;
        }

        public Criteria andCourseVedioNameGreaterThanOrEqualTo(String value) {
            addCriterion("course_vedio_name >=", value, "courseVedioName");
            return (Criteria) this;
        }

        public Criteria andCourseVedioNameLessThan(String value) {
            addCriterion("course_vedio_name <", value, "courseVedioName");
            return (Criteria) this;
        }

        public Criteria andCourseVedioNameLessThanOrEqualTo(String value) {
            addCriterion("course_vedio_name <=", value, "courseVedioName");
            return (Criteria) this;
        }

        public Criteria andCourseVedioNameLike(String value) {
            addCriterion("course_vedio_name like", value, "courseVedioName");
            return (Criteria) this;
        }

        public Criteria andCourseVedioNameNotLike(String value) {
            addCriterion("course_vedio_name not like", value, "courseVedioName");
            return (Criteria) this;
        }

        public Criteria andCourseVedioNameIn(List<String> values) {
            addCriterion("course_vedio_name in", values, "courseVedioName");
            return (Criteria) this;
        }

        public Criteria andCourseVedioNameNotIn(List<String> values) {
            addCriterion("course_vedio_name not in", values, "courseVedioName");
            return (Criteria) this;
        }

        public Criteria andCourseVedioNameBetween(String value1, String value2) {
            addCriterion("course_vedio_name between", value1, value2, "courseVedioName");
            return (Criteria) this;
        }

        public Criteria andCourseVedioNameNotBetween(String value1, String value2) {
            addCriterion("course_vedio_name not between", value1, value2, "courseVedioName");
            return (Criteria) this;
        }

        public Criteria andCourseVedioClicktimeIsNull() {
            addCriterion("course_vedio_clickTime is null");
            return (Criteria) this;
        }

        public Criteria andCourseVedioClicktimeIsNotNull() {
            addCriterion("course_vedio_clickTime is not null");
            return (Criteria) this;
        }

        public Criteria andCourseVedioClicktimeEqualTo(Integer value) {
            addCriterion("course_vedio_clickTime =", value, "courseVedioClicktime");
            return (Criteria) this;
        }

        public Criteria andCourseVedioClicktimeNotEqualTo(Integer value) {
            addCriterion("course_vedio_clickTime <>", value, "courseVedioClicktime");
            return (Criteria) this;
        }

        public Criteria andCourseVedioClicktimeGreaterThan(Integer value) {
            addCriterion("course_vedio_clickTime >", value, "courseVedioClicktime");
            return (Criteria) this;
        }

        public Criteria andCourseVedioClicktimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_vedio_clickTime >=", value, "courseVedioClicktime");
            return (Criteria) this;
        }

        public Criteria andCourseVedioClicktimeLessThan(Integer value) {
            addCriterion("course_vedio_clickTime <", value, "courseVedioClicktime");
            return (Criteria) this;
        }

        public Criteria andCourseVedioClicktimeLessThanOrEqualTo(Integer value) {
            addCriterion("course_vedio_clickTime <=", value, "courseVedioClicktime");
            return (Criteria) this;
        }

        public Criteria andCourseVedioClicktimeIn(List<Integer> values) {
            addCriterion("course_vedio_clickTime in", values, "courseVedioClicktime");
            return (Criteria) this;
        }

        public Criteria andCourseVedioClicktimeNotIn(List<Integer> values) {
            addCriterion("course_vedio_clickTime not in", values, "courseVedioClicktime");
            return (Criteria) this;
        }

        public Criteria andCourseVedioClicktimeBetween(Integer value1, Integer value2) {
            addCriterion("course_vedio_clickTime between", value1, value2, "courseVedioClicktime");
            return (Criteria) this;
        }

        public Criteria andCourseVedioClicktimeNotBetween(Integer value1, Integer value2) {
            addCriterion("course_vedio_clickTime not between", value1, value2, "courseVedioClicktime");
            return (Criteria) this;
        }

        public Criteria andCourseVedioDuringtimeIsNull() {
            addCriterion("course_vedio_duringTime is null");
            return (Criteria) this;
        }

        public Criteria andCourseVedioDuringtimeIsNotNull() {
            addCriterion("course_vedio_duringTime is not null");
            return (Criteria) this;
        }

        public Criteria andCourseVedioDuringtimeEqualTo(String value) {
            addCriterion("course_vedio_duringTime =", value, "courseVedioDuringtime");
            return (Criteria) this;
        }

        public Criteria andCourseVedioDuringtimeNotEqualTo(String value) {
            addCriterion("course_vedio_duringTime <>", value, "courseVedioDuringtime");
            return (Criteria) this;
        }

        public Criteria andCourseVedioDuringtimeGreaterThan(String value) {
            addCriterion("course_vedio_duringTime >", value, "courseVedioDuringtime");
            return (Criteria) this;
        }

        public Criteria andCourseVedioDuringtimeGreaterThanOrEqualTo(String value) {
            addCriterion("course_vedio_duringTime >=", value, "courseVedioDuringtime");
            return (Criteria) this;
        }

        public Criteria andCourseVedioDuringtimeLessThan(String value) {
            addCriterion("course_vedio_duringTime <", value, "courseVedioDuringtime");
            return (Criteria) this;
        }

        public Criteria andCourseVedioDuringtimeLessThanOrEqualTo(String value) {
            addCriterion("course_vedio_duringTime <=", value, "courseVedioDuringtime");
            return (Criteria) this;
        }

        public Criteria andCourseVedioDuringtimeLike(String value) {
            addCriterion("course_vedio_duringTime like", value, "courseVedioDuringtime");
            return (Criteria) this;
        }

        public Criteria andCourseVedioDuringtimeNotLike(String value) {
            addCriterion("course_vedio_duringTime not like", value, "courseVedioDuringtime");
            return (Criteria) this;
        }

        public Criteria andCourseVedioDuringtimeIn(List<String> values) {
            addCriterion("course_vedio_duringTime in", values, "courseVedioDuringtime");
            return (Criteria) this;
        }

        public Criteria andCourseVedioDuringtimeNotIn(List<String> values) {
            addCriterion("course_vedio_duringTime not in", values, "courseVedioDuringtime");
            return (Criteria) this;
        }

        public Criteria andCourseVedioDuringtimeBetween(String value1, String value2) {
            addCriterion("course_vedio_duringTime between", value1, value2, "courseVedioDuringtime");
            return (Criteria) this;
        }

        public Criteria andCourseVedioDuringtimeNotBetween(String value1, String value2) {
            addCriterion("course_vedio_duringTime not between", value1, value2, "courseVedioDuringtime");
            return (Criteria) this;
        }

        public Criteria andCourseVedioStatusIsNull() {
            addCriterion("course_vedio_status is null");
            return (Criteria) this;
        }

        public Criteria andCourseVedioStatusIsNotNull() {
            addCriterion("course_vedio_status is not null");
            return (Criteria) this;
        }

        public Criteria andCourseVedioStatusEqualTo(String value) {
            addCriterion("course_vedio_status =", value, "courseVedioStatus");
            return (Criteria) this;
        }

        public Criteria andCourseVedioStatusNotEqualTo(String value) {
            addCriterion("course_vedio_status <>", value, "courseVedioStatus");
            return (Criteria) this;
        }

        public Criteria andCourseVedioStatusGreaterThan(String value) {
            addCriterion("course_vedio_status >", value, "courseVedioStatus");
            return (Criteria) this;
        }

        public Criteria andCourseVedioStatusGreaterThanOrEqualTo(String value) {
            addCriterion("course_vedio_status >=", value, "courseVedioStatus");
            return (Criteria) this;
        }

        public Criteria andCourseVedioStatusLessThan(String value) {
            addCriterion("course_vedio_status <", value, "courseVedioStatus");
            return (Criteria) this;
        }

        public Criteria andCourseVedioStatusLessThanOrEqualTo(String value) {
            addCriterion("course_vedio_status <=", value, "courseVedioStatus");
            return (Criteria) this;
        }

        public Criteria andCourseVedioStatusLike(String value) {
            addCriterion("course_vedio_status like", value, "courseVedioStatus");
            return (Criteria) this;
        }

        public Criteria andCourseVedioStatusNotLike(String value) {
            addCriterion("course_vedio_status not like", value, "courseVedioStatus");
            return (Criteria) this;
        }

        public Criteria andCourseVedioStatusIn(List<String> values) {
            addCriterion("course_vedio_status in", values, "courseVedioStatus");
            return (Criteria) this;
        }

        public Criteria andCourseVedioStatusNotIn(List<String> values) {
            addCriterion("course_vedio_status not in", values, "courseVedioStatus");
            return (Criteria) this;
        }

        public Criteria andCourseVedioStatusBetween(String value1, String value2) {
            addCriterion("course_vedio_status between", value1, value2, "courseVedioStatus");
            return (Criteria) this;
        }

        public Criteria andCourseVedioStatusNotBetween(String value1, String value2) {
            addCriterion("course_vedio_status not between", value1, value2, "courseVedioStatus");
            return (Criteria) this;
        }

        public Criteria andCourseVedioPptUrlIsNull() {
            addCriterion("course_vedio_ppt_url is null");
            return (Criteria) this;
        }

        public Criteria andCourseVedioPptUrlIsNotNull() {
            addCriterion("course_vedio_ppt_url is not null");
            return (Criteria) this;
        }

        public Criteria andCourseVedioPptUrlEqualTo(String value) {
            addCriterion("course_vedio_ppt_url =", value, "courseVedioPptUrl");
            return (Criteria) this;
        }

        public Criteria andCourseVedioPptUrlNotEqualTo(String value) {
            addCriterion("course_vedio_ppt_url <>", value, "courseVedioPptUrl");
            return (Criteria) this;
        }

        public Criteria andCourseVedioPptUrlGreaterThan(String value) {
            addCriterion("course_vedio_ppt_url >", value, "courseVedioPptUrl");
            return (Criteria) this;
        }

        public Criteria andCourseVedioPptUrlGreaterThanOrEqualTo(String value) {
            addCriterion("course_vedio_ppt_url >=", value, "courseVedioPptUrl");
            return (Criteria) this;
        }

        public Criteria andCourseVedioPptUrlLessThan(String value) {
            addCriterion("course_vedio_ppt_url <", value, "courseVedioPptUrl");
            return (Criteria) this;
        }

        public Criteria andCourseVedioPptUrlLessThanOrEqualTo(String value) {
            addCriterion("course_vedio_ppt_url <=", value, "courseVedioPptUrl");
            return (Criteria) this;
        }

        public Criteria andCourseVedioPptUrlLike(String value) {
            addCriterion("course_vedio_ppt_url like", value, "courseVedioPptUrl");
            return (Criteria) this;
        }

        public Criteria andCourseVedioPptUrlNotLike(String value) {
            addCriterion("course_vedio_ppt_url not like", value, "courseVedioPptUrl");
            return (Criteria) this;
        }

        public Criteria andCourseVedioPptUrlIn(List<String> values) {
            addCriterion("course_vedio_ppt_url in", values, "courseVedioPptUrl");
            return (Criteria) this;
        }

        public Criteria andCourseVedioPptUrlNotIn(List<String> values) {
            addCriterion("course_vedio_ppt_url not in", values, "courseVedioPptUrl");
            return (Criteria) this;
        }

        public Criteria andCourseVedioPptUrlBetween(String value1, String value2) {
            addCriterion("course_vedio_ppt_url between", value1, value2, "courseVedioPptUrl");
            return (Criteria) this;
        }

        public Criteria andCourseVedioPptUrlNotBetween(String value1, String value2) {
            addCriterion("course_vedio_ppt_url not between", value1, value2, "courseVedioPptUrl");
            return (Criteria) this;
        }

        public Criteria andCourseVedioCatalogIsNull() {
            addCriterion("course_vedio_catalog is null");
            return (Criteria) this;
        }

        public Criteria andCourseVedioCatalogIsNotNull() {
            addCriterion("course_vedio_catalog is not null");
            return (Criteria) this;
        }

        public Criteria andCourseVedioCatalogEqualTo(String value) {
            addCriterion("course_vedio_catalog =", value, "courseVedioCatalog");
            return (Criteria) this;
        }

        public Criteria andCourseVedioCatalogNotEqualTo(String value) {
            addCriterion("course_vedio_catalog <>", value, "courseVedioCatalog");
            return (Criteria) this;
        }

        public Criteria andCourseVedioCatalogGreaterThan(String value) {
            addCriterion("course_vedio_catalog >", value, "courseVedioCatalog");
            return (Criteria) this;
        }

        public Criteria andCourseVedioCatalogGreaterThanOrEqualTo(String value) {
            addCriterion("course_vedio_catalog >=", value, "courseVedioCatalog");
            return (Criteria) this;
        }

        public Criteria andCourseVedioCatalogLessThan(String value) {
            addCriterion("course_vedio_catalog <", value, "courseVedioCatalog");
            return (Criteria) this;
        }

        public Criteria andCourseVedioCatalogLessThanOrEqualTo(String value) {
            addCriterion("course_vedio_catalog <=", value, "courseVedioCatalog");
            return (Criteria) this;
        }

        public Criteria andCourseVedioCatalogLike(String value) {
            addCriterion("course_vedio_catalog like", value, "courseVedioCatalog");
            return (Criteria) this;
        }

        public Criteria andCourseVedioCatalogNotLike(String value) {
            addCriterion("course_vedio_catalog not like", value, "courseVedioCatalog");
            return (Criteria) this;
        }

        public Criteria andCourseVedioCatalogIn(List<String> values) {
            addCriterion("course_vedio_catalog in", values, "courseVedioCatalog");
            return (Criteria) this;
        }

        public Criteria andCourseVedioCatalogNotIn(List<String> values) {
            addCriterion("course_vedio_catalog not in", values, "courseVedioCatalog");
            return (Criteria) this;
        }

        public Criteria andCourseVedioCatalogBetween(String value1, String value2) {
            addCriterion("course_vedio_catalog between", value1, value2, "courseVedioCatalog");
            return (Criteria) this;
        }

        public Criteria andCourseVedioCatalogNotBetween(String value1, String value2) {
            addCriterion("course_vedio_catalog not between", value1, value2, "courseVedioCatalog");
            return (Criteria) this;
        }

        public Criteria andCourseVedioIsdeletedIsNull() {
            addCriterion("course_vedio_isDeleted is null");
            return (Criteria) this;
        }

        public Criteria andCourseVedioIsdeletedIsNotNull() {
            addCriterion("course_vedio_isDeleted is not null");
            return (Criteria) this;
        }

        public Criteria andCourseVedioIsdeletedEqualTo(String value) {
            addCriterion("course_vedio_isDeleted =", value, "courseVedioIsdeleted");
            return (Criteria) this;
        }

        public Criteria andCourseVedioIsdeletedNotEqualTo(String value) {
            addCriterion("course_vedio_isDeleted <>", value, "courseVedioIsdeleted");
            return (Criteria) this;
        }

        public Criteria andCourseVedioIsdeletedGreaterThan(String value) {
            addCriterion("course_vedio_isDeleted >", value, "courseVedioIsdeleted");
            return (Criteria) this;
        }

        public Criteria andCourseVedioIsdeletedGreaterThanOrEqualTo(String value) {
            addCriterion("course_vedio_isDeleted >=", value, "courseVedioIsdeleted");
            return (Criteria) this;
        }

        public Criteria andCourseVedioIsdeletedLessThan(String value) {
            addCriterion("course_vedio_isDeleted <", value, "courseVedioIsdeleted");
            return (Criteria) this;
        }

        public Criteria andCourseVedioIsdeletedLessThanOrEqualTo(String value) {
            addCriterion("course_vedio_isDeleted <=", value, "courseVedioIsdeleted");
            return (Criteria) this;
        }

        public Criteria andCourseVedioIsdeletedLike(String value) {
            addCriterion("course_vedio_isDeleted like", value, "courseVedioIsdeleted");
            return (Criteria) this;
        }

        public Criteria andCourseVedioIsdeletedNotLike(String value) {
            addCriterion("course_vedio_isDeleted not like", value, "courseVedioIsdeleted");
            return (Criteria) this;
        }

        public Criteria andCourseVedioIsdeletedIn(List<String> values) {
            addCriterion("course_vedio_isDeleted in", values, "courseVedioIsdeleted");
            return (Criteria) this;
        }

        public Criteria andCourseVedioIsdeletedNotIn(List<String> values) {
            addCriterion("course_vedio_isDeleted not in", values, "courseVedioIsdeleted");
            return (Criteria) this;
        }

        public Criteria andCourseVedioIsdeletedBetween(String value1, String value2) {
            addCriterion("course_vedio_isDeleted between", value1, value2, "courseVedioIsdeleted");
            return (Criteria) this;
        }

        public Criteria andCourseVedioIsdeletedNotBetween(String value1, String value2) {
            addCriterion("course_vedio_isDeleted not between", value1, value2, "courseVedioIsdeleted");
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