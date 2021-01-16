package com.shu.copartner.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProActivityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProActivityExample() {
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

        public Criteria andActivityIdIsNull() {
            addCriterion("activity_id is null");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNotNull() {
            addCriterion("activity_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivityIdEqualTo(Long value) {
            addCriterion("activity_id =", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotEqualTo(Long value) {
            addCriterion("activity_id <>", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThan(Long value) {
            addCriterion("activity_id >", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThanOrEqualTo(Long value) {
            addCriterion("activity_id >=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThan(Long value) {
            addCriterion("activity_id <", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThanOrEqualTo(Long value) {
            addCriterion("activity_id <=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdIn(List<Long> values) {
            addCriterion("activity_id in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotIn(List<Long> values) {
            addCriterion("activity_id not in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdBetween(Long value1, Long value2) {
            addCriterion("activity_id between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotBetween(Long value1, Long value2) {
            addCriterion("activity_id not between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityTitleIsNull() {
            addCriterion("activity_title is null");
            return (Criteria) this;
        }

        public Criteria andActivityTitleIsNotNull() {
            addCriterion("activity_title is not null");
            return (Criteria) this;
        }

        public Criteria andActivityTitleEqualTo(String value) {
            addCriterion("activity_title =", value, "activityTitle");
            return (Criteria) this;
        }

        public Criteria andActivityTitleNotEqualTo(String value) {
            addCriterion("activity_title <>", value, "activityTitle");
            return (Criteria) this;
        }

        public Criteria andActivityTitleGreaterThan(String value) {
            addCriterion("activity_title >", value, "activityTitle");
            return (Criteria) this;
        }

        public Criteria andActivityTitleGreaterThanOrEqualTo(String value) {
            addCriterion("activity_title >=", value, "activityTitle");
            return (Criteria) this;
        }

        public Criteria andActivityTitleLessThan(String value) {
            addCriterion("activity_title <", value, "activityTitle");
            return (Criteria) this;
        }

        public Criteria andActivityTitleLessThanOrEqualTo(String value) {
            addCriterion("activity_title <=", value, "activityTitle");
            return (Criteria) this;
        }

        public Criteria andActivityTitleLike(String value) {
            addCriterion("activity_title like", value, "activityTitle");
            return (Criteria) this;
        }

        public Criteria andActivityTitleNotLike(String value) {
            addCriterion("activity_title not like", value, "activityTitle");
            return (Criteria) this;
        }

        public Criteria andActivityTitleIn(List<String> values) {
            addCriterion("activity_title in", values, "activityTitle");
            return (Criteria) this;
        }

        public Criteria andActivityTitleNotIn(List<String> values) {
            addCriterion("activity_title not in", values, "activityTitle");
            return (Criteria) this;
        }

        public Criteria andActivityTitleBetween(String value1, String value2) {
            addCriterion("activity_title between", value1, value2, "activityTitle");
            return (Criteria) this;
        }

        public Criteria andActivityTitleNotBetween(String value1, String value2) {
            addCriterion("activity_title not between", value1, value2, "activityTitle");
            return (Criteria) this;
        }

        public Criteria andActivityContentIsNull() {
            addCriterion("activity_content is null");
            return (Criteria) this;
        }

        public Criteria andActivityContentIsNotNull() {
            addCriterion("activity_content is not null");
            return (Criteria) this;
        }

        public Criteria andActivityContentEqualTo(String value) {
            addCriterion("activity_content =", value, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentNotEqualTo(String value) {
            addCriterion("activity_content <>", value, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentGreaterThan(String value) {
            addCriterion("activity_content >", value, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentGreaterThanOrEqualTo(String value) {
            addCriterion("activity_content >=", value, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentLessThan(String value) {
            addCriterion("activity_content <", value, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentLessThanOrEqualTo(String value) {
            addCriterion("activity_content <=", value, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentLike(String value) {
            addCriterion("activity_content like", value, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentNotLike(String value) {
            addCriterion("activity_content not like", value, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentIn(List<String> values) {
            addCriterion("activity_content in", values, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentNotIn(List<String> values) {
            addCriterion("activity_content not in", values, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentBetween(String value1, String value2) {
            addCriterion("activity_content between", value1, value2, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityContentNotBetween(String value1, String value2) {
            addCriterion("activity_content not between", value1, value2, "activityContent");
            return (Criteria) this;
        }

        public Criteria andActivityStatusIsNull() {
            addCriterion("activity_status is null");
            return (Criteria) this;
        }

        public Criteria andActivityStatusIsNotNull() {
            addCriterion("activity_status is not null");
            return (Criteria) this;
        }

        public Criteria andActivityStatusEqualTo(String value) {
            addCriterion("activity_status =", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusNotEqualTo(String value) {
            addCriterion("activity_status <>", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusGreaterThan(String value) {
            addCriterion("activity_status >", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusGreaterThanOrEqualTo(String value) {
            addCriterion("activity_status >=", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusLessThan(String value) {
            addCriterion("activity_status <", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusLessThanOrEqualTo(String value) {
            addCriterion("activity_status <=", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusLike(String value) {
            addCriterion("activity_status like", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusNotLike(String value) {
            addCriterion("activity_status not like", value, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusIn(List<String> values) {
            addCriterion("activity_status in", values, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusNotIn(List<String> values) {
            addCriterion("activity_status not in", values, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusBetween(String value1, String value2) {
            addCriterion("activity_status between", value1, value2, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityStatusNotBetween(String value1, String value2) {
            addCriterion("activity_status not between", value1, value2, "activityStatus");
            return (Criteria) this;
        }

        public Criteria andActivityAuthorIsNull() {
            addCriterion("activity_author is null");
            return (Criteria) this;
        }

        public Criteria andActivityAuthorIsNotNull() {
            addCriterion("activity_author is not null");
            return (Criteria) this;
        }

        public Criteria andActivityAuthorEqualTo(String value) {
            addCriterion("activity_author =", value, "activityAuthor");
            return (Criteria) this;
        }

        public Criteria andActivityAuthorNotEqualTo(String value) {
            addCriterion("activity_author <>", value, "activityAuthor");
            return (Criteria) this;
        }

        public Criteria andActivityAuthorGreaterThan(String value) {
            addCriterion("activity_author >", value, "activityAuthor");
            return (Criteria) this;
        }

        public Criteria andActivityAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("activity_author >=", value, "activityAuthor");
            return (Criteria) this;
        }

        public Criteria andActivityAuthorLessThan(String value) {
            addCriterion("activity_author <", value, "activityAuthor");
            return (Criteria) this;
        }

        public Criteria andActivityAuthorLessThanOrEqualTo(String value) {
            addCriterion("activity_author <=", value, "activityAuthor");
            return (Criteria) this;
        }

        public Criteria andActivityAuthorLike(String value) {
            addCriterion("activity_author like", value, "activityAuthor");
            return (Criteria) this;
        }

        public Criteria andActivityAuthorNotLike(String value) {
            addCriterion("activity_author not like", value, "activityAuthor");
            return (Criteria) this;
        }

        public Criteria andActivityAuthorIn(List<String> values) {
            addCriterion("activity_author in", values, "activityAuthor");
            return (Criteria) this;
        }

        public Criteria andActivityAuthorNotIn(List<String> values) {
            addCriterion("activity_author not in", values, "activityAuthor");
            return (Criteria) this;
        }

        public Criteria andActivityAuthorBetween(String value1, String value2) {
            addCriterion("activity_author between", value1, value2, "activityAuthor");
            return (Criteria) this;
        }

        public Criteria andActivityAuthorNotBetween(String value1, String value2) {
            addCriterion("activity_author not between", value1, value2, "activityAuthor");
            return (Criteria) this;
        }

        public Criteria andActivityParticipatorIsNull() {
            addCriterion("activity_participator is null");
            return (Criteria) this;
        }

        public Criteria andActivityParticipatorIsNotNull() {
            addCriterion("activity_participator is not null");
            return (Criteria) this;
        }

        public Criteria andActivityParticipatorEqualTo(String value) {
            addCriterion("activity_participator =", value, "activityParticipator");
            return (Criteria) this;
        }

        public Criteria andActivityParticipatorNotEqualTo(String value) {
            addCriterion("activity_participator <>", value, "activityParticipator");
            return (Criteria) this;
        }

        public Criteria andActivityParticipatorGreaterThan(String value) {
            addCriterion("activity_participator >", value, "activityParticipator");
            return (Criteria) this;
        }

        public Criteria andActivityParticipatorGreaterThanOrEqualTo(String value) {
            addCriterion("activity_participator >=", value, "activityParticipator");
            return (Criteria) this;
        }

        public Criteria andActivityParticipatorLessThan(String value) {
            addCriterion("activity_participator <", value, "activityParticipator");
            return (Criteria) this;
        }

        public Criteria andActivityParticipatorLessThanOrEqualTo(String value) {
            addCriterion("activity_participator <=", value, "activityParticipator");
            return (Criteria) this;
        }

        public Criteria andActivityParticipatorLike(String value) {
            addCriterion("activity_participator like", value, "activityParticipator");
            return (Criteria) this;
        }

        public Criteria andActivityParticipatorNotLike(String value) {
            addCriterion("activity_participator not like", value, "activityParticipator");
            return (Criteria) this;
        }

        public Criteria andActivityParticipatorIn(List<String> values) {
            addCriterion("activity_participator in", values, "activityParticipator");
            return (Criteria) this;
        }

        public Criteria andActivityParticipatorNotIn(List<String> values) {
            addCriterion("activity_participator not in", values, "activityParticipator");
            return (Criteria) this;
        }

        public Criteria andActivityParticipatorBetween(String value1, String value2) {
            addCriterion("activity_participator between", value1, value2, "activityParticipator");
            return (Criteria) this;
        }

        public Criteria andActivityParticipatorNotBetween(String value1, String value2) {
            addCriterion("activity_participator not between", value1, value2, "activityParticipator");
            return (Criteria) this;
        }

        public Criteria andActivityImageIsNull() {
            addCriterion("activity_image is null");
            return (Criteria) this;
        }

        public Criteria andActivityImageIsNotNull() {
            addCriterion("activity_image is not null");
            return (Criteria) this;
        }

        public Criteria andActivityImageEqualTo(String value) {
            addCriterion("activity_image =", value, "activityImage");
            return (Criteria) this;
        }

        public Criteria andActivityImageNotEqualTo(String value) {
            addCriterion("activity_image <>", value, "activityImage");
            return (Criteria) this;
        }

        public Criteria andActivityImageGreaterThan(String value) {
            addCriterion("activity_image >", value, "activityImage");
            return (Criteria) this;
        }

        public Criteria andActivityImageGreaterThanOrEqualTo(String value) {
            addCriterion("activity_image >=", value, "activityImage");
            return (Criteria) this;
        }

        public Criteria andActivityImageLessThan(String value) {
            addCriterion("activity_image <", value, "activityImage");
            return (Criteria) this;
        }

        public Criteria andActivityImageLessThanOrEqualTo(String value) {
            addCriterion("activity_image <=", value, "activityImage");
            return (Criteria) this;
        }

        public Criteria andActivityImageLike(String value) {
            addCriterion("activity_image like", value, "activityImage");
            return (Criteria) this;
        }

        public Criteria andActivityImageNotLike(String value) {
            addCriterion("activity_image not like", value, "activityImage");
            return (Criteria) this;
        }

        public Criteria andActivityImageIn(List<String> values) {
            addCriterion("activity_image in", values, "activityImage");
            return (Criteria) this;
        }

        public Criteria andActivityImageNotIn(List<String> values) {
            addCriterion("activity_image not in", values, "activityImage");
            return (Criteria) this;
        }

        public Criteria andActivityImageBetween(String value1, String value2) {
            addCriterion("activity_image between", value1, value2, "activityImage");
            return (Criteria) this;
        }

        public Criteria andActivityImageNotBetween(String value1, String value2) {
            addCriterion("activity_image not between", value1, value2, "activityImage");
            return (Criteria) this;
        }

        public Criteria andIsPublishIsNull() {
            addCriterion("is_publish is null");
            return (Criteria) this;
        }

        public Criteria andIsPublishIsNotNull() {
            addCriterion("is_publish is not null");
            return (Criteria) this;
        }

        public Criteria andIsPublishEqualTo(Integer value) {
            addCriterion("is_publish =", value, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishNotEqualTo(Integer value) {
            addCriterion("is_publish <>", value, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishGreaterThan(Integer value) {
            addCriterion("is_publish >", value, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_publish >=", value, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishLessThan(Integer value) {
            addCriterion("is_publish <", value, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishLessThanOrEqualTo(Integer value) {
            addCriterion("is_publish <=", value, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishIn(List<Integer> values) {
            addCriterion("is_publish in", values, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishNotIn(List<Integer> values) {
            addCriterion("is_publish not in", values, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishBetween(Integer value1, Integer value2) {
            addCriterion("is_publish between", value1, value2, "isPublish");
            return (Criteria) this;
        }

        public Criteria andIsPublishNotBetween(Integer value1, Integer value2) {
            addCriterion("is_publish not between", value1, value2, "isPublish");
            return (Criteria) this;
        }

        public Criteria andClickCountIsNull() {
            addCriterion("click_count is null");
            return (Criteria) this;
        }

        public Criteria andClickCountIsNotNull() {
            addCriterion("click_count is not null");
            return (Criteria) this;
        }

        public Criteria andClickCountEqualTo(String value) {
            addCriterion("click_count =", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountNotEqualTo(String value) {
            addCriterion("click_count <>", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountGreaterThan(String value) {
            addCriterion("click_count >", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountGreaterThanOrEqualTo(String value) {
            addCriterion("click_count >=", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountLessThan(String value) {
            addCriterion("click_count <", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountLessThanOrEqualTo(String value) {
            addCriterion("click_count <=", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountLike(String value) {
            addCriterion("click_count like", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountNotLike(String value) {
            addCriterion("click_count not like", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountIn(List<String> values) {
            addCriterion("click_count in", values, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountNotIn(List<String> values) {
            addCriterion("click_count not in", values, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountBetween(String value1, String value2) {
            addCriterion("click_count between", value1, value2, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountNotBetween(String value1, String value2) {
            addCriterion("click_count not between", value1, value2, "clickCount");
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

        public Criteria andIsEnrolledIsNull() {
            addCriterion("is_enrolled is null");
            return (Criteria) this;
        }

        public Criteria andIsEnrolledIsNotNull() {
            addCriterion("is_enrolled is not null");
            return (Criteria) this;
        }

        public Criteria andIsEnrolledEqualTo(Integer value) {
            addCriterion("is_enrolled =", value, "isEnrolled");
            return (Criteria) this;
        }

        public Criteria andIsEnrolledNotEqualTo(Integer value) {
            addCriterion("is_enrolled <>", value, "isEnrolled");
            return (Criteria) this;
        }

        public Criteria andIsEnrolledGreaterThan(Integer value) {
            addCriterion("is_enrolled >", value, "isEnrolled");
            return (Criteria) this;
        }

        public Criteria andIsEnrolledGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_enrolled >=", value, "isEnrolled");
            return (Criteria) this;
        }

        public Criteria andIsEnrolledLessThan(Integer value) {
            addCriterion("is_enrolled <", value, "isEnrolled");
            return (Criteria) this;
        }

        public Criteria andIsEnrolledLessThanOrEqualTo(Integer value) {
            addCriterion("is_enrolled <=", value, "isEnrolled");
            return (Criteria) this;
        }

        public Criteria andIsEnrolledIn(List<Integer> values) {
            addCriterion("is_enrolled in", values, "isEnrolled");
            return (Criteria) this;
        }

        public Criteria andIsEnrolledNotIn(List<Integer> values) {
            addCriterion("is_enrolled not in", values, "isEnrolled");
            return (Criteria) this;
        }

        public Criteria andIsEnrolledBetween(Integer value1, Integer value2) {
            addCriterion("is_enrolled between", value1, value2, "isEnrolled");
            return (Criteria) this;
        }

        public Criteria andIsEnrolledNotBetween(Integer value1, Integer value2) {
            addCriterion("is_enrolled not between", value1, value2, "isEnrolled");
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