package com.shu.copartner.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ProRegisterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProRegisterExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAuthIsNull() {
            addCriterion("auth is null");
            return (Criteria) this;
        }

        public Criteria andAuthIsNotNull() {
            addCriterion("auth is not null");
            return (Criteria) this;
        }

        public Criteria andAuthEqualTo(String value) {
            addCriterion("auth =", value, "auth");
            return (Criteria) this;
        }

        public Criteria andAuthNotEqualTo(String value) {
            addCriterion("auth <>", value, "auth");
            return (Criteria) this;
        }

        public Criteria andAuthGreaterThan(String value) {
            addCriterion("auth >", value, "auth");
            return (Criteria) this;
        }

        public Criteria andAuthGreaterThanOrEqualTo(String value) {
            addCriterion("auth >=", value, "auth");
            return (Criteria) this;
        }

        public Criteria andAuthLessThan(String value) {
            addCriterion("auth <", value, "auth");
            return (Criteria) this;
        }

        public Criteria andAuthLessThanOrEqualTo(String value) {
            addCriterion("auth <=", value, "auth");
            return (Criteria) this;
        }

        public Criteria andAuthLike(String value) {
            addCriterion("auth like", value, "auth");
            return (Criteria) this;
        }

        public Criteria andAuthNotLike(String value) {
            addCriterion("auth not like", value, "auth");
            return (Criteria) this;
        }

        public Criteria andAuthIn(List<String> values) {
            addCriterion("auth in", values, "auth");
            return (Criteria) this;
        }

        public Criteria andAuthNotIn(List<String> values) {
            addCriterion("auth not in", values, "auth");
            return (Criteria) this;
        }

        public Criteria andAuthBetween(String value1, String value2) {
            addCriterion("auth between", value1, value2, "auth");
            return (Criteria) this;
        }

        public Criteria andAuthNotBetween(String value1, String value2) {
            addCriterion("auth not between", value1, value2, "auth");
            return (Criteria) this;
        }

        public Criteria andApplystatusIsNull() {
            addCriterion("applystatus is null");
            return (Criteria) this;
        }

        public Criteria andApplystatusIsNotNull() {
            addCriterion("applystatus is not null");
            return (Criteria) this;
        }

        public Criteria andApplystatusEqualTo(Integer value) {
            addCriterion("applystatus =", value, "applystatus");
            return (Criteria) this;
        }

        public Criteria andApplystatusNotEqualTo(Integer value) {
            addCriterion("applystatus <>", value, "applystatus");
            return (Criteria) this;
        }

        public Criteria andApplystatusGreaterThan(Integer value) {
            addCriterion("applystatus >", value, "applystatus");
            return (Criteria) this;
        }

        public Criteria andApplystatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("applystatus >=", value, "applystatus");
            return (Criteria) this;
        }

        public Criteria andApplystatusLessThan(Integer value) {
            addCriterion("applystatus <", value, "applystatus");
            return (Criteria) this;
        }

        public Criteria andApplystatusLessThanOrEqualTo(Integer value) {
            addCriterion("applystatus <=", value, "applystatus");
            return (Criteria) this;
        }

        public Criteria andApplystatusIn(List<Integer> values) {
            addCriterion("applystatus in", values, "applystatus");
            return (Criteria) this;
        }

        public Criteria andApplystatusNotIn(List<Integer> values) {
            addCriterion("applystatus not in", values, "applystatus");
            return (Criteria) this;
        }

        public Criteria andApplystatusBetween(Integer value1, Integer value2) {
            addCriterion("applystatus between", value1, value2, "applystatus");
            return (Criteria) this;
        }

        public Criteria andApplystatusNotBetween(Integer value1, Integer value2) {
            addCriterion("applystatus not between", value1, value2, "applystatus");
            return (Criteria) this;
        }

        public Criteria andAdviceIsNull() {
            addCriterion("advice is null");
            return (Criteria) this;
        }

        public Criteria andAdviceIsNotNull() {
            addCriterion("advice is not null");
            return (Criteria) this;
        }

        public Criteria andAdviceEqualTo(String value) {
            addCriterion("advice =", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceNotEqualTo(String value) {
            addCriterion("advice <>", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceGreaterThan(String value) {
            addCriterion("advice >", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceGreaterThanOrEqualTo(String value) {
            addCriterion("advice >=", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceLessThan(String value) {
            addCriterion("advice <", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceLessThanOrEqualTo(String value) {
            addCriterion("advice <=", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceLike(String value) {
            addCriterion("advice like", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceNotLike(String value) {
            addCriterion("advice not like", value, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceIn(List<String> values) {
            addCriterion("advice in", values, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceNotIn(List<String> values) {
            addCriterion("advice not in", values, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceBetween(String value1, String value2) {
            addCriterion("advice between", value1, value2, "advice");
            return (Criteria) this;
        }

        public Criteria andAdviceNotBetween(String value1, String value2) {
            addCriterion("advice not between", value1, value2, "advice");
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

        public Criteria andApplydateIsNull() {
            addCriterion("applydate is null");
            return (Criteria) this;
        }

        public Criteria andApplydateIsNotNull() {
            addCriterion("applydate is not null");
            return (Criteria) this;
        }

        public Criteria andApplydateEqualTo(Date value) {
            addCriterion("applydate =", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateNotEqualTo(Date value) {
            addCriterion("applydate <>", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateGreaterThan(Date value) {
            addCriterion("applydate >", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateGreaterThanOrEqualTo(Date value) {
            addCriterion("applydate >=", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateLessThan(Date value) {
            addCriterion("applydate <", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateLessThanOrEqualTo(Date value) {
            addCriterion("applydate <=", value, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateIn(List<Date> values) {
            addCriterion("applydate in", values, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateNotIn(List<Date> values) {
            addCriterion("applydate not in", values, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateBetween(Date value1, Date value2) {
            addCriterion("applydate between", value1, value2, "applydate");
            return (Criteria) this;
        }

        public Criteria andApplydateNotBetween(Date value1, Date value2) {
            addCriterion("applydate not between", value1, value2, "applydate");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthDay is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthDay is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(Date value) {
            addCriterion("birthDay =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(Date value) {
            addCriterion("birthDay <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(Date value) {
            addCriterion("birthDay >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterion("birthDay >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(Date value) {
            addCriterion("birthDay <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(Date value) {
            addCriterion("birthDay <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<Date> values) {
            addCriterion("birthDay in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<Date> values) {
            addCriterion("birthDay not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(Date value1, Date value2) {
            addCriterion("birthDay between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(Date value1, Date value2) {
            addCriterion("birthDay not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andCampusIsNull() {
            addCriterion("campus is null");
            return (Criteria) this;
        }

        public Criteria andCampusIsNotNull() {
            addCriterion("campus is not null");
            return (Criteria) this;
        }

        public Criteria andCampusEqualTo(String value) {
            addCriterion("campus =", value, "campus");
            return (Criteria) this;
        }

        public Criteria andCampusNotEqualTo(String value) {
            addCriterion("campus <>", value, "campus");
            return (Criteria) this;
        }

        public Criteria andCampusGreaterThan(String value) {
            addCriterion("campus >", value, "campus");
            return (Criteria) this;
        }

        public Criteria andCampusGreaterThanOrEqualTo(String value) {
            addCriterion("campus >=", value, "campus");
            return (Criteria) this;
        }

        public Criteria andCampusLessThan(String value) {
            addCriterion("campus <", value, "campus");
            return (Criteria) this;
        }

        public Criteria andCampusLessThanOrEqualTo(String value) {
            addCriterion("campus <=", value, "campus");
            return (Criteria) this;
        }

        public Criteria andCampusLike(String value) {
            addCriterion("campus like", value, "campus");
            return (Criteria) this;
        }

        public Criteria andCampusNotLike(String value) {
            addCriterion("campus not like", value, "campus");
            return (Criteria) this;
        }

        public Criteria andCampusIn(List<String> values) {
            addCriterion("campus in", values, "campus");
            return (Criteria) this;
        }

        public Criteria andCampusNotIn(List<String> values) {
            addCriterion("campus not in", values, "campus");
            return (Criteria) this;
        }

        public Criteria andCampusBetween(String value1, String value2) {
            addCriterion("campus between", value1, value2, "campus");
            return (Criteria) this;
        }

        public Criteria andCampusNotBetween(String value1, String value2) {
            addCriterion("campus not between", value1, value2, "campus");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNull() {
            addCriterion("company is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIsNotNull() {
            addCriterion("company is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyEqualTo(String value) {
            addCriterion("company =", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotEqualTo(String value) {
            addCriterion("company <>", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThan(String value) {
            addCriterion("company >", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("company >=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThan(String value) {
            addCriterion("company <", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLessThanOrEqualTo(String value) {
            addCriterion("company <=", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyLike(String value) {
            addCriterion("company like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotLike(String value) {
            addCriterion("company not like", value, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyIn(List<String> values) {
            addCriterion("company in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotIn(List<String> values) {
            addCriterion("company not in", values, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyBetween(String value1, String value2) {
            addCriterion("company between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andCompanyNotBetween(String value1, String value2) {
            addCriterion("company not between", value1, value2, "company");
            return (Criteria) this;
        }

        public Criteria andEducationIsNull() {
            addCriterion("education is null");
            return (Criteria) this;
        }

        public Criteria andEducationIsNotNull() {
            addCriterion("education is not null");
            return (Criteria) this;
        }

        public Criteria andEducationEqualTo(String value) {
            addCriterion("education =", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotEqualTo(String value) {
            addCriterion("education <>", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThan(String value) {
            addCriterion("education >", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationGreaterThanOrEqualTo(String value) {
            addCriterion("education >=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThan(String value) {
            addCriterion("education <", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLessThanOrEqualTo(String value) {
            addCriterion("education <=", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationLike(String value) {
            addCriterion("education like", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotLike(String value) {
            addCriterion("education not like", value, "education");
            return (Criteria) this;
        }

        public Criteria andEducationIn(List<String> values) {
            addCriterion("education in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotIn(List<String> values) {
            addCriterion("education not in", values, "education");
            return (Criteria) this;
        }

        public Criteria andEducationBetween(String value1, String value2) {
            addCriterion("education between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andEducationNotBetween(String value1, String value2) {
            addCriterion("education not between", value1, value2, "education");
            return (Criteria) this;
        }

        public Criteria andGradutedateIsNull() {
            addCriterion("gradutedate is null");
            return (Criteria) this;
        }

        public Criteria andGradutedateIsNotNull() {
            addCriterion("gradutedate is not null");
            return (Criteria) this;
        }

        public Criteria andGradutedateEqualTo(Date value) {
            addCriterionForJDBCDate("gradutedate =", value, "gradutedate");
            return (Criteria) this;
        }

        public Criteria andGradutedateNotEqualTo(Date value) {
            addCriterionForJDBCDate("gradutedate <>", value, "gradutedate");
            return (Criteria) this;
        }

        public Criteria andGradutedateGreaterThan(Date value) {
            addCriterionForJDBCDate("gradutedate >", value, "gradutedate");
            return (Criteria) this;
        }

        public Criteria andGradutedateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("gradutedate >=", value, "gradutedate");
            return (Criteria) this;
        }

        public Criteria andGradutedateLessThan(Date value) {
            addCriterionForJDBCDate("gradutedate <", value, "gradutedate");
            return (Criteria) this;
        }

        public Criteria andGradutedateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("gradutedate <=", value, "gradutedate");
            return (Criteria) this;
        }

        public Criteria andGradutedateIn(List<Date> values) {
            addCriterionForJDBCDate("gradutedate in", values, "gradutedate");
            return (Criteria) this;
        }

        public Criteria andGradutedateNotIn(List<Date> values) {
            addCriterionForJDBCDate("gradutedate not in", values, "gradutedate");
            return (Criteria) this;
        }

        public Criteria andGradutedateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("gradutedate between", value1, value2, "gradutedate");
            return (Criteria) this;
        }

        public Criteria andGradutedateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("gradutedate not between", value1, value2, "gradutedate");
            return (Criteria) this;
        }

        public Criteria andMajorIsNull() {
            addCriterion("major is null");
            return (Criteria) this;
        }

        public Criteria andMajorIsNotNull() {
            addCriterion("major is not null");
            return (Criteria) this;
        }

        public Criteria andMajorEqualTo(String value) {
            addCriterion("major =", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotEqualTo(String value) {
            addCriterion("major <>", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThan(String value) {
            addCriterion("major >", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorGreaterThanOrEqualTo(String value) {
            addCriterion("major >=", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThan(String value) {
            addCriterion("major <", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLessThanOrEqualTo(String value) {
            addCriterion("major <=", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorLike(String value) {
            addCriterion("major like", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotLike(String value) {
            addCriterion("major not like", value, "major");
            return (Criteria) this;
        }

        public Criteria andMajorIn(List<String> values) {
            addCriterion("major in", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotIn(List<String> values) {
            addCriterion("major not in", values, "major");
            return (Criteria) this;
        }

        public Criteria andMajorBetween(String value1, String value2) {
            addCriterion("major between", value1, value2, "major");
            return (Criteria) this;
        }

        public Criteria andMajorNotBetween(String value1, String value2) {
            addCriterion("major not between", value1, value2, "major");
            return (Criteria) this;
        }

        public Criteria andWorkernameIsNull() {
            addCriterion("workername is null");
            return (Criteria) this;
        }

        public Criteria andWorkernameIsNotNull() {
            addCriterion("workername is not null");
            return (Criteria) this;
        }

        public Criteria andWorkernameEqualTo(String value) {
            addCriterion("workername =", value, "workername");
            return (Criteria) this;
        }

        public Criteria andWorkernameNotEqualTo(String value) {
            addCriterion("workername <>", value, "workername");
            return (Criteria) this;
        }

        public Criteria andWorkernameGreaterThan(String value) {
            addCriterion("workername >", value, "workername");
            return (Criteria) this;
        }

        public Criteria andWorkernameGreaterThanOrEqualTo(String value) {
            addCriterion("workername >=", value, "workername");
            return (Criteria) this;
        }

        public Criteria andWorkernameLessThan(String value) {
            addCriterion("workername <", value, "workername");
            return (Criteria) this;
        }

        public Criteria andWorkernameLessThanOrEqualTo(String value) {
            addCriterion("workername <=", value, "workername");
            return (Criteria) this;
        }

        public Criteria andWorkernameLike(String value) {
            addCriterion("workername like", value, "workername");
            return (Criteria) this;
        }

        public Criteria andWorkernameNotLike(String value) {
            addCriterion("workername not like", value, "workername");
            return (Criteria) this;
        }

        public Criteria andWorkernameIn(List<String> values) {
            addCriterion("workername in", values, "workername");
            return (Criteria) this;
        }

        public Criteria andWorkernameNotIn(List<String> values) {
            addCriterion("workername not in", values, "workername");
            return (Criteria) this;
        }

        public Criteria andWorkernameBetween(String value1, String value2) {
            addCriterion("workername between", value1, value2, "workername");
            return (Criteria) this;
        }

        public Criteria andWorkernameNotBetween(String value1, String value2) {
            addCriterion("workername not between", value1, value2, "workername");
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

        public Criteria andSupervisorIsNull() {
            addCriterion("supervisor is null");
            return (Criteria) this;
        }

        public Criteria andSupervisorIsNotNull() {
            addCriterion("supervisor is not null");
            return (Criteria) this;
        }

        public Criteria andSupervisorEqualTo(Boolean value) {
            addCriterion("supervisor =", value, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorNotEqualTo(Boolean value) {
            addCriterion("supervisor <>", value, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorGreaterThan(Boolean value) {
            addCriterion("supervisor >", value, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorGreaterThanOrEqualTo(Boolean value) {
            addCriterion("supervisor >=", value, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorLessThan(Boolean value) {
            addCriterion("supervisor <", value, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorLessThanOrEqualTo(Boolean value) {
            addCriterion("supervisor <=", value, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorIn(List<Boolean> values) {
            addCriterion("supervisor in", values, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorNotIn(List<Boolean> values) {
            addCriterion("supervisor not in", values, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorBetween(Boolean value1, Boolean value2) {
            addCriterion("supervisor between", value1, value2, "supervisor");
            return (Criteria) this;
        }

        public Criteria andSupervisorNotBetween(Boolean value1, Boolean value2) {
            addCriterion("supervisor not between", value1, value2, "supervisor");
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

        public Criteria andDepartmentIsNull() {
            addCriterion("department is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNotNull() {
            addCriterion("department is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentEqualTo(String value) {
            addCriterion("department =", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotEqualTo(String value) {
            addCriterion("department <>", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThan(String value) {
            addCriterion("department >", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("department >=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThan(String value) {
            addCriterion("department <", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThanOrEqualTo(String value) {
            addCriterion("department <=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLike(String value) {
            addCriterion("department like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotLike(String value) {
            addCriterion("department not like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentIn(List<String> values) {
            addCriterion("department in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotIn(List<String> values) {
            addCriterion("department not in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentBetween(String value1, String value2) {
            addCriterion("department between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotBetween(String value1, String value2) {
            addCriterion("department not between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andAdmissiondateIsNull() {
            addCriterion("admissiondate is null");
            return (Criteria) this;
        }

        public Criteria andAdmissiondateIsNotNull() {
            addCriterion("admissiondate is not null");
            return (Criteria) this;
        }

        public Criteria andAdmissiondateEqualTo(Date value) {
            addCriterionForJDBCDate("admissiondate =", value, "admissiondate");
            return (Criteria) this;
        }

        public Criteria andAdmissiondateNotEqualTo(Date value) {
            addCriterionForJDBCDate("admissiondate <>", value, "admissiondate");
            return (Criteria) this;
        }

        public Criteria andAdmissiondateGreaterThan(Date value) {
            addCriterionForJDBCDate("admissiondate >", value, "admissiondate");
            return (Criteria) this;
        }

        public Criteria andAdmissiondateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("admissiondate >=", value, "admissiondate");
            return (Criteria) this;
        }

        public Criteria andAdmissiondateLessThan(Date value) {
            addCriterionForJDBCDate("admissiondate <", value, "admissiondate");
            return (Criteria) this;
        }

        public Criteria andAdmissiondateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("admissiondate <=", value, "admissiondate");
            return (Criteria) this;
        }

        public Criteria andAdmissiondateIn(List<Date> values) {
            addCriterionForJDBCDate("admissiondate in", values, "admissiondate");
            return (Criteria) this;
        }

        public Criteria andAdmissiondateNotIn(List<Date> values) {
            addCriterionForJDBCDate("admissiondate not in", values, "admissiondate");
            return (Criteria) this;
        }

        public Criteria andAdmissiondateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("admissiondate between", value1, value2, "admissiondate");
            return (Criteria) this;
        }

        public Criteria andAdmissiondateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("admissiondate not between", value1, value2, "admissiondate");
            return (Criteria) this;
        }

        public Criteria andStudentnumberIsNull() {
            addCriterion("studentnumber is null");
            return (Criteria) this;
        }

        public Criteria andStudentnumberIsNotNull() {
            addCriterion("studentnumber is not null");
            return (Criteria) this;
        }

        public Criteria andStudentnumberEqualTo(String value) {
            addCriterion("studentnumber =", value, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberNotEqualTo(String value) {
            addCriterion("studentnumber <>", value, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberGreaterThan(String value) {
            addCriterion("studentnumber >", value, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberGreaterThanOrEqualTo(String value) {
            addCriterion("studentnumber >=", value, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberLessThan(String value) {
            addCriterion("studentnumber <", value, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberLessThanOrEqualTo(String value) {
            addCriterion("studentnumber <=", value, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberLike(String value) {
            addCriterion("studentnumber like", value, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberNotLike(String value) {
            addCriterion("studentnumber not like", value, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberIn(List<String> values) {
            addCriterion("studentnumber in", values, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberNotIn(List<String> values) {
            addCriterion("studentnumber not in", values, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberBetween(String value1, String value2) {
            addCriterion("studentnumber between", value1, value2, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andStudentnumberNotBetween(String value1, String value2) {
            addCriterion("studentnumber not between", value1, value2, "studentnumber");
            return (Criteria) this;
        }

        public Criteria andTeachernumberIsNull() {
            addCriterion("teachernumber is null");
            return (Criteria) this;
        }

        public Criteria andTeachernumberIsNotNull() {
            addCriterion("teachernumber is not null");
            return (Criteria) this;
        }

        public Criteria andTeachernumberEqualTo(String value) {
            addCriterion("teachernumber =", value, "teachernumber");
            return (Criteria) this;
        }

        public Criteria andTeachernumberNotEqualTo(String value) {
            addCriterion("teachernumber <>", value, "teachernumber");
            return (Criteria) this;
        }

        public Criteria andTeachernumberGreaterThan(String value) {
            addCriterion("teachernumber >", value, "teachernumber");
            return (Criteria) this;
        }

        public Criteria andTeachernumberGreaterThanOrEqualTo(String value) {
            addCriterion("teachernumber >=", value, "teachernumber");
            return (Criteria) this;
        }

        public Criteria andTeachernumberLessThan(String value) {
            addCriterion("teachernumber <", value, "teachernumber");
            return (Criteria) this;
        }

        public Criteria andTeachernumberLessThanOrEqualTo(String value) {
            addCriterion("teachernumber <=", value, "teachernumber");
            return (Criteria) this;
        }

        public Criteria andTeachernumberLike(String value) {
            addCriterion("teachernumber like", value, "teachernumber");
            return (Criteria) this;
        }

        public Criteria andTeachernumberNotLike(String value) {
            addCriterion("teachernumber not like", value, "teachernumber");
            return (Criteria) this;
        }

        public Criteria andTeachernumberIn(List<String> values) {
            addCriterion("teachernumber in", values, "teachernumber");
            return (Criteria) this;
        }

        public Criteria andTeachernumberNotIn(List<String> values) {
            addCriterion("teachernumber not in", values, "teachernumber");
            return (Criteria) this;
        }

        public Criteria andTeachernumberBetween(String value1, String value2) {
            addCriterion("teachernumber between", value1, value2, "teachernumber");
            return (Criteria) this;
        }

        public Criteria andTeachernumberNotBetween(String value1, String value2) {
            addCriterion("teachernumber not between", value1, value2, "teachernumber");
            return (Criteria) this;
        }

        public Criteria andMailIsNull() {
            addCriterion("mail is null");
            return (Criteria) this;
        }

        public Criteria andMailIsNotNull() {
            addCriterion("mail is not null");
            return (Criteria) this;
        }

        public Criteria andMailEqualTo(String value) {
            addCriterion("mail =", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotEqualTo(String value) {
            addCriterion("mail <>", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailGreaterThan(String value) {
            addCriterion("mail >", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailGreaterThanOrEqualTo(String value) {
            addCriterion("mail >=", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailLessThan(String value) {
            addCriterion("mail <", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailLessThanOrEqualTo(String value) {
            addCriterion("mail <=", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailLike(String value) {
            addCriterion("mail like", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotLike(String value) {
            addCriterion("mail not like", value, "mail");
            return (Criteria) this;
        }

        public Criteria andMailIn(List<String> values) {
            addCriterion("mail in", values, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotIn(List<String> values) {
            addCriterion("mail not in", values, "mail");
            return (Criteria) this;
        }

        public Criteria andMailBetween(String value1, String value2) {
            addCriterion("mail between", value1, value2, "mail");
            return (Criteria) this;
        }

        public Criteria andMailNotBetween(String value1, String value2) {
            addCriterion("mail not between", value1, value2, "mail");
            return (Criteria) this;
        }

        public Criteria andExpectprojectIsNull() {
            addCriterion("expectproject is null");
            return (Criteria) this;
        }

        public Criteria andExpectprojectIsNotNull() {
            addCriterion("expectproject is not null");
            return (Criteria) this;
        }

        public Criteria andExpectprojectEqualTo(String value) {
            addCriterion("expectproject =", value, "expectproject");
            return (Criteria) this;
        }

        public Criteria andExpectprojectNotEqualTo(String value) {
            addCriterion("expectproject <>", value, "expectproject");
            return (Criteria) this;
        }

        public Criteria andExpectprojectGreaterThan(String value) {
            addCriterion("expectproject >", value, "expectproject");
            return (Criteria) this;
        }

        public Criteria andExpectprojectGreaterThanOrEqualTo(String value) {
            addCriterion("expectproject >=", value, "expectproject");
            return (Criteria) this;
        }

        public Criteria andExpectprojectLessThan(String value) {
            addCriterion("expectproject <", value, "expectproject");
            return (Criteria) this;
        }

        public Criteria andExpectprojectLessThanOrEqualTo(String value) {
            addCriterion("expectproject <=", value, "expectproject");
            return (Criteria) this;
        }

        public Criteria andExpectprojectLike(String value) {
            addCriterion("expectproject like", value, "expectproject");
            return (Criteria) this;
        }

        public Criteria andExpectprojectNotLike(String value) {
            addCriterion("expectproject not like", value, "expectproject");
            return (Criteria) this;
        }

        public Criteria andExpectprojectIn(List<String> values) {
            addCriterion("expectproject in", values, "expectproject");
            return (Criteria) this;
        }

        public Criteria andExpectprojectNotIn(List<String> values) {
            addCriterion("expectproject not in", values, "expectproject");
            return (Criteria) this;
        }

        public Criteria andExpectprojectBetween(String value1, String value2) {
            addCriterion("expectproject between", value1, value2, "expectproject");
            return (Criteria) this;
        }

        public Criteria andExpectprojectNotBetween(String value1, String value2) {
            addCriterion("expectproject not between", value1, value2, "expectproject");
            return (Criteria) this;
        }

        public Criteria andExpectstudentIsNull() {
            addCriterion("expectstudent is null");
            return (Criteria) this;
        }

        public Criteria andExpectstudentIsNotNull() {
            addCriterion("expectstudent is not null");
            return (Criteria) this;
        }

        public Criteria andExpectstudentEqualTo(String value) {
            addCriterion("expectstudent =", value, "expectstudent");
            return (Criteria) this;
        }

        public Criteria andExpectstudentNotEqualTo(String value) {
            addCriterion("expectstudent <>", value, "expectstudent");
            return (Criteria) this;
        }

        public Criteria andExpectstudentGreaterThan(String value) {
            addCriterion("expectstudent >", value, "expectstudent");
            return (Criteria) this;
        }

        public Criteria andExpectstudentGreaterThanOrEqualTo(String value) {
            addCriterion("expectstudent >=", value, "expectstudent");
            return (Criteria) this;
        }

        public Criteria andExpectstudentLessThan(String value) {
            addCriterion("expectstudent <", value, "expectstudent");
            return (Criteria) this;
        }

        public Criteria andExpectstudentLessThanOrEqualTo(String value) {
            addCriterion("expectstudent <=", value, "expectstudent");
            return (Criteria) this;
        }

        public Criteria andExpectstudentLike(String value) {
            addCriterion("expectstudent like", value, "expectstudent");
            return (Criteria) this;
        }

        public Criteria andExpectstudentNotLike(String value) {
            addCriterion("expectstudent not like", value, "expectstudent");
            return (Criteria) this;
        }

        public Criteria andExpectstudentIn(List<String> values) {
            addCriterion("expectstudent in", values, "expectstudent");
            return (Criteria) this;
        }

        public Criteria andExpectstudentNotIn(List<String> values) {
            addCriterion("expectstudent not in", values, "expectstudent");
            return (Criteria) this;
        }

        public Criteria andExpectstudentBetween(String value1, String value2) {
            addCriterion("expectstudent between", value1, value2, "expectstudent");
            return (Criteria) this;
        }

        public Criteria andExpectstudentNotBetween(String value1, String value2) {
            addCriterion("expectstudent not between", value1, value2, "expectstudent");
            return (Criteria) this;
        }

        public Criteria andExpectotherIsNull() {
            addCriterion("expectother is null");
            return (Criteria) this;
        }

        public Criteria andExpectotherIsNotNull() {
            addCriterion("expectother is not null");
            return (Criteria) this;
        }

        public Criteria andExpectotherEqualTo(String value) {
            addCriterion("expectother =", value, "expectother");
            return (Criteria) this;
        }

        public Criteria andExpectotherNotEqualTo(String value) {
            addCriterion("expectother <>", value, "expectother");
            return (Criteria) this;
        }

        public Criteria andExpectotherGreaterThan(String value) {
            addCriterion("expectother >", value, "expectother");
            return (Criteria) this;
        }

        public Criteria andExpectotherGreaterThanOrEqualTo(String value) {
            addCriterion("expectother >=", value, "expectother");
            return (Criteria) this;
        }

        public Criteria andExpectotherLessThan(String value) {
            addCriterion("expectother <", value, "expectother");
            return (Criteria) this;
        }

        public Criteria andExpectotherLessThanOrEqualTo(String value) {
            addCriterion("expectother <=", value, "expectother");
            return (Criteria) this;
        }

        public Criteria andExpectotherLike(String value) {
            addCriterion("expectother like", value, "expectother");
            return (Criteria) this;
        }

        public Criteria andExpectotherNotLike(String value) {
            addCriterion("expectother not like", value, "expectother");
            return (Criteria) this;
        }

        public Criteria andExpectotherIn(List<String> values) {
            addCriterion("expectother in", values, "expectother");
            return (Criteria) this;
        }

        public Criteria andExpectotherNotIn(List<String> values) {
            addCriterion("expectother not in", values, "expectother");
            return (Criteria) this;
        }

        public Criteria andExpectotherBetween(String value1, String value2) {
            addCriterion("expectother between", value1, value2, "expectother");
            return (Criteria) this;
        }

        public Criteria andExpectotherNotBetween(String value1, String value2) {
            addCriterion("expectother not between", value1, value2, "expectother");
            return (Criteria) this;
        }

        public Criteria andLabelpersonIsNull() {
            addCriterion("labelperson is null");
            return (Criteria) this;
        }

        public Criteria andLabelpersonIsNotNull() {
            addCriterion("labelperson is not null");
            return (Criteria) this;
        }

        public Criteria andLabelpersonEqualTo(String value) {
            addCriterion("labelperson =", value, "labelperson");
            return (Criteria) this;
        }

        public Criteria andLabelpersonNotEqualTo(String value) {
            addCriterion("labelperson <>", value, "labelperson");
            return (Criteria) this;
        }

        public Criteria andLabelpersonGreaterThan(String value) {
            addCriterion("labelperson >", value, "labelperson");
            return (Criteria) this;
        }

        public Criteria andLabelpersonGreaterThanOrEqualTo(String value) {
            addCriterion("labelperson >=", value, "labelperson");
            return (Criteria) this;
        }

        public Criteria andLabelpersonLessThan(String value) {
            addCriterion("labelperson <", value, "labelperson");
            return (Criteria) this;
        }

        public Criteria andLabelpersonLessThanOrEqualTo(String value) {
            addCriterion("labelperson <=", value, "labelperson");
            return (Criteria) this;
        }

        public Criteria andLabelpersonLike(String value) {
            addCriterion("labelperson like", value, "labelperson");
            return (Criteria) this;
        }

        public Criteria andLabelpersonNotLike(String value) {
            addCriterion("labelperson not like", value, "labelperson");
            return (Criteria) this;
        }

        public Criteria andLabelpersonIn(List<String> values) {
            addCriterion("labelperson in", values, "labelperson");
            return (Criteria) this;
        }

        public Criteria andLabelpersonNotIn(List<String> values) {
            addCriterion("labelperson not in", values, "labelperson");
            return (Criteria) this;
        }

        public Criteria andLabelpersonBetween(String value1, String value2) {
            addCriterion("labelperson between", value1, value2, "labelperson");
            return (Criteria) this;
        }

        public Criteria andLabelpersonNotBetween(String value1, String value2) {
            addCriterion("labelperson not between", value1, value2, "labelperson");
            return (Criteria) this;
        }

        public Criteria andLabelalumnusIsNull() {
            addCriterion("labelalumnus is null");
            return (Criteria) this;
        }

        public Criteria andLabelalumnusIsNotNull() {
            addCriterion("labelalumnus is not null");
            return (Criteria) this;
        }

        public Criteria andLabelalumnusEqualTo(String value) {
            addCriterion("labelalumnus =", value, "labelalumnus");
            return (Criteria) this;
        }

        public Criteria andLabelalumnusNotEqualTo(String value) {
            addCriterion("labelalumnus <>", value, "labelalumnus");
            return (Criteria) this;
        }

        public Criteria andLabelalumnusGreaterThan(String value) {
            addCriterion("labelalumnus >", value, "labelalumnus");
            return (Criteria) this;
        }

        public Criteria andLabelalumnusGreaterThanOrEqualTo(String value) {
            addCriterion("labelalumnus >=", value, "labelalumnus");
            return (Criteria) this;
        }

        public Criteria andLabelalumnusLessThan(String value) {
            addCriterion("labelalumnus <", value, "labelalumnus");
            return (Criteria) this;
        }

        public Criteria andLabelalumnusLessThanOrEqualTo(String value) {
            addCriterion("labelalumnus <=", value, "labelalumnus");
            return (Criteria) this;
        }

        public Criteria andLabelalumnusLike(String value) {
            addCriterion("labelalumnus like", value, "labelalumnus");
            return (Criteria) this;
        }

        public Criteria andLabelalumnusNotLike(String value) {
            addCriterion("labelalumnus not like", value, "labelalumnus");
            return (Criteria) this;
        }

        public Criteria andLabelalumnusIn(List<String> values) {
            addCriterion("labelalumnus in", values, "labelalumnus");
            return (Criteria) this;
        }

        public Criteria andLabelalumnusNotIn(List<String> values) {
            addCriterion("labelalumnus not in", values, "labelalumnus");
            return (Criteria) this;
        }

        public Criteria andLabelalumnusBetween(String value1, String value2) {
            addCriterion("labelalumnus between", value1, value2, "labelalumnus");
            return (Criteria) this;
        }

        public Criteria andLabelalumnusNotBetween(String value1, String value2) {
            addCriterion("labelalumnus not between", value1, value2, "labelalumnus");
            return (Criteria) this;
        }

        public Criteria andLabelalumnicompanyIsNull() {
            addCriterion("labelalumnicompany is null");
            return (Criteria) this;
        }

        public Criteria andLabelalumnicompanyIsNotNull() {
            addCriterion("labelalumnicompany is not null");
            return (Criteria) this;
        }

        public Criteria andLabelalumnicompanyEqualTo(String value) {
            addCriterion("labelalumnicompany =", value, "labelalumnicompany");
            return (Criteria) this;
        }

        public Criteria andLabelalumnicompanyNotEqualTo(String value) {
            addCriterion("labelalumnicompany <>", value, "labelalumnicompany");
            return (Criteria) this;
        }

        public Criteria andLabelalumnicompanyGreaterThan(String value) {
            addCriterion("labelalumnicompany >", value, "labelalumnicompany");
            return (Criteria) this;
        }

        public Criteria andLabelalumnicompanyGreaterThanOrEqualTo(String value) {
            addCriterion("labelalumnicompany >=", value, "labelalumnicompany");
            return (Criteria) this;
        }

        public Criteria andLabelalumnicompanyLessThan(String value) {
            addCriterion("labelalumnicompany <", value, "labelalumnicompany");
            return (Criteria) this;
        }

        public Criteria andLabelalumnicompanyLessThanOrEqualTo(String value) {
            addCriterion("labelalumnicompany <=", value, "labelalumnicompany");
            return (Criteria) this;
        }

        public Criteria andLabelalumnicompanyLike(String value) {
            addCriterion("labelalumnicompany like", value, "labelalumnicompany");
            return (Criteria) this;
        }

        public Criteria andLabelalumnicompanyNotLike(String value) {
            addCriterion("labelalumnicompany not like", value, "labelalumnicompany");
            return (Criteria) this;
        }

        public Criteria andLabelalumnicompanyIn(List<String> values) {
            addCriterion("labelalumnicompany in", values, "labelalumnicompany");
            return (Criteria) this;
        }

        public Criteria andLabelalumnicompanyNotIn(List<String> values) {
            addCriterion("labelalumnicompany not in", values, "labelalumnicompany");
            return (Criteria) this;
        }

        public Criteria andLabelalumnicompanyBetween(String value1, String value2) {
            addCriterion("labelalumnicompany between", value1, value2, "labelalumnicompany");
            return (Criteria) this;
        }

        public Criteria andLabelalumnicompanyNotBetween(String value1, String value2) {
            addCriterion("labelalumnicompany not between", value1, value2, "labelalumnicompany");
            return (Criteria) this;
        }

        public Criteria andLabelincubatorIsNull() {
            addCriterion("labelincubator is null");
            return (Criteria) this;
        }

        public Criteria andLabelincubatorIsNotNull() {
            addCriterion("labelincubator is not null");
            return (Criteria) this;
        }

        public Criteria andLabelincubatorEqualTo(String value) {
            addCriterion("labelincubator =", value, "labelincubator");
            return (Criteria) this;
        }

        public Criteria andLabelincubatorNotEqualTo(String value) {
            addCriterion("labelincubator <>", value, "labelincubator");
            return (Criteria) this;
        }

        public Criteria andLabelincubatorGreaterThan(String value) {
            addCriterion("labelincubator >", value, "labelincubator");
            return (Criteria) this;
        }

        public Criteria andLabelincubatorGreaterThanOrEqualTo(String value) {
            addCriterion("labelincubator >=", value, "labelincubator");
            return (Criteria) this;
        }

        public Criteria andLabelincubatorLessThan(String value) {
            addCriterion("labelincubator <", value, "labelincubator");
            return (Criteria) this;
        }

        public Criteria andLabelincubatorLessThanOrEqualTo(String value) {
            addCriterion("labelincubator <=", value, "labelincubator");
            return (Criteria) this;
        }

        public Criteria andLabelincubatorLike(String value) {
            addCriterion("labelincubator like", value, "labelincubator");
            return (Criteria) this;
        }

        public Criteria andLabelincubatorNotLike(String value) {
            addCriterion("labelincubator not like", value, "labelincubator");
            return (Criteria) this;
        }

        public Criteria andLabelincubatorIn(List<String> values) {
            addCriterion("labelincubator in", values, "labelincubator");
            return (Criteria) this;
        }

        public Criteria andLabelincubatorNotIn(List<String> values) {
            addCriterion("labelincubator not in", values, "labelincubator");
            return (Criteria) this;
        }

        public Criteria andLabelincubatorBetween(String value1, String value2) {
            addCriterion("labelincubator between", value1, value2, "labelincubator");
            return (Criteria) this;
        }

        public Criteria andLabelincubatorNotBetween(String value1, String value2) {
            addCriterion("labelincubator not between", value1, value2, "labelincubator");
            return (Criteria) this;
        }

        public Criteria andLabelinstitutionsIsNull() {
            addCriterion("labelinstitutions is null");
            return (Criteria) this;
        }

        public Criteria andLabelinstitutionsIsNotNull() {
            addCriterion("labelinstitutions is not null");
            return (Criteria) this;
        }

        public Criteria andLabelinstitutionsEqualTo(String value) {
            addCriterion("labelinstitutions =", value, "labelinstitutions");
            return (Criteria) this;
        }

        public Criteria andLabelinstitutionsNotEqualTo(String value) {
            addCriterion("labelinstitutions <>", value, "labelinstitutions");
            return (Criteria) this;
        }

        public Criteria andLabelinstitutionsGreaterThan(String value) {
            addCriterion("labelinstitutions >", value, "labelinstitutions");
            return (Criteria) this;
        }

        public Criteria andLabelinstitutionsGreaterThanOrEqualTo(String value) {
            addCriterion("labelinstitutions >=", value, "labelinstitutions");
            return (Criteria) this;
        }

        public Criteria andLabelinstitutionsLessThan(String value) {
            addCriterion("labelinstitutions <", value, "labelinstitutions");
            return (Criteria) this;
        }

        public Criteria andLabelinstitutionsLessThanOrEqualTo(String value) {
            addCriterion("labelinstitutions <=", value, "labelinstitutions");
            return (Criteria) this;
        }

        public Criteria andLabelinstitutionsLike(String value) {
            addCriterion("labelinstitutions like", value, "labelinstitutions");
            return (Criteria) this;
        }

        public Criteria andLabelinstitutionsNotLike(String value) {
            addCriterion("labelinstitutions not like", value, "labelinstitutions");
            return (Criteria) this;
        }

        public Criteria andLabelinstitutionsIn(List<String> values) {
            addCriterion("labelinstitutions in", values, "labelinstitutions");
            return (Criteria) this;
        }

        public Criteria andLabelinstitutionsNotIn(List<String> values) {
            addCriterion("labelinstitutions not in", values, "labelinstitutions");
            return (Criteria) this;
        }

        public Criteria andLabelinstitutionsBetween(String value1, String value2) {
            addCriterion("labelinstitutions between", value1, value2, "labelinstitutions");
            return (Criteria) this;
        }

        public Criteria andLabelinstitutionsNotBetween(String value1, String value2) {
            addCriterion("labelinstitutions not between", value1, value2, "labelinstitutions");
            return (Criteria) this;
        }

        public Criteria andLabelotherIsNull() {
            addCriterion("labelother is null");
            return (Criteria) this;
        }

        public Criteria andLabelotherIsNotNull() {
            addCriterion("labelother is not null");
            return (Criteria) this;
        }

        public Criteria andLabelotherEqualTo(String value) {
            addCriterion("labelother =", value, "labelother");
            return (Criteria) this;
        }

        public Criteria andLabelotherNotEqualTo(String value) {
            addCriterion("labelother <>", value, "labelother");
            return (Criteria) this;
        }

        public Criteria andLabelotherGreaterThan(String value) {
            addCriterion("labelother >", value, "labelother");
            return (Criteria) this;
        }

        public Criteria andLabelotherGreaterThanOrEqualTo(String value) {
            addCriterion("labelother >=", value, "labelother");
            return (Criteria) this;
        }

        public Criteria andLabelotherLessThan(String value) {
            addCriterion("labelother <", value, "labelother");
            return (Criteria) this;
        }

        public Criteria andLabelotherLessThanOrEqualTo(String value) {
            addCriterion("labelother <=", value, "labelother");
            return (Criteria) this;
        }

        public Criteria andLabelotherLike(String value) {
            addCriterion("labelother like", value, "labelother");
            return (Criteria) this;
        }

        public Criteria andLabelotherNotLike(String value) {
            addCriterion("labelother not like", value, "labelother");
            return (Criteria) this;
        }

        public Criteria andLabelotherIn(List<String> values) {
            addCriterion("labelother in", values, "labelother");
            return (Criteria) this;
        }

        public Criteria andLabelotherNotIn(List<String> values) {
            addCriterion("labelother not in", values, "labelother");
            return (Criteria) this;
        }

        public Criteria andLabelotherBetween(String value1, String value2) {
            addCriterion("labelother between", value1, value2, "labelother");
            return (Criteria) this;
        }

        public Criteria andLabelotherNotBetween(String value1, String value2) {
            addCriterion("labelother not between", value1, value2, "labelother");
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