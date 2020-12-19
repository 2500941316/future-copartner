package com.shu.copartner.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProNewsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProNewsExample() {
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

        public Criteria andNewsIdIsNull() {
            addCriterion("news_id is null");
            return (Criteria) this;
        }

        public Criteria andNewsIdIsNotNull() {
            addCriterion("news_id is not null");
            return (Criteria) this;
        }

        public Criteria andNewsIdEqualTo(Long value) {
            addCriterion("news_id =", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdNotEqualTo(Long value) {
            addCriterion("news_id <>", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdGreaterThan(Long value) {
            addCriterion("news_id >", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("news_id >=", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdLessThan(Long value) {
            addCriterion("news_id <", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdLessThanOrEqualTo(Long value) {
            addCriterion("news_id <=", value, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdIn(List<Long> values) {
            addCriterion("news_id in", values, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdNotIn(List<Long> values) {
            addCriterion("news_id not in", values, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdBetween(Long value1, Long value2) {
            addCriterion("news_id between", value1, value2, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsIdNotBetween(Long value1, Long value2) {
            addCriterion("news_id not between", value1, value2, "newsId");
            return (Criteria) this;
        }

        public Criteria andNewsTitleIsNull() {
            addCriterion("news_title is null");
            return (Criteria) this;
        }

        public Criteria andNewsTitleIsNotNull() {
            addCriterion("news_title is not null");
            return (Criteria) this;
        }

        public Criteria andNewsTitleEqualTo(String value) {
            addCriterion("news_title =", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleNotEqualTo(String value) {
            addCriterion("news_title <>", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleGreaterThan(String value) {
            addCriterion("news_title >", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleGreaterThanOrEqualTo(String value) {
            addCriterion("news_title >=", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleLessThan(String value) {
            addCriterion("news_title <", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleLessThanOrEqualTo(String value) {
            addCriterion("news_title <=", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleLike(String value) {
            addCriterion("news_title like", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleNotLike(String value) {
            addCriterion("news_title not like", value, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleIn(List<String> values) {
            addCriterion("news_title in", values, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleNotIn(List<String> values) {
            addCriterion("news_title not in", values, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleBetween(String value1, String value2) {
            addCriterion("news_title between", value1, value2, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsTitleNotBetween(String value1, String value2) {
            addCriterion("news_title not between", value1, value2, "newsTitle");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorIsNull() {
            addCriterion("news_author is null");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorIsNotNull() {
            addCriterion("news_author is not null");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorEqualTo(String value) {
            addCriterion("news_author =", value, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorNotEqualTo(String value) {
            addCriterion("news_author <>", value, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorGreaterThan(String value) {
            addCriterion("news_author >", value, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("news_author >=", value, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorLessThan(String value) {
            addCriterion("news_author <", value, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorLessThanOrEqualTo(String value) {
            addCriterion("news_author <=", value, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorLike(String value) {
            addCriterion("news_author like", value, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorNotLike(String value) {
            addCriterion("news_author not like", value, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorIn(List<String> values) {
            addCriterion("news_author in", values, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorNotIn(List<String> values) {
            addCriterion("news_author not in", values, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorBetween(String value1, String value2) {
            addCriterion("news_author between", value1, value2, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsAuthorNotBetween(String value1, String value2) {
            addCriterion("news_author not between", value1, value2, "newsAuthor");
            return (Criteria) this;
        }

        public Criteria andNewsCategoryIsNull() {
            addCriterion("news_category is null");
            return (Criteria) this;
        }

        public Criteria andNewsCategoryIsNotNull() {
            addCriterion("news_category is not null");
            return (Criteria) this;
        }

        public Criteria andNewsCategoryEqualTo(String value) {
            addCriterion("news_category =", value, "newsCategory");
            return (Criteria) this;
        }

        public Criteria andNewsCategoryNotEqualTo(String value) {
            addCriterion("news_category <>", value, "newsCategory");
            return (Criteria) this;
        }

        public Criteria andNewsCategoryGreaterThan(String value) {
            addCriterion("news_category >", value, "newsCategory");
            return (Criteria) this;
        }

        public Criteria andNewsCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("news_category >=", value, "newsCategory");
            return (Criteria) this;
        }

        public Criteria andNewsCategoryLessThan(String value) {
            addCriterion("news_category <", value, "newsCategory");
            return (Criteria) this;
        }

        public Criteria andNewsCategoryLessThanOrEqualTo(String value) {
            addCriterion("news_category <=", value, "newsCategory");
            return (Criteria) this;
        }

        public Criteria andNewsCategoryLike(String value) {
            addCriterion("news_category like", value, "newsCategory");
            return (Criteria) this;
        }

        public Criteria andNewsCategoryNotLike(String value) {
            addCriterion("news_category not like", value, "newsCategory");
            return (Criteria) this;
        }

        public Criteria andNewsCategoryIn(List<String> values) {
            addCriterion("news_category in", values, "newsCategory");
            return (Criteria) this;
        }

        public Criteria andNewsCategoryNotIn(List<String> values) {
            addCriterion("news_category not in", values, "newsCategory");
            return (Criteria) this;
        }

        public Criteria andNewsCategoryBetween(String value1, String value2) {
            addCriterion("news_category between", value1, value2, "newsCategory");
            return (Criteria) this;
        }

        public Criteria andNewsCategoryNotBetween(String value1, String value2) {
            addCriterion("news_category not between", value1, value2, "newsCategory");
            return (Criteria) this;
        }

        public Criteria andNewsPublistimeIsNull() {
            addCriterion("news_publisTime is null");
            return (Criteria) this;
        }

        public Criteria andNewsPublistimeIsNotNull() {
            addCriterion("news_publisTime is not null");
            return (Criteria) this;
        }

        public Criteria andNewsPublistimeEqualTo(Date value) {
            addCriterion("news_publisTime =", value, "newsPublistime");
            return (Criteria) this;
        }

        public Criteria andNewsPublistimeNotEqualTo(Date value) {
            addCriterion("news_publisTime <>", value, "newsPublistime");
            return (Criteria) this;
        }

        public Criteria andNewsPublistimeGreaterThan(Date value) {
            addCriterion("news_publisTime >", value, "newsPublistime");
            return (Criteria) this;
        }

        public Criteria andNewsPublistimeGreaterThanOrEqualTo(Date value) {
            addCriterion("news_publisTime >=", value, "newsPublistime");
            return (Criteria) this;
        }

        public Criteria andNewsPublistimeLessThan(Date value) {
            addCriterion("news_publisTime <", value, "newsPublistime");
            return (Criteria) this;
        }

        public Criteria andNewsPublistimeLessThanOrEqualTo(Date value) {
            addCriterion("news_publisTime <=", value, "newsPublistime");
            return (Criteria) this;
        }

        public Criteria andNewsPublistimeIn(List<Date> values) {
            addCriterion("news_publisTime in", values, "newsPublistime");
            return (Criteria) this;
        }

        public Criteria andNewsPublistimeNotIn(List<Date> values) {
            addCriterion("news_publisTime not in", values, "newsPublistime");
            return (Criteria) this;
        }

        public Criteria andNewsPublistimeBetween(Date value1, Date value2) {
            addCriterion("news_publisTime between", value1, value2, "newsPublistime");
            return (Criteria) this;
        }

        public Criteria andNewsPublistimeNotBetween(Date value1, Date value2) {
            addCriterion("news_publisTime not between", value1, value2, "newsPublistime");
            return (Criteria) this;
        }

        public Criteria andNewsBrowsecountIsNull() {
            addCriterion("news_browseCount is null");
            return (Criteria) this;
        }

        public Criteria andNewsBrowsecountIsNotNull() {
            addCriterion("news_browseCount is not null");
            return (Criteria) this;
        }

        public Criteria andNewsBrowsecountEqualTo(Integer value) {
            addCriterion("news_browseCount =", value, "newsBrowsecount");
            return (Criteria) this;
        }

        public Criteria andNewsBrowsecountNotEqualTo(Integer value) {
            addCriterion("news_browseCount <>", value, "newsBrowsecount");
            return (Criteria) this;
        }

        public Criteria andNewsBrowsecountGreaterThan(Integer value) {
            addCriterion("news_browseCount >", value, "newsBrowsecount");
            return (Criteria) this;
        }

        public Criteria andNewsBrowsecountGreaterThanOrEqualTo(Integer value) {
            addCriterion("news_browseCount >=", value, "newsBrowsecount");
            return (Criteria) this;
        }

        public Criteria andNewsBrowsecountLessThan(Integer value) {
            addCriterion("news_browseCount <", value, "newsBrowsecount");
            return (Criteria) this;
        }

        public Criteria andNewsBrowsecountLessThanOrEqualTo(Integer value) {
            addCriterion("news_browseCount <=", value, "newsBrowsecount");
            return (Criteria) this;
        }

        public Criteria andNewsBrowsecountIn(List<Integer> values) {
            addCriterion("news_browseCount in", values, "newsBrowsecount");
            return (Criteria) this;
        }

        public Criteria andNewsBrowsecountNotIn(List<Integer> values) {
            addCriterion("news_browseCount not in", values, "newsBrowsecount");
            return (Criteria) this;
        }

        public Criteria andNewsBrowsecountBetween(Integer value1, Integer value2) {
            addCriterion("news_browseCount between", value1, value2, "newsBrowsecount");
            return (Criteria) this;
        }

        public Criteria andNewsBrowsecountNotBetween(Integer value1, Integer value2) {
            addCriterion("news_browseCount not between", value1, value2, "newsBrowsecount");
            return (Criteria) this;
        }

        public Criteria andIstoppingIsNull() {
            addCriterion("isTopping is null");
            return (Criteria) this;
        }

        public Criteria andIstoppingIsNotNull() {
            addCriterion("isTopping is not null");
            return (Criteria) this;
        }

        public Criteria andIstoppingEqualTo(String value) {
            addCriterion("isTopping =", value, "istopping");
            return (Criteria) this;
        }

        public Criteria andIstoppingNotEqualTo(String value) {
            addCriterion("isTopping <>", value, "istopping");
            return (Criteria) this;
        }

        public Criteria andIstoppingGreaterThan(String value) {
            addCriterion("isTopping >", value, "istopping");
            return (Criteria) this;
        }

        public Criteria andIstoppingGreaterThanOrEqualTo(String value) {
            addCriterion("isTopping >=", value, "istopping");
            return (Criteria) this;
        }

        public Criteria andIstoppingLessThan(String value) {
            addCriterion("isTopping <", value, "istopping");
            return (Criteria) this;
        }

        public Criteria andIstoppingLessThanOrEqualTo(String value) {
            addCriterion("isTopping <=", value, "istopping");
            return (Criteria) this;
        }

        public Criteria andIstoppingLike(String value) {
            addCriterion("isTopping like", value, "istopping");
            return (Criteria) this;
        }

        public Criteria andIstoppingNotLike(String value) {
            addCriterion("isTopping not like", value, "istopping");
            return (Criteria) this;
        }

        public Criteria andIstoppingIn(List<String> values) {
            addCriterion("isTopping in", values, "istopping");
            return (Criteria) this;
        }

        public Criteria andIstoppingNotIn(List<String> values) {
            addCriterion("isTopping not in", values, "istopping");
            return (Criteria) this;
        }

        public Criteria andIstoppingBetween(String value1, String value2) {
            addCriterion("isTopping between", value1, value2, "istopping");
            return (Criteria) this;
        }

        public Criteria andIstoppingNotBetween(String value1, String value2) {
            addCriterion("isTopping not between", value1, value2, "istopping");
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

        public Criteria andIsdeletedEqualTo(String value) {
            addCriterion("isDeleted =", value, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedNotEqualTo(String value) {
            addCriterion("isDeleted <>", value, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedGreaterThan(String value) {
            addCriterion("isDeleted >", value, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedGreaterThanOrEqualTo(String value) {
            addCriterion("isDeleted >=", value, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedLessThan(String value) {
            addCriterion("isDeleted <", value, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedLessThanOrEqualTo(String value) {
            addCriterion("isDeleted <=", value, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedLike(String value) {
            addCriterion("isDeleted like", value, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedNotLike(String value) {
            addCriterion("isDeleted not like", value, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedIn(List<String> values) {
            addCriterion("isDeleted in", values, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedNotIn(List<String> values) {
            addCriterion("isDeleted not in", values, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedBetween(String value1, String value2) {
            addCriterion("isDeleted between", value1, value2, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andIsdeletedNotBetween(String value1, String value2) {
            addCriterion("isDeleted not between", value1, value2, "isdeleted");
            return (Criteria) this;
        }

        public Criteria andNewsKeywordsIsNull() {
            addCriterion("news_keywords is null");
            return (Criteria) this;
        }

        public Criteria andNewsKeywordsIsNotNull() {
            addCriterion("news_keywords is not null");
            return (Criteria) this;
        }

        public Criteria andNewsKeywordsEqualTo(String value) {
            addCriterion("news_keywords =", value, "newsKeywords");
            return (Criteria) this;
        }

        public Criteria andNewsKeywordsNotEqualTo(String value) {
            addCriterion("news_keywords <>", value, "newsKeywords");
            return (Criteria) this;
        }

        public Criteria andNewsKeywordsGreaterThan(String value) {
            addCriterion("news_keywords >", value, "newsKeywords");
            return (Criteria) this;
        }

        public Criteria andNewsKeywordsGreaterThanOrEqualTo(String value) {
            addCriterion("news_keywords >=", value, "newsKeywords");
            return (Criteria) this;
        }

        public Criteria andNewsKeywordsLessThan(String value) {
            addCriterion("news_keywords <", value, "newsKeywords");
            return (Criteria) this;
        }

        public Criteria andNewsKeywordsLessThanOrEqualTo(String value) {
            addCriterion("news_keywords <=", value, "newsKeywords");
            return (Criteria) this;
        }

        public Criteria andNewsKeywordsLike(String value) {
            addCriterion("news_keywords like", value, "newsKeywords");
            return (Criteria) this;
        }

        public Criteria andNewsKeywordsNotLike(String value) {
            addCriterion("news_keywords not like", value, "newsKeywords");
            return (Criteria) this;
        }

        public Criteria andNewsKeywordsIn(List<String> values) {
            addCriterion("news_keywords in", values, "newsKeywords");
            return (Criteria) this;
        }

        public Criteria andNewsKeywordsNotIn(List<String> values) {
            addCriterion("news_keywords not in", values, "newsKeywords");
            return (Criteria) this;
        }

        public Criteria andNewsKeywordsBetween(String value1, String value2) {
            addCriterion("news_keywords between", value1, value2, "newsKeywords");
            return (Criteria) this;
        }

        public Criteria andNewsKeywordsNotBetween(String value1, String value2) {
            addCriterion("news_keywords not between", value1, value2, "newsKeywords");
            return (Criteria) this;
        }

        public Criteria andIsauditIsNull() {
            addCriterion("isAudit is null");
            return (Criteria) this;
        }

        public Criteria andIsauditIsNotNull() {
            addCriterion("isAudit is not null");
            return (Criteria) this;
        }

        public Criteria andIsauditEqualTo(String value) {
            addCriterion("isAudit =", value, "isaudit");
            return (Criteria) this;
        }

        public Criteria andIsauditNotEqualTo(String value) {
            addCriterion("isAudit <>", value, "isaudit");
            return (Criteria) this;
        }

        public Criteria andIsauditGreaterThan(String value) {
            addCriterion("isAudit >", value, "isaudit");
            return (Criteria) this;
        }

        public Criteria andIsauditGreaterThanOrEqualTo(String value) {
            addCriterion("isAudit >=", value, "isaudit");
            return (Criteria) this;
        }

        public Criteria andIsauditLessThan(String value) {
            addCriterion("isAudit <", value, "isaudit");
            return (Criteria) this;
        }

        public Criteria andIsauditLessThanOrEqualTo(String value) {
            addCriterion("isAudit <=", value, "isaudit");
            return (Criteria) this;
        }

        public Criteria andIsauditLike(String value) {
            addCriterion("isAudit like", value, "isaudit");
            return (Criteria) this;
        }

        public Criteria andIsauditNotLike(String value) {
            addCriterion("isAudit not like", value, "isaudit");
            return (Criteria) this;
        }

        public Criteria andIsauditIn(List<String> values) {
            addCriterion("isAudit in", values, "isaudit");
            return (Criteria) this;
        }

        public Criteria andIsauditNotIn(List<String> values) {
            addCriterion("isAudit not in", values, "isaudit");
            return (Criteria) this;
        }

        public Criteria andIsauditBetween(String value1, String value2) {
            addCriterion("isAudit between", value1, value2, "isaudit");
            return (Criteria) this;
        }

        public Criteria andIsauditNotBetween(String value1, String value2) {
            addCriterion("isAudit not between", value1, value2, "isaudit");
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