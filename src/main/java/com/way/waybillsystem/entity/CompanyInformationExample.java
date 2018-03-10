package com.way.waybillsystem.entity;

import java.util.ArrayList;
import java.util.List;

public class CompanyInformationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CompanyInformationExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andLocationIsNull() {
            addCriterion("location is null");
            return (Criteria) this;
        }

        public Criteria andLocationIsNotNull() {
            addCriterion("location is not null");
            return (Criteria) this;
        }

        public Criteria andLocationEqualTo(String value) {
            addCriterion("location =", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotEqualTo(String value) {
            addCriterion("location <>", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThan(String value) {
            addCriterion("location >", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationGreaterThanOrEqualTo(String value) {
            addCriterion("location >=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThan(String value) {
            addCriterion("location <", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLessThanOrEqualTo(String value) {
            addCriterion("location <=", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationLike(String value) {
            addCriterion("location like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotLike(String value) {
            addCriterion("location not like", value, "location");
            return (Criteria) this;
        }

        public Criteria andLocationIn(List<String> values) {
            addCriterion("location in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotIn(List<String> values) {
            addCriterion("location not in", values, "location");
            return (Criteria) this;
        }

        public Criteria andLocationBetween(String value1, String value2) {
            addCriterion("location between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andLocationNotBetween(String value1, String value2) {
            addCriterion("location not between", value1, value2, "location");
            return (Criteria) this;
        }

        public Criteria andWebsiteIsNull() {
            addCriterion("website is null");
            return (Criteria) this;
        }

        public Criteria andWebsiteIsNotNull() {
            addCriterion("website is not null");
            return (Criteria) this;
        }

        public Criteria andWebsiteEqualTo(String value) {
            addCriterion("website =", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotEqualTo(String value) {
            addCriterion("website <>", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteGreaterThan(String value) {
            addCriterion("website >", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteGreaterThanOrEqualTo(String value) {
            addCriterion("website >=", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLessThan(String value) {
            addCriterion("website <", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLessThanOrEqualTo(String value) {
            addCriterion("website <=", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteLike(String value) {
            addCriterion("website like", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotLike(String value) {
            addCriterion("website not like", value, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteIn(List<String> values) {
            addCriterion("website in", values, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotIn(List<String> values) {
            addCriterion("website not in", values, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteBetween(String value1, String value2) {
            addCriterion("website between", value1, value2, "website");
            return (Criteria) this;
        }

        public Criteria andWebsiteNotBetween(String value1, String value2) {
            addCriterion("website not between", value1, value2, "website");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andSloganIsNull() {
            addCriterion("slogan is null");
            return (Criteria) this;
        }

        public Criteria andSloganIsNotNull() {
            addCriterion("slogan is not null");
            return (Criteria) this;
        }

        public Criteria andSloganEqualTo(String value) {
            addCriterion("slogan =", value, "slogan");
            return (Criteria) this;
        }

        public Criteria andSloganNotEqualTo(String value) {
            addCriterion("slogan <>", value, "slogan");
            return (Criteria) this;
        }

        public Criteria andSloganGreaterThan(String value) {
            addCriterion("slogan >", value, "slogan");
            return (Criteria) this;
        }

        public Criteria andSloganGreaterThanOrEqualTo(String value) {
            addCriterion("slogan >=", value, "slogan");
            return (Criteria) this;
        }

        public Criteria andSloganLessThan(String value) {
            addCriterion("slogan <", value, "slogan");
            return (Criteria) this;
        }

        public Criteria andSloganLessThanOrEqualTo(String value) {
            addCriterion("slogan <=", value, "slogan");
            return (Criteria) this;
        }

        public Criteria andSloganLike(String value) {
            addCriterion("slogan like", value, "slogan");
            return (Criteria) this;
        }

        public Criteria andSloganNotLike(String value) {
            addCriterion("slogan not like", value, "slogan");
            return (Criteria) this;
        }

        public Criteria andSloganIn(List<String> values) {
            addCriterion("slogan in", values, "slogan");
            return (Criteria) this;
        }

        public Criteria andSloganNotIn(List<String> values) {
            addCriterion("slogan not in", values, "slogan");
            return (Criteria) this;
        }

        public Criteria andSloganBetween(String value1, String value2) {
            addCriterion("slogan between", value1, value2, "slogan");
            return (Criteria) this;
        }

        public Criteria andSloganNotBetween(String value1, String value2) {
            addCriterion("slogan not between", value1, value2, "slogan");
            return (Criteria) this;
        }

        public Criteria andDescriptionTitleIsNull() {
            addCriterion("description_title is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionTitleIsNotNull() {
            addCriterion("description_title is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionTitleEqualTo(String value) {
            addCriterion("description_title =", value, "descriptionTitle");
            return (Criteria) this;
        }

        public Criteria andDescriptionTitleNotEqualTo(String value) {
            addCriterion("description_title <>", value, "descriptionTitle");
            return (Criteria) this;
        }

        public Criteria andDescriptionTitleGreaterThan(String value) {
            addCriterion("description_title >", value, "descriptionTitle");
            return (Criteria) this;
        }

        public Criteria andDescriptionTitleGreaterThanOrEqualTo(String value) {
            addCriterion("description_title >=", value, "descriptionTitle");
            return (Criteria) this;
        }

        public Criteria andDescriptionTitleLessThan(String value) {
            addCriterion("description_title <", value, "descriptionTitle");
            return (Criteria) this;
        }

        public Criteria andDescriptionTitleLessThanOrEqualTo(String value) {
            addCriterion("description_title <=", value, "descriptionTitle");
            return (Criteria) this;
        }

        public Criteria andDescriptionTitleLike(String value) {
            addCriterion("description_title like", value, "descriptionTitle");
            return (Criteria) this;
        }

        public Criteria andDescriptionTitleNotLike(String value) {
            addCriterion("description_title not like", value, "descriptionTitle");
            return (Criteria) this;
        }

        public Criteria andDescriptionTitleIn(List<String> values) {
            addCriterion("description_title in", values, "descriptionTitle");
            return (Criteria) this;
        }

        public Criteria andDescriptionTitleNotIn(List<String> values) {
            addCriterion("description_title not in", values, "descriptionTitle");
            return (Criteria) this;
        }

        public Criteria andDescriptionTitleBetween(String value1, String value2) {
            addCriterion("description_title between", value1, value2, "descriptionTitle");
            return (Criteria) this;
        }

        public Criteria andDescriptionTitleNotBetween(String value1, String value2) {
            addCriterion("description_title not between", value1, value2, "descriptionTitle");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent1IsNull() {
            addCriterion("description_content1 is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent1IsNotNull() {
            addCriterion("description_content1 is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent1EqualTo(String value) {
            addCriterion("description_content1 =", value, "descriptionContent1");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent1NotEqualTo(String value) {
            addCriterion("description_content1 <>", value, "descriptionContent1");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent1GreaterThan(String value) {
            addCriterion("description_content1 >", value, "descriptionContent1");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent1GreaterThanOrEqualTo(String value) {
            addCriterion("description_content1 >=", value, "descriptionContent1");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent1LessThan(String value) {
            addCriterion("description_content1 <", value, "descriptionContent1");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent1LessThanOrEqualTo(String value) {
            addCriterion("description_content1 <=", value, "descriptionContent1");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent1Like(String value) {
            addCriterion("description_content1 like", value, "descriptionContent1");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent1NotLike(String value) {
            addCriterion("description_content1 not like", value, "descriptionContent1");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent1In(List<String> values) {
            addCriterion("description_content1 in", values, "descriptionContent1");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent1NotIn(List<String> values) {
            addCriterion("description_content1 not in", values, "descriptionContent1");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent1Between(String value1, String value2) {
            addCriterion("description_content1 between", value1, value2, "descriptionContent1");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent1NotBetween(String value1, String value2) {
            addCriterion("description_content1 not between", value1, value2, "descriptionContent1");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent2IsNull() {
            addCriterion("description_content2 is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent2IsNotNull() {
            addCriterion("description_content2 is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent2EqualTo(String value) {
            addCriterion("description_content2 =", value, "descriptionContent2");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent2NotEqualTo(String value) {
            addCriterion("description_content2 <>", value, "descriptionContent2");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent2GreaterThan(String value) {
            addCriterion("description_content2 >", value, "descriptionContent2");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent2GreaterThanOrEqualTo(String value) {
            addCriterion("description_content2 >=", value, "descriptionContent2");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent2LessThan(String value) {
            addCriterion("description_content2 <", value, "descriptionContent2");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent2LessThanOrEqualTo(String value) {
            addCriterion("description_content2 <=", value, "descriptionContent2");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent2Like(String value) {
            addCriterion("description_content2 like", value, "descriptionContent2");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent2NotLike(String value) {
            addCriterion("description_content2 not like", value, "descriptionContent2");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent2In(List<String> values) {
            addCriterion("description_content2 in", values, "descriptionContent2");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent2NotIn(List<String> values) {
            addCriterion("description_content2 not in", values, "descriptionContent2");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent2Between(String value1, String value2) {
            addCriterion("description_content2 between", value1, value2, "descriptionContent2");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent2NotBetween(String value1, String value2) {
            addCriterion("description_content2 not between", value1, value2, "descriptionContent2");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent3IsNull() {
            addCriterion("description_content3 is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent3IsNotNull() {
            addCriterion("description_content3 is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent3EqualTo(String value) {
            addCriterion("description_content3 =", value, "descriptionContent3");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent3NotEqualTo(String value) {
            addCriterion("description_content3 <>", value, "descriptionContent3");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent3GreaterThan(String value) {
            addCriterion("description_content3 >", value, "descriptionContent3");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent3GreaterThanOrEqualTo(String value) {
            addCriterion("description_content3 >=", value, "descriptionContent3");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent3LessThan(String value) {
            addCriterion("description_content3 <", value, "descriptionContent3");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent3LessThanOrEqualTo(String value) {
            addCriterion("description_content3 <=", value, "descriptionContent3");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent3Like(String value) {
            addCriterion("description_content3 like", value, "descriptionContent3");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent3NotLike(String value) {
            addCriterion("description_content3 not like", value, "descriptionContent3");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent3In(List<String> values) {
            addCriterion("description_content3 in", values, "descriptionContent3");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent3NotIn(List<String> values) {
            addCriterion("description_content3 not in", values, "descriptionContent3");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent3Between(String value1, String value2) {
            addCriterion("description_content3 between", value1, value2, "descriptionContent3");
            return (Criteria) this;
        }

        public Criteria andDescriptionContent3NotBetween(String value1, String value2) {
            addCriterion("description_content3 not between", value1, value2, "descriptionContent3");
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