package com.jkf.channel.gateway.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderInfoExample() {
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

        public Criteria andSerialIsNull() {
            addCriterion("serial is null");
            return (Criteria) this;
        }

        public Criteria andSerialIsNotNull() {
            addCriterion("serial is not null");
            return (Criteria) this;
        }

        public Criteria andSerialEqualTo(String value) {
            addCriterion("serial =", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialNotEqualTo(String value) {
            addCriterion("serial <>", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialGreaterThan(String value) {
            addCriterion("serial >", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialGreaterThanOrEqualTo(String value) {
            addCriterion("serial >=", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialLessThan(String value) {
            addCriterion("serial <", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialLessThanOrEqualTo(String value) {
            addCriterion("serial <=", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialLike(String value) {
            addCriterion("serial like", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialNotLike(String value) {
            addCriterion("serial not like", value, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialIn(List<String> values) {
            addCriterion("serial in", values, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialNotIn(List<String> values) {
            addCriterion("serial not in", values, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialBetween(String value1, String value2) {
            addCriterion("serial between", value1, value2, "serial");
            return (Criteria) this;
        }

        public Criteria andSerialNotBetween(String value1, String value2) {
            addCriterion("serial not between", value1, value2, "serial");
            return (Criteria) this;
        }

        public Criteria andOutSerialIsNull() {
            addCriterion("out_serial is null");
            return (Criteria) this;
        }

        public Criteria andOutSerialIsNotNull() {
            addCriterion("out_serial is not null");
            return (Criteria) this;
        }

        public Criteria andOutSerialEqualTo(String value) {
            addCriterion("out_serial =", value, "outSerial");
            return (Criteria) this;
        }

        public Criteria andOutSerialNotEqualTo(String value) {
            addCriterion("out_serial <>", value, "outSerial");
            return (Criteria) this;
        }

        public Criteria andOutSerialGreaterThan(String value) {
            addCriterion("out_serial >", value, "outSerial");
            return (Criteria) this;
        }

        public Criteria andOutSerialGreaterThanOrEqualTo(String value) {
            addCriterion("out_serial >=", value, "outSerial");
            return (Criteria) this;
        }

        public Criteria andOutSerialLessThan(String value) {
            addCriterion("out_serial <", value, "outSerial");
            return (Criteria) this;
        }

        public Criteria andOutSerialLessThanOrEqualTo(String value) {
            addCriterion("out_serial <=", value, "outSerial");
            return (Criteria) this;
        }

        public Criteria andOutSerialLike(String value) {
            addCriterion("out_serial like", value, "outSerial");
            return (Criteria) this;
        }

        public Criteria andOutSerialNotLike(String value) {
            addCriterion("out_serial not like", value, "outSerial");
            return (Criteria) this;
        }

        public Criteria andOutSerialIn(List<String> values) {
            addCriterion("out_serial in", values, "outSerial");
            return (Criteria) this;
        }

        public Criteria andOutSerialNotIn(List<String> values) {
            addCriterion("out_serial not in", values, "outSerial");
            return (Criteria) this;
        }

        public Criteria andOutSerialBetween(String value1, String value2) {
            addCriterion("out_serial between", value1, value2, "outSerial");
            return (Criteria) this;
        }

        public Criteria andOutSerialNotBetween(String value1, String value2) {
            addCriterion("out_serial not between", value1, value2, "outSerial");
            return (Criteria) this;
        }

        public Criteria andOutMchIdIsNull() {
            addCriterion("out_mch_id is null");
            return (Criteria) this;
        }

        public Criteria andOutMchIdIsNotNull() {
            addCriterion("out_mch_id is not null");
            return (Criteria) this;
        }

        public Criteria andOutMchIdEqualTo(String value) {
            addCriterion("out_mch_id =", value, "outMchId");
            return (Criteria) this;
        }

        public Criteria andOutMchIdNotEqualTo(String value) {
            addCriterion("out_mch_id <>", value, "outMchId");
            return (Criteria) this;
        }

        public Criteria andOutMchIdGreaterThan(String value) {
            addCriterion("out_mch_id >", value, "outMchId");
            return (Criteria) this;
        }

        public Criteria andOutMchIdGreaterThanOrEqualTo(String value) {
            addCriterion("out_mch_id >=", value, "outMchId");
            return (Criteria) this;
        }

        public Criteria andOutMchIdLessThan(String value) {
            addCriterion("out_mch_id <", value, "outMchId");
            return (Criteria) this;
        }

        public Criteria andOutMchIdLessThanOrEqualTo(String value) {
            addCriterion("out_mch_id <=", value, "outMchId");
            return (Criteria) this;
        }

        public Criteria andOutMchIdLike(String value) {
            addCriterion("out_mch_id like", value, "outMchId");
            return (Criteria) this;
        }

        public Criteria andOutMchIdNotLike(String value) {
            addCriterion("out_mch_id not like", value, "outMchId");
            return (Criteria) this;
        }

        public Criteria andOutMchIdIn(List<String> values) {
            addCriterion("out_mch_id in", values, "outMchId");
            return (Criteria) this;
        }

        public Criteria andOutMchIdNotIn(List<String> values) {
            addCriterion("out_mch_id not in", values, "outMchId");
            return (Criteria) this;
        }

        public Criteria andOutMchIdBetween(String value1, String value2) {
            addCriterion("out_mch_id between", value1, value2, "outMchId");
            return (Criteria) this;
        }

        public Criteria andOutMchIdNotBetween(String value1, String value2) {
            addCriterion("out_mch_id not between", value1, value2, "outMchId");
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

        public Criteria andOrgIdIsNull() {
            addCriterion("org_id is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("org_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(Long value) {
            addCriterion("org_id =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(Long value) {
            addCriterion("org_id <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(Long value) {
            addCriterion("org_id >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(Long value) {
            addCriterion("org_id >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(Long value) {
            addCriterion("org_id <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(Long value) {
            addCriterion("org_id <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(List<Long> values) {
            addCriterion("org_id in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(List<Long> values) {
            addCriterion("org_id not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(Long value1, Long value2) {
            addCriterion("org_id between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(Long value1, Long value2) {
            addCriterion("org_id not between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andTradeOrgIdIsNull() {
            addCriterion("trade_org_id is null");
            return (Criteria) this;
        }

        public Criteria andTradeOrgIdIsNotNull() {
            addCriterion("trade_org_id is not null");
            return (Criteria) this;
        }

        public Criteria andTradeOrgIdEqualTo(Long value) {
            addCriterion("trade_org_id =", value, "tradeOrgId");
            return (Criteria) this;
        }

        public Criteria andTradeOrgIdNotEqualTo(Long value) {
            addCriterion("trade_org_id <>", value, "tradeOrgId");
            return (Criteria) this;
        }

        public Criteria andTradeOrgIdGreaterThan(Long value) {
            addCriterion("trade_org_id >", value, "tradeOrgId");
            return (Criteria) this;
        }

        public Criteria andTradeOrgIdGreaterThanOrEqualTo(Long value) {
            addCriterion("trade_org_id >=", value, "tradeOrgId");
            return (Criteria) this;
        }

        public Criteria andTradeOrgIdLessThan(Long value) {
            addCriterion("trade_org_id <", value, "tradeOrgId");
            return (Criteria) this;
        }

        public Criteria andTradeOrgIdLessThanOrEqualTo(Long value) {
            addCriterion("trade_org_id <=", value, "tradeOrgId");
            return (Criteria) this;
        }

        public Criteria andTradeOrgIdIn(List<Long> values) {
            addCriterion("trade_org_id in", values, "tradeOrgId");
            return (Criteria) this;
        }

        public Criteria andTradeOrgIdNotIn(List<Long> values) {
            addCriterion("trade_org_id not in", values, "tradeOrgId");
            return (Criteria) this;
        }

        public Criteria andTradeOrgIdBetween(Long value1, Long value2) {
            addCriterion("trade_org_id between", value1, value2, "tradeOrgId");
            return (Criteria) this;
        }

        public Criteria andTradeOrgIdNotBetween(Long value1, Long value2) {
            addCriterion("trade_org_id not between", value1, value2, "tradeOrgId");
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

        public Criteria andShopIdIsNull() {
            addCriterion("shop_id is null");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNotNull() {
            addCriterion("shop_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopIdEqualTo(Long value) {
            addCriterion("shop_id =", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotEqualTo(Long value) {
            addCriterion("shop_id <>", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThan(Long value) {
            addCriterion("shop_id >", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            addCriterion("shop_id >=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThan(Long value) {
            addCriterion("shop_id <", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThanOrEqualTo(Long value) {
            addCriterion("shop_id <=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdIn(List<Long> values) {
            addCriterion("shop_id in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotIn(List<Long> values) {
            addCriterion("shop_id not in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdBetween(Long value1, Long value2) {
            addCriterion("shop_id between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotBetween(Long value1, Long value2) {
            addCriterion("shop_id not between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andMchNameIsNull() {
            addCriterion("mch_name is null");
            return (Criteria) this;
        }

        public Criteria andMchNameIsNotNull() {
            addCriterion("mch_name is not null");
            return (Criteria) this;
        }

        public Criteria andMchNameEqualTo(String value) {
            addCriterion("mch_name =", value, "mchName");
            return (Criteria) this;
        }

        public Criteria andMchNameNotEqualTo(String value) {
            addCriterion("mch_name <>", value, "mchName");
            return (Criteria) this;
        }

        public Criteria andMchNameGreaterThan(String value) {
            addCriterion("mch_name >", value, "mchName");
            return (Criteria) this;
        }

        public Criteria andMchNameGreaterThanOrEqualTo(String value) {
            addCriterion("mch_name >=", value, "mchName");
            return (Criteria) this;
        }

        public Criteria andMchNameLessThan(String value) {
            addCriterion("mch_name <", value, "mchName");
            return (Criteria) this;
        }

        public Criteria andMchNameLessThanOrEqualTo(String value) {
            addCriterion("mch_name <=", value, "mchName");
            return (Criteria) this;
        }

        public Criteria andMchNameLike(String value) {
            addCriterion("mch_name like", value, "mchName");
            return (Criteria) this;
        }

        public Criteria andMchNameNotLike(String value) {
            addCriterion("mch_name not like", value, "mchName");
            return (Criteria) this;
        }

        public Criteria andMchNameIn(List<String> values) {
            addCriterion("mch_name in", values, "mchName");
            return (Criteria) this;
        }

        public Criteria andMchNameNotIn(List<String> values) {
            addCriterion("mch_name not in", values, "mchName");
            return (Criteria) this;
        }

        public Criteria andMchNameBetween(String value1, String value2) {
            addCriterion("mch_name between", value1, value2, "mchName");
            return (Criteria) this;
        }

        public Criteria andMchNameNotBetween(String value1, String value2) {
            addCriterion("mch_name not between", value1, value2, "mchName");
            return (Criteria) this;
        }

        public Criteria andSnIsNull() {
            addCriterion("sn is null");
            return (Criteria) this;
        }

        public Criteria andSnIsNotNull() {
            addCriterion("sn is not null");
            return (Criteria) this;
        }

        public Criteria andSnEqualTo(String value) {
            addCriterion("sn =", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotEqualTo(String value) {
            addCriterion("sn <>", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThan(String value) {
            addCriterion("sn >", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnGreaterThanOrEqualTo(String value) {
            addCriterion("sn >=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThan(String value) {
            addCriterion("sn <", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLessThanOrEqualTo(String value) {
            addCriterion("sn <=", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnLike(String value) {
            addCriterion("sn like", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotLike(String value) {
            addCriterion("sn not like", value, "sn");
            return (Criteria) this;
        }

        public Criteria andSnIn(List<String> values) {
            addCriterion("sn in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotIn(List<String> values) {
            addCriterion("sn not in", values, "sn");
            return (Criteria) this;
        }

        public Criteria andSnBetween(String value1, String value2) {
            addCriterion("sn between", value1, value2, "sn");
            return (Criteria) this;
        }

        public Criteria andSnNotBetween(String value1, String value2) {
            addCriterion("sn not between", value1, value2, "sn");
            return (Criteria) this;
        }

        public Criteria andTermSnIsNull() {
            addCriterion("term_sn is null");
            return (Criteria) this;
        }

        public Criteria andTermSnIsNotNull() {
            addCriterion("term_sn is not null");
            return (Criteria) this;
        }

        public Criteria andTermSnEqualTo(String value) {
            addCriterion("term_sn =", value, "termSn");
            return (Criteria) this;
        }

        public Criteria andTermSnNotEqualTo(String value) {
            addCriterion("term_sn <>", value, "termSn");
            return (Criteria) this;
        }

        public Criteria andTermSnGreaterThan(String value) {
            addCriterion("term_sn >", value, "termSn");
            return (Criteria) this;
        }

        public Criteria andTermSnGreaterThanOrEqualTo(String value) {
            addCriterion("term_sn >=", value, "termSn");
            return (Criteria) this;
        }

        public Criteria andTermSnLessThan(String value) {
            addCriterion("term_sn <", value, "termSn");
            return (Criteria) this;
        }

        public Criteria andTermSnLessThanOrEqualTo(String value) {
            addCriterion("term_sn <=", value, "termSn");
            return (Criteria) this;
        }

        public Criteria andTermSnLike(String value) {
            addCriterion("term_sn like", value, "termSn");
            return (Criteria) this;
        }

        public Criteria andTermSnNotLike(String value) {
            addCriterion("term_sn not like", value, "termSn");
            return (Criteria) this;
        }

        public Criteria andTermSnIn(List<String> values) {
            addCriterion("term_sn in", values, "termSn");
            return (Criteria) this;
        }

        public Criteria andTermSnNotIn(List<String> values) {
            addCriterion("term_sn not in", values, "termSn");
            return (Criteria) this;
        }

        public Criteria andTermSnBetween(String value1, String value2) {
            addCriterion("term_sn between", value1, value2, "termSn");
            return (Criteria) this;
        }

        public Criteria andTermSnNotBetween(String value1, String value2) {
            addCriterion("term_sn not between", value1, value2, "termSn");
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

        public Criteria andChannelMchNoIsNull() {
            addCriterion("channel_mch_no is null");
            return (Criteria) this;
        }

        public Criteria andChannelMchNoIsNotNull() {
            addCriterion("channel_mch_no is not null");
            return (Criteria) this;
        }

        public Criteria andChannelMchNoEqualTo(String value) {
            addCriterion("channel_mch_no =", value, "channelMchNo");
            return (Criteria) this;
        }

        public Criteria andChannelMchNoNotEqualTo(String value) {
            addCriterion("channel_mch_no <>", value, "channelMchNo");
            return (Criteria) this;
        }

        public Criteria andChannelMchNoGreaterThan(String value) {
            addCriterion("channel_mch_no >", value, "channelMchNo");
            return (Criteria) this;
        }

        public Criteria andChannelMchNoGreaterThanOrEqualTo(String value) {
            addCriterion("channel_mch_no >=", value, "channelMchNo");
            return (Criteria) this;
        }

        public Criteria andChannelMchNoLessThan(String value) {
            addCriterion("channel_mch_no <", value, "channelMchNo");
            return (Criteria) this;
        }

        public Criteria andChannelMchNoLessThanOrEqualTo(String value) {
            addCriterion("channel_mch_no <=", value, "channelMchNo");
            return (Criteria) this;
        }

        public Criteria andChannelMchNoLike(String value) {
            addCriterion("channel_mch_no like", value, "channelMchNo");
            return (Criteria) this;
        }

        public Criteria andChannelMchNoNotLike(String value) {
            addCriterion("channel_mch_no not like", value, "channelMchNo");
            return (Criteria) this;
        }

        public Criteria andChannelMchNoIn(List<String> values) {
            addCriterion("channel_mch_no in", values, "channelMchNo");
            return (Criteria) this;
        }

        public Criteria andChannelMchNoNotIn(List<String> values) {
            addCriterion("channel_mch_no not in", values, "channelMchNo");
            return (Criteria) this;
        }

        public Criteria andChannelMchNoBetween(String value1, String value2) {
            addCriterion("channel_mch_no between", value1, value2, "channelMchNo");
            return (Criteria) this;
        }

        public Criteria andChannelMchNoNotBetween(String value1, String value2) {
            addCriterion("channel_mch_no not between", value1, value2, "channelMchNo");
            return (Criteria) this;
        }

        public Criteria andChannelTermNoIsNull() {
            addCriterion("channel_term_no is null");
            return (Criteria) this;
        }

        public Criteria andChannelTermNoIsNotNull() {
            addCriterion("channel_term_no is not null");
            return (Criteria) this;
        }

        public Criteria andChannelTermNoEqualTo(String value) {
            addCriterion("channel_term_no =", value, "channelTermNo");
            return (Criteria) this;
        }

        public Criteria andChannelTermNoNotEqualTo(String value) {
            addCriterion("channel_term_no <>", value, "channelTermNo");
            return (Criteria) this;
        }

        public Criteria andChannelTermNoGreaterThan(String value) {
            addCriterion("channel_term_no >", value, "channelTermNo");
            return (Criteria) this;
        }

        public Criteria andChannelTermNoGreaterThanOrEqualTo(String value) {
            addCriterion("channel_term_no >=", value, "channelTermNo");
            return (Criteria) this;
        }

        public Criteria andChannelTermNoLessThan(String value) {
            addCriterion("channel_term_no <", value, "channelTermNo");
            return (Criteria) this;
        }

        public Criteria andChannelTermNoLessThanOrEqualTo(String value) {
            addCriterion("channel_term_no <=", value, "channelTermNo");
            return (Criteria) this;
        }

        public Criteria andChannelTermNoLike(String value) {
            addCriterion("channel_term_no like", value, "channelTermNo");
            return (Criteria) this;
        }

        public Criteria andChannelTermNoNotLike(String value) {
            addCriterion("channel_term_no not like", value, "channelTermNo");
            return (Criteria) this;
        }

        public Criteria andChannelTermNoIn(List<String> values) {
            addCriterion("channel_term_no in", values, "channelTermNo");
            return (Criteria) this;
        }

        public Criteria andChannelTermNoNotIn(List<String> values) {
            addCriterion("channel_term_no not in", values, "channelTermNo");
            return (Criteria) this;
        }

        public Criteria andChannelTermNoBetween(String value1, String value2) {
            addCriterion("channel_term_no between", value1, value2, "channelTermNo");
            return (Criteria) this;
        }

        public Criteria andChannelTermNoNotBetween(String value1, String value2) {
            addCriterion("channel_term_no not between", value1, value2, "channelTermNo");
            return (Criteria) this;
        }

        public Criteria andChannelOrderNoIsNull() {
            addCriterion("channel_order_no is null");
            return (Criteria) this;
        }

        public Criteria andChannelOrderNoIsNotNull() {
            addCriterion("channel_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andChannelOrderNoEqualTo(String value) {
            addCriterion("channel_order_no =", value, "channelOrderNo");
            return (Criteria) this;
        }

        public Criteria andChannelOrderNoNotEqualTo(String value) {
            addCriterion("channel_order_no <>", value, "channelOrderNo");
            return (Criteria) this;
        }

        public Criteria andChannelOrderNoGreaterThan(String value) {
            addCriterion("channel_order_no >", value, "channelOrderNo");
            return (Criteria) this;
        }

        public Criteria andChannelOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("channel_order_no >=", value, "channelOrderNo");
            return (Criteria) this;
        }

        public Criteria andChannelOrderNoLessThan(String value) {
            addCriterion("channel_order_no <", value, "channelOrderNo");
            return (Criteria) this;
        }

        public Criteria andChannelOrderNoLessThanOrEqualTo(String value) {
            addCriterion("channel_order_no <=", value, "channelOrderNo");
            return (Criteria) this;
        }

        public Criteria andChannelOrderNoLike(String value) {
            addCriterion("channel_order_no like", value, "channelOrderNo");
            return (Criteria) this;
        }

        public Criteria andChannelOrderNoNotLike(String value) {
            addCriterion("channel_order_no not like", value, "channelOrderNo");
            return (Criteria) this;
        }

        public Criteria andChannelOrderNoIn(List<String> values) {
            addCriterion("channel_order_no in", values, "channelOrderNo");
            return (Criteria) this;
        }

        public Criteria andChannelOrderNoNotIn(List<String> values) {
            addCriterion("channel_order_no not in", values, "channelOrderNo");
            return (Criteria) this;
        }

        public Criteria andChannelOrderNoBetween(String value1, String value2) {
            addCriterion("channel_order_no between", value1, value2, "channelOrderNo");
            return (Criteria) this;
        }

        public Criteria andChannelOrderNoNotBetween(String value1, String value2) {
            addCriterion("channel_order_no not between", value1, value2, "channelOrderNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoIsNull() {
            addCriterion("trade_no is null");
            return (Criteria) this;
        }

        public Criteria andTradeNoIsNotNull() {
            addCriterion("trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andTradeNoEqualTo(String value) {
            addCriterion("trade_no =", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotEqualTo(String value) {
            addCriterion("trade_no <>", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoGreaterThan(String value) {
            addCriterion("trade_no >", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("trade_no >=", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLessThan(String value) {
            addCriterion("trade_no <", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLessThanOrEqualTo(String value) {
            addCriterion("trade_no <=", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLike(String value) {
            addCriterion("trade_no like", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotLike(String value) {
            addCriterion("trade_no not like", value, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoIn(List<String> values) {
            addCriterion("trade_no in", values, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotIn(List<String> values) {
            addCriterion("trade_no not in", values, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoBetween(String value1, String value2) {
            addCriterion("trade_no between", value1, value2, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoNotBetween(String value1, String value2) {
            addCriterion("trade_no not between", value1, value2, "tradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoIsNull() {
            addCriterion("out_trade_no is null");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoIsNotNull() {
            addCriterion("out_trade_no is not null");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoEqualTo(String value) {
            addCriterion("out_trade_no =", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotEqualTo(String value) {
            addCriterion("out_trade_no <>", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoGreaterThan(String value) {
            addCriterion("out_trade_no >", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoGreaterThanOrEqualTo(String value) {
            addCriterion("out_trade_no >=", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoLessThan(String value) {
            addCriterion("out_trade_no <", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoLessThanOrEqualTo(String value) {
            addCriterion("out_trade_no <=", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoLike(String value) {
            addCriterion("out_trade_no like", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotLike(String value) {
            addCriterion("out_trade_no not like", value, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoIn(List<String> values) {
            addCriterion("out_trade_no in", values, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotIn(List<String> values) {
            addCriterion("out_trade_no not in", values, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoBetween(String value1, String value2) {
            addCriterion("out_trade_no between", value1, value2, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoNotBetween(String value1, String value2) {
            addCriterion("out_trade_no not between", value1, value2, "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOrigSerialIsNull() {
            addCriterion("orig_serial is null");
            return (Criteria) this;
        }

        public Criteria andOrigSerialIsNotNull() {
            addCriterion("orig_serial is not null");
            return (Criteria) this;
        }

        public Criteria andOrigSerialEqualTo(String value) {
            addCriterion("orig_serial =", value, "origSerial");
            return (Criteria) this;
        }

        public Criteria andOrigSerialNotEqualTo(String value) {
            addCriterion("orig_serial <>", value, "origSerial");
            return (Criteria) this;
        }

        public Criteria andOrigSerialGreaterThan(String value) {
            addCriterion("orig_serial >", value, "origSerial");
            return (Criteria) this;
        }

        public Criteria andOrigSerialGreaterThanOrEqualTo(String value) {
            addCriterion("orig_serial >=", value, "origSerial");
            return (Criteria) this;
        }

        public Criteria andOrigSerialLessThan(String value) {
            addCriterion("orig_serial <", value, "origSerial");
            return (Criteria) this;
        }

        public Criteria andOrigSerialLessThanOrEqualTo(String value) {
            addCriterion("orig_serial <=", value, "origSerial");
            return (Criteria) this;
        }

        public Criteria andOrigSerialLike(String value) {
            addCriterion("orig_serial like", value, "origSerial");
            return (Criteria) this;
        }

        public Criteria andOrigSerialNotLike(String value) {
            addCriterion("orig_serial not like", value, "origSerial");
            return (Criteria) this;
        }

        public Criteria andOrigSerialIn(List<String> values) {
            addCriterion("orig_serial in", values, "origSerial");
            return (Criteria) this;
        }

        public Criteria andOrigSerialNotIn(List<String> values) {
            addCriterion("orig_serial not in", values, "origSerial");
            return (Criteria) this;
        }

        public Criteria andOrigSerialBetween(String value1, String value2) {
            addCriterion("orig_serial between", value1, value2, "origSerial");
            return (Criteria) this;
        }

        public Criteria andOrigSerialNotBetween(String value1, String value2) {
            addCriterion("orig_serial not between", value1, value2, "origSerial");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNull() {
            addCriterion("order_type is null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIsNotNull() {
            addCriterion("order_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrderTypeEqualTo(String value) {
            addCriterion("order_type =", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotEqualTo(String value) {
            addCriterion("order_type <>", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThan(String value) {
            addCriterion("order_type >", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeGreaterThanOrEqualTo(String value) {
            addCriterion("order_type >=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThan(String value) {
            addCriterion("order_type <", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLessThanOrEqualTo(String value) {
            addCriterion("order_type <=", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLike(String value) {
            addCriterion("order_type like", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotLike(String value) {
            addCriterion("order_type not like", value, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeIn(List<String> values) {
            addCriterion("order_type in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotIn(List<String> values) {
            addCriterion("order_type not in", values, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeBetween(String value1, String value2) {
            addCriterion("order_type between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andOrderTypeNotBetween(String value1, String value2) {
            addCriterion("order_type not between", value1, value2, "orderType");
            return (Criteria) this;
        }

        public Criteria andProductIsNull() {
            addCriterion("product is null");
            return (Criteria) this;
        }

        public Criteria andProductIsNotNull() {
            addCriterion("product is not null");
            return (Criteria) this;
        }

        public Criteria andProductEqualTo(String value) {
            addCriterion("product =", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotEqualTo(String value) {
            addCriterion("product <>", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductGreaterThan(String value) {
            addCriterion("product >", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductGreaterThanOrEqualTo(String value) {
            addCriterion("product >=", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductLessThan(String value) {
            addCriterion("product <", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductLessThanOrEqualTo(String value) {
            addCriterion("product <=", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductLike(String value) {
            addCriterion("product like", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotLike(String value) {
            addCriterion("product not like", value, "product");
            return (Criteria) this;
        }

        public Criteria andProductIn(List<String> values) {
            addCriterion("product in", values, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotIn(List<String> values) {
            addCriterion("product not in", values, "product");
            return (Criteria) this;
        }

        public Criteria andProductBetween(String value1, String value2) {
            addCriterion("product between", value1, value2, "product");
            return (Criteria) this;
        }

        public Criteria andProductNotBetween(String value1, String value2) {
            addCriterion("product not between", value1, value2, "product");
            return (Criteria) this;
        }

        public Criteria andSubProductIsNull() {
            addCriterion("sub_product is null");
            return (Criteria) this;
        }

        public Criteria andSubProductIsNotNull() {
            addCriterion("sub_product is not null");
            return (Criteria) this;
        }

        public Criteria andSubProductEqualTo(String value) {
            addCriterion("sub_product =", value, "subProduct");
            return (Criteria) this;
        }

        public Criteria andSubProductNotEqualTo(String value) {
            addCriterion("sub_product <>", value, "subProduct");
            return (Criteria) this;
        }

        public Criteria andSubProductGreaterThan(String value) {
            addCriterion("sub_product >", value, "subProduct");
            return (Criteria) this;
        }

        public Criteria andSubProductGreaterThanOrEqualTo(String value) {
            addCriterion("sub_product >=", value, "subProduct");
            return (Criteria) this;
        }

        public Criteria andSubProductLessThan(String value) {
            addCriterion("sub_product <", value, "subProduct");
            return (Criteria) this;
        }

        public Criteria andSubProductLessThanOrEqualTo(String value) {
            addCriterion("sub_product <=", value, "subProduct");
            return (Criteria) this;
        }

        public Criteria andSubProductLike(String value) {
            addCriterion("sub_product like", value, "subProduct");
            return (Criteria) this;
        }

        public Criteria andSubProductNotLike(String value) {
            addCriterion("sub_product not like", value, "subProduct");
            return (Criteria) this;
        }

        public Criteria andSubProductIn(List<String> values) {
            addCriterion("sub_product in", values, "subProduct");
            return (Criteria) this;
        }

        public Criteria andSubProductNotIn(List<String> values) {
            addCriterion("sub_product not in", values, "subProduct");
            return (Criteria) this;
        }

        public Criteria andSubProductBetween(String value1, String value2) {
            addCriterion("sub_product between", value1, value2, "subProduct");
            return (Criteria) this;
        }

        public Criteria andSubProductNotBetween(String value1, String value2) {
            addCriterion("sub_product not between", value1, value2, "subProduct");
            return (Criteria) this;
        }

        public Criteria andOrderDateIsNull() {
            addCriterion("order_date is null");
            return (Criteria) this;
        }

        public Criteria andOrderDateIsNotNull() {
            addCriterion("order_date is not null");
            return (Criteria) this;
        }

        public Criteria andOrderDateEqualTo(String value) {
            addCriterion("order_date =", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateNotEqualTo(String value) {
            addCriterion("order_date <>", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateGreaterThan(String value) {
            addCriterion("order_date >", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateGreaterThanOrEqualTo(String value) {
            addCriterion("order_date >=", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateLessThan(String value) {
            addCriterion("order_date <", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateLessThanOrEqualTo(String value) {
            addCriterion("order_date <=", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateLike(String value) {
            addCriterion("order_date like", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateNotLike(String value) {
            addCriterion("order_date not like", value, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateIn(List<String> values) {
            addCriterion("order_date in", values, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateNotIn(List<String> values) {
            addCriterion("order_date not in", values, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateBetween(String value1, String value2) {
            addCriterion("order_date between", value1, value2, "orderDate");
            return (Criteria) this;
        }

        public Criteria andOrderDateNotBetween(String value1, String value2) {
            addCriterion("order_date not between", value1, value2, "orderDate");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIsNull() {
            addCriterion("notify_url is null");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIsNotNull() {
            addCriterion("notify_url is not null");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlEqualTo(String value) {
            addCriterion("notify_url =", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotEqualTo(String value) {
            addCriterion("notify_url <>", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlGreaterThan(String value) {
            addCriterion("notify_url >", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlGreaterThanOrEqualTo(String value) {
            addCriterion("notify_url >=", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLessThan(String value) {
            addCriterion("notify_url <", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLessThanOrEqualTo(String value) {
            addCriterion("notify_url <=", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLike(String value) {
            addCriterion("notify_url like", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotLike(String value) {
            addCriterion("notify_url not like", value, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlIn(List<String> values) {
            addCriterion("notify_url in", values, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotIn(List<String> values) {
            addCriterion("notify_url not in", values, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlBetween(String value1, String value2) {
            addCriterion("notify_url between", value1, value2, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlNotBetween(String value1, String value2) {
            addCriterion("notify_url not between", value1, value2, "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andFrontUrlIsNull() {
            addCriterion("front_url is null");
            return (Criteria) this;
        }

        public Criteria andFrontUrlIsNotNull() {
            addCriterion("front_url is not null");
            return (Criteria) this;
        }

        public Criteria andFrontUrlEqualTo(String value) {
            addCriterion("front_url =", value, "frontUrl");
            return (Criteria) this;
        }

        public Criteria andFrontUrlNotEqualTo(String value) {
            addCriterion("front_url <>", value, "frontUrl");
            return (Criteria) this;
        }

        public Criteria andFrontUrlGreaterThan(String value) {
            addCriterion("front_url >", value, "frontUrl");
            return (Criteria) this;
        }

        public Criteria andFrontUrlGreaterThanOrEqualTo(String value) {
            addCriterion("front_url >=", value, "frontUrl");
            return (Criteria) this;
        }

        public Criteria andFrontUrlLessThan(String value) {
            addCriterion("front_url <", value, "frontUrl");
            return (Criteria) this;
        }

        public Criteria andFrontUrlLessThanOrEqualTo(String value) {
            addCriterion("front_url <=", value, "frontUrl");
            return (Criteria) this;
        }

        public Criteria andFrontUrlLike(String value) {
            addCriterion("front_url like", value, "frontUrl");
            return (Criteria) this;
        }

        public Criteria andFrontUrlNotLike(String value) {
            addCriterion("front_url not like", value, "frontUrl");
            return (Criteria) this;
        }

        public Criteria andFrontUrlIn(List<String> values) {
            addCriterion("front_url in", values, "frontUrl");
            return (Criteria) this;
        }

        public Criteria andFrontUrlNotIn(List<String> values) {
            addCriterion("front_url not in", values, "frontUrl");
            return (Criteria) this;
        }

        public Criteria andFrontUrlBetween(String value1, String value2) {
            addCriterion("front_url between", value1, value2, "frontUrl");
            return (Criteria) this;
        }

        public Criteria andFrontUrlNotBetween(String value1, String value2) {
            addCriterion("front_url not between", value1, value2, "frontUrl");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIsNull() {
            addCriterion("order_amount is null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIsNotNull() {
            addCriterion("order_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountEqualTo(Long value) {
            addCriterion("order_amount =", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotEqualTo(Long value) {
            addCriterion("order_amount <>", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountGreaterThan(Long value) {
            addCriterion("order_amount >", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("order_amount >=", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountLessThan(Long value) {
            addCriterion("order_amount <", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountLessThanOrEqualTo(Long value) {
            addCriterion("order_amount <=", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIn(List<Long> values) {
            addCriterion("order_amount in", values, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotIn(List<Long> values) {
            addCriterion("order_amount not in", values, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountBetween(Long value1, Long value2) {
            addCriterion("order_amount between", value1, value2, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotBetween(Long value1, Long value2) {
            addCriterion("order_amount not between", value1, value2, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountIsNull() {
            addCriterion("coupon_amount is null");
            return (Criteria) this;
        }

        public Criteria andCouponAmountIsNotNull() {
            addCriterion("coupon_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCouponAmountEqualTo(Long value) {
            addCriterion("coupon_amount =", value, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountNotEqualTo(Long value) {
            addCriterion("coupon_amount <>", value, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountGreaterThan(Long value) {
            addCriterion("coupon_amount >", value, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("coupon_amount >=", value, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountLessThan(Long value) {
            addCriterion("coupon_amount <", value, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountLessThanOrEqualTo(Long value) {
            addCriterion("coupon_amount <=", value, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountIn(List<Long> values) {
            addCriterion("coupon_amount in", values, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountNotIn(List<Long> values) {
            addCriterion("coupon_amount not in", values, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountBetween(Long value1, Long value2) {
            addCriterion("coupon_amount between", value1, value2, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andCouponAmountNotBetween(Long value1, Long value2) {
            addCriterion("coupon_amount not between", value1, value2, "couponAmount");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNull() {
            addCriterion("subject is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNotNull() {
            addCriterion("subject is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectEqualTo(String value) {
            addCriterion("subject =", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotEqualTo(String value) {
            addCriterion("subject <>", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThan(String value) {
            addCriterion("subject >", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("subject >=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThan(String value) {
            addCriterion("subject <", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThanOrEqualTo(String value) {
            addCriterion("subject <=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLike(String value) {
            addCriterion("subject like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotLike(String value) {
            addCriterion("subject not like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectIn(List<String> values) {
            addCriterion("subject in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotIn(List<String> values) {
            addCriterion("subject not in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectBetween(String value1, String value2) {
            addCriterion("subject between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotBetween(String value1, String value2) {
            addCriterion("subject not between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andSubAppidIsNull() {
            addCriterion("sub_appid is null");
            return (Criteria) this;
        }

        public Criteria andSubAppidIsNotNull() {
            addCriterion("sub_appid is not null");
            return (Criteria) this;
        }

        public Criteria andSubAppidEqualTo(String value) {
            addCriterion("sub_appid =", value, "subAppid");
            return (Criteria) this;
        }

        public Criteria andSubAppidNotEqualTo(String value) {
            addCriterion("sub_appid <>", value, "subAppid");
            return (Criteria) this;
        }

        public Criteria andSubAppidGreaterThan(String value) {
            addCriterion("sub_appid >", value, "subAppid");
            return (Criteria) this;
        }

        public Criteria andSubAppidGreaterThanOrEqualTo(String value) {
            addCriterion("sub_appid >=", value, "subAppid");
            return (Criteria) this;
        }

        public Criteria andSubAppidLessThan(String value) {
            addCriterion("sub_appid <", value, "subAppid");
            return (Criteria) this;
        }

        public Criteria andSubAppidLessThanOrEqualTo(String value) {
            addCriterion("sub_appid <=", value, "subAppid");
            return (Criteria) this;
        }

        public Criteria andSubAppidLike(String value) {
            addCriterion("sub_appid like", value, "subAppid");
            return (Criteria) this;
        }

        public Criteria andSubAppidNotLike(String value) {
            addCriterion("sub_appid not like", value, "subAppid");
            return (Criteria) this;
        }

        public Criteria andSubAppidIn(List<String> values) {
            addCriterion("sub_appid in", values, "subAppid");
            return (Criteria) this;
        }

        public Criteria andSubAppidNotIn(List<String> values) {
            addCriterion("sub_appid not in", values, "subAppid");
            return (Criteria) this;
        }

        public Criteria andSubAppidBetween(String value1, String value2) {
            addCriterion("sub_appid between", value1, value2, "subAppid");
            return (Criteria) this;
        }

        public Criteria andSubAppidNotBetween(String value1, String value2) {
            addCriterion("sub_appid not between", value1, value2, "subAppid");
            return (Criteria) this;
        }

        public Criteria andSubOpenidIsNull() {
            addCriterion("sub_openid is null");
            return (Criteria) this;
        }

        public Criteria andSubOpenidIsNotNull() {
            addCriterion("sub_openid is not null");
            return (Criteria) this;
        }

        public Criteria andSubOpenidEqualTo(String value) {
            addCriterion("sub_openid =", value, "subOpenid");
            return (Criteria) this;
        }

        public Criteria andSubOpenidNotEqualTo(String value) {
            addCriterion("sub_openid <>", value, "subOpenid");
            return (Criteria) this;
        }

        public Criteria andSubOpenidGreaterThan(String value) {
            addCriterion("sub_openid >", value, "subOpenid");
            return (Criteria) this;
        }

        public Criteria andSubOpenidGreaterThanOrEqualTo(String value) {
            addCriterion("sub_openid >=", value, "subOpenid");
            return (Criteria) this;
        }

        public Criteria andSubOpenidLessThan(String value) {
            addCriterion("sub_openid <", value, "subOpenid");
            return (Criteria) this;
        }

        public Criteria andSubOpenidLessThanOrEqualTo(String value) {
            addCriterion("sub_openid <=", value, "subOpenid");
            return (Criteria) this;
        }

        public Criteria andSubOpenidLike(String value) {
            addCriterion("sub_openid like", value, "subOpenid");
            return (Criteria) this;
        }

        public Criteria andSubOpenidNotLike(String value) {
            addCriterion("sub_openid not like", value, "subOpenid");
            return (Criteria) this;
        }

        public Criteria andSubOpenidIn(List<String> values) {
            addCriterion("sub_openid in", values, "subOpenid");
            return (Criteria) this;
        }

        public Criteria andSubOpenidNotIn(List<String> values) {
            addCriterion("sub_openid not in", values, "subOpenid");
            return (Criteria) this;
        }

        public Criteria andSubOpenidBetween(String value1, String value2) {
            addCriterion("sub_openid between", value1, value2, "subOpenid");
            return (Criteria) this;
        }

        public Criteria andSubOpenidNotBetween(String value1, String value2) {
            addCriterion("sub_openid not between", value1, value2, "subOpenid");
            return (Criteria) this;
        }

        public Criteria andAuthCodeIsNull() {
            addCriterion("auth_code is null");
            return (Criteria) this;
        }

        public Criteria andAuthCodeIsNotNull() {
            addCriterion("auth_code is not null");
            return (Criteria) this;
        }

        public Criteria andAuthCodeEqualTo(String value) {
            addCriterion("auth_code =", value, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeNotEqualTo(String value) {
            addCriterion("auth_code <>", value, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeGreaterThan(String value) {
            addCriterion("auth_code >", value, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeGreaterThanOrEqualTo(String value) {
            addCriterion("auth_code >=", value, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeLessThan(String value) {
            addCriterion("auth_code <", value, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeLessThanOrEqualTo(String value) {
            addCriterion("auth_code <=", value, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeLike(String value) {
            addCriterion("auth_code like", value, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeNotLike(String value) {
            addCriterion("auth_code not like", value, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeIn(List<String> values) {
            addCriterion("auth_code in", values, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeNotIn(List<String> values) {
            addCriterion("auth_code not in", values, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeBetween(String value1, String value2) {
            addCriterion("auth_code between", value1, value2, "authCode");
            return (Criteria) this;
        }

        public Criteria andAuthCodeNotBetween(String value1, String value2) {
            addCriterion("auth_code not between", value1, value2, "authCode");
            return (Criteria) this;
        }

        public Criteria andClientIpIsNull() {
            addCriterion("client_ip is null");
            return (Criteria) this;
        }

        public Criteria andClientIpIsNotNull() {
            addCriterion("client_ip is not null");
            return (Criteria) this;
        }

        public Criteria andClientIpEqualTo(String value) {
            addCriterion("client_ip =", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpNotEqualTo(String value) {
            addCriterion("client_ip <>", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpGreaterThan(String value) {
            addCriterion("client_ip >", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpGreaterThanOrEqualTo(String value) {
            addCriterion("client_ip >=", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpLessThan(String value) {
            addCriterion("client_ip <", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpLessThanOrEqualTo(String value) {
            addCriterion("client_ip <=", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpLike(String value) {
            addCriterion("client_ip like", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpNotLike(String value) {
            addCriterion("client_ip not like", value, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpIn(List<String> values) {
            addCriterion("client_ip in", values, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpNotIn(List<String> values) {
            addCriterion("client_ip not in", values, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpBetween(String value1, String value2) {
            addCriterion("client_ip between", value1, value2, "clientIp");
            return (Criteria) this;
        }

        public Criteria andClientIpNotBetween(String value1, String value2) {
            addCriterion("client_ip not between", value1, value2, "clientIp");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(String value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(String value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(String value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(String value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(String value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLike(String value) {
            addCriterion("longitude like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotLike(String value) {
            addCriterion("longitude not like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<String> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<String> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(String value1, String value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(String value1, String value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(String value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(String value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(String value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(String value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(String value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLike(String value) {
            addCriterion("latitude like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotLike(String value) {
            addCriterion("latitude not like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<String> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<String> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(String value1, String value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(String value1, String value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNull() {
            addCriterion("expire_time is null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIsNotNull() {
            addCriterion("expire_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpireTimeEqualTo(Long value) {
            addCriterion("expire_time =", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotEqualTo(Long value) {
            addCriterion("expire_time <>", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThan(Long value) {
            addCriterion("expire_time >", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("expire_time >=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThan(Long value) {
            addCriterion("expire_time <", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeLessThanOrEqualTo(Long value) {
            addCriterion("expire_time <=", value, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeIn(List<Long> values) {
            addCriterion("expire_time in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotIn(List<Long> values) {
            addCriterion("expire_time not in", values, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeBetween(Long value1, Long value2) {
            addCriterion("expire_time between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andExpireTimeNotBetween(Long value1, Long value2) {
            addCriterion("expire_time not between", value1, value2, "expireTime");
            return (Criteria) this;
        }

        public Criteria andLimitPayIsNull() {
            addCriterion("limit_pay is null");
            return (Criteria) this;
        }

        public Criteria andLimitPayIsNotNull() {
            addCriterion("limit_pay is not null");
            return (Criteria) this;
        }

        public Criteria andLimitPayEqualTo(String value) {
            addCriterion("limit_pay =", value, "limitPay");
            return (Criteria) this;
        }

        public Criteria andLimitPayNotEqualTo(String value) {
            addCriterion("limit_pay <>", value, "limitPay");
            return (Criteria) this;
        }

        public Criteria andLimitPayGreaterThan(String value) {
            addCriterion("limit_pay >", value, "limitPay");
            return (Criteria) this;
        }

        public Criteria andLimitPayGreaterThanOrEqualTo(String value) {
            addCriterion("limit_pay >=", value, "limitPay");
            return (Criteria) this;
        }

        public Criteria andLimitPayLessThan(String value) {
            addCriterion("limit_pay <", value, "limitPay");
            return (Criteria) this;
        }

        public Criteria andLimitPayLessThanOrEqualTo(String value) {
            addCriterion("limit_pay <=", value, "limitPay");
            return (Criteria) this;
        }

        public Criteria andLimitPayLike(String value) {
            addCriterion("limit_pay like", value, "limitPay");
            return (Criteria) this;
        }

        public Criteria andLimitPayNotLike(String value) {
            addCriterion("limit_pay not like", value, "limitPay");
            return (Criteria) this;
        }

        public Criteria andLimitPayIn(List<String> values) {
            addCriterion("limit_pay in", values, "limitPay");
            return (Criteria) this;
        }

        public Criteria andLimitPayNotIn(List<String> values) {
            addCriterion("limit_pay not in", values, "limitPay");
            return (Criteria) this;
        }

        public Criteria andLimitPayBetween(String value1, String value2) {
            addCriterion("limit_pay between", value1, value2, "limitPay");
            return (Criteria) this;
        }

        public Criteria andLimitPayNotBetween(String value1, String value2) {
            addCriterion("limit_pay not between", value1, value2, "limitPay");
            return (Criteria) this;
        }

        public Criteria andOrderExtIsNull() {
            addCriterion("order_ext is null");
            return (Criteria) this;
        }

        public Criteria andOrderExtIsNotNull() {
            addCriterion("order_ext is not null");
            return (Criteria) this;
        }

        public Criteria andOrderExtEqualTo(String value) {
            addCriterion("order_ext =", value, "orderExt");
            return (Criteria) this;
        }

        public Criteria andOrderExtNotEqualTo(String value) {
            addCriterion("order_ext <>", value, "orderExt");
            return (Criteria) this;
        }

        public Criteria andOrderExtGreaterThan(String value) {
            addCriterion("order_ext >", value, "orderExt");
            return (Criteria) this;
        }

        public Criteria andOrderExtGreaterThanOrEqualTo(String value) {
            addCriterion("order_ext >=", value, "orderExt");
            return (Criteria) this;
        }

        public Criteria andOrderExtLessThan(String value) {
            addCriterion("order_ext <", value, "orderExt");
            return (Criteria) this;
        }

        public Criteria andOrderExtLessThanOrEqualTo(String value) {
            addCriterion("order_ext <=", value, "orderExt");
            return (Criteria) this;
        }

        public Criteria andOrderExtLike(String value) {
            addCriterion("order_ext like", value, "orderExt");
            return (Criteria) this;
        }

        public Criteria andOrderExtNotLike(String value) {
            addCriterion("order_ext not like", value, "orderExt");
            return (Criteria) this;
        }

        public Criteria andOrderExtIn(List<String> values) {
            addCriterion("order_ext in", values, "orderExt");
            return (Criteria) this;
        }

        public Criteria andOrderExtNotIn(List<String> values) {
            addCriterion("order_ext not in", values, "orderExt");
            return (Criteria) this;
        }

        public Criteria andOrderExtBetween(String value1, String value2) {
            addCriterion("order_ext between", value1, value2, "orderExt");
            return (Criteria) this;
        }

        public Criteria andOrderExtNotBetween(String value1, String value2) {
            addCriterion("order_ext not between", value1, value2, "orderExt");
            return (Criteria) this;
        }

        public Criteria andTradeStatusIsNull() {
            addCriterion("trade_status is null");
            return (Criteria) this;
        }

        public Criteria andTradeStatusIsNotNull() {
            addCriterion("trade_status is not null");
            return (Criteria) this;
        }

        public Criteria andTradeStatusEqualTo(String value) {
            addCriterion("trade_status =", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusNotEqualTo(String value) {
            addCriterion("trade_status <>", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusGreaterThan(String value) {
            addCriterion("trade_status >", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusGreaterThanOrEqualTo(String value) {
            addCriterion("trade_status >=", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusLessThan(String value) {
            addCriterion("trade_status <", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusLessThanOrEqualTo(String value) {
            addCriterion("trade_status <=", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusLike(String value) {
            addCriterion("trade_status like", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusNotLike(String value) {
            addCriterion("trade_status not like", value, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusIn(List<String> values) {
            addCriterion("trade_status in", values, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusNotIn(List<String> values) {
            addCriterion("trade_status not in", values, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusBetween(String value1, String value2) {
            addCriterion("trade_status between", value1, value2, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andTradeStatusNotBetween(String value1, String value2) {
            addCriterion("trade_status not between", value1, value2, "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusIsNull() {
            addCriterion("bill_status is null");
            return (Criteria) this;
        }

        public Criteria andBillStatusIsNotNull() {
            addCriterion("bill_status is not null");
            return (Criteria) this;
        }

        public Criteria andBillStatusEqualTo(String value) {
            addCriterion("bill_status =", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusNotEqualTo(String value) {
            addCriterion("bill_status <>", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusGreaterThan(String value) {
            addCriterion("bill_status >", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusGreaterThanOrEqualTo(String value) {
            addCriterion("bill_status >=", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusLessThan(String value) {
            addCriterion("bill_status <", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusLessThanOrEqualTo(String value) {
            addCriterion("bill_status <=", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusLike(String value) {
            addCriterion("bill_status like", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusNotLike(String value) {
            addCriterion("bill_status not like", value, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusIn(List<String> values) {
            addCriterion("bill_status in", values, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusNotIn(List<String> values) {
            addCriterion("bill_status not in", values, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusBetween(String value1, String value2) {
            addCriterion("bill_status between", value1, value2, "billStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusNotBetween(String value1, String value2) {
            addCriterion("bill_status not between", value1, value2, "billStatus");
            return (Criteria) this;
        }

        public Criteria andSettleStatusIsNull() {
            addCriterion("settle_status is null");
            return (Criteria) this;
        }

        public Criteria andSettleStatusIsNotNull() {
            addCriterion("settle_status is not null");
            return (Criteria) this;
        }

        public Criteria andSettleStatusEqualTo(String value) {
            addCriterion("settle_status =", value, "settleStatus");
            return (Criteria) this;
        }

        public Criteria andSettleStatusNotEqualTo(String value) {
            addCriterion("settle_status <>", value, "settleStatus");
            return (Criteria) this;
        }

        public Criteria andSettleStatusGreaterThan(String value) {
            addCriterion("settle_status >", value, "settleStatus");
            return (Criteria) this;
        }

        public Criteria andSettleStatusGreaterThanOrEqualTo(String value) {
            addCriterion("settle_status >=", value, "settleStatus");
            return (Criteria) this;
        }

        public Criteria andSettleStatusLessThan(String value) {
            addCriterion("settle_status <", value, "settleStatus");
            return (Criteria) this;
        }

        public Criteria andSettleStatusLessThanOrEqualTo(String value) {
            addCriterion("settle_status <=", value, "settleStatus");
            return (Criteria) this;
        }

        public Criteria andSettleStatusLike(String value) {
            addCriterion("settle_status like", value, "settleStatus");
            return (Criteria) this;
        }

        public Criteria andSettleStatusNotLike(String value) {
            addCriterion("settle_status not like", value, "settleStatus");
            return (Criteria) this;
        }

        public Criteria andSettleStatusIn(List<String> values) {
            addCriterion("settle_status in", values, "settleStatus");
            return (Criteria) this;
        }

        public Criteria andSettleStatusNotIn(List<String> values) {
            addCriterion("settle_status not in", values, "settleStatus");
            return (Criteria) this;
        }

        public Criteria andSettleStatusBetween(String value1, String value2) {
            addCriterion("settle_status between", value1, value2, "settleStatus");
            return (Criteria) this;
        }

        public Criteria andSettleStatusNotBetween(String value1, String value2) {
            addCriterion("settle_status not between", value1, value2, "settleStatus");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNull() {
            addCriterion("finish_time is null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIsNotNull() {
            addCriterion("finish_time is not null");
            return (Criteria) this;
        }

        public Criteria andFinishTimeEqualTo(String value) {
            addCriterion("finish_time =", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotEqualTo(String value) {
            addCriterion("finish_time <>", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThan(String value) {
            addCriterion("finish_time >", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeGreaterThanOrEqualTo(String value) {
            addCriterion("finish_time >=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThan(String value) {
            addCriterion("finish_time <", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLessThanOrEqualTo(String value) {
            addCriterion("finish_time <=", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLike(String value) {
            addCriterion("finish_time like", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotLike(String value) {
            addCriterion("finish_time not like", value, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeIn(List<String> values) {
            addCriterion("finish_time in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotIn(List<String> values) {
            addCriterion("finish_time not in", values, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeBetween(String value1, String value2) {
            addCriterion("finish_time between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andFinishTimeNotBetween(String value1, String value2) {
            addCriterion("finish_time not between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNull() {
            addCriterion("card_type is null");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNotNull() {
            addCriterion("card_type is not null");
            return (Criteria) this;
        }

        public Criteria andCardTypeEqualTo(String value) {
            addCriterion("card_type =", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotEqualTo(String value) {
            addCriterion("card_type <>", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThan(String value) {
            addCriterion("card_type >", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThanOrEqualTo(String value) {
            addCriterion("card_type >=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThan(String value) {
            addCriterion("card_type <", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThanOrEqualTo(String value) {
            addCriterion("card_type <=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLike(String value) {
            addCriterion("card_type like", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotLike(String value) {
            addCriterion("card_type not like", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeIn(List<String> values) {
            addCriterion("card_type in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotIn(List<String> values) {
            addCriterion("card_type not in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeBetween(String value1, String value2) {
            addCriterion("card_type between", value1, value2, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotBetween(String value1, String value2) {
            addCriterion("card_type not between", value1, value2, "cardType");
            return (Criteria) this;
        }

        public Criteria andChargeAmountIsNull() {
            addCriterion("charge_amount is null");
            return (Criteria) this;
        }

        public Criteria andChargeAmountIsNotNull() {
            addCriterion("charge_amount is not null");
            return (Criteria) this;
        }

        public Criteria andChargeAmountEqualTo(Long value) {
            addCriterion("charge_amount =", value, "chargeAmount");
            return (Criteria) this;
        }

        public Criteria andChargeAmountNotEqualTo(Long value) {
            addCriterion("charge_amount <>", value, "chargeAmount");
            return (Criteria) this;
        }

        public Criteria andChargeAmountGreaterThan(Long value) {
            addCriterion("charge_amount >", value, "chargeAmount");
            return (Criteria) this;
        }

        public Criteria andChargeAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("charge_amount >=", value, "chargeAmount");
            return (Criteria) this;
        }

        public Criteria andChargeAmountLessThan(Long value) {
            addCriterion("charge_amount <", value, "chargeAmount");
            return (Criteria) this;
        }

        public Criteria andChargeAmountLessThanOrEqualTo(Long value) {
            addCriterion("charge_amount <=", value, "chargeAmount");
            return (Criteria) this;
        }

        public Criteria andChargeAmountIn(List<Long> values) {
            addCriterion("charge_amount in", values, "chargeAmount");
            return (Criteria) this;
        }

        public Criteria andChargeAmountNotIn(List<Long> values) {
            addCriterion("charge_amount not in", values, "chargeAmount");
            return (Criteria) this;
        }

        public Criteria andChargeAmountBetween(Long value1, Long value2) {
            addCriterion("charge_amount between", value1, value2, "chargeAmount");
            return (Criteria) this;
        }

        public Criteria andChargeAmountNotBetween(Long value1, Long value2) {
            addCriterion("charge_amount not between", value1, value2, "chargeAmount");
            return (Criteria) this;
        }

        public Criteria andChargeRateIsNull() {
            addCriterion("charge_rate is null");
            return (Criteria) this;
        }

        public Criteria andChargeRateIsNotNull() {
            addCriterion("charge_rate is not null");
            return (Criteria) this;
        }

        public Criteria andChargeRateEqualTo(String value) {
            addCriterion("charge_rate =", value, "chargeRate");
            return (Criteria) this;
        }

        public Criteria andChargeRateNotEqualTo(String value) {
            addCriterion("charge_rate <>", value, "chargeRate");
            return (Criteria) this;
        }

        public Criteria andChargeRateGreaterThan(String value) {
            addCriterion("charge_rate >", value, "chargeRate");
            return (Criteria) this;
        }

        public Criteria andChargeRateGreaterThanOrEqualTo(String value) {
            addCriterion("charge_rate >=", value, "chargeRate");
            return (Criteria) this;
        }

        public Criteria andChargeRateLessThan(String value) {
            addCriterion("charge_rate <", value, "chargeRate");
            return (Criteria) this;
        }

        public Criteria andChargeRateLessThanOrEqualTo(String value) {
            addCriterion("charge_rate <=", value, "chargeRate");
            return (Criteria) this;
        }

        public Criteria andChargeRateLike(String value) {
            addCriterion("charge_rate like", value, "chargeRate");
            return (Criteria) this;
        }

        public Criteria andChargeRateNotLike(String value) {
            addCriterion("charge_rate not like", value, "chargeRate");
            return (Criteria) this;
        }

        public Criteria andChargeRateIn(List<String> values) {
            addCriterion("charge_rate in", values, "chargeRate");
            return (Criteria) this;
        }

        public Criteria andChargeRateNotIn(List<String> values) {
            addCriterion("charge_rate not in", values, "chargeRate");
            return (Criteria) this;
        }

        public Criteria andChargeRateBetween(String value1, String value2) {
            addCriterion("charge_rate between", value1, value2, "chargeRate");
            return (Criteria) this;
        }

        public Criteria andChargeRateNotBetween(String value1, String value2) {
            addCriterion("charge_rate not between", value1, value2, "chargeRate");
            return (Criteria) this;
        }

        public Criteria andAddFeeAmountIsNull() {
            addCriterion("add_fee_amount is null");
            return (Criteria) this;
        }

        public Criteria andAddFeeAmountIsNotNull() {
            addCriterion("add_fee_amount is not null");
            return (Criteria) this;
        }

        public Criteria andAddFeeAmountEqualTo(Long value) {
            addCriterion("add_fee_amount =", value, "addFeeAmount");
            return (Criteria) this;
        }

        public Criteria andAddFeeAmountNotEqualTo(Long value) {
            addCriterion("add_fee_amount <>", value, "addFeeAmount");
            return (Criteria) this;
        }

        public Criteria andAddFeeAmountGreaterThan(Long value) {
            addCriterion("add_fee_amount >", value, "addFeeAmount");
            return (Criteria) this;
        }

        public Criteria andAddFeeAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("add_fee_amount >=", value, "addFeeAmount");
            return (Criteria) this;
        }

        public Criteria andAddFeeAmountLessThan(Long value) {
            addCriterion("add_fee_amount <", value, "addFeeAmount");
            return (Criteria) this;
        }

        public Criteria andAddFeeAmountLessThanOrEqualTo(Long value) {
            addCriterion("add_fee_amount <=", value, "addFeeAmount");
            return (Criteria) this;
        }

        public Criteria andAddFeeAmountIn(List<Long> values) {
            addCriterion("add_fee_amount in", values, "addFeeAmount");
            return (Criteria) this;
        }

        public Criteria andAddFeeAmountNotIn(List<Long> values) {
            addCriterion("add_fee_amount not in", values, "addFeeAmount");
            return (Criteria) this;
        }

        public Criteria andAddFeeAmountBetween(Long value1, Long value2) {
            addCriterion("add_fee_amount between", value1, value2, "addFeeAmount");
            return (Criteria) this;
        }

        public Criteria andAddFeeAmountNotBetween(Long value1, Long value2) {
            addCriterion("add_fee_amount not between", value1, value2, "addFeeAmount");
            return (Criteria) this;
        }

        public Criteria andAdvanceFlagIsNull() {
            addCriterion("advance_flag is null");
            return (Criteria) this;
        }

        public Criteria andAdvanceFlagIsNotNull() {
            addCriterion("advance_flag is not null");
            return (Criteria) this;
        }

        public Criteria andAdvanceFlagEqualTo(String value) {
            addCriterion("advance_flag =", value, "advanceFlag");
            return (Criteria) this;
        }

        public Criteria andAdvanceFlagNotEqualTo(String value) {
            addCriterion("advance_flag <>", value, "advanceFlag");
            return (Criteria) this;
        }

        public Criteria andAdvanceFlagGreaterThan(String value) {
            addCriterion("advance_flag >", value, "advanceFlag");
            return (Criteria) this;
        }

        public Criteria andAdvanceFlagGreaterThanOrEqualTo(String value) {
            addCriterion("advance_flag >=", value, "advanceFlag");
            return (Criteria) this;
        }

        public Criteria andAdvanceFlagLessThan(String value) {
            addCriterion("advance_flag <", value, "advanceFlag");
            return (Criteria) this;
        }

        public Criteria andAdvanceFlagLessThanOrEqualTo(String value) {
            addCriterion("advance_flag <=", value, "advanceFlag");
            return (Criteria) this;
        }

        public Criteria andAdvanceFlagLike(String value) {
            addCriterion("advance_flag like", value, "advanceFlag");
            return (Criteria) this;
        }

        public Criteria andAdvanceFlagNotLike(String value) {
            addCriterion("advance_flag not like", value, "advanceFlag");
            return (Criteria) this;
        }

        public Criteria andAdvanceFlagIn(List<String> values) {
            addCriterion("advance_flag in", values, "advanceFlag");
            return (Criteria) this;
        }

        public Criteria andAdvanceFlagNotIn(List<String> values) {
            addCriterion("advance_flag not in", values, "advanceFlag");
            return (Criteria) this;
        }

        public Criteria andAdvanceFlagBetween(String value1, String value2) {
            addCriterion("advance_flag between", value1, value2, "advanceFlag");
            return (Criteria) this;
        }

        public Criteria andAdvanceFlagNotBetween(String value1, String value2) {
            addCriterion("advance_flag not between", value1, value2, "advanceFlag");
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

        public Criteria andOrderSourceIsNull() {
            addCriterion("order_source is null");
            return (Criteria) this;
        }

        public Criteria andOrderSourceIsNotNull() {
            addCriterion("order_source is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSourceEqualTo(String value) {
            addCriterion("order_source =", value, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceNotEqualTo(String value) {
            addCriterion("order_source <>", value, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceGreaterThan(String value) {
            addCriterion("order_source >", value, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceGreaterThanOrEqualTo(String value) {
            addCriterion("order_source >=", value, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceLessThan(String value) {
            addCriterion("order_source <", value, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceLessThanOrEqualTo(String value) {
            addCriterion("order_source <=", value, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceLike(String value) {
            addCriterion("order_source like", value, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceNotLike(String value) {
            addCriterion("order_source not like", value, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceIn(List<String> values) {
            addCriterion("order_source in", values, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceNotIn(List<String> values) {
            addCriterion("order_source not in", values, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceBetween(String value1, String value2) {
            addCriterion("order_source between", value1, value2, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceNotBetween(String value1, String value2) {
            addCriterion("order_source not between", value1, value2, "orderSource");
            return (Criteria) this;
        }

        public Criteria andSourceAppIsNull() {
            addCriterion("source_app is null");
            return (Criteria) this;
        }

        public Criteria andSourceAppIsNotNull() {
            addCriterion("source_app is not null");
            return (Criteria) this;
        }

        public Criteria andSourceAppEqualTo(String value) {
            addCriterion("source_app =", value, "sourceApp");
            return (Criteria) this;
        }

        public Criteria andSourceAppNotEqualTo(String value) {
            addCriterion("source_app <>", value, "sourceApp");
            return (Criteria) this;
        }

        public Criteria andSourceAppGreaterThan(String value) {
            addCriterion("source_app >", value, "sourceApp");
            return (Criteria) this;
        }

        public Criteria andSourceAppGreaterThanOrEqualTo(String value) {
            addCriterion("source_app >=", value, "sourceApp");
            return (Criteria) this;
        }

        public Criteria andSourceAppLessThan(String value) {
            addCriterion("source_app <", value, "sourceApp");
            return (Criteria) this;
        }

        public Criteria andSourceAppLessThanOrEqualTo(String value) {
            addCriterion("source_app <=", value, "sourceApp");
            return (Criteria) this;
        }

        public Criteria andSourceAppLike(String value) {
            addCriterion("source_app like", value, "sourceApp");
            return (Criteria) this;
        }

        public Criteria andSourceAppNotLike(String value) {
            addCriterion("source_app not like", value, "sourceApp");
            return (Criteria) this;
        }

        public Criteria andSourceAppIn(List<String> values) {
            addCriterion("source_app in", values, "sourceApp");
            return (Criteria) this;
        }

        public Criteria andSourceAppNotIn(List<String> values) {
            addCriterion("source_app not in", values, "sourceApp");
            return (Criteria) this;
        }

        public Criteria andSourceAppBetween(String value1, String value2) {
            addCriterion("source_app between", value1, value2, "sourceApp");
            return (Criteria) this;
        }

        public Criteria andSourceAppNotBetween(String value1, String value2) {
            addCriterion("source_app not between", value1, value2, "sourceApp");
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

        public Criteria andSerialLikeInsensitive(String value) {
            addCriterion("upper(serial) like", value.toUpperCase(), "serial");
            return (Criteria) this;
        }

        public Criteria andOutSerialLikeInsensitive(String value) {
            addCriterion("upper(out_serial) like", value.toUpperCase(), "outSerial");
            return (Criteria) this;
        }

        public Criteria andOutMchIdLikeInsensitive(String value) {
            addCriterion("upper(out_mch_id) like", value.toUpperCase(), "outMchId");
            return (Criteria) this;
        }

        public Criteria andMchNameLikeInsensitive(String value) {
            addCriterion("upper(mch_name) like", value.toUpperCase(), "mchName");
            return (Criteria) this;
        }

        public Criteria andSnLikeInsensitive(String value) {
            addCriterion("upper(sn) like", value.toUpperCase(), "sn");
            return (Criteria) this;
        }

        public Criteria andTermSnLikeInsensitive(String value) {
            addCriterion("upper(term_sn) like", value.toUpperCase(), "termSn");
            return (Criteria) this;
        }

        public Criteria andChannelMchNoLikeInsensitive(String value) {
            addCriterion("upper(channel_mch_no) like", value.toUpperCase(), "channelMchNo");
            return (Criteria) this;
        }

        public Criteria andChannelTermNoLikeInsensitive(String value) {
            addCriterion("upper(channel_term_no) like", value.toUpperCase(), "channelTermNo");
            return (Criteria) this;
        }

        public Criteria andChannelOrderNoLikeInsensitive(String value) {
            addCriterion("upper(channel_order_no) like", value.toUpperCase(), "channelOrderNo");
            return (Criteria) this;
        }

        public Criteria andTradeNoLikeInsensitive(String value) {
            addCriterion("upper(trade_no) like", value.toUpperCase(), "tradeNo");
            return (Criteria) this;
        }

        public Criteria andOutTradeNoLikeInsensitive(String value) {
            addCriterion("upper(out_trade_no) like", value.toUpperCase(), "outTradeNo");
            return (Criteria) this;
        }

        public Criteria andOrigSerialLikeInsensitive(String value) {
            addCriterion("upper(orig_serial) like", value.toUpperCase(), "origSerial");
            return (Criteria) this;
        }

        public Criteria andOrderTypeLikeInsensitive(String value) {
            addCriterion("upper(order_type) like", value.toUpperCase(), "orderType");
            return (Criteria) this;
        }

        public Criteria andProductLikeInsensitive(String value) {
            addCriterion("upper(product) like", value.toUpperCase(), "product");
            return (Criteria) this;
        }

        public Criteria andSubProductLikeInsensitive(String value) {
            addCriterion("upper(sub_product) like", value.toUpperCase(), "subProduct");
            return (Criteria) this;
        }

        public Criteria andOrderDateLikeInsensitive(String value) {
            addCriterion("upper(order_date) like", value.toUpperCase(), "orderDate");
            return (Criteria) this;
        }

        public Criteria andNotifyUrlLikeInsensitive(String value) {
            addCriterion("upper(notify_url) like", value.toUpperCase(), "notifyUrl");
            return (Criteria) this;
        }

        public Criteria andFrontUrlLikeInsensitive(String value) {
            addCriterion("upper(front_url) like", value.toUpperCase(), "frontUrl");
            return (Criteria) this;
        }

        public Criteria andSubjectLikeInsensitive(String value) {
            addCriterion("upper(subject) like", value.toUpperCase(), "subject");
            return (Criteria) this;
        }

        public Criteria andSubAppidLikeInsensitive(String value) {
            addCriterion("upper(sub_appid) like", value.toUpperCase(), "subAppid");
            return (Criteria) this;
        }

        public Criteria andSubOpenidLikeInsensitive(String value) {
            addCriterion("upper(sub_openid) like", value.toUpperCase(), "subOpenid");
            return (Criteria) this;
        }

        public Criteria andAuthCodeLikeInsensitive(String value) {
            addCriterion("upper(auth_code) like", value.toUpperCase(), "authCode");
            return (Criteria) this;
        }

        public Criteria andClientIpLikeInsensitive(String value) {
            addCriterion("upper(client_ip) like", value.toUpperCase(), "clientIp");
            return (Criteria) this;
        }

        public Criteria andLongitudeLikeInsensitive(String value) {
            addCriterion("upper(longitude) like", value.toUpperCase(), "longitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLikeInsensitive(String value) {
            addCriterion("upper(latitude) like", value.toUpperCase(), "latitude");
            return (Criteria) this;
        }

        public Criteria andLimitPayLikeInsensitive(String value) {
            addCriterion("upper(limit_pay) like", value.toUpperCase(), "limitPay");
            return (Criteria) this;
        }

        public Criteria andOrderExtLikeInsensitive(String value) {
            addCriterion("upper(order_ext) like", value.toUpperCase(), "orderExt");
            return (Criteria) this;
        }

        public Criteria andTradeStatusLikeInsensitive(String value) {
            addCriterion("upper(trade_status) like", value.toUpperCase(), "tradeStatus");
            return (Criteria) this;
        }

        public Criteria andBillStatusLikeInsensitive(String value) {
            addCriterion("upper(bill_status) like", value.toUpperCase(), "billStatus");
            return (Criteria) this;
        }

        public Criteria andSettleStatusLikeInsensitive(String value) {
            addCriterion("upper(settle_status) like", value.toUpperCase(), "settleStatus");
            return (Criteria) this;
        }

        public Criteria andFinishTimeLikeInsensitive(String value) {
            addCriterion("upper(finish_time) like", value.toUpperCase(), "finishTime");
            return (Criteria) this;
        }

        public Criteria andCardTypeLikeInsensitive(String value) {
            addCriterion("upper(card_type) like", value.toUpperCase(), "cardType");
            return (Criteria) this;
        }

        public Criteria andChargeRateLikeInsensitive(String value) {
            addCriterion("upper(charge_rate) like", value.toUpperCase(), "chargeRate");
            return (Criteria) this;
        }

        public Criteria andAdvanceFlagLikeInsensitive(String value) {
            addCriterion("upper(advance_flag) like", value.toUpperCase(), "advanceFlag");
            return (Criteria) this;
        }

        public Criteria andRemarkLikeInsensitive(String value) {
            addCriterion("upper(remark) like", value.toUpperCase(), "remark");
            return (Criteria) this;
        }

        public Criteria andOrderSourceLikeInsensitive(String value) {
            addCriterion("upper(order_source) like", value.toUpperCase(), "orderSource");
            return (Criteria) this;
        }

        public Criteria andSourceAppLikeInsensitive(String value) {
            addCriterion("upper(source_app) like", value.toUpperCase(), "sourceApp");
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