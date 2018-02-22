package com.way.waybillsystem.entity;

import java.util.ArrayList;
import java.util.List;

public class FeeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FeeExample() {
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

        public Criteria andFeeIdIsNull() {
            addCriterion("fee_id is null");
            return (Criteria) this;
        }

        public Criteria andFeeIdIsNotNull() {
            addCriterion("fee_id is not null");
            return (Criteria) this;
        }

        public Criteria andFeeIdEqualTo(Integer value) {
            addCriterion("fee_id =", value, "feeId");
            return (Criteria) this;
        }

        public Criteria andFeeIdNotEqualTo(Integer value) {
            addCriterion("fee_id <>", value, "feeId");
            return (Criteria) this;
        }

        public Criteria andFeeIdGreaterThan(Integer value) {
            addCriterion("fee_id >", value, "feeId");
            return (Criteria) this;
        }

        public Criteria andFeeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("fee_id >=", value, "feeId");
            return (Criteria) this;
        }

        public Criteria andFeeIdLessThan(Integer value) {
            addCriterion("fee_id <", value, "feeId");
            return (Criteria) this;
        }

        public Criteria andFeeIdLessThanOrEqualTo(Integer value) {
            addCriterion("fee_id <=", value, "feeId");
            return (Criteria) this;
        }

        public Criteria andFeeIdIn(List<Integer> values) {
            addCriterion("fee_id in", values, "feeId");
            return (Criteria) this;
        }

        public Criteria andFeeIdNotIn(List<Integer> values) {
            addCriterion("fee_id not in", values, "feeId");
            return (Criteria) this;
        }

        public Criteria andFeeIdBetween(Integer value1, Integer value2) {
            addCriterion("fee_id between", value1, value2, "feeId");
            return (Criteria) this;
        }

        public Criteria andFeeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("fee_id not between", value1, value2, "feeId");
            return (Criteria) this;
        }

        public Criteria andLocationSendIsNull() {
            addCriterion("location_send is null");
            return (Criteria) this;
        }

        public Criteria andLocationSendIsNotNull() {
            addCriterion("location_send is not null");
            return (Criteria) this;
        }

        public Criteria andLocationSendEqualTo(Integer value) {
            addCriterion("location_send =", value, "locationSend");
            return (Criteria) this;
        }

        public Criteria andLocationSendNotEqualTo(Integer value) {
            addCriterion("location_send <>", value, "locationSend");
            return (Criteria) this;
        }

        public Criteria andLocationSendGreaterThan(Integer value) {
            addCriterion("location_send >", value, "locationSend");
            return (Criteria) this;
        }

        public Criteria andLocationSendGreaterThanOrEqualTo(Integer value) {
            addCriterion("location_send >=", value, "locationSend");
            return (Criteria) this;
        }

        public Criteria andLocationSendLessThan(Integer value) {
            addCriterion("location_send <", value, "locationSend");
            return (Criteria) this;
        }

        public Criteria andLocationSendLessThanOrEqualTo(Integer value) {
            addCriterion("location_send <=", value, "locationSend");
            return (Criteria) this;
        }

        public Criteria andLocationSendIn(List<Integer> values) {
            addCriterion("location_send in", values, "locationSend");
            return (Criteria) this;
        }

        public Criteria andLocationSendNotIn(List<Integer> values) {
            addCriterion("location_send not in", values, "locationSend");
            return (Criteria) this;
        }

        public Criteria andLocationSendBetween(Integer value1, Integer value2) {
            addCriterion("location_send between", value1, value2, "locationSend");
            return (Criteria) this;
        }

        public Criteria andLocationSendNotBetween(Integer value1, Integer value2) {
            addCriterion("location_send not between", value1, value2, "locationSend");
            return (Criteria) this;
        }

        public Criteria andLoacationReceiveIsNull() {
            addCriterion("loacation_receive is null");
            return (Criteria) this;
        }

        public Criteria andLoacationReceiveIsNotNull() {
            addCriterion("loacation_receive is not null");
            return (Criteria) this;
        }

        public Criteria andLoacationReceiveEqualTo(Integer value) {
            addCriterion("loacation_receive =", value, "loacationReceive");
            return (Criteria) this;
        }

        public Criteria andLoacationReceiveNotEqualTo(Integer value) {
            addCriterion("loacation_receive <>", value, "loacationReceive");
            return (Criteria) this;
        }

        public Criteria andLoacationReceiveGreaterThan(Integer value) {
            addCriterion("loacation_receive >", value, "loacationReceive");
            return (Criteria) this;
        }

        public Criteria andLoacationReceiveGreaterThanOrEqualTo(Integer value) {
            addCriterion("loacation_receive >=", value, "loacationReceive");
            return (Criteria) this;
        }

        public Criteria andLoacationReceiveLessThan(Integer value) {
            addCriterion("loacation_receive <", value, "loacationReceive");
            return (Criteria) this;
        }

        public Criteria andLoacationReceiveLessThanOrEqualTo(Integer value) {
            addCriterion("loacation_receive <=", value, "loacationReceive");
            return (Criteria) this;
        }

        public Criteria andLoacationReceiveIn(List<Integer> values) {
            addCriterion("loacation_receive in", values, "loacationReceive");
            return (Criteria) this;
        }

        public Criteria andLoacationReceiveNotIn(List<Integer> values) {
            addCriterion("loacation_receive not in", values, "loacationReceive");
            return (Criteria) this;
        }

        public Criteria andLoacationReceiveBetween(Integer value1, Integer value2) {
            addCriterion("loacation_receive between", value1, value2, "loacationReceive");
            return (Criteria) this;
        }

        public Criteria andLoacationReceiveNotBetween(Integer value1, Integer value2) {
            addCriterion("loacation_receive not between", value1, value2, "loacationReceive");
            return (Criteria) this;
        }

        public Criteria andFeeIsNull() {
            addCriterion("fee is null");
            return (Criteria) this;
        }

        public Criteria andFeeIsNotNull() {
            addCriterion("fee is not null");
            return (Criteria) this;
        }

        public Criteria andFeeEqualTo(Long value) {
            addCriterion("fee =", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotEqualTo(Long value) {
            addCriterion("fee <>", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThan(Long value) {
            addCriterion("fee >", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("fee >=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThan(Long value) {
            addCriterion("fee <", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThanOrEqualTo(Long value) {
            addCriterion("fee <=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeIn(List<Long> values) {
            addCriterion("fee in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotIn(List<Long> values) {
            addCriterion("fee not in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeBetween(Long value1, Long value2) {
            addCriterion("fee between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotBetween(Long value1, Long value2) {
            addCriterion("fee not between", value1, value2, "fee");
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