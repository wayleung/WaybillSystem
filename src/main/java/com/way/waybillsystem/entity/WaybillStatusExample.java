package com.way.waybillsystem.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WaybillStatusExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WaybillStatusExample() {
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

        public Criteria andWsIdIsNull() {
            addCriterion("ws_id is null");
            return (Criteria) this;
        }

        public Criteria andWsIdIsNotNull() {
            addCriterion("ws_id is not null");
            return (Criteria) this;
        }

        public Criteria andWsIdEqualTo(Long value) {
            addCriterion("ws_id =", value, "wsId");
            return (Criteria) this;
        }

        public Criteria andWsIdNotEqualTo(Long value) {
            addCriterion("ws_id <>", value, "wsId");
            return (Criteria) this;
        }

        public Criteria andWsIdGreaterThan(Long value) {
            addCriterion("ws_id >", value, "wsId");
            return (Criteria) this;
        }

        public Criteria andWsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ws_id >=", value, "wsId");
            return (Criteria) this;
        }

        public Criteria andWsIdLessThan(Long value) {
            addCriterion("ws_id <", value, "wsId");
            return (Criteria) this;
        }

        public Criteria andWsIdLessThanOrEqualTo(Long value) {
            addCriterion("ws_id <=", value, "wsId");
            return (Criteria) this;
        }

        public Criteria andWsIdIn(List<Long> values) {
            addCriterion("ws_id in", values, "wsId");
            return (Criteria) this;
        }

        public Criteria andWsIdNotIn(List<Long> values) {
            addCriterion("ws_id not in", values, "wsId");
            return (Criteria) this;
        }

        public Criteria andWsIdBetween(Long value1, Long value2) {
            addCriterion("ws_id between", value1, value2, "wsId");
            return (Criteria) this;
        }

        public Criteria andWsIdNotBetween(Long value1, Long value2) {
            addCriterion("ws_id not between", value1, value2, "wsId");
            return (Criteria) this;
        }

        public Criteria andWaybillNumberIsNull() {
            addCriterion("waybill_number is null");
            return (Criteria) this;
        }

        public Criteria andWaybillNumberIsNotNull() {
            addCriterion("waybill_number is not null");
            return (Criteria) this;
        }

        public Criteria andWaybillNumberEqualTo(Long value) {
            addCriterion("waybill_number =", value, "waybillNumber");
            return (Criteria) this;
        }

        public Criteria andWaybillNumberNotEqualTo(Long value) {
            addCriterion("waybill_number <>", value, "waybillNumber");
            return (Criteria) this;
        }

        public Criteria andWaybillNumberGreaterThan(Long value) {
            addCriterion("waybill_number >", value, "waybillNumber");
            return (Criteria) this;
        }

        public Criteria andWaybillNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("waybill_number >=", value, "waybillNumber");
            return (Criteria) this;
        }

        public Criteria andWaybillNumberLessThan(Long value) {
            addCriterion("waybill_number <", value, "waybillNumber");
            return (Criteria) this;
        }

        public Criteria andWaybillNumberLessThanOrEqualTo(Long value) {
            addCriterion("waybill_number <=", value, "waybillNumber");
            return (Criteria) this;
        }

        public Criteria andWaybillNumberIn(List<Long> values) {
            addCriterion("waybill_number in", values, "waybillNumber");
            return (Criteria) this;
        }

        public Criteria andWaybillNumberNotIn(List<Long> values) {
            addCriterion("waybill_number not in", values, "waybillNumber");
            return (Criteria) this;
        }

        public Criteria andWaybillNumberBetween(Long value1, Long value2) {
            addCriterion("waybill_number between", value1, value2, "waybillNumber");
            return (Criteria) this;
        }

        public Criteria andWaybillNumberNotBetween(Long value1, Long value2) {
            addCriterion("waybill_number not between", value1, value2, "waybillNumber");
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

        public Criteria andLocationNowIsNull() {
            addCriterion("location_now is null");
            return (Criteria) this;
        }

        public Criteria andLocationNowIsNotNull() {
            addCriterion("location_now is not null");
            return (Criteria) this;
        }

        public Criteria andLocationNowEqualTo(Integer value) {
            addCriterion("location_now =", value, "locationNow");
            return (Criteria) this;
        }

        public Criteria andLocationNowNotEqualTo(Integer value) {
            addCriterion("location_now <>", value, "locationNow");
            return (Criteria) this;
        }

        public Criteria andLocationNowGreaterThan(Integer value) {
            addCriterion("location_now >", value, "locationNow");
            return (Criteria) this;
        }

        public Criteria andLocationNowGreaterThanOrEqualTo(Integer value) {
            addCriterion("location_now >=", value, "locationNow");
            return (Criteria) this;
        }

        public Criteria andLocationNowLessThan(Integer value) {
            addCriterion("location_now <", value, "locationNow");
            return (Criteria) this;
        }

        public Criteria andLocationNowLessThanOrEqualTo(Integer value) {
            addCriterion("location_now <=", value, "locationNow");
            return (Criteria) this;
        }

        public Criteria andLocationNowIn(List<Integer> values) {
            addCriterion("location_now in", values, "locationNow");
            return (Criteria) this;
        }

        public Criteria andLocationNowNotIn(List<Integer> values) {
            addCriterion("location_now not in", values, "locationNow");
            return (Criteria) this;
        }

        public Criteria andLocationNowBetween(Integer value1, Integer value2) {
            addCriterion("location_now between", value1, value2, "locationNow");
            return (Criteria) this;
        }

        public Criteria andLocationNowNotBetween(Integer value1, Integer value2) {
            addCriterion("location_now not between", value1, value2, "locationNow");
            return (Criteria) this;
        }

        public Criteria andLacationTimeIsNull() {
            addCriterion("lacation_time is null");
            return (Criteria) this;
        }

        public Criteria andLacationTimeIsNotNull() {
            addCriterion("lacation_time is not null");
            return (Criteria) this;
        }

        public Criteria andLacationTimeEqualTo(Date value) {
            addCriterion("lacation_time =", value, "lacationTime");
            return (Criteria) this;
        }

        public Criteria andLacationTimeNotEqualTo(Date value) {
            addCriterion("lacation_time <>", value, "lacationTime");
            return (Criteria) this;
        }

        public Criteria andLacationTimeGreaterThan(Date value) {
            addCriterion("lacation_time >", value, "lacationTime");
            return (Criteria) this;
        }

        public Criteria andLacationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lacation_time >=", value, "lacationTime");
            return (Criteria) this;
        }

        public Criteria andLacationTimeLessThan(Date value) {
            addCriterion("lacation_time <", value, "lacationTime");
            return (Criteria) this;
        }

        public Criteria andLacationTimeLessThanOrEqualTo(Date value) {
            addCriterion("lacation_time <=", value, "lacationTime");
            return (Criteria) this;
        }

        public Criteria andLacationTimeIn(List<Date> values) {
            addCriterion("lacation_time in", values, "lacationTime");
            return (Criteria) this;
        }

        public Criteria andLacationTimeNotIn(List<Date> values) {
            addCriterion("lacation_time not in", values, "lacationTime");
            return (Criteria) this;
        }

        public Criteria andLacationTimeBetween(Date value1, Date value2) {
            addCriterion("lacation_time between", value1, value2, "lacationTime");
            return (Criteria) this;
        }

        public Criteria andLacationTimeNotBetween(Date value1, Date value2) {
            addCriterion("lacation_time not between", value1, value2, "lacationTime");
            return (Criteria) this;
        }

        public Criteria andEmployeeChargeIsNull() {
            addCriterion("employee_charge is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeChargeIsNotNull() {
            addCriterion("employee_charge is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeChargeEqualTo(Long value) {
            addCriterion("employee_charge =", value, "employeeCharge");
            return (Criteria) this;
        }

        public Criteria andEmployeeChargeNotEqualTo(Long value) {
            addCriterion("employee_charge <>", value, "employeeCharge");
            return (Criteria) this;
        }

        public Criteria andEmployeeChargeGreaterThan(Long value) {
            addCriterion("employee_charge >", value, "employeeCharge");
            return (Criteria) this;
        }

        public Criteria andEmployeeChargeGreaterThanOrEqualTo(Long value) {
            addCriterion("employee_charge >=", value, "employeeCharge");
            return (Criteria) this;
        }

        public Criteria andEmployeeChargeLessThan(Long value) {
            addCriterion("employee_charge <", value, "employeeCharge");
            return (Criteria) this;
        }

        public Criteria andEmployeeChargeLessThanOrEqualTo(Long value) {
            addCriterion("employee_charge <=", value, "employeeCharge");
            return (Criteria) this;
        }

        public Criteria andEmployeeChargeIn(List<Long> values) {
            addCriterion("employee_charge in", values, "employeeCharge");
            return (Criteria) this;
        }

        public Criteria andEmployeeChargeNotIn(List<Long> values) {
            addCriterion("employee_charge not in", values, "employeeCharge");
            return (Criteria) this;
        }

        public Criteria andEmployeeChargeBetween(Long value1, Long value2) {
            addCriterion("employee_charge between", value1, value2, "employeeCharge");
            return (Criteria) this;
        }

        public Criteria andEmployeeChargeNotBetween(Long value1, Long value2) {
            addCriterion("employee_charge not between", value1, value2, "employeeCharge");
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