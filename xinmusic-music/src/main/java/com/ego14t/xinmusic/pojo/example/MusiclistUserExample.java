package com.ego14t.xinmusic.pojo.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MusiclistUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MusiclistUserExample() {
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

        public Criteria andMusiclistidIsNull() {
            addCriterion("musicListID is null");
            return (Criteria) this;
        }

        public Criteria andMusiclistidIsNotNull() {
            addCriterion("musicListID is not null");
            return (Criteria) this;
        }

        public Criteria andMusiclistidEqualTo(Integer value) {
            addCriterion("musicListID =", value, "musiclistid");
            return (Criteria) this;
        }

        public Criteria andMusiclistidNotEqualTo(Integer value) {
            addCriterion("musicListID <>", value, "musiclistid");
            return (Criteria) this;
        }

        public Criteria andMusiclistidGreaterThan(Integer value) {
            addCriterion("musicListID >", value, "musiclistid");
            return (Criteria) this;
        }

        public Criteria andMusiclistidGreaterThanOrEqualTo(Integer value) {
            addCriterion("musicListID >=", value, "musiclistid");
            return (Criteria) this;
        }

        public Criteria andMusiclistidLessThan(Integer value) {
            addCriterion("musicListID <", value, "musiclistid");
            return (Criteria) this;
        }

        public Criteria andMusiclistidLessThanOrEqualTo(Integer value) {
            addCriterion("musicListID <=", value, "musiclistid");
            return (Criteria) this;
        }

        public Criteria andMusiclistidIn(List<Integer> values) {
            addCriterion("musicListID in", values, "musiclistid");
            return (Criteria) this;
        }

        public Criteria andMusiclistidNotIn(List<Integer> values) {
            addCriterion("musicListID not in", values, "musiclistid");
            return (Criteria) this;
        }

        public Criteria andMusiclistidBetween(Integer value1, Integer value2) {
            addCriterion("musicListID between", value1, value2, "musiclistid");
            return (Criteria) this;
        }

        public Criteria andMusiclistidNotBetween(Integer value1, Integer value2) {
            addCriterion("musicListID not between", value1, value2, "musiclistid");
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

        public Criteria andUseridEqualTo(Integer value) {
            addCriterion("userID =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Integer value) {
            addCriterion("userID <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Integer value) {
            addCriterion("userID >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("userID >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Integer value) {
            addCriterion("userID <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Integer value) {
            addCriterion("userID <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Integer> values) {
            addCriterion("userID in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Integer> values) {
            addCriterion("userID not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Integer value1, Integer value2) {
            addCriterion("userID between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("userID not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andMusiclistNameIsNull() {
            addCriterion("musiclist_Name is null");
            return (Criteria) this;
        }

        public Criteria andMusiclistNameIsNotNull() {
            addCriterion("musiclist_Name is not null");
            return (Criteria) this;
        }

        public Criteria andMusiclistNameEqualTo(String value) {
            addCriterion("musiclist_Name =", value, "musiclistName");
            return (Criteria) this;
        }

        public Criteria andMusiclistNameNotEqualTo(String value) {
            addCriterion("musiclist_Name <>", value, "musiclistName");
            return (Criteria) this;
        }

        public Criteria andMusiclistNameGreaterThan(String value) {
            addCriterion("musiclist_Name >", value, "musiclistName");
            return (Criteria) this;
        }

        public Criteria andMusiclistNameGreaterThanOrEqualTo(String value) {
            addCriterion("musiclist_Name >=", value, "musiclistName");
            return (Criteria) this;
        }

        public Criteria andMusiclistNameLessThan(String value) {
            addCriterion("musiclist_Name <", value, "musiclistName");
            return (Criteria) this;
        }

        public Criteria andMusiclistNameLessThanOrEqualTo(String value) {
            addCriterion("musiclist_Name <=", value, "musiclistName");
            return (Criteria) this;
        }

        public Criteria andMusiclistNameLike(String value) {
            addCriterion("musiclist_Name like", value, "musiclistName");
            return (Criteria) this;
        }

        public Criteria andMusiclistNameNotLike(String value) {
            addCriterion("musiclist_Name not like", value, "musiclistName");
            return (Criteria) this;
        }

        public Criteria andMusiclistNameIn(List<String> values) {
            addCriterion("musiclist_Name in", values, "musiclistName");
            return (Criteria) this;
        }

        public Criteria andMusiclistNameNotIn(List<String> values) {
            addCriterion("musiclist_Name not in", values, "musiclistName");
            return (Criteria) this;
        }

        public Criteria andMusiclistNameBetween(String value1, String value2) {
            addCriterion("musiclist_Name between", value1, value2, "musiclistName");
            return (Criteria) this;
        }

        public Criteria andMusiclistNameNotBetween(String value1, String value2) {
            addCriterion("musiclist_Name not between", value1, value2, "musiclistName");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterionForJDBCDate("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterionForJDBCDate("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterionForJDBCDate("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andTagsIsNull() {
            addCriterion("tags is null");
            return (Criteria) this;
        }

        public Criteria andTagsIsNotNull() {
            addCriterion("tags is not null");
            return (Criteria) this;
        }

        public Criteria andTagsEqualTo(String value) {
            addCriterion("tags =", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotEqualTo(String value) {
            addCriterion("tags <>", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsGreaterThan(String value) {
            addCriterion("tags >", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsGreaterThanOrEqualTo(String value) {
            addCriterion("tags >=", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsLessThan(String value) {
            addCriterion("tags <", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsLessThanOrEqualTo(String value) {
            addCriterion("tags <=", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsLike(String value) {
            addCriterion("tags like", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotLike(String value) {
            addCriterion("tags not like", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsIn(List<String> values) {
            addCriterion("tags in", values, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotIn(List<String> values) {
            addCriterion("tags not in", values, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsBetween(String value1, String value2) {
            addCriterion("tags between", value1, value2, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotBetween(String value1, String value2) {
            addCriterion("tags not between", value1, value2, "tags");
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

        public Criteria andMusiclistImgIsNull() {
            addCriterion("musiclist_img is null");
            return (Criteria) this;
        }

        public Criteria andMusiclistImgIsNotNull() {
            addCriterion("musiclist_img is not null");
            return (Criteria) this;
        }

        public Criteria andMusiclistImgEqualTo(String value) {
            addCriterion("musiclist_img =", value, "musiclistImg");
            return (Criteria) this;
        }

        public Criteria andMusiclistImgNotEqualTo(String value) {
            addCriterion("musiclist_img <>", value, "musiclistImg");
            return (Criteria) this;
        }

        public Criteria andMusiclistImgGreaterThan(String value) {
            addCriterion("musiclist_img >", value, "musiclistImg");
            return (Criteria) this;
        }

        public Criteria andMusiclistImgGreaterThanOrEqualTo(String value) {
            addCriterion("musiclist_img >=", value, "musiclistImg");
            return (Criteria) this;
        }

        public Criteria andMusiclistImgLessThan(String value) {
            addCriterion("musiclist_img <", value, "musiclistImg");
            return (Criteria) this;
        }

        public Criteria andMusiclistImgLessThanOrEqualTo(String value) {
            addCriterion("musiclist_img <=", value, "musiclistImg");
            return (Criteria) this;
        }

        public Criteria andMusiclistImgLike(String value) {
            addCriterion("musiclist_img like", value, "musiclistImg");
            return (Criteria) this;
        }

        public Criteria andMusiclistImgNotLike(String value) {
            addCriterion("musiclist_img not like", value, "musiclistImg");
            return (Criteria) this;
        }

        public Criteria andMusiclistImgIn(List<String> values) {
            addCriterion("musiclist_img in", values, "musiclistImg");
            return (Criteria) this;
        }

        public Criteria andMusiclistImgNotIn(List<String> values) {
            addCriterion("musiclist_img not in", values, "musiclistImg");
            return (Criteria) this;
        }

        public Criteria andMusiclistImgBetween(String value1, String value2) {
            addCriterion("musiclist_img between", value1, value2, "musiclistImg");
            return (Criteria) this;
        }

        public Criteria andMusiclistImgNotBetween(String value1, String value2) {
            addCriterion("musiclist_img not between", value1, value2, "musiclistImg");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andIscollectingIsNull() {
            addCriterion("isCollecting is null");
            return (Criteria) this;
        }

        public Criteria andIscollectingIsNotNull() {
            addCriterion("isCollecting is not null");
            return (Criteria) this;
        }

        public Criteria andIscollectingEqualTo(Integer value) {
            addCriterion("isCollecting =", value, "iscollecting");
            return (Criteria) this;
        }

        public Criteria andIscollectingNotEqualTo(Integer value) {
            addCriterion("isCollecting <>", value, "iscollecting");
            return (Criteria) this;
        }

        public Criteria andIscollectingGreaterThan(Integer value) {
            addCriterion("isCollecting >", value, "iscollecting");
            return (Criteria) this;
        }

        public Criteria andIscollectingGreaterThanOrEqualTo(Integer value) {
            addCriterion("isCollecting >=", value, "iscollecting");
            return (Criteria) this;
        }

        public Criteria andIscollectingLessThan(Integer value) {
            addCriterion("isCollecting <", value, "iscollecting");
            return (Criteria) this;
        }

        public Criteria andIscollectingLessThanOrEqualTo(Integer value) {
            addCriterion("isCollecting <=", value, "iscollecting");
            return (Criteria) this;
        }

        public Criteria andIscollectingIn(List<Integer> values) {
            addCriterion("isCollecting in", values, "iscollecting");
            return (Criteria) this;
        }

        public Criteria andIscollectingNotIn(List<Integer> values) {
            addCriterion("isCollecting not in", values, "iscollecting");
            return (Criteria) this;
        }

        public Criteria andIscollectingBetween(Integer value1, Integer value2) {
            addCriterion("isCollecting between", value1, value2, "iscollecting");
            return (Criteria) this;
        }

        public Criteria andIscollectingNotBetween(Integer value1, Integer value2) {
            addCriterion("isCollecting not between", value1, value2, "iscollecting");
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