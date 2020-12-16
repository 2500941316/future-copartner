package com.shu.copartner.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActRuExecutionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ActRuExecutionExample() {
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
            addCriterion("ID_ is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID_ is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID_ =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID_ <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID_ >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID_ >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID_ <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID_ <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID_ like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID_ not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID_ in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID_ not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID_ between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID_ not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRevIsNull() {
            addCriterion("REV_ is null");
            return (Criteria) this;
        }

        public Criteria andRevIsNotNull() {
            addCriterion("REV_ is not null");
            return (Criteria) this;
        }

        public Criteria andRevEqualTo(Integer value) {
            addCriterion("REV_ =", value, "rev");
            return (Criteria) this;
        }

        public Criteria andRevNotEqualTo(Integer value) {
            addCriterion("REV_ <>", value, "rev");
            return (Criteria) this;
        }

        public Criteria andRevGreaterThan(Integer value) {
            addCriterion("REV_ >", value, "rev");
            return (Criteria) this;
        }

        public Criteria andRevGreaterThanOrEqualTo(Integer value) {
            addCriterion("REV_ >=", value, "rev");
            return (Criteria) this;
        }

        public Criteria andRevLessThan(Integer value) {
            addCriterion("REV_ <", value, "rev");
            return (Criteria) this;
        }

        public Criteria andRevLessThanOrEqualTo(Integer value) {
            addCriterion("REV_ <=", value, "rev");
            return (Criteria) this;
        }

        public Criteria andRevIn(List<Integer> values) {
            addCriterion("REV_ in", values, "rev");
            return (Criteria) this;
        }

        public Criteria andRevNotIn(List<Integer> values) {
            addCriterion("REV_ not in", values, "rev");
            return (Criteria) this;
        }

        public Criteria andRevBetween(Integer value1, Integer value2) {
            addCriterion("REV_ between", value1, value2, "rev");
            return (Criteria) this;
        }

        public Criteria andRevNotBetween(Integer value1, Integer value2) {
            addCriterion("REV_ not between", value1, value2, "rev");
            return (Criteria) this;
        }

        public Criteria andProcInstIdIsNull() {
            addCriterion("PROC_INST_ID_ is null");
            return (Criteria) this;
        }

        public Criteria andProcInstIdIsNotNull() {
            addCriterion("PROC_INST_ID_ is not null");
            return (Criteria) this;
        }

        public Criteria andProcInstIdEqualTo(String value) {
            addCriterion("PROC_INST_ID_ =", value, "procInstId");
            return (Criteria) this;
        }

        public Criteria andProcInstIdNotEqualTo(String value) {
            addCriterion("PROC_INST_ID_ <>", value, "procInstId");
            return (Criteria) this;
        }

        public Criteria andProcInstIdGreaterThan(String value) {
            addCriterion("PROC_INST_ID_ >", value, "procInstId");
            return (Criteria) this;
        }

        public Criteria andProcInstIdGreaterThanOrEqualTo(String value) {
            addCriterion("PROC_INST_ID_ >=", value, "procInstId");
            return (Criteria) this;
        }

        public Criteria andProcInstIdLessThan(String value) {
            addCriterion("PROC_INST_ID_ <", value, "procInstId");
            return (Criteria) this;
        }

        public Criteria andProcInstIdLessThanOrEqualTo(String value) {
            addCriterion("PROC_INST_ID_ <=", value, "procInstId");
            return (Criteria) this;
        }

        public Criteria andProcInstIdLike(String value) {
            addCriterion("PROC_INST_ID_ like", value, "procInstId");
            return (Criteria) this;
        }

        public Criteria andProcInstIdNotLike(String value) {
            addCriterion("PROC_INST_ID_ not like", value, "procInstId");
            return (Criteria) this;
        }

        public Criteria andProcInstIdIn(List<String> values) {
            addCriterion("PROC_INST_ID_ in", values, "procInstId");
            return (Criteria) this;
        }

        public Criteria andProcInstIdNotIn(List<String> values) {
            addCriterion("PROC_INST_ID_ not in", values, "procInstId");
            return (Criteria) this;
        }

        public Criteria andProcInstIdBetween(String value1, String value2) {
            addCriterion("PROC_INST_ID_ between", value1, value2, "procInstId");
            return (Criteria) this;
        }

        public Criteria andProcInstIdNotBetween(String value1, String value2) {
            addCriterion("PROC_INST_ID_ not between", value1, value2, "procInstId");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyIsNull() {
            addCriterion("BUSINESS_KEY_ is null");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyIsNotNull() {
            addCriterion("BUSINESS_KEY_ is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyEqualTo(String value) {
            addCriterion("BUSINESS_KEY_ =", value, "businessKey");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyNotEqualTo(String value) {
            addCriterion("BUSINESS_KEY_ <>", value, "businessKey");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyGreaterThan(String value) {
            addCriterion("BUSINESS_KEY_ >", value, "businessKey");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESS_KEY_ >=", value, "businessKey");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyLessThan(String value) {
            addCriterion("BUSINESS_KEY_ <", value, "businessKey");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyLessThanOrEqualTo(String value) {
            addCriterion("BUSINESS_KEY_ <=", value, "businessKey");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyLike(String value) {
            addCriterion("BUSINESS_KEY_ like", value, "businessKey");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyNotLike(String value) {
            addCriterion("BUSINESS_KEY_ not like", value, "businessKey");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyIn(List<String> values) {
            addCriterion("BUSINESS_KEY_ in", values, "businessKey");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyNotIn(List<String> values) {
            addCriterion("BUSINESS_KEY_ not in", values, "businessKey");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyBetween(String value1, String value2) {
            addCriterion("BUSINESS_KEY_ between", value1, value2, "businessKey");
            return (Criteria) this;
        }

        public Criteria andBusinessKeyNotBetween(String value1, String value2) {
            addCriterion("BUSINESS_KEY_ not between", value1, value2, "businessKey");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("PARENT_ID_ is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("PARENT_ID_ is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(String value) {
            addCriterion("PARENT_ID_ =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(String value) {
            addCriterion("PARENT_ID_ <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(String value) {
            addCriterion("PARENT_ID_ >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("PARENT_ID_ >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(String value) {
            addCriterion("PARENT_ID_ <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(String value) {
            addCriterion("PARENT_ID_ <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLike(String value) {
            addCriterion("PARENT_ID_ like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotLike(String value) {
            addCriterion("PARENT_ID_ not like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<String> values) {
            addCriterion("PARENT_ID_ in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<String> values) {
            addCriterion("PARENT_ID_ not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(String value1, String value2) {
            addCriterion("PARENT_ID_ between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(String value1, String value2) {
            addCriterion("PARENT_ID_ not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andProcDefIdIsNull() {
            addCriterion("PROC_DEF_ID_ is null");
            return (Criteria) this;
        }

        public Criteria andProcDefIdIsNotNull() {
            addCriterion("PROC_DEF_ID_ is not null");
            return (Criteria) this;
        }

        public Criteria andProcDefIdEqualTo(String value) {
            addCriterion("PROC_DEF_ID_ =", value, "procDefId");
            return (Criteria) this;
        }

        public Criteria andProcDefIdNotEqualTo(String value) {
            addCriterion("PROC_DEF_ID_ <>", value, "procDefId");
            return (Criteria) this;
        }

        public Criteria andProcDefIdGreaterThan(String value) {
            addCriterion("PROC_DEF_ID_ >", value, "procDefId");
            return (Criteria) this;
        }

        public Criteria andProcDefIdGreaterThanOrEqualTo(String value) {
            addCriterion("PROC_DEF_ID_ >=", value, "procDefId");
            return (Criteria) this;
        }

        public Criteria andProcDefIdLessThan(String value) {
            addCriterion("PROC_DEF_ID_ <", value, "procDefId");
            return (Criteria) this;
        }

        public Criteria andProcDefIdLessThanOrEqualTo(String value) {
            addCriterion("PROC_DEF_ID_ <=", value, "procDefId");
            return (Criteria) this;
        }

        public Criteria andProcDefIdLike(String value) {
            addCriterion("PROC_DEF_ID_ like", value, "procDefId");
            return (Criteria) this;
        }

        public Criteria andProcDefIdNotLike(String value) {
            addCriterion("PROC_DEF_ID_ not like", value, "procDefId");
            return (Criteria) this;
        }

        public Criteria andProcDefIdIn(List<String> values) {
            addCriterion("PROC_DEF_ID_ in", values, "procDefId");
            return (Criteria) this;
        }

        public Criteria andProcDefIdNotIn(List<String> values) {
            addCriterion("PROC_DEF_ID_ not in", values, "procDefId");
            return (Criteria) this;
        }

        public Criteria andProcDefIdBetween(String value1, String value2) {
            addCriterion("PROC_DEF_ID_ between", value1, value2, "procDefId");
            return (Criteria) this;
        }

        public Criteria andProcDefIdNotBetween(String value1, String value2) {
            addCriterion("PROC_DEF_ID_ not between", value1, value2, "procDefId");
            return (Criteria) this;
        }

        public Criteria andSuperExecIsNull() {
            addCriterion("SUPER_EXEC_ is null");
            return (Criteria) this;
        }

        public Criteria andSuperExecIsNotNull() {
            addCriterion("SUPER_EXEC_ is not null");
            return (Criteria) this;
        }

        public Criteria andSuperExecEqualTo(String value) {
            addCriterion("SUPER_EXEC_ =", value, "superExec");
            return (Criteria) this;
        }

        public Criteria andSuperExecNotEqualTo(String value) {
            addCriterion("SUPER_EXEC_ <>", value, "superExec");
            return (Criteria) this;
        }

        public Criteria andSuperExecGreaterThan(String value) {
            addCriterion("SUPER_EXEC_ >", value, "superExec");
            return (Criteria) this;
        }

        public Criteria andSuperExecGreaterThanOrEqualTo(String value) {
            addCriterion("SUPER_EXEC_ >=", value, "superExec");
            return (Criteria) this;
        }

        public Criteria andSuperExecLessThan(String value) {
            addCriterion("SUPER_EXEC_ <", value, "superExec");
            return (Criteria) this;
        }

        public Criteria andSuperExecLessThanOrEqualTo(String value) {
            addCriterion("SUPER_EXEC_ <=", value, "superExec");
            return (Criteria) this;
        }

        public Criteria andSuperExecLike(String value) {
            addCriterion("SUPER_EXEC_ like", value, "superExec");
            return (Criteria) this;
        }

        public Criteria andSuperExecNotLike(String value) {
            addCriterion("SUPER_EXEC_ not like", value, "superExec");
            return (Criteria) this;
        }

        public Criteria andSuperExecIn(List<String> values) {
            addCriterion("SUPER_EXEC_ in", values, "superExec");
            return (Criteria) this;
        }

        public Criteria andSuperExecNotIn(List<String> values) {
            addCriterion("SUPER_EXEC_ not in", values, "superExec");
            return (Criteria) this;
        }

        public Criteria andSuperExecBetween(String value1, String value2) {
            addCriterion("SUPER_EXEC_ between", value1, value2, "superExec");
            return (Criteria) this;
        }

        public Criteria andSuperExecNotBetween(String value1, String value2) {
            addCriterion("SUPER_EXEC_ not between", value1, value2, "superExec");
            return (Criteria) this;
        }

        public Criteria andRootProcInstIdIsNull() {
            addCriterion("ROOT_PROC_INST_ID_ is null");
            return (Criteria) this;
        }

        public Criteria andRootProcInstIdIsNotNull() {
            addCriterion("ROOT_PROC_INST_ID_ is not null");
            return (Criteria) this;
        }

        public Criteria andRootProcInstIdEqualTo(String value) {
            addCriterion("ROOT_PROC_INST_ID_ =", value, "rootProcInstId");
            return (Criteria) this;
        }

        public Criteria andRootProcInstIdNotEqualTo(String value) {
            addCriterion("ROOT_PROC_INST_ID_ <>", value, "rootProcInstId");
            return (Criteria) this;
        }

        public Criteria andRootProcInstIdGreaterThan(String value) {
            addCriterion("ROOT_PROC_INST_ID_ >", value, "rootProcInstId");
            return (Criteria) this;
        }

        public Criteria andRootProcInstIdGreaterThanOrEqualTo(String value) {
            addCriterion("ROOT_PROC_INST_ID_ >=", value, "rootProcInstId");
            return (Criteria) this;
        }

        public Criteria andRootProcInstIdLessThan(String value) {
            addCriterion("ROOT_PROC_INST_ID_ <", value, "rootProcInstId");
            return (Criteria) this;
        }

        public Criteria andRootProcInstIdLessThanOrEqualTo(String value) {
            addCriterion("ROOT_PROC_INST_ID_ <=", value, "rootProcInstId");
            return (Criteria) this;
        }

        public Criteria andRootProcInstIdLike(String value) {
            addCriterion("ROOT_PROC_INST_ID_ like", value, "rootProcInstId");
            return (Criteria) this;
        }

        public Criteria andRootProcInstIdNotLike(String value) {
            addCriterion("ROOT_PROC_INST_ID_ not like", value, "rootProcInstId");
            return (Criteria) this;
        }

        public Criteria andRootProcInstIdIn(List<String> values) {
            addCriterion("ROOT_PROC_INST_ID_ in", values, "rootProcInstId");
            return (Criteria) this;
        }

        public Criteria andRootProcInstIdNotIn(List<String> values) {
            addCriterion("ROOT_PROC_INST_ID_ not in", values, "rootProcInstId");
            return (Criteria) this;
        }

        public Criteria andRootProcInstIdBetween(String value1, String value2) {
            addCriterion("ROOT_PROC_INST_ID_ between", value1, value2, "rootProcInstId");
            return (Criteria) this;
        }

        public Criteria andRootProcInstIdNotBetween(String value1, String value2) {
            addCriterion("ROOT_PROC_INST_ID_ not between", value1, value2, "rootProcInstId");
            return (Criteria) this;
        }

        public Criteria andActIdIsNull() {
            addCriterion("ACT_ID_ is null");
            return (Criteria) this;
        }

        public Criteria andActIdIsNotNull() {
            addCriterion("ACT_ID_ is not null");
            return (Criteria) this;
        }

        public Criteria andActIdEqualTo(String value) {
            addCriterion("ACT_ID_ =", value, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdNotEqualTo(String value) {
            addCriterion("ACT_ID_ <>", value, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdGreaterThan(String value) {
            addCriterion("ACT_ID_ >", value, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdGreaterThanOrEqualTo(String value) {
            addCriterion("ACT_ID_ >=", value, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdLessThan(String value) {
            addCriterion("ACT_ID_ <", value, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdLessThanOrEqualTo(String value) {
            addCriterion("ACT_ID_ <=", value, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdLike(String value) {
            addCriterion("ACT_ID_ like", value, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdNotLike(String value) {
            addCriterion("ACT_ID_ not like", value, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdIn(List<String> values) {
            addCriterion("ACT_ID_ in", values, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdNotIn(List<String> values) {
            addCriterion("ACT_ID_ not in", values, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdBetween(String value1, String value2) {
            addCriterion("ACT_ID_ between", value1, value2, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdNotBetween(String value1, String value2) {
            addCriterion("ACT_ID_ not between", value1, value2, "actId");
            return (Criteria) this;
        }

        public Criteria andIsActiveIsNull() {
            addCriterion("IS_ACTIVE_ is null");
            return (Criteria) this;
        }

        public Criteria andIsActiveIsNotNull() {
            addCriterion("IS_ACTIVE_ is not null");
            return (Criteria) this;
        }

        public Criteria andIsActiveEqualTo(Byte value) {
            addCriterion("IS_ACTIVE_ =", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveNotEqualTo(Byte value) {
            addCriterion("IS_ACTIVE_ <>", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveGreaterThan(Byte value) {
            addCriterion("IS_ACTIVE_ >", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveGreaterThanOrEqualTo(Byte value) {
            addCriterion("IS_ACTIVE_ >=", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveLessThan(Byte value) {
            addCriterion("IS_ACTIVE_ <", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveLessThanOrEqualTo(Byte value) {
            addCriterion("IS_ACTIVE_ <=", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveIn(List<Byte> values) {
            addCriterion("IS_ACTIVE_ in", values, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveNotIn(List<Byte> values) {
            addCriterion("IS_ACTIVE_ not in", values, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveBetween(Byte value1, Byte value2) {
            addCriterion("IS_ACTIVE_ between", value1, value2, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveNotBetween(Byte value1, Byte value2) {
            addCriterion("IS_ACTIVE_ not between", value1, value2, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsConcurrentIsNull() {
            addCriterion("IS_CONCURRENT_ is null");
            return (Criteria) this;
        }

        public Criteria andIsConcurrentIsNotNull() {
            addCriterion("IS_CONCURRENT_ is not null");
            return (Criteria) this;
        }

        public Criteria andIsConcurrentEqualTo(Byte value) {
            addCriterion("IS_CONCURRENT_ =", value, "isConcurrent");
            return (Criteria) this;
        }

        public Criteria andIsConcurrentNotEqualTo(Byte value) {
            addCriterion("IS_CONCURRENT_ <>", value, "isConcurrent");
            return (Criteria) this;
        }

        public Criteria andIsConcurrentGreaterThan(Byte value) {
            addCriterion("IS_CONCURRENT_ >", value, "isConcurrent");
            return (Criteria) this;
        }

        public Criteria andIsConcurrentGreaterThanOrEqualTo(Byte value) {
            addCriterion("IS_CONCURRENT_ >=", value, "isConcurrent");
            return (Criteria) this;
        }

        public Criteria andIsConcurrentLessThan(Byte value) {
            addCriterion("IS_CONCURRENT_ <", value, "isConcurrent");
            return (Criteria) this;
        }

        public Criteria andIsConcurrentLessThanOrEqualTo(Byte value) {
            addCriterion("IS_CONCURRENT_ <=", value, "isConcurrent");
            return (Criteria) this;
        }

        public Criteria andIsConcurrentIn(List<Byte> values) {
            addCriterion("IS_CONCURRENT_ in", values, "isConcurrent");
            return (Criteria) this;
        }

        public Criteria andIsConcurrentNotIn(List<Byte> values) {
            addCriterion("IS_CONCURRENT_ not in", values, "isConcurrent");
            return (Criteria) this;
        }

        public Criteria andIsConcurrentBetween(Byte value1, Byte value2) {
            addCriterion("IS_CONCURRENT_ between", value1, value2, "isConcurrent");
            return (Criteria) this;
        }

        public Criteria andIsConcurrentNotBetween(Byte value1, Byte value2) {
            addCriterion("IS_CONCURRENT_ not between", value1, value2, "isConcurrent");
            return (Criteria) this;
        }

        public Criteria andIsScopeIsNull() {
            addCriterion("IS_SCOPE_ is null");
            return (Criteria) this;
        }

        public Criteria andIsScopeIsNotNull() {
            addCriterion("IS_SCOPE_ is not null");
            return (Criteria) this;
        }

        public Criteria andIsScopeEqualTo(Byte value) {
            addCriterion("IS_SCOPE_ =", value, "isScope");
            return (Criteria) this;
        }

        public Criteria andIsScopeNotEqualTo(Byte value) {
            addCriterion("IS_SCOPE_ <>", value, "isScope");
            return (Criteria) this;
        }

        public Criteria andIsScopeGreaterThan(Byte value) {
            addCriterion("IS_SCOPE_ >", value, "isScope");
            return (Criteria) this;
        }

        public Criteria andIsScopeGreaterThanOrEqualTo(Byte value) {
            addCriterion("IS_SCOPE_ >=", value, "isScope");
            return (Criteria) this;
        }

        public Criteria andIsScopeLessThan(Byte value) {
            addCriterion("IS_SCOPE_ <", value, "isScope");
            return (Criteria) this;
        }

        public Criteria andIsScopeLessThanOrEqualTo(Byte value) {
            addCriterion("IS_SCOPE_ <=", value, "isScope");
            return (Criteria) this;
        }

        public Criteria andIsScopeIn(List<Byte> values) {
            addCriterion("IS_SCOPE_ in", values, "isScope");
            return (Criteria) this;
        }

        public Criteria andIsScopeNotIn(List<Byte> values) {
            addCriterion("IS_SCOPE_ not in", values, "isScope");
            return (Criteria) this;
        }

        public Criteria andIsScopeBetween(Byte value1, Byte value2) {
            addCriterion("IS_SCOPE_ between", value1, value2, "isScope");
            return (Criteria) this;
        }

        public Criteria andIsScopeNotBetween(Byte value1, Byte value2) {
            addCriterion("IS_SCOPE_ not between", value1, value2, "isScope");
            return (Criteria) this;
        }

        public Criteria andIsEventScopeIsNull() {
            addCriterion("IS_EVENT_SCOPE_ is null");
            return (Criteria) this;
        }

        public Criteria andIsEventScopeIsNotNull() {
            addCriterion("IS_EVENT_SCOPE_ is not null");
            return (Criteria) this;
        }

        public Criteria andIsEventScopeEqualTo(Byte value) {
            addCriterion("IS_EVENT_SCOPE_ =", value, "isEventScope");
            return (Criteria) this;
        }

        public Criteria andIsEventScopeNotEqualTo(Byte value) {
            addCriterion("IS_EVENT_SCOPE_ <>", value, "isEventScope");
            return (Criteria) this;
        }

        public Criteria andIsEventScopeGreaterThan(Byte value) {
            addCriterion("IS_EVENT_SCOPE_ >", value, "isEventScope");
            return (Criteria) this;
        }

        public Criteria andIsEventScopeGreaterThanOrEqualTo(Byte value) {
            addCriterion("IS_EVENT_SCOPE_ >=", value, "isEventScope");
            return (Criteria) this;
        }

        public Criteria andIsEventScopeLessThan(Byte value) {
            addCriterion("IS_EVENT_SCOPE_ <", value, "isEventScope");
            return (Criteria) this;
        }

        public Criteria andIsEventScopeLessThanOrEqualTo(Byte value) {
            addCriterion("IS_EVENT_SCOPE_ <=", value, "isEventScope");
            return (Criteria) this;
        }

        public Criteria andIsEventScopeIn(List<Byte> values) {
            addCriterion("IS_EVENT_SCOPE_ in", values, "isEventScope");
            return (Criteria) this;
        }

        public Criteria andIsEventScopeNotIn(List<Byte> values) {
            addCriterion("IS_EVENT_SCOPE_ not in", values, "isEventScope");
            return (Criteria) this;
        }

        public Criteria andIsEventScopeBetween(Byte value1, Byte value2) {
            addCriterion("IS_EVENT_SCOPE_ between", value1, value2, "isEventScope");
            return (Criteria) this;
        }

        public Criteria andIsEventScopeNotBetween(Byte value1, Byte value2) {
            addCriterion("IS_EVENT_SCOPE_ not between", value1, value2, "isEventScope");
            return (Criteria) this;
        }

        public Criteria andIsMiRootIsNull() {
            addCriterion("IS_MI_ROOT_ is null");
            return (Criteria) this;
        }

        public Criteria andIsMiRootIsNotNull() {
            addCriterion("IS_MI_ROOT_ is not null");
            return (Criteria) this;
        }

        public Criteria andIsMiRootEqualTo(Byte value) {
            addCriterion("IS_MI_ROOT_ =", value, "isMiRoot");
            return (Criteria) this;
        }

        public Criteria andIsMiRootNotEqualTo(Byte value) {
            addCriterion("IS_MI_ROOT_ <>", value, "isMiRoot");
            return (Criteria) this;
        }

        public Criteria andIsMiRootGreaterThan(Byte value) {
            addCriterion("IS_MI_ROOT_ >", value, "isMiRoot");
            return (Criteria) this;
        }

        public Criteria andIsMiRootGreaterThanOrEqualTo(Byte value) {
            addCriterion("IS_MI_ROOT_ >=", value, "isMiRoot");
            return (Criteria) this;
        }

        public Criteria andIsMiRootLessThan(Byte value) {
            addCriterion("IS_MI_ROOT_ <", value, "isMiRoot");
            return (Criteria) this;
        }

        public Criteria andIsMiRootLessThanOrEqualTo(Byte value) {
            addCriterion("IS_MI_ROOT_ <=", value, "isMiRoot");
            return (Criteria) this;
        }

        public Criteria andIsMiRootIn(List<Byte> values) {
            addCriterion("IS_MI_ROOT_ in", values, "isMiRoot");
            return (Criteria) this;
        }

        public Criteria andIsMiRootNotIn(List<Byte> values) {
            addCriterion("IS_MI_ROOT_ not in", values, "isMiRoot");
            return (Criteria) this;
        }

        public Criteria andIsMiRootBetween(Byte value1, Byte value2) {
            addCriterion("IS_MI_ROOT_ between", value1, value2, "isMiRoot");
            return (Criteria) this;
        }

        public Criteria andIsMiRootNotBetween(Byte value1, Byte value2) {
            addCriterion("IS_MI_ROOT_ not between", value1, value2, "isMiRoot");
            return (Criteria) this;
        }

        public Criteria andSuspensionStateIsNull() {
            addCriterion("SUSPENSION_STATE_ is null");
            return (Criteria) this;
        }

        public Criteria andSuspensionStateIsNotNull() {
            addCriterion("SUSPENSION_STATE_ is not null");
            return (Criteria) this;
        }

        public Criteria andSuspensionStateEqualTo(Integer value) {
            addCriterion("SUSPENSION_STATE_ =", value, "suspensionState");
            return (Criteria) this;
        }

        public Criteria andSuspensionStateNotEqualTo(Integer value) {
            addCriterion("SUSPENSION_STATE_ <>", value, "suspensionState");
            return (Criteria) this;
        }

        public Criteria andSuspensionStateGreaterThan(Integer value) {
            addCriterion("SUSPENSION_STATE_ >", value, "suspensionState");
            return (Criteria) this;
        }

        public Criteria andSuspensionStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("SUSPENSION_STATE_ >=", value, "suspensionState");
            return (Criteria) this;
        }

        public Criteria andSuspensionStateLessThan(Integer value) {
            addCriterion("SUSPENSION_STATE_ <", value, "suspensionState");
            return (Criteria) this;
        }

        public Criteria andSuspensionStateLessThanOrEqualTo(Integer value) {
            addCriterion("SUSPENSION_STATE_ <=", value, "suspensionState");
            return (Criteria) this;
        }

        public Criteria andSuspensionStateIn(List<Integer> values) {
            addCriterion("SUSPENSION_STATE_ in", values, "suspensionState");
            return (Criteria) this;
        }

        public Criteria andSuspensionStateNotIn(List<Integer> values) {
            addCriterion("SUSPENSION_STATE_ not in", values, "suspensionState");
            return (Criteria) this;
        }

        public Criteria andSuspensionStateBetween(Integer value1, Integer value2) {
            addCriterion("SUSPENSION_STATE_ between", value1, value2, "suspensionState");
            return (Criteria) this;
        }

        public Criteria andSuspensionStateNotBetween(Integer value1, Integer value2) {
            addCriterion("SUSPENSION_STATE_ not between", value1, value2, "suspensionState");
            return (Criteria) this;
        }

        public Criteria andCachedEntStateIsNull() {
            addCriterion("CACHED_ENT_STATE_ is null");
            return (Criteria) this;
        }

        public Criteria andCachedEntStateIsNotNull() {
            addCriterion("CACHED_ENT_STATE_ is not null");
            return (Criteria) this;
        }

        public Criteria andCachedEntStateEqualTo(Integer value) {
            addCriterion("CACHED_ENT_STATE_ =", value, "cachedEntState");
            return (Criteria) this;
        }

        public Criteria andCachedEntStateNotEqualTo(Integer value) {
            addCriterion("CACHED_ENT_STATE_ <>", value, "cachedEntState");
            return (Criteria) this;
        }

        public Criteria andCachedEntStateGreaterThan(Integer value) {
            addCriterion("CACHED_ENT_STATE_ >", value, "cachedEntState");
            return (Criteria) this;
        }

        public Criteria andCachedEntStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("CACHED_ENT_STATE_ >=", value, "cachedEntState");
            return (Criteria) this;
        }

        public Criteria andCachedEntStateLessThan(Integer value) {
            addCriterion("CACHED_ENT_STATE_ <", value, "cachedEntState");
            return (Criteria) this;
        }

        public Criteria andCachedEntStateLessThanOrEqualTo(Integer value) {
            addCriterion("CACHED_ENT_STATE_ <=", value, "cachedEntState");
            return (Criteria) this;
        }

        public Criteria andCachedEntStateIn(List<Integer> values) {
            addCriterion("CACHED_ENT_STATE_ in", values, "cachedEntState");
            return (Criteria) this;
        }

        public Criteria andCachedEntStateNotIn(List<Integer> values) {
            addCriterion("CACHED_ENT_STATE_ not in", values, "cachedEntState");
            return (Criteria) this;
        }

        public Criteria andCachedEntStateBetween(Integer value1, Integer value2) {
            addCriterion("CACHED_ENT_STATE_ between", value1, value2, "cachedEntState");
            return (Criteria) this;
        }

        public Criteria andCachedEntStateNotBetween(Integer value1, Integer value2) {
            addCriterion("CACHED_ENT_STATE_ not between", value1, value2, "cachedEntState");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNull() {
            addCriterion("TENANT_ID_ is null");
            return (Criteria) this;
        }

        public Criteria andTenantIdIsNotNull() {
            addCriterion("TENANT_ID_ is not null");
            return (Criteria) this;
        }

        public Criteria andTenantIdEqualTo(String value) {
            addCriterion("TENANT_ID_ =", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotEqualTo(String value) {
            addCriterion("TENANT_ID_ <>", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThan(String value) {
            addCriterion("TENANT_ID_ >", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdGreaterThanOrEqualTo(String value) {
            addCriterion("TENANT_ID_ >=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThan(String value) {
            addCriterion("TENANT_ID_ <", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLessThanOrEqualTo(String value) {
            addCriterion("TENANT_ID_ <=", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdLike(String value) {
            addCriterion("TENANT_ID_ like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotLike(String value) {
            addCriterion("TENANT_ID_ not like", value, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdIn(List<String> values) {
            addCriterion("TENANT_ID_ in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotIn(List<String> values) {
            addCriterion("TENANT_ID_ not in", values, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdBetween(String value1, String value2) {
            addCriterion("TENANT_ID_ between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andTenantIdNotBetween(String value1, String value2) {
            addCriterion("TENANT_ID_ not between", value1, value2, "tenantId");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME_ is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME_ is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME_ =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME_ <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME_ >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME_ >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME_ <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME_ <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME_ like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME_ not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME_ in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME_ not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME_ between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME_ not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("START_TIME_ is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("START_TIME_ is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("START_TIME_ =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("START_TIME_ <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("START_TIME_ >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("START_TIME_ >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("START_TIME_ <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("START_TIME_ <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("START_TIME_ in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("START_TIME_ not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("START_TIME_ between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("START_TIME_ not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartUserIdIsNull() {
            addCriterion("START_USER_ID_ is null");
            return (Criteria) this;
        }

        public Criteria andStartUserIdIsNotNull() {
            addCriterion("START_USER_ID_ is not null");
            return (Criteria) this;
        }

        public Criteria andStartUserIdEqualTo(String value) {
            addCriterion("START_USER_ID_ =", value, "startUserId");
            return (Criteria) this;
        }

        public Criteria andStartUserIdNotEqualTo(String value) {
            addCriterion("START_USER_ID_ <>", value, "startUserId");
            return (Criteria) this;
        }

        public Criteria andStartUserIdGreaterThan(String value) {
            addCriterion("START_USER_ID_ >", value, "startUserId");
            return (Criteria) this;
        }

        public Criteria andStartUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("START_USER_ID_ >=", value, "startUserId");
            return (Criteria) this;
        }

        public Criteria andStartUserIdLessThan(String value) {
            addCriterion("START_USER_ID_ <", value, "startUserId");
            return (Criteria) this;
        }

        public Criteria andStartUserIdLessThanOrEqualTo(String value) {
            addCriterion("START_USER_ID_ <=", value, "startUserId");
            return (Criteria) this;
        }

        public Criteria andStartUserIdLike(String value) {
            addCriterion("START_USER_ID_ like", value, "startUserId");
            return (Criteria) this;
        }

        public Criteria andStartUserIdNotLike(String value) {
            addCriterion("START_USER_ID_ not like", value, "startUserId");
            return (Criteria) this;
        }

        public Criteria andStartUserIdIn(List<String> values) {
            addCriterion("START_USER_ID_ in", values, "startUserId");
            return (Criteria) this;
        }

        public Criteria andStartUserIdNotIn(List<String> values) {
            addCriterion("START_USER_ID_ not in", values, "startUserId");
            return (Criteria) this;
        }

        public Criteria andStartUserIdBetween(String value1, String value2) {
            addCriterion("START_USER_ID_ between", value1, value2, "startUserId");
            return (Criteria) this;
        }

        public Criteria andStartUserIdNotBetween(String value1, String value2) {
            addCriterion("START_USER_ID_ not between", value1, value2, "startUserId");
            return (Criteria) this;
        }

        public Criteria andLockTimeIsNull() {
            addCriterion("LOCK_TIME_ is null");
            return (Criteria) this;
        }

        public Criteria andLockTimeIsNotNull() {
            addCriterion("LOCK_TIME_ is not null");
            return (Criteria) this;
        }

        public Criteria andLockTimeEqualTo(Date value) {
            addCriterion("LOCK_TIME_ =", value, "lockTime");
            return (Criteria) this;
        }

        public Criteria andLockTimeNotEqualTo(Date value) {
            addCriterion("LOCK_TIME_ <>", value, "lockTime");
            return (Criteria) this;
        }

        public Criteria andLockTimeGreaterThan(Date value) {
            addCriterion("LOCK_TIME_ >", value, "lockTime");
            return (Criteria) this;
        }

        public Criteria andLockTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LOCK_TIME_ >=", value, "lockTime");
            return (Criteria) this;
        }

        public Criteria andLockTimeLessThan(Date value) {
            addCriterion("LOCK_TIME_ <", value, "lockTime");
            return (Criteria) this;
        }

        public Criteria andLockTimeLessThanOrEqualTo(Date value) {
            addCriterion("LOCK_TIME_ <=", value, "lockTime");
            return (Criteria) this;
        }

        public Criteria andLockTimeIn(List<Date> values) {
            addCriterion("LOCK_TIME_ in", values, "lockTime");
            return (Criteria) this;
        }

        public Criteria andLockTimeNotIn(List<Date> values) {
            addCriterion("LOCK_TIME_ not in", values, "lockTime");
            return (Criteria) this;
        }

        public Criteria andLockTimeBetween(Date value1, Date value2) {
            addCriterion("LOCK_TIME_ between", value1, value2, "lockTime");
            return (Criteria) this;
        }

        public Criteria andLockTimeNotBetween(Date value1, Date value2) {
            addCriterion("LOCK_TIME_ not between", value1, value2, "lockTime");
            return (Criteria) this;
        }

        public Criteria andIsCountEnabledIsNull() {
            addCriterion("IS_COUNT_ENABLED_ is null");
            return (Criteria) this;
        }

        public Criteria andIsCountEnabledIsNotNull() {
            addCriterion("IS_COUNT_ENABLED_ is not null");
            return (Criteria) this;
        }

        public Criteria andIsCountEnabledEqualTo(Byte value) {
            addCriterion("IS_COUNT_ENABLED_ =", value, "isCountEnabled");
            return (Criteria) this;
        }

        public Criteria andIsCountEnabledNotEqualTo(Byte value) {
            addCriterion("IS_COUNT_ENABLED_ <>", value, "isCountEnabled");
            return (Criteria) this;
        }

        public Criteria andIsCountEnabledGreaterThan(Byte value) {
            addCriterion("IS_COUNT_ENABLED_ >", value, "isCountEnabled");
            return (Criteria) this;
        }

        public Criteria andIsCountEnabledGreaterThanOrEqualTo(Byte value) {
            addCriterion("IS_COUNT_ENABLED_ >=", value, "isCountEnabled");
            return (Criteria) this;
        }

        public Criteria andIsCountEnabledLessThan(Byte value) {
            addCriterion("IS_COUNT_ENABLED_ <", value, "isCountEnabled");
            return (Criteria) this;
        }

        public Criteria andIsCountEnabledLessThanOrEqualTo(Byte value) {
            addCriterion("IS_COUNT_ENABLED_ <=", value, "isCountEnabled");
            return (Criteria) this;
        }

        public Criteria andIsCountEnabledIn(List<Byte> values) {
            addCriterion("IS_COUNT_ENABLED_ in", values, "isCountEnabled");
            return (Criteria) this;
        }

        public Criteria andIsCountEnabledNotIn(List<Byte> values) {
            addCriterion("IS_COUNT_ENABLED_ not in", values, "isCountEnabled");
            return (Criteria) this;
        }

        public Criteria andIsCountEnabledBetween(Byte value1, Byte value2) {
            addCriterion("IS_COUNT_ENABLED_ between", value1, value2, "isCountEnabled");
            return (Criteria) this;
        }

        public Criteria andIsCountEnabledNotBetween(Byte value1, Byte value2) {
            addCriterion("IS_COUNT_ENABLED_ not between", value1, value2, "isCountEnabled");
            return (Criteria) this;
        }

        public Criteria andEvtSubscrCountIsNull() {
            addCriterion("EVT_SUBSCR_COUNT_ is null");
            return (Criteria) this;
        }

        public Criteria andEvtSubscrCountIsNotNull() {
            addCriterion("EVT_SUBSCR_COUNT_ is not null");
            return (Criteria) this;
        }

        public Criteria andEvtSubscrCountEqualTo(Integer value) {
            addCriterion("EVT_SUBSCR_COUNT_ =", value, "evtSubscrCount");
            return (Criteria) this;
        }

        public Criteria andEvtSubscrCountNotEqualTo(Integer value) {
            addCriterion("EVT_SUBSCR_COUNT_ <>", value, "evtSubscrCount");
            return (Criteria) this;
        }

        public Criteria andEvtSubscrCountGreaterThan(Integer value) {
            addCriterion("EVT_SUBSCR_COUNT_ >", value, "evtSubscrCount");
            return (Criteria) this;
        }

        public Criteria andEvtSubscrCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("EVT_SUBSCR_COUNT_ >=", value, "evtSubscrCount");
            return (Criteria) this;
        }

        public Criteria andEvtSubscrCountLessThan(Integer value) {
            addCriterion("EVT_SUBSCR_COUNT_ <", value, "evtSubscrCount");
            return (Criteria) this;
        }

        public Criteria andEvtSubscrCountLessThanOrEqualTo(Integer value) {
            addCriterion("EVT_SUBSCR_COUNT_ <=", value, "evtSubscrCount");
            return (Criteria) this;
        }

        public Criteria andEvtSubscrCountIn(List<Integer> values) {
            addCriterion("EVT_SUBSCR_COUNT_ in", values, "evtSubscrCount");
            return (Criteria) this;
        }

        public Criteria andEvtSubscrCountNotIn(List<Integer> values) {
            addCriterion("EVT_SUBSCR_COUNT_ not in", values, "evtSubscrCount");
            return (Criteria) this;
        }

        public Criteria andEvtSubscrCountBetween(Integer value1, Integer value2) {
            addCriterion("EVT_SUBSCR_COUNT_ between", value1, value2, "evtSubscrCount");
            return (Criteria) this;
        }

        public Criteria andEvtSubscrCountNotBetween(Integer value1, Integer value2) {
            addCriterion("EVT_SUBSCR_COUNT_ not between", value1, value2, "evtSubscrCount");
            return (Criteria) this;
        }

        public Criteria andTaskCountIsNull() {
            addCriterion("TASK_COUNT_ is null");
            return (Criteria) this;
        }

        public Criteria andTaskCountIsNotNull() {
            addCriterion("TASK_COUNT_ is not null");
            return (Criteria) this;
        }

        public Criteria andTaskCountEqualTo(Integer value) {
            addCriterion("TASK_COUNT_ =", value, "taskCount");
            return (Criteria) this;
        }

        public Criteria andTaskCountNotEqualTo(Integer value) {
            addCriterion("TASK_COUNT_ <>", value, "taskCount");
            return (Criteria) this;
        }

        public Criteria andTaskCountGreaterThan(Integer value) {
            addCriterion("TASK_COUNT_ >", value, "taskCount");
            return (Criteria) this;
        }

        public Criteria andTaskCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("TASK_COUNT_ >=", value, "taskCount");
            return (Criteria) this;
        }

        public Criteria andTaskCountLessThan(Integer value) {
            addCriterion("TASK_COUNT_ <", value, "taskCount");
            return (Criteria) this;
        }

        public Criteria andTaskCountLessThanOrEqualTo(Integer value) {
            addCriterion("TASK_COUNT_ <=", value, "taskCount");
            return (Criteria) this;
        }

        public Criteria andTaskCountIn(List<Integer> values) {
            addCriterion("TASK_COUNT_ in", values, "taskCount");
            return (Criteria) this;
        }

        public Criteria andTaskCountNotIn(List<Integer> values) {
            addCriterion("TASK_COUNT_ not in", values, "taskCount");
            return (Criteria) this;
        }

        public Criteria andTaskCountBetween(Integer value1, Integer value2) {
            addCriterion("TASK_COUNT_ between", value1, value2, "taskCount");
            return (Criteria) this;
        }

        public Criteria andTaskCountNotBetween(Integer value1, Integer value2) {
            addCriterion("TASK_COUNT_ not between", value1, value2, "taskCount");
            return (Criteria) this;
        }

        public Criteria andJobCountIsNull() {
            addCriterion("JOB_COUNT_ is null");
            return (Criteria) this;
        }

        public Criteria andJobCountIsNotNull() {
            addCriterion("JOB_COUNT_ is not null");
            return (Criteria) this;
        }

        public Criteria andJobCountEqualTo(Integer value) {
            addCriterion("JOB_COUNT_ =", value, "jobCount");
            return (Criteria) this;
        }

        public Criteria andJobCountNotEqualTo(Integer value) {
            addCriterion("JOB_COUNT_ <>", value, "jobCount");
            return (Criteria) this;
        }

        public Criteria andJobCountGreaterThan(Integer value) {
            addCriterion("JOB_COUNT_ >", value, "jobCount");
            return (Criteria) this;
        }

        public Criteria andJobCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("JOB_COUNT_ >=", value, "jobCount");
            return (Criteria) this;
        }

        public Criteria andJobCountLessThan(Integer value) {
            addCriterion("JOB_COUNT_ <", value, "jobCount");
            return (Criteria) this;
        }

        public Criteria andJobCountLessThanOrEqualTo(Integer value) {
            addCriterion("JOB_COUNT_ <=", value, "jobCount");
            return (Criteria) this;
        }

        public Criteria andJobCountIn(List<Integer> values) {
            addCriterion("JOB_COUNT_ in", values, "jobCount");
            return (Criteria) this;
        }

        public Criteria andJobCountNotIn(List<Integer> values) {
            addCriterion("JOB_COUNT_ not in", values, "jobCount");
            return (Criteria) this;
        }

        public Criteria andJobCountBetween(Integer value1, Integer value2) {
            addCriterion("JOB_COUNT_ between", value1, value2, "jobCount");
            return (Criteria) this;
        }

        public Criteria andJobCountNotBetween(Integer value1, Integer value2) {
            addCriterion("JOB_COUNT_ not between", value1, value2, "jobCount");
            return (Criteria) this;
        }

        public Criteria andTimerJobCountIsNull() {
            addCriterion("TIMER_JOB_COUNT_ is null");
            return (Criteria) this;
        }

        public Criteria andTimerJobCountIsNotNull() {
            addCriterion("TIMER_JOB_COUNT_ is not null");
            return (Criteria) this;
        }

        public Criteria andTimerJobCountEqualTo(Integer value) {
            addCriterion("TIMER_JOB_COUNT_ =", value, "timerJobCount");
            return (Criteria) this;
        }

        public Criteria andTimerJobCountNotEqualTo(Integer value) {
            addCriterion("TIMER_JOB_COUNT_ <>", value, "timerJobCount");
            return (Criteria) this;
        }

        public Criteria andTimerJobCountGreaterThan(Integer value) {
            addCriterion("TIMER_JOB_COUNT_ >", value, "timerJobCount");
            return (Criteria) this;
        }

        public Criteria andTimerJobCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("TIMER_JOB_COUNT_ >=", value, "timerJobCount");
            return (Criteria) this;
        }

        public Criteria andTimerJobCountLessThan(Integer value) {
            addCriterion("TIMER_JOB_COUNT_ <", value, "timerJobCount");
            return (Criteria) this;
        }

        public Criteria andTimerJobCountLessThanOrEqualTo(Integer value) {
            addCriterion("TIMER_JOB_COUNT_ <=", value, "timerJobCount");
            return (Criteria) this;
        }

        public Criteria andTimerJobCountIn(List<Integer> values) {
            addCriterion("TIMER_JOB_COUNT_ in", values, "timerJobCount");
            return (Criteria) this;
        }

        public Criteria andTimerJobCountNotIn(List<Integer> values) {
            addCriterion("TIMER_JOB_COUNT_ not in", values, "timerJobCount");
            return (Criteria) this;
        }

        public Criteria andTimerJobCountBetween(Integer value1, Integer value2) {
            addCriterion("TIMER_JOB_COUNT_ between", value1, value2, "timerJobCount");
            return (Criteria) this;
        }

        public Criteria andTimerJobCountNotBetween(Integer value1, Integer value2) {
            addCriterion("TIMER_JOB_COUNT_ not between", value1, value2, "timerJobCount");
            return (Criteria) this;
        }

        public Criteria andSuspJobCountIsNull() {
            addCriterion("SUSP_JOB_COUNT_ is null");
            return (Criteria) this;
        }

        public Criteria andSuspJobCountIsNotNull() {
            addCriterion("SUSP_JOB_COUNT_ is not null");
            return (Criteria) this;
        }

        public Criteria andSuspJobCountEqualTo(Integer value) {
            addCriterion("SUSP_JOB_COUNT_ =", value, "suspJobCount");
            return (Criteria) this;
        }

        public Criteria andSuspJobCountNotEqualTo(Integer value) {
            addCriterion("SUSP_JOB_COUNT_ <>", value, "suspJobCount");
            return (Criteria) this;
        }

        public Criteria andSuspJobCountGreaterThan(Integer value) {
            addCriterion("SUSP_JOB_COUNT_ >", value, "suspJobCount");
            return (Criteria) this;
        }

        public Criteria andSuspJobCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("SUSP_JOB_COUNT_ >=", value, "suspJobCount");
            return (Criteria) this;
        }

        public Criteria andSuspJobCountLessThan(Integer value) {
            addCriterion("SUSP_JOB_COUNT_ <", value, "suspJobCount");
            return (Criteria) this;
        }

        public Criteria andSuspJobCountLessThanOrEqualTo(Integer value) {
            addCriterion("SUSP_JOB_COUNT_ <=", value, "suspJobCount");
            return (Criteria) this;
        }

        public Criteria andSuspJobCountIn(List<Integer> values) {
            addCriterion("SUSP_JOB_COUNT_ in", values, "suspJobCount");
            return (Criteria) this;
        }

        public Criteria andSuspJobCountNotIn(List<Integer> values) {
            addCriterion("SUSP_JOB_COUNT_ not in", values, "suspJobCount");
            return (Criteria) this;
        }

        public Criteria andSuspJobCountBetween(Integer value1, Integer value2) {
            addCriterion("SUSP_JOB_COUNT_ between", value1, value2, "suspJobCount");
            return (Criteria) this;
        }

        public Criteria andSuspJobCountNotBetween(Integer value1, Integer value2) {
            addCriterion("SUSP_JOB_COUNT_ not between", value1, value2, "suspJobCount");
            return (Criteria) this;
        }

        public Criteria andDeadletterJobCountIsNull() {
            addCriterion("DEADLETTER_JOB_COUNT_ is null");
            return (Criteria) this;
        }

        public Criteria andDeadletterJobCountIsNotNull() {
            addCriterion("DEADLETTER_JOB_COUNT_ is not null");
            return (Criteria) this;
        }

        public Criteria andDeadletterJobCountEqualTo(Integer value) {
            addCriterion("DEADLETTER_JOB_COUNT_ =", value, "deadletterJobCount");
            return (Criteria) this;
        }

        public Criteria andDeadletterJobCountNotEqualTo(Integer value) {
            addCriterion("DEADLETTER_JOB_COUNT_ <>", value, "deadletterJobCount");
            return (Criteria) this;
        }

        public Criteria andDeadletterJobCountGreaterThan(Integer value) {
            addCriterion("DEADLETTER_JOB_COUNT_ >", value, "deadletterJobCount");
            return (Criteria) this;
        }

        public Criteria andDeadletterJobCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("DEADLETTER_JOB_COUNT_ >=", value, "deadletterJobCount");
            return (Criteria) this;
        }

        public Criteria andDeadletterJobCountLessThan(Integer value) {
            addCriterion("DEADLETTER_JOB_COUNT_ <", value, "deadletterJobCount");
            return (Criteria) this;
        }

        public Criteria andDeadletterJobCountLessThanOrEqualTo(Integer value) {
            addCriterion("DEADLETTER_JOB_COUNT_ <=", value, "deadletterJobCount");
            return (Criteria) this;
        }

        public Criteria andDeadletterJobCountIn(List<Integer> values) {
            addCriterion("DEADLETTER_JOB_COUNT_ in", values, "deadletterJobCount");
            return (Criteria) this;
        }

        public Criteria andDeadletterJobCountNotIn(List<Integer> values) {
            addCriterion("DEADLETTER_JOB_COUNT_ not in", values, "deadletterJobCount");
            return (Criteria) this;
        }

        public Criteria andDeadletterJobCountBetween(Integer value1, Integer value2) {
            addCriterion("DEADLETTER_JOB_COUNT_ between", value1, value2, "deadletterJobCount");
            return (Criteria) this;
        }

        public Criteria andDeadletterJobCountNotBetween(Integer value1, Integer value2) {
            addCriterion("DEADLETTER_JOB_COUNT_ not between", value1, value2, "deadletterJobCount");
            return (Criteria) this;
        }

        public Criteria andVarCountIsNull() {
            addCriterion("VAR_COUNT_ is null");
            return (Criteria) this;
        }

        public Criteria andVarCountIsNotNull() {
            addCriterion("VAR_COUNT_ is not null");
            return (Criteria) this;
        }

        public Criteria andVarCountEqualTo(Integer value) {
            addCriterion("VAR_COUNT_ =", value, "varCount");
            return (Criteria) this;
        }

        public Criteria andVarCountNotEqualTo(Integer value) {
            addCriterion("VAR_COUNT_ <>", value, "varCount");
            return (Criteria) this;
        }

        public Criteria andVarCountGreaterThan(Integer value) {
            addCriterion("VAR_COUNT_ >", value, "varCount");
            return (Criteria) this;
        }

        public Criteria andVarCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("VAR_COUNT_ >=", value, "varCount");
            return (Criteria) this;
        }

        public Criteria andVarCountLessThan(Integer value) {
            addCriterion("VAR_COUNT_ <", value, "varCount");
            return (Criteria) this;
        }

        public Criteria andVarCountLessThanOrEqualTo(Integer value) {
            addCriterion("VAR_COUNT_ <=", value, "varCount");
            return (Criteria) this;
        }

        public Criteria andVarCountIn(List<Integer> values) {
            addCriterion("VAR_COUNT_ in", values, "varCount");
            return (Criteria) this;
        }

        public Criteria andVarCountNotIn(List<Integer> values) {
            addCriterion("VAR_COUNT_ not in", values, "varCount");
            return (Criteria) this;
        }

        public Criteria andVarCountBetween(Integer value1, Integer value2) {
            addCriterion("VAR_COUNT_ between", value1, value2, "varCount");
            return (Criteria) this;
        }

        public Criteria andVarCountNotBetween(Integer value1, Integer value2) {
            addCriterion("VAR_COUNT_ not between", value1, value2, "varCount");
            return (Criteria) this;
        }

        public Criteria andIdLinkCountIsNull() {
            addCriterion("ID_LINK_COUNT_ is null");
            return (Criteria) this;
        }

        public Criteria andIdLinkCountIsNotNull() {
            addCriterion("ID_LINK_COUNT_ is not null");
            return (Criteria) this;
        }

        public Criteria andIdLinkCountEqualTo(Integer value) {
            addCriterion("ID_LINK_COUNT_ =", value, "idLinkCount");
            return (Criteria) this;
        }

        public Criteria andIdLinkCountNotEqualTo(Integer value) {
            addCriterion("ID_LINK_COUNT_ <>", value, "idLinkCount");
            return (Criteria) this;
        }

        public Criteria andIdLinkCountGreaterThan(Integer value) {
            addCriterion("ID_LINK_COUNT_ >", value, "idLinkCount");
            return (Criteria) this;
        }

        public Criteria andIdLinkCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID_LINK_COUNT_ >=", value, "idLinkCount");
            return (Criteria) this;
        }

        public Criteria andIdLinkCountLessThan(Integer value) {
            addCriterion("ID_LINK_COUNT_ <", value, "idLinkCount");
            return (Criteria) this;
        }

        public Criteria andIdLinkCountLessThanOrEqualTo(Integer value) {
            addCriterion("ID_LINK_COUNT_ <=", value, "idLinkCount");
            return (Criteria) this;
        }

        public Criteria andIdLinkCountIn(List<Integer> values) {
            addCriterion("ID_LINK_COUNT_ in", values, "idLinkCount");
            return (Criteria) this;
        }

        public Criteria andIdLinkCountNotIn(List<Integer> values) {
            addCriterion("ID_LINK_COUNT_ not in", values, "idLinkCount");
            return (Criteria) this;
        }

        public Criteria andIdLinkCountBetween(Integer value1, Integer value2) {
            addCriterion("ID_LINK_COUNT_ between", value1, value2, "idLinkCount");
            return (Criteria) this;
        }

        public Criteria andIdLinkCountNotBetween(Integer value1, Integer value2) {
            addCriterion("ID_LINK_COUNT_ not between", value1, value2, "idLinkCount");
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