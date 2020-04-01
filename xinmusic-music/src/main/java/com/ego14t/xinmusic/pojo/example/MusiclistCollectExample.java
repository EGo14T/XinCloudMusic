package com.ego14t.xinmusic.pojo.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MusiclistCollectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public MusiclistCollectExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
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

        public Criteria andMusiclistidIsNull() {
            addCriterion("musiclistID is null");
            return (Criteria) this;
        }

        public Criteria andMusiclistidIsNotNull() {
            addCriterion("musiclistID is not null");
            return (Criteria) this;
        }

        public Criteria andMusiclistidEqualTo(String value) {
            addCriterion("musiclistID =", value, "musiclistid");
            return (Criteria) this;
        }

        public Criteria andMusiclistidNotEqualTo(String value) {
            addCriterion("musiclistID <>", value, "musiclistid");
            return (Criteria) this;
        }

        public Criteria andMusiclistidGreaterThan(String value) {
            addCriterion("musiclistID >", value, "musiclistid");
            return (Criteria) this;
        }

        public Criteria andMusiclistidGreaterThanOrEqualTo(String value) {
            addCriterion("musiclistID >=", value, "musiclistid");
            return (Criteria) this;
        }

        public Criteria andMusiclistidLessThan(String value) {
            addCriterion("musiclistID <", value, "musiclistid");
            return (Criteria) this;
        }

        public Criteria andMusiclistidLessThanOrEqualTo(String value) {
            addCriterion("musiclistID <=", value, "musiclistid");
            return (Criteria) this;
        }

        public Criteria andMusiclistidLike(String value) {
            addCriterion("musiclistID like", value, "musiclistid");
            return (Criteria) this;
        }

        public Criteria andMusiclistidNotLike(String value) {
            addCriterion("musiclistID not like", value, "musiclistid");
            return (Criteria) this;
        }

        public Criteria andMusiclistidIn(List<String> values) {
            addCriterion("musiclistID in", values, "musiclistid");
            return (Criteria) this;
        }

        public Criteria andMusiclistidNotIn(List<String> values) {
            addCriterion("musiclistID not in", values, "musiclistid");
            return (Criteria) this;
        }

        public Criteria andMusiclistidBetween(String value1, String value2) {
            addCriterion("musiclistID between", value1, value2, "musiclistid");
            return (Criteria) this;
        }

        public Criteria andMusiclistidNotBetween(String value1, String value2) {
            addCriterion("musiclistID not between", value1, value2, "musiclistid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userID is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userID is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userID =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userID <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userID >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userID >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userID <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userID <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userID like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userID not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userID in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userID not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userID between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userID not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andCollectingtimeIsNull() {
            addCriterion("collectingTime is null");
            return (Criteria) this;
        }

        public Criteria andCollectingtimeIsNotNull() {
            addCriterion("collectingTime is not null");
            return (Criteria) this;
        }

        public Criteria andCollectingtimeEqualTo(Date value) {
            addCriterion("collectingTime =", value, "collectingtime");
            return (Criteria) this;
        }

        public Criteria andCollectingtimeNotEqualTo(Date value) {
            addCriterion("collectingTime <>", value, "collectingtime");
            return (Criteria) this;
        }

        public Criteria andCollectingtimeGreaterThan(Date value) {
            addCriterion("collectingTime >", value, "collectingtime");
            return (Criteria) this;
        }

        public Criteria andCollectingtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("collectingTime >=", value, "collectingtime");
            return (Criteria) this;
        }

        public Criteria andCollectingtimeLessThan(Date value) {
            addCriterion("collectingTime <", value, "collectingtime");
            return (Criteria) this;
        }

        public Criteria andCollectingtimeLessThanOrEqualTo(Date value) {
            addCriterion("collectingTime <=", value, "collectingtime");
            return (Criteria) this;
        }

        public Criteria andCollectingtimeIn(List<Date> values) {
            addCriterion("collectingTime in", values, "collectingtime");
            return (Criteria) this;
        }

        public Criteria andCollectingtimeNotIn(List<Date> values) {
            addCriterion("collectingTime not in", values, "collectingtime");
            return (Criteria) this;
        }

        public Criteria andCollectingtimeBetween(Date value1, Date value2) {
            addCriterion("collectingTime between", value1, value2, "collectingtime");
            return (Criteria) this;
        }

        public Criteria andCollectingtimeNotBetween(Date value1, Date value2) {
            addCriterion("collectingTime not between", value1, value2, "collectingtime");
            return (Criteria) this;
        }
    }

    /**
     */
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