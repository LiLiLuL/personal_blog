package com.chenxq.blog.personalBlog.Domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SystemLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SystemLogExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRequestipIsNull() {
            addCriterion("requestip is null");
            return (Criteria) this;
        }

        public Criteria andRequestipIsNotNull() {
            addCriterion("requestip is not null");
            return (Criteria) this;
        }

        public Criteria andRequestipEqualTo(String value) {
            addCriterion("requestip =", value, "requestip");
            return (Criteria) this;
        }

        public Criteria andRequestipNotEqualTo(String value) {
            addCriterion("requestip <>", value, "requestip");
            return (Criteria) this;
        }

        public Criteria andRequestipGreaterThan(String value) {
            addCriterion("requestip >", value, "requestip");
            return (Criteria) this;
        }

        public Criteria andRequestipGreaterThanOrEqualTo(String value) {
            addCriterion("requestip >=", value, "requestip");
            return (Criteria) this;
        }

        public Criteria andRequestipLessThan(String value) {
            addCriterion("requestip <", value, "requestip");
            return (Criteria) this;
        }

        public Criteria andRequestipLessThanOrEqualTo(String value) {
            addCriterion("requestip <=", value, "requestip");
            return (Criteria) this;
        }

        public Criteria andRequestipLike(String value) {
            addCriterion("requestip like", value, "requestip");
            return (Criteria) this;
        }

        public Criteria andRequestipNotLike(String value) {
            addCriterion("requestip not like", value, "requestip");
            return (Criteria) this;
        }

        public Criteria andRequestipIn(List<String> values) {
            addCriterion("requestip in", values, "requestip");
            return (Criteria) this;
        }

        public Criteria andRequestipNotIn(List<String> values) {
            addCriterion("requestip not in", values, "requestip");
            return (Criteria) this;
        }

        public Criteria andRequestipBetween(String value1, String value2) {
            addCriterion("requestip between", value1, value2, "requestip");
            return (Criteria) this;
        }

        public Criteria andRequestipNotBetween(String value1, String value2) {
            addCriterion("requestip not between", value1, value2, "requestip");
            return (Criteria) this;
        }

        public Criteria andOperate_typeIsNull() {
            addCriterion("operate_type is null");
            return (Criteria) this;
        }

        public Criteria andOperate_typeIsNotNull() {
            addCriterion("operate_type is not null");
            return (Criteria) this;
        }

        public Criteria andOperate_typeEqualTo(String value) {
            addCriterion("operate_type =", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeNotEqualTo(String value) {
            addCriterion("operate_type <>", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeGreaterThan(String value) {
            addCriterion("operate_type >", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeGreaterThanOrEqualTo(String value) {
            addCriterion("operate_type >=", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeLessThan(String value) {
            addCriterion("operate_type <", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeLessThanOrEqualTo(String value) {
            addCriterion("operate_type <=", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeLike(String value) {
            addCriterion("operate_type like", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeNotLike(String value) {
            addCriterion("operate_type not like", value, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeIn(List<String> values) {
            addCriterion("operate_type in", values, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeNotIn(List<String> values) {
            addCriterion("operate_type not in", values, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeBetween(String value1, String value2) {
            addCriterion("operate_type between", value1, value2, "operate_type");
            return (Criteria) this;
        }

        public Criteria andOperate_typeNotBetween(String value1, String value2) {
            addCriterion("operate_type not between", value1, value2, "operate_type");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userid like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userid not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andExceptioncodeIsNull() {
            addCriterion("exceptioncode is null");
            return (Criteria) this;
        }

        public Criteria andExceptioncodeIsNotNull() {
            addCriterion("exceptioncode is not null");
            return (Criteria) this;
        }

        public Criteria andExceptioncodeEqualTo(String value) {
            addCriterion("exceptioncode =", value, "exceptioncode");
            return (Criteria) this;
        }

        public Criteria andExceptioncodeNotEqualTo(String value) {
            addCriterion("exceptioncode <>", value, "exceptioncode");
            return (Criteria) this;
        }

        public Criteria andExceptioncodeGreaterThan(String value) {
            addCriterion("exceptioncode >", value, "exceptioncode");
            return (Criteria) this;
        }

        public Criteria andExceptioncodeGreaterThanOrEqualTo(String value) {
            addCriterion("exceptioncode >=", value, "exceptioncode");
            return (Criteria) this;
        }

        public Criteria andExceptioncodeLessThan(String value) {
            addCriterion("exceptioncode <", value, "exceptioncode");
            return (Criteria) this;
        }

        public Criteria andExceptioncodeLessThanOrEqualTo(String value) {
            addCriterion("exceptioncode <=", value, "exceptioncode");
            return (Criteria) this;
        }

        public Criteria andExceptioncodeLike(String value) {
            addCriterion("exceptioncode like", value, "exceptioncode");
            return (Criteria) this;
        }

        public Criteria andExceptioncodeNotLike(String value) {
            addCriterion("exceptioncode not like", value, "exceptioncode");
            return (Criteria) this;
        }

        public Criteria andExceptioncodeIn(List<String> values) {
            addCriterion("exceptioncode in", values, "exceptioncode");
            return (Criteria) this;
        }

        public Criteria andExceptioncodeNotIn(List<String> values) {
            addCriterion("exceptioncode not in", values, "exceptioncode");
            return (Criteria) this;
        }

        public Criteria andExceptioncodeBetween(String value1, String value2) {
            addCriterion("exceptioncode between", value1, value2, "exceptioncode");
            return (Criteria) this;
        }

        public Criteria andExceptioncodeNotBetween(String value1, String value2) {
            addCriterion("exceptioncode not between", value1, value2, "exceptioncode");
            return (Criteria) this;
        }

        public Criteria andExceptiondetailIsNull() {
            addCriterion("exceptiondetail is null");
            return (Criteria) this;
        }

        public Criteria andExceptiondetailIsNotNull() {
            addCriterion("exceptiondetail is not null");
            return (Criteria) this;
        }

        public Criteria andExceptiondetailEqualTo(String value) {
            addCriterion("exceptiondetail =", value, "exceptiondetail");
            return (Criteria) this;
        }

        public Criteria andExceptiondetailNotEqualTo(String value) {
            addCriterion("exceptiondetail <>", value, "exceptiondetail");
            return (Criteria) this;
        }

        public Criteria andExceptiondetailGreaterThan(String value) {
            addCriterion("exceptiondetail >", value, "exceptiondetail");
            return (Criteria) this;
        }

        public Criteria andExceptiondetailGreaterThanOrEqualTo(String value) {
            addCriterion("exceptiondetail >=", value, "exceptiondetail");
            return (Criteria) this;
        }

        public Criteria andExceptiondetailLessThan(String value) {
            addCriterion("exceptiondetail <", value, "exceptiondetail");
            return (Criteria) this;
        }

        public Criteria andExceptiondetailLessThanOrEqualTo(String value) {
            addCriterion("exceptiondetail <=", value, "exceptiondetail");
            return (Criteria) this;
        }

        public Criteria andExceptiondetailLike(String value) {
            addCriterion("exceptiondetail like", value, "exceptiondetail");
            return (Criteria) this;
        }

        public Criteria andExceptiondetailNotLike(String value) {
            addCriterion("exceptiondetail not like", value, "exceptiondetail");
            return (Criteria) this;
        }

        public Criteria andExceptiondetailIn(List<String> values) {
            addCriterion("exceptiondetail in", values, "exceptiondetail");
            return (Criteria) this;
        }

        public Criteria andExceptiondetailNotIn(List<String> values) {
            addCriterion("exceptiondetail not in", values, "exceptiondetail");
            return (Criteria) this;
        }

        public Criteria andExceptiondetailBetween(String value1, String value2) {
            addCriterion("exceptiondetail between", value1, value2, "exceptiondetail");
            return (Criteria) this;
        }

        public Criteria andExceptiondetailNotBetween(String value1, String value2) {
            addCriterion("exceptiondetail not between", value1, value2, "exceptiondetail");
            return (Criteria) this;
        }

        public Criteria andActiondateIsNull() {
            addCriterion("actiondate is null");
            return (Criteria) this;
        }

        public Criteria andActiondateIsNotNull() {
            addCriterion("actiondate is not null");
            return (Criteria) this;
        }

        public Criteria andActiondateEqualTo(Date value) {
            addCriterion("actiondate =", value, "actiondate");
            return (Criteria) this;
        }

        public Criteria andActiondateNotEqualTo(Date value) {
            addCriterion("actiondate <>", value, "actiondate");
            return (Criteria) this;
        }

        public Criteria andActiondateGreaterThan(Date value) {
            addCriterion("actiondate >", value, "actiondate");
            return (Criteria) this;
        }

        public Criteria andActiondateGreaterThanOrEqualTo(Date value) {
            addCriterion("actiondate >=", value, "actiondate");
            return (Criteria) this;
        }

        public Criteria andActiondateLessThan(Date value) {
            addCriterion("actiondate <", value, "actiondate");
            return (Criteria) this;
        }

        public Criteria andActiondateLessThanOrEqualTo(Date value) {
            addCriterion("actiondate <=", value, "actiondate");
            return (Criteria) this;
        }

        public Criteria andActiondateIn(List<Date> values) {
            addCriterion("actiondate in", values, "actiondate");
            return (Criteria) this;
        }

        public Criteria andActiondateNotIn(List<Date> values) {
            addCriterion("actiondate not in", values, "actiondate");
            return (Criteria) this;
        }

        public Criteria andActiondateBetween(Date value1, Date value2) {
            addCriterion("actiondate between", value1, value2, "actiondate");
            return (Criteria) this;
        }

        public Criteria andActiondateNotBetween(Date value1, Date value2) {
            addCriterion("actiondate not between", value1, value2, "actiondate");
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

        public Criteria andActionmethodIsNull() {
            addCriterion("actionmethod is null");
            return (Criteria) this;
        }

        public Criteria andActionmethodIsNotNull() {
            addCriterion("actionmethod is not null");
            return (Criteria) this;
        }

        public Criteria andActionmethodEqualTo(String value) {
            addCriterion("actionmethod =", value, "actionmethod");
            return (Criteria) this;
        }

        public Criteria andActionmethodNotEqualTo(String value) {
            addCriterion("actionmethod <>", value, "actionmethod");
            return (Criteria) this;
        }

        public Criteria andActionmethodGreaterThan(String value) {
            addCriterion("actionmethod >", value, "actionmethod");
            return (Criteria) this;
        }

        public Criteria andActionmethodGreaterThanOrEqualTo(String value) {
            addCriterion("actionmethod >=", value, "actionmethod");
            return (Criteria) this;
        }

        public Criteria andActionmethodLessThan(String value) {
            addCriterion("actionmethod <", value, "actionmethod");
            return (Criteria) this;
        }

        public Criteria andActionmethodLessThanOrEqualTo(String value) {
            addCriterion("actionmethod <=", value, "actionmethod");
            return (Criteria) this;
        }

        public Criteria andActionmethodLike(String value) {
            addCriterion("actionmethod like", value, "actionmethod");
            return (Criteria) this;
        }

        public Criteria andActionmethodNotLike(String value) {
            addCriterion("actionmethod not like", value, "actionmethod");
            return (Criteria) this;
        }

        public Criteria andActionmethodIn(List<String> values) {
            addCriterion("actionmethod in", values, "actionmethod");
            return (Criteria) this;
        }

        public Criteria andActionmethodNotIn(List<String> values) {
            addCriterion("actionmethod not in", values, "actionmethod");
            return (Criteria) this;
        }

        public Criteria andActionmethodBetween(String value1, String value2) {
            addCriterion("actionmethod between", value1, value2, "actionmethod");
            return (Criteria) this;
        }

        public Criteria andActionmethodNotBetween(String value1, String value2) {
            addCriterion("actionmethod not between", value1, value2, "actionmethod");
            return (Criteria) this;
        }

        public Criteria andParamsIsNull() {
            addCriterion("params is null");
            return (Criteria) this;
        }

        public Criteria andParamsIsNotNull() {
            addCriterion("params is not null");
            return (Criteria) this;
        }

        public Criteria andParamsEqualTo(String value) {
            addCriterion("params =", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotEqualTo(String value) {
            addCriterion("params <>", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsGreaterThan(String value) {
            addCriterion("params >", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsGreaterThanOrEqualTo(String value) {
            addCriterion("params >=", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsLessThan(String value) {
            addCriterion("params <", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsLessThanOrEqualTo(String value) {
            addCriterion("params <=", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsLike(String value) {
            addCriterion("params like", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotLike(String value) {
            addCriterion("params not like", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsIn(List<String> values) {
            addCriterion("params in", values, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotIn(List<String> values) {
            addCriterion("params not in", values, "params");
            return (Criteria) this;
        }

        public Criteria andParamsBetween(String value1, String value2) {
            addCriterion("params between", value1, value2, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotBetween(String value1, String value2) {
            addCriterion("params not between", value1, value2, "params");
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