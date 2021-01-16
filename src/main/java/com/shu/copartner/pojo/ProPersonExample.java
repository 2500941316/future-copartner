package com.shu.copartner.pojo;

import java.util.ArrayList;
import java.util.Date;
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

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(Integer value) {
            addCriterion("age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(Integer value) {
            addCriterion("age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(Integer value) {
            addCriterion("age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(Integer value) {
            addCriterion("age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(Integer value) {
            addCriterion("age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(Integer value) {
            addCriterion("age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<Integer> values) {
            addCriterion("age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<Integer> values) {
            addCriterion("age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(Integer value1, Integer value2) {
            addCriterion("age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(Integer value1, Integer value2) {
            addCriterion("age not between", value1, value2, "age");
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

        public Criteria andEducationbackgroundIsNull() {
            addCriterion("educationBackground is null");
            return (Criteria) this;
        }

        public Criteria andEducationbackgroundIsNotNull() {
            addCriterion("educationBackground is not null");
            return (Criteria) this;
        }

        public Criteria andEducationbackgroundEqualTo(String value) {
            addCriterion("educationBackground =", value, "educationbackground");
            return (Criteria) this;
        }

        public Criteria andEducationbackgroundNotEqualTo(String value) {
            addCriterion("educationBackground <>", value, "educationbackground");
            return (Criteria) this;
        }

        public Criteria andEducationbackgroundGreaterThan(String value) {
            addCriterion("educationBackground >", value, "educationbackground");
            return (Criteria) this;
        }

        public Criteria andEducationbackgroundGreaterThanOrEqualTo(String value) {
            addCriterion("educationBackground >=", value, "educationbackground");
            return (Criteria) this;
        }

        public Criteria andEducationbackgroundLessThan(String value) {
            addCriterion("educationBackground <", value, "educationbackground");
            return (Criteria) this;
        }

        public Criteria andEducationbackgroundLessThanOrEqualTo(String value) {
            addCriterion("educationBackground <=", value, "educationbackground");
            return (Criteria) this;
        }

        public Criteria andEducationbackgroundLike(String value) {
            addCriterion("educationBackground like", value, "educationbackground");
            return (Criteria) this;
        }

        public Criteria andEducationbackgroundNotLike(String value) {
            addCriterion("educationBackground not like", value, "educationbackground");
            return (Criteria) this;
        }

        public Criteria andEducationbackgroundIn(List<String> values) {
            addCriterion("educationBackground in", values, "educationbackground");
            return (Criteria) this;
        }

        public Criteria andEducationbackgroundNotIn(List<String> values) {
            addCriterion("educationBackground not in", values, "educationbackground");
            return (Criteria) this;
        }

        public Criteria andEducationbackgroundBetween(String value1, String value2) {
            addCriterion("educationBackground between", value1, value2, "educationbackground");
            return (Criteria) this;
        }

        public Criteria andEducationbackgroundNotBetween(String value1, String value2) {
            addCriterion("educationBackground not between", value1, value2, "educationbackground");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andExperiencestringIsNull() {
            addCriterion("experienceString is null");
            return (Criteria) this;
        }

        public Criteria andExperiencestringIsNotNull() {
            addCriterion("experienceString is not null");
            return (Criteria) this;
        }

        public Criteria andExperiencestringEqualTo(String value) {
            addCriterion("experienceString =", value, "experiencestring");
            return (Criteria) this;
        }

        public Criteria andExperiencestringNotEqualTo(String value) {
            addCriterion("experienceString <>", value, "experiencestring");
            return (Criteria) this;
        }

        public Criteria andExperiencestringGreaterThan(String value) {
            addCriterion("experienceString >", value, "experiencestring");
            return (Criteria) this;
        }

        public Criteria andExperiencestringGreaterThanOrEqualTo(String value) {
            addCriterion("experienceString >=", value, "experiencestring");
            return (Criteria) this;
        }

        public Criteria andExperiencestringLessThan(String value) {
            addCriterion("experienceString <", value, "experiencestring");
            return (Criteria) this;
        }

        public Criteria andExperiencestringLessThanOrEqualTo(String value) {
            addCriterion("experienceString <=", value, "experiencestring");
            return (Criteria) this;
        }

        public Criteria andExperiencestringLike(String value) {
            addCriterion("experienceString like", value, "experiencestring");
            return (Criteria) this;
        }

        public Criteria andExperiencestringNotLike(String value) {
            addCriterion("experienceString not like", value, "experiencestring");
            return (Criteria) this;
        }

        public Criteria andExperiencestringIn(List<String> values) {
            addCriterion("experienceString in", values, "experiencestring");
            return (Criteria) this;
        }

        public Criteria andExperiencestringNotIn(List<String> values) {
            addCriterion("experienceString not in", values, "experiencestring");
            return (Criteria) this;
        }

        public Criteria andExperiencestringBetween(String value1, String value2) {
            addCriterion("experienceString between", value1, value2, "experiencestring");
            return (Criteria) this;
        }

        public Criteria andExperiencestringNotBetween(String value1, String value2) {
            addCriterion("experienceString not between", value1, value2, "experiencestring");
            return (Criteria) this;
        }

        public Criteria andIsgraduateIsNull() {
            addCriterion("isGraduate is null");
            return (Criteria) this;
        }

        public Criteria andIsgraduateIsNotNull() {
            addCriterion("isGraduate is not null");
            return (Criteria) this;
        }

        public Criteria andIsgraduateEqualTo(String value) {
            addCriterion("isGraduate =", value, "isgraduate");
            return (Criteria) this;
        }

        public Criteria andIsgraduateNotEqualTo(String value) {
            addCriterion("isGraduate <>", value, "isgraduate");
            return (Criteria) this;
        }

        public Criteria andIsgraduateGreaterThan(String value) {
            addCriterion("isGraduate >", value, "isgraduate");
            return (Criteria) this;
        }

        public Criteria andIsgraduateGreaterThanOrEqualTo(String value) {
            addCriterion("isGraduate >=", value, "isgraduate");
            return (Criteria) this;
        }

        public Criteria andIsgraduateLessThan(String value) {
            addCriterion("isGraduate <", value, "isgraduate");
            return (Criteria) this;
        }

        public Criteria andIsgraduateLessThanOrEqualTo(String value) {
            addCriterion("isGraduate <=", value, "isgraduate");
            return (Criteria) this;
        }

        public Criteria andIsgraduateLike(String value) {
            addCriterion("isGraduate like", value, "isgraduate");
            return (Criteria) this;
        }

        public Criteria andIsgraduateNotLike(String value) {
            addCriterion("isGraduate not like", value, "isgraduate");
            return (Criteria) this;
        }

        public Criteria andIsgraduateIn(List<String> values) {
            addCriterion("isGraduate in", values, "isgraduate");
            return (Criteria) this;
        }

        public Criteria andIsgraduateNotIn(List<String> values) {
            addCriterion("isGraduate not in", values, "isgraduate");
            return (Criteria) this;
        }

        public Criteria andIsgraduateBetween(String value1, String value2) {
            addCriterion("isGraduate between", value1, value2, "isgraduate");
            return (Criteria) this;
        }

        public Criteria andIsgraduateNotBetween(String value1, String value2) {
            addCriterion("isGraduate not between", value1, value2, "isgraduate");
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

        public Criteria andPhotourlIsNull() {
            addCriterion("photoUrl is null");
            return (Criteria) this;
        }

        public Criteria andPhotourlIsNotNull() {
            addCriterion("photoUrl is not null");
            return (Criteria) this;
        }

        public Criteria andPhotourlEqualTo(String value) {
            addCriterion("photoUrl =", value, "photourl");
            return (Criteria) this;
        }

        public Criteria andPhotourlNotEqualTo(String value) {
            addCriterion("photoUrl <>", value, "photourl");
            return (Criteria) this;
        }

        public Criteria andPhotourlGreaterThan(String value) {
            addCriterion("photoUrl >", value, "photourl");
            return (Criteria) this;
        }

        public Criteria andPhotourlGreaterThanOrEqualTo(String value) {
            addCriterion("photoUrl >=", value, "photourl");
            return (Criteria) this;
        }

        public Criteria andPhotourlLessThan(String value) {
            addCriterion("photoUrl <", value, "photourl");
            return (Criteria) this;
        }

        public Criteria andPhotourlLessThanOrEqualTo(String value) {
            addCriterion("photoUrl <=", value, "photourl");
            return (Criteria) this;
        }

        public Criteria andPhotourlLike(String value) {
            addCriterion("photoUrl like", value, "photourl");
            return (Criteria) this;
        }

        public Criteria andPhotourlNotLike(String value) {
            addCriterion("photoUrl not like", value, "photourl");
            return (Criteria) this;
        }

        public Criteria andPhotourlIn(List<String> values) {
            addCriterion("photoUrl in", values, "photourl");
            return (Criteria) this;
        }

        public Criteria andPhotourlNotIn(List<String> values) {
            addCriterion("photoUrl not in", values, "photourl");
            return (Criteria) this;
        }

        public Criteria andPhotourlBetween(String value1, String value2) {
            addCriterion("photoUrl between", value1, value2, "photourl");
            return (Criteria) this;
        }

        public Criteria andPhotourlNotBetween(String value1, String value2) {
            addCriterion("photoUrl not between", value1, value2, "photourl");
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

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andVediourlIsNull() {
            addCriterion("vedioUrl is null");
            return (Criteria) this;
        }

        public Criteria andVediourlIsNotNull() {
            addCriterion("vedioUrl is not null");
            return (Criteria) this;
        }

        public Criteria andVediourlEqualTo(String value) {
            addCriterion("vedioUrl =", value, "vediourl");
            return (Criteria) this;
        }

        public Criteria andVediourlNotEqualTo(String value) {
            addCriterion("vedioUrl <>", value, "vediourl");
            return (Criteria) this;
        }

        public Criteria andVediourlGreaterThan(String value) {
            addCriterion("vedioUrl >", value, "vediourl");
            return (Criteria) this;
        }

        public Criteria andVediourlGreaterThanOrEqualTo(String value) {
            addCriterion("vedioUrl >=", value, "vediourl");
            return (Criteria) this;
        }

        public Criteria andVediourlLessThan(String value) {
            addCriterion("vedioUrl <", value, "vediourl");
            return (Criteria) this;
        }

        public Criteria andVediourlLessThanOrEqualTo(String value) {
            addCriterion("vedioUrl <=", value, "vediourl");
            return (Criteria) this;
        }

        public Criteria andVediourlLike(String value) {
            addCriterion("vedioUrl like", value, "vediourl");
            return (Criteria) this;
        }

        public Criteria andVediourlNotLike(String value) {
            addCriterion("vedioUrl not like", value, "vediourl");
            return (Criteria) this;
        }

        public Criteria andVediourlIn(List<String> values) {
            addCriterion("vedioUrl in", values, "vediourl");
            return (Criteria) this;
        }

        public Criteria andVediourlNotIn(List<String> values) {
            addCriterion("vedioUrl not in", values, "vediourl");
            return (Criteria) this;
        }

        public Criteria andVediourlBetween(String value1, String value2) {
            addCriterion("vedioUrl between", value1, value2, "vediourl");
            return (Criteria) this;
        }

        public Criteria andVediourlNotBetween(String value1, String value2) {
            addCriterion("vedioUrl not between", value1, value2, "vediourl");
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