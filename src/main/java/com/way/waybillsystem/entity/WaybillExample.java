package com.way.waybillsystem.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WaybillExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WaybillExample() {
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

        public Criteria andWsIdNewestIsNull() {
            addCriterion("ws_id_newest is null");
            return (Criteria) this;
        }

        public Criteria andWsIdNewestIsNotNull() {
            addCriterion("ws_id_newest is not null");
            return (Criteria) this;
        }

        public Criteria andWsIdNewestEqualTo(Long value) {
            addCriterion("ws_id_newest =", value, "wsIdNewest");
            return (Criteria) this;
        }

        public Criteria andWsIdNewestNotEqualTo(Long value) {
            addCriterion("ws_id_newest <>", value, "wsIdNewest");
            return (Criteria) this;
        }

        public Criteria andWsIdNewestGreaterThan(Long value) {
            addCriterion("ws_id_newest >", value, "wsIdNewest");
            return (Criteria) this;
        }

        public Criteria andWsIdNewestGreaterThanOrEqualTo(Long value) {
            addCriterion("ws_id_newest >=", value, "wsIdNewest");
            return (Criteria) this;
        }

        public Criteria andWsIdNewestLessThan(Long value) {
            addCriterion("ws_id_newest <", value, "wsIdNewest");
            return (Criteria) this;
        }

        public Criteria andWsIdNewestLessThanOrEqualTo(Long value) {
            addCriterion("ws_id_newest <=", value, "wsIdNewest");
            return (Criteria) this;
        }

        public Criteria andWsIdNewestIn(List<Long> values) {
            addCriterion("ws_id_newest in", values, "wsIdNewest");
            return (Criteria) this;
        }

        public Criteria andWsIdNewestNotIn(List<Long> values) {
            addCriterion("ws_id_newest not in", values, "wsIdNewest");
            return (Criteria) this;
        }

        public Criteria andWsIdNewestBetween(Long value1, Long value2) {
            addCriterion("ws_id_newest between", value1, value2, "wsIdNewest");
            return (Criteria) this;
        }

        public Criteria andWsIdNewestNotBetween(Long value1, Long value2) {
            addCriterion("ws_id_newest not between", value1, value2, "wsIdNewest");
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

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andFromNameIsNull() {
            addCriterion("from_name is null");
            return (Criteria) this;
        }

        public Criteria andFromNameIsNotNull() {
            addCriterion("from_name is not null");
            return (Criteria) this;
        }

        public Criteria andFromNameEqualTo(String value) {
            addCriterion("from_name =", value, "fromName");
            return (Criteria) this;
        }

        public Criteria andFromNameNotEqualTo(String value) {
            addCriterion("from_name <>", value, "fromName");
            return (Criteria) this;
        }

        public Criteria andFromNameGreaterThan(String value) {
            addCriterion("from_name >", value, "fromName");
            return (Criteria) this;
        }

        public Criteria andFromNameGreaterThanOrEqualTo(String value) {
            addCriterion("from_name >=", value, "fromName");
            return (Criteria) this;
        }

        public Criteria andFromNameLessThan(String value) {
            addCriterion("from_name <", value, "fromName");
            return (Criteria) this;
        }

        public Criteria andFromNameLessThanOrEqualTo(String value) {
            addCriterion("from_name <=", value, "fromName");
            return (Criteria) this;
        }

        public Criteria andFromNameLike(String value) {
            addCriterion("from_name like", value, "fromName");
            return (Criteria) this;
        }

        public Criteria andFromNameNotLike(String value) {
            addCriterion("from_name not like", value, "fromName");
            return (Criteria) this;
        }

        public Criteria andFromNameIn(List<String> values) {
            addCriterion("from_name in", values, "fromName");
            return (Criteria) this;
        }

        public Criteria andFromNameNotIn(List<String> values) {
            addCriterion("from_name not in", values, "fromName");
            return (Criteria) this;
        }

        public Criteria andFromNameBetween(String value1, String value2) {
            addCriterion("from_name between", value1, value2, "fromName");
            return (Criteria) this;
        }

        public Criteria andFromNameNotBetween(String value1, String value2) {
            addCriterion("from_name not between", value1, value2, "fromName");
            return (Criteria) this;
        }

        public Criteria andDepartureIsNull() {
            addCriterion("departure is null");
            return (Criteria) this;
        }

        public Criteria andDepartureIsNotNull() {
            addCriterion("departure is not null");
            return (Criteria) this;
        }

        public Criteria andDepartureEqualTo(String value) {
            addCriterion("departure =", value, "departure");
            return (Criteria) this;
        }

        public Criteria andDepartureNotEqualTo(String value) {
            addCriterion("departure <>", value, "departure");
            return (Criteria) this;
        }

        public Criteria andDepartureGreaterThan(String value) {
            addCriterion("departure >", value, "departure");
            return (Criteria) this;
        }

        public Criteria andDepartureGreaterThanOrEqualTo(String value) {
            addCriterion("departure >=", value, "departure");
            return (Criteria) this;
        }

        public Criteria andDepartureLessThan(String value) {
            addCriterion("departure <", value, "departure");
            return (Criteria) this;
        }

        public Criteria andDepartureLessThanOrEqualTo(String value) {
            addCriterion("departure <=", value, "departure");
            return (Criteria) this;
        }

        public Criteria andDepartureLike(String value) {
            addCriterion("departure like", value, "departure");
            return (Criteria) this;
        }

        public Criteria andDepartureNotLike(String value) {
            addCriterion("departure not like", value, "departure");
            return (Criteria) this;
        }

        public Criteria andDepartureIn(List<String> values) {
            addCriterion("departure in", values, "departure");
            return (Criteria) this;
        }

        public Criteria andDepartureNotIn(List<String> values) {
            addCriterion("departure not in", values, "departure");
            return (Criteria) this;
        }

        public Criteria andDepartureBetween(String value1, String value2) {
            addCriterion("departure between", value1, value2, "departure");
            return (Criteria) this;
        }

        public Criteria andDepartureNotBetween(String value1, String value2) {
            addCriterion("departure not between", value1, value2, "departure");
            return (Criteria) this;
        }

        public Criteria andSendDateIsNull() {
            addCriterion("send_date is null");
            return (Criteria) this;
        }

        public Criteria andSendDateIsNotNull() {
            addCriterion("send_date is not null");
            return (Criteria) this;
        }

        public Criteria andSendDateEqualTo(Date value) {
            addCriterion("send_date =", value, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateNotEqualTo(Date value) {
            addCriterion("send_date <>", value, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateGreaterThan(Date value) {
            addCriterion("send_date >", value, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateGreaterThanOrEqualTo(Date value) {
            addCriterion("send_date >=", value, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateLessThan(Date value) {
            addCriterion("send_date <", value, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateLessThanOrEqualTo(Date value) {
            addCriterion("send_date <=", value, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateIn(List<Date> values) {
            addCriterion("send_date in", values, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateNotIn(List<Date> values) {
            addCriterion("send_date not in", values, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateBetween(Date value1, Date value2) {
            addCriterion("send_date between", value1, value2, "sendDate");
            return (Criteria) this;
        }

        public Criteria andSendDateNotBetween(Date value1, Date value2) {
            addCriterion("send_date not between", value1, value2, "sendDate");
            return (Criteria) this;
        }

        public Criteria andFromCompanyNameIsNull() {
            addCriterion("from_company_name is null");
            return (Criteria) this;
        }

        public Criteria andFromCompanyNameIsNotNull() {
            addCriterion("from_company_name is not null");
            return (Criteria) this;
        }

        public Criteria andFromCompanyNameEqualTo(String value) {
            addCriterion("from_company_name =", value, "fromCompanyName");
            return (Criteria) this;
        }

        public Criteria andFromCompanyNameNotEqualTo(String value) {
            addCriterion("from_company_name <>", value, "fromCompanyName");
            return (Criteria) this;
        }

        public Criteria andFromCompanyNameGreaterThan(String value) {
            addCriterion("from_company_name >", value, "fromCompanyName");
            return (Criteria) this;
        }

        public Criteria andFromCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("from_company_name >=", value, "fromCompanyName");
            return (Criteria) this;
        }

        public Criteria andFromCompanyNameLessThan(String value) {
            addCriterion("from_company_name <", value, "fromCompanyName");
            return (Criteria) this;
        }

        public Criteria andFromCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("from_company_name <=", value, "fromCompanyName");
            return (Criteria) this;
        }

        public Criteria andFromCompanyNameLike(String value) {
            addCriterion("from_company_name like", value, "fromCompanyName");
            return (Criteria) this;
        }

        public Criteria andFromCompanyNameNotLike(String value) {
            addCriterion("from_company_name not like", value, "fromCompanyName");
            return (Criteria) this;
        }

        public Criteria andFromCompanyNameIn(List<String> values) {
            addCriterion("from_company_name in", values, "fromCompanyName");
            return (Criteria) this;
        }

        public Criteria andFromCompanyNameNotIn(List<String> values) {
            addCriterion("from_company_name not in", values, "fromCompanyName");
            return (Criteria) this;
        }

        public Criteria andFromCompanyNameBetween(String value1, String value2) {
            addCriterion("from_company_name between", value1, value2, "fromCompanyName");
            return (Criteria) this;
        }

        public Criteria andFromCompanyNameNotBetween(String value1, String value2) {
            addCriterion("from_company_name not between", value1, value2, "fromCompanyName");
            return (Criteria) this;
        }

        public Criteria andFromAddressIsNull() {
            addCriterion("from_address is null");
            return (Criteria) this;
        }

        public Criteria andFromAddressIsNotNull() {
            addCriterion("from_address is not null");
            return (Criteria) this;
        }

        public Criteria andFromAddressEqualTo(String value) {
            addCriterion("from_address =", value, "fromAddress");
            return (Criteria) this;
        }

        public Criteria andFromAddressNotEqualTo(String value) {
            addCriterion("from_address <>", value, "fromAddress");
            return (Criteria) this;
        }

        public Criteria andFromAddressGreaterThan(String value) {
            addCriterion("from_address >", value, "fromAddress");
            return (Criteria) this;
        }

        public Criteria andFromAddressGreaterThanOrEqualTo(String value) {
            addCriterion("from_address >=", value, "fromAddress");
            return (Criteria) this;
        }

        public Criteria andFromAddressLessThan(String value) {
            addCriterion("from_address <", value, "fromAddress");
            return (Criteria) this;
        }

        public Criteria andFromAddressLessThanOrEqualTo(String value) {
            addCriterion("from_address <=", value, "fromAddress");
            return (Criteria) this;
        }

        public Criteria andFromAddressLike(String value) {
            addCriterion("from_address like", value, "fromAddress");
            return (Criteria) this;
        }

        public Criteria andFromAddressNotLike(String value) {
            addCriterion("from_address not like", value, "fromAddress");
            return (Criteria) this;
        }

        public Criteria andFromAddressIn(List<String> values) {
            addCriterion("from_address in", values, "fromAddress");
            return (Criteria) this;
        }

        public Criteria andFromAddressNotIn(List<String> values) {
            addCriterion("from_address not in", values, "fromAddress");
            return (Criteria) this;
        }

        public Criteria andFromAddressBetween(String value1, String value2) {
            addCriterion("from_address between", value1, value2, "fromAddress");
            return (Criteria) this;
        }

        public Criteria andFromAddressNotBetween(String value1, String value2) {
            addCriterion("from_address not between", value1, value2, "fromAddress");
            return (Criteria) this;
        }

        public Criteria andFromPhoneIsNull() {
            addCriterion("from_phone is null");
            return (Criteria) this;
        }

        public Criteria andFromPhoneIsNotNull() {
            addCriterion("from_phone is not null");
            return (Criteria) this;
        }

        public Criteria andFromPhoneEqualTo(String value) {
            addCriterion("from_phone =", value, "fromPhone");
            return (Criteria) this;
        }

        public Criteria andFromPhoneNotEqualTo(String value) {
            addCriterion("from_phone <>", value, "fromPhone");
            return (Criteria) this;
        }

        public Criteria andFromPhoneGreaterThan(String value) {
            addCriterion("from_phone >", value, "fromPhone");
            return (Criteria) this;
        }

        public Criteria andFromPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("from_phone >=", value, "fromPhone");
            return (Criteria) this;
        }

        public Criteria andFromPhoneLessThan(String value) {
            addCriterion("from_phone <", value, "fromPhone");
            return (Criteria) this;
        }

        public Criteria andFromPhoneLessThanOrEqualTo(String value) {
            addCriterion("from_phone <=", value, "fromPhone");
            return (Criteria) this;
        }

        public Criteria andFromPhoneLike(String value) {
            addCriterion("from_phone like", value, "fromPhone");
            return (Criteria) this;
        }

        public Criteria andFromPhoneNotLike(String value) {
            addCriterion("from_phone not like", value, "fromPhone");
            return (Criteria) this;
        }

        public Criteria andFromPhoneIn(List<String> values) {
            addCriterion("from_phone in", values, "fromPhone");
            return (Criteria) this;
        }

        public Criteria andFromPhoneNotIn(List<String> values) {
            addCriterion("from_phone not in", values, "fromPhone");
            return (Criteria) this;
        }

        public Criteria andFromPhoneBetween(String value1, String value2) {
            addCriterion("from_phone between", value1, value2, "fromPhone");
            return (Criteria) this;
        }

        public Criteria andFromPhoneNotBetween(String value1, String value2) {
            addCriterion("from_phone not between", value1, value2, "fromPhone");
            return (Criteria) this;
        }

        public Criteria andIsMsgIsNull() {
            addCriterion("is_msg is null");
            return (Criteria) this;
        }

        public Criteria andIsMsgIsNotNull() {
            addCriterion("is_msg is not null");
            return (Criteria) this;
        }

        public Criteria andIsMsgEqualTo(String value) {
            addCriterion("is_msg =", value, "isMsg");
            return (Criteria) this;
        }

        public Criteria andIsMsgNotEqualTo(String value) {
            addCriterion("is_msg <>", value, "isMsg");
            return (Criteria) this;
        }

        public Criteria andIsMsgGreaterThan(String value) {
            addCriterion("is_msg >", value, "isMsg");
            return (Criteria) this;
        }

        public Criteria andIsMsgGreaterThanOrEqualTo(String value) {
            addCriterion("is_msg >=", value, "isMsg");
            return (Criteria) this;
        }

        public Criteria andIsMsgLessThan(String value) {
            addCriterion("is_msg <", value, "isMsg");
            return (Criteria) this;
        }

        public Criteria andIsMsgLessThanOrEqualTo(String value) {
            addCriterion("is_msg <=", value, "isMsg");
            return (Criteria) this;
        }

        public Criteria andIsMsgLike(String value) {
            addCriterion("is_msg like", value, "isMsg");
            return (Criteria) this;
        }

        public Criteria andIsMsgNotLike(String value) {
            addCriterion("is_msg not like", value, "isMsg");
            return (Criteria) this;
        }

        public Criteria andIsMsgIn(List<String> values) {
            addCriterion("is_msg in", values, "isMsg");
            return (Criteria) this;
        }

        public Criteria andIsMsgNotIn(List<String> values) {
            addCriterion("is_msg not in", values, "isMsg");
            return (Criteria) this;
        }

        public Criteria andIsMsgBetween(String value1, String value2) {
            addCriterion("is_msg between", value1, value2, "isMsg");
            return (Criteria) this;
        }

        public Criteria andIsMsgNotBetween(String value1, String value2) {
            addCriterion("is_msg not between", value1, value2, "isMsg");
            return (Criteria) this;
        }

        public Criteria andContentsIsNull() {
            addCriterion("contents is null");
            return (Criteria) this;
        }

        public Criteria andContentsIsNotNull() {
            addCriterion("contents is not null");
            return (Criteria) this;
        }

        public Criteria andContentsEqualTo(String value) {
            addCriterion("contents =", value, "contents");
            return (Criteria) this;
        }

        public Criteria andContentsNotEqualTo(String value) {
            addCriterion("contents <>", value, "contents");
            return (Criteria) this;
        }

        public Criteria andContentsGreaterThan(String value) {
            addCriterion("contents >", value, "contents");
            return (Criteria) this;
        }

        public Criteria andContentsGreaterThanOrEqualTo(String value) {
            addCriterion("contents >=", value, "contents");
            return (Criteria) this;
        }

        public Criteria andContentsLessThan(String value) {
            addCriterion("contents <", value, "contents");
            return (Criteria) this;
        }

        public Criteria andContentsLessThanOrEqualTo(String value) {
            addCriterion("contents <=", value, "contents");
            return (Criteria) this;
        }

        public Criteria andContentsLike(String value) {
            addCriterion("contents like", value, "contents");
            return (Criteria) this;
        }

        public Criteria andContentsNotLike(String value) {
            addCriterion("contents not like", value, "contents");
            return (Criteria) this;
        }

        public Criteria andContentsIn(List<String> values) {
            addCriterion("contents in", values, "contents");
            return (Criteria) this;
        }

        public Criteria andContentsNotIn(List<String> values) {
            addCriterion("contents not in", values, "contents");
            return (Criteria) this;
        }

        public Criteria andContentsBetween(String value1, String value2) {
            addCriterion("contents between", value1, value2, "contents");
            return (Criteria) this;
        }

        public Criteria andContentsNotBetween(String value1, String value2) {
            addCriterion("contents not between", value1, value2, "contents");
            return (Criteria) this;
        }

        public Criteria andToNameIsNull() {
            addCriterion("to_name is null");
            return (Criteria) this;
        }

        public Criteria andToNameIsNotNull() {
            addCriterion("to_name is not null");
            return (Criteria) this;
        }

        public Criteria andToNameEqualTo(String value) {
            addCriterion("to_name =", value, "toName");
            return (Criteria) this;
        }

        public Criteria andToNameNotEqualTo(String value) {
            addCriterion("to_name <>", value, "toName");
            return (Criteria) this;
        }

        public Criteria andToNameGreaterThan(String value) {
            addCriterion("to_name >", value, "toName");
            return (Criteria) this;
        }

        public Criteria andToNameGreaterThanOrEqualTo(String value) {
            addCriterion("to_name >=", value, "toName");
            return (Criteria) this;
        }

        public Criteria andToNameLessThan(String value) {
            addCriterion("to_name <", value, "toName");
            return (Criteria) this;
        }

        public Criteria andToNameLessThanOrEqualTo(String value) {
            addCriterion("to_name <=", value, "toName");
            return (Criteria) this;
        }

        public Criteria andToNameLike(String value) {
            addCriterion("to_name like", value, "toName");
            return (Criteria) this;
        }

        public Criteria andToNameNotLike(String value) {
            addCriterion("to_name not like", value, "toName");
            return (Criteria) this;
        }

        public Criteria andToNameIn(List<String> values) {
            addCriterion("to_name in", values, "toName");
            return (Criteria) this;
        }

        public Criteria andToNameNotIn(List<String> values) {
            addCriterion("to_name not in", values, "toName");
            return (Criteria) this;
        }

        public Criteria andToNameBetween(String value1, String value2) {
            addCriterion("to_name between", value1, value2, "toName");
            return (Criteria) this;
        }

        public Criteria andToNameNotBetween(String value1, String value2) {
            addCriterion("to_name not between", value1, value2, "toName");
            return (Criteria) this;
        }

        public Criteria andDestinationIsNull() {
            addCriterion("destination is null");
            return (Criteria) this;
        }

        public Criteria andDestinationIsNotNull() {
            addCriterion("destination is not null");
            return (Criteria) this;
        }

        public Criteria andDestinationEqualTo(String value) {
            addCriterion("destination =", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotEqualTo(String value) {
            addCriterion("destination <>", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationGreaterThan(String value) {
            addCriterion("destination >", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationGreaterThanOrEqualTo(String value) {
            addCriterion("destination >=", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationLessThan(String value) {
            addCriterion("destination <", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationLessThanOrEqualTo(String value) {
            addCriterion("destination <=", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationLike(String value) {
            addCriterion("destination like", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotLike(String value) {
            addCriterion("destination not like", value, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationIn(List<String> values) {
            addCriterion("destination in", values, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotIn(List<String> values) {
            addCriterion("destination not in", values, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationBetween(String value1, String value2) {
            addCriterion("destination between", value1, value2, "destination");
            return (Criteria) this;
        }

        public Criteria andDestinationNotBetween(String value1, String value2) {
            addCriterion("destination not between", value1, value2, "destination");
            return (Criteria) this;
        }

        public Criteria andReceiveDateIsNull() {
            addCriterion("receive_date is null");
            return (Criteria) this;
        }

        public Criteria andReceiveDateIsNotNull() {
            addCriterion("receive_date is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveDateEqualTo(Date value) {
            addCriterion("receive_date =", value, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateNotEqualTo(Date value) {
            addCriterion("receive_date <>", value, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateGreaterThan(Date value) {
            addCriterion("receive_date >", value, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateGreaterThanOrEqualTo(Date value) {
            addCriterion("receive_date >=", value, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateLessThan(Date value) {
            addCriterion("receive_date <", value, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateLessThanOrEqualTo(Date value) {
            addCriterion("receive_date <=", value, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateIn(List<Date> values) {
            addCriterion("receive_date in", values, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateNotIn(List<Date> values) {
            addCriterion("receive_date not in", values, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateBetween(Date value1, Date value2) {
            addCriterion("receive_date between", value1, value2, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateNotBetween(Date value1, Date value2) {
            addCriterion("receive_date not between", value1, value2, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andToCompanyNameIsNull() {
            addCriterion("to_company_name is null");
            return (Criteria) this;
        }

        public Criteria andToCompanyNameIsNotNull() {
            addCriterion("to_company_name is not null");
            return (Criteria) this;
        }

        public Criteria andToCompanyNameEqualTo(String value) {
            addCriterion("to_company_name =", value, "toCompanyName");
            return (Criteria) this;
        }

        public Criteria andToCompanyNameNotEqualTo(String value) {
            addCriterion("to_company_name <>", value, "toCompanyName");
            return (Criteria) this;
        }

        public Criteria andToCompanyNameGreaterThan(String value) {
            addCriterion("to_company_name >", value, "toCompanyName");
            return (Criteria) this;
        }

        public Criteria andToCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("to_company_name >=", value, "toCompanyName");
            return (Criteria) this;
        }

        public Criteria andToCompanyNameLessThan(String value) {
            addCriterion("to_company_name <", value, "toCompanyName");
            return (Criteria) this;
        }

        public Criteria andToCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("to_company_name <=", value, "toCompanyName");
            return (Criteria) this;
        }

        public Criteria andToCompanyNameLike(String value) {
            addCriterion("to_company_name like", value, "toCompanyName");
            return (Criteria) this;
        }

        public Criteria andToCompanyNameNotLike(String value) {
            addCriterion("to_company_name not like", value, "toCompanyName");
            return (Criteria) this;
        }

        public Criteria andToCompanyNameIn(List<String> values) {
            addCriterion("to_company_name in", values, "toCompanyName");
            return (Criteria) this;
        }

        public Criteria andToCompanyNameNotIn(List<String> values) {
            addCriterion("to_company_name not in", values, "toCompanyName");
            return (Criteria) this;
        }

        public Criteria andToCompanyNameBetween(String value1, String value2) {
            addCriterion("to_company_name between", value1, value2, "toCompanyName");
            return (Criteria) this;
        }

        public Criteria andToCompanyNameNotBetween(String value1, String value2) {
            addCriterion("to_company_name not between", value1, value2, "toCompanyName");
            return (Criteria) this;
        }

        public Criteria andToAddressIsNull() {
            addCriterion("to_address is null");
            return (Criteria) this;
        }

        public Criteria andToAddressIsNotNull() {
            addCriterion("to_address is not null");
            return (Criteria) this;
        }

        public Criteria andToAddressEqualTo(String value) {
            addCriterion("to_address =", value, "toAddress");
            return (Criteria) this;
        }

        public Criteria andToAddressNotEqualTo(String value) {
            addCriterion("to_address <>", value, "toAddress");
            return (Criteria) this;
        }

        public Criteria andToAddressGreaterThan(String value) {
            addCriterion("to_address >", value, "toAddress");
            return (Criteria) this;
        }

        public Criteria andToAddressGreaterThanOrEqualTo(String value) {
            addCriterion("to_address >=", value, "toAddress");
            return (Criteria) this;
        }

        public Criteria andToAddressLessThan(String value) {
            addCriterion("to_address <", value, "toAddress");
            return (Criteria) this;
        }

        public Criteria andToAddressLessThanOrEqualTo(String value) {
            addCriterion("to_address <=", value, "toAddress");
            return (Criteria) this;
        }

        public Criteria andToAddressLike(String value) {
            addCriterion("to_address like", value, "toAddress");
            return (Criteria) this;
        }

        public Criteria andToAddressNotLike(String value) {
            addCriterion("to_address not like", value, "toAddress");
            return (Criteria) this;
        }

        public Criteria andToAddressIn(List<String> values) {
            addCriterion("to_address in", values, "toAddress");
            return (Criteria) this;
        }

        public Criteria andToAddressNotIn(List<String> values) {
            addCriterion("to_address not in", values, "toAddress");
            return (Criteria) this;
        }

        public Criteria andToAddressBetween(String value1, String value2) {
            addCriterion("to_address between", value1, value2, "toAddress");
            return (Criteria) this;
        }

        public Criteria andToAddressNotBetween(String value1, String value2) {
            addCriterion("to_address not between", value1, value2, "toAddress");
            return (Criteria) this;
        }

        public Criteria andToPhoneIsNull() {
            addCriterion("to_phone is null");
            return (Criteria) this;
        }

        public Criteria andToPhoneIsNotNull() {
            addCriterion("to_phone is not null");
            return (Criteria) this;
        }

        public Criteria andToPhoneEqualTo(String value) {
            addCriterion("to_phone =", value, "toPhone");
            return (Criteria) this;
        }

        public Criteria andToPhoneNotEqualTo(String value) {
            addCriterion("to_phone <>", value, "toPhone");
            return (Criteria) this;
        }

        public Criteria andToPhoneGreaterThan(String value) {
            addCriterion("to_phone >", value, "toPhone");
            return (Criteria) this;
        }

        public Criteria andToPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("to_phone >=", value, "toPhone");
            return (Criteria) this;
        }

        public Criteria andToPhoneLessThan(String value) {
            addCriterion("to_phone <", value, "toPhone");
            return (Criteria) this;
        }

        public Criteria andToPhoneLessThanOrEqualTo(String value) {
            addCriterion("to_phone <=", value, "toPhone");
            return (Criteria) this;
        }

        public Criteria andToPhoneLike(String value) {
            addCriterion("to_phone like", value, "toPhone");
            return (Criteria) this;
        }

        public Criteria andToPhoneNotLike(String value) {
            addCriterion("to_phone not like", value, "toPhone");
            return (Criteria) this;
        }

        public Criteria andToPhoneIn(List<String> values) {
            addCriterion("to_phone in", values, "toPhone");
            return (Criteria) this;
        }

        public Criteria andToPhoneNotIn(List<String> values) {
            addCriterion("to_phone not in", values, "toPhone");
            return (Criteria) this;
        }

        public Criteria andToPhoneBetween(String value1, String value2) {
            addCriterion("to_phone between", value1, value2, "toPhone");
            return (Criteria) this;
        }

        public Criteria andToPhoneNotBetween(String value1, String value2) {
            addCriterion("to_phone not between", value1, value2, "toPhone");
            return (Criteria) this;
        }

        public Criteria andPickedupByIsNull() {
            addCriterion("pickedup_by is null");
            return (Criteria) this;
        }

        public Criteria andPickedupByIsNotNull() {
            addCriterion("pickedup_by is not null");
            return (Criteria) this;
        }

        public Criteria andPickedupByEqualTo(String value) {
            addCriterion("pickedup_by =", value, "pickedupBy");
            return (Criteria) this;
        }

        public Criteria andPickedupByNotEqualTo(String value) {
            addCriterion("pickedup_by <>", value, "pickedupBy");
            return (Criteria) this;
        }

        public Criteria andPickedupByGreaterThan(String value) {
            addCriterion("pickedup_by >", value, "pickedupBy");
            return (Criteria) this;
        }

        public Criteria andPickedupByGreaterThanOrEqualTo(String value) {
            addCriterion("pickedup_by >=", value, "pickedupBy");
            return (Criteria) this;
        }

        public Criteria andPickedupByLessThan(String value) {
            addCriterion("pickedup_by <", value, "pickedupBy");
            return (Criteria) this;
        }

        public Criteria andPickedupByLessThanOrEqualTo(String value) {
            addCriterion("pickedup_by <=", value, "pickedupBy");
            return (Criteria) this;
        }

        public Criteria andPickedupByLike(String value) {
            addCriterion("pickedup_by like", value, "pickedupBy");
            return (Criteria) this;
        }

        public Criteria andPickedupByNotLike(String value) {
            addCriterion("pickedup_by not like", value, "pickedupBy");
            return (Criteria) this;
        }

        public Criteria andPickedupByIn(List<String> values) {
            addCriterion("pickedup_by in", values, "pickedupBy");
            return (Criteria) this;
        }

        public Criteria andPickedupByNotIn(List<String> values) {
            addCriterion("pickedup_by not in", values, "pickedupBy");
            return (Criteria) this;
        }

        public Criteria andPickedupByBetween(String value1, String value2) {
            addCriterion("pickedup_by between", value1, value2, "pickedupBy");
            return (Criteria) this;
        }

        public Criteria andPickedupByNotBetween(String value1, String value2) {
            addCriterion("pickedup_by not between", value1, value2, "pickedupBy");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(Double value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Double value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Double value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Double value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Double value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Double value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Double> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Double> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Double value1, Double value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Double value1, Double value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andDimensionlIsNull() {
            addCriterion("dimensionl is null");
            return (Criteria) this;
        }

        public Criteria andDimensionlIsNotNull() {
            addCriterion("dimensionl is not null");
            return (Criteria) this;
        }

        public Criteria andDimensionlEqualTo(Double value) {
            addCriterion("dimensionl =", value, "dimensionl");
            return (Criteria) this;
        }

        public Criteria andDimensionlNotEqualTo(Double value) {
            addCriterion("dimensionl <>", value, "dimensionl");
            return (Criteria) this;
        }

        public Criteria andDimensionlGreaterThan(Double value) {
            addCriterion("dimensionl >", value, "dimensionl");
            return (Criteria) this;
        }

        public Criteria andDimensionlGreaterThanOrEqualTo(Double value) {
            addCriterion("dimensionl >=", value, "dimensionl");
            return (Criteria) this;
        }

        public Criteria andDimensionlLessThan(Double value) {
            addCriterion("dimensionl <", value, "dimensionl");
            return (Criteria) this;
        }

        public Criteria andDimensionlLessThanOrEqualTo(Double value) {
            addCriterion("dimensionl <=", value, "dimensionl");
            return (Criteria) this;
        }

        public Criteria andDimensionlIn(List<Double> values) {
            addCriterion("dimensionl in", values, "dimensionl");
            return (Criteria) this;
        }

        public Criteria andDimensionlNotIn(List<Double> values) {
            addCriterion("dimensionl not in", values, "dimensionl");
            return (Criteria) this;
        }

        public Criteria andDimensionlBetween(Double value1, Double value2) {
            addCriterion("dimensionl between", value1, value2, "dimensionl");
            return (Criteria) this;
        }

        public Criteria andDimensionlNotBetween(Double value1, Double value2) {
            addCriterion("dimensionl not between", value1, value2, "dimensionl");
            return (Criteria) this;
        }

        public Criteria andIsInsIsNull() {
            addCriterion("is_ins is null");
            return (Criteria) this;
        }

        public Criteria andIsInsIsNotNull() {
            addCriterion("is_ins is not null");
            return (Criteria) this;
        }

        public Criteria andIsInsEqualTo(String value) {
            addCriterion("is_ins =", value, "isIns");
            return (Criteria) this;
        }

        public Criteria andIsInsNotEqualTo(String value) {
            addCriterion("is_ins <>", value, "isIns");
            return (Criteria) this;
        }

        public Criteria andIsInsGreaterThan(String value) {
            addCriterion("is_ins >", value, "isIns");
            return (Criteria) this;
        }

        public Criteria andIsInsGreaterThanOrEqualTo(String value) {
            addCriterion("is_ins >=", value, "isIns");
            return (Criteria) this;
        }

        public Criteria andIsInsLessThan(String value) {
            addCriterion("is_ins <", value, "isIns");
            return (Criteria) this;
        }

        public Criteria andIsInsLessThanOrEqualTo(String value) {
            addCriterion("is_ins <=", value, "isIns");
            return (Criteria) this;
        }

        public Criteria andIsInsLike(String value) {
            addCriterion("is_ins like", value, "isIns");
            return (Criteria) this;
        }

        public Criteria andIsInsNotLike(String value) {
            addCriterion("is_ins not like", value, "isIns");
            return (Criteria) this;
        }

        public Criteria andIsInsIn(List<String> values) {
            addCriterion("is_ins in", values, "isIns");
            return (Criteria) this;
        }

        public Criteria andIsInsNotIn(List<String> values) {
            addCriterion("is_ins not in", values, "isIns");
            return (Criteria) this;
        }

        public Criteria andIsInsBetween(String value1, String value2) {
            addCriterion("is_ins between", value1, value2, "isIns");
            return (Criteria) this;
        }

        public Criteria andIsInsNotBetween(String value1, String value2) {
            addCriterion("is_ins not between", value1, value2, "isIns");
            return (Criteria) this;
        }

        public Criteria andInsuranceFeeIsNull() {
            addCriterion("insurance_fee is null");
            return (Criteria) this;
        }

        public Criteria andInsuranceFeeIsNotNull() {
            addCriterion("insurance_fee is not null");
            return (Criteria) this;
        }

        public Criteria andInsuranceFeeEqualTo(Long value) {
            addCriterion("insurance_fee =", value, "insuranceFee");
            return (Criteria) this;
        }

        public Criteria andInsuranceFeeNotEqualTo(Long value) {
            addCriterion("insurance_fee <>", value, "insuranceFee");
            return (Criteria) this;
        }

        public Criteria andInsuranceFeeGreaterThan(Long value) {
            addCriterion("insurance_fee >", value, "insuranceFee");
            return (Criteria) this;
        }

        public Criteria andInsuranceFeeGreaterThanOrEqualTo(Long value) {
            addCriterion("insurance_fee >=", value, "insuranceFee");
            return (Criteria) this;
        }

        public Criteria andInsuranceFeeLessThan(Long value) {
            addCriterion("insurance_fee <", value, "insuranceFee");
            return (Criteria) this;
        }

        public Criteria andInsuranceFeeLessThanOrEqualTo(Long value) {
            addCriterion("insurance_fee <=", value, "insuranceFee");
            return (Criteria) this;
        }

        public Criteria andInsuranceFeeIn(List<Long> values) {
            addCriterion("insurance_fee in", values, "insuranceFee");
            return (Criteria) this;
        }

        public Criteria andInsuranceFeeNotIn(List<Long> values) {
            addCriterion("insurance_fee not in", values, "insuranceFee");
            return (Criteria) this;
        }

        public Criteria andInsuranceFeeBetween(Long value1, Long value2) {
            addCriterion("insurance_fee between", value1, value2, "insuranceFee");
            return (Criteria) this;
        }

        public Criteria andInsuranceFeeNotBetween(Long value1, Long value2) {
            addCriterion("insurance_fee not between", value1, value2, "insuranceFee");
            return (Criteria) this;
        }

        public Criteria andInsuranceAmountIsNull() {
            addCriterion("insurance_amount is null");
            return (Criteria) this;
        }

        public Criteria andInsuranceAmountIsNotNull() {
            addCriterion("insurance_amount is not null");
            return (Criteria) this;
        }

        public Criteria andInsuranceAmountEqualTo(Long value) {
            addCriterion("insurance_amount =", value, "insuranceAmount");
            return (Criteria) this;
        }

        public Criteria andInsuranceAmountNotEqualTo(Long value) {
            addCriterion("insurance_amount <>", value, "insuranceAmount");
            return (Criteria) this;
        }

        public Criteria andInsuranceAmountGreaterThan(Long value) {
            addCriterion("insurance_amount >", value, "insuranceAmount");
            return (Criteria) this;
        }

        public Criteria andInsuranceAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("insurance_amount >=", value, "insuranceAmount");
            return (Criteria) this;
        }

        public Criteria andInsuranceAmountLessThan(Long value) {
            addCriterion("insurance_amount <", value, "insuranceAmount");
            return (Criteria) this;
        }

        public Criteria andInsuranceAmountLessThanOrEqualTo(Long value) {
            addCriterion("insurance_amount <=", value, "insuranceAmount");
            return (Criteria) this;
        }

        public Criteria andInsuranceAmountIn(List<Long> values) {
            addCriterion("insurance_amount in", values, "insuranceAmount");
            return (Criteria) this;
        }

        public Criteria andInsuranceAmountNotIn(List<Long> values) {
            addCriterion("insurance_amount not in", values, "insuranceAmount");
            return (Criteria) this;
        }

        public Criteria andInsuranceAmountBetween(Long value1, Long value2) {
            addCriterion("insurance_amount between", value1, value2, "insuranceAmount");
            return (Criteria) this;
        }

        public Criteria andInsuranceAmountNotBetween(Long value1, Long value2) {
            addCriterion("insurance_amount not between", value1, value2, "insuranceAmount");
            return (Criteria) this;
        }

        public Criteria andTimesOfChargeIsNull() {
            addCriterion("times_of_charge is null");
            return (Criteria) this;
        }

        public Criteria andTimesOfChargeIsNotNull() {
            addCriterion("times_of_charge is not null");
            return (Criteria) this;
        }

        public Criteria andTimesOfChargeEqualTo(Long value) {
            addCriterion("times_of_charge =", value, "timesOfCharge");
            return (Criteria) this;
        }

        public Criteria andTimesOfChargeNotEqualTo(Long value) {
            addCriterion("times_of_charge <>", value, "timesOfCharge");
            return (Criteria) this;
        }

        public Criteria andTimesOfChargeGreaterThan(Long value) {
            addCriterion("times_of_charge >", value, "timesOfCharge");
            return (Criteria) this;
        }

        public Criteria andTimesOfChargeGreaterThanOrEqualTo(Long value) {
            addCriterion("times_of_charge >=", value, "timesOfCharge");
            return (Criteria) this;
        }

        public Criteria andTimesOfChargeLessThan(Long value) {
            addCriterion("times_of_charge <", value, "timesOfCharge");
            return (Criteria) this;
        }

        public Criteria andTimesOfChargeLessThanOrEqualTo(Long value) {
            addCriterion("times_of_charge <=", value, "timesOfCharge");
            return (Criteria) this;
        }

        public Criteria andTimesOfChargeIn(List<Long> values) {
            addCriterion("times_of_charge in", values, "timesOfCharge");
            return (Criteria) this;
        }

        public Criteria andTimesOfChargeNotIn(List<Long> values) {
            addCriterion("times_of_charge not in", values, "timesOfCharge");
            return (Criteria) this;
        }

        public Criteria andTimesOfChargeBetween(Long value1, Long value2) {
            addCriterion("times_of_charge between", value1, value2, "timesOfCharge");
            return (Criteria) this;
        }

        public Criteria andTimesOfChargeNotBetween(Long value1, Long value2) {
            addCriterion("times_of_charge not between", value1, value2, "timesOfCharge");
            return (Criteria) this;
        }

        public Criteria andChargeIsNull() {
            addCriterion("charge is null");
            return (Criteria) this;
        }

        public Criteria andChargeIsNotNull() {
            addCriterion("charge is not null");
            return (Criteria) this;
        }

        public Criteria andChargeEqualTo(Long value) {
            addCriterion("charge =", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeNotEqualTo(Long value) {
            addCriterion("charge <>", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeGreaterThan(Long value) {
            addCriterion("charge >", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeGreaterThanOrEqualTo(Long value) {
            addCriterion("charge >=", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeLessThan(Long value) {
            addCriterion("charge <", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeLessThanOrEqualTo(Long value) {
            addCriterion("charge <=", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeIn(List<Long> values) {
            addCriterion("charge in", values, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeNotIn(List<Long> values) {
            addCriterion("charge not in", values, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeBetween(Long value1, Long value2) {
            addCriterion("charge between", value1, value2, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeNotBetween(Long value1, Long value2) {
            addCriterion("charge not between", value1, value2, "charge");
            return (Criteria) this;
        }

        public Criteria andPackageChargeIsNull() {
            addCriterion("package_charge is null");
            return (Criteria) this;
        }

        public Criteria andPackageChargeIsNotNull() {
            addCriterion("package_charge is not null");
            return (Criteria) this;
        }

        public Criteria andPackageChargeEqualTo(Long value) {
            addCriterion("package_charge =", value, "packageCharge");
            return (Criteria) this;
        }

        public Criteria andPackageChargeNotEqualTo(Long value) {
            addCriterion("package_charge <>", value, "packageCharge");
            return (Criteria) this;
        }

        public Criteria andPackageChargeGreaterThan(Long value) {
            addCriterion("package_charge >", value, "packageCharge");
            return (Criteria) this;
        }

        public Criteria andPackageChargeGreaterThanOrEqualTo(Long value) {
            addCriterion("package_charge >=", value, "packageCharge");
            return (Criteria) this;
        }

        public Criteria andPackageChargeLessThan(Long value) {
            addCriterion("package_charge <", value, "packageCharge");
            return (Criteria) this;
        }

        public Criteria andPackageChargeLessThanOrEqualTo(Long value) {
            addCriterion("package_charge <=", value, "packageCharge");
            return (Criteria) this;
        }

        public Criteria andPackageChargeIn(List<Long> values) {
            addCriterion("package_charge in", values, "packageCharge");
            return (Criteria) this;
        }

        public Criteria andPackageChargeNotIn(List<Long> values) {
            addCriterion("package_charge not in", values, "packageCharge");
            return (Criteria) this;
        }

        public Criteria andPackageChargeBetween(Long value1, Long value2) {
            addCriterion("package_charge between", value1, value2, "packageCharge");
            return (Criteria) this;
        }

        public Criteria andPackageChargeNotBetween(Long value1, Long value2) {
            addCriterion("package_charge not between", value1, value2, "packageCharge");
            return (Criteria) this;
        }

        public Criteria andTotalChargeIsNull() {
            addCriterion("total_charge is null");
            return (Criteria) this;
        }

        public Criteria andTotalChargeIsNotNull() {
            addCriterion("total_charge is not null");
            return (Criteria) this;
        }

        public Criteria andTotalChargeEqualTo(Long value) {
            addCriterion("total_charge =", value, "totalCharge");
            return (Criteria) this;
        }

        public Criteria andTotalChargeNotEqualTo(Long value) {
            addCriterion("total_charge <>", value, "totalCharge");
            return (Criteria) this;
        }

        public Criteria andTotalChargeGreaterThan(Long value) {
            addCriterion("total_charge >", value, "totalCharge");
            return (Criteria) this;
        }

        public Criteria andTotalChargeGreaterThanOrEqualTo(Long value) {
            addCriterion("total_charge >=", value, "totalCharge");
            return (Criteria) this;
        }

        public Criteria andTotalChargeLessThan(Long value) {
            addCriterion("total_charge <", value, "totalCharge");
            return (Criteria) this;
        }

        public Criteria andTotalChargeLessThanOrEqualTo(Long value) {
            addCriterion("total_charge <=", value, "totalCharge");
            return (Criteria) this;
        }

        public Criteria andTotalChargeIn(List<Long> values) {
            addCriterion("total_charge in", values, "totalCharge");
            return (Criteria) this;
        }

        public Criteria andTotalChargeNotIn(List<Long> values) {
            addCriterion("total_charge not in", values, "totalCharge");
            return (Criteria) this;
        }

        public Criteria andTotalChargeBetween(Long value1, Long value2) {
            addCriterion("total_charge between", value1, value2, "totalCharge");
            return (Criteria) this;
        }

        public Criteria andTotalChargeNotBetween(Long value1, Long value2) {
            addCriterion("total_charge not between", value1, value2, "totalCharge");
            return (Criteria) this;
        }

        public Criteria andPaymentOptionIsNull() {
            addCriterion("payment_option is null");
            return (Criteria) this;
        }

        public Criteria andPaymentOptionIsNotNull() {
            addCriterion("payment_option is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentOptionEqualTo(Integer value) {
            addCriterion("payment_option =", value, "paymentOption");
            return (Criteria) this;
        }

        public Criteria andPaymentOptionNotEqualTo(Integer value) {
            addCriterion("payment_option <>", value, "paymentOption");
            return (Criteria) this;
        }

        public Criteria andPaymentOptionGreaterThan(Integer value) {
            addCriterion("payment_option >", value, "paymentOption");
            return (Criteria) this;
        }

        public Criteria andPaymentOptionGreaterThanOrEqualTo(Integer value) {
            addCriterion("payment_option >=", value, "paymentOption");
            return (Criteria) this;
        }

        public Criteria andPaymentOptionLessThan(Integer value) {
            addCriterion("payment_option <", value, "paymentOption");
            return (Criteria) this;
        }

        public Criteria andPaymentOptionLessThanOrEqualTo(Integer value) {
            addCriterion("payment_option <=", value, "paymentOption");
            return (Criteria) this;
        }

        public Criteria andPaymentOptionIn(List<Integer> values) {
            addCriterion("payment_option in", values, "paymentOption");
            return (Criteria) this;
        }

        public Criteria andPaymentOptionNotIn(List<Integer> values) {
            addCriterion("payment_option not in", values, "paymentOption");
            return (Criteria) this;
        }

        public Criteria andPaymentOptionBetween(Integer value1, Integer value2) {
            addCriterion("payment_option between", value1, value2, "paymentOption");
            return (Criteria) this;
        }

        public Criteria andPaymentOptionNotBetween(Integer value1, Integer value2) {
            addCriterion("payment_option not between", value1, value2, "paymentOption");
            return (Criteria) this;
        }

        public Criteria andPaymentChargeIsNull() {
            addCriterion("payment_charge is null");
            return (Criteria) this;
        }

        public Criteria andPaymentChargeIsNotNull() {
            addCriterion("payment_charge is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentChargeEqualTo(Integer value) {
            addCriterion("payment_charge =", value, "paymentCharge");
            return (Criteria) this;
        }

        public Criteria andPaymentChargeNotEqualTo(Integer value) {
            addCriterion("payment_charge <>", value, "paymentCharge");
            return (Criteria) this;
        }

        public Criteria andPaymentChargeGreaterThan(Integer value) {
            addCriterion("payment_charge >", value, "paymentCharge");
            return (Criteria) this;
        }

        public Criteria andPaymentChargeGreaterThanOrEqualTo(Integer value) {
            addCriterion("payment_charge >=", value, "paymentCharge");
            return (Criteria) this;
        }

        public Criteria andPaymentChargeLessThan(Integer value) {
            addCriterion("payment_charge <", value, "paymentCharge");
            return (Criteria) this;
        }

        public Criteria andPaymentChargeLessThanOrEqualTo(Integer value) {
            addCriterion("payment_charge <=", value, "paymentCharge");
            return (Criteria) this;
        }

        public Criteria andPaymentChargeIn(List<Integer> values) {
            addCriterion("payment_charge in", values, "paymentCharge");
            return (Criteria) this;
        }

        public Criteria andPaymentChargeNotIn(List<Integer> values) {
            addCriterion("payment_charge not in", values, "paymentCharge");
            return (Criteria) this;
        }

        public Criteria andPaymentChargeBetween(Integer value1, Integer value2) {
            addCriterion("payment_charge between", value1, value2, "paymentCharge");
            return (Criteria) this;
        }

        public Criteria andPaymentChargeNotBetween(Integer value1, Integer value2) {
            addCriterion("payment_charge not between", value1, value2, "paymentCharge");
            return (Criteria) this;
        }

        public Criteria andFromSignatureIsNull() {
            addCriterion("from_signature is null");
            return (Criteria) this;
        }

        public Criteria andFromSignatureIsNotNull() {
            addCriterion("from_signature is not null");
            return (Criteria) this;
        }

        public Criteria andFromSignatureEqualTo(String value) {
            addCriterion("from_signature =", value, "fromSignature");
            return (Criteria) this;
        }

        public Criteria andFromSignatureNotEqualTo(String value) {
            addCriterion("from_signature <>", value, "fromSignature");
            return (Criteria) this;
        }

        public Criteria andFromSignatureGreaterThan(String value) {
            addCriterion("from_signature >", value, "fromSignature");
            return (Criteria) this;
        }

        public Criteria andFromSignatureGreaterThanOrEqualTo(String value) {
            addCriterion("from_signature >=", value, "fromSignature");
            return (Criteria) this;
        }

        public Criteria andFromSignatureLessThan(String value) {
            addCriterion("from_signature <", value, "fromSignature");
            return (Criteria) this;
        }

        public Criteria andFromSignatureLessThanOrEqualTo(String value) {
            addCriterion("from_signature <=", value, "fromSignature");
            return (Criteria) this;
        }

        public Criteria andFromSignatureLike(String value) {
            addCriterion("from_signature like", value, "fromSignature");
            return (Criteria) this;
        }

        public Criteria andFromSignatureNotLike(String value) {
            addCriterion("from_signature not like", value, "fromSignature");
            return (Criteria) this;
        }

        public Criteria andFromSignatureIn(List<String> values) {
            addCriterion("from_signature in", values, "fromSignature");
            return (Criteria) this;
        }

        public Criteria andFromSignatureNotIn(List<String> values) {
            addCriterion("from_signature not in", values, "fromSignature");
            return (Criteria) this;
        }

        public Criteria andFromSignatureBetween(String value1, String value2) {
            addCriterion("from_signature between", value1, value2, "fromSignature");
            return (Criteria) this;
        }

        public Criteria andFromSignatureNotBetween(String value1, String value2) {
            addCriterion("from_signature not between", value1, value2, "fromSignature");
            return (Criteria) this;
        }

        public Criteria andFromIdIsNull() {
            addCriterion("from_id is null");
            return (Criteria) this;
        }

        public Criteria andFromIdIsNotNull() {
            addCriterion("from_id is not null");
            return (Criteria) this;
        }

        public Criteria andFromIdEqualTo(String value) {
            addCriterion("from_id =", value, "fromId");
            return (Criteria) this;
        }

        public Criteria andFromIdNotEqualTo(String value) {
            addCriterion("from_id <>", value, "fromId");
            return (Criteria) this;
        }

        public Criteria andFromIdGreaterThan(String value) {
            addCriterion("from_id >", value, "fromId");
            return (Criteria) this;
        }

        public Criteria andFromIdGreaterThanOrEqualTo(String value) {
            addCriterion("from_id >=", value, "fromId");
            return (Criteria) this;
        }

        public Criteria andFromIdLessThan(String value) {
            addCriterion("from_id <", value, "fromId");
            return (Criteria) this;
        }

        public Criteria andFromIdLessThanOrEqualTo(String value) {
            addCriterion("from_id <=", value, "fromId");
            return (Criteria) this;
        }

        public Criteria andFromIdLike(String value) {
            addCriterion("from_id like", value, "fromId");
            return (Criteria) this;
        }

        public Criteria andFromIdNotLike(String value) {
            addCriterion("from_id not like", value, "fromId");
            return (Criteria) this;
        }

        public Criteria andFromIdIn(List<String> values) {
            addCriterion("from_id in", values, "fromId");
            return (Criteria) this;
        }

        public Criteria andFromIdNotIn(List<String> values) {
            addCriterion("from_id not in", values, "fromId");
            return (Criteria) this;
        }

        public Criteria andFromIdBetween(String value1, String value2) {
            addCriterion("from_id between", value1, value2, "fromId");
            return (Criteria) this;
        }

        public Criteria andFromIdNotBetween(String value1, String value2) {
            addCriterion("from_id not between", value1, value2, "fromId");
            return (Criteria) this;
        }

        public Criteria andToIdIsNull() {
            addCriterion("to_id is null");
            return (Criteria) this;
        }

        public Criteria andToIdIsNotNull() {
            addCriterion("to_id is not null");
            return (Criteria) this;
        }

        public Criteria andToIdEqualTo(String value) {
            addCriterion("to_id =", value, "toId");
            return (Criteria) this;
        }

        public Criteria andToIdNotEqualTo(String value) {
            addCriterion("to_id <>", value, "toId");
            return (Criteria) this;
        }

        public Criteria andToIdGreaterThan(String value) {
            addCriterion("to_id >", value, "toId");
            return (Criteria) this;
        }

        public Criteria andToIdGreaterThanOrEqualTo(String value) {
            addCriterion("to_id >=", value, "toId");
            return (Criteria) this;
        }

        public Criteria andToIdLessThan(String value) {
            addCriterion("to_id <", value, "toId");
            return (Criteria) this;
        }

        public Criteria andToIdLessThanOrEqualTo(String value) {
            addCriterion("to_id <=", value, "toId");
            return (Criteria) this;
        }

        public Criteria andToIdLike(String value) {
            addCriterion("to_id like", value, "toId");
            return (Criteria) this;
        }

        public Criteria andToIdNotLike(String value) {
            addCriterion("to_id not like", value, "toId");
            return (Criteria) this;
        }

        public Criteria andToIdIn(List<String> values) {
            addCriterion("to_id in", values, "toId");
            return (Criteria) this;
        }

        public Criteria andToIdNotIn(List<String> values) {
            addCriterion("to_id not in", values, "toId");
            return (Criteria) this;
        }

        public Criteria andToIdBetween(String value1, String value2) {
            addCriterion("to_id between", value1, value2, "toId");
            return (Criteria) this;
        }

        public Criteria andToIdNotBetween(String value1, String value2) {
            addCriterion("to_id not between", value1, value2, "toId");
            return (Criteria) this;
        }

        public Criteria andWaybillPicIsNull() {
            addCriterion("waybill_pic is null");
            return (Criteria) this;
        }

        public Criteria andWaybillPicIsNotNull() {
            addCriterion("waybill_pic is not null");
            return (Criteria) this;
        }

        public Criteria andWaybillPicEqualTo(String value) {
            addCriterion("waybill_pic =", value, "waybillPic");
            return (Criteria) this;
        }

        public Criteria andWaybillPicNotEqualTo(String value) {
            addCriterion("waybill_pic <>", value, "waybillPic");
            return (Criteria) this;
        }

        public Criteria andWaybillPicGreaterThan(String value) {
            addCriterion("waybill_pic >", value, "waybillPic");
            return (Criteria) this;
        }

        public Criteria andWaybillPicGreaterThanOrEqualTo(String value) {
            addCriterion("waybill_pic >=", value, "waybillPic");
            return (Criteria) this;
        }

        public Criteria andWaybillPicLessThan(String value) {
            addCriterion("waybill_pic <", value, "waybillPic");
            return (Criteria) this;
        }

        public Criteria andWaybillPicLessThanOrEqualTo(String value) {
            addCriterion("waybill_pic <=", value, "waybillPic");
            return (Criteria) this;
        }

        public Criteria andWaybillPicLike(String value) {
            addCriterion("waybill_pic like", value, "waybillPic");
            return (Criteria) this;
        }

        public Criteria andWaybillPicNotLike(String value) {
            addCriterion("waybill_pic not like", value, "waybillPic");
            return (Criteria) this;
        }

        public Criteria andWaybillPicIn(List<String> values) {
            addCriterion("waybill_pic in", values, "waybillPic");
            return (Criteria) this;
        }

        public Criteria andWaybillPicNotIn(List<String> values) {
            addCriterion("waybill_pic not in", values, "waybillPic");
            return (Criteria) this;
        }

        public Criteria andWaybillPicBetween(String value1, String value2) {
            addCriterion("waybill_pic between", value1, value2, "waybillPic");
            return (Criteria) this;
        }

        public Criteria andWaybillPicNotBetween(String value1, String value2) {
            addCriterion("waybill_pic not between", value1, value2, "waybillPic");
            return (Criteria) this;
        }

        public Criteria andToSignatureIsNull() {
            addCriterion("to_signature is null");
            return (Criteria) this;
        }

        public Criteria andToSignatureIsNotNull() {
            addCriterion("to_signature is not null");
            return (Criteria) this;
        }

        public Criteria andToSignatureEqualTo(String value) {
            addCriterion("to_signature =", value, "toSignature");
            return (Criteria) this;
        }

        public Criteria andToSignatureNotEqualTo(String value) {
            addCriterion("to_signature <>", value, "toSignature");
            return (Criteria) this;
        }

        public Criteria andToSignatureGreaterThan(String value) {
            addCriterion("to_signature >", value, "toSignature");
            return (Criteria) this;
        }

        public Criteria andToSignatureGreaterThanOrEqualTo(String value) {
            addCriterion("to_signature >=", value, "toSignature");
            return (Criteria) this;
        }

        public Criteria andToSignatureLessThan(String value) {
            addCriterion("to_signature <", value, "toSignature");
            return (Criteria) this;
        }

        public Criteria andToSignatureLessThanOrEqualTo(String value) {
            addCriterion("to_signature <=", value, "toSignature");
            return (Criteria) this;
        }

        public Criteria andToSignatureLike(String value) {
            addCriterion("to_signature like", value, "toSignature");
            return (Criteria) this;
        }

        public Criteria andToSignatureNotLike(String value) {
            addCriterion("to_signature not like", value, "toSignature");
            return (Criteria) this;
        }

        public Criteria andToSignatureIn(List<String> values) {
            addCriterion("to_signature in", values, "toSignature");
            return (Criteria) this;
        }

        public Criteria andToSignatureNotIn(List<String> values) {
            addCriterion("to_signature not in", values, "toSignature");
            return (Criteria) this;
        }

        public Criteria andToSignatureBetween(String value1, String value2) {
            addCriterion("to_signature between", value1, value2, "toSignature");
            return (Criteria) this;
        }

        public Criteria andToSignatureNotBetween(String value1, String value2) {
            addCriterion("to_signature not between", value1, value2, "toSignature");
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