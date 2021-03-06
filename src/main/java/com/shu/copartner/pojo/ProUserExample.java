package com.shu.copartner.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProUserExample() {
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

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Long value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Long value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Long value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Long value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Long value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Long value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Long> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Long> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Long value1, Long value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Long value1, Long value2) {
            addCriterion("userid not between", value1, value2, "userid");
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

        public Criteria andFollowprojectIsNull() {
            addCriterion("followProject is null");
            return (Criteria) this;
        }

        public Criteria andFollowprojectIsNotNull() {
            addCriterion("followProject is not null");
            return (Criteria) this;
        }

        public Criteria andFollowprojectEqualTo(String value) {
            addCriterion("followProject =", value, "followproject");
            return (Criteria) this;
        }

        public Criteria andFollowprojectNotEqualTo(String value) {
            addCriterion("followProject <>", value, "followproject");
            return (Criteria) this;
        }

        public Criteria andFollowprojectGreaterThan(String value) {
            addCriterion("followProject >", value, "followproject");
            return (Criteria) this;
        }

        public Criteria andFollowprojectGreaterThanOrEqualTo(String value) {
            addCriterion("followProject >=", value, "followproject");
            return (Criteria) this;
        }

        public Criteria andFollowprojectLessThan(String value) {
            addCriterion("followProject <", value, "followproject");
            return (Criteria) this;
        }

        public Criteria andFollowprojectLessThanOrEqualTo(String value) {
            addCriterion("followProject <=", value, "followproject");
            return (Criteria) this;
        }

        public Criteria andFollowprojectLike(String value) {
            addCriterion("followProject like", value, "followproject");
            return (Criteria) this;
        }

        public Criteria andFollowprojectNotLike(String value) {
            addCriterion("followProject not like", value, "followproject");
            return (Criteria) this;
        }

        public Criteria andFollowprojectIn(List<String> values) {
            addCriterion("followProject in", values, "followproject");
            return (Criteria) this;
        }

        public Criteria andFollowprojectNotIn(List<String> values) {
            addCriterion("followProject not in", values, "followproject");
            return (Criteria) this;
        }

        public Criteria andFollowprojectBetween(String value1, String value2) {
            addCriterion("followProject between", value1, value2, "followproject");
            return (Criteria) this;
        }

        public Criteria andFollowprojectNotBetween(String value1, String value2) {
            addCriterion("followProject not between", value1, value2, "followproject");
            return (Criteria) this;
        }

        public Criteria andIsdeletedIsNull() {
            addCriterion("isDeleted is null");
            return (Criteria) this;
        }

        public Criteria andIsdeletedIsNotNull() {
            addCriterion("isDeleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsdeletedEqualTo(Integer value) {
            addCriterion("isDeleted =", value, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedNotEqualTo(Integer value) {
            addCriterion("isDeleted <>", value, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedGreaterThan(Integer value) {
            addCriterion("isDeleted >", value, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedGreaterThanOrEqualTo(Integer value) {
            addCriterion("isDeleted >=", value, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedLessThan(Integer value) {
            addCriterion("isDeleted <", value, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedLessThanOrEqualTo(Integer value) {
            addCriterion("isDeleted <=", value, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedIn(List<Integer> values) {
            addCriterion("isDeleted in", values, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedNotIn(List<Integer> values) {
            addCriterion("isDeleted not in", values, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedBetween(Integer value1, Integer value2) {
            addCriterion("isDeleted between", value1, value2, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedNotBetween(Integer value1, Integer value2) {
            addCriterion("isDeleted not between", value1, value2, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIslockIsNull() {
            addCriterion("isLock is null");
            return (Criteria) this;
        }

        public Criteria andIslockIsNotNull() {
            addCriterion("isLock is not null");
            return (Criteria) this;
        }

        public Criteria andIslockEqualTo(Integer value) {
            addCriterion("isLock =", value, "islock");
            return (Criteria) this;
        }

        public Criteria andIslockNotEqualTo(Integer value) {
            addCriterion("isLock <>", value, "islock");
            return (Criteria) this;
        }

        public Criteria andIslockGreaterThan(Integer value) {
            addCriterion("isLock >", value, "islock");
            return (Criteria) this;
        }

        public Criteria andIslockGreaterThanOrEqualTo(Integer value) {
            addCriterion("isLock >=", value, "islock");
            return (Criteria) this;
        }

        public Criteria andIslockLessThan(Integer value) {
            addCriterion("isLock <", value, "islock");
            return (Criteria) this;
        }

        public Criteria andIslockLessThanOrEqualTo(Integer value) {
            addCriterion("isLock <=", value, "islock");
            return (Criteria) this;
        }

        public Criteria andIslockIn(List<Integer> values) {
            addCriterion("isLock in", values, "islock");
            return (Criteria) this;
        }

        public Criteria andIslockNotIn(List<Integer> values) {
            addCriterion("isLock not in", values, "islock");
            return (Criteria) this;
        }

        public Criteria andIslockBetween(Integer value1, Integer value2) {
            addCriterion("isLock between", value1, value2, "islock");
            return (Criteria) this;
        }

        public Criteria andIslockNotBetween(Integer value1, Integer value2) {
            addCriterion("isLock not between", value1, value2, "islock");
            return (Criteria) this;
        }

        public Criteria andLastdateIsNull() {
            addCriterion("lastDate is null");
            return (Criteria) this;
        }

        public Criteria andLastdateIsNotNull() {
            addCriterion("lastDate is not null");
            return (Criteria) this;
        }

        public Criteria andLastdateEqualTo(Date value) {
            addCriterion("lastDate =", value, "lastdate");
            return (Criteria) this;
        }

        public Criteria andLastdateNotEqualTo(Date value) {
            addCriterion("lastDate <>", value, "lastdate");
            return (Criteria) this;
        }

        public Criteria andLastdateGreaterThan(Date value) {
            addCriterion("lastDate >", value, "lastdate");
            return (Criteria) this;
        }

        public Criteria andLastdateGreaterThanOrEqualTo(Date value) {
            addCriterion("lastDate >=", value, "lastdate");
            return (Criteria) this;
        }

        public Criteria andLastdateLessThan(Date value) {
            addCriterion("lastDate <", value, "lastdate");
            return (Criteria) this;
        }

        public Criteria andLastdateLessThanOrEqualTo(Date value) {
            addCriterion("lastDate <=", value, "lastdate");
            return (Criteria) this;
        }

        public Criteria andLastdateIn(List<Date> values) {
            addCriterion("lastDate in", values, "lastdate");
            return (Criteria) this;
        }

        public Criteria andLastdateNotIn(List<Date> values) {
            addCriterion("lastDate not in", values, "lastdate");
            return (Criteria) this;
        }

        public Criteria andLastdateBetween(Date value1, Date value2) {
            addCriterion("lastDate between", value1, value2, "lastdate");
            return (Criteria) this;
        }

        public Criteria andLastdateNotBetween(Date value1, Date value2) {
            addCriterion("lastDate not between", value1, value2, "lastdate");
            return (Criteria) this;
        }

        public Criteria andLogintimeIsNull() {
            addCriterion("loginTime is null");
            return (Criteria) this;
        }

        public Criteria andLogintimeIsNotNull() {
            addCriterion("loginTime is not null");
            return (Criteria) this;
        }

        public Criteria andLogintimeEqualTo(Integer value) {
            addCriterion("loginTime =", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeNotEqualTo(Integer value) {
            addCriterion("loginTime <>", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeGreaterThan(Integer value) {
            addCriterion("loginTime >", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("loginTime >=", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeLessThan(Integer value) {
            addCriterion("loginTime <", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeLessThanOrEqualTo(Integer value) {
            addCriterion("loginTime <=", value, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeIn(List<Integer> values) {
            addCriterion("loginTime in", values, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeNotIn(List<Integer> values) {
            addCriterion("loginTime not in", values, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeBetween(Integer value1, Integer value2) {
            addCriterion("loginTime between", value1, value2, "logintime");
            return (Criteria) this;
        }

        public Criteria andLogintimeNotBetween(Integer value1, Integer value2) {
            addCriterion("loginTime not between", value1, value2, "logintime");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andRegistrydateIsNull() {
            addCriterion("registryDate is null");
            return (Criteria) this;
        }

        public Criteria andRegistrydateIsNotNull() {
            addCriterion("registryDate is not null");
            return (Criteria) this;
        }

        public Criteria andRegistrydateEqualTo(Date value) {
            addCriterion("registryDate =", value, "registrydate");
            return (Criteria) this;
        }

        public Criteria andRegistrydateNotEqualTo(Date value) {
            addCriterion("registryDate <>", value, "registrydate");
            return (Criteria) this;
        }

        public Criteria andRegistrydateGreaterThan(Date value) {
            addCriterion("registryDate >", value, "registrydate");
            return (Criteria) this;
        }

        public Criteria andRegistrydateGreaterThanOrEqualTo(Date value) {
            addCriterion("registryDate >=", value, "registrydate");
            return (Criteria) this;
        }

        public Criteria andRegistrydateLessThan(Date value) {
            addCriterion("registryDate <", value, "registrydate");
            return (Criteria) this;
        }

        public Criteria andRegistrydateLessThanOrEqualTo(Date value) {
            addCriterion("registryDate <=", value, "registrydate");
            return (Criteria) this;
        }

        public Criteria andRegistrydateIn(List<Date> values) {
            addCriterion("registryDate in", values, "registrydate");
            return (Criteria) this;
        }

        public Criteria andRegistrydateNotIn(List<Date> values) {
            addCriterion("registryDate not in", values, "registrydate");
            return (Criteria) this;
        }

        public Criteria andRegistrydateBetween(Date value1, Date value2) {
            addCriterion("registryDate between", value1, value2, "registrydate");
            return (Criteria) this;
        }

        public Criteria andRegistrydateNotBetween(Date value1, Date value2) {
            addCriterion("registryDate not between", value1, value2, "registrydate");
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

        public Criteria andNewAuthIsNull() {
            addCriterion("new_auth is null");
            return (Criteria) this;
        }

        public Criteria andNewAuthIsNotNull() {
            addCriterion("new_auth is not null");
            return (Criteria) this;
        }

        public Criteria andNewAuthEqualTo(String value) {
            addCriterion("new_auth =", value, "newAuth");
            return (Criteria) this;
        }

        public Criteria andNewAuthNotEqualTo(String value) {
            addCriterion("new_auth <>", value, "newAuth");
            return (Criteria) this;
        }

        public Criteria andNewAuthGreaterThan(String value) {
            addCriterion("new_auth >", value, "newAuth");
            return (Criteria) this;
        }

        public Criteria andNewAuthGreaterThanOrEqualTo(String value) {
            addCriterion("new_auth >=", value, "newAuth");
            return (Criteria) this;
        }

        public Criteria andNewAuthLessThan(String value) {
            addCriterion("new_auth <", value, "newAuth");
            return (Criteria) this;
        }

        public Criteria andNewAuthLessThanOrEqualTo(String value) {
            addCriterion("new_auth <=", value, "newAuth");
            return (Criteria) this;
        }

        public Criteria andNewAuthLike(String value) {
            addCriterion("new_auth like", value, "newAuth");
            return (Criteria) this;
        }

        public Criteria andNewAuthNotLike(String value) {
            addCriterion("new_auth not like", value, "newAuth");
            return (Criteria) this;
        }

        public Criteria andNewAuthIn(List<String> values) {
            addCriterion("new_auth in", values, "newAuth");
            return (Criteria) this;
        }

        public Criteria andNewAuthNotIn(List<String> values) {
            addCriterion("new_auth not in", values, "newAuth");
            return (Criteria) this;
        }

        public Criteria andNewAuthBetween(String value1, String value2) {
            addCriterion("new_auth between", value1, value2, "newAuth");
            return (Criteria) this;
        }

        public Criteria andNewAuthNotBetween(String value1, String value2) {
            addCriterion("new_auth not between", value1, value2, "newAuth");
            return (Criteria) this;
        }

        public Criteria andNewAuthDateIsNull() {
            addCriterion("new_auth_date is null");
            return (Criteria) this;
        }

        public Criteria andNewAuthDateIsNotNull() {
            addCriterion("new_auth_date is not null");
            return (Criteria) this;
        }

        public Criteria andNewAuthDateEqualTo(Date value) {
            addCriterion("new_auth_date =", value, "newAuthDate");
            return (Criteria) this;
        }

        public Criteria andNewAuthDateNotEqualTo(Date value) {
            addCriterion("new_auth_date <>", value, "newAuthDate");
            return (Criteria) this;
        }

        public Criteria andNewAuthDateGreaterThan(Date value) {
            addCriterion("new_auth_date >", value, "newAuthDate");
            return (Criteria) this;
        }

        public Criteria andNewAuthDateGreaterThanOrEqualTo(Date value) {
            addCriterion("new_auth_date >=", value, "newAuthDate");
            return (Criteria) this;
        }

        public Criteria andNewAuthDateLessThan(Date value) {
            addCriterion("new_auth_date <", value, "newAuthDate");
            return (Criteria) this;
        }

        public Criteria andNewAuthDateLessThanOrEqualTo(Date value) {
            addCriterion("new_auth_date <=", value, "newAuthDate");
            return (Criteria) this;
        }

        public Criteria andNewAuthDateIn(List<Date> values) {
            addCriterion("new_auth_date in", values, "newAuthDate");
            return (Criteria) this;
        }

        public Criteria andNewAuthDateNotIn(List<Date> values) {
            addCriterion("new_auth_date not in", values, "newAuthDate");
            return (Criteria) this;
        }

        public Criteria andNewAuthDateBetween(Date value1, Date value2) {
            addCriterion("new_auth_date between", value1, value2, "newAuthDate");
            return (Criteria) this;
        }

        public Criteria andNewAuthDateNotBetween(Date value1, Date value2) {
            addCriterion("new_auth_date not between", value1, value2, "newAuthDate");
            return (Criteria) this;
        }

        public Criteria andImageUrlIsNull() {
            addCriterion("image_url is null");
            return (Criteria) this;
        }

        public Criteria andImageUrlIsNotNull() {
            addCriterion("image_url is not null");
            return (Criteria) this;
        }

        public Criteria andImageUrlEqualTo(String value) {
            addCriterion("image_url =", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotEqualTo(String value) {
            addCriterion("image_url <>", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlGreaterThan(String value) {
            addCriterion("image_url >", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlGreaterThanOrEqualTo(String value) {
            addCriterion("image_url >=", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlLessThan(String value) {
            addCriterion("image_url <", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlLessThanOrEqualTo(String value) {
            addCriterion("image_url <=", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlLike(String value) {
            addCriterion("image_url like", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotLike(String value) {
            addCriterion("image_url not like", value, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlIn(List<String> values) {
            addCriterion("image_url in", values, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotIn(List<String> values) {
            addCriterion("image_url not in", values, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlBetween(String value1, String value2) {
            addCriterion("image_url between", value1, value2, "imageUrl");
            return (Criteria) this;
        }

        public Criteria andImageUrlNotBetween(String value1, String value2) {
            addCriterion("image_url not between", value1, value2, "imageUrl");
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