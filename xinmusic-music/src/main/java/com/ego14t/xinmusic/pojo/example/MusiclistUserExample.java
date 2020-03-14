package com.ego14t.xinmusic.pojo.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MusiclistUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

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
            addCriterion("musicListID is null");
            return (Criteria) this;
        }

        public Criteria andMusiclistidIsNotNull() {
            addCriterion("musicListID is not null");
            return (Criteria) this;
        }

        public Criteria andMusiclistidEqualTo(String value) {
            addCriterion("musicListID =", value, "musiclistid");
            return (Criteria) this;
        }

        public Criteria andMusiclistidNotEqualTo(String value) {
            addCriterion("musicListID <>", value, "musiclistid");
            return (Criteria) this;
        }

        public Criteria andMusiclistidGreaterThan(String value) {
            addCriterion("musicListID >", value, "musiclistid");
            return (Criteria) this;
        }

        public Criteria andMusiclistidGreaterThanOrEqualTo(String value) {
            addCriterion("musicListID >=", value, "musiclistid");
            return (Criteria) this;
        }

        public Criteria andMusiclistidLessThan(String value) {
            addCriterion("musicListID <", value, "musiclistid");
            return (Criteria) this;
        }

        public Criteria andMusiclistidLessThanOrEqualTo(String value) {
            addCriterion("musicListID <=", value, "musiclistid");
            return (Criteria) this;
        }

        public Criteria andMusiclistidLike(String value) {
            addCriterion("musicListID like", value, "musiclistid");
            return (Criteria) this;
        }

        public Criteria andMusiclistidNotLike(String value) {
            addCriterion("musicListID not like", value, "musiclistid");
            return (Criteria) this;
        }

        public Criteria andMusiclistidIn(List<String> values) {
            addCriterion("musicListID in", values, "musiclistid");
            return (Criteria) this;
        }

        public Criteria andMusiclistidNotIn(List<String> values) {
            addCriterion("musicListID not in", values, "musiclistid");
            return (Criteria) this;
        }

        public Criteria andMusiclistidBetween(String value1, String value2) {
            addCriterion("musicListID between", value1, value2, "musiclistid");
            return (Criteria) this;
        }

        public Criteria andMusiclistidNotBetween(String value1, String value2) {
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

        public Criteria andMusiclistNameIsNull() {
            addCriterion("musicList_name is null");
            return (Criteria) this;
        }

        public Criteria andMusiclistNameIsNotNull() {
            addCriterion("musicList_name is not null");
            return (Criteria) this;
        }

        public Criteria andMusiclistNameEqualTo(String value) {
            addCriterion("musicList_name =", value, "musiclistName");
            return (Criteria) this;
        }

        public Criteria andMusiclistNameNotEqualTo(String value) {
            addCriterion("musicList_name <>", value, "musiclistName");
            return (Criteria) this;
        }

        public Criteria andMusiclistNameGreaterThan(String value) {
            addCriterion("musicList_name >", value, "musiclistName");
            return (Criteria) this;
        }

        public Criteria andMusiclistNameGreaterThanOrEqualTo(String value) {
            addCriterion("musicList_name >=", value, "musiclistName");
            return (Criteria) this;
        }

        public Criteria andMusiclistNameLessThan(String value) {
            addCriterion("musicList_name <", value, "musiclistName");
            return (Criteria) this;
        }

        public Criteria andMusiclistNameLessThanOrEqualTo(String value) {
            addCriterion("musicList_name <=", value, "musiclistName");
            return (Criteria) this;
        }

        public Criteria andMusiclistNameLike(String value) {
            addCriterion("musicList_name like", value, "musiclistName");
            return (Criteria) this;
        }

        public Criteria andMusiclistNameNotLike(String value) {
            addCriterion("musicList_name not like", value, "musiclistName");
            return (Criteria) this;
        }

        public Criteria andMusiclistNameIn(List<String> values) {
            addCriterion("musicList_name in", values, "musiclistName");
            return (Criteria) this;
        }

        public Criteria andMusiclistNameNotIn(List<String> values) {
            addCriterion("musicList_name not in", values, "musiclistName");
            return (Criteria) this;
        }

        public Criteria andMusiclistNameBetween(String value1, String value2) {
            addCriterion("musicList_name between", value1, value2, "musiclistName");
            return (Criteria) this;
        }

        public Criteria andMusiclistNameNotBetween(String value1, String value2) {
            addCriterion("musicList_name not between", value1, value2, "musiclistName");
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
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("`status` not between", value1, value2, "status");
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