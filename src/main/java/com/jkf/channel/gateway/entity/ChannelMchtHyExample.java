package com.jkf.channel.gateway.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChannelMchtHyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChannelMchtHyExample() {
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

        public Criteria andMchIdIsNull() {
            addCriterion("mch_id is null");
            return (Criteria) this;
        }

        public Criteria andMchIdIsNotNull() {
            addCriterion("mch_id is not null");
            return (Criteria) this;
        }

        public Criteria andMchIdEqualTo(Long value) {
            addCriterion("mch_id =", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotEqualTo(Long value) {
            addCriterion("mch_id <>", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdGreaterThan(Long value) {
            addCriterion("mch_id >", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdGreaterThanOrEqualTo(Long value) {
            addCriterion("mch_id >=", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdLessThan(Long value) {
            addCriterion("mch_id <", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdLessThanOrEqualTo(Long value) {
            addCriterion("mch_id <=", value, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdIn(List<Long> values) {
            addCriterion("mch_id in", values, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotIn(List<Long> values) {
            addCriterion("mch_id not in", values, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdBetween(Long value1, Long value2) {
            addCriterion("mch_id between", value1, value2, "mchId");
            return (Criteria) this;
        }

        public Criteria andMchIdNotBetween(Long value1, Long value2) {
            addCriterion("mch_id not between", value1, value2, "mchId");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNull() {
            addCriterion("channel_id is null");
            return (Criteria) this;
        }

        public Criteria andChannelIdIsNotNull() {
            addCriterion("channel_id is not null");
            return (Criteria) this;
        }

        public Criteria andChannelIdEqualTo(Long value) {
            addCriterion("channel_id =", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotEqualTo(Long value) {
            addCriterion("channel_id <>", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThan(Long value) {
            addCriterion("channel_id >", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("channel_id >=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThan(Long value) {
            addCriterion("channel_id <", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdLessThanOrEqualTo(Long value) {
            addCriterion("channel_id <=", value, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdIn(List<Long> values) {
            addCriterion("channel_id in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotIn(List<Long> values) {
            addCriterion("channel_id not in", values, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdBetween(Long value1, Long value2) {
            addCriterion("channel_id between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelIdNotBetween(Long value1, Long value2) {
            addCriterion("channel_id not between", value1, value2, "channelId");
            return (Criteria) this;
        }

        public Criteria andChannelMchtNoIsNull() {
            addCriterion("channel_mcht_no is null");
            return (Criteria) this;
        }

        public Criteria andChannelMchtNoIsNotNull() {
            addCriterion("channel_mcht_no is not null");
            return (Criteria) this;
        }

        public Criteria andChannelMchtNoEqualTo(String value) {
            addCriterion("channel_mcht_no =", value, "channelMchtNo");
            return (Criteria) this;
        }

        public Criteria andChannelMchtNoNotEqualTo(String value) {
            addCriterion("channel_mcht_no <>", value, "channelMchtNo");
            return (Criteria) this;
        }

        public Criteria andChannelMchtNoGreaterThan(String value) {
            addCriterion("channel_mcht_no >", value, "channelMchtNo");
            return (Criteria) this;
        }

        public Criteria andChannelMchtNoGreaterThanOrEqualTo(String value) {
            addCriterion("channel_mcht_no >=", value, "channelMchtNo");
            return (Criteria) this;
        }

        public Criteria andChannelMchtNoLessThan(String value) {
            addCriterion("channel_mcht_no <", value, "channelMchtNo");
            return (Criteria) this;
        }

        public Criteria andChannelMchtNoLessThanOrEqualTo(String value) {
            addCriterion("channel_mcht_no <=", value, "channelMchtNo");
            return (Criteria) this;
        }

        public Criteria andChannelMchtNoLike(String value) {
            addCriterion("channel_mcht_no like", value, "channelMchtNo");
            return (Criteria) this;
        }

        public Criteria andChannelMchtNoNotLike(String value) {
            addCriterion("channel_mcht_no not like", value, "channelMchtNo");
            return (Criteria) this;
        }

        public Criteria andChannelMchtNoIn(List<String> values) {
            addCriterion("channel_mcht_no in", values, "channelMchtNo");
            return (Criteria) this;
        }

        public Criteria andChannelMchtNoNotIn(List<String> values) {
            addCriterion("channel_mcht_no not in", values, "channelMchtNo");
            return (Criteria) this;
        }

        public Criteria andChannelMchtNoBetween(String value1, String value2) {
            addCriterion("channel_mcht_no between", value1, value2, "channelMchtNo");
            return (Criteria) this;
        }

        public Criteria andChannelMchtNoNotBetween(String value1, String value2) {
            addCriterion("channel_mcht_no not between", value1, value2, "channelMchtNo");
            return (Criteria) this;
        }

        public Criteria andChannelMchtNameIsNull() {
            addCriterion("channel_mcht_name is null");
            return (Criteria) this;
        }

        public Criteria andChannelMchtNameIsNotNull() {
            addCriterion("channel_mcht_name is not null");
            return (Criteria) this;
        }

        public Criteria andChannelMchtNameEqualTo(String value) {
            addCriterion("channel_mcht_name =", value, "channelMchtName");
            return (Criteria) this;
        }

        public Criteria andChannelMchtNameNotEqualTo(String value) {
            addCriterion("channel_mcht_name <>", value, "channelMchtName");
            return (Criteria) this;
        }

        public Criteria andChannelMchtNameGreaterThan(String value) {
            addCriterion("channel_mcht_name >", value, "channelMchtName");
            return (Criteria) this;
        }

        public Criteria andChannelMchtNameGreaterThanOrEqualTo(String value) {
            addCriterion("channel_mcht_name >=", value, "channelMchtName");
            return (Criteria) this;
        }

        public Criteria andChannelMchtNameLessThan(String value) {
            addCriterion("channel_mcht_name <", value, "channelMchtName");
            return (Criteria) this;
        }

        public Criteria andChannelMchtNameLessThanOrEqualTo(String value) {
            addCriterion("channel_mcht_name <=", value, "channelMchtName");
            return (Criteria) this;
        }

        public Criteria andChannelMchtNameLike(String value) {
            addCriterion("channel_mcht_name like", value, "channelMchtName");
            return (Criteria) this;
        }

        public Criteria andChannelMchtNameNotLike(String value) {
            addCriterion("channel_mcht_name not like", value, "channelMchtName");
            return (Criteria) this;
        }

        public Criteria andChannelMchtNameIn(List<String> values) {
            addCriterion("channel_mcht_name in", values, "channelMchtName");
            return (Criteria) this;
        }

        public Criteria andChannelMchtNameNotIn(List<String> values) {
            addCriterion("channel_mcht_name not in", values, "channelMchtName");
            return (Criteria) this;
        }

        public Criteria andChannelMchtNameBetween(String value1, String value2) {
            addCriterion("channel_mcht_name between", value1, value2, "channelMchtName");
            return (Criteria) this;
        }

        public Criteria andChannelMchtNameNotBetween(String value1, String value2) {
            addCriterion("channel_mcht_name not between", value1, value2, "channelMchtName");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNull() {
            addCriterion("short_name is null");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNotNull() {
            addCriterion("short_name is not null");
            return (Criteria) this;
        }

        public Criteria andShortNameEqualTo(String value) {
            addCriterion("short_name =", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotEqualTo(String value) {
            addCriterion("short_name <>", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThan(String value) {
            addCriterion("short_name >", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("short_name >=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThan(String value) {
            addCriterion("short_name <", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThanOrEqualTo(String value) {
            addCriterion("short_name <=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLike(String value) {
            addCriterion("short_name like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotLike(String value) {
            addCriterion("short_name not like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameIn(List<String> values) {
            addCriterion("short_name in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotIn(List<String> values) {
            addCriterion("short_name not in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameBetween(String value1, String value2) {
            addCriterion("short_name between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotBetween(String value1, String value2) {
            addCriterion("short_name not between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeIsNull() {
            addCriterion("category_type is null");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeIsNotNull() {
            addCriterion("category_type is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeEqualTo(String value) {
            addCriterion("category_type =", value, "categoryType");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeNotEqualTo(String value) {
            addCriterion("category_type <>", value, "categoryType");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeGreaterThan(String value) {
            addCriterion("category_type >", value, "categoryType");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeGreaterThanOrEqualTo(String value) {
            addCriterion("category_type >=", value, "categoryType");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeLessThan(String value) {
            addCriterion("category_type <", value, "categoryType");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeLessThanOrEqualTo(String value) {
            addCriterion("category_type <=", value, "categoryType");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeLike(String value) {
            addCriterion("category_type like", value, "categoryType");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeNotLike(String value) {
            addCriterion("category_type not like", value, "categoryType");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeIn(List<String> values) {
            addCriterion("category_type in", values, "categoryType");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeNotIn(List<String> values) {
            addCriterion("category_type not in", values, "categoryType");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeBetween(String value1, String value2) {
            addCriterion("category_type between", value1, value2, "categoryType");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeNotBetween(String value1, String value2) {
            addCriterion("category_type not between", value1, value2, "categoryType");
            return (Criteria) this;
        }

        public Criteria andCorEmailIsNull() {
            addCriterion("cor_email is null");
            return (Criteria) this;
        }

        public Criteria andCorEmailIsNotNull() {
            addCriterion("cor_email is not null");
            return (Criteria) this;
        }

        public Criteria andCorEmailEqualTo(String value) {
            addCriterion("cor_email =", value, "corEmail");
            return (Criteria) this;
        }

        public Criteria andCorEmailNotEqualTo(String value) {
            addCriterion("cor_email <>", value, "corEmail");
            return (Criteria) this;
        }

        public Criteria andCorEmailGreaterThan(String value) {
            addCriterion("cor_email >", value, "corEmail");
            return (Criteria) this;
        }

        public Criteria andCorEmailGreaterThanOrEqualTo(String value) {
            addCriterion("cor_email >=", value, "corEmail");
            return (Criteria) this;
        }

        public Criteria andCorEmailLessThan(String value) {
            addCriterion("cor_email <", value, "corEmail");
            return (Criteria) this;
        }

        public Criteria andCorEmailLessThanOrEqualTo(String value) {
            addCriterion("cor_email <=", value, "corEmail");
            return (Criteria) this;
        }

        public Criteria andCorEmailLike(String value) {
            addCriterion("cor_email like", value, "corEmail");
            return (Criteria) this;
        }

        public Criteria andCorEmailNotLike(String value) {
            addCriterion("cor_email not like", value, "corEmail");
            return (Criteria) this;
        }

        public Criteria andCorEmailIn(List<String> values) {
            addCriterion("cor_email in", values, "corEmail");
            return (Criteria) this;
        }

        public Criteria andCorEmailNotIn(List<String> values) {
            addCriterion("cor_email not in", values, "corEmail");
            return (Criteria) this;
        }

        public Criteria andCorEmailBetween(String value1, String value2) {
            addCriterion("cor_email between", value1, value2, "corEmail");
            return (Criteria) this;
        }

        public Criteria andCorEmailNotBetween(String value1, String value2) {
            addCriterion("cor_email not between", value1, value2, "corEmail");
            return (Criteria) this;
        }

        public Criteria andCorTelIsNull() {
            addCriterion("cor_tel is null");
            return (Criteria) this;
        }

        public Criteria andCorTelIsNotNull() {
            addCriterion("cor_tel is not null");
            return (Criteria) this;
        }

        public Criteria andCorTelEqualTo(String value) {
            addCriterion("cor_tel =", value, "corTel");
            return (Criteria) this;
        }

        public Criteria andCorTelNotEqualTo(String value) {
            addCriterion("cor_tel <>", value, "corTel");
            return (Criteria) this;
        }

        public Criteria andCorTelGreaterThan(String value) {
            addCriterion("cor_tel >", value, "corTel");
            return (Criteria) this;
        }

        public Criteria andCorTelGreaterThanOrEqualTo(String value) {
            addCriterion("cor_tel >=", value, "corTel");
            return (Criteria) this;
        }

        public Criteria andCorTelLessThan(String value) {
            addCriterion("cor_tel <", value, "corTel");
            return (Criteria) this;
        }

        public Criteria andCorTelLessThanOrEqualTo(String value) {
            addCriterion("cor_tel <=", value, "corTel");
            return (Criteria) this;
        }

        public Criteria andCorTelLike(String value) {
            addCriterion("cor_tel like", value, "corTel");
            return (Criteria) this;
        }

        public Criteria andCorTelNotLike(String value) {
            addCriterion("cor_tel not like", value, "corTel");
            return (Criteria) this;
        }

        public Criteria andCorTelIn(List<String> values) {
            addCriterion("cor_tel in", values, "corTel");
            return (Criteria) this;
        }

        public Criteria andCorTelNotIn(List<String> values) {
            addCriterion("cor_tel not in", values, "corTel");
            return (Criteria) this;
        }

        public Criteria andCorTelBetween(String value1, String value2) {
            addCriterion("cor_tel between", value1, value2, "corTel");
            return (Criteria) this;
        }

        public Criteria andCorTelNotBetween(String value1, String value2) {
            addCriterion("cor_tel not between", value1, value2, "corTel");
            return (Criteria) this;
        }

        public Criteria andScaleIsNull() {
            addCriterion("`scale` is null");
            return (Criteria) this;
        }

        public Criteria andScaleIsNotNull() {
            addCriterion("`scale` is not null");
            return (Criteria) this;
        }

        public Criteria andScaleEqualTo(String value) {
            addCriterion("`scale` =", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleNotEqualTo(String value) {
            addCriterion("`scale` <>", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleGreaterThan(String value) {
            addCriterion("`scale` >", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleGreaterThanOrEqualTo(String value) {
            addCriterion("`scale` >=", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleLessThan(String value) {
            addCriterion("`scale` <", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleLessThanOrEqualTo(String value) {
            addCriterion("`scale` <=", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleLike(String value) {
            addCriterion("`scale` like", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleNotLike(String value) {
            addCriterion("`scale` not like", value, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleIn(List<String> values) {
            addCriterion("`scale` in", values, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleNotIn(List<String> values) {
            addCriterion("`scale` not in", values, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleBetween(String value1, String value2) {
            addCriterion("`scale` between", value1, value2, "scale");
            return (Criteria) this;
        }

        public Criteria andScaleNotBetween(String value1, String value2) {
            addCriterion("`scale` not between", value1, value2, "scale");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("user_type is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("user_type is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(String value) {
            addCriterion("user_type =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(String value) {
            addCriterion("user_type <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(String value) {
            addCriterion("user_type >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(String value) {
            addCriterion("user_type >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(String value) {
            addCriterion("user_type <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(String value) {
            addCriterion("user_type <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLike(String value) {
            addCriterion("user_type like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotLike(String value) {
            addCriterion("user_type not like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<String> values) {
            addCriterion("user_type in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<String> values) {
            addCriterion("user_type not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(String value1, String value2) {
            addCriterion("user_type between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(String value1, String value2) {
            addCriterion("user_type not between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNoIsNull() {
            addCriterion("business_license_no is null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNoIsNotNull() {
            addCriterion("business_license_no is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNoEqualTo(String value) {
            addCriterion("business_license_no =", value, "businessLicenseNo");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNoNotEqualTo(String value) {
            addCriterion("business_license_no <>", value, "businessLicenseNo");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNoGreaterThan(String value) {
            addCriterion("business_license_no >", value, "businessLicenseNo");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNoGreaterThanOrEqualTo(String value) {
            addCriterion("business_license_no >=", value, "businessLicenseNo");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNoLessThan(String value) {
            addCriterion("business_license_no <", value, "businessLicenseNo");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNoLessThanOrEqualTo(String value) {
            addCriterion("business_license_no <=", value, "businessLicenseNo");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNoLike(String value) {
            addCriterion("business_license_no like", value, "businessLicenseNo");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNoNotLike(String value) {
            addCriterion("business_license_no not like", value, "businessLicenseNo");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNoIn(List<String> values) {
            addCriterion("business_license_no in", values, "businessLicenseNo");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNoNotIn(List<String> values) {
            addCriterion("business_license_no not in", values, "businessLicenseNo");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNoBetween(String value1, String value2) {
            addCriterion("business_license_no between", value1, value2, "businessLicenseNo");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNoNotBetween(String value1, String value2) {
            addCriterion("business_license_no not between", value1, value2, "businessLicenseNo");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseExpireStartIsNull() {
            addCriterion("business_license_expire_start is null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseExpireStartIsNotNull() {
            addCriterion("business_license_expire_start is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseExpireStartEqualTo(String value) {
            addCriterion("business_license_expire_start =", value, "businessLicenseExpireStart");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseExpireStartNotEqualTo(String value) {
            addCriterion("business_license_expire_start <>", value, "businessLicenseExpireStart");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseExpireStartGreaterThan(String value) {
            addCriterion("business_license_expire_start >", value, "businessLicenseExpireStart");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseExpireStartGreaterThanOrEqualTo(String value) {
            addCriterion("business_license_expire_start >=", value, "businessLicenseExpireStart");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseExpireStartLessThan(String value) {
            addCriterion("business_license_expire_start <", value, "businessLicenseExpireStart");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseExpireStartLessThanOrEqualTo(String value) {
            addCriterion("business_license_expire_start <=", value, "businessLicenseExpireStart");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseExpireStartLike(String value) {
            addCriterion("business_license_expire_start like", value, "businessLicenseExpireStart");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseExpireStartNotLike(String value) {
            addCriterion("business_license_expire_start not like", value, "businessLicenseExpireStart");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseExpireStartIn(List<String> values) {
            addCriterion("business_license_expire_start in", values, "businessLicenseExpireStart");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseExpireStartNotIn(List<String> values) {
            addCriterion("business_license_expire_start not in", values, "businessLicenseExpireStart");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseExpireStartBetween(String value1, String value2) {
            addCriterion("business_license_expire_start between", value1, value2, "businessLicenseExpireStart");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseExpireStartNotBetween(String value1, String value2) {
            addCriterion("business_license_expire_start not between", value1, value2, "businessLicenseExpireStart");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseExpireEndIsNull() {
            addCriterion("business_license_expire_end is null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseExpireEndIsNotNull() {
            addCriterion("business_license_expire_end is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseExpireEndEqualTo(String value) {
            addCriterion("business_license_expire_end =", value, "businessLicenseExpireEnd");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseExpireEndNotEqualTo(String value) {
            addCriterion("business_license_expire_end <>", value, "businessLicenseExpireEnd");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseExpireEndGreaterThan(String value) {
            addCriterion("business_license_expire_end >", value, "businessLicenseExpireEnd");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseExpireEndGreaterThanOrEqualTo(String value) {
            addCriterion("business_license_expire_end >=", value, "businessLicenseExpireEnd");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseExpireEndLessThan(String value) {
            addCriterion("business_license_expire_end <", value, "businessLicenseExpireEnd");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseExpireEndLessThanOrEqualTo(String value) {
            addCriterion("business_license_expire_end <=", value, "businessLicenseExpireEnd");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseExpireEndLike(String value) {
            addCriterion("business_license_expire_end like", value, "businessLicenseExpireEnd");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseExpireEndNotLike(String value) {
            addCriterion("business_license_expire_end not like", value, "businessLicenseExpireEnd");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseExpireEndIn(List<String> values) {
            addCriterion("business_license_expire_end in", values, "businessLicenseExpireEnd");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseExpireEndNotIn(List<String> values) {
            addCriterion("business_license_expire_end not in", values, "businessLicenseExpireEnd");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseExpireEndBetween(String value1, String value2) {
            addCriterion("business_license_expire_end between", value1, value2, "businessLicenseExpireEnd");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseExpireEndNotBetween(String value1, String value2) {
            addCriterion("business_license_expire_end not between", value1, value2, "businessLicenseExpireEnd");
            return (Criteria) this;
        }

        public Criteria andContactNameIsNull() {
            addCriterion("contact_name is null");
            return (Criteria) this;
        }

        public Criteria andContactNameIsNotNull() {
            addCriterion("contact_name is not null");
            return (Criteria) this;
        }

        public Criteria andContactNameEqualTo(String value) {
            addCriterion("contact_name =", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotEqualTo(String value) {
            addCriterion("contact_name <>", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameGreaterThan(String value) {
            addCriterion("contact_name >", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameGreaterThanOrEqualTo(String value) {
            addCriterion("contact_name >=", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLessThan(String value) {
            addCriterion("contact_name <", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLessThanOrEqualTo(String value) {
            addCriterion("contact_name <=", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameLike(String value) {
            addCriterion("contact_name like", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotLike(String value) {
            addCriterion("contact_name not like", value, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameIn(List<String> values) {
            addCriterion("contact_name in", values, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotIn(List<String> values) {
            addCriterion("contact_name not in", values, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameBetween(String value1, String value2) {
            addCriterion("contact_name between", value1, value2, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactNameNotBetween(String value1, String value2) {
            addCriterion("contact_name not between", value1, value2, "contactName");
            return (Criteria) this;
        }

        public Criteria andContactTelIsNull() {
            addCriterion("contact_tel is null");
            return (Criteria) this;
        }

        public Criteria andContactTelIsNotNull() {
            addCriterion("contact_tel is not null");
            return (Criteria) this;
        }

        public Criteria andContactTelEqualTo(String value) {
            addCriterion("contact_tel =", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelNotEqualTo(String value) {
            addCriterion("contact_tel <>", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelGreaterThan(String value) {
            addCriterion("contact_tel >", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelGreaterThanOrEqualTo(String value) {
            addCriterion("contact_tel >=", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelLessThan(String value) {
            addCriterion("contact_tel <", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelLessThanOrEqualTo(String value) {
            addCriterion("contact_tel <=", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelLike(String value) {
            addCriterion("contact_tel like", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelNotLike(String value) {
            addCriterion("contact_tel not like", value, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelIn(List<String> values) {
            addCriterion("contact_tel in", values, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelNotIn(List<String> values) {
            addCriterion("contact_tel not in", values, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelBetween(String value1, String value2) {
            addCriterion("contact_tel between", value1, value2, "contactTel");
            return (Criteria) this;
        }

        public Criteria andContactTelNotBetween(String value1, String value2) {
            addCriterion("contact_tel not between", value1, value2, "contactTel");
            return (Criteria) this;
        }

        public Criteria andIdNotTypeIsNull() {
            addCriterion("id_not_type is null");
            return (Criteria) this;
        }

        public Criteria andIdNotTypeIsNotNull() {
            addCriterion("id_not_type is not null");
            return (Criteria) this;
        }

        public Criteria andIdNotTypeEqualTo(String value) {
            addCriterion("id_not_type =", value, "idNotType");
            return (Criteria) this;
        }

        public Criteria andIdNotTypeNotEqualTo(String value) {
            addCriterion("id_not_type <>", value, "idNotType");
            return (Criteria) this;
        }

        public Criteria andIdNotTypeGreaterThan(String value) {
            addCriterion("id_not_type >", value, "idNotType");
            return (Criteria) this;
        }

        public Criteria andIdNotTypeGreaterThanOrEqualTo(String value) {
            addCriterion("id_not_type >=", value, "idNotType");
            return (Criteria) this;
        }

        public Criteria andIdNotTypeLessThan(String value) {
            addCriterion("id_not_type <", value, "idNotType");
            return (Criteria) this;
        }

        public Criteria andIdNotTypeLessThanOrEqualTo(String value) {
            addCriterion("id_not_type <=", value, "idNotType");
            return (Criteria) this;
        }

        public Criteria andIdNotTypeLike(String value) {
            addCriterion("id_not_type like", value, "idNotType");
            return (Criteria) this;
        }

        public Criteria andIdNotTypeNotLike(String value) {
            addCriterion("id_not_type not like", value, "idNotType");
            return (Criteria) this;
        }

        public Criteria andIdNotTypeIn(List<String> values) {
            addCriterion("id_not_type in", values, "idNotType");
            return (Criteria) this;
        }

        public Criteria andIdNotTypeNotIn(List<String> values) {
            addCriterion("id_not_type not in", values, "idNotType");
            return (Criteria) this;
        }

        public Criteria andIdNotTypeBetween(String value1, String value2) {
            addCriterion("id_not_type between", value1, value2, "idNotType");
            return (Criteria) this;
        }

        public Criteria andIdNotTypeNotBetween(String value1, String value2) {
            addCriterion("id_not_type not between", value1, value2, "idNotType");
            return (Criteria) this;
        }

        public Criteria andIdNoIsNull() {
            addCriterion("id_no is null");
            return (Criteria) this;
        }

        public Criteria andIdNoIsNotNull() {
            addCriterion("id_no is not null");
            return (Criteria) this;
        }

        public Criteria andIdNoEqualTo(String value) {
            addCriterion("id_no =", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoNotEqualTo(String value) {
            addCriterion("id_no <>", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoGreaterThan(String value) {
            addCriterion("id_no >", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoGreaterThanOrEqualTo(String value) {
            addCriterion("id_no >=", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoLessThan(String value) {
            addCriterion("id_no <", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoLessThanOrEqualTo(String value) {
            addCriterion("id_no <=", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoLike(String value) {
            addCriterion("id_no like", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoNotLike(String value) {
            addCriterion("id_no not like", value, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoIn(List<String> values) {
            addCriterion("id_no in", values, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoNotIn(List<String> values) {
            addCriterion("id_no not in", values, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoBetween(String value1, String value2) {
            addCriterion("id_no between", value1, value2, "idNo");
            return (Criteria) this;
        }

        public Criteria andIdNoNotBetween(String value1, String value2) {
            addCriterion("id_no not between", value1, value2, "idNo");
            return (Criteria) this;
        }

        public Criteria andIssDateIsNull() {
            addCriterion("iss_date is null");
            return (Criteria) this;
        }

        public Criteria andIssDateIsNotNull() {
            addCriterion("iss_date is not null");
            return (Criteria) this;
        }

        public Criteria andIssDateEqualTo(String value) {
            addCriterion("iss_date =", value, "issDate");
            return (Criteria) this;
        }

        public Criteria andIssDateNotEqualTo(String value) {
            addCriterion("iss_date <>", value, "issDate");
            return (Criteria) this;
        }

        public Criteria andIssDateGreaterThan(String value) {
            addCriterion("iss_date >", value, "issDate");
            return (Criteria) this;
        }

        public Criteria andIssDateGreaterThanOrEqualTo(String value) {
            addCriterion("iss_date >=", value, "issDate");
            return (Criteria) this;
        }

        public Criteria andIssDateLessThan(String value) {
            addCriterion("iss_date <", value, "issDate");
            return (Criteria) this;
        }

        public Criteria andIssDateLessThanOrEqualTo(String value) {
            addCriterion("iss_date <=", value, "issDate");
            return (Criteria) this;
        }

        public Criteria andIssDateLike(String value) {
            addCriterion("iss_date like", value, "issDate");
            return (Criteria) this;
        }

        public Criteria andIssDateNotLike(String value) {
            addCriterion("iss_date not like", value, "issDate");
            return (Criteria) this;
        }

        public Criteria andIssDateIn(List<String> values) {
            addCriterion("iss_date in", values, "issDate");
            return (Criteria) this;
        }

        public Criteria andIssDateNotIn(List<String> values) {
            addCriterion("iss_date not in", values, "issDate");
            return (Criteria) this;
        }

        public Criteria andIssDateBetween(String value1, String value2) {
            addCriterion("iss_date between", value1, value2, "issDate");
            return (Criteria) this;
        }

        public Criteria andIssDateNotBetween(String value1, String value2) {
            addCriterion("iss_date not between", value1, value2, "issDate");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andExpiryDateIsNull() {
            addCriterion("expiry_date is null");
            return (Criteria) this;
        }

        public Criteria andExpiryDateIsNotNull() {
            addCriterion("expiry_date is not null");
            return (Criteria) this;
        }

        public Criteria andExpiryDateEqualTo(String value) {
            addCriterion("expiry_date =", value, "expiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateNotEqualTo(String value) {
            addCriterion("expiry_date <>", value, "expiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateGreaterThan(String value) {
            addCriterion("expiry_date >", value, "expiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateGreaterThanOrEqualTo(String value) {
            addCriterion("expiry_date >=", value, "expiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateLessThan(String value) {
            addCriterion("expiry_date <", value, "expiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateLessThanOrEqualTo(String value) {
            addCriterion("expiry_date <=", value, "expiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateLike(String value) {
            addCriterion("expiry_date like", value, "expiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateNotLike(String value) {
            addCriterion("expiry_date not like", value, "expiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateIn(List<String> values) {
            addCriterion("expiry_date in", values, "expiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateNotIn(List<String> values) {
            addCriterion("expiry_date not in", values, "expiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateBetween(String value1, String value2) {
            addCriterion("expiry_date between", value1, value2, "expiryDate");
            return (Criteria) this;
        }

        public Criteria andExpiryDateNotBetween(String value1, String value2) {
            addCriterion("expiry_date not between", value1, value2, "expiryDate");
            return (Criteria) this;
        }

        public Criteria andDistrictIsNull() {
            addCriterion("district is null");
            return (Criteria) this;
        }

        public Criteria andDistrictIsNotNull() {
            addCriterion("district is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictEqualTo(String value) {
            addCriterion("district =", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotEqualTo(String value) {
            addCriterion("district <>", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictGreaterThan(String value) {
            addCriterion("district >", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictGreaterThanOrEqualTo(String value) {
            addCriterion("district >=", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLessThan(String value) {
            addCriterion("district <", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLessThanOrEqualTo(String value) {
            addCriterion("district <=", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictLike(String value) {
            addCriterion("district like", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotLike(String value) {
            addCriterion("district not like", value, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictIn(List<String> values) {
            addCriterion("district in", values, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotIn(List<String> values) {
            addCriterion("district not in", values, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictBetween(String value1, String value2) {
            addCriterion("district between", value1, value2, "district");
            return (Criteria) this;
        }

        public Criteria andDistrictNotBetween(String value1, String value2) {
            addCriterion("district not between", value1, value2, "district");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andContactEmailIsNull() {
            addCriterion("contact_email is null");
            return (Criteria) this;
        }

        public Criteria andContactEmailIsNotNull() {
            addCriterion("contact_email is not null");
            return (Criteria) this;
        }

        public Criteria andContactEmailEqualTo(String value) {
            addCriterion("contact_email =", value, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailNotEqualTo(String value) {
            addCriterion("contact_email <>", value, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailGreaterThan(String value) {
            addCriterion("contact_email >", value, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailGreaterThanOrEqualTo(String value) {
            addCriterion("contact_email >=", value, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailLessThan(String value) {
            addCriterion("contact_email <", value, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailLessThanOrEqualTo(String value) {
            addCriterion("contact_email <=", value, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailLike(String value) {
            addCriterion("contact_email like", value, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailNotLike(String value) {
            addCriterion("contact_email not like", value, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailIn(List<String> values) {
            addCriterion("contact_email in", values, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailNotIn(List<String> values) {
            addCriterion("contact_email not in", values, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailBetween(String value1, String value2) {
            addCriterion("contact_email between", value1, value2, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andContactEmailNotBetween(String value1, String value2) {
            addCriterion("contact_email not between", value1, value2, "contactEmail");
            return (Criteria) this;
        }

        public Criteria andPeriodsIsNull() {
            addCriterion("periods is null");
            return (Criteria) this;
        }

        public Criteria andPeriodsIsNotNull() {
            addCriterion("periods is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodsEqualTo(String value) {
            addCriterion("periods =", value, "periods");
            return (Criteria) this;
        }

        public Criteria andPeriodsNotEqualTo(String value) {
            addCriterion("periods <>", value, "periods");
            return (Criteria) this;
        }

        public Criteria andPeriodsGreaterThan(String value) {
            addCriterion("periods >", value, "periods");
            return (Criteria) this;
        }

        public Criteria andPeriodsGreaterThanOrEqualTo(String value) {
            addCriterion("periods >=", value, "periods");
            return (Criteria) this;
        }

        public Criteria andPeriodsLessThan(String value) {
            addCriterion("periods <", value, "periods");
            return (Criteria) this;
        }

        public Criteria andPeriodsLessThanOrEqualTo(String value) {
            addCriterion("periods <=", value, "periods");
            return (Criteria) this;
        }

        public Criteria andPeriodsLike(String value) {
            addCriterion("periods like", value, "periods");
            return (Criteria) this;
        }

        public Criteria andPeriodsNotLike(String value) {
            addCriterion("periods not like", value, "periods");
            return (Criteria) this;
        }

        public Criteria andPeriodsIn(List<String> values) {
            addCriterion("periods in", values, "periods");
            return (Criteria) this;
        }

        public Criteria andPeriodsNotIn(List<String> values) {
            addCriterion("periods not in", values, "periods");
            return (Criteria) this;
        }

        public Criteria andPeriodsBetween(String value1, String value2) {
            addCriterion("periods between", value1, value2, "periods");
            return (Criteria) this;
        }

        public Criteria andPeriodsNotBetween(String value1, String value2) {
            addCriterion("periods not between", value1, value2, "periods");
            return (Criteria) this;
        }

        public Criteria andChannelNameIsNull() {
            addCriterion("channel_name is null");
            return (Criteria) this;
        }

        public Criteria andChannelNameIsNotNull() {
            addCriterion("channel_name is not null");
            return (Criteria) this;
        }

        public Criteria andChannelNameEqualTo(String value) {
            addCriterion("channel_name =", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameNotEqualTo(String value) {
            addCriterion("channel_name <>", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameGreaterThan(String value) {
            addCriterion("channel_name >", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameGreaterThanOrEqualTo(String value) {
            addCriterion("channel_name >=", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameLessThan(String value) {
            addCriterion("channel_name <", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameLessThanOrEqualTo(String value) {
            addCriterion("channel_name <=", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameLike(String value) {
            addCriterion("channel_name like", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameNotLike(String value) {
            addCriterion("channel_name not like", value, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameIn(List<String> values) {
            addCriterion("channel_name in", values, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameNotIn(List<String> values) {
            addCriterion("channel_name not in", values, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameBetween(String value1, String value2) {
            addCriterion("channel_name between", value1, value2, "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelNameNotBetween(String value1, String value2) {
            addCriterion("channel_name not between", value1, value2, "channelName");
            return (Criteria) this;
        }

        public Criteria andFeeModeIsNull() {
            addCriterion("fee_mode is null");
            return (Criteria) this;
        }

        public Criteria andFeeModeIsNotNull() {
            addCriterion("fee_mode is not null");
            return (Criteria) this;
        }

        public Criteria andFeeModeEqualTo(String value) {
            addCriterion("fee_mode =", value, "feeMode");
            return (Criteria) this;
        }

        public Criteria andFeeModeNotEqualTo(String value) {
            addCriterion("fee_mode <>", value, "feeMode");
            return (Criteria) this;
        }

        public Criteria andFeeModeGreaterThan(String value) {
            addCriterion("fee_mode >", value, "feeMode");
            return (Criteria) this;
        }

        public Criteria andFeeModeGreaterThanOrEqualTo(String value) {
            addCriterion("fee_mode >=", value, "feeMode");
            return (Criteria) this;
        }

        public Criteria andFeeModeLessThan(String value) {
            addCriterion("fee_mode <", value, "feeMode");
            return (Criteria) this;
        }

        public Criteria andFeeModeLessThanOrEqualTo(String value) {
            addCriterion("fee_mode <=", value, "feeMode");
            return (Criteria) this;
        }

        public Criteria andFeeModeLike(String value) {
            addCriterion("fee_mode like", value, "feeMode");
            return (Criteria) this;
        }

        public Criteria andFeeModeNotLike(String value) {
            addCriterion("fee_mode not like", value, "feeMode");
            return (Criteria) this;
        }

        public Criteria andFeeModeIn(List<String> values) {
            addCriterion("fee_mode in", values, "feeMode");
            return (Criteria) this;
        }

        public Criteria andFeeModeNotIn(List<String> values) {
            addCriterion("fee_mode not in", values, "feeMode");
            return (Criteria) this;
        }

        public Criteria andFeeModeBetween(String value1, String value2) {
            addCriterion("fee_mode between", value1, value2, "feeMode");
            return (Criteria) this;
        }

        public Criteria andFeeModeNotBetween(String value1, String value2) {
            addCriterion("fee_mode not between", value1, value2, "feeMode");
            return (Criteria) this;
        }

        public Criteria andOpenQuickIsNull() {
            addCriterion("open_quick is null");
            return (Criteria) this;
        }

        public Criteria andOpenQuickIsNotNull() {
            addCriterion("open_quick is not null");
            return (Criteria) this;
        }

        public Criteria andOpenQuickEqualTo(String value) {
            addCriterion("open_quick =", value, "openQuick");
            return (Criteria) this;
        }

        public Criteria andOpenQuickNotEqualTo(String value) {
            addCriterion("open_quick <>", value, "openQuick");
            return (Criteria) this;
        }

        public Criteria andOpenQuickGreaterThan(String value) {
            addCriterion("open_quick >", value, "openQuick");
            return (Criteria) this;
        }

        public Criteria andOpenQuickGreaterThanOrEqualTo(String value) {
            addCriterion("open_quick >=", value, "openQuick");
            return (Criteria) this;
        }

        public Criteria andOpenQuickLessThan(String value) {
            addCriterion("open_quick <", value, "openQuick");
            return (Criteria) this;
        }

        public Criteria andOpenQuickLessThanOrEqualTo(String value) {
            addCriterion("open_quick <=", value, "openQuick");
            return (Criteria) this;
        }

        public Criteria andOpenQuickLike(String value) {
            addCriterion("open_quick like", value, "openQuick");
            return (Criteria) this;
        }

        public Criteria andOpenQuickNotLike(String value) {
            addCriterion("open_quick not like", value, "openQuick");
            return (Criteria) this;
        }

        public Criteria andOpenQuickIn(List<String> values) {
            addCriterion("open_quick in", values, "openQuick");
            return (Criteria) this;
        }

        public Criteria andOpenQuickNotIn(List<String> values) {
            addCriterion("open_quick not in", values, "openQuick");
            return (Criteria) this;
        }

        public Criteria andOpenQuickBetween(String value1, String value2) {
            addCriterion("open_quick between", value1, value2, "openQuick");
            return (Criteria) this;
        }

        public Criteria andOpenQuickNotBetween(String value1, String value2) {
            addCriterion("open_quick not between", value1, value2, "openQuick");
            return (Criteria) this;
        }

        public Criteria andAppidIsNull() {
            addCriterion("appid is null");
            return (Criteria) this;
        }

        public Criteria andAppidIsNotNull() {
            addCriterion("appid is not null");
            return (Criteria) this;
        }

        public Criteria andAppidEqualTo(String value) {
            addCriterion("appid =", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotEqualTo(String value) {
            addCriterion("appid <>", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThan(String value) {
            addCriterion("appid >", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidGreaterThanOrEqualTo(String value) {
            addCriterion("appid >=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThan(String value) {
            addCriterion("appid <", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLessThanOrEqualTo(String value) {
            addCriterion("appid <=", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidLike(String value) {
            addCriterion("appid like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotLike(String value) {
            addCriterion("appid not like", value, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidIn(List<String> values) {
            addCriterion("appid in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotIn(List<String> values) {
            addCriterion("appid not in", values, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidBetween(String value1, String value2) {
            addCriterion("appid between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andAppidNotBetween(String value1, String value2) {
            addCriterion("appid not between", value1, value2, "appid");
            return (Criteria) this;
        }

        public Criteria andSecretIsNull() {
            addCriterion("secret is null");
            return (Criteria) this;
        }

        public Criteria andSecretIsNotNull() {
            addCriterion("secret is not null");
            return (Criteria) this;
        }

        public Criteria andSecretEqualTo(String value) {
            addCriterion("secret =", value, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretNotEqualTo(String value) {
            addCriterion("secret <>", value, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretGreaterThan(String value) {
            addCriterion("secret >", value, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretGreaterThanOrEqualTo(String value) {
            addCriterion("secret >=", value, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretLessThan(String value) {
            addCriterion("secret <", value, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretLessThanOrEqualTo(String value) {
            addCriterion("secret <=", value, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretLike(String value) {
            addCriterion("secret like", value, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretNotLike(String value) {
            addCriterion("secret not like", value, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretIn(List<String> values) {
            addCriterion("secret in", values, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretNotIn(List<String> values) {
            addCriterion("secret not in", values, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretBetween(String value1, String value2) {
            addCriterion("secret between", value1, value2, "secret");
            return (Criteria) this;
        }

        public Criteria andSecretNotBetween(String value1, String value2) {
            addCriterion("secret not between", value1, value2, "secret");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("`status` like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("`status` not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("`status` not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andFailReasonIsNull() {
            addCriterion("fail_reason is null");
            return (Criteria) this;
        }

        public Criteria andFailReasonIsNotNull() {
            addCriterion("fail_reason is not null");
            return (Criteria) this;
        }

        public Criteria andFailReasonEqualTo(String value) {
            addCriterion("fail_reason =", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonNotEqualTo(String value) {
            addCriterion("fail_reason <>", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonGreaterThan(String value) {
            addCriterion("fail_reason >", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonGreaterThanOrEqualTo(String value) {
            addCriterion("fail_reason >=", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonLessThan(String value) {
            addCriterion("fail_reason <", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonLessThanOrEqualTo(String value) {
            addCriterion("fail_reason <=", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonLike(String value) {
            addCriterion("fail_reason like", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonNotLike(String value) {
            addCriterion("fail_reason not like", value, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonIn(List<String> values) {
            addCriterion("fail_reason in", values, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonNotIn(List<String> values) {
            addCriterion("fail_reason not in", values, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonBetween(String value1, String value2) {
            addCriterion("fail_reason between", value1, value2, "failReason");
            return (Criteria) this;
        }

        public Criteria andFailReasonNotBetween(String value1, String value2) {
            addCriterion("fail_reason not between", value1, value2, "failReason");
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

        public Criteria andCreateIdIsNull() {
            addCriterion("create_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateIdIsNotNull() {
            addCriterion("create_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateIdEqualTo(Long value) {
            addCriterion("create_id =", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotEqualTo(Long value) {
            addCriterion("create_id <>", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdGreaterThan(Long value) {
            addCriterion("create_id >", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdGreaterThanOrEqualTo(Long value) {
            addCriterion("create_id >=", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLessThan(Long value) {
            addCriterion("create_id <", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdLessThanOrEqualTo(Long value) {
            addCriterion("create_id <=", value, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdIn(List<Long> values) {
            addCriterion("create_id in", values, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotIn(List<Long> values) {
            addCriterion("create_id not in", values, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdBetween(Long value1, Long value2) {
            addCriterion("create_id between", value1, value2, "createId");
            return (Criteria) this;
        }

        public Criteria andCreateIdNotBetween(Long value1, Long value2) {
            addCriterion("create_id not between", value1, value2, "createId");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateIdIsNull() {
            addCriterion("update_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdateIdIsNotNull() {
            addCriterion("update_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateIdEqualTo(Long value) {
            addCriterion("update_id =", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotEqualTo(Long value) {
            addCriterion("update_id <>", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdGreaterThan(Long value) {
            addCriterion("update_id >", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdGreaterThanOrEqualTo(Long value) {
            addCriterion("update_id >=", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdLessThan(Long value) {
            addCriterion("update_id <", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdLessThanOrEqualTo(Long value) {
            addCriterion("update_id <=", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdIn(List<Long> values) {
            addCriterion("update_id in", values, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotIn(List<Long> values) {
            addCriterion("update_id not in", values, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdBetween(Long value1, Long value2) {
            addCriterion("update_id between", value1, value2, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotBetween(Long value1, Long value2) {
            addCriterion("update_id not between", value1, value2, "updateId");
            return (Criteria) this;
        }

        public Criteria andChannelMchtNoLikeInsensitive(String value) {
            addCriterion("upper(channel_mcht_no) like", value.toUpperCase(), "channelMchtNo");
            return (Criteria) this;
        }

        public Criteria andChannelMchtNameLikeInsensitive(String value) {
            addCriterion("upper(channel_mcht_name) like", value.toUpperCase(), "channelMchtName");
            return (Criteria) this;
        }

        public Criteria andShortNameLikeInsensitive(String value) {
            addCriterion("upper(short_name) like", value.toUpperCase(), "shortName");
            return (Criteria) this;
        }

        public Criteria andCategoryTypeLikeInsensitive(String value) {
            addCriterion("upper(category_type) like", value.toUpperCase(), "categoryType");
            return (Criteria) this;
        }

        public Criteria andCorEmailLikeInsensitive(String value) {
            addCriterion("upper(cor_email) like", value.toUpperCase(), "corEmail");
            return (Criteria) this;
        }

        public Criteria andCorTelLikeInsensitive(String value) {
            addCriterion("upper(cor_tel) like", value.toUpperCase(), "corTel");
            return (Criteria) this;
        }

        public Criteria andScaleLikeInsensitive(String value) {
            addCriterion("upper(`scale`) like", value.toUpperCase(), "scale");
            return (Criteria) this;
        }

        public Criteria andUserTypeLikeInsensitive(String value) {
            addCriterion("upper(user_type) like", value.toUpperCase(), "userType");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNoLikeInsensitive(String value) {
            addCriterion("upper(business_license_no) like", value.toUpperCase(), "businessLicenseNo");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseExpireStartLikeInsensitive(String value) {
            addCriterion("upper(business_license_expire_start) like", value.toUpperCase(), "businessLicenseExpireStart");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseExpireEndLikeInsensitive(String value) {
            addCriterion("upper(business_license_expire_end) like", value.toUpperCase(), "businessLicenseExpireEnd");
            return (Criteria) this;
        }

        public Criteria andContactNameLikeInsensitive(String value) {
            addCriterion("upper(contact_name) like", value.toUpperCase(), "contactName");
            return (Criteria) this;
        }

        public Criteria andContactTelLikeInsensitive(String value) {
            addCriterion("upper(contact_tel) like", value.toUpperCase(), "contactTel");
            return (Criteria) this;
        }

        public Criteria andIdNotTypeLikeInsensitive(String value) {
            addCriterion("upper(id_not_type) like", value.toUpperCase(), "idNotType");
            return (Criteria) this;
        }

        public Criteria andIdNoLikeInsensitive(String value) {
            addCriterion("upper(id_no) like", value.toUpperCase(), "idNo");
            return (Criteria) this;
        }

        public Criteria andIssDateLikeInsensitive(String value) {
            addCriterion("upper(iss_date) like", value.toUpperCase(), "issDate");
            return (Criteria) this;
        }

        public Criteria andProvinceLikeInsensitive(String value) {
            addCriterion("upper(province) like", value.toUpperCase(), "province");
            return (Criteria) this;
        }

        public Criteria andCityLikeInsensitive(String value) {
            addCriterion("upper(city) like", value.toUpperCase(), "city");
            return (Criteria) this;
        }

        public Criteria andExpiryDateLikeInsensitive(String value) {
            addCriterion("upper(expiry_date) like", value.toUpperCase(), "expiryDate");
            return (Criteria) this;
        }

        public Criteria andDistrictLikeInsensitive(String value) {
            addCriterion("upper(district) like", value.toUpperCase(), "district");
            return (Criteria) this;
        }

        public Criteria andAddressLikeInsensitive(String value) {
            addCriterion("upper(address) like", value.toUpperCase(), "address");
            return (Criteria) this;
        }

        public Criteria andRemarkLikeInsensitive(String value) {
            addCriterion("upper(remark) like", value.toUpperCase(), "remark");
            return (Criteria) this;
        }

        public Criteria andContactEmailLikeInsensitive(String value) {
            addCriterion("upper(contact_email) like", value.toUpperCase(), "contactEmail");
            return (Criteria) this;
        }

        public Criteria andPeriodsLikeInsensitive(String value) {
            addCriterion("upper(periods) like", value.toUpperCase(), "periods");
            return (Criteria) this;
        }

        public Criteria andChannelNameLikeInsensitive(String value) {
            addCriterion("upper(channel_name) like", value.toUpperCase(), "channelName");
            return (Criteria) this;
        }

        public Criteria andFeeModeLikeInsensitive(String value) {
            addCriterion("upper(fee_mode) like", value.toUpperCase(), "feeMode");
            return (Criteria) this;
        }

        public Criteria andOpenQuickLikeInsensitive(String value) {
            addCriterion("upper(open_quick) like", value.toUpperCase(), "openQuick");
            return (Criteria) this;
        }

        public Criteria andAppidLikeInsensitive(String value) {
            addCriterion("upper(appid) like", value.toUpperCase(), "appid");
            return (Criteria) this;
        }

        public Criteria andSecretLikeInsensitive(String value) {
            addCriterion("upper(secret) like", value.toUpperCase(), "secret");
            return (Criteria) this;
        }

        public Criteria andStatusLikeInsensitive(String value) {
            addCriterion("upper(`status`) like", value.toUpperCase(), "status");
            return (Criteria) this;
        }

        public Criteria andFailReasonLikeInsensitive(String value) {
            addCriterion("upper(fail_reason) like", value.toUpperCase(), "failReason");
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