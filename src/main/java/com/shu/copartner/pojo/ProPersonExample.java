package com.shu.copartner.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ProPersonExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProPersonExample() {
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

        public Criteria andPersonidIsNull() {
            addCriterion("personid is null");
            return (Criteria) this;
        }

        public Criteria andPersonidIsNotNull() {
            addCriterion("personid is not null");
            return (Criteria) this;
        }

        public Criteria andPersonidEqualTo(Long value) {
            addCriterion("personid =", value, "personid");
            return (Criteria) this;
        }

        public Criteria andPersonidNotEqualTo(Long value) {
            addCriterion("personid <>", value, "personid");
            return (Criteria) this;
        }

        public Criteria andPersonidGreaterThan(Long value) {
            addCriterion("personid >", value, "personid");
            return (Criteria) this;
        }

        public Criteria andPersonidGreaterThanOrEqualTo(Long value) {
            addCriterion("personid >=", value, "personid");
            return (Criteria) this;
        }

        public Criteria andPersonidLessThan(Long value) {
            addCriterion("personid <", value, "personid");
            return (Criteria) this;
        }

        public Criteria andPersonidLessThanOrEqualTo(Long value) {
            addCriterion("personid <=", value, "personid");
            return (Criteria) this;
        }

        public Criteria andPersonidIn(List<Long> values) {
            addCriterion("personid in", values, "personid");
            return (Criteria) this;
        }

        public Criteria andPersonidNotIn(List<Long> values) {
            addCriterion("personid not in", values, "personid");
            return (Criteria) this;
        }

        public Criteria andPersonidBetween(Long value1, Long value2) {
            addCriterion("personid between", value1, value2, "personid");
            return (Criteria) this;
        }

        public Criteria andPersonidNotBetween(Long value1, Long value2) {
            addCriterion("personid not between", value1, value2, "personid");
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

        public Criteria andResumeurlIsNull() {
            addCriterion("resumeUrl is null");
            return (Criteria) this;
        }

        public Criteria andResumeurlIsNotNull() {
            addCriterion("resumeUrl is not null");
            return (Criteria) this;
        }

        public Criteria andResumeurlEqualTo(String value) {
            addCriterion("resumeUrl =", value, "resumeurl");
            return (Criteria) this;
        }

        public Criteria andResumeurlNotEqualTo(String value) {
            addCriterion("resumeUrl <>", value, "resumeurl");
            return (Criteria) this;
        }

        public Criteria andResumeurlGreaterThan(String value) {
            addCriterion("resumeUrl >", value, "resumeurl");
            return (Criteria) this;
        }

        public Criteria andResumeurlGreaterThanOrEqualTo(String value) {
            addCriterion("resumeUrl >=", value, "resumeurl");
            return (Criteria) this;
        }

        public Criteria andResumeurlLessThan(String value) {
            addCriterion("resumeUrl <", value, "resumeurl");
            return (Criteria) this;
        }

        public Criteria andResumeurlLessThanOrEqualTo(String value) {
            addCriterion("resumeUrl <=", value, "resumeurl");
            return (Criteria) this;
        }

        public Criteria andResumeurlLike(String value) {
            addCriterion("resumeUrl like", value, "resumeurl");
            return (Criteria) this;
        }

        public Criteria andResumeurlNotLike(String value) {
            addCriterion("resumeUrl not like", value, "resumeurl");
            return (Criteria) this;
        }

        public Criteria andResumeurlIn(List<String> values) {
            addCriterion("resumeUrl in", values, "resumeurl");
            return (Criteria) this;
        }

        public Criteria andResumeurlNotIn(List<String> values) {
            addCriterion("resumeUrl not in", values, "resumeurl");
            return (Criteria) this;
        }

        public Criteria andResumeurlBetween(String value1, String value2) {
            addCriterion("resumeUrl between", value1, value2, "resumeurl");
            return (Criteria) this;
        }

        public Criteria andResumeurlNotBetween(String value1, String value2) {
            addCriterion("resumeUrl not between", value1, value2, "resumeurl");
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