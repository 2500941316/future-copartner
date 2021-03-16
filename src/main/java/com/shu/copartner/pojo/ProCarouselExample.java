package com.shu.copartner.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProCarouselExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProCarouselExample() {
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

        public Criteria andCarouselIdIsNull() {
            addCriterion("carousel_id is null");
            return (Criteria) this;
        }

        public Criteria andCarouselIdIsNotNull() {
            addCriterion("carousel_id is not null");
            return (Criteria) this;
        }

        public Criteria andCarouselIdEqualTo(Long value) {
            addCriterion("carousel_id =", value, "carouselId");
            return (Criteria) this;
        }

        public Criteria andCarouselIdNotEqualTo(Long value) {
            addCriterion("carousel_id <>", value, "carouselId");
            return (Criteria) this;
        }

        public Criteria andCarouselIdGreaterThan(Long value) {
            addCriterion("carousel_id >", value, "carouselId");
            return (Criteria) this;
        }

        public Criteria andCarouselIdGreaterThanOrEqualTo(Long value) {
            addCriterion("carousel_id >=", value, "carouselId");
            return (Criteria) this;
        }

        public Criteria andCarouselIdLessThan(Long value) {
            addCriterion("carousel_id <", value, "carouselId");
            return (Criteria) this;
        }

        public Criteria andCarouselIdLessThanOrEqualTo(Long value) {
            addCriterion("carousel_id <=", value, "carouselId");
            return (Criteria) this;
        }

        public Criteria andCarouselIdIn(List<Long> values) {
            addCriterion("carousel_id in", values, "carouselId");
            return (Criteria) this;
        }

        public Criteria andCarouselIdNotIn(List<Long> values) {
            addCriterion("carousel_id not in", values, "carouselId");
            return (Criteria) this;
        }

        public Criteria andCarouselIdBetween(Long value1, Long value2) {
            addCriterion("carousel_id between", value1, value2, "carouselId");
            return (Criteria) this;
        }

        public Criteria andCarouselIdNotBetween(Long value1, Long value2) {
            addCriterion("carousel_id not between", value1, value2, "carouselId");
            return (Criteria) this;
        }

        public Criteria andCarouselTypeIsNull() {
            addCriterion("carousel_type is null");
            return (Criteria) this;
        }

        public Criteria andCarouselTypeIsNotNull() {
            addCriterion("carousel_type is not null");
            return (Criteria) this;
        }

        public Criteria andCarouselTypeEqualTo(Integer value) {
            addCriterion("carousel_type =", value, "carouselType");
            return (Criteria) this;
        }

        public Criteria andCarouselTypeNotEqualTo(Integer value) {
            addCriterion("carousel_type <>", value, "carouselType");
            return (Criteria) this;
        }

        public Criteria andCarouselTypeGreaterThan(Integer value) {
            addCriterion("carousel_type >", value, "carouselType");
            return (Criteria) this;
        }

        public Criteria andCarouselTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("carousel_type >=", value, "carouselType");
            return (Criteria) this;
        }

        public Criteria andCarouselTypeLessThan(Integer value) {
            addCriterion("carousel_type <", value, "carouselType");
            return (Criteria) this;
        }

        public Criteria andCarouselTypeLessThanOrEqualTo(Integer value) {
            addCriterion("carousel_type <=", value, "carouselType");
            return (Criteria) this;
        }

        public Criteria andCarouselTypeIn(List<Integer> values) {
            addCriterion("carousel_type in", values, "carouselType");
            return (Criteria) this;
        }

        public Criteria andCarouselTypeNotIn(List<Integer> values) {
            addCriterion("carousel_type not in", values, "carouselType");
            return (Criteria) this;
        }

        public Criteria andCarouselTypeBetween(Integer value1, Integer value2) {
            addCriterion("carousel_type between", value1, value2, "carouselType");
            return (Criteria) this;
        }

        public Criteria andCarouselTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("carousel_type not between", value1, value2, "carouselType");
            return (Criteria) this;
        }

        public Criteria andCarouselUrlIsNull() {
            addCriterion("carousel_url is null");
            return (Criteria) this;
        }

        public Criteria andCarouselUrlIsNotNull() {
            addCriterion("carousel_url is not null");
            return (Criteria) this;
        }

        public Criteria andCarouselUrlEqualTo(String value) {
            addCriterion("carousel_url =", value, "carouselUrl");
            return (Criteria) this;
        }

        public Criteria andCarouselUrlNotEqualTo(String value) {
            addCriterion("carousel_url <>", value, "carouselUrl");
            return (Criteria) this;
        }

        public Criteria andCarouselUrlGreaterThan(String value) {
            addCriterion("carousel_url >", value, "carouselUrl");
            return (Criteria) this;
        }

        public Criteria andCarouselUrlGreaterThanOrEqualTo(String value) {
            addCriterion("carousel_url >=", value, "carouselUrl");
            return (Criteria) this;
        }

        public Criteria andCarouselUrlLessThan(String value) {
            addCriterion("carousel_url <", value, "carouselUrl");
            return (Criteria) this;
        }

        public Criteria andCarouselUrlLessThanOrEqualTo(String value) {
            addCriterion("carousel_url <=", value, "carouselUrl");
            return (Criteria) this;
        }

        public Criteria andCarouselUrlLike(String value) {
            addCriterion("carousel_url like", value, "carouselUrl");
            return (Criteria) this;
        }

        public Criteria andCarouselUrlNotLike(String value) {
            addCriterion("carousel_url not like", value, "carouselUrl");
            return (Criteria) this;
        }

        public Criteria andCarouselUrlIn(List<String> values) {
            addCriterion("carousel_url in", values, "carouselUrl");
            return (Criteria) this;
        }

        public Criteria andCarouselUrlNotIn(List<String> values) {
            addCriterion("carousel_url not in", values, "carouselUrl");
            return (Criteria) this;
        }

        public Criteria andCarouselUrlBetween(String value1, String value2) {
            addCriterion("carousel_url between", value1, value2, "carouselUrl");
            return (Criteria) this;
        }

        public Criteria andCarouselUrlNotBetween(String value1, String value2) {
            addCriterion("carousel_url not between", value1, value2, "carouselUrl");
            return (Criteria) this;
        }

        public Criteria andCarouselHrefIsNull() {
            addCriterion("carousel_href is null");
            return (Criteria) this;
        }

        public Criteria andCarouselHrefIsNotNull() {
            addCriterion("carousel_href is not null");
            return (Criteria) this;
        }

        public Criteria andCarouselHrefEqualTo(String value) {
            addCriterion("carousel_href =", value, "carouselHref");
            return (Criteria) this;
        }

        public Criteria andCarouselHrefNotEqualTo(String value) {
            addCriterion("carousel_href <>", value, "carouselHref");
            return (Criteria) this;
        }

        public Criteria andCarouselHrefGreaterThan(String value) {
            addCriterion("carousel_href >", value, "carouselHref");
            return (Criteria) this;
        }

        public Criteria andCarouselHrefGreaterThanOrEqualTo(String value) {
            addCriterion("carousel_href >=", value, "carouselHref");
            return (Criteria) this;
        }

        public Criteria andCarouselHrefLessThan(String value) {
            addCriterion("carousel_href <", value, "carouselHref");
            return (Criteria) this;
        }

        public Criteria andCarouselHrefLessThanOrEqualTo(String value) {
            addCriterion("carousel_href <=", value, "carouselHref");
            return (Criteria) this;
        }

        public Criteria andCarouselHrefLike(String value) {
            addCriterion("carousel_href like", value, "carouselHref");
            return (Criteria) this;
        }

        public Criteria andCarouselHrefNotLike(String value) {
            addCriterion("carousel_href not like", value, "carouselHref");
            return (Criteria) this;
        }

        public Criteria andCarouselHrefIn(List<String> values) {
            addCriterion("carousel_href in", values, "carouselHref");
            return (Criteria) this;
        }

        public Criteria andCarouselHrefNotIn(List<String> values) {
            addCriterion("carousel_href not in", values, "carouselHref");
            return (Criteria) this;
        }

        public Criteria andCarouselHrefBetween(String value1, String value2) {
            addCriterion("carousel_href between", value1, value2, "carouselHref");
            return (Criteria) this;
        }

        public Criteria andCarouselHrefNotBetween(String value1, String value2) {
            addCriterion("carousel_href not between", value1, value2, "carouselHref");
            return (Criteria) this;
        }

        public Criteria andUploadDateIsNull() {
            addCriterion("upload_date is null");
            return (Criteria) this;
        }

        public Criteria andUploadDateIsNotNull() {
            addCriterion("upload_date is not null");
            return (Criteria) this;
        }

        public Criteria andUploadDateEqualTo(Date value) {
            addCriterion("upload_date =", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateNotEqualTo(Date value) {
            addCriterion("upload_date <>", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateGreaterThan(Date value) {
            addCriterion("upload_date >", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateGreaterThanOrEqualTo(Date value) {
            addCriterion("upload_date >=", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateLessThan(Date value) {
            addCriterion("upload_date <", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateLessThanOrEqualTo(Date value) {
            addCriterion("upload_date <=", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateIn(List<Date> values) {
            addCriterion("upload_date in", values, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateNotIn(List<Date> values) {
            addCriterion("upload_date not in", values, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateBetween(Date value1, Date value2) {
            addCriterion("upload_date between", value1, value2, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateNotBetween(Date value1, Date value2) {
            addCriterion("upload_date not between", value1, value2, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andDeleteDateIsNull() {
            addCriterion("delete_date is null");
            return (Criteria) this;
        }

        public Criteria andDeleteDateIsNotNull() {
            addCriterion("delete_date is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteDateEqualTo(Date value) {
            addCriterion("delete_date =", value, "deleteDate");
            return (Criteria) this;
        }

        public Criteria andDeleteDateNotEqualTo(Date value) {
            addCriterion("delete_date <>", value, "deleteDate");
            return (Criteria) this;
        }

        public Criteria andDeleteDateGreaterThan(Date value) {
            addCriterion("delete_date >", value, "deleteDate");
            return (Criteria) this;
        }

        public Criteria andDeleteDateGreaterThanOrEqualTo(Date value) {
            addCriterion("delete_date >=", value, "deleteDate");
            return (Criteria) this;
        }

        public Criteria andDeleteDateLessThan(Date value) {
            addCriterion("delete_date <", value, "deleteDate");
            return (Criteria) this;
        }

        public Criteria andDeleteDateLessThanOrEqualTo(Date value) {
            addCriterion("delete_date <=", value, "deleteDate");
            return (Criteria) this;
        }

        public Criteria andDeleteDateIn(List<Date> values) {
            addCriterion("delete_date in", values, "deleteDate");
            return (Criteria) this;
        }

        public Criteria andDeleteDateNotIn(List<Date> values) {
            addCriterion("delete_date not in", values, "deleteDate");
            return (Criteria) this;
        }

        public Criteria andDeleteDateBetween(Date value1, Date value2) {
            addCriterion("delete_date between", value1, value2, "deleteDate");
            return (Criteria) this;
        }

        public Criteria andDeleteDateNotBetween(Date value1, Date value2) {
            addCriterion("delete_date not between", value1, value2, "deleteDate");
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
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