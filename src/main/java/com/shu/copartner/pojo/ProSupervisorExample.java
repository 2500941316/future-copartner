package com.shu.copartner.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProSupervisorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProSupervisorExample() {
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

        public Criteria andSupervisorIdIsNull() {
            addCriterion("supervisor_id is null");
            return (Criteria) this;
        }

        public Criteria andSupervisorIdIsNotNull() {
            addCriterion("supervisor_id is not null");
            return (Criteria) this;
        }

        public Criteria andSupervisorIdEqualTo(Long value) {
            addCriterion("supervisor_id =", value, "supervisorId");
            return (Criteria) this;
        }

        public Criteria andSupervisorIdNotEqualTo(Long value) {
            addCriterion("supervisor_id <>", value, "supervisorId");
            return (Criteria) this;
        }

        public Criteria andSupervisorIdGreaterThan(Long value) {
            addCriterion("supervisor_id >", value, "supervisorId");
            return (Criteria) this;
        }

        public Criteria andSupervisorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("supervisor_id >=", value, "supervisorId");
            return (Criteria) this;
        }

        public Criteria andSupervisorIdLessThan(Long value) {
            addCriterion("supervisor_id <", value, "supervisorId");
            return (Criteria) this;
        }

        public Criteria andSupervisorIdLessThanOrEqualTo(Long value) {
            addCriterion("supervisor_id <=", value, "supervisorId");
            return (Criteria) this;
        }

        public Criteria andSupervisorIdIn(List<Long> values) {
            addCriterion("supervisor_id in", values, "supervisorId");
            return (Criteria) this;
        }

        public Criteria andSupervisorIdNotIn(List<Long> values) {
            addCriterion("supervisor_id not in", values, "supervisorId");
            return (Criteria) this;
        }

        public Criteria andSupervisorIdBetween(Long value1, Long value2) {
            addCriterion("supervisor_id between", value1, value2, "supervisorId");
            return (Criteria) this;
        }

        public Criteria andSupervisorIdNotBetween(Long value1, Long value2) {
            addCriterion("supervisor_id not between", value1, value2, "supervisorId");
            return (Criteria) this;
        }

        public Criteria andSupervisorNameIsNull() {
            addCriterion("supervisor_name is null");
            return (Criteria) this;
        }

        public Criteria andSupervisorNameIsNotNull() {
            addCriterion("supervisor_name is not null");
            return (Criteria) this;
        }

        public Criteria andSupervisorNameEqualTo(String value) {
            addCriterion("supervisor_name =", value, "supervisorName");
            return (Criteria) this;
        }

        public Criteria andSupervisorNameNotEqualTo(String value) {
            addCriterion("supervisor_name <>", value, "supervisorName");
            return (Criteria) this;
        }

        public Criteria andSupervisorNameGreaterThan(String value) {
            addCriterion("supervisor_name >", value, "supervisorName");
            return (Criteria) this;
        }

        public Criteria andSupervisorNameGreaterThanOrEqualTo(String value) {
            addCriterion("supervisor_name >=", value, "supervisorName");
            return (Criteria) this;
        }

        public Criteria andSupervisorNameLessThan(String value) {
            addCriterion("supervisor_name <", value, "supervisorName");
            return (Criteria) this;
        }

        public Criteria andSupervisorNameLessThanOrEqualTo(String value) {
            addCriterion("supervisor_name <=", value, "supervisorName");
            return (Criteria) this;
        }

        public Criteria andSupervisorNameLike(String value) {
            addCriterion("supervisor_name like", value, "supervisorName");
            return (Criteria) this;
        }

        public Criteria andSupervisorNameNotLike(String value) {
            addCriterion("supervisor_name not like", value, "supervisorName");
            return (Criteria) this;
        }

        public Criteria andSupervisorNameIn(List<String> values) {
            addCriterion("supervisor_name in", values, "supervisorName");
            return (Criteria) this;
        }

        public Criteria andSupervisorNameNotIn(List<String> values) {
            addCriterion("supervisor_name not in", values, "supervisorName");
            return (Criteria) this;
        }

        public Criteria andSupervisorNameBetween(String value1, String value2) {
            addCriterion("supervisor_name between", value1, value2, "supervisorName");
            return (Criteria) this;
        }

        public Criteria andSupervisorNameNotBetween(String value1, String value2) {
            addCriterion("supervisor_name not between", value1, value2, "supervisorName");
            return (Criteria) this;
        }

        public Criteria andSupervisorStatusIsNull() {
            addCriterion("supervisor_status is null");
            return (Criteria) this;
        }

        public Criteria andSupervisorStatusIsNotNull() {
            addCriterion("supervisor_status is not null");
            return (Criteria) this;
        }

        public Criteria andSupervisorStatusEqualTo(String value) {
            addCriterion("supervisor_status =", value, "supervisorStatus");
            return (Criteria) this;
        }

        public Criteria andSupervisorStatusNotEqualTo(String value) {
            addCriterion("supervisor_status <>", value, "supervisorStatus");
            return (Criteria) this;
        }

        public Criteria andSupervisorStatusGreaterThan(String value) {
            addCriterion("supervisor_status >", value, "supervisorStatus");
            return (Criteria) this;
        }

        public Criteria andSupervisorStatusGreaterThanOrEqualTo(String value) {
            addCriterion("supervisor_status >=", value, "supervisorStatus");
            return (Criteria) this;
        }

        public Criteria andSupervisorStatusLessThan(String value) {
            addCriterion("supervisor_status <", value, "supervisorStatus");
            return (Criteria) this;
        }

        public Criteria andSupervisorStatusLessThanOrEqualTo(String value) {
            addCriterion("supervisor_status <=", value, "supervisorStatus");
            return (Criteria) this;
        }

        public Criteria andSupervisorStatusLike(String value) {
            addCriterion("supervisor_status like", value, "supervisorStatus");
            return (Criteria) this;
        }

        public Criteria andSupervisorStatusNotLike(String value) {
            addCriterion("supervisor_status not like", value, "supervisorStatus");
            return (Criteria) this;
        }

        public Criteria andSupervisorStatusIn(List<String> values) {
            addCriterion("supervisor_status in", values, "supervisorStatus");
            return (Criteria) this;
        }

        public Criteria andSupervisorStatusNotIn(List<String> values) {
            addCriterion("supervisor_status not in", values, "supervisorStatus");
            return (Criteria) this;
        }

        public Criteria andSupervisorStatusBetween(String value1, String value2) {
            addCriterion("supervisor_status between", value1, value2, "supervisorStatus");
            return (Criteria) this;
        }

        public Criteria andSupervisorStatusNotBetween(String value1, String value2) {
            addCriterion("supervisor_status not between", value1, value2, "supervisorStatus");
            return (Criteria) this;
        }

        public Criteria andSupervisorInstituteIsNull() {
            addCriterion("supervisor_institute is null");
            return (Criteria) this;
        }

        public Criteria andSupervisorInstituteIsNotNull() {
            addCriterion("supervisor_institute is not null");
            return (Criteria) this;
        }

        public Criteria andSupervisorInstituteEqualTo(String value) {
            addCriterion("supervisor_institute =", value, "supervisorInstitute");
            return (Criteria) this;
        }

        public Criteria andSupervisorInstituteNotEqualTo(String value) {
            addCriterion("supervisor_institute <>", value, "supervisorInstitute");
            return (Criteria) this;
        }

        public Criteria andSupervisorInstituteGreaterThan(String value) {
            addCriterion("supervisor_institute >", value, "supervisorInstitute");
            return (Criteria) this;
        }

        public Criteria andSupervisorInstituteGreaterThanOrEqualTo(String value) {
            addCriterion("supervisor_institute >=", value, "supervisorInstitute");
            return (Criteria) this;
        }

        public Criteria andSupervisorInstituteLessThan(String value) {
            addCriterion("supervisor_institute <", value, "supervisorInstitute");
            return (Criteria) this;
        }

        public Criteria andSupervisorInstituteLessThanOrEqualTo(String value) {
            addCriterion("supervisor_institute <=", value, "supervisorInstitute");
            return (Criteria) this;
        }

        public Criteria andSupervisorInstituteLike(String value) {
            addCriterion("supervisor_institute like", value, "supervisorInstitute");
            return (Criteria) this;
        }

        public Criteria andSupervisorInstituteNotLike(String value) {
            addCriterion("supervisor_institute not like", value, "supervisorInstitute");
            return (Criteria) this;
        }

        public Criteria andSupervisorInstituteIn(List<String> values) {
            addCriterion("supervisor_institute in", values, "supervisorInstitute");
            return (Criteria) this;
        }

        public Criteria andSupervisorInstituteNotIn(List<String> values) {
            addCriterion("supervisor_institute not in", values, "supervisorInstitute");
            return (Criteria) this;
        }

        public Criteria andSupervisorInstituteBetween(String value1, String value2) {
            addCriterion("supervisor_institute between", value1, value2, "supervisorInstitute");
            return (Criteria) this;
        }

        public Criteria andSupervisorInstituteNotBetween(String value1, String value2) {
            addCriterion("supervisor_institute not between", value1, value2, "supervisorInstitute");
            return (Criteria) this;
        }

        public Criteria andSupervisorImageIsNull() {
            addCriterion("supervisor_image is null");
            return (Criteria) this;
        }

        public Criteria andSupervisorImageIsNotNull() {
            addCriterion("supervisor_image is not null");
            return (Criteria) this;
        }

        public Criteria andSupervisorImageEqualTo(String value) {
            addCriterion("supervisor_image =", value, "supervisorImage");
            return (Criteria) this;
        }

        public Criteria andSupervisorImageNotEqualTo(String value) {
            addCriterion("supervisor_image <>", value, "supervisorImage");
            return (Criteria) this;
        }

        public Criteria andSupervisorImageGreaterThan(String value) {
            addCriterion("supervisor_image >", value, "supervisorImage");
            return (Criteria) this;
        }

        public Criteria andSupervisorImageGreaterThanOrEqualTo(String value) {
            addCriterion("supervisor_image >=", value, "supervisorImage");
            return (Criteria) this;
        }

        public Criteria andSupervisorImageLessThan(String value) {
            addCriterion("supervisor_image <", value, "supervisorImage");
            return (Criteria) this;
        }

        public Criteria andSupervisorImageLessThanOrEqualTo(String value) {
            addCriterion("supervisor_image <=", value, "supervisorImage");
            return (Criteria) this;
        }

        public Criteria andSupervisorImageLike(String value) {
            addCriterion("supervisor_image like", value, "supervisorImage");
            return (Criteria) this;
        }

        public Criteria andSupervisorImageNotLike(String value) {
            addCriterion("supervisor_image not like", value, "supervisorImage");
            return (Criteria) this;
        }

        public Criteria andSupervisorImageIn(List<String> values) {
            addCriterion("supervisor_image in", values, "supervisorImage");
            return (Criteria) this;
        }

        public Criteria andSupervisorImageNotIn(List<String> values) {
            addCriterion("supervisor_image not in", values, "supervisorImage");
            return (Criteria) this;
        }

        public Criteria andSupervisorImageBetween(String value1, String value2) {
            addCriterion("supervisor_image between", value1, value2, "supervisorImage");
            return (Criteria) this;
        }

        public Criteria andSupervisorImageNotBetween(String value1, String value2) {
            addCriterion("supervisor_image not between", value1, value2, "supervisorImage");
            return (Criteria) this;
        }

        public Criteria andSupervisorDescriptionIsNull() {
            addCriterion("supervisor_description is null");
            return (Criteria) this;
        }

        public Criteria andSupervisorDescriptionIsNotNull() {
            addCriterion("supervisor_description is not null");
            return (Criteria) this;
        }

        public Criteria andSupervisorDescriptionEqualTo(String value) {
            addCriterion("supervisor_description =", value, "supervisorDescription");
            return (Criteria) this;
        }

        public Criteria andSupervisorDescriptionNotEqualTo(String value) {
            addCriterion("supervisor_description <>", value, "supervisorDescription");
            return (Criteria) this;
        }

        public Criteria andSupervisorDescriptionGreaterThan(String value) {
            addCriterion("supervisor_description >", value, "supervisorDescription");
            return (Criteria) this;
        }

        public Criteria andSupervisorDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("supervisor_description >=", value, "supervisorDescription");
            return (Criteria) this;
        }

        public Criteria andSupervisorDescriptionLessThan(String value) {
            addCriterion("supervisor_description <", value, "supervisorDescription");
            return (Criteria) this;
        }

        public Criteria andSupervisorDescriptionLessThanOrEqualTo(String value) {
            addCriterion("supervisor_description <=", value, "supervisorDescription");
            return (Criteria) this;
        }

        public Criteria andSupervisorDescriptionLike(String value) {
            addCriterion("supervisor_description like", value, "supervisorDescription");
            return (Criteria) this;
        }

        public Criteria andSupervisorDescriptionNotLike(String value) {
            addCriterion("supervisor_description not like", value, "supervisorDescription");
            return (Criteria) this;
        }

        public Criteria andSupervisorDescriptionIn(List<String> values) {
            addCriterion("supervisor_description in", values, "supervisorDescription");
            return (Criteria) this;
        }

        public Criteria andSupervisorDescriptionNotIn(List<String> values) {
            addCriterion("supervisor_description not in", values, "supervisorDescription");
            return (Criteria) this;
        }

        public Criteria andSupervisorDescriptionBetween(String value1, String value2) {
            addCriterion("supervisor_description between", value1, value2, "supervisorDescription");
            return (Criteria) this;
        }

        public Criteria andSupervisorDescriptionNotBetween(String value1, String value2) {
            addCriterion("supervisor_description not between", value1, value2, "supervisorDescription");
            return (Criteria) this;
        }

        public Criteria andSupervisorEmailIsNull() {
            addCriterion("supervisor_email is null");
            return (Criteria) this;
        }

        public Criteria andSupervisorEmailIsNotNull() {
            addCriterion("supervisor_email is not null");
            return (Criteria) this;
        }

        public Criteria andSupervisorEmailEqualTo(String value) {
            addCriterion("supervisor_email =", value, "supervisorEmail");
            return (Criteria) this;
        }

        public Criteria andSupervisorEmailNotEqualTo(String value) {
            addCriterion("supervisor_email <>", value, "supervisorEmail");
            return (Criteria) this;
        }

        public Criteria andSupervisorEmailGreaterThan(String value) {
            addCriterion("supervisor_email >", value, "supervisorEmail");
            return (Criteria) this;
        }

        public Criteria andSupervisorEmailGreaterThanOrEqualTo(String value) {
            addCriterion("supervisor_email >=", value, "supervisorEmail");
            return (Criteria) this;
        }

        public Criteria andSupervisorEmailLessThan(String value) {
            addCriterion("supervisor_email <", value, "supervisorEmail");
            return (Criteria) this;
        }

        public Criteria andSupervisorEmailLessThanOrEqualTo(String value) {
            addCriterion("supervisor_email <=", value, "supervisorEmail");
            return (Criteria) this;
        }

        public Criteria andSupervisorEmailLike(String value) {
            addCriterion("supervisor_email like", value, "supervisorEmail");
            return (Criteria) this;
        }

        public Criteria andSupervisorEmailNotLike(String value) {
            addCriterion("supervisor_email not like", value, "supervisorEmail");
            return (Criteria) this;
        }

        public Criteria andSupervisorEmailIn(List<String> values) {
            addCriterion("supervisor_email in", values, "supervisorEmail");
            return (Criteria) this;
        }

        public Criteria andSupervisorEmailNotIn(List<String> values) {
            addCriterion("supervisor_email not in", values, "supervisorEmail");
            return (Criteria) this;
        }

        public Criteria andSupervisorEmailBetween(String value1, String value2) {
            addCriterion("supervisor_email between", value1, value2, "supervisorEmail");
            return (Criteria) this;
        }

        public Criteria andSupervisorEmailNotBetween(String value1, String value2) {
            addCriterion("supervisor_email not between", value1, value2, "supervisorEmail");
            return (Criteria) this;
        }

        public Criteria andSupervisorTelephoneIsNull() {
            addCriterion("supervisor_telephone is null");
            return (Criteria) this;
        }

        public Criteria andSupervisorTelephoneIsNotNull() {
            addCriterion("supervisor_telephone is not null");
            return (Criteria) this;
        }

        public Criteria andSupervisorTelephoneEqualTo(String value) {
            addCriterion("supervisor_telephone =", value, "supervisorTelephone");
            return (Criteria) this;
        }

        public Criteria andSupervisorTelephoneNotEqualTo(String value) {
            addCriterion("supervisor_telephone <>", value, "supervisorTelephone");
            return (Criteria) this;
        }

        public Criteria andSupervisorTelephoneGreaterThan(String value) {
            addCriterion("supervisor_telephone >", value, "supervisorTelephone");
            return (Criteria) this;
        }

        public Criteria andSupervisorTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("supervisor_telephone >=", value, "supervisorTelephone");
            return (Criteria) this;
        }

        public Criteria andSupervisorTelephoneLessThan(String value) {
            addCriterion("supervisor_telephone <", value, "supervisorTelephone");
            return (Criteria) this;
        }

        public Criteria andSupervisorTelephoneLessThanOrEqualTo(String value) {
            addCriterion("supervisor_telephone <=", value, "supervisorTelephone");
            return (Criteria) this;
        }

        public Criteria andSupervisorTelephoneLike(String value) {
            addCriterion("supervisor_telephone like", value, "supervisorTelephone");
            return (Criteria) this;
        }

        public Criteria andSupervisorTelephoneNotLike(String value) {
            addCriterion("supervisor_telephone not like", value, "supervisorTelephone");
            return (Criteria) this;
        }

        public Criteria andSupervisorTelephoneIn(List<String> values) {
            addCriterion("supervisor_telephone in", values, "supervisorTelephone");
            return (Criteria) this;
        }

        public Criteria andSupervisorTelephoneNotIn(List<String> values) {
            addCriterion("supervisor_telephone not in", values, "supervisorTelephone");
            return (Criteria) this;
        }

        public Criteria andSupervisorTelephoneBetween(String value1, String value2) {
            addCriterion("supervisor_telephone between", value1, value2, "supervisorTelephone");
            return (Criteria) this;
        }

        public Criteria andSupervisorTelephoneNotBetween(String value1, String value2) {
            addCriterion("supervisor_telephone not between", value1, value2, "supervisorTelephone");
            return (Criteria) this;
        }

        public Criteria andSupervisorSchoolIsNull() {
            addCriterion("supervisor_school is null");
            return (Criteria) this;
        }

        public Criteria andSupervisorSchoolIsNotNull() {
            addCriterion("supervisor_school is not null");
            return (Criteria) this;
        }

        public Criteria andSupervisorSchoolEqualTo(String value) {
            addCriterion("supervisor_school =", value, "supervisorSchool");
            return (Criteria) this;
        }

        public Criteria andSupervisorSchoolNotEqualTo(String value) {
            addCriterion("supervisor_school <>", value, "supervisorSchool");
            return (Criteria) this;
        }

        public Criteria andSupervisorSchoolGreaterThan(String value) {
            addCriterion("supervisor_school >", value, "supervisorSchool");
            return (Criteria) this;
        }

        public Criteria andSupervisorSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("supervisor_school >=", value, "supervisorSchool");
            return (Criteria) this;
        }

        public Criteria andSupervisorSchoolLessThan(String value) {
            addCriterion("supervisor_school <", value, "supervisorSchool");
            return (Criteria) this;
        }

        public Criteria andSupervisorSchoolLessThanOrEqualTo(String value) {
            addCriterion("supervisor_school <=", value, "supervisorSchool");
            return (Criteria) this;
        }

        public Criteria andSupervisorSchoolLike(String value) {
            addCriterion("supervisor_school like", value, "supervisorSchool");
            return (Criteria) this;
        }

        public Criteria andSupervisorSchoolNotLike(String value) {
            addCriterion("supervisor_school not like", value, "supervisorSchool");
            return (Criteria) this;
        }

        public Criteria andSupervisorSchoolIn(List<String> values) {
            addCriterion("supervisor_school in", values, "supervisorSchool");
            return (Criteria) this;
        }

        public Criteria andSupervisorSchoolNotIn(List<String> values) {
            addCriterion("supervisor_school not in", values, "supervisorSchool");
            return (Criteria) this;
        }

        public Criteria andSupervisorSchoolBetween(String value1, String value2) {
            addCriterion("supervisor_school between", value1, value2, "supervisorSchool");
            return (Criteria) this;
        }

        public Criteria andSupervisorSchoolNotBetween(String value1, String value2) {
            addCriterion("supervisor_school not between", value1, value2, "supervisorSchool");
            return (Criteria) this;
        }

        public Criteria andSupervisorBriefIntroIsNull() {
            addCriterion("supervisor_brief_intro is null");
            return (Criteria) this;
        }

        public Criteria andSupervisorBriefIntroIsNotNull() {
            addCriterion("supervisor_brief_intro is not null");
            return (Criteria) this;
        }

        public Criteria andSupervisorBriefIntroEqualTo(String value) {
            addCriterion("supervisor_brief_intro =", value, "supervisorBriefIntro");
            return (Criteria) this;
        }

        public Criteria andSupervisorBriefIntroNotEqualTo(String value) {
            addCriterion("supervisor_brief_intro <>", value, "supervisorBriefIntro");
            return (Criteria) this;
        }

        public Criteria andSupervisorBriefIntroGreaterThan(String value) {
            addCriterion("supervisor_brief_intro >", value, "supervisorBriefIntro");
            return (Criteria) this;
        }

        public Criteria andSupervisorBriefIntroGreaterThanOrEqualTo(String value) {
            addCriterion("supervisor_brief_intro >=", value, "supervisorBriefIntro");
            return (Criteria) this;
        }

        public Criteria andSupervisorBriefIntroLessThan(String value) {
            addCriterion("supervisor_brief_intro <", value, "supervisorBriefIntro");
            return (Criteria) this;
        }

        public Criteria andSupervisorBriefIntroLessThanOrEqualTo(String value) {
            addCriterion("supervisor_brief_intro <=", value, "supervisorBriefIntro");
            return (Criteria) this;
        }

        public Criteria andSupervisorBriefIntroLike(String value) {
            addCriterion("supervisor_brief_intro like", value, "supervisorBriefIntro");
            return (Criteria) this;
        }

        public Criteria andSupervisorBriefIntroNotLike(String value) {
            addCriterion("supervisor_brief_intro not like", value, "supervisorBriefIntro");
            return (Criteria) this;
        }

        public Criteria andSupervisorBriefIntroIn(List<String> values) {
            addCriterion("supervisor_brief_intro in", values, "supervisorBriefIntro");
            return (Criteria) this;
        }

        public Criteria andSupervisorBriefIntroNotIn(List<String> values) {
            addCriterion("supervisor_brief_intro not in", values, "supervisorBriefIntro");
            return (Criteria) this;
        }

        public Criteria andSupervisorBriefIntroBetween(String value1, String value2) {
            addCriterion("supervisor_brief_intro between", value1, value2, "supervisorBriefIntro");
            return (Criteria) this;
        }

        public Criteria andSupervisorBriefIntroNotBetween(String value1, String value2) {
            addCriterion("supervisor_brief_intro not between", value1, value2, "supervisorBriefIntro");
            return (Criteria) this;
        }

        public Criteria andSupervisorAchievementIsNull() {
            addCriterion("supervisor_achievement is null");
            return (Criteria) this;
        }

        public Criteria andSupervisorAchievementIsNotNull() {
            addCriterion("supervisor_achievement is not null");
            return (Criteria) this;
        }

        public Criteria andSupervisorAchievementEqualTo(String value) {
            addCriterion("supervisor_achievement =", value, "supervisorAchievement");
            return (Criteria) this;
        }

        public Criteria andSupervisorAchievementNotEqualTo(String value) {
            addCriterion("supervisor_achievement <>", value, "supervisorAchievement");
            return (Criteria) this;
        }

        public Criteria andSupervisorAchievementGreaterThan(String value) {
            addCriterion("supervisor_achievement >", value, "supervisorAchievement");
            return (Criteria) this;
        }

        public Criteria andSupervisorAchievementGreaterThanOrEqualTo(String value) {
            addCriterion("supervisor_achievement >=", value, "supervisorAchievement");
            return (Criteria) this;
        }

        public Criteria andSupervisorAchievementLessThan(String value) {
            addCriterion("supervisor_achievement <", value, "supervisorAchievement");
            return (Criteria) this;
        }

        public Criteria andSupervisorAchievementLessThanOrEqualTo(String value) {
            addCriterion("supervisor_achievement <=", value, "supervisorAchievement");
            return (Criteria) this;
        }

        public Criteria andSupervisorAchievementLike(String value) {
            addCriterion("supervisor_achievement like", value, "supervisorAchievement");
            return (Criteria) this;
        }

        public Criteria andSupervisorAchievementNotLike(String value) {
            addCriterion("supervisor_achievement not like", value, "supervisorAchievement");
            return (Criteria) this;
        }

        public Criteria andSupervisorAchievementIn(List<String> values) {
            addCriterion("supervisor_achievement in", values, "supervisorAchievement");
            return (Criteria) this;
        }

        public Criteria andSupervisorAchievementNotIn(List<String> values) {
            addCriterion("supervisor_achievement not in", values, "supervisorAchievement");
            return (Criteria) this;
        }

        public Criteria andSupervisorAchievementBetween(String value1, String value2) {
            addCriterion("supervisor_achievement between", value1, value2, "supervisorAchievement");
            return (Criteria) this;
        }

        public Criteria andSupervisorAchievementNotBetween(String value1, String value2) {
            addCriterion("supervisor_achievement not between", value1, value2, "supervisorAchievement");
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

        public Criteria andProjectIdEqualTo(Integer value) {
            addCriterion("project_id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(Integer value) {
            addCriterion("project_id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(Integer value) {
            addCriterion("project_id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("project_id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(Integer value) {
            addCriterion("project_id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(Integer value) {
            addCriterion("project_id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<Integer> values) {
            addCriterion("project_id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<Integer> values) {
            addCriterion("project_id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(Integer value1, Integer value2) {
            addCriterion("project_id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("project_id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andLogIdIsNull() {
            addCriterion("log_id is null");
            return (Criteria) this;
        }

        public Criteria andLogIdIsNotNull() {
            addCriterion("log_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogIdEqualTo(Integer value) {
            addCriterion("log_id =", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotEqualTo(Integer value) {
            addCriterion("log_id <>", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThan(Integer value) {
            addCriterion("log_id >", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("log_id >=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThan(Integer value) {
            addCriterion("log_id <", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThanOrEqualTo(Integer value) {
            addCriterion("log_id <=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdIn(List<Integer> values) {
            addCriterion("log_id in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotIn(List<Integer> values) {
            addCriterion("log_id not in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdBetween(Integer value1, Integer value2) {
            addCriterion("log_id between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotBetween(Integer value1, Integer value2) {
            addCriterion("log_id not between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andSupervisorRankIsNull() {
            addCriterion("supervisor_rank is null");
            return (Criteria) this;
        }

        public Criteria andSupervisorRankIsNotNull() {
            addCriterion("supervisor_rank is not null");
            return (Criteria) this;
        }

        public Criteria andSupervisorRankEqualTo(Integer value) {
            addCriterion("supervisor_rank =", value, "supervisorRank");
            return (Criteria) this;
        }

        public Criteria andSupervisorRankNotEqualTo(Integer value) {
            addCriterion("supervisor_rank <>", value, "supervisorRank");
            return (Criteria) this;
        }

        public Criteria andSupervisorRankGreaterThan(Integer value) {
            addCriterion("supervisor_rank >", value, "supervisorRank");
            return (Criteria) this;
        }

        public Criteria andSupervisorRankGreaterThanOrEqualTo(Integer value) {
            addCriterion("supervisor_rank >=", value, "supervisorRank");
            return (Criteria) this;
        }

        public Criteria andSupervisorRankLessThan(Integer value) {
            addCriterion("supervisor_rank <", value, "supervisorRank");
            return (Criteria) this;
        }

        public Criteria andSupervisorRankLessThanOrEqualTo(Integer value) {
            addCriterion("supervisor_rank <=", value, "supervisorRank");
            return (Criteria) this;
        }

        public Criteria andSupervisorRankIn(List<Integer> values) {
            addCriterion("supervisor_rank in", values, "supervisorRank");
            return (Criteria) this;
        }

        public Criteria andSupervisorRankNotIn(List<Integer> values) {
            addCriterion("supervisor_rank not in", values, "supervisorRank");
            return (Criteria) this;
        }

        public Criteria andSupervisorRankBetween(Integer value1, Integer value2) {
            addCriterion("supervisor_rank between", value1, value2, "supervisorRank");
            return (Criteria) this;
        }

        public Criteria andSupervisorRankNotBetween(Integer value1, Integer value2) {
            addCriterion("supervisor_rank not between", value1, value2, "supervisorRank");
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