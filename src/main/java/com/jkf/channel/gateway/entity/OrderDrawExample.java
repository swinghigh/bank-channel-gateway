package com.jkf.channel.gateway.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDrawExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderDrawExample() {
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

        public Criteria andDrawAmountIsNull() {
            addCriterion("draw_amount is null");
            return (Criteria) this;
        }

        public Criteria andDrawAmountIsNotNull() {
            addCriterion("draw_amount is not null");
            return (Criteria) this;
        }

        public Criteria andDrawAmountEqualTo(Long value) {
            addCriterion("draw_amount =", value, "drawAmount");
            return (Criteria) this;
        }

        public Criteria andDrawAmountNotEqualTo(Long value) {
            addCriterion("draw_amount <>", value, "drawAmount");
            return (Criteria) this;
        }

        public Criteria andDrawAmountGreaterThan(Long value) {
            addCriterion("draw_amount >", value, "drawAmount");
            return (Criteria) this;
        }

        public Criteria andDrawAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("draw_amount >=", value, "drawAmount");
            return (Criteria) this;
        }

        public Criteria andDrawAmountLessThan(Long value) {
            addCriterion("draw_amount <", value, "drawAmount");
            return (Criteria) this;
        }

        public Criteria andDrawAmountLessThanOrEqualTo(Long value) {
            addCriterion("draw_amount <=", value, "drawAmount");
            return (Criteria) this;
        }

        public Criteria andDrawAmountIn(List<Long> values) {
            addCriterion("draw_amount in", values, "drawAmount");
            return (Criteria) this;
        }

        public Criteria andDrawAmountNotIn(List<Long> values) {
            addCriterion("draw_amount not in", values, "drawAmount");
            return (Criteria) this;
        }

        public Criteria andDrawAmountBetween(Long value1, Long value2) {
            addCriterion("draw_amount between", value1, value2, "drawAmount");
            return (Criteria) this;
        }

        public Criteria andDrawAmountNotBetween(Long value1, Long value2) {
            addCriterion("draw_amount not between", value1, value2, "drawAmount");
            return (Criteria) this;
        }

        public Criteria andDrawChargeAmountIsNull() {
            addCriterion("draw_charge_amount is null");
            return (Criteria) this;
        }

        public Criteria andDrawChargeAmountIsNotNull() {
            addCriterion("draw_charge_amount is not null");
            return (Criteria) this;
        }

        public Criteria andDrawChargeAmountEqualTo(Long value) {
            addCriterion("draw_charge_amount =", value, "drawChargeAmount");
            return (Criteria) this;
        }

        public Criteria andDrawChargeAmountNotEqualTo(Long value) {
            addCriterion("draw_charge_amount <>", value, "drawChargeAmount");
            return (Criteria) this;
        }

        public Criteria andDrawChargeAmountGreaterThan(Long value) {
            addCriterion("draw_charge_amount >", value, "drawChargeAmount");
            return (Criteria) this;
        }

        public Criteria andDrawChargeAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("draw_charge_amount >=", value, "drawChargeAmount");
            return (Criteria) this;
        }

        public Criteria andDrawChargeAmountLessThan(Long value) {
            addCriterion("draw_charge_amount <", value, "drawChargeAmount");
            return (Criteria) this;
        }

        public Criteria andDrawChargeAmountLessThanOrEqualTo(Long value) {
            addCriterion("draw_charge_amount <=", value, "drawChargeAmount");
            return (Criteria) this;
        }

        public Criteria andDrawChargeAmountIn(List<Long> values) {
            addCriterion("draw_charge_amount in", values, "drawChargeAmount");
            return (Criteria) this;
        }

        public Criteria andDrawChargeAmountNotIn(List<Long> values) {
            addCriterion("draw_charge_amount not in", values, "drawChargeAmount");
            return (Criteria) this;
        }

        public Criteria andDrawChargeAmountBetween(Long value1, Long value2) {
            addCriterion("draw_charge_amount between", value1, value2, "drawChargeAmount");
            return (Criteria) this;
        }

        public Criteria andDrawChargeAmountNotBetween(Long value1, Long value2) {
            addCriterion("draw_charge_amount not between", value1, value2, "drawChargeAmount");
            return (Criteria) this;
        }

        public Criteria andVirtualAmountPreIsNull() {
            addCriterion("virtual_amount_pre is null");
            return (Criteria) this;
        }

        public Criteria andVirtualAmountPreIsNotNull() {
            addCriterion("virtual_amount_pre is not null");
            return (Criteria) this;
        }

        public Criteria andVirtualAmountPreEqualTo(Long value) {
            addCriterion("virtual_amount_pre =", value, "virtualAmountPre");
            return (Criteria) this;
        }

        public Criteria andVirtualAmountPreNotEqualTo(Long value) {
            addCriterion("virtual_amount_pre <>", value, "virtualAmountPre");
            return (Criteria) this;
        }

        public Criteria andVirtualAmountPreGreaterThan(Long value) {
            addCriterion("virtual_amount_pre >", value, "virtualAmountPre");
            return (Criteria) this;
        }

        public Criteria andVirtualAmountPreGreaterThanOrEqualTo(Long value) {
            addCriterion("virtual_amount_pre >=", value, "virtualAmountPre");
            return (Criteria) this;
        }

        public Criteria andVirtualAmountPreLessThan(Long value) {
            addCriterion("virtual_amount_pre <", value, "virtualAmountPre");
            return (Criteria) this;
        }

        public Criteria andVirtualAmountPreLessThanOrEqualTo(Long value) {
            addCriterion("virtual_amount_pre <=", value, "virtualAmountPre");
            return (Criteria) this;
        }

        public Criteria andVirtualAmountPreIn(List<Long> values) {
            addCriterion("virtual_amount_pre in", values, "virtualAmountPre");
            return (Criteria) this;
        }

        public Criteria andVirtualAmountPreNotIn(List<Long> values) {
            addCriterion("virtual_amount_pre not in", values, "virtualAmountPre");
            return (Criteria) this;
        }

        public Criteria andVirtualAmountPreBetween(Long value1, Long value2) {
            addCriterion("virtual_amount_pre between", value1, value2, "virtualAmountPre");
            return (Criteria) this;
        }

        public Criteria andVirtualAmountPreNotBetween(Long value1, Long value2) {
            addCriterion("virtual_amount_pre not between", value1, value2, "virtualAmountPre");
            return (Criteria) this;
        }

        public Criteria andVirtualAmountFinishIsNull() {
            addCriterion("virtual_amount_finish is null");
            return (Criteria) this;
        }

        public Criteria andVirtualAmountFinishIsNotNull() {
            addCriterion("virtual_amount_finish is not null");
            return (Criteria) this;
        }

        public Criteria andVirtualAmountFinishEqualTo(Long value) {
            addCriterion("virtual_amount_finish =", value, "virtualAmountFinish");
            return (Criteria) this;
        }

        public Criteria andVirtualAmountFinishNotEqualTo(Long value) {
            addCriterion("virtual_amount_finish <>", value, "virtualAmountFinish");
            return (Criteria) this;
        }

        public Criteria andVirtualAmountFinishGreaterThan(Long value) {
            addCriterion("virtual_amount_finish >", value, "virtualAmountFinish");
            return (Criteria) this;
        }

        public Criteria andVirtualAmountFinishGreaterThanOrEqualTo(Long value) {
            addCriterion("virtual_amount_finish >=", value, "virtualAmountFinish");
            return (Criteria) this;
        }

        public Criteria andVirtualAmountFinishLessThan(Long value) {
            addCriterion("virtual_amount_finish <", value, "virtualAmountFinish");
            return (Criteria) this;
        }

        public Criteria andVirtualAmountFinishLessThanOrEqualTo(Long value) {
            addCriterion("virtual_amount_finish <=", value, "virtualAmountFinish");
            return (Criteria) this;
        }

        public Criteria andVirtualAmountFinishIn(List<Long> values) {
            addCriterion("virtual_amount_finish in", values, "virtualAmountFinish");
            return (Criteria) this;
        }

        public Criteria andVirtualAmountFinishNotIn(List<Long> values) {
            addCriterion("virtual_amount_finish not in", values, "virtualAmountFinish");
            return (Criteria) this;
        }

        public Criteria andVirtualAmountFinishBetween(Long value1, Long value2) {
            addCriterion("virtual_amount_finish between", value1, value2, "virtualAmountFinish");
            return (Criteria) this;
        }

        public Criteria andVirtualAmountFinishNotBetween(Long value1, Long value2) {
            addCriterion("virtual_amount_finish not between", value1, value2, "virtualAmountFinish");
            return (Criteria) this;
        }

        public Criteria andChargeTypeIsNull() {
            addCriterion("charge_type is null");
            return (Criteria) this;
        }

        public Criteria andChargeTypeIsNotNull() {
            addCriterion("charge_type is not null");
            return (Criteria) this;
        }

        public Criteria andChargeTypeEqualTo(String value) {
            addCriterion("charge_type =", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeNotEqualTo(String value) {
            addCriterion("charge_type <>", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeGreaterThan(String value) {
            addCriterion("charge_type >", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("charge_type >=", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeLessThan(String value) {
            addCriterion("charge_type <", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeLessThanOrEqualTo(String value) {
            addCriterion("charge_type <=", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeLike(String value) {
            addCriterion("charge_type like", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeNotLike(String value) {
            addCriterion("charge_type not like", value, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeIn(List<String> values) {
            addCriterion("charge_type in", values, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeNotIn(List<String> values) {
            addCriterion("charge_type not in", values, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeBetween(String value1, String value2) {
            addCriterion("charge_type between", value1, value2, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeTypeNotBetween(String value1, String value2) {
            addCriterion("charge_type not between", value1, value2, "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeCostRateIsNull() {
            addCriterion("`charge cost rate` is null");
            return (Criteria) this;
        }

        public Criteria andChargeCostRateIsNotNull() {
            addCriterion("`charge cost rate` is not null");
            return (Criteria) this;
        }

        public Criteria andChargeCostRateEqualTo(String value) {
            addCriterion("`charge cost rate` =", value, "chargeCostRate");
            return (Criteria) this;
        }

        public Criteria andChargeCostRateNotEqualTo(String value) {
            addCriterion("`charge cost rate` <>", value, "chargeCostRate");
            return (Criteria) this;
        }

        public Criteria andChargeCostRateGreaterThan(String value) {
            addCriterion("`charge cost rate` >", value, "chargeCostRate");
            return (Criteria) this;
        }

        public Criteria andChargeCostRateGreaterThanOrEqualTo(String value) {
            addCriterion("`charge cost rate` >=", value, "chargeCostRate");
            return (Criteria) this;
        }

        public Criteria andChargeCostRateLessThan(String value) {
            addCriterion("`charge cost rate` <", value, "chargeCostRate");
            return (Criteria) this;
        }

        public Criteria andChargeCostRateLessThanOrEqualTo(String value) {
            addCriterion("`charge cost rate` <=", value, "chargeCostRate");
            return (Criteria) this;
        }

        public Criteria andChargeCostRateLike(String value) {
            addCriterion("`charge cost rate` like", value, "chargeCostRate");
            return (Criteria) this;
        }

        public Criteria andChargeCostRateNotLike(String value) {
            addCriterion("`charge cost rate` not like", value, "chargeCostRate");
            return (Criteria) this;
        }

        public Criteria andChargeCostRateIn(List<String> values) {
            addCriterion("`charge cost rate` in", values, "chargeCostRate");
            return (Criteria) this;
        }

        public Criteria andChargeCostRateNotIn(List<String> values) {
            addCriterion("`charge cost rate` not in", values, "chargeCostRate");
            return (Criteria) this;
        }

        public Criteria andChargeCostRateBetween(String value1, String value2) {
            addCriterion("`charge cost rate` between", value1, value2, "chargeCostRate");
            return (Criteria) this;
        }

        public Criteria andChargeCostRateNotBetween(String value1, String value2) {
            addCriterion("`charge cost rate` not between", value1, value2, "chargeCostRate");
            return (Criteria) this;
        }

        public Criteria andChargeCostAmountIsNull() {
            addCriterion("charge_cost_amount is null");
            return (Criteria) this;
        }

        public Criteria andChargeCostAmountIsNotNull() {
            addCriterion("charge_cost_amount is not null");
            return (Criteria) this;
        }

        public Criteria andChargeCostAmountEqualTo(Long value) {
            addCriterion("charge_cost_amount =", value, "chargeCostAmount");
            return (Criteria) this;
        }

        public Criteria andChargeCostAmountNotEqualTo(Long value) {
            addCriterion("charge_cost_amount <>", value, "chargeCostAmount");
            return (Criteria) this;
        }

        public Criteria andChargeCostAmountGreaterThan(Long value) {
            addCriterion("charge_cost_amount >", value, "chargeCostAmount");
            return (Criteria) this;
        }

        public Criteria andChargeCostAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("charge_cost_amount >=", value, "chargeCostAmount");
            return (Criteria) this;
        }

        public Criteria andChargeCostAmountLessThan(Long value) {
            addCriterion("charge_cost_amount <", value, "chargeCostAmount");
            return (Criteria) this;
        }

        public Criteria andChargeCostAmountLessThanOrEqualTo(Long value) {
            addCriterion("charge_cost_amount <=", value, "chargeCostAmount");
            return (Criteria) this;
        }

        public Criteria andChargeCostAmountIn(List<Long> values) {
            addCriterion("charge_cost_amount in", values, "chargeCostAmount");
            return (Criteria) this;
        }

        public Criteria andChargeCostAmountNotIn(List<Long> values) {
            addCriterion("charge_cost_amount not in", values, "chargeCostAmount");
            return (Criteria) this;
        }

        public Criteria andChargeCostAmountBetween(Long value1, Long value2) {
            addCriterion("charge_cost_amount between", value1, value2, "chargeCostAmount");
            return (Criteria) this;
        }

        public Criteria andChargeCostAmountNotBetween(Long value1, Long value2) {
            addCriterion("charge_cost_amount not between", value1, value2, "chargeCostAmount");
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

        public Criteria andVirtualCustomerIsNull() {
            addCriterion("virtual_customer is null");
            return (Criteria) this;
        }

        public Criteria andVirtualCustomerIsNotNull() {
            addCriterion("virtual_customer is not null");
            return (Criteria) this;
        }

        public Criteria andVirtualCustomerEqualTo(String value) {
            addCriterion("virtual_customer =", value, "virtualCustomer");
            return (Criteria) this;
        }

        public Criteria andVirtualCustomerNotEqualTo(String value) {
            addCriterion("virtual_customer <>", value, "virtualCustomer");
            return (Criteria) this;
        }

        public Criteria andVirtualCustomerGreaterThan(String value) {
            addCriterion("virtual_customer >", value, "virtualCustomer");
            return (Criteria) this;
        }

        public Criteria andVirtualCustomerGreaterThanOrEqualTo(String value) {
            addCriterion("virtual_customer >=", value, "virtualCustomer");
            return (Criteria) this;
        }

        public Criteria andVirtualCustomerLessThan(String value) {
            addCriterion("virtual_customer <", value, "virtualCustomer");
            return (Criteria) this;
        }

        public Criteria andVirtualCustomerLessThanOrEqualTo(String value) {
            addCriterion("virtual_customer <=", value, "virtualCustomer");
            return (Criteria) this;
        }

        public Criteria andVirtualCustomerLike(String value) {
            addCriterion("virtual_customer like", value, "virtualCustomer");
            return (Criteria) this;
        }

        public Criteria andVirtualCustomerNotLike(String value) {
            addCriterion("virtual_customer not like", value, "virtualCustomer");
            return (Criteria) this;
        }

        public Criteria andVirtualCustomerIn(List<String> values) {
            addCriterion("virtual_customer in", values, "virtualCustomer");
            return (Criteria) this;
        }

        public Criteria andVirtualCustomerNotIn(List<String> values) {
            addCriterion("virtual_customer not in", values, "virtualCustomer");
            return (Criteria) this;
        }

        public Criteria andVirtualCustomerBetween(String value1, String value2) {
            addCriterion("virtual_customer between", value1, value2, "virtualCustomer");
            return (Criteria) this;
        }

        public Criteria andVirtualCustomerNotBetween(String value1, String value2) {
            addCriterion("virtual_customer not between", value1, value2, "virtualCustomer");
            return (Criteria) this;
        }

        public Criteria andChannelReasonIsNull() {
            addCriterion("channel_reason is null");
            return (Criteria) this;
        }

        public Criteria andChannelReasonIsNotNull() {
            addCriterion("channel_reason is not null");
            return (Criteria) this;
        }

        public Criteria andChannelReasonEqualTo(String value) {
            addCriterion("channel_reason =", value, "channelReason");
            return (Criteria) this;
        }

        public Criteria andChannelReasonNotEqualTo(String value) {
            addCriterion("channel_reason <>", value, "channelReason");
            return (Criteria) this;
        }

        public Criteria andChannelReasonGreaterThan(String value) {
            addCriterion("channel_reason >", value, "channelReason");
            return (Criteria) this;
        }

        public Criteria andChannelReasonGreaterThanOrEqualTo(String value) {
            addCriterion("channel_reason >=", value, "channelReason");
            return (Criteria) this;
        }

        public Criteria andChannelReasonLessThan(String value) {
            addCriterion("channel_reason <", value, "channelReason");
            return (Criteria) this;
        }

        public Criteria andChannelReasonLessThanOrEqualTo(String value) {
            addCriterion("channel_reason <=", value, "channelReason");
            return (Criteria) this;
        }

        public Criteria andChannelReasonLike(String value) {
            addCriterion("channel_reason like", value, "channelReason");
            return (Criteria) this;
        }

        public Criteria andChannelReasonNotLike(String value) {
            addCriterion("channel_reason not like", value, "channelReason");
            return (Criteria) this;
        }

        public Criteria andChannelReasonIn(List<String> values) {
            addCriterion("channel_reason in", values, "channelReason");
            return (Criteria) this;
        }

        public Criteria andChannelReasonNotIn(List<String> values) {
            addCriterion("channel_reason not in", values, "channelReason");
            return (Criteria) this;
        }

        public Criteria andChannelReasonBetween(String value1, String value2) {
            addCriterion("channel_reason between", value1, value2, "channelReason");
            return (Criteria) this;
        }

        public Criteria andChannelReasonNotBetween(String value1, String value2) {
            addCriterion("channel_reason not between", value1, value2, "channelReason");
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

        public Criteria andChannelMchtTermNoIsNull() {
            addCriterion("channel_mcht_term_no is null");
            return (Criteria) this;
        }

        public Criteria andChannelMchtTermNoIsNotNull() {
            addCriterion("channel_mcht_term_no is not null");
            return (Criteria) this;
        }

        public Criteria andChannelMchtTermNoEqualTo(String value) {
            addCriterion("channel_mcht_term_no =", value, "channelMchtTermNo");
            return (Criteria) this;
        }

        public Criteria andChannelMchtTermNoNotEqualTo(String value) {
            addCriterion("channel_mcht_term_no <>", value, "channelMchtTermNo");
            return (Criteria) this;
        }

        public Criteria andChannelMchtTermNoGreaterThan(String value) {
            addCriterion("channel_mcht_term_no >", value, "channelMchtTermNo");
            return (Criteria) this;
        }

        public Criteria andChannelMchtTermNoGreaterThanOrEqualTo(String value) {
            addCriterion("channel_mcht_term_no >=", value, "channelMchtTermNo");
            return (Criteria) this;
        }

        public Criteria andChannelMchtTermNoLessThan(String value) {
            addCriterion("channel_mcht_term_no <", value, "channelMchtTermNo");
            return (Criteria) this;
        }

        public Criteria andChannelMchtTermNoLessThanOrEqualTo(String value) {
            addCriterion("channel_mcht_term_no <=", value, "channelMchtTermNo");
            return (Criteria) this;
        }

        public Criteria andChannelMchtTermNoLike(String value) {
            addCriterion("channel_mcht_term_no like", value, "channelMchtTermNo");
            return (Criteria) this;
        }

        public Criteria andChannelMchtTermNoNotLike(String value) {
            addCriterion("channel_mcht_term_no not like", value, "channelMchtTermNo");
            return (Criteria) this;
        }

        public Criteria andChannelMchtTermNoIn(List<String> values) {
            addCriterion("channel_mcht_term_no in", values, "channelMchtTermNo");
            return (Criteria) this;
        }

        public Criteria andChannelMchtTermNoNotIn(List<String> values) {
            addCriterion("channel_mcht_term_no not in", values, "channelMchtTermNo");
            return (Criteria) this;
        }

        public Criteria andChannelMchtTermNoBetween(String value1, String value2) {
            addCriterion("channel_mcht_term_no between", value1, value2, "channelMchtTermNo");
            return (Criteria) this;
        }

        public Criteria andChannelMchtTermNoNotBetween(String value1, String value2) {
            addCriterion("channel_mcht_term_no not between", value1, value2, "channelMchtTermNo");
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

        public Criteria andDrawTimeIsNull() {
            addCriterion("draw_time is null");
            return (Criteria) this;
        }

        public Criteria andDrawTimeIsNotNull() {
            addCriterion("draw_time is not null");
            return (Criteria) this;
        }

        public Criteria andDrawTimeEqualTo(String value) {
            addCriterion("draw_time =", value, "drawTime");
            return (Criteria) this;
        }

        public Criteria andDrawTimeNotEqualTo(String value) {
            addCriterion("draw_time <>", value, "drawTime");
            return (Criteria) this;
        }

        public Criteria andDrawTimeGreaterThan(String value) {
            addCriterion("draw_time >", value, "drawTime");
            return (Criteria) this;
        }

        public Criteria andDrawTimeGreaterThanOrEqualTo(String value) {
            addCriterion("draw_time >=", value, "drawTime");
            return (Criteria) this;
        }

        public Criteria andDrawTimeLessThan(String value) {
            addCriterion("draw_time <", value, "drawTime");
            return (Criteria) this;
        }

        public Criteria andDrawTimeLessThanOrEqualTo(String value) {
            addCriterion("draw_time <=", value, "drawTime");
            return (Criteria) this;
        }

        public Criteria andDrawTimeLike(String value) {
            addCriterion("draw_time like", value, "drawTime");
            return (Criteria) this;
        }

        public Criteria andDrawTimeNotLike(String value) {
            addCriterion("draw_time not like", value, "drawTime");
            return (Criteria) this;
        }

        public Criteria andDrawTimeIn(List<String> values) {
            addCriterion("draw_time in", values, "drawTime");
            return (Criteria) this;
        }

        public Criteria andDrawTimeNotIn(List<String> values) {
            addCriterion("draw_time not in", values, "drawTime");
            return (Criteria) this;
        }

        public Criteria andDrawTimeBetween(String value1, String value2) {
            addCriterion("draw_time between", value1, value2, "drawTime");
            return (Criteria) this;
        }

        public Criteria andDrawTimeNotBetween(String value1, String value2) {
            addCriterion("draw_time not between", value1, value2, "drawTime");
            return (Criteria) this;
        }

        public Criteria andChannelChargeIsNull() {
            addCriterion("channel_charge is null");
            return (Criteria) this;
        }

        public Criteria andChannelChargeIsNotNull() {
            addCriterion("channel_charge is not null");
            return (Criteria) this;
        }

        public Criteria andChannelChargeEqualTo(Long value) {
            addCriterion("channel_charge =", value, "channelCharge");
            return (Criteria) this;
        }

        public Criteria andChannelChargeNotEqualTo(Long value) {
            addCriterion("channel_charge <>", value, "channelCharge");
            return (Criteria) this;
        }

        public Criteria andChannelChargeGreaterThan(Long value) {
            addCriterion("channel_charge >", value, "channelCharge");
            return (Criteria) this;
        }

        public Criteria andChannelChargeGreaterThanOrEqualTo(Long value) {
            addCriterion("channel_charge >=", value, "channelCharge");
            return (Criteria) this;
        }

        public Criteria andChannelChargeLessThan(Long value) {
            addCriterion("channel_charge <", value, "channelCharge");
            return (Criteria) this;
        }

        public Criteria andChannelChargeLessThanOrEqualTo(Long value) {
            addCriterion("channel_charge <=", value, "channelCharge");
            return (Criteria) this;
        }

        public Criteria andChannelChargeIn(List<Long> values) {
            addCriterion("channel_charge in", values, "channelCharge");
            return (Criteria) this;
        }

        public Criteria andChannelChargeNotIn(List<Long> values) {
            addCriterion("channel_charge not in", values, "channelCharge");
            return (Criteria) this;
        }

        public Criteria andChannelChargeBetween(Long value1, Long value2) {
            addCriterion("channel_charge between", value1, value2, "channelCharge");
            return (Criteria) this;
        }

        public Criteria andChannelChargeNotBetween(Long value1, Long value2) {
            addCriterion("channel_charge not between", value1, value2, "channelCharge");
            return (Criteria) this;
        }

        public Criteria andChannelAddChargeIsNull() {
            addCriterion("channel_add_charge is null");
            return (Criteria) this;
        }

        public Criteria andChannelAddChargeIsNotNull() {
            addCriterion("channel_add_charge is not null");
            return (Criteria) this;
        }

        public Criteria andChannelAddChargeEqualTo(Long value) {
            addCriterion("channel_add_charge =", value, "channelAddCharge");
            return (Criteria) this;
        }

        public Criteria andChannelAddChargeNotEqualTo(Long value) {
            addCriterion("channel_add_charge <>", value, "channelAddCharge");
            return (Criteria) this;
        }

        public Criteria andChannelAddChargeGreaterThan(Long value) {
            addCriterion("channel_add_charge >", value, "channelAddCharge");
            return (Criteria) this;
        }

        public Criteria andChannelAddChargeGreaterThanOrEqualTo(Long value) {
            addCriterion("channel_add_charge >=", value, "channelAddCharge");
            return (Criteria) this;
        }

        public Criteria andChannelAddChargeLessThan(Long value) {
            addCriterion("channel_add_charge <", value, "channelAddCharge");
            return (Criteria) this;
        }

        public Criteria andChannelAddChargeLessThanOrEqualTo(Long value) {
            addCriterion("channel_add_charge <=", value, "channelAddCharge");
            return (Criteria) this;
        }

        public Criteria andChannelAddChargeIn(List<Long> values) {
            addCriterion("channel_add_charge in", values, "channelAddCharge");
            return (Criteria) this;
        }

        public Criteria andChannelAddChargeNotIn(List<Long> values) {
            addCriterion("channel_add_charge not in", values, "channelAddCharge");
            return (Criteria) this;
        }

        public Criteria andChannelAddChargeBetween(Long value1, Long value2) {
            addCriterion("channel_add_charge between", value1, value2, "channelAddCharge");
            return (Criteria) this;
        }

        public Criteria andChannelAddChargeNotBetween(Long value1, Long value2) {
            addCriterion("channel_add_charge not between", value1, value2, "channelAddCharge");
            return (Criteria) this;
        }

        public Criteria andChannelBillStatusIsNull() {
            addCriterion("channel_bill_status is null");
            return (Criteria) this;
        }

        public Criteria andChannelBillStatusIsNotNull() {
            addCriterion("channel_bill_status is not null");
            return (Criteria) this;
        }

        public Criteria andChannelBillStatusEqualTo(String value) {
            addCriterion("channel_bill_status =", value, "channelBillStatus");
            return (Criteria) this;
        }

        public Criteria andChannelBillStatusNotEqualTo(String value) {
            addCriterion("channel_bill_status <>", value, "channelBillStatus");
            return (Criteria) this;
        }

        public Criteria andChannelBillStatusGreaterThan(String value) {
            addCriterion("channel_bill_status >", value, "channelBillStatus");
            return (Criteria) this;
        }

        public Criteria andChannelBillStatusGreaterThanOrEqualTo(String value) {
            addCriterion("channel_bill_status >=", value, "channelBillStatus");
            return (Criteria) this;
        }

        public Criteria andChannelBillStatusLessThan(String value) {
            addCriterion("channel_bill_status <", value, "channelBillStatus");
            return (Criteria) this;
        }

        public Criteria andChannelBillStatusLessThanOrEqualTo(String value) {
            addCriterion("channel_bill_status <=", value, "channelBillStatus");
            return (Criteria) this;
        }

        public Criteria andChannelBillStatusLike(String value) {
            addCriterion("channel_bill_status like", value, "channelBillStatus");
            return (Criteria) this;
        }

        public Criteria andChannelBillStatusNotLike(String value) {
            addCriterion("channel_bill_status not like", value, "channelBillStatus");
            return (Criteria) this;
        }

        public Criteria andChannelBillStatusIn(List<String> values) {
            addCriterion("channel_bill_status in", values, "channelBillStatus");
            return (Criteria) this;
        }

        public Criteria andChannelBillStatusNotIn(List<String> values) {
            addCriterion("channel_bill_status not in", values, "channelBillStatus");
            return (Criteria) this;
        }

        public Criteria andChannelBillStatusBetween(String value1, String value2) {
            addCriterion("channel_bill_status between", value1, value2, "channelBillStatus");
            return (Criteria) this;
        }

        public Criteria andChannelBillStatusNotBetween(String value1, String value2) {
            addCriterion("channel_bill_status not between", value1, value2, "channelBillStatus");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNull() {
            addCriterion("bank_name is null");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNotNull() {
            addCriterion("bank_name is not null");
            return (Criteria) this;
        }

        public Criteria andBankNameEqualTo(String value) {
            addCriterion("bank_name =", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotEqualTo(String value) {
            addCriterion("bank_name <>", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThan(String value) {
            addCriterion("bank_name >", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("bank_name >=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThan(String value) {
            addCriterion("bank_name <", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThanOrEqualTo(String value) {
            addCriterion("bank_name <=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLike(String value) {
            addCriterion("bank_name like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotLike(String value) {
            addCriterion("bank_name not like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameIn(List<String> values) {
            addCriterion("bank_name in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotIn(List<String> values) {
            addCriterion("bank_name not in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameBetween(String value1, String value2) {
            addCriterion("bank_name between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotBetween(String value1, String value2) {
            addCriterion("bank_name not between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNoIsNull() {
            addCriterion("bank_account_no is null");
            return (Criteria) this;
        }

        public Criteria andBankAccountNoIsNotNull() {
            addCriterion("bank_account_no is not null");
            return (Criteria) this;
        }

        public Criteria andBankAccountNoEqualTo(String value) {
            addCriterion("bank_account_no =", value, "bankAccountNo");
            return (Criteria) this;
        }

        public Criteria andBankAccountNoNotEqualTo(String value) {
            addCriterion("bank_account_no <>", value, "bankAccountNo");
            return (Criteria) this;
        }

        public Criteria andBankAccountNoGreaterThan(String value) {
            addCriterion("bank_account_no >", value, "bankAccountNo");
            return (Criteria) this;
        }

        public Criteria andBankAccountNoGreaterThanOrEqualTo(String value) {
            addCriterion("bank_account_no >=", value, "bankAccountNo");
            return (Criteria) this;
        }

        public Criteria andBankAccountNoLessThan(String value) {
            addCriterion("bank_account_no <", value, "bankAccountNo");
            return (Criteria) this;
        }

        public Criteria andBankAccountNoLessThanOrEqualTo(String value) {
            addCriterion("bank_account_no <=", value, "bankAccountNo");
            return (Criteria) this;
        }

        public Criteria andBankAccountNoLike(String value) {
            addCriterion("bank_account_no like", value, "bankAccountNo");
            return (Criteria) this;
        }

        public Criteria andBankAccountNoNotLike(String value) {
            addCriterion("bank_account_no not like", value, "bankAccountNo");
            return (Criteria) this;
        }

        public Criteria andBankAccountNoIn(List<String> values) {
            addCriterion("bank_account_no in", values, "bankAccountNo");
            return (Criteria) this;
        }

        public Criteria andBankAccountNoNotIn(List<String> values) {
            addCriterion("bank_account_no not in", values, "bankAccountNo");
            return (Criteria) this;
        }

        public Criteria andBankAccountNoBetween(String value1, String value2) {
            addCriterion("bank_account_no between", value1, value2, "bankAccountNo");
            return (Criteria) this;
        }

        public Criteria andBankAccountNoNotBetween(String value1, String value2) {
            addCriterion("bank_account_no not between", value1, value2, "bankAccountNo");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameIsNull() {
            addCriterion("bank_account_name is null");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameIsNotNull() {
            addCriterion("bank_account_name is not null");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameEqualTo(String value) {
            addCriterion("bank_account_name =", value, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameNotEqualTo(String value) {
            addCriterion("bank_account_name <>", value, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameGreaterThan(String value) {
            addCriterion("bank_account_name >", value, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameGreaterThanOrEqualTo(String value) {
            addCriterion("bank_account_name >=", value, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameLessThan(String value) {
            addCriterion("bank_account_name <", value, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameLessThanOrEqualTo(String value) {
            addCriterion("bank_account_name <=", value, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameLike(String value) {
            addCriterion("bank_account_name like", value, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameNotLike(String value) {
            addCriterion("bank_account_name not like", value, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameIn(List<String> values) {
            addCriterion("bank_account_name in", values, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameNotIn(List<String> values) {
            addCriterion("bank_account_name not in", values, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameBetween(String value1, String value2) {
            addCriterion("bank_account_name between", value1, value2, "bankAccountName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameNotBetween(String value1, String value2) {
            addCriterion("bank_account_name not between", value1, value2, "bankAccountName");
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

        public Criteria andUpdateIdEqualTo(Integer value) {
            addCriterion("update_id =", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotEqualTo(Integer value) {
            addCriterion("update_id <>", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdGreaterThan(Integer value) {
            addCriterion("update_id >", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("update_id >=", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdLessThan(Integer value) {
            addCriterion("update_id <", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdLessThanOrEqualTo(Integer value) {
            addCriterion("update_id <=", value, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdIn(List<Integer> values) {
            addCriterion("update_id in", values, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotIn(List<Integer> values) {
            addCriterion("update_id not in", values, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdBetween(Integer value1, Integer value2) {
            addCriterion("update_id between", value1, value2, "updateId");
            return (Criteria) this;
        }

        public Criteria andUpdateIdNotBetween(Integer value1, Integer value2) {
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

        public Criteria andOutSerialLikeInsensitive(String value) {
            addCriterion("upper(out_serial) like", value.toUpperCase(), "outSerial");
            return (Criteria) this;
        }

        public Criteria andSerialLikeInsensitive(String value) {
            addCriterion("upper(serial) like", value.toUpperCase(), "serial");
            return (Criteria) this;
        }

        public Criteria andVirtualNoLikeInsensitive(String value) {
            addCriterion("upper(virtual_no) like", value.toUpperCase(), "virtualNo");
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

        public Criteria andChargeTypeLikeInsensitive(String value) {
            addCriterion("upper(charge_type) like", value.toUpperCase(), "chargeType");
            return (Criteria) this;
        }

        public Criteria andChargeCostRateLikeInsensitive(String value) {
            addCriterion("upper(`charge cost rate`) like", value.toUpperCase(), "chargeCostRate");
            return (Criteria) this;
        }

        public Criteria andStatusLikeInsensitive(String value) {
            addCriterion("upper(`status`) like", value.toUpperCase(), "status");
            return (Criteria) this;
        }

        public Criteria andRemarkLikeInsensitive(String value) {
            addCriterion("upper(remark) like", value.toUpperCase(), "remark");
            return (Criteria) this;
        }

        public Criteria andVirtualCustomerLikeInsensitive(String value) {
            addCriterion("upper(virtual_customer) like", value.toUpperCase(), "virtualCustomer");
            return (Criteria) this;
        }

        public Criteria andChannelReasonLikeInsensitive(String value) {
            addCriterion("upper(channel_reason) like", value.toUpperCase(), "channelReason");
            return (Criteria) this;
        }

        public Criteria andChannelMchtNoLikeInsensitive(String value) {
            addCriterion("upper(channel_mcht_no) like", value.toUpperCase(), "channelMchtNo");
            return (Criteria) this;
        }

        public Criteria andChannelMchtTermNoLikeInsensitive(String value) {
            addCriterion("upper(channel_mcht_term_no) like", value.toUpperCase(), "channelMchtTermNo");
            return (Criteria) this;
        }

        public Criteria andChannelOrderNoLikeInsensitive(String value) {
            addCriterion("upper(channel_order_no) like", value.toUpperCase(), "channelOrderNo");
            return (Criteria) this;
        }

        public Criteria andDrawTimeLikeInsensitive(String value) {
            addCriterion("upper(draw_time) like", value.toUpperCase(), "drawTime");
            return (Criteria) this;
        }

        public Criteria andChannelBillStatusLikeInsensitive(String value) {
            addCriterion("upper(channel_bill_status) like", value.toUpperCase(), "channelBillStatus");
            return (Criteria) this;
        }

        public Criteria andBankNameLikeInsensitive(String value) {
            addCriterion("upper(bank_name) like", value.toUpperCase(), "bankName");
            return (Criteria) this;
        }

        public Criteria andBankAccountNoLikeInsensitive(String value) {
            addCriterion("upper(bank_account_no) like", value.toUpperCase(), "bankAccountNo");
            return (Criteria) this;
        }

        public Criteria andBankAccountNameLikeInsensitive(String value) {
            addCriterion("upper(bank_account_name) like", value.toUpperCase(), "bankAccountName");
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