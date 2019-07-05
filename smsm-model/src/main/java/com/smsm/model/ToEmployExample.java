package com.smsm.model;

import java.util.ArrayList;
import java.util.List;

public class ToEmployExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ToEmployExample() {
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

        public Criteria andResumeIdIsNull() {
            addCriterion("resume_id is null");
            return (Criteria) this;
        }

        public Criteria andResumeIdIsNotNull() {
            addCriterion("resume_id is not null");
            return (Criteria) this;
        }

        public Criteria andResumeIdEqualTo(String value) {
            addCriterion("resume_id =", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdNotEqualTo(String value) {
            addCriterion("resume_id <>", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdGreaterThan(String value) {
            addCriterion("resume_id >", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdGreaterThanOrEqualTo(String value) {
            addCriterion("resume_id >=", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdLessThan(String value) {
            addCriterion("resume_id <", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdLessThanOrEqualTo(String value) {
            addCriterion("resume_id <=", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdLike(String value) {
            addCriterion("resume_id like", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdNotLike(String value) {
            addCriterion("resume_id not like", value, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdIn(List<String> values) {
            addCriterion("resume_id in", values, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdNotIn(List<String> values) {
            addCriterion("resume_id not in", values, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdBetween(String value1, String value2) {
            addCriterion("resume_id between", value1, value2, "resumeId");
            return (Criteria) this;
        }

        public Criteria andResumeIdNotBetween(String value1, String value2) {
            addCriterion("resume_id not between", value1, value2, "resumeId");
            return (Criteria) this;
        }

        public Criteria andJobIdIsNull() {
            addCriterion("job_id is null");
            return (Criteria) this;
        }

        public Criteria andJobIdIsNotNull() {
            addCriterion("job_id is not null");
            return (Criteria) this;
        }

        public Criteria andJobIdEqualTo(String value) {
            addCriterion("job_id =", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotEqualTo(String value) {
            addCriterion("job_id <>", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdGreaterThan(String value) {
            addCriterion("job_id >", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdGreaterThanOrEqualTo(String value) {
            addCriterion("job_id >=", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdLessThan(String value) {
            addCriterion("job_id <", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdLessThanOrEqualTo(String value) {
            addCriterion("job_id <=", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdLike(String value) {
            addCriterion("job_id like", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotLike(String value) {
            addCriterion("job_id not like", value, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdIn(List<String> values) {
            addCriterion("job_id in", values, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotIn(List<String> values) {
            addCriterion("job_id not in", values, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdBetween(String value1, String value2) {
            addCriterion("job_id between", value1, value2, "jobId");
            return (Criteria) this;
        }

        public Criteria andJobIdNotBetween(String value1, String value2) {
            addCriterion("job_id not between", value1, value2, "jobId");
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

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andExceptionSalaryIsNull() {
            addCriterion("exception_salary is null");
            return (Criteria) this;
        }

        public Criteria andExceptionSalaryIsNotNull() {
            addCriterion("exception_salary is not null");
            return (Criteria) this;
        }

        public Criteria andExceptionSalaryEqualTo(Integer value) {
            addCriterion("exception_salary =", value, "exceptionSalary");
            return (Criteria) this;
        }

        public Criteria andExceptionSalaryNotEqualTo(Integer value) {
            addCriterion("exception_salary <>", value, "exceptionSalary");
            return (Criteria) this;
        }

        public Criteria andExceptionSalaryGreaterThan(Integer value) {
            addCriterion("exception_salary >", value, "exceptionSalary");
            return (Criteria) this;
        }

        public Criteria andExceptionSalaryGreaterThanOrEqualTo(Integer value) {
            addCriterion("exception_salary >=", value, "exceptionSalary");
            return (Criteria) this;
        }

        public Criteria andExceptionSalaryLessThan(Integer value) {
            addCriterion("exception_salary <", value, "exceptionSalary");
            return (Criteria) this;
        }

        public Criteria andExceptionSalaryLessThanOrEqualTo(Integer value) {
            addCriterion("exception_salary <=", value, "exceptionSalary");
            return (Criteria) this;
        }

        public Criteria andExceptionSalaryIn(List<Integer> values) {
            addCriterion("exception_salary in", values, "exceptionSalary");
            return (Criteria) this;
        }

        public Criteria andExceptionSalaryNotIn(List<Integer> values) {
            addCriterion("exception_salary not in", values, "exceptionSalary");
            return (Criteria) this;
        }

        public Criteria andExceptionSalaryBetween(Integer value1, Integer value2) {
            addCriterion("exception_salary between", value1, value2, "exceptionSalary");
            return (Criteria) this;
        }

        public Criteria andExceptionSalaryNotBetween(Integer value1, Integer value2) {
            addCriterion("exception_salary not between", value1, value2, "exceptionSalary");
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