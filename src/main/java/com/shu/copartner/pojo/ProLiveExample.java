package com.shu.copartner.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProLiveExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProLiveExample() {
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

        public Criteria andLiveIdIsNull() {
            addCriterion("live_id is null");
            return (Criteria) this;
        }

        public Criteria andLiveIdIsNotNull() {
            addCriterion("live_id is not null");
            return (Criteria) this;
        }

        public Criteria andLiveIdEqualTo(Long value) {
            addCriterion("live_id =", value, "liveId");
            return (Criteria) this;
        }

        public Criteria andLiveIdNotEqualTo(Long value) {
            addCriterion("live_id <>", value, "liveId");
            return (Criteria) this;
        }

        public Criteria andLiveIdGreaterThan(Long value) {
            addCriterion("live_id >", value, "liveId");
            return (Criteria) this;
        }

        public Criteria andLiveIdGreaterThanOrEqualTo(Long value) {
            addCriterion("live_id >=", value, "liveId");
            return (Criteria) this;
        }

        public Criteria andLiveIdLessThan(Long value) {
            addCriterion("live_id <", value, "liveId");
            return (Criteria) this;
        }

        public Criteria andLiveIdLessThanOrEqualTo(Long value) {
            addCriterion("live_id <=", value, "liveId");
            return (Criteria) this;
        }

        public Criteria andLiveIdIn(List<Long> values) {
            addCriterion("live_id in", values, "liveId");
            return (Criteria) this;
        }

        public Criteria andLiveIdNotIn(List<Long> values) {
            addCriterion("live_id not in", values, "liveId");
            return (Criteria) this;
        }

        public Criteria andLiveIdBetween(Long value1, Long value2) {
            addCriterion("live_id between", value1, value2, "liveId");
            return (Criteria) this;
        }

        public Criteria andLiveIdNotBetween(Long value1, Long value2) {
            addCriterion("live_id not between", value1, value2, "liveId");
            return (Criteria) this;
        }

        public Criteria andLiveTitleIsNull() {
            addCriterion("live_title is null");
            return (Criteria) this;
        }

        public Criteria andLiveTitleIsNotNull() {
            addCriterion("live_title is not null");
            return (Criteria) this;
        }

        public Criteria andLiveTitleEqualTo(String value) {
            addCriterion("live_title =", value, "liveTitle");
            return (Criteria) this;
        }

        public Criteria andLiveTitleNotEqualTo(String value) {
            addCriterion("live_title <>", value, "liveTitle");
            return (Criteria) this;
        }

        public Criteria andLiveTitleGreaterThan(String value) {
            addCriterion("live_title >", value, "liveTitle");
            return (Criteria) this;
        }

        public Criteria andLiveTitleGreaterThanOrEqualTo(String value) {
            addCriterion("live_title >=", value, "liveTitle");
            return (Criteria) this;
        }

        public Criteria andLiveTitleLessThan(String value) {
            addCriterion("live_title <", value, "liveTitle");
            return (Criteria) this;
        }

        public Criteria andLiveTitleLessThanOrEqualTo(String value) {
            addCriterion("live_title <=", value, "liveTitle");
            return (Criteria) this;
        }

        public Criteria andLiveTitleLike(String value) {
            addCriterion("live_title like", value, "liveTitle");
            return (Criteria) this;
        }

        public Criteria andLiveTitleNotLike(String value) {
            addCriterion("live_title not like", value, "liveTitle");
            return (Criteria) this;
        }

        public Criteria andLiveTitleIn(List<String> values) {
            addCriterion("live_title in", values, "liveTitle");
            return (Criteria) this;
        }

        public Criteria andLiveTitleNotIn(List<String> values) {
            addCriterion("live_title not in", values, "liveTitle");
            return (Criteria) this;
        }

        public Criteria andLiveTitleBetween(String value1, String value2) {
            addCriterion("live_title between", value1, value2, "liveTitle");
            return (Criteria) this;
        }

        public Criteria andLiveTitleNotBetween(String value1, String value2) {
            addCriterion("live_title not between", value1, value2, "liveTitle");
            return (Criteria) this;
        }

        public Criteria andLiveUrlIsNull() {
            addCriterion("live_url is null");
            return (Criteria) this;
        }

        public Criteria andLiveUrlIsNotNull() {
            addCriterion("live_url is not null");
            return (Criteria) this;
        }

        public Criteria andLiveUrlEqualTo(String value) {
            addCriterion("live_url =", value, "liveUrl");
            return (Criteria) this;
        }

        public Criteria andLiveUrlNotEqualTo(String value) {
            addCriterion("live_url <>", value, "liveUrl");
            return (Criteria) this;
        }

        public Criteria andLiveUrlGreaterThan(String value) {
            addCriterion("live_url >", value, "liveUrl");
            return (Criteria) this;
        }

        public Criteria andLiveUrlGreaterThanOrEqualTo(String value) {
            addCriterion("live_url >=", value, "liveUrl");
            return (Criteria) this;
        }

        public Criteria andLiveUrlLessThan(String value) {
            addCriterion("live_url <", value, "liveUrl");
            return (Criteria) this;
        }

        public Criteria andLiveUrlLessThanOrEqualTo(String value) {
            addCriterion("live_url <=", value, "liveUrl");
            return (Criteria) this;
        }

        public Criteria andLiveUrlLike(String value) {
            addCriterion("live_url like", value, "liveUrl");
            return (Criteria) this;
        }

        public Criteria andLiveUrlNotLike(String value) {
            addCriterion("live_url not like", value, "liveUrl");
            return (Criteria) this;
        }

        public Criteria andLiveUrlIn(List<String> values) {
            addCriterion("live_url in", values, "liveUrl");
            return (Criteria) this;
        }

        public Criteria andLiveUrlNotIn(List<String> values) {
            addCriterion("live_url not in", values, "liveUrl");
            return (Criteria) this;
        }

        public Criteria andLiveUrlBetween(String value1, String value2) {
            addCriterion("live_url between", value1, value2, "liveUrl");
            return (Criteria) this;
        }

        public Criteria andLiveUrlNotBetween(String value1, String value2) {
            addCriterion("live_url not between", value1, value2, "liveUrl");
            return (Criteria) this;
        }

        public Criteria andLiveDescriptionIsNull() {
            addCriterion("live_description is null");
            return (Criteria) this;
        }

        public Criteria andLiveDescriptionIsNotNull() {
            addCriterion("live_description is not null");
            return (Criteria) this;
        }

        public Criteria andLiveDescriptionEqualTo(String value) {
            addCriterion("live_description =", value, "liveDescription");
            return (Criteria) this;
        }

        public Criteria andLiveDescriptionNotEqualTo(String value) {
            addCriterion("live_description <>", value, "liveDescription");
            return (Criteria) this;
        }

        public Criteria andLiveDescriptionGreaterThan(String value) {
            addCriterion("live_description >", value, "liveDescription");
            return (Criteria) this;
        }

        public Criteria andLiveDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("live_description >=", value, "liveDescription");
            return (Criteria) this;
        }

        public Criteria andLiveDescriptionLessThan(String value) {
            addCriterion("live_description <", value, "liveDescription");
            return (Criteria) this;
        }

        public Criteria andLiveDescriptionLessThanOrEqualTo(String value) {
            addCriterion("live_description <=", value, "liveDescription");
            return (Criteria) this;
        }

        public Criteria andLiveDescriptionLike(String value) {
            addCriterion("live_description like", value, "liveDescription");
            return (Criteria) this;
        }

        public Criteria andLiveDescriptionNotLike(String value) {
            addCriterion("live_description not like", value, "liveDescription");
            return (Criteria) this;
        }

        public Criteria andLiveDescriptionIn(List<String> values) {
            addCriterion("live_description in", values, "liveDescription");
            return (Criteria) this;
        }

        public Criteria andLiveDescriptionNotIn(List<String> values) {
            addCriterion("live_description not in", values, "liveDescription");
            return (Criteria) this;
        }

        public Criteria andLiveDescriptionBetween(String value1, String value2) {
            addCriterion("live_description between", value1, value2, "liveDescription");
            return (Criteria) this;
        }

        public Criteria andLiveDescriptionNotBetween(String value1, String value2) {
            addCriterion("live_description not between", value1, value2, "liveDescription");
            return (Criteria) this;
        }

        public Criteria andLiveDurationIsNull() {
            addCriterion("live_duration is null");
            return (Criteria) this;
        }

        public Criteria andLiveDurationIsNotNull() {
            addCriterion("live_duration is not null");
            return (Criteria) this;
        }

        public Criteria andLiveDurationEqualTo(Integer value) {
            addCriterion("live_duration =", value, "liveDuration");
            return (Criteria) this;
        }

        public Criteria andLiveDurationNotEqualTo(Integer value) {
            addCriterion("live_duration <>", value, "liveDuration");
            return (Criteria) this;
        }

        public Criteria andLiveDurationGreaterThan(Integer value) {
            addCriterion("live_duration >", value, "liveDuration");
            return (Criteria) this;
        }

        public Criteria andLiveDurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("live_duration >=", value, "liveDuration");
            return (Criteria) this;
        }

        public Criteria andLiveDurationLessThan(Integer value) {
            addCriterion("live_duration <", value, "liveDuration");
            return (Criteria) this;
        }

        public Criteria andLiveDurationLessThanOrEqualTo(Integer value) {
            addCriterion("live_duration <=", value, "liveDuration");
            return (Criteria) this;
        }

        public Criteria andLiveDurationIn(List<Integer> values) {
            addCriterion("live_duration in", values, "liveDuration");
            return (Criteria) this;
        }

        public Criteria andLiveDurationNotIn(List<Integer> values) {
            addCriterion("live_duration not in", values, "liveDuration");
            return (Criteria) this;
        }

        public Criteria andLiveDurationBetween(Integer value1, Integer value2) {
            addCriterion("live_duration between", value1, value2, "liveDuration");
            return (Criteria) this;
        }

        public Criteria andLiveDurationNotBetween(Integer value1, Integer value2) {
            addCriterion("live_duration not between", value1, value2, "liveDuration");
            return (Criteria) this;
        }

        public Criteria andLiveStatusIsNull() {
            addCriterion("live_status is null");
            return (Criteria) this;
        }

        public Criteria andLiveStatusIsNotNull() {
            addCriterion("live_status is not null");
            return (Criteria) this;
        }

        public Criteria andLiveStatusEqualTo(String value) {
            addCriterion("live_status =", value, "liveStatus");
            return (Criteria) this;
        }

        public Criteria andLiveStatusNotEqualTo(String value) {
            addCriterion("live_status <>", value, "liveStatus");
            return (Criteria) this;
        }

        public Criteria andLiveStatusGreaterThan(String value) {
            addCriterion("live_status >", value, "liveStatus");
            return (Criteria) this;
        }

        public Criteria andLiveStatusGreaterThanOrEqualTo(String value) {
            addCriterion("live_status >=", value, "liveStatus");
            return (Criteria) this;
        }

        public Criteria andLiveStatusLessThan(String value) {
            addCriterion("live_status <", value, "liveStatus");
            return (Criteria) this;
        }

        public Criteria andLiveStatusLessThanOrEqualTo(String value) {
            addCriterion("live_status <=", value, "liveStatus");
            return (Criteria) this;
        }

        public Criteria andLiveStatusLike(String value) {
            addCriterion("live_status like", value, "liveStatus");
            return (Criteria) this;
        }

        public Criteria andLiveStatusNotLike(String value) {
            addCriterion("live_status not like", value, "liveStatus");
            return (Criteria) this;
        }

        public Criteria andLiveStatusIn(List<String> values) {
            addCriterion("live_status in", values, "liveStatus");
            return (Criteria) this;
        }

        public Criteria andLiveStatusNotIn(List<String> values) {
            addCriterion("live_status not in", values, "liveStatus");
            return (Criteria) this;
        }

        public Criteria andLiveStatusBetween(String value1, String value2) {
            addCriterion("live_status between", value1, value2, "liveStatus");
            return (Criteria) this;
        }

        public Criteria andLiveStatusNotBetween(String value1, String value2) {
            addCriterion("live_status not between", value1, value2, "liveStatus");
            return (Criteria) this;
        }

        public Criteria andLiveImageIsNull() {
            addCriterion("live_image is null");
            return (Criteria) this;
        }

        public Criteria andLiveImageIsNotNull() {
            addCriterion("live_image is not null");
            return (Criteria) this;
        }

        public Criteria andLiveImageEqualTo(String value) {
            addCriterion("live_image =", value, "liveImage");
            return (Criteria) this;
        }

        public Criteria andLiveImageNotEqualTo(String value) {
            addCriterion("live_image <>", value, "liveImage");
            return (Criteria) this;
        }

        public Criteria andLiveImageGreaterThan(String value) {
            addCriterion("live_image >", value, "liveImage");
            return (Criteria) this;
        }

        public Criteria andLiveImageGreaterThanOrEqualTo(String value) {
            addCriterion("live_image >=", value, "liveImage");
            return (Criteria) this;
        }

        public Criteria andLiveImageLessThan(String value) {
            addCriterion("live_image <", value, "liveImage");
            return (Criteria) this;
        }

        public Criteria andLiveImageLessThanOrEqualTo(String value) {
            addCriterion("live_image <=", value, "liveImage");
            return (Criteria) this;
        }

        public Criteria andLiveImageLike(String value) {
            addCriterion("live_image like", value, "liveImage");
            return (Criteria) this;
        }

        public Criteria andLiveImageNotLike(String value) {
            addCriterion("live_image not like", value, "liveImage");
            return (Criteria) this;
        }

        public Criteria andLiveImageIn(List<String> values) {
            addCriterion("live_image in", values, "liveImage");
            return (Criteria) this;
        }

        public Criteria andLiveImageNotIn(List<String> values) {
            addCriterion("live_image not in", values, "liveImage");
            return (Criteria) this;
        }

        public Criteria andLiveImageBetween(String value1, String value2) {
            addCriterion("live_image between", value1, value2, "liveImage");
            return (Criteria) this;
        }

        public Criteria andLiveImageNotBetween(String value1, String value2) {
            addCriterion("live_image not between", value1, value2, "liveImage");
            return (Criteria) this;
        }

        public Criteria andClickTimesIsNull() {
            addCriterion("click_times is null");
            return (Criteria) this;
        }

        public Criteria andClickTimesIsNotNull() {
            addCriterion("click_times is not null");
            return (Criteria) this;
        }

        public Criteria andClickTimesEqualTo(String value) {
            addCriterion("click_times =", value, "clickTimes");
            return (Criteria) this;
        }

        public Criteria andClickTimesNotEqualTo(String value) {
            addCriterion("click_times <>", value, "clickTimes");
            return (Criteria) this;
        }

        public Criteria andClickTimesGreaterThan(String value) {
            addCriterion("click_times >", value, "clickTimes");
            return (Criteria) this;
        }

        public Criteria andClickTimesGreaterThanOrEqualTo(String value) {
            addCriterion("click_times >=", value, "clickTimes");
            return (Criteria) this;
        }

        public Criteria andClickTimesLessThan(String value) {
            addCriterion("click_times <", value, "clickTimes");
            return (Criteria) this;
        }

        public Criteria andClickTimesLessThanOrEqualTo(String value) {
            addCriterion("click_times <=", value, "clickTimes");
            return (Criteria) this;
        }

        public Criteria andClickTimesLike(String value) {
            addCriterion("click_times like", value, "clickTimes");
            return (Criteria) this;
        }

        public Criteria andClickTimesNotLike(String value) {
            addCriterion("click_times not like", value, "clickTimes");
            return (Criteria) this;
        }

        public Criteria andClickTimesIn(List<String> values) {
            addCriterion("click_times in", values, "clickTimes");
            return (Criteria) this;
        }

        public Criteria andClickTimesNotIn(List<String> values) {
            addCriterion("click_times not in", values, "clickTimes");
            return (Criteria) this;
        }

        public Criteria andClickTimesBetween(String value1, String value2) {
            addCriterion("click_times between", value1, value2, "clickTimes");
            return (Criteria) this;
        }

        public Criteria andClickTimesNotBetween(String value1, String value2) {
            addCriterion("click_times not between", value1, value2, "clickTimes");
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

        public Criteria andIsIssueIsNull() {
            addCriterion("is_issue is null");
            return (Criteria) this;
        }

        public Criteria andIsIssueIsNotNull() {
            addCriterion("is_issue is not null");
            return (Criteria) this;
        }

        public Criteria andIsIssueEqualTo(Integer value) {
            addCriterion("is_issue =", value, "isIssue");
            return (Criteria) this;
        }

        public Criteria andIsIssueNotEqualTo(Integer value) {
            addCriterion("is_issue <>", value, "isIssue");
            return (Criteria) this;
        }

        public Criteria andIsIssueGreaterThan(Integer value) {
            addCriterion("is_issue >", value, "isIssue");
            return (Criteria) this;
        }

        public Criteria andIsIssueGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_issue >=", value, "isIssue");
            return (Criteria) this;
        }

        public Criteria andIsIssueLessThan(Integer value) {
            addCriterion("is_issue <", value, "isIssue");
            return (Criteria) this;
        }

        public Criteria andIsIssueLessThanOrEqualTo(Integer value) {
            addCriterion("is_issue <=", value, "isIssue");
            return (Criteria) this;
        }

        public Criteria andIsIssueIn(List<Integer> values) {
            addCriterion("is_issue in", values, "isIssue");
            return (Criteria) this;
        }

        public Criteria andIsIssueNotIn(List<Integer> values) {
            addCriterion("is_issue not in", values, "isIssue");
            return (Criteria) this;
        }

        public Criteria andIsIssueBetween(Integer value1, Integer value2) {
            addCriterion("is_issue between", value1, value2, "isIssue");
            return (Criteria) this;
        }

        public Criteria andIsIssueNotBetween(Integer value1, Integer value2) {
            addCriterion("is_issue not between", value1, value2, "isIssue");
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

        public Criteria andLiveVideoUrlIsNull() {
            addCriterion("live_video_url is null");
            return (Criteria) this;
        }

        public Criteria andLiveVideoUrlIsNotNull() {
            addCriterion("live_video_url is not null");
            return (Criteria) this;
        }

        public Criteria andLiveVideoUrlEqualTo(String value) {
            addCriterion("live_video_url =", value, "liveVideoUrl");
            return (Criteria) this;
        }

        public Criteria andLiveVideoUrlNotEqualTo(String value) {
            addCriterion("live_video_url <>", value, "liveVideoUrl");
            return (Criteria) this;
        }

        public Criteria andLiveVideoUrlGreaterThan(String value) {
            addCriterion("live_video_url >", value, "liveVideoUrl");
            return (Criteria) this;
        }

        public Criteria andLiveVideoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("live_video_url >=", value, "liveVideoUrl");
            return (Criteria) this;
        }

        public Criteria andLiveVideoUrlLessThan(String value) {
            addCriterion("live_video_url <", value, "liveVideoUrl");
            return (Criteria) this;
        }

        public Criteria andLiveVideoUrlLessThanOrEqualTo(String value) {
            addCriterion("live_video_url <=", value, "liveVideoUrl");
            return (Criteria) this;
        }

        public Criteria andLiveVideoUrlLike(String value) {
            addCriterion("live_video_url like", value, "liveVideoUrl");
            return (Criteria) this;
        }

        public Criteria andLiveVideoUrlNotLike(String value) {
            addCriterion("live_video_url not like", value, "liveVideoUrl");
            return (Criteria) this;
        }

        public Criteria andLiveVideoUrlIn(List<String> values) {
            addCriterion("live_video_url in", values, "liveVideoUrl");
            return (Criteria) this;
        }

        public Criteria andLiveVideoUrlNotIn(List<String> values) {
            addCriterion("live_video_url not in", values, "liveVideoUrl");
            return (Criteria) this;
        }

        public Criteria andLiveVideoUrlBetween(String value1, String value2) {
            addCriterion("live_video_url between", value1, value2, "liveVideoUrl");
            return (Criteria) this;
        }

        public Criteria andLiveVideoUrlNotBetween(String value1, String value2) {
            addCriterion("live_video_url not between", value1, value2, "liveVideoUrl");
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