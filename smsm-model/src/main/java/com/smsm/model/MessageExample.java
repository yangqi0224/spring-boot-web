package com.smsm.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessageExample() {
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

        public Criteria andMIdIsNull() {
            addCriterion("M_id is null");
            return (Criteria) this;
        }

        public Criteria andMIdIsNotNull() {
            addCriterion("M_id is not null");
            return (Criteria) this;
        }

        public Criteria andMIdEqualTo(String value) {
            addCriterion("M_id =", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdNotEqualTo(String value) {
            addCriterion("M_id <>", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdGreaterThan(String value) {
            addCriterion("M_id >", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdGreaterThanOrEqualTo(String value) {
            addCriterion("M_id >=", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdLessThan(String value) {
            addCriterion("M_id <", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdLessThanOrEqualTo(String value) {
            addCriterion("M_id <=", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdLike(String value) {
            addCriterion("M_id like", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdNotLike(String value) {
            addCriterion("M_id not like", value, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdIn(List<String> values) {
            addCriterion("M_id in", values, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdNotIn(List<String> values) {
            addCriterion("M_id not in", values, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdBetween(String value1, String value2) {
            addCriterion("M_id between", value1, value2, "mId");
            return (Criteria) this;
        }

        public Criteria andMIdNotBetween(String value1, String value2) {
            addCriterion("M_id not between", value1, value2, "mId");
            return (Criteria) this;
        }

        public Criteria andMStatusIsNull() {
            addCriterion("M_status is null");
            return (Criteria) this;
        }

        public Criteria andMStatusIsNotNull() {
            addCriterion("M_status is not null");
            return (Criteria) this;
        }

        public Criteria andMStatusEqualTo(Boolean value) {
            addCriterion("M_status =", value, "mStatus");
            return (Criteria) this;
        }

        public Criteria andMStatusNotEqualTo(Boolean value) {
            addCriterion("M_status <>", value, "mStatus");
            return (Criteria) this;
        }

        public Criteria andMStatusGreaterThan(Boolean value) {
            addCriterion("M_status >", value, "mStatus");
            return (Criteria) this;
        }

        public Criteria andMStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("M_status >=", value, "mStatus");
            return (Criteria) this;
        }

        public Criteria andMStatusLessThan(Boolean value) {
            addCriterion("M_status <", value, "mStatus");
            return (Criteria) this;
        }

        public Criteria andMStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("M_status <=", value, "mStatus");
            return (Criteria) this;
        }

        public Criteria andMStatusIn(List<Boolean> values) {
            addCriterion("M_status in", values, "mStatus");
            return (Criteria) this;
        }

        public Criteria andMStatusNotIn(List<Boolean> values) {
            addCriterion("M_status not in", values, "mStatus");
            return (Criteria) this;
        }

        public Criteria andMStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("M_status between", value1, value2, "mStatus");
            return (Criteria) this;
        }

        public Criteria andMStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("M_status not between", value1, value2, "mStatus");
            return (Criteria) this;
        }

        public Criteria andMTimeIsNull() {
            addCriterion("M_time is null");
            return (Criteria) this;
        }

        public Criteria andMTimeIsNotNull() {
            addCriterion("M_time is not null");
            return (Criteria) this;
        }

        public Criteria andMTimeEqualTo(Date value) {
            addCriterion("M_time =", value, "mTime");
            return (Criteria) this;
        }

        public Criteria andMTimeNotEqualTo(Date value) {
            addCriterion("M_time <>", value, "mTime");
            return (Criteria) this;
        }

        public Criteria andMTimeGreaterThan(Date value) {
            addCriterion("M_time >", value, "mTime");
            return (Criteria) this;
        }

        public Criteria andMTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("M_time >=", value, "mTime");
            return (Criteria) this;
        }

        public Criteria andMTimeLessThan(Date value) {
            addCriterion("M_time <", value, "mTime");
            return (Criteria) this;
        }

        public Criteria andMTimeLessThanOrEqualTo(Date value) {
            addCriterion("M_time <=", value, "mTime");
            return (Criteria) this;
        }

        public Criteria andMTimeIn(List<Date> values) {
            addCriterion("M_time in", values, "mTime");
            return (Criteria) this;
        }

        public Criteria andMTimeNotIn(List<Date> values) {
            addCriterion("M_time not in", values, "mTime");
            return (Criteria) this;
        }

        public Criteria andMTimeBetween(Date value1, Date value2) {
            addCriterion("M_time between", value1, value2, "mTime");
            return (Criteria) this;
        }

        public Criteria andMTimeNotBetween(Date value1, Date value2) {
            addCriterion("M_time not between", value1, value2, "mTime");
            return (Criteria) this;
        }

        public Criteria andMFromUserIdIsNull() {
            addCriterion("M_from_user_id is null");
            return (Criteria) this;
        }

        public Criteria andMFromUserIdIsNotNull() {
            addCriterion("M_from_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andMFromUserIdEqualTo(String value) {
            addCriterion("M_from_user_id =", value, "mFromUserId");
            return (Criteria) this;
        }

        public Criteria andMFromUserIdNotEqualTo(String value) {
            addCriterion("M_from_user_id <>", value, "mFromUserId");
            return (Criteria) this;
        }

        public Criteria andMFromUserIdGreaterThan(String value) {
            addCriterion("M_from_user_id >", value, "mFromUserId");
            return (Criteria) this;
        }

        public Criteria andMFromUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("M_from_user_id >=", value, "mFromUserId");
            return (Criteria) this;
        }

        public Criteria andMFromUserIdLessThan(String value) {
            addCriterion("M_from_user_id <", value, "mFromUserId");
            return (Criteria) this;
        }

        public Criteria andMFromUserIdLessThanOrEqualTo(String value) {
            addCriterion("M_from_user_id <=", value, "mFromUserId");
            return (Criteria) this;
        }

        public Criteria andMFromUserIdLike(String value) {
            addCriterion("M_from_user_id like", value, "mFromUserId");
            return (Criteria) this;
        }

        public Criteria andMFromUserIdNotLike(String value) {
            addCriterion("M_from_user_id not like", value, "mFromUserId");
            return (Criteria) this;
        }

        public Criteria andMFromUserIdIn(List<String> values) {
            addCriterion("M_from_user_id in", values, "mFromUserId");
            return (Criteria) this;
        }

        public Criteria andMFromUserIdNotIn(List<String> values) {
            addCriterion("M_from_user_id not in", values, "mFromUserId");
            return (Criteria) this;
        }

        public Criteria andMFromUserIdBetween(String value1, String value2) {
            addCriterion("M_from_user_id between", value1, value2, "mFromUserId");
            return (Criteria) this;
        }

        public Criteria andMFromUserIdNotBetween(String value1, String value2) {
            addCriterion("M_from_user_id not between", value1, value2, "mFromUserId");
            return (Criteria) this;
        }

        public Criteria andMToUserIdIsNull() {
            addCriterion("M_to_user_id is null");
            return (Criteria) this;
        }

        public Criteria andMToUserIdIsNotNull() {
            addCriterion("M_to_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andMToUserIdEqualTo(String value) {
            addCriterion("M_to_user_id =", value, "mToUserId");
            return (Criteria) this;
        }

        public Criteria andMToUserIdNotEqualTo(String value) {
            addCriterion("M_to_user_id <>", value, "mToUserId");
            return (Criteria) this;
        }

        public Criteria andMToUserIdGreaterThan(String value) {
            addCriterion("M_to_user_id >", value, "mToUserId");
            return (Criteria) this;
        }

        public Criteria andMToUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("M_to_user_id >=", value, "mToUserId");
            return (Criteria) this;
        }

        public Criteria andMToUserIdLessThan(String value) {
            addCriterion("M_to_user_id <", value, "mToUserId");
            return (Criteria) this;
        }

        public Criteria andMToUserIdLessThanOrEqualTo(String value) {
            addCriterion("M_to_user_id <=", value, "mToUserId");
            return (Criteria) this;
        }

        public Criteria andMToUserIdLike(String value) {
            addCriterion("M_to_user_id like", value, "mToUserId");
            return (Criteria) this;
        }

        public Criteria andMToUserIdNotLike(String value) {
            addCriterion("M_to_user_id not like", value, "mToUserId");
            return (Criteria) this;
        }

        public Criteria andMToUserIdIn(List<String> values) {
            addCriterion("M_to_user_id in", values, "mToUserId");
            return (Criteria) this;
        }

        public Criteria andMToUserIdNotIn(List<String> values) {
            addCriterion("M_to_user_id not in", values, "mToUserId");
            return (Criteria) this;
        }

        public Criteria andMToUserIdBetween(String value1, String value2) {
            addCriterion("M_to_user_id between", value1, value2, "mToUserId");
            return (Criteria) this;
        }

        public Criteria andMToUserIdNotBetween(String value1, String value2) {
            addCriterion("M_to_user_id not between", value1, value2, "mToUserId");
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