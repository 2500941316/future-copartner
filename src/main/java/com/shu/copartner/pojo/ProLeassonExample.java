package com.shu.copartner.pojo;

import java.util.ArrayList;
import java.util.List;

public class ProLeassonExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProLeassonExample() {
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

        public Criteria andCourseIdIsNull() {
            addCriterion("course_id is null");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNotNull() {
            addCriterion("course_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourseIdEqualTo(Long value) {
            addCriterion("course_id =", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotEqualTo(Long value) {
            addCriterion("course_id <>", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThan(Long value) {
            addCriterion("course_id >", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThanOrEqualTo(Long value) {
            addCriterion("course_id >=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThan(Long value) {
            addCriterion("course_id <", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThanOrEqualTo(Long value) {
            addCriterion("course_id <=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIn(List<Long> values) {
            addCriterion("course_id in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotIn(List<Long> values) {
            addCriterion("course_id not in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdBetween(Long value1, Long value2) {
            addCriterion("course_id between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotBetween(Long value1, Long value2) {
            addCriterion("course_id not between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNull() {
            addCriterion("course_name is null");
            return (Criteria) this;
        }

        public Criteria andCourseNameIsNotNull() {
            addCriterion("course_name is not null");
            return (Criteria) this;
        }

        public Criteria andCourseNameEqualTo(String value) {
            addCriterion("course_name =", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotEqualTo(String value) {
            addCriterion("course_name <>", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThan(String value) {
            addCriterion("course_name >", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameGreaterThanOrEqualTo(String value) {
            addCriterion("course_name >=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThan(String value) {
            addCriterion("course_name <", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLessThanOrEqualTo(String value) {
            addCriterion("course_name <=", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameLike(String value) {
            addCriterion("course_name like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotLike(String value) {
            addCriterion("course_name not like", value, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameIn(List<String> values) {
            addCriterion("course_name in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotIn(List<String> values) {
            addCriterion("course_name not in", values, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameBetween(String value1, String value2) {
            addCriterion("course_name between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseNameNotBetween(String value1, String value2) {
            addCriterion("course_name not between", value1, value2, "courseName");
            return (Criteria) this;
        }

        public Criteria andCourseTypeIsNull() {
            addCriterion("course_type is null");
            return (Criteria) this;
        }

        public Criteria andCourseTypeIsNotNull() {
            addCriterion("course_type is not null");
            return (Criteria) this;
        }

        public Criteria andCourseTypeEqualTo(String value) {
            addCriterion("course_type =", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeNotEqualTo(String value) {
            addCriterion("course_type <>", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeGreaterThan(String value) {
            addCriterion("course_type >", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeGreaterThanOrEqualTo(String value) {
            addCriterion("course_type >=", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeLessThan(String value) {
            addCriterion("course_type <", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeLessThanOrEqualTo(String value) {
            addCriterion("course_type <=", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeLike(String value) {
            addCriterion("course_type like", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeNotLike(String value) {
            addCriterion("course_type not like", value, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeIn(List<String> values) {
            addCriterion("course_type in", values, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeNotIn(List<String> values) {
            addCriterion("course_type not in", values, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeBetween(String value1, String value2) {
            addCriterion("course_type between", value1, value2, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseTypeNotBetween(String value1, String value2) {
            addCriterion("course_type not between", value1, value2, "courseType");
            return (Criteria) this;
        }

        public Criteria andCourseStatusIsNull() {
            addCriterion("course_status is null");
            return (Criteria) this;
        }

        public Criteria andCourseStatusIsNotNull() {
            addCriterion("course_status is not null");
            return (Criteria) this;
        }

        public Criteria andCourseStatusEqualTo(String value) {
            addCriterion("course_status =", value, "courseStatus");
            return (Criteria) this;
        }

        public Criteria andCourseStatusNotEqualTo(String value) {
            addCriterion("course_status <>", value, "courseStatus");
            return (Criteria) this;
        }

        public Criteria andCourseStatusGreaterThan(String value) {
            addCriterion("course_status >", value, "courseStatus");
            return (Criteria) this;
        }

        public Criteria andCourseStatusGreaterThanOrEqualTo(String value) {
            addCriterion("course_status >=", value, "courseStatus");
            return (Criteria) this;
        }

        public Criteria andCourseStatusLessThan(String value) {
            addCriterion("course_status <", value, "courseStatus");
            return (Criteria) this;
        }

        public Criteria andCourseStatusLessThanOrEqualTo(String value) {
            addCriterion("course_status <=", value, "courseStatus");
            return (Criteria) this;
        }

        public Criteria andCourseStatusLike(String value) {
            addCriterion("course_status like", value, "courseStatus");
            return (Criteria) this;
        }

        public Criteria andCourseStatusNotLike(String value) {
            addCriterion("course_status not like", value, "courseStatus");
            return (Criteria) this;
        }

        public Criteria andCourseStatusIn(List<String> values) {
            addCriterion("course_status in", values, "courseStatus");
            return (Criteria) this;
        }

        public Criteria andCourseStatusNotIn(List<String> values) {
            addCriterion("course_status not in", values, "courseStatus");
            return (Criteria) this;
        }

        public Criteria andCourseStatusBetween(String value1, String value2) {
            addCriterion("course_status between", value1, value2, "courseStatus");
            return (Criteria) this;
        }

        public Criteria andCourseStatusNotBetween(String value1, String value2) {
            addCriterion("course_status not between", value1, value2, "courseStatus");
            return (Criteria) this;
        }

        public Criteria andCourseTeacherIsNull() {
            addCriterion("course_teacher is null");
            return (Criteria) this;
        }

        public Criteria andCourseTeacherIsNotNull() {
            addCriterion("course_teacher is not null");
            return (Criteria) this;
        }

        public Criteria andCourseTeacherEqualTo(String value) {
            addCriterion("course_teacher =", value, "courseTeacher");
            return (Criteria) this;
        }

        public Criteria andCourseTeacherNotEqualTo(String value) {
            addCriterion("course_teacher <>", value, "courseTeacher");
            return (Criteria) this;
        }

        public Criteria andCourseTeacherGreaterThan(String value) {
            addCriterion("course_teacher >", value, "courseTeacher");
            return (Criteria) this;
        }

        public Criteria andCourseTeacherGreaterThanOrEqualTo(String value) {
            addCriterion("course_teacher >=", value, "courseTeacher");
            return (Criteria) this;
        }

        public Criteria andCourseTeacherLessThan(String value) {
            addCriterion("course_teacher <", value, "courseTeacher");
            return (Criteria) this;
        }

        public Criteria andCourseTeacherLessThanOrEqualTo(String value) {
            addCriterion("course_teacher <=", value, "courseTeacher");
            return (Criteria) this;
        }

        public Criteria andCourseTeacherLike(String value) {
            addCriterion("course_teacher like", value, "courseTeacher");
            return (Criteria) this;
        }

        public Criteria andCourseTeacherNotLike(String value) {
            addCriterion("course_teacher not like", value, "courseTeacher");
            return (Criteria) this;
        }

        public Criteria andCourseTeacherIn(List<String> values) {
            addCriterion("course_teacher in", values, "courseTeacher");
            return (Criteria) this;
        }

        public Criteria andCourseTeacherNotIn(List<String> values) {
            addCriterion("course_teacher not in", values, "courseTeacher");
            return (Criteria) this;
        }

        public Criteria andCourseTeacherBetween(String value1, String value2) {
            addCriterion("course_teacher between", value1, value2, "courseTeacher");
            return (Criteria) this;
        }

        public Criteria andCourseTeacherNotBetween(String value1, String value2) {
            addCriterion("course_teacher not between", value1, value2, "courseTeacher");
            return (Criteria) this;
        }

        public Criteria andCourseTotaltimeIsNull() {
            addCriterion("course_totalTime is null");
            return (Criteria) this;
        }

        public Criteria andCourseTotaltimeIsNotNull() {
            addCriterion("course_totalTime is not null");
            return (Criteria) this;
        }

        public Criteria andCourseTotaltimeEqualTo(String value) {
            addCriterion("course_totalTime =", value, "courseTotaltime");
            return (Criteria) this;
        }

        public Criteria andCourseTotaltimeNotEqualTo(String value) {
            addCriterion("course_totalTime <>", value, "courseTotaltime");
            return (Criteria) this;
        }

        public Criteria andCourseTotaltimeGreaterThan(String value) {
            addCriterion("course_totalTime >", value, "courseTotaltime");
            return (Criteria) this;
        }

        public Criteria andCourseTotaltimeGreaterThanOrEqualTo(String value) {
            addCriterion("course_totalTime >=", value, "courseTotaltime");
            return (Criteria) this;
        }

        public Criteria andCourseTotaltimeLessThan(String value) {
            addCriterion("course_totalTime <", value, "courseTotaltime");
            return (Criteria) this;
        }

        public Criteria andCourseTotaltimeLessThanOrEqualTo(String value) {
            addCriterion("course_totalTime <=", value, "courseTotaltime");
            return (Criteria) this;
        }

        public Criteria andCourseTotaltimeLike(String value) {
            addCriterion("course_totalTime like", value, "courseTotaltime");
            return (Criteria) this;
        }

        public Criteria andCourseTotaltimeNotLike(String value) {
            addCriterion("course_totalTime not like", value, "courseTotaltime");
            return (Criteria) this;
        }

        public Criteria andCourseTotaltimeIn(List<String> values) {
            addCriterion("course_totalTime in", values, "courseTotaltime");
            return (Criteria) this;
        }

        public Criteria andCourseTotaltimeNotIn(List<String> values) {
            addCriterion("course_totalTime not in", values, "courseTotaltime");
            return (Criteria) this;
        }

        public Criteria andCourseTotaltimeBetween(String value1, String value2) {
            addCriterion("course_totalTime between", value1, value2, "courseTotaltime");
            return (Criteria) this;
        }

        public Criteria andCourseTotaltimeNotBetween(String value1, String value2) {
            addCriterion("course_totalTime not between", value1, value2, "courseTotaltime");
            return (Criteria) this;
        }

        public Criteria andCourseDescriptionIsNull() {
            addCriterion("course_description is null");
            return (Criteria) this;
        }

        public Criteria andCourseDescriptionIsNotNull() {
            addCriterion("course_description is not null");
            return (Criteria) this;
        }

        public Criteria andCourseDescriptionEqualTo(String value) {
            addCriterion("course_description =", value, "courseDescription");
            return (Criteria) this;
        }

        public Criteria andCourseDescriptionNotEqualTo(String value) {
            addCriterion("course_description <>", value, "courseDescription");
            return (Criteria) this;
        }

        public Criteria andCourseDescriptionGreaterThan(String value) {
            addCriterion("course_description >", value, "courseDescription");
            return (Criteria) this;
        }

        public Criteria andCourseDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("course_description >=", value, "courseDescription");
            return (Criteria) this;
        }

        public Criteria andCourseDescriptionLessThan(String value) {
            addCriterion("course_description <", value, "courseDescription");
            return (Criteria) this;
        }

        public Criteria andCourseDescriptionLessThanOrEqualTo(String value) {
            addCriterion("course_description <=", value, "courseDescription");
            return (Criteria) this;
        }

        public Criteria andCourseDescriptionLike(String value) {
            addCriterion("course_description like", value, "courseDescription");
            return (Criteria) this;
        }

        public Criteria andCourseDescriptionNotLike(String value) {
            addCriterion("course_description not like", value, "courseDescription");
            return (Criteria) this;
        }

        public Criteria andCourseDescriptionIn(List<String> values) {
            addCriterion("course_description in", values, "courseDescription");
            return (Criteria) this;
        }

        public Criteria andCourseDescriptionNotIn(List<String> values) {
            addCriterion("course_description not in", values, "courseDescription");
            return (Criteria) this;
        }

        public Criteria andCourseDescriptionBetween(String value1, String value2) {
            addCriterion("course_description between", value1, value2, "courseDescription");
            return (Criteria) this;
        }

        public Criteria andCourseDescriptionNotBetween(String value1, String value2) {
            addCriterion("course_description not between", value1, value2, "courseDescription");
            return (Criteria) this;
        }

        public Criteria andCourseTotalblocksIsNull() {
            addCriterion("course_totalBlocks is null");
            return (Criteria) this;
        }

        public Criteria andCourseTotalblocksIsNotNull() {
            addCriterion("course_totalBlocks is not null");
            return (Criteria) this;
        }

        public Criteria andCourseTotalblocksEqualTo(Integer value) {
            addCriterion("course_totalBlocks =", value, "courseTotalblocks");
            return (Criteria) this;
        }

        public Criteria andCourseTotalblocksNotEqualTo(Integer value) {
            addCriterion("course_totalBlocks <>", value, "courseTotalblocks");
            return (Criteria) this;
        }

        public Criteria andCourseTotalblocksGreaterThan(Integer value) {
            addCriterion("course_totalBlocks >", value, "courseTotalblocks");
            return (Criteria) this;
        }

        public Criteria andCourseTotalblocksGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_totalBlocks >=", value, "courseTotalblocks");
            return (Criteria) this;
        }

        public Criteria andCourseTotalblocksLessThan(Integer value) {
            addCriterion("course_totalBlocks <", value, "courseTotalblocks");
            return (Criteria) this;
        }

        public Criteria andCourseTotalblocksLessThanOrEqualTo(Integer value) {
            addCriterion("course_totalBlocks <=", value, "courseTotalblocks");
            return (Criteria) this;
        }

        public Criteria andCourseTotalblocksIn(List<Integer> values) {
            addCriterion("course_totalBlocks in", values, "courseTotalblocks");
            return (Criteria) this;
        }

        public Criteria andCourseTotalblocksNotIn(List<Integer> values) {
            addCriterion("course_totalBlocks not in", values, "courseTotalblocks");
            return (Criteria) this;
        }

        public Criteria andCourseTotalblocksBetween(Integer value1, Integer value2) {
            addCriterion("course_totalBlocks between", value1, value2, "courseTotalblocks");
            return (Criteria) this;
        }

        public Criteria andCourseTotalblocksNotBetween(Integer value1, Integer value2) {
            addCriterion("course_totalBlocks not between", value1, value2, "courseTotalblocks");
            return (Criteria) this;
        }

        public Criteria andCourseClicktimeIsNull() {
            addCriterion("course_clickTime is null");
            return (Criteria) this;
        }

        public Criteria andCourseClicktimeIsNotNull() {
            addCriterion("course_clickTime is not null");
            return (Criteria) this;
        }

        public Criteria andCourseClicktimeEqualTo(Integer value) {
            addCriterion("course_clickTime =", value, "courseClicktime");
            return (Criteria) this;
        }

        public Criteria andCourseClicktimeNotEqualTo(Integer value) {
            addCriterion("course_clickTime <>", value, "courseClicktime");
            return (Criteria) this;
        }

        public Criteria andCourseClicktimeGreaterThan(Integer value) {
            addCriterion("course_clickTime >", value, "courseClicktime");
            return (Criteria) this;
        }

        public Criteria andCourseClicktimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_clickTime >=", value, "courseClicktime");
            return (Criteria) this;
        }

        public Criteria andCourseClicktimeLessThan(Integer value) {
            addCriterion("course_clickTime <", value, "courseClicktime");
            return (Criteria) this;
        }

        public Criteria andCourseClicktimeLessThanOrEqualTo(Integer value) {
            addCriterion("course_clickTime <=", value, "courseClicktime");
            return (Criteria) this;
        }

        public Criteria andCourseClicktimeIn(List<Integer> values) {
            addCriterion("course_clickTime in", values, "courseClicktime");
            return (Criteria) this;
        }

        public Criteria andCourseClicktimeNotIn(List<Integer> values) {
            addCriterion("course_clickTime not in", values, "courseClicktime");
            return (Criteria) this;
        }

        public Criteria andCourseClicktimeBetween(Integer value1, Integer value2) {
            addCriterion("course_clickTime between", value1, value2, "courseClicktime");
            return (Criteria) this;
        }

        public Criteria andCourseClicktimeNotBetween(Integer value1, Integer value2) {
            addCriterion("course_clickTime not between", value1, value2, "courseClicktime");
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