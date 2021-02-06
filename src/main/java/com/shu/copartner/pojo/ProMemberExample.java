package com.shu.copartner.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProMemberExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProMemberExample() {
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

        public Criteria andMemberIdIsNull() {
            addCriterion("member_id is null");
            return (Criteria) this;
        }

        public Criteria andMemberIdIsNotNull() {
            addCriterion("member_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIdEqualTo(Long value) {
            addCriterion("member_id =", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotEqualTo(Long value) {
            addCriterion("member_id <>", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThan(Long value) {
            addCriterion("member_id >", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdGreaterThanOrEqualTo(Long value) {
            addCriterion("member_id >=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThan(Long value) {
            addCriterion("member_id <", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdLessThanOrEqualTo(Long value) {
            addCriterion("member_id <=", value, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdIn(List<Long> values) {
            addCriterion("member_id in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotIn(List<Long> values) {
            addCriterion("member_id not in", values, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdBetween(Long value1, Long value2) {
            addCriterion("member_id between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberIdNotBetween(Long value1, Long value2) {
            addCriterion("member_id not between", value1, value2, "memberId");
            return (Criteria) this;
        }

        public Criteria andMemberNameIsNull() {
            addCriterion("member_name is null");
            return (Criteria) this;
        }

        public Criteria andMemberNameIsNotNull() {
            addCriterion("member_name is not null");
            return (Criteria) this;
        }

        public Criteria andMemberNameEqualTo(String value) {
            addCriterion("member_name =", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameNotEqualTo(String value) {
            addCriterion("member_name <>", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameGreaterThan(String value) {
            addCriterion("member_name >", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameGreaterThanOrEqualTo(String value) {
            addCriterion("member_name >=", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameLessThan(String value) {
            addCriterion("member_name <", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameLessThanOrEqualTo(String value) {
            addCriterion("member_name <=", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameLike(String value) {
            addCriterion("member_name like", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameNotLike(String value) {
            addCriterion("member_name not like", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameIn(List<String> values) {
            addCriterion("member_name in", values, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameNotIn(List<String> values) {
            addCriterion("member_name not in", values, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameBetween(String value1, String value2) {
            addCriterion("member_name between", value1, value2, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameNotBetween(String value1, String value2) {
            addCriterion("member_name not between", value1, value2, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberPhoneIsNull() {
            addCriterion("member_phone is null");
            return (Criteria) this;
        }

        public Criteria andMemberPhoneIsNotNull() {
            addCriterion("member_phone is not null");
            return (Criteria) this;
        }

        public Criteria andMemberPhoneEqualTo(String value) {
            addCriterion("member_phone =", value, "memberPhone");
            return (Criteria) this;
        }

        public Criteria andMemberPhoneNotEqualTo(String value) {
            addCriterion("member_phone <>", value, "memberPhone");
            return (Criteria) this;
        }

        public Criteria andMemberPhoneGreaterThan(String value) {
            addCriterion("member_phone >", value, "memberPhone");
            return (Criteria) this;
        }

        public Criteria andMemberPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("member_phone >=", value, "memberPhone");
            return (Criteria) this;
        }

        public Criteria andMemberPhoneLessThan(String value) {
            addCriterion("member_phone <", value, "memberPhone");
            return (Criteria) this;
        }

        public Criteria andMemberPhoneLessThanOrEqualTo(String value) {
            addCriterion("member_phone <=", value, "memberPhone");
            return (Criteria) this;
        }

        public Criteria andMemberPhoneLike(String value) {
            addCriterion("member_phone like", value, "memberPhone");
            return (Criteria) this;
        }

        public Criteria andMemberPhoneNotLike(String value) {
            addCriterion("member_phone not like", value, "memberPhone");
            return (Criteria) this;
        }

        public Criteria andMemberPhoneIn(List<String> values) {
            addCriterion("member_phone in", values, "memberPhone");
            return (Criteria) this;
        }

        public Criteria andMemberPhoneNotIn(List<String> values) {
            addCriterion("member_phone not in", values, "memberPhone");
            return (Criteria) this;
        }

        public Criteria andMemberPhoneBetween(String value1, String value2) {
            addCriterion("member_phone between", value1, value2, "memberPhone");
            return (Criteria) this;
        }

        public Criteria andMemberPhoneNotBetween(String value1, String value2) {
            addCriterion("member_phone not between", value1, value2, "memberPhone");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNull() {
            addCriterion("project_id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(Long value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(Long value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(Long value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(Long value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(Long value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(Long value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<Long> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<Long> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(Long value1, Long value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(Long value1, Long value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andInviterNameIsNull() {
            addCriterion("inviter_name is null");
            return (Criteria) this;
        }

        public Criteria andInviterNameIsNotNull() {
            addCriterion("inviter_name is not null");
            return (Criteria) this;
        }

        public Criteria andInviterNameEqualTo(String value) {
            addCriterion("inviter_name =", value, "inviterName");
            return (Criteria) this;
        }

        public Criteria andInviterNameNotEqualTo(String value) {
            addCriterion("inviter_name <>", value, "inviterName");
            return (Criteria) this;
        }

        public Criteria andInviterNameGreaterThan(String value) {
            addCriterion("inviter_name >", value, "inviterName");
            return (Criteria) this;
        }

        public Criteria andInviterNameGreaterThanOrEqualTo(String value) {
            addCriterion("inviter_name >=", value, "inviterName");
            return (Criteria) this;
        }

        public Criteria andInviterNameLessThan(String value) {
            addCriterion("inviter_name <", value, "inviterName");
            return (Criteria) this;
        }

        public Criteria andInviterNameLessThanOrEqualTo(String value) {
            addCriterion("inviter_name <=", value, "inviterName");
            return (Criteria) this;
        }

        public Criteria andInviterNameLike(String value) {
            addCriterion("inviter_name like", value, "inviterName");
            return (Criteria) this;
        }

        public Criteria andInviterNameNotLike(String value) {
            addCriterion("inviter_name not like", value, "inviterName");
            return (Criteria) this;
        }

        public Criteria andInviterNameIn(List<String> values) {
            addCriterion("inviter_name in", values, "inviterName");
            return (Criteria) this;
        }

        public Criteria andInviterNameNotIn(List<String> values) {
            addCriterion("inviter_name not in", values, "inviterName");
            return (Criteria) this;
        }

        public Criteria andInviterNameBetween(String value1, String value2) {
            addCriterion("inviter_name between", value1, value2, "inviterName");
            return (Criteria) this;
        }

        public Criteria andInviterNameNotBetween(String value1, String value2) {
            addCriterion("inviter_name not between", value1, value2, "inviterName");
            return (Criteria) this;
        }

        public Criteria andApplyDateIsNull() {
            addCriterion("apply_date is null");
            return (Criteria) this;
        }

        public Criteria andApplyDateIsNotNull() {
            addCriterion("apply_date is not null");
            return (Criteria) this;
        }

        public Criteria andApplyDateEqualTo(Date value) {
            addCriterion("apply_date =", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotEqualTo(Date value) {
            addCriterion("apply_date <>", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateGreaterThan(Date value) {
            addCriterion("apply_date >", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("apply_date >=", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateLessThan(Date value) {
            addCriterion("apply_date <", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateLessThanOrEqualTo(Date value) {
            addCriterion("apply_date <=", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateIn(List<Date> values) {
            addCriterion("apply_date in", values, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotIn(List<Date> values) {
            addCriterion("apply_date not in", values, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateBetween(Date value1, Date value2) {
            addCriterion("apply_date between", value1, value2, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotBetween(Date value1, Date value2) {
            addCriterion("apply_date not between", value1, value2, "applyDate");
            return (Criteria) this;
        }

        public Criteria andInviteDateIsNull() {
            addCriterion("invite_date is null");
            return (Criteria) this;
        }

        public Criteria andInviteDateIsNotNull() {
            addCriterion("invite_date is not null");
            return (Criteria) this;
        }

        public Criteria andInviteDateEqualTo(Date value) {
            addCriterion("invite_date =", value, "inviteDate");
            return (Criteria) this;
        }

        public Criteria andInviteDateNotEqualTo(Date value) {
            addCriterion("invite_date <>", value, "inviteDate");
            return (Criteria) this;
        }

        public Criteria andInviteDateGreaterThan(Date value) {
            addCriterion("invite_date >", value, "inviteDate");
            return (Criteria) this;
        }

        public Criteria andInviteDateGreaterThanOrEqualTo(Date value) {
            addCriterion("invite_date >=", value, "inviteDate");
            return (Criteria) this;
        }

        public Criteria andInviteDateLessThan(Date value) {
            addCriterion("invite_date <", value, "inviteDate");
            return (Criteria) this;
        }

        public Criteria andInviteDateLessThanOrEqualTo(Date value) {
            addCriterion("invite_date <=", value, "inviteDate");
            return (Criteria) this;
        }

        public Criteria andInviteDateIn(List<Date> values) {
            addCriterion("invite_date in", values, "inviteDate");
            return (Criteria) this;
        }

        public Criteria andInviteDateNotIn(List<Date> values) {
            addCriterion("invite_date not in", values, "inviteDate");
            return (Criteria) this;
        }

        public Criteria andInviteDateBetween(Date value1, Date value2) {
            addCriterion("invite_date between", value1, value2, "inviteDate");
            return (Criteria) this;
        }

        public Criteria andInviteDateNotBetween(Date value1, Date value2) {
            addCriterion("invite_date not between", value1, value2, "inviteDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateIsNull() {
            addCriterion("join_date is null");
            return (Criteria) this;
        }

        public Criteria andJoinDateIsNotNull() {
            addCriterion("join_date is not null");
            return (Criteria) this;
        }

        public Criteria andJoinDateEqualTo(Date value) {
            addCriterion("join_date =", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateNotEqualTo(Date value) {
            addCriterion("join_date <>", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateGreaterThan(Date value) {
            addCriterion("join_date >", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateGreaterThanOrEqualTo(Date value) {
            addCriterion("join_date >=", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateLessThan(Date value) {
            addCriterion("join_date <", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateLessThanOrEqualTo(Date value) {
            addCriterion("join_date <=", value, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateIn(List<Date> values) {
            addCriterion("join_date in", values, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateNotIn(List<Date> values) {
            addCriterion("join_date not in", values, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateBetween(Date value1, Date value2) {
            addCriterion("join_date between", value1, value2, "joinDate");
            return (Criteria) this;
        }

        public Criteria andJoinDateNotBetween(Date value1, Date value2) {
            addCriterion("join_date not between", value1, value2, "joinDate");
            return (Criteria) this;
        }

        public Criteria andExitDateIsNull() {
            addCriterion("exit_date is null");
            return (Criteria) this;
        }

        public Criteria andExitDateIsNotNull() {
            addCriterion("exit_date is not null");
            return (Criteria) this;
        }

        public Criteria andExitDateEqualTo(Date value) {
            addCriterion("exit_date =", value, "exitDate");
            return (Criteria) this;
        }

        public Criteria andExitDateNotEqualTo(Date value) {
            addCriterion("exit_date <>", value, "exitDate");
            return (Criteria) this;
        }

        public Criteria andExitDateGreaterThan(Date value) {
            addCriterion("exit_date >", value, "exitDate");
            return (Criteria) this;
        }

        public Criteria andExitDateGreaterThanOrEqualTo(Date value) {
            addCriterion("exit_date >=", value, "exitDate");
            return (Criteria) this;
        }

        public Criteria andExitDateLessThan(Date value) {
            addCriterion("exit_date <", value, "exitDate");
            return (Criteria) this;
        }

        public Criteria andExitDateLessThanOrEqualTo(Date value) {
            addCriterion("exit_date <=", value, "exitDate");
            return (Criteria) this;
        }

        public Criteria andExitDateIn(List<Date> values) {
            addCriterion("exit_date in", values, "exitDate");
            return (Criteria) this;
        }

        public Criteria andExitDateNotIn(List<Date> values) {
            addCriterion("exit_date not in", values, "exitDate");
            return (Criteria) this;
        }

        public Criteria andExitDateBetween(Date value1, Date value2) {
            addCriterion("exit_date between", value1, value2, "exitDate");
            return (Criteria) this;
        }

        public Criteria andExitDateNotBetween(Date value1, Date value2) {
            addCriterion("exit_date not between", value1, value2, "exitDate");
            return (Criteria) this;
        }

        public Criteria andIsAuditIsNull() {
            addCriterion("is_audit is null");
            return (Criteria) this;
        }

        public Criteria andIsAuditIsNotNull() {
            addCriterion("is_audit is not null");
            return (Criteria) this;
        }

        public Criteria andIsAuditEqualTo(Integer value) {
            addCriterion("is_audit =", value, "isAudit");
            return (Criteria) this;
        }

        public Criteria andIsAuditNotEqualTo(Integer value) {
            addCriterion("is_audit <>", value, "isAudit");
            return (Criteria) this;
        }

        public Criteria andIsAuditGreaterThan(Integer value) {
            addCriterion("is_audit >", value, "isAudit");
            return (Criteria) this;
        }

        public Criteria andIsAuditGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_audit >=", value, "isAudit");
            return (Criteria) this;
        }

        public Criteria andIsAuditLessThan(Integer value) {
            addCriterion("is_audit <", value, "isAudit");
            return (Criteria) this;
        }

        public Criteria andIsAuditLessThanOrEqualTo(Integer value) {
            addCriterion("is_audit <=", value, "isAudit");
            return (Criteria) this;
        }

        public Criteria andIsAuditIn(List<Integer> values) {
            addCriterion("is_audit in", values, "isAudit");
            return (Criteria) this;
        }

        public Criteria andIsAuditNotIn(List<Integer> values) {
            addCriterion("is_audit not in", values, "isAudit");
            return (Criteria) this;
        }

        public Criteria andIsAuditBetween(Integer value1, Integer value2) {
            addCriterion("is_audit between", value1, value2, "isAudit");
            return (Criteria) this;
        }

        public Criteria andIsAuditNotBetween(Integer value1, Integer value2) {
            addCriterion("is_audit not between", value1, value2, "isAudit");
            return (Criteria) this;
        }

        public Criteria andJoinStatusIsNull() {
            addCriterion("join_status is null");
            return (Criteria) this;
        }

        public Criteria andJoinStatusIsNotNull() {
            addCriterion("join_status is not null");
            return (Criteria) this;
        }

        public Criteria andJoinStatusEqualTo(String value) {
            addCriterion("join_status =", value, "joinStatus");
            return (Criteria) this;
        }

        public Criteria andJoinStatusNotEqualTo(String value) {
            addCriterion("join_status <>", value, "joinStatus");
            return (Criteria) this;
        }

        public Criteria andJoinStatusGreaterThan(String value) {
            addCriterion("join_status >", value, "joinStatus");
            return (Criteria) this;
        }

        public Criteria andJoinStatusGreaterThanOrEqualTo(String value) {
            addCriterion("join_status >=", value, "joinStatus");
            return (Criteria) this;
        }

        public Criteria andJoinStatusLessThan(String value) {
            addCriterion("join_status <", value, "joinStatus");
            return (Criteria) this;
        }

        public Criteria andJoinStatusLessThanOrEqualTo(String value) {
            addCriterion("join_status <=", value, "joinStatus");
            return (Criteria) this;
        }

        public Criteria andJoinStatusLike(String value) {
            addCriterion("join_status like", value, "joinStatus");
            return (Criteria) this;
        }

        public Criteria andJoinStatusNotLike(String value) {
            addCriterion("join_status not like", value, "joinStatus");
            return (Criteria) this;
        }

        public Criteria andJoinStatusIn(List<String> values) {
            addCriterion("join_status in", values, "joinStatus");
            return (Criteria) this;
        }

        public Criteria andJoinStatusNotIn(List<String> values) {
            addCriterion("join_status not in", values, "joinStatus");
            return (Criteria) this;
        }

        public Criteria andJoinStatusBetween(String value1, String value2) {
            addCriterion("join_status between", value1, value2, "joinStatus");
            return (Criteria) this;
        }

        public Criteria andJoinStatusNotBetween(String value1, String value2) {
            addCriterion("join_status not between", value1, value2, "joinStatus");
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