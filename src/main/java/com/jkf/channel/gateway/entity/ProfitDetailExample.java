package com.jkf.channel.gateway.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProfitDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProfitDetailExample() {
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

        public Criteria andProfitOrgIsNull() {
            addCriterion("profit_org is null");
            return (Criteria) this;
        }

        public Criteria andProfitOrgIsNotNull() {
            addCriterion("profit_org is not null");
            return (Criteria) this;
        }

        public Criteria andProfitOrgEqualTo(String value) {
            addCriterion("profit_org =", value, "profitOrg");
            return (Criteria) this;
        }

        public Criteria andProfitOrgNotEqualTo(String value) {
            addCriterion("profit_org <>", value, "profitOrg");
            return (Criteria) this;
        }

        public Criteria andProfitOrgGreaterThan(String value) {
            addCriterion("profit_org >", value, "profitOrg");
            return (Criteria) this;
        }

        public Criteria andProfitOrgGreaterThanOrEqualTo(String value) {
            addCriterion("profit_org >=", value, "profitOrg");
            return (Criteria) this;
        }

        public Criteria andProfitOrgLessThan(String value) {
            addCriterion("profit_org <", value, "profitOrg");
            return (Criteria) this;
        }

        public Criteria andProfitOrgLessThanOrEqualTo(String value) {
            addCriterion("profit_org <=", value, "profitOrg");
            return (Criteria) this;
        }

        public Criteria andProfitOrgLike(String value) {
            addCriterion("profit_org like", value, "profitOrg");
            return (Criteria) this;
        }

        public Criteria andProfitOrgNotLike(String value) {
            addCriterion("profit_org not like", value, "profitOrg");
            return (Criteria) this;
        }

        public Criteria andProfitOrgIn(List<String> values) {
            addCriterion("profit_org in", values, "profitOrg");
            return (Criteria) this;
        }

        public Criteria andProfitOrgNotIn(List<String> values) {
            addCriterion("profit_org not in", values, "profitOrg");
            return (Criteria) this;
        }

        public Criteria andProfitOrgBetween(String value1, String value2) {
            addCriterion("profit_org between", value1, value2, "profitOrg");
            return (Criteria) this;
        }

        public Criteria andProfitOrgNotBetween(String value1, String value2) {
            addCriterion("profit_org not between", value1, value2, "profitOrg");
            return (Criteria) this;
        }

        public Criteria andProfitOrgTypeIsNull() {
            addCriterion("profit_org_type is null");
            return (Criteria) this;
        }

        public Criteria andProfitOrgTypeIsNotNull() {
            addCriterion("profit_org_type is not null");
            return (Criteria) this;
        }

        public Criteria andProfitOrgTypeEqualTo(String value) {
            addCriterion("profit_org_type =", value, "profitOrgType");
            return (Criteria) this;
        }

        public Criteria andProfitOrgTypeNotEqualTo(String value) {
            addCriterion("profit_org_type <>", value, "profitOrgType");
            return (Criteria) this;
        }

        public Criteria andProfitOrgTypeGreaterThan(String value) {
            addCriterion("profit_org_type >", value, "profitOrgType");
            return (Criteria) this;
        }

        public Criteria andProfitOrgTypeGreaterThanOrEqualTo(String value) {
            addCriterion("profit_org_type >=", value, "profitOrgType");
            return (Criteria) this;
        }

        public Criteria andProfitOrgTypeLessThan(String value) {
            addCriterion("profit_org_type <", value, "profitOrgType");
            return (Criteria) this;
        }

        public Criteria andProfitOrgTypeLessThanOrEqualTo(String value) {
            addCriterion("profit_org_type <=", value, "profitOrgType");
            return (Criteria) this;
        }

        public Criteria andProfitOrgTypeLike(String value) {
            addCriterion("profit_org_type like", value, "profitOrgType");
            return (Criteria) this;
        }

        public Criteria andProfitOrgTypeNotLike(String value) {
            addCriterion("profit_org_type not like", value, "profitOrgType");
            return (Criteria) this;
        }

        public Criteria andProfitOrgTypeIn(List<String> values) {
            addCriterion("profit_org_type in", values, "profitOrgType");
            return (Criteria) this;
        }

        public Criteria andProfitOrgTypeNotIn(List<String> values) {
            addCriterion("profit_org_type not in", values, "profitOrgType");
            return (Criteria) this;
        }

        public Criteria andProfitOrgTypeBetween(String value1, String value2) {
            addCriterion("profit_org_type between", value1, value2, "profitOrgType");
            return (Criteria) this;
        }

        public Criteria andProfitOrgTypeNotBetween(String value1, String value2) {
            addCriterion("profit_org_type not between", value1, value2, "profitOrgType");
            return (Criteria) this;
        }

        public Criteria andProfitOrgNameIsNull() {
            addCriterion("profit_org_name is null");
            return (Criteria) this;
        }

        public Criteria andProfitOrgNameIsNotNull() {
            addCriterion("profit_org_name is not null");
            return (Criteria) this;
        }

        public Criteria andProfitOrgNameEqualTo(String value) {
            addCriterion("profit_org_name =", value, "profitOrgName");
            return (Criteria) this;
        }

        public Criteria andProfitOrgNameNotEqualTo(String value) {
            addCriterion("profit_org_name <>", value, "profitOrgName");
            return (Criteria) this;
        }

        public Criteria andProfitOrgNameGreaterThan(String value) {
            addCriterion("profit_org_name >", value, "profitOrgName");
            return (Criteria) this;
        }

        public Criteria andProfitOrgNameGreaterThanOrEqualTo(String value) {
            addCriterion("profit_org_name >=", value, "profitOrgName");
            return (Criteria) this;
        }

        public Criteria andProfitOrgNameLessThan(String value) {
            addCriterion("profit_org_name <", value, "profitOrgName");
            return (Criteria) this;
        }

        public Criteria andProfitOrgNameLessThanOrEqualTo(String value) {
            addCriterion("profit_org_name <=", value, "profitOrgName");
            return (Criteria) this;
        }

        public Criteria andProfitOrgNameLike(String value) {
            addCriterion("profit_org_name like", value, "profitOrgName");
            return (Criteria) this;
        }

        public Criteria andProfitOrgNameNotLike(String value) {
            addCriterion("profit_org_name not like", value, "profitOrgName");
            return (Criteria) this;
        }

        public Criteria andProfitOrgNameIn(List<String> values) {
            addCriterion("profit_org_name in", values, "profitOrgName");
            return (Criteria) this;
        }

        public Criteria andProfitOrgNameNotIn(List<String> values) {
            addCriterion("profit_org_name not in", values, "profitOrgName");
            return (Criteria) this;
        }

        public Criteria andProfitOrgNameBetween(String value1, String value2) {
            addCriterion("profit_org_name between", value1, value2, "profitOrgName");
            return (Criteria) this;
        }

        public Criteria andProfitOrgNameNotBetween(String value1, String value2) {
            addCriterion("profit_org_name not between", value1, value2, "profitOrgName");
            return (Criteria) this;
        }

        public Criteria andVirtualNoIsNull() {
            addCriterion("virtual_no is null");
            return (Criteria) this;
        }

        public Criteria andVirtualNoIsNotNull() {
            addCriterion("virtual_no is not null");
            return (Criteria) this;
        }

        public Criteria andVirtualNoEqualTo(String value) {
            addCriterion("virtual_no =", value, "virtualNo");
            return (Criteria) this;
        }

        public Criteria andVirtualNoNotEqualTo(String value) {
            addCriterion("virtual_no <>", value, "virtualNo");
            return (Criteria) this;
        }

        public Criteria andVirtualNoGreaterThan(String value) {
            addCriterion("virtual_no >", value, "virtualNo");
            return (Criteria) this;
        }

        public Criteria andVirtualNoGreaterThanOrEqualTo(String value) {
            addCriterion("virtual_no >=", value, "virtualNo");
            return (Criteria) this;
        }

        public Criteria andVirtualNoLessThan(String value) {
            addCriterion("virtual_no <", value, "virtualNo");
            return (Criteria) this;
        }

        public Criteria andVirtualNoLessThanOrEqualTo(String value) {
            addCriterion("virtual_no <=", value, "virtualNo");
            return (Criteria) this;
        }

        public Criteria andVirtualNoLike(String value) {
            addCriterion("virtual_no like", value, "virtualNo");
            return (Criteria) this;
        }

        public Criteria andVirtualNoNotLike(String value) {
            addCriterion("virtual_no not like", value, "virtualNo");
            return (Criteria) this;
        }

        public Criteria andVirtualNoIn(List<String> values) {
            addCriterion("virtual_no in", values, "virtualNo");
            return (Criteria) this;
        }

        public Criteria andVirtualNoNotIn(List<String> values) {
            addCriterion("virtual_no not in", values, "virtualNo");
            return (Criteria) this;
        }

        public Criteria andVirtualNoBetween(String value1, String value2) {
            addCriterion("virtual_no between", value1, value2, "virtualNo");
            return (Criteria) this;
        }

        public Criteria andVirtualNoNotBetween(String value1, String value2) {
            addCriterion("virtual_no not between", value1, value2, "virtualNo");
            return (Criteria) this;
        }

        public Criteria andProfitTypeIsNull() {
            addCriterion("profit_type is null");
            return (Criteria) this;
        }

        public Criteria andProfitTypeIsNotNull() {
            addCriterion("profit_type is not null");
            return (Criteria) this;
        }

        public Criteria andProfitTypeEqualTo(String value) {
            addCriterion("profit_type =", value, "profitType");
            return (Criteria) this;
        }

        public Criteria andProfitTypeNotEqualTo(String value) {
            addCriterion("profit_type <>", value, "profitType");
            return (Criteria) this;
        }

        public Criteria andProfitTypeGreaterThan(String value) {
            addCriterion("profit_type >", value, "profitType");
            return (Criteria) this;
        }

        public Criteria andProfitTypeGreaterThanOrEqualTo(String value) {
            addCriterion("profit_type >=", value, "profitType");
            return (Criteria) this;
        }

        public Criteria andProfitTypeLessThan(String value) {
            addCriterion("profit_type <", value, "profitType");
            return (Criteria) this;
        }

        public Criteria andProfitTypeLessThanOrEqualTo(String value) {
            addCriterion("profit_type <=", value, "profitType");
            return (Criteria) this;
        }

        public Criteria andProfitTypeLike(String value) {
            addCriterion("profit_type like", value, "profitType");
            return (Criteria) this;
        }

        public Criteria andProfitTypeNotLike(String value) {
            addCriterion("profit_type not like", value, "profitType");
            return (Criteria) this;
        }

        public Criteria andProfitTypeIn(List<String> values) {
            addCriterion("profit_type in", values, "profitType");
            return (Criteria) this;
        }

        public Criteria andProfitTypeNotIn(List<String> values) {
            addCriterion("profit_type not in", values, "profitType");
            return (Criteria) this;
        }

        public Criteria andProfitTypeBetween(String value1, String value2) {
            addCriterion("profit_type between", value1, value2, "profitType");
            return (Criteria) this;
        }

        public Criteria andProfitTypeNotBetween(String value1, String value2) {
            addCriterion("profit_type not between", value1, value2, "profitType");
            return (Criteria) this;
        }

        public Criteria andProfitRemarkIsNull() {
            addCriterion("profit_remark is null");
            return (Criteria) this;
        }

        public Criteria andProfitRemarkIsNotNull() {
            addCriterion("profit_remark is not null");
            return (Criteria) this;
        }

        public Criteria andProfitRemarkEqualTo(String value) {
            addCriterion("profit_remark =", value, "profitRemark");
            return (Criteria) this;
        }

        public Criteria andProfitRemarkNotEqualTo(String value) {
            addCriterion("profit_remark <>", value, "profitRemark");
            return (Criteria) this;
        }

        public Criteria andProfitRemarkGreaterThan(String value) {
            addCriterion("profit_remark >", value, "profitRemark");
            return (Criteria) this;
        }

        public Criteria andProfitRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("profit_remark >=", value, "profitRemark");
            return (Criteria) this;
        }

        public Criteria andProfitRemarkLessThan(String value) {
            addCriterion("profit_remark <", value, "profitRemark");
            return (Criteria) this;
        }

        public Criteria andProfitRemarkLessThanOrEqualTo(String value) {
            addCriterion("profit_remark <=", value, "profitRemark");
            return (Criteria) this;
        }

        public Criteria andProfitRemarkLike(String value) {
            addCriterion("profit_remark like", value, "profitRemark");
            return (Criteria) this;
        }

        public Criteria andProfitRemarkNotLike(String value) {
            addCriterion("profit_remark not like", value, "profitRemark");
            return (Criteria) this;
        }

        public Criteria andProfitRemarkIn(List<String> values) {
            addCriterion("profit_remark in", values, "profitRemark");
            return (Criteria) this;
        }

        public Criteria andProfitRemarkNotIn(List<String> values) {
            addCriterion("profit_remark not in", values, "profitRemark");
            return (Criteria) this;
        }

        public Criteria andProfitRemarkBetween(String value1, String value2) {
            addCriterion("profit_remark between", value1, value2, "profitRemark");
            return (Criteria) this;
        }

        public Criteria andProfitRemarkNotBetween(String value1, String value2) {
            addCriterion("profit_remark not between", value1, value2, "profitRemark");
            return (Criteria) this;
        }

        public Criteria andProfitOrgLevelIsNull() {
            addCriterion("profit_org_level is null");
            return (Criteria) this;
        }

        public Criteria andProfitOrgLevelIsNotNull() {
            addCriterion("profit_org_level is not null");
            return (Criteria) this;
        }

        public Criteria andProfitOrgLevelEqualTo(String value) {
            addCriterion("profit_org_level =", value, "profitOrgLevel");
            return (Criteria) this;
        }

        public Criteria andProfitOrgLevelNotEqualTo(String value) {
            addCriterion("profit_org_level <>", value, "profitOrgLevel");
            return (Criteria) this;
        }

        public Criteria andProfitOrgLevelGreaterThan(String value) {
            addCriterion("profit_org_level >", value, "profitOrgLevel");
            return (Criteria) this;
        }

        public Criteria andProfitOrgLevelGreaterThanOrEqualTo(String value) {
            addCriterion("profit_org_level >=", value, "profitOrgLevel");
            return (Criteria) this;
        }

        public Criteria andProfitOrgLevelLessThan(String value) {
            addCriterion("profit_org_level <", value, "profitOrgLevel");
            return (Criteria) this;
        }

        public Criteria andProfitOrgLevelLessThanOrEqualTo(String value) {
            addCriterion("profit_org_level <=", value, "profitOrgLevel");
            return (Criteria) this;
        }

        public Criteria andProfitOrgLevelLike(String value) {
            addCriterion("profit_org_level like", value, "profitOrgLevel");
            return (Criteria) this;
        }

        public Criteria andProfitOrgLevelNotLike(String value) {
            addCriterion("profit_org_level not like", value, "profitOrgLevel");
            return (Criteria) this;
        }

        public Criteria andProfitOrgLevelIn(List<String> values) {
            addCriterion("profit_org_level in", values, "profitOrgLevel");
            return (Criteria) this;
        }

        public Criteria andProfitOrgLevelNotIn(List<String> values) {
            addCriterion("profit_org_level not in", values, "profitOrgLevel");
            return (Criteria) this;
        }

        public Criteria andProfitOrgLevelBetween(String value1, String value2) {
            addCriterion("profit_org_level between", value1, value2, "profitOrgLevel");
            return (Criteria) this;
        }

        public Criteria andProfitOrgLevelNotBetween(String value1, String value2) {
            addCriterion("profit_org_level not between", value1, value2, "profitOrgLevel");
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

        public Criteria andApplyIdIsNull() {
            addCriterion("apply_id is null");
            return (Criteria) this;
        }

        public Criteria andApplyIdIsNotNull() {
            addCriterion("apply_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplyIdEqualTo(String value) {
            addCriterion("apply_id =", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotEqualTo(String value) {
            addCriterion("apply_id <>", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdGreaterThan(String value) {
            addCriterion("apply_id >", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdGreaterThanOrEqualTo(String value) {
            addCriterion("apply_id >=", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLessThan(String value) {
            addCriterion("apply_id <", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLessThanOrEqualTo(String value) {
            addCriterion("apply_id <=", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLike(String value) {
            addCriterion("apply_id like", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotLike(String value) {
            addCriterion("apply_id not like", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdIn(List<String> values) {
            addCriterion("apply_id in", values, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotIn(List<String> values) {
            addCriterion("apply_id not in", values, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdBetween(String value1, String value2) {
            addCriterion("apply_id between", value1, value2, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotBetween(String value1, String value2) {
            addCriterion("apply_id not between", value1, value2, "applyId");
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

        public Criteria andPlatSerialIsNull() {
            addCriterion("plat_serial is null");
            return (Criteria) this;
        }

        public Criteria andPlatSerialIsNotNull() {
            addCriterion("plat_serial is not null");
            return (Criteria) this;
        }

        public Criteria andPlatSerialEqualTo(String value) {
            addCriterion("plat_serial =", value, "platSerial");
            return (Criteria) this;
        }

        public Criteria andPlatSerialNotEqualTo(String value) {
            addCriterion("plat_serial <>", value, "platSerial");
            return (Criteria) this;
        }

        public Criteria andPlatSerialGreaterThan(String value) {
            addCriterion("plat_serial >", value, "platSerial");
            return (Criteria) this;
        }

        public Criteria andPlatSerialGreaterThanOrEqualTo(String value) {
            addCriterion("plat_serial >=", value, "platSerial");
            return (Criteria) this;
        }

        public Criteria andPlatSerialLessThan(String value) {
            addCriterion("plat_serial <", value, "platSerial");
            return (Criteria) this;
        }

        public Criteria andPlatSerialLessThanOrEqualTo(String value) {
            addCriterion("plat_serial <=", value, "platSerial");
            return (Criteria) this;
        }

        public Criteria andPlatSerialLike(String value) {
            addCriterion("plat_serial like", value, "platSerial");
            return (Criteria) this;
        }

        public Criteria andPlatSerialNotLike(String value) {
            addCriterion("plat_serial not like", value, "platSerial");
            return (Criteria) this;
        }

        public Criteria andPlatSerialIn(List<String> values) {
            addCriterion("plat_serial in", values, "platSerial");
            return (Criteria) this;
        }

        public Criteria andPlatSerialNotIn(List<String> values) {
            addCriterion("plat_serial not in", values, "platSerial");
            return (Criteria) this;
        }

        public Criteria andPlatSerialBetween(String value1, String value2) {
            addCriterion("plat_serial between", value1, value2, "platSerial");
            return (Criteria) this;
        }

        public Criteria andPlatSerialNotBetween(String value1, String value2) {
            addCriterion("plat_serial not between", value1, value2, "platSerial");
            return (Criteria) this;
        }

        public Criteria andTradeAmountIsNull() {
            addCriterion("trade_amount is null");
            return (Criteria) this;
        }

        public Criteria andTradeAmountIsNotNull() {
            addCriterion("trade_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTradeAmountEqualTo(Long value) {
            addCriterion("trade_amount =", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountNotEqualTo(Long value) {
            addCriterion("trade_amount <>", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountGreaterThan(Long value) {
            addCriterion("trade_amount >", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("trade_amount >=", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountLessThan(Long value) {
            addCriterion("trade_amount <", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountLessThanOrEqualTo(Long value) {
            addCriterion("trade_amount <=", value, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountIn(List<Long> values) {
            addCriterion("trade_amount in", values, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountNotIn(List<Long> values) {
            addCriterion("trade_amount not in", values, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountBetween(Long value1, Long value2) {
            addCriterion("trade_amount between", value1, value2, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAmountNotBetween(Long value1, Long value2) {
            addCriterion("trade_amount not between", value1, value2, "tradeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeChargeAmountIsNull() {
            addCriterion("trade_charge_amount is null");
            return (Criteria) this;
        }

        public Criteria andTradeChargeAmountIsNotNull() {
            addCriterion("trade_charge_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTradeChargeAmountEqualTo(Long value) {
            addCriterion("trade_charge_amount =", value, "tradeChargeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeChargeAmountNotEqualTo(Long value) {
            addCriterion("trade_charge_amount <>", value, "tradeChargeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeChargeAmountGreaterThan(Long value) {
            addCriterion("trade_charge_amount >", value, "tradeChargeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeChargeAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("trade_charge_amount >=", value, "tradeChargeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeChargeAmountLessThan(Long value) {
            addCriterion("trade_charge_amount <", value, "tradeChargeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeChargeAmountLessThanOrEqualTo(Long value) {
            addCriterion("trade_charge_amount <=", value, "tradeChargeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeChargeAmountIn(List<Long> values) {
            addCriterion("trade_charge_amount in", values, "tradeChargeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeChargeAmountNotIn(List<Long> values) {
            addCriterion("trade_charge_amount not in", values, "tradeChargeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeChargeAmountBetween(Long value1, Long value2) {
            addCriterion("trade_charge_amount between", value1, value2, "tradeChargeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeChargeAmountNotBetween(Long value1, Long value2) {
            addCriterion("trade_charge_amount not between", value1, value2, "tradeChargeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAddChargeAmountIsNull() {
            addCriterion("trade_add_charge_amount is null");
            return (Criteria) this;
        }

        public Criteria andTradeAddChargeAmountIsNotNull() {
            addCriterion("trade_add_charge_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTradeAddChargeAmountEqualTo(Long value) {
            addCriterion("trade_add_charge_amount =", value, "tradeAddChargeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAddChargeAmountNotEqualTo(Long value) {
            addCriterion("trade_add_charge_amount <>", value, "tradeAddChargeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAddChargeAmountGreaterThan(Long value) {
            addCriterion("trade_add_charge_amount >", value, "tradeAddChargeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAddChargeAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("trade_add_charge_amount >=", value, "tradeAddChargeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAddChargeAmountLessThan(Long value) {
            addCriterion("trade_add_charge_amount <", value, "tradeAddChargeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAddChargeAmountLessThanOrEqualTo(Long value) {
            addCriterion("trade_add_charge_amount <=", value, "tradeAddChargeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAddChargeAmountIn(List<Long> values) {
            addCriterion("trade_add_charge_amount in", values, "tradeAddChargeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAddChargeAmountNotIn(List<Long> values) {
            addCriterion("trade_add_charge_amount not in", values, "tradeAddChargeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAddChargeAmountBetween(Long value1, Long value2) {
            addCriterion("trade_add_charge_amount between", value1, value2, "tradeAddChargeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAddChargeAmountNotBetween(Long value1, Long value2) {
            addCriterion("trade_add_charge_amount not between", value1, value2, "tradeAddChargeAmount");
            return (Criteria) this;
        }

        public Criteria andTradeRateIsNull() {
            addCriterion("trade_rate is null");
            return (Criteria) this;
        }

        public Criteria andTradeRateIsNotNull() {
            addCriterion("trade_rate is not null");
            return (Criteria) this;
        }

        public Criteria andTradeRateEqualTo(String value) {
            addCriterion("trade_rate =", value, "tradeRate");
            return (Criteria) this;
        }

        public Criteria andTradeRateNotEqualTo(String value) {
            addCriterion("trade_rate <>", value, "tradeRate");
            return (Criteria) this;
        }

        public Criteria andTradeRateGreaterThan(String value) {
            addCriterion("trade_rate >", value, "tradeRate");
            return (Criteria) this;
        }

        public Criteria andTradeRateGreaterThanOrEqualTo(String value) {
            addCriterion("trade_rate >=", value, "tradeRate");
            return (Criteria) this;
        }

        public Criteria andTradeRateLessThan(String value) {
            addCriterion("trade_rate <", value, "tradeRate");
            return (Criteria) this;
        }

        public Criteria andTradeRateLessThanOrEqualTo(String value) {
            addCriterion("trade_rate <=", value, "tradeRate");
            return (Criteria) this;
        }

        public Criteria andTradeRateLike(String value) {
            addCriterion("trade_rate like", value, "tradeRate");
            return (Criteria) this;
        }

        public Criteria andTradeRateNotLike(String value) {
            addCriterion("trade_rate not like", value, "tradeRate");
            return (Criteria) this;
        }

        public Criteria andTradeRateIn(List<String> values) {
            addCriterion("trade_rate in", values, "tradeRate");
            return (Criteria) this;
        }

        public Criteria andTradeRateNotIn(List<String> values) {
            addCriterion("trade_rate not in", values, "tradeRate");
            return (Criteria) this;
        }

        public Criteria andTradeRateBetween(String value1, String value2) {
            addCriterion("trade_rate between", value1, value2, "tradeRate");
            return (Criteria) this;
        }

        public Criteria andTradeRateNotBetween(String value1, String value2) {
            addCriterion("trade_rate not between", value1, value2, "tradeRate");
            return (Criteria) this;
        }

        public Criteria andTradeChargeProfitAmountIsNull() {
            addCriterion("trade_charge_profit_amount is null");
            return (Criteria) this;
        }

        public Criteria andTradeChargeProfitAmountIsNotNull() {
            addCriterion("trade_charge_profit_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTradeChargeProfitAmountEqualTo(Long value) {
            addCriterion("trade_charge_profit_amount =", value, "tradeChargeProfitAmount");
            return (Criteria) this;
        }

        public Criteria andTradeChargeProfitAmountNotEqualTo(Long value) {
            addCriterion("trade_charge_profit_amount <>", value, "tradeChargeProfitAmount");
            return (Criteria) this;
        }

        public Criteria andTradeChargeProfitAmountGreaterThan(Long value) {
            addCriterion("trade_charge_profit_amount >", value, "tradeChargeProfitAmount");
            return (Criteria) this;
        }

        public Criteria andTradeChargeProfitAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("trade_charge_profit_amount >=", value, "tradeChargeProfitAmount");
            return (Criteria) this;
        }

        public Criteria andTradeChargeProfitAmountLessThan(Long value) {
            addCriterion("trade_charge_profit_amount <", value, "tradeChargeProfitAmount");
            return (Criteria) this;
        }

        public Criteria andTradeChargeProfitAmountLessThanOrEqualTo(Long value) {
            addCriterion("trade_charge_profit_amount <=", value, "tradeChargeProfitAmount");
            return (Criteria) this;
        }

        public Criteria andTradeChargeProfitAmountIn(List<Long> values) {
            addCriterion("trade_charge_profit_amount in", values, "tradeChargeProfitAmount");
            return (Criteria) this;
        }

        public Criteria andTradeChargeProfitAmountNotIn(List<Long> values) {
            addCriterion("trade_charge_profit_amount not in", values, "tradeChargeProfitAmount");
            return (Criteria) this;
        }

        public Criteria andTradeChargeProfitAmountBetween(Long value1, Long value2) {
            addCriterion("trade_charge_profit_amount between", value1, value2, "tradeChargeProfitAmount");
            return (Criteria) this;
        }

        public Criteria andTradeChargeProfitAmountNotBetween(Long value1, Long value2) {
            addCriterion("trade_charge_profit_amount not between", value1, value2, "tradeChargeProfitAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAddChargeProfitAmountIsNull() {
            addCriterion("trade_add_charge_profit_amount is null");
            return (Criteria) this;
        }

        public Criteria andTradeAddChargeProfitAmountIsNotNull() {
            addCriterion("trade_add_charge_profit_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTradeAddChargeProfitAmountEqualTo(Long value) {
            addCriterion("trade_add_charge_profit_amount =", value, "tradeAddChargeProfitAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAddChargeProfitAmountNotEqualTo(Long value) {
            addCriterion("trade_add_charge_profit_amount <>", value, "tradeAddChargeProfitAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAddChargeProfitAmountGreaterThan(Long value) {
            addCriterion("trade_add_charge_profit_amount >", value, "tradeAddChargeProfitAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAddChargeProfitAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("trade_add_charge_profit_amount >=", value, "tradeAddChargeProfitAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAddChargeProfitAmountLessThan(Long value) {
            addCriterion("trade_add_charge_profit_amount <", value, "tradeAddChargeProfitAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAddChargeProfitAmountLessThanOrEqualTo(Long value) {
            addCriterion("trade_add_charge_profit_amount <=", value, "tradeAddChargeProfitAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAddChargeProfitAmountIn(List<Long> values) {
            addCriterion("trade_add_charge_profit_amount in", values, "tradeAddChargeProfitAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAddChargeProfitAmountNotIn(List<Long> values) {
            addCriterion("trade_add_charge_profit_amount not in", values, "tradeAddChargeProfitAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAddChargeProfitAmountBetween(Long value1, Long value2) {
            addCriterion("trade_add_charge_profit_amount between", value1, value2, "tradeAddChargeProfitAmount");
            return (Criteria) this;
        }

        public Criteria andTradeAddChargeProfitAmountNotBetween(Long value1, Long value2) {
            addCriterion("trade_add_charge_profit_amount not between", value1, value2, "tradeAddChargeProfitAmount");
            return (Criteria) this;
        }

        public Criteria andTradeProfitRateIsNull() {
            addCriterion("trade_profit_rate is null");
            return (Criteria) this;
        }

        public Criteria andTradeProfitRateIsNotNull() {
            addCriterion("trade_profit_rate is not null");
            return (Criteria) this;
        }

        public Criteria andTradeProfitRateEqualTo(String value) {
            addCriterion("trade_profit_rate =", value, "tradeProfitRate");
            return (Criteria) this;
        }

        public Criteria andTradeProfitRateNotEqualTo(String value) {
            addCriterion("trade_profit_rate <>", value, "tradeProfitRate");
            return (Criteria) this;
        }

        public Criteria andTradeProfitRateGreaterThan(String value) {
            addCriterion("trade_profit_rate >", value, "tradeProfitRate");
            return (Criteria) this;
        }

        public Criteria andTradeProfitRateGreaterThanOrEqualTo(String value) {
            addCriterion("trade_profit_rate >=", value, "tradeProfitRate");
            return (Criteria) this;
        }

        public Criteria andTradeProfitRateLessThan(String value) {
            addCriterion("trade_profit_rate <", value, "tradeProfitRate");
            return (Criteria) this;
        }

        public Criteria andTradeProfitRateLessThanOrEqualTo(String value) {
            addCriterion("trade_profit_rate <=", value, "tradeProfitRate");
            return (Criteria) this;
        }

        public Criteria andTradeProfitRateLike(String value) {
            addCriterion("trade_profit_rate like", value, "tradeProfitRate");
            return (Criteria) this;
        }

        public Criteria andTradeProfitRateNotLike(String value) {
            addCriterion("trade_profit_rate not like", value, "tradeProfitRate");
            return (Criteria) this;
        }

        public Criteria andTradeProfitRateIn(List<String> values) {
            addCriterion("trade_profit_rate in", values, "tradeProfitRate");
            return (Criteria) this;
        }

        public Criteria andTradeProfitRateNotIn(List<String> values) {
            addCriterion("trade_profit_rate not in", values, "tradeProfitRate");
            return (Criteria) this;
        }

        public Criteria andTradeProfitRateBetween(String value1, String value2) {
            addCriterion("trade_profit_rate between", value1, value2, "tradeProfitRate");
            return (Criteria) this;
        }

        public Criteria andTradeProfitRateNotBetween(String value1, String value2) {
            addCriterion("trade_profit_rate not between", value1, value2, "tradeProfitRate");
            return (Criteria) this;
        }

        public Criteria andOtherProfitAmountIsNull() {
            addCriterion("other_profit_amount is null");
            return (Criteria) this;
        }

        public Criteria andOtherProfitAmountIsNotNull() {
            addCriterion("other_profit_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOtherProfitAmountEqualTo(Long value) {
            addCriterion("other_profit_amount =", value, "otherProfitAmount");
            return (Criteria) this;
        }

        public Criteria andOtherProfitAmountNotEqualTo(Long value) {
            addCriterion("other_profit_amount <>", value, "otherProfitAmount");
            return (Criteria) this;
        }

        public Criteria andOtherProfitAmountGreaterThan(Long value) {
            addCriterion("other_profit_amount >", value, "otherProfitAmount");
            return (Criteria) this;
        }

        public Criteria andOtherProfitAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("other_profit_amount >=", value, "otherProfitAmount");
            return (Criteria) this;
        }

        public Criteria andOtherProfitAmountLessThan(Long value) {
            addCriterion("other_profit_amount <", value, "otherProfitAmount");
            return (Criteria) this;
        }

        public Criteria andOtherProfitAmountLessThanOrEqualTo(Long value) {
            addCriterion("other_profit_amount <=", value, "otherProfitAmount");
            return (Criteria) this;
        }

        public Criteria andOtherProfitAmountIn(List<Long> values) {
            addCriterion("other_profit_amount in", values, "otherProfitAmount");
            return (Criteria) this;
        }

        public Criteria andOtherProfitAmountNotIn(List<Long> values) {
            addCriterion("other_profit_amount not in", values, "otherProfitAmount");
            return (Criteria) this;
        }

        public Criteria andOtherProfitAmountBetween(Long value1, Long value2) {
            addCriterion("other_profit_amount between", value1, value2, "otherProfitAmount");
            return (Criteria) this;
        }

        public Criteria andOtherProfitAmountNotBetween(Long value1, Long value2) {
            addCriterion("other_profit_amount not between", value1, value2, "otherProfitAmount");
            return (Criteria) this;
        }

        public Criteria andTotalProfitAmountIsNull() {
            addCriterion("total_profit_amount is null");
            return (Criteria) this;
        }

        public Criteria andTotalProfitAmountIsNotNull() {
            addCriterion("total_profit_amount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalProfitAmountEqualTo(Long value) {
            addCriterion("total_profit_amount =", value, "totalProfitAmount");
            return (Criteria) this;
        }

        public Criteria andTotalProfitAmountNotEqualTo(Long value) {
            addCriterion("total_profit_amount <>", value, "totalProfitAmount");
            return (Criteria) this;
        }

        public Criteria andTotalProfitAmountGreaterThan(Long value) {
            addCriterion("total_profit_amount >", value, "totalProfitAmount");
            return (Criteria) this;
        }

        public Criteria andTotalProfitAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("total_profit_amount >=", value, "totalProfitAmount");
            return (Criteria) this;
        }

        public Criteria andTotalProfitAmountLessThan(Long value) {
            addCriterion("total_profit_amount <", value, "totalProfitAmount");
            return (Criteria) this;
        }

        public Criteria andTotalProfitAmountLessThanOrEqualTo(Long value) {
            addCriterion("total_profit_amount <=", value, "totalProfitAmount");
            return (Criteria) this;
        }

        public Criteria andTotalProfitAmountIn(List<Long> values) {
            addCriterion("total_profit_amount in", values, "totalProfitAmount");
            return (Criteria) this;
        }

        public Criteria andTotalProfitAmountNotIn(List<Long> values) {
            addCriterion("total_profit_amount not in", values, "totalProfitAmount");
            return (Criteria) this;
        }

        public Criteria andTotalProfitAmountBetween(Long value1, Long value2) {
            addCriterion("total_profit_amount between", value1, value2, "totalProfitAmount");
            return (Criteria) this;
        }

        public Criteria andTotalProfitAmountNotBetween(Long value1, Long value2) {
            addCriterion("total_profit_amount not between", value1, value2, "totalProfitAmount");
            return (Criteria) this;
        }

        public Criteria andProfitDateIsNull() {
            addCriterion("profit_date is null");
            return (Criteria) this;
        }

        public Criteria andProfitDateIsNotNull() {
            addCriterion("profit_date is not null");
            return (Criteria) this;
        }

        public Criteria andProfitDateEqualTo(String value) {
            addCriterion("profit_date =", value, "profitDate");
            return (Criteria) this;
        }

        public Criteria andProfitDateNotEqualTo(String value) {
            addCriterion("profit_date <>", value, "profitDate");
            return (Criteria) this;
        }

        public Criteria andProfitDateGreaterThan(String value) {
            addCriterion("profit_date >", value, "profitDate");
            return (Criteria) this;
        }

        public Criteria andProfitDateGreaterThanOrEqualTo(String value) {
            addCriterion("profit_date >=", value, "profitDate");
            return (Criteria) this;
        }

        public Criteria andProfitDateLessThan(String value) {
            addCriterion("profit_date <", value, "profitDate");
            return (Criteria) this;
        }

        public Criteria andProfitDateLessThanOrEqualTo(String value) {
            addCriterion("profit_date <=", value, "profitDate");
            return (Criteria) this;
        }

        public Criteria andProfitDateLike(String value) {
            addCriterion("profit_date like", value, "profitDate");
            return (Criteria) this;
        }

        public Criteria andProfitDateNotLike(String value) {
            addCriterion("profit_date not like", value, "profitDate");
            return (Criteria) this;
        }

        public Criteria andProfitDateIn(List<String> values) {
            addCriterion("profit_date in", values, "profitDate");
            return (Criteria) this;
        }

        public Criteria andProfitDateNotIn(List<String> values) {
            addCriterion("profit_date not in", values, "profitDate");
            return (Criteria) this;
        }

        public Criteria andProfitDateBetween(String value1, String value2) {
            addCriterion("profit_date between", value1, value2, "profitDate");
            return (Criteria) this;
        }

        public Criteria andProfitDateNotBetween(String value1, String value2) {
            addCriterion("profit_date not between", value1, value2, "profitDate");
            return (Criteria) this;
        }

        public Criteria andTradeMchtIdIsNull() {
            addCriterion("trade_mcht_id is null");
            return (Criteria) this;
        }

        public Criteria andTradeMchtIdIsNotNull() {
            addCriterion("trade_mcht_id is not null");
            return (Criteria) this;
        }

        public Criteria andTradeMchtIdEqualTo(Long value) {
            addCriterion("trade_mcht_id =", value, "tradeMchtId");
            return (Criteria) this;
        }

        public Criteria andTradeMchtIdNotEqualTo(Long value) {
            addCriterion("trade_mcht_id <>", value, "tradeMchtId");
            return (Criteria) this;
        }

        public Criteria andTradeMchtIdGreaterThan(Long value) {
            addCriterion("trade_mcht_id >", value, "tradeMchtId");
            return (Criteria) this;
        }

        public Criteria andTradeMchtIdGreaterThanOrEqualTo(Long value) {
            addCriterion("trade_mcht_id >=", value, "tradeMchtId");
            return (Criteria) this;
        }

        public Criteria andTradeMchtIdLessThan(Long value) {
            addCriterion("trade_mcht_id <", value, "tradeMchtId");
            return (Criteria) this;
        }

        public Criteria andTradeMchtIdLessThanOrEqualTo(Long value) {
            addCriterion("trade_mcht_id <=", value, "tradeMchtId");
            return (Criteria) this;
        }

        public Criteria andTradeMchtIdIn(List<Long> values) {
            addCriterion("trade_mcht_id in", values, "tradeMchtId");
            return (Criteria) this;
        }

        public Criteria andTradeMchtIdNotIn(List<Long> values) {
            addCriterion("trade_mcht_id not in", values, "tradeMchtId");
            return (Criteria) this;
        }

        public Criteria andTradeMchtIdBetween(Long value1, Long value2) {
            addCriterion("trade_mcht_id between", value1, value2, "tradeMchtId");
            return (Criteria) this;
        }

        public Criteria andTradeMchtIdNotBetween(Long value1, Long value2) {
            addCriterion("trade_mcht_id not between", value1, value2, "tradeMchtId");
            return (Criteria) this;
        }

        public Criteria andTradeFinishTimeIsNull() {
            addCriterion("trade_finish_time is null");
            return (Criteria) this;
        }

        public Criteria andTradeFinishTimeIsNotNull() {
            addCriterion("trade_finish_time is not null");
            return (Criteria) this;
        }

        public Criteria andTradeFinishTimeEqualTo(String value) {
            addCriterion("trade_finish_time =", value, "tradeFinishTime");
            return (Criteria) this;
        }

        public Criteria andTradeFinishTimeNotEqualTo(String value) {
            addCriterion("trade_finish_time <>", value, "tradeFinishTime");
            return (Criteria) this;
        }

        public Criteria andTradeFinishTimeGreaterThan(String value) {
            addCriterion("trade_finish_time >", value, "tradeFinishTime");
            return (Criteria) this;
        }

        public Criteria andTradeFinishTimeGreaterThanOrEqualTo(String value) {
            addCriterion("trade_finish_time >=", value, "tradeFinishTime");
            return (Criteria) this;
        }

        public Criteria andTradeFinishTimeLessThan(String value) {
            addCriterion("trade_finish_time <", value, "tradeFinishTime");
            return (Criteria) this;
        }

        public Criteria andTradeFinishTimeLessThanOrEqualTo(String value) {
            addCriterion("trade_finish_time <=", value, "tradeFinishTime");
            return (Criteria) this;
        }

        public Criteria andTradeFinishTimeLike(String value) {
            addCriterion("trade_finish_time like", value, "tradeFinishTime");
            return (Criteria) this;
        }

        public Criteria andTradeFinishTimeNotLike(String value) {
            addCriterion("trade_finish_time not like", value, "tradeFinishTime");
            return (Criteria) this;
        }

        public Criteria andTradeFinishTimeIn(List<String> values) {
            addCriterion("trade_finish_time in", values, "tradeFinishTime");
            return (Criteria) this;
        }

        public Criteria andTradeFinishTimeNotIn(List<String> values) {
            addCriterion("trade_finish_time not in", values, "tradeFinishTime");
            return (Criteria) this;
        }

        public Criteria andTradeFinishTimeBetween(String value1, String value2) {
            addCriterion("trade_finish_time between", value1, value2, "tradeFinishTime");
            return (Criteria) this;
        }

        public Criteria andTradeFinishTimeNotBetween(String value1, String value2) {
            addCriterion("trade_finish_time not between", value1, value2, "tradeFinishTime");
            return (Criteria) this;
        }

        public Criteria andSourceIsNull() {
            addCriterion("`source` is null");
            return (Criteria) this;
        }

        public Criteria andSourceIsNotNull() {
            addCriterion("`source` is not null");
            return (Criteria) this;
        }

        public Criteria andSourceEqualTo(String value) {
            addCriterion("`source` =", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotEqualTo(String value) {
            addCriterion("`source` <>", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThan(String value) {
            addCriterion("`source` >", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceGreaterThanOrEqualTo(String value) {
            addCriterion("`source` >=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThan(String value) {
            addCriterion("`source` <", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLessThanOrEqualTo(String value) {
            addCriterion("`source` <=", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceLike(String value) {
            addCriterion("`source` like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotLike(String value) {
            addCriterion("`source` not like", value, "source");
            return (Criteria) this;
        }

        public Criteria andSourceIn(List<String> values) {
            addCriterion("`source` in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotIn(List<String> values) {
            addCriterion("`source` not in", values, "source");
            return (Criteria) this;
        }

        public Criteria andSourceBetween(String value1, String value2) {
            addCriterion("`source` between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andSourceNotBetween(String value1, String value2) {
            addCriterion("`source` not between", value1, value2, "source");
            return (Criteria) this;
        }

        public Criteria andTradeMchtNameIsNull() {
            addCriterion("trade_mcht_name is null");
            return (Criteria) this;
        }

        public Criteria andTradeMchtNameIsNotNull() {
            addCriterion("trade_mcht_name is not null");
            return (Criteria) this;
        }

        public Criteria andTradeMchtNameEqualTo(String value) {
            addCriterion("trade_mcht_name =", value, "tradeMchtName");
            return (Criteria) this;
        }

        public Criteria andTradeMchtNameNotEqualTo(String value) {
            addCriterion("trade_mcht_name <>", value, "tradeMchtName");
            return (Criteria) this;
        }

        public Criteria andTradeMchtNameGreaterThan(String value) {
            addCriterion("trade_mcht_name >", value, "tradeMchtName");
            return (Criteria) this;
        }

        public Criteria andTradeMchtNameGreaterThanOrEqualTo(String value) {
            addCriterion("trade_mcht_name >=", value, "tradeMchtName");
            return (Criteria) this;
        }

        public Criteria andTradeMchtNameLessThan(String value) {
            addCriterion("trade_mcht_name <", value, "tradeMchtName");
            return (Criteria) this;
        }

        public Criteria andTradeMchtNameLessThanOrEqualTo(String value) {
            addCriterion("trade_mcht_name <=", value, "tradeMchtName");
            return (Criteria) this;
        }

        public Criteria andTradeMchtNameLike(String value) {
            addCriterion("trade_mcht_name like", value, "tradeMchtName");
            return (Criteria) this;
        }

        public Criteria andTradeMchtNameNotLike(String value) {
            addCriterion("trade_mcht_name not like", value, "tradeMchtName");
            return (Criteria) this;
        }

        public Criteria andTradeMchtNameIn(List<String> values) {
            addCriterion("trade_mcht_name in", values, "tradeMchtName");
            return (Criteria) this;
        }

        public Criteria andTradeMchtNameNotIn(List<String> values) {
            addCriterion("trade_mcht_name not in", values, "tradeMchtName");
            return (Criteria) this;
        }

        public Criteria andTradeMchtNameBetween(String value1, String value2) {
            addCriterion("trade_mcht_name between", value1, value2, "tradeMchtName");
            return (Criteria) this;
        }

        public Criteria andTradeMchtNameNotBetween(String value1, String value2) {
            addCriterion("trade_mcht_name not between", value1, value2, "tradeMchtName");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNull() {
            addCriterion("check_status is null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIsNotNull() {
            addCriterion("check_status is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStatusEqualTo(String value) {
            addCriterion("check_status =", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotEqualTo(String value) {
            addCriterion("check_status <>", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThan(String value) {
            addCriterion("check_status >", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusGreaterThanOrEqualTo(String value) {
            addCriterion("check_status >=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThan(String value) {
            addCriterion("check_status <", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLessThanOrEqualTo(String value) {
            addCriterion("check_status <=", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLike(String value) {
            addCriterion("check_status like", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotLike(String value) {
            addCriterion("check_status not like", value, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusIn(List<String> values) {
            addCriterion("check_status in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotIn(List<String> values) {
            addCriterion("check_status not in", values, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusBetween(String value1, String value2) {
            addCriterion("check_status between", value1, value2, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckStatusNotBetween(String value1, String value2) {
            addCriterion("check_status not between", value1, value2, "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckNameIsNull() {
            addCriterion("check_name is null");
            return (Criteria) this;
        }

        public Criteria andCheckNameIsNotNull() {
            addCriterion("check_name is not null");
            return (Criteria) this;
        }

        public Criteria andCheckNameEqualTo(String value) {
            addCriterion("check_name =", value, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameNotEqualTo(String value) {
            addCriterion("check_name <>", value, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameGreaterThan(String value) {
            addCriterion("check_name >", value, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameGreaterThanOrEqualTo(String value) {
            addCriterion("check_name >=", value, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameLessThan(String value) {
            addCriterion("check_name <", value, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameLessThanOrEqualTo(String value) {
            addCriterion("check_name <=", value, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameLike(String value) {
            addCriterion("check_name like", value, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameNotLike(String value) {
            addCriterion("check_name not like", value, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameIn(List<String> values) {
            addCriterion("check_name in", values, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameNotIn(List<String> values) {
            addCriterion("check_name not in", values, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameBetween(String value1, String value2) {
            addCriterion("check_name between", value1, value2, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckNameNotBetween(String value1, String value2) {
            addCriterion("check_name not between", value1, value2, "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckRemarkIsNull() {
            addCriterion("check_remark is null");
            return (Criteria) this;
        }

        public Criteria andCheckRemarkIsNotNull() {
            addCriterion("check_remark is not null");
            return (Criteria) this;
        }

        public Criteria andCheckRemarkEqualTo(String value) {
            addCriterion("check_remark =", value, "checkRemark");
            return (Criteria) this;
        }

        public Criteria andCheckRemarkNotEqualTo(String value) {
            addCriterion("check_remark <>", value, "checkRemark");
            return (Criteria) this;
        }

        public Criteria andCheckRemarkGreaterThan(String value) {
            addCriterion("check_remark >", value, "checkRemark");
            return (Criteria) this;
        }

        public Criteria andCheckRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("check_remark >=", value, "checkRemark");
            return (Criteria) this;
        }

        public Criteria andCheckRemarkLessThan(String value) {
            addCriterion("check_remark <", value, "checkRemark");
            return (Criteria) this;
        }

        public Criteria andCheckRemarkLessThanOrEqualTo(String value) {
            addCriterion("check_remark <=", value, "checkRemark");
            return (Criteria) this;
        }

        public Criteria andCheckRemarkLike(String value) {
            addCriterion("check_remark like", value, "checkRemark");
            return (Criteria) this;
        }

        public Criteria andCheckRemarkNotLike(String value) {
            addCriterion("check_remark not like", value, "checkRemark");
            return (Criteria) this;
        }

        public Criteria andCheckRemarkIn(List<String> values) {
            addCriterion("check_remark in", values, "checkRemark");
            return (Criteria) this;
        }

        public Criteria andCheckRemarkNotIn(List<String> values) {
            addCriterion("check_remark not in", values, "checkRemark");
            return (Criteria) this;
        }

        public Criteria andCheckRemarkBetween(String value1, String value2) {
            addCriterion("check_remark between", value1, value2, "checkRemark");
            return (Criteria) this;
        }

        public Criteria andCheckRemarkNotBetween(String value1, String value2) {
            addCriterion("check_remark not between", value1, value2, "checkRemark");
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

        public Criteria andSettleFinishTimeIsNull() {
            addCriterion("settle_finish_time is null");
            return (Criteria) this;
        }

        public Criteria andSettleFinishTimeIsNotNull() {
            addCriterion("settle_finish_time is not null");
            return (Criteria) this;
        }

        public Criteria andSettleFinishTimeEqualTo(Date value) {
            addCriterion("settle_finish_time =", value, "settleFinishTime");
            return (Criteria) this;
        }

        public Criteria andSettleFinishTimeNotEqualTo(Date value) {
            addCriterion("settle_finish_time <>", value, "settleFinishTime");
            return (Criteria) this;
        }

        public Criteria andSettleFinishTimeGreaterThan(Date value) {
            addCriterion("settle_finish_time >", value, "settleFinishTime");
            return (Criteria) this;
        }

        public Criteria andSettleFinishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("settle_finish_time >=", value, "settleFinishTime");
            return (Criteria) this;
        }

        public Criteria andSettleFinishTimeLessThan(Date value) {
            addCriterion("settle_finish_time <", value, "settleFinishTime");
            return (Criteria) this;
        }

        public Criteria andSettleFinishTimeLessThanOrEqualTo(Date value) {
            addCriterion("settle_finish_time <=", value, "settleFinishTime");
            return (Criteria) this;
        }

        public Criteria andSettleFinishTimeIn(List<Date> values) {
            addCriterion("settle_finish_time in", values, "settleFinishTime");
            return (Criteria) this;
        }

        public Criteria andSettleFinishTimeNotIn(List<Date> values) {
            addCriterion("settle_finish_time not in", values, "settleFinishTime");
            return (Criteria) this;
        }

        public Criteria andSettleFinishTimeBetween(Date value1, Date value2) {
            addCriterion("settle_finish_time between", value1, value2, "settleFinishTime");
            return (Criteria) this;
        }

        public Criteria andSettleFinishTimeNotBetween(Date value1, Date value2) {
            addCriterion("settle_finish_time not between", value1, value2, "settleFinishTime");
            return (Criteria) this;
        }

        public Criteria andSettlePatchNoIsNull() {
            addCriterion("settle_patch_no is null");
            return (Criteria) this;
        }

        public Criteria andSettlePatchNoIsNotNull() {
            addCriterion("settle_patch_no is not null");
            return (Criteria) this;
        }

        public Criteria andSettlePatchNoEqualTo(String value) {
            addCriterion("settle_patch_no =", value, "settlePatchNo");
            return (Criteria) this;
        }

        public Criteria andSettlePatchNoNotEqualTo(String value) {
            addCriterion("settle_patch_no <>", value, "settlePatchNo");
            return (Criteria) this;
        }

        public Criteria andSettlePatchNoGreaterThan(String value) {
            addCriterion("settle_patch_no >", value, "settlePatchNo");
            return (Criteria) this;
        }

        public Criteria andSettlePatchNoGreaterThanOrEqualTo(String value) {
            addCriterion("settle_patch_no >=", value, "settlePatchNo");
            return (Criteria) this;
        }

        public Criteria andSettlePatchNoLessThan(String value) {
            addCriterion("settle_patch_no <", value, "settlePatchNo");
            return (Criteria) this;
        }

        public Criteria andSettlePatchNoLessThanOrEqualTo(String value) {
            addCriterion("settle_patch_no <=", value, "settlePatchNo");
            return (Criteria) this;
        }

        public Criteria andSettlePatchNoLike(String value) {
            addCriterion("settle_patch_no like", value, "settlePatchNo");
            return (Criteria) this;
        }

        public Criteria andSettlePatchNoNotLike(String value) {
            addCriterion("settle_patch_no not like", value, "settlePatchNo");
            return (Criteria) this;
        }

        public Criteria andSettlePatchNoIn(List<String> values) {
            addCriterion("settle_patch_no in", values, "settlePatchNo");
            return (Criteria) this;
        }

        public Criteria andSettlePatchNoNotIn(List<String> values) {
            addCriterion("settle_patch_no not in", values, "settlePatchNo");
            return (Criteria) this;
        }

        public Criteria andSettlePatchNoBetween(String value1, String value2) {
            addCriterion("settle_patch_no between", value1, value2, "settlePatchNo");
            return (Criteria) this;
        }

        public Criteria andSettlePatchNoNotBetween(String value1, String value2) {
            addCriterion("settle_patch_no not between", value1, value2, "settlePatchNo");
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

        public Criteria andProfitAccountTypeIsNull() {
            addCriterion("profit_account_type is null");
            return (Criteria) this;
        }

        public Criteria andProfitAccountTypeIsNotNull() {
            addCriterion("profit_account_type is not null");
            return (Criteria) this;
        }

        public Criteria andProfitAccountTypeEqualTo(String value) {
            addCriterion("profit_account_type =", value, "profitAccountType");
            return (Criteria) this;
        }

        public Criteria andProfitAccountTypeNotEqualTo(String value) {
            addCriterion("profit_account_type <>", value, "profitAccountType");
            return (Criteria) this;
        }

        public Criteria andProfitAccountTypeGreaterThan(String value) {
            addCriterion("profit_account_type >", value, "profitAccountType");
            return (Criteria) this;
        }

        public Criteria andProfitAccountTypeGreaterThanOrEqualTo(String value) {
            addCriterion("profit_account_type >=", value, "profitAccountType");
            return (Criteria) this;
        }

        public Criteria andProfitAccountTypeLessThan(String value) {
            addCriterion("profit_account_type <", value, "profitAccountType");
            return (Criteria) this;
        }

        public Criteria andProfitAccountTypeLessThanOrEqualTo(String value) {
            addCriterion("profit_account_type <=", value, "profitAccountType");
            return (Criteria) this;
        }

        public Criteria andProfitAccountTypeLike(String value) {
            addCriterion("profit_account_type like", value, "profitAccountType");
            return (Criteria) this;
        }

        public Criteria andProfitAccountTypeNotLike(String value) {
            addCriterion("profit_account_type not like", value, "profitAccountType");
            return (Criteria) this;
        }

        public Criteria andProfitAccountTypeIn(List<String> values) {
            addCriterion("profit_account_type in", values, "profitAccountType");
            return (Criteria) this;
        }

        public Criteria andProfitAccountTypeNotIn(List<String> values) {
            addCriterion("profit_account_type not in", values, "profitAccountType");
            return (Criteria) this;
        }

        public Criteria andProfitAccountTypeBetween(String value1, String value2) {
            addCriterion("profit_account_type between", value1, value2, "profitAccountType");
            return (Criteria) this;
        }

        public Criteria andProfitAccountTypeNotBetween(String value1, String value2) {
            addCriterion("profit_account_type not between", value1, value2, "profitAccountType");
            return (Criteria) this;
        }

        public Criteria andProfitOrgLikeInsensitive(String value) {
            addCriterion("upper(profit_org) like", value.toUpperCase(), "profitOrg");
            return (Criteria) this;
        }

        public Criteria andProfitOrgTypeLikeInsensitive(String value) {
            addCriterion("upper(profit_org_type) like", value.toUpperCase(), "profitOrgType");
            return (Criteria) this;
        }

        public Criteria andProfitOrgNameLikeInsensitive(String value) {
            addCriterion("upper(profit_org_name) like", value.toUpperCase(), "profitOrgName");
            return (Criteria) this;
        }

        public Criteria andVirtualNoLikeInsensitive(String value) {
            addCriterion("upper(virtual_no) like", value.toUpperCase(), "virtualNo");
            return (Criteria) this;
        }

        public Criteria andProfitTypeLikeInsensitive(String value) {
            addCriterion("upper(profit_type) like", value.toUpperCase(), "profitType");
            return (Criteria) this;
        }

        public Criteria andProfitRemarkLikeInsensitive(String value) {
            addCriterion("upper(profit_remark) like", value.toUpperCase(), "profitRemark");
            return (Criteria) this;
        }

        public Criteria andProfitOrgLevelLikeInsensitive(String value) {
            addCriterion("upper(profit_org_level) like", value.toUpperCase(), "profitOrgLevel");
            return (Criteria) this;
        }

        public Criteria andSerialLikeInsensitive(String value) {
            addCriterion("upper(serial) like", value.toUpperCase(), "serial");
            return (Criteria) this;
        }

        public Criteria andProductLikeInsensitive(String value) {
            addCriterion("upper(product) like", value.toUpperCase(), "product");
            return (Criteria) this;
        }

        public Criteria andCardTypeLikeInsensitive(String value) {
            addCriterion("upper(card_type) like", value.toUpperCase(), "cardType");
            return (Criteria) this;
        }

        public Criteria andApplyIdLikeInsensitive(String value) {
            addCriterion("upper(apply_id) like", value.toUpperCase(), "applyId");
            return (Criteria) this;
        }

        public Criteria andPlatSerialLikeInsensitive(String value) {
            addCriterion("upper(plat_serial) like", value.toUpperCase(), "platSerial");
            return (Criteria) this;
        }

        public Criteria andTradeRateLikeInsensitive(String value) {
            addCriterion("upper(trade_rate) like", value.toUpperCase(), "tradeRate");
            return (Criteria) this;
        }

        public Criteria andTradeProfitRateLikeInsensitive(String value) {
            addCriterion("upper(trade_profit_rate) like", value.toUpperCase(), "tradeProfitRate");
            return (Criteria) this;
        }

        public Criteria andProfitDateLikeInsensitive(String value) {
            addCriterion("upper(profit_date) like", value.toUpperCase(), "profitDate");
            return (Criteria) this;
        }

        public Criteria andTradeFinishTimeLikeInsensitive(String value) {
            addCriterion("upper(trade_finish_time) like", value.toUpperCase(), "tradeFinishTime");
            return (Criteria) this;
        }

        public Criteria andSourceLikeInsensitive(String value) {
            addCriterion("upper(`source`) like", value.toUpperCase(), "source");
            return (Criteria) this;
        }

        public Criteria andTradeMchtNameLikeInsensitive(String value) {
            addCriterion("upper(trade_mcht_name) like", value.toUpperCase(), "tradeMchtName");
            return (Criteria) this;
        }

        public Criteria andCheckStatusLikeInsensitive(String value) {
            addCriterion("upper(check_status) like", value.toUpperCase(), "checkStatus");
            return (Criteria) this;
        }

        public Criteria andCheckNameLikeInsensitive(String value) {
            addCriterion("upper(check_name) like", value.toUpperCase(), "checkName");
            return (Criteria) this;
        }

        public Criteria andCheckRemarkLikeInsensitive(String value) {
            addCriterion("upper(check_remark) like", value.toUpperCase(), "checkRemark");
            return (Criteria) this;
        }

        public Criteria andSettleStatusLikeInsensitive(String value) {
            addCriterion("upper(settle_status) like", value.toUpperCase(), "settleStatus");
            return (Criteria) this;
        }

        public Criteria andSettlePatchNoLikeInsensitive(String value) {
            addCriterion("upper(settle_patch_no) like", value.toUpperCase(), "settlePatchNo");
            return (Criteria) this;
        }

        public Criteria andProfitAccountTypeLikeInsensitive(String value) {
            addCriterion("upper(profit_account_type) like", value.toUpperCase(), "profitAccountType");
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