package com.smsm.model;

import java.util.ArrayList;
import java.util.List;

public class JobSeekerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JobSeekerExample() {
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

        public Criteria andJobSeekerIdIsNull() {
            addCriterion("job_seeker_id is null");
            return (Criteria) this;
        }

        public Criteria andJobSeekerIdIsNotNull() {
            addCriterion("job_seeker_id is not null");
            return (Criteria) this;
        }

        public Criteria andJobSeekerIdEqualTo(String value) {
            addCriterion("job_seeker_id =", value, "jobSeekerId");
            return (Criteria) this;
        }

        public Criteria andJobSeekerIdNotEqualTo(String value) {
            addCriterion("job_seeker_id <>", value, "jobSeekerId");
            return (Criteria) this;
        }

        public Criteria andJobSeekerIdGreaterThan(String value) {
            addCriterion("job_seeker_id >", value, "jobSeekerId");
            return (Criteria) this;
        }

        public Criteria andJobSeekerIdGreaterThanOrEqualTo(String value) {
            addCriterion("job_seeker_id >=", value, "jobSeekerId");
            return (Criteria) this;
        }

        public Criteria andJobSeekerIdLessThan(String value) {
            addCriterion("job_seeker_id <", value, "jobSeekerId");
            return (Criteria) this;
        }

        public Criteria andJobSeekerIdLessThanOrEqualTo(String value) {
            addCriterion("job_seeker_id <=", value, "jobSeekerId");
            return (Criteria) this;
        }

        public Criteria andJobSeekerIdLike(String value) {
            addCriterion("job_seeker_id like", value, "jobSeekerId");
            return (Criteria) this;
        }

        public Criteria andJobSeekerIdNotLike(String value) {
            addCriterion("job_seeker_id not like", value, "jobSeekerId");
            return (Criteria) this;
        }

        public Criteria andJobSeekerIdIn(List<String> values) {
            addCriterion("job_seeker_id in", values, "jobSeekerId");
            return (Criteria) this;
        }

        public Criteria andJobSeekerIdNotIn(List<String> values) {
            addCriterion("job_seeker_id not in", values, "jobSeekerId");
            return (Criteria) this;
        }

        public Criteria andJobSeekerIdBetween(String value1, String value2) {
            addCriterion("job_seeker_id between", value1, value2, "jobSeekerId");
            return (Criteria) this;
        }

        public Criteria andJobSeekerIdNotBetween(String value1, String value2) {
            addCriterion("job_seeker_id not between", value1, value2, "jobSeekerId");
            return (Criteria) this;
        }

        public Criteria andJobSeekerNameIsNull() {
            addCriterion("job_seeker_name is null");
            return (Criteria) this;
        }

        public Criteria andJobSeekerNameIsNotNull() {
            addCriterion("job_seeker_name is not null");
            return (Criteria) this;
        }

        public Criteria andJobSeekerNameEqualTo(String value) {
            addCriterion("job_seeker_name =", value, "jobSeekerName");
            return (Criteria) this;
        }

        public Criteria andJobSeekerNameNotEqualTo(String value) {
            addCriterion("job_seeker_name <>", value, "jobSeekerName");
            return (Criteria) this;
        }

        public Criteria andJobSeekerNameGreaterThan(String value) {
            addCriterion("job_seeker_name >", value, "jobSeekerName");
            return (Criteria) this;
        }

        public Criteria andJobSeekerNameGreaterThanOrEqualTo(String value) {
            addCriterion("job_seeker_name >=", value, "jobSeekerName");
            return (Criteria) this;
        }

        public Criteria andJobSeekerNameLessThan(String value) {
            addCriterion("job_seeker_name <", value, "jobSeekerName");
            return (Criteria) this;
        }

        public Criteria andJobSeekerNameLessThanOrEqualTo(String value) {
            addCriterion("job_seeker_name <=", value, "jobSeekerName");
            return (Criteria) this;
        }

        public Criteria andJobSeekerNameLike(String value) {
            addCriterion("job_seeker_name like", value, "jobSeekerName");
            return (Criteria) this;
        }

        public Criteria andJobSeekerNameNotLike(String value) {
            addCriterion("job_seeker_name not like", value, "jobSeekerName");
            return (Criteria) this;
        }

        public Criteria andJobSeekerNameIn(List<String> values) {
            addCriterion("job_seeker_name in", values, "jobSeekerName");
            return (Criteria) this;
        }

        public Criteria andJobSeekerNameNotIn(List<String> values) {
            addCriterion("job_seeker_name not in", values, "jobSeekerName");
            return (Criteria) this;
        }

        public Criteria andJobSeekerNameBetween(String value1, String value2) {
            addCriterion("job_seeker_name between", value1, value2, "jobSeekerName");
            return (Criteria) this;
        }

        public Criteria andJobSeekerNameNotBetween(String value1, String value2) {
            addCriterion("job_seeker_name not between", value1, value2, "jobSeekerName");
            return (Criteria) this;
        }

        public Criteria andJobSeekerSexIsNull() {
            addCriterion("job_seeker_sex is null");
            return (Criteria) this;
        }

        public Criteria andJobSeekerSexIsNotNull() {
            addCriterion("job_seeker_sex is not null");
            return (Criteria) this;
        }

        public Criteria andJobSeekerSexEqualTo(String value) {
            addCriterion("job_seeker_sex =", value, "jobSeekerSex");
            return (Criteria) this;
        }

        public Criteria andJobSeekerSexNotEqualTo(String value) {
            addCriterion("job_seeker_sex <>", value, "jobSeekerSex");
            return (Criteria) this;
        }

        public Criteria andJobSeekerSexGreaterThan(String value) {
            addCriterion("job_seeker_sex >", value, "jobSeekerSex");
            return (Criteria) this;
        }

        public Criteria andJobSeekerSexGreaterThanOrEqualTo(String value) {
            addCriterion("job_seeker_sex >=", value, "jobSeekerSex");
            return (Criteria) this;
        }

        public Criteria andJobSeekerSexLessThan(String value) {
            addCriterion("job_seeker_sex <", value, "jobSeekerSex");
            return (Criteria) this;
        }

        public Criteria andJobSeekerSexLessThanOrEqualTo(String value) {
            addCriterion("job_seeker_sex <=", value, "jobSeekerSex");
            return (Criteria) this;
        }

        public Criteria andJobSeekerSexLike(String value) {
            addCriterion("job_seeker_sex like", value, "jobSeekerSex");
            return (Criteria) this;
        }

        public Criteria andJobSeekerSexNotLike(String value) {
            addCriterion("job_seeker_sex not like", value, "jobSeekerSex");
            return (Criteria) this;
        }

        public Criteria andJobSeekerSexIn(List<String> values) {
            addCriterion("job_seeker_sex in", values, "jobSeekerSex");
            return (Criteria) this;
        }

        public Criteria andJobSeekerSexNotIn(List<String> values) {
            addCriterion("job_seeker_sex not in", values, "jobSeekerSex");
            return (Criteria) this;
        }

        public Criteria andJobSeekerSexBetween(String value1, String value2) {
            addCriterion("job_seeker_sex between", value1, value2, "jobSeekerSex");
            return (Criteria) this;
        }

        public Criteria andJobSeekerSexNotBetween(String value1, String value2) {
            addCriterion("job_seeker_sex not between", value1, value2, "jobSeekerSex");
            return (Criteria) this;
        }

        public Criteria andResumeNumIsNull() {
            addCriterion("resume_num is null");
            return (Criteria) this;
        }

        public Criteria andResumeNumIsNotNull() {
            addCriterion("resume_num is not null");
            return (Criteria) this;
        }

        public Criteria andResumeNumEqualTo(Integer value) {
            addCriterion("resume_num =", value, "resumeNum");
            return (Criteria) this;
        }

        public Criteria andResumeNumNotEqualTo(Integer value) {
            addCriterion("resume_num <>", value, "resumeNum");
            return (Criteria) this;
        }

        public Criteria andResumeNumGreaterThan(Integer value) {
            addCriterion("resume_num >", value, "resumeNum");
            return (Criteria) this;
        }

        public Criteria andResumeNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("resume_num >=", value, "resumeNum");
            return (Criteria) this;
        }

        public Criteria andResumeNumLessThan(Integer value) {
            addCriterion("resume_num <", value, "resumeNum");
            return (Criteria) this;
        }

        public Criteria andResumeNumLessThanOrEqualTo(Integer value) {
            addCriterion("resume_num <=", value, "resumeNum");
            return (Criteria) this;
        }

        public Criteria andResumeNumIn(List<Integer> values) {
            addCriterion("resume_num in", values, "resumeNum");
            return (Criteria) this;
        }

        public Criteria andResumeNumNotIn(List<Integer> values) {
            addCriterion("resume_num not in", values, "resumeNum");
            return (Criteria) this;
        }

        public Criteria andResumeNumBetween(Integer value1, Integer value2) {
            addCriterion("resume_num between", value1, value2, "resumeNum");
            return (Criteria) this;
        }

        public Criteria andResumeNumNotBetween(Integer value1, Integer value2) {
            addCriterion("resume_num not between", value1, value2, "resumeNum");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
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