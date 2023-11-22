package com.jkf.channel.gateway.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MchInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MchInfoExample() {
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

        public Criteria andOutMchNoIsNull() {
            addCriterion("out_mch_no is null");
            return (Criteria) this;
        }

        public Criteria andOutMchNoIsNotNull() {
            addCriterion("out_mch_no is not null");
            return (Criteria) this;
        }

        public Criteria andOutMchNoEqualTo(String value) {
            addCriterion("out_mch_no =", value, "outMchNo");
            return (Criteria) this;
        }

        public Criteria andOutMchNoNotEqualTo(String value) {
            addCriterion("out_mch_no <>", value, "outMchNo");
            return (Criteria) this;
        }

        public Criteria andOutMchNoGreaterThan(String value) {
            addCriterion("out_mch_no >", value, "outMchNo");
            return (Criteria) this;
        }

        public Criteria andOutMchNoGreaterThanOrEqualTo(String value) {
            addCriterion("out_mch_no >=", value, "outMchNo");
            return (Criteria) this;
        }

        public Criteria andOutMchNoLessThan(String value) {
            addCriterion("out_mch_no <", value, "outMchNo");
            return (Criteria) this;
        }

        public Criteria andOutMchNoLessThanOrEqualTo(String value) {
            addCriterion("out_mch_no <=", value, "outMchNo");
            return (Criteria) this;
        }

        public Criteria andOutMchNoLike(String value) {
            addCriterion("out_mch_no like", value, "outMchNo");
            return (Criteria) this;
        }

        public Criteria andOutMchNoNotLike(String value) {
            addCriterion("out_mch_no not like", value, "outMchNo");
            return (Criteria) this;
        }

        public Criteria andOutMchNoIn(List<String> values) {
            addCriterion("out_mch_no in", values, "outMchNo");
            return (Criteria) this;
        }

        public Criteria andOutMchNoNotIn(List<String> values) {
            addCriterion("out_mch_no not in", values, "outMchNo");
            return (Criteria) this;
        }

        public Criteria andOutMchNoBetween(String value1, String value2) {
            addCriterion("out_mch_no between", value1, value2, "outMchNo");
            return (Criteria) this;
        }

        public Criteria andOutMchNoNotBetween(String value1, String value2) {
            addCriterion("out_mch_no not between", value1, value2, "outMchNo");
            return (Criteria) this;
        }

        public Criteria andMchNoIsNull() {
            addCriterion("mch_no is null");
            return (Criteria) this;
        }

        public Criteria andMchNoIsNotNull() {
            addCriterion("mch_no is not null");
            return (Criteria) this;
        }

        public Criteria andMchNoEqualTo(String value) {
            addCriterion("mch_no =", value, "mchNo");
            return (Criteria) this;
        }

        public Criteria andMchNoNotEqualTo(String value) {
            addCriterion("mch_no <>", value, "mchNo");
            return (Criteria) this;
        }

        public Criteria andMchNoGreaterThan(String value) {
            addCriterion("mch_no >", value, "mchNo");
            return (Criteria) this;
        }

        public Criteria andMchNoGreaterThanOrEqualTo(String value) {
            addCriterion("mch_no >=", value, "mchNo");
            return (Criteria) this;
        }

        public Criteria andMchNoLessThan(String value) {
            addCriterion("mch_no <", value, "mchNo");
            return (Criteria) this;
        }

        public Criteria andMchNoLessThanOrEqualTo(String value) {
            addCriterion("mch_no <=", value, "mchNo");
            return (Criteria) this;
        }

        public Criteria andMchNoLike(String value) {
            addCriterion("mch_no like", value, "mchNo");
            return (Criteria) this;
        }

        public Criteria andMchNoNotLike(String value) {
            addCriterion("mch_no not like", value, "mchNo");
            return (Criteria) this;
        }

        public Criteria andMchNoIn(List<String> values) {
            addCriterion("mch_no in", values, "mchNo");
            return (Criteria) this;
        }

        public Criteria andMchNoNotIn(List<String> values) {
            addCriterion("mch_no not in", values, "mchNo");
            return (Criteria) this;
        }

        public Criteria andMchNoBetween(String value1, String value2) {
            addCriterion("mch_no between", value1, value2, "mchNo");
            return (Criteria) this;
        }

        public Criteria andMchNoNotBetween(String value1, String value2) {
            addCriterion("mch_no not between", value1, value2, "mchNo");
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

        public Criteria andAgentIdIsNull() {
            addCriterion("agent_id is null");
            return (Criteria) this;
        }

        public Criteria andAgentIdIsNotNull() {
            addCriterion("agent_id is not null");
            return (Criteria) this;
        }

        public Criteria andAgentIdEqualTo(Long value) {
            addCriterion("agent_id =", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotEqualTo(Long value) {
            addCriterion("agent_id <>", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdGreaterThan(Long value) {
            addCriterion("agent_id >", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("agent_id >=", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdLessThan(Long value) {
            addCriterion("agent_id <", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdLessThanOrEqualTo(Long value) {
            addCriterion("agent_id <=", value, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdIn(List<Long> values) {
            addCriterion("agent_id in", values, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotIn(List<Long> values) {
            addCriterion("agent_id not in", values, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdBetween(Long value1, Long value2) {
            addCriterion("agent_id between", value1, value2, "agentId");
            return (Criteria) this;
        }

        public Criteria andAgentIdNotBetween(Long value1, Long value2) {
            addCriterion("agent_id not between", value1, value2, "agentId");
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

        public Criteria andUserAdminIdIsNull() {
            addCriterion("user_admin_id is null");
            return (Criteria) this;
        }

        public Criteria andUserAdminIdIsNotNull() {
            addCriterion("user_admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserAdminIdEqualTo(Long value) {
            addCriterion("user_admin_id =", value, "userAdminId");
            return (Criteria) this;
        }

        public Criteria andUserAdminIdNotEqualTo(Long value) {
            addCriterion("user_admin_id <>", value, "userAdminId");
            return (Criteria) this;
        }

        public Criteria andUserAdminIdGreaterThan(Long value) {
            addCriterion("user_admin_id >", value, "userAdminId");
            return (Criteria) this;
        }

        public Criteria andUserAdminIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_admin_id >=", value, "userAdminId");
            return (Criteria) this;
        }

        public Criteria andUserAdminIdLessThan(Long value) {
            addCriterion("user_admin_id <", value, "userAdminId");
            return (Criteria) this;
        }

        public Criteria andUserAdminIdLessThanOrEqualTo(Long value) {
            addCriterion("user_admin_id <=", value, "userAdminId");
            return (Criteria) this;
        }

        public Criteria andUserAdminIdIn(List<Long> values) {
            addCriterion("user_admin_id in", values, "userAdminId");
            return (Criteria) this;
        }

        public Criteria andUserAdminIdNotIn(List<Long> values) {
            addCriterion("user_admin_id not in", values, "userAdminId");
            return (Criteria) this;
        }

        public Criteria andUserAdminIdBetween(Long value1, Long value2) {
            addCriterion("user_admin_id between", value1, value2, "userAdminId");
            return (Criteria) this;
        }

        public Criteria andUserAdminIdNotBetween(Long value1, Long value2) {
            addCriterion("user_admin_id not between", value1, value2, "userAdminId");
            return (Criteria) this;
        }

        public Criteria andMchStatusIsNull() {
            addCriterion("mch_status is null");
            return (Criteria) this;
        }

        public Criteria andMchStatusIsNotNull() {
            addCriterion("mch_status is not null");
            return (Criteria) this;
        }

        public Criteria andMchStatusEqualTo(String value) {
            addCriterion("mch_status =", value, "mchStatus");
            return (Criteria) this;
        }

        public Criteria andMchStatusNotEqualTo(String value) {
            addCriterion("mch_status <>", value, "mchStatus");
            return (Criteria) this;
        }

        public Criteria andMchStatusGreaterThan(String value) {
            addCriterion("mch_status >", value, "mchStatus");
            return (Criteria) this;
        }

        public Criteria andMchStatusGreaterThanOrEqualTo(String value) {
            addCriterion("mch_status >=", value, "mchStatus");
            return (Criteria) this;
        }

        public Criteria andMchStatusLessThan(String value) {
            addCriterion("mch_status <", value, "mchStatus");
            return (Criteria) this;
        }

        public Criteria andMchStatusLessThanOrEqualTo(String value) {
            addCriterion("mch_status <=", value, "mchStatus");
            return (Criteria) this;
        }

        public Criteria andMchStatusLike(String value) {
            addCriterion("mch_status like", value, "mchStatus");
            return (Criteria) this;
        }

        public Criteria andMchStatusNotLike(String value) {
            addCriterion("mch_status not like", value, "mchStatus");
            return (Criteria) this;
        }

        public Criteria andMchStatusIn(List<String> values) {
            addCriterion("mch_status in", values, "mchStatus");
            return (Criteria) this;
        }

        public Criteria andMchStatusNotIn(List<String> values) {
            addCriterion("mch_status not in", values, "mchStatus");
            return (Criteria) this;
        }

        public Criteria andMchStatusBetween(String value1, String value2) {
            addCriterion("mch_status between", value1, value2, "mchStatus");
            return (Criteria) this;
        }

        public Criteria andMchStatusNotBetween(String value1, String value2) {
            addCriterion("mch_status not between", value1, value2, "mchStatus");
            return (Criteria) this;
        }

        public Criteria andMchTypeIsNull() {
            addCriterion("mch_type is null");
            return (Criteria) this;
        }

        public Criteria andMchTypeIsNotNull() {
            addCriterion("mch_type is not null");
            return (Criteria) this;
        }

        public Criteria andMchTypeEqualTo(String value) {
            addCriterion("mch_type =", value, "mchType");
            return (Criteria) this;
        }

        public Criteria andMchTypeNotEqualTo(String value) {
            addCriterion("mch_type <>", value, "mchType");
            return (Criteria) this;
        }

        public Criteria andMchTypeGreaterThan(String value) {
            addCriterion("mch_type >", value, "mchType");
            return (Criteria) this;
        }

        public Criteria andMchTypeGreaterThanOrEqualTo(String value) {
            addCriterion("mch_type >=", value, "mchType");
            return (Criteria) this;
        }

        public Criteria andMchTypeLessThan(String value) {
            addCriterion("mch_type <", value, "mchType");
            return (Criteria) this;
        }

        public Criteria andMchTypeLessThanOrEqualTo(String value) {
            addCriterion("mch_type <=", value, "mchType");
            return (Criteria) this;
        }

        public Criteria andMchTypeLike(String value) {
            addCriterion("mch_type like", value, "mchType");
            return (Criteria) this;
        }

        public Criteria andMchTypeNotLike(String value) {
            addCriterion("mch_type not like", value, "mchType");
            return (Criteria) this;
        }

        public Criteria andMchTypeIn(List<String> values) {
            addCriterion("mch_type in", values, "mchType");
            return (Criteria) this;
        }

        public Criteria andMchTypeNotIn(List<String> values) {
            addCriterion("mch_type not in", values, "mchType");
            return (Criteria) this;
        }

        public Criteria andMchTypeBetween(String value1, String value2) {
            addCriterion("mch_type between", value1, value2, "mchType");
            return (Criteria) this;
        }

        public Criteria andMchTypeNotBetween(String value1, String value2) {
            addCriterion("mch_type not between", value1, value2, "mchType");
            return (Criteria) this;
        }

        public Criteria andMchShortNameIsNull() {
            addCriterion("mch_short_name is null");
            return (Criteria) this;
        }

        public Criteria andMchShortNameIsNotNull() {
            addCriterion("mch_short_name is not null");
            return (Criteria) this;
        }

        public Criteria andMchShortNameEqualTo(String value) {
            addCriterion("mch_short_name =", value, "mchShortName");
            return (Criteria) this;
        }

        public Criteria andMchShortNameNotEqualTo(String value) {
            addCriterion("mch_short_name <>", value, "mchShortName");
            return (Criteria) this;
        }

        public Criteria andMchShortNameGreaterThan(String value) {
            addCriterion("mch_short_name >", value, "mchShortName");
            return (Criteria) this;
        }

        public Criteria andMchShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("mch_short_name >=", value, "mchShortName");
            return (Criteria) this;
        }

        public Criteria andMchShortNameLessThan(String value) {
            addCriterion("mch_short_name <", value, "mchShortName");
            return (Criteria) this;
        }

        public Criteria andMchShortNameLessThanOrEqualTo(String value) {
            addCriterion("mch_short_name <=", value, "mchShortName");
            return (Criteria) this;
        }

        public Criteria andMchShortNameLike(String value) {
            addCriterion("mch_short_name like", value, "mchShortName");
            return (Criteria) this;
        }

        public Criteria andMchShortNameNotLike(String value) {
            addCriterion("mch_short_name not like", value, "mchShortName");
            return (Criteria) this;
        }

        public Criteria andMchShortNameIn(List<String> values) {
            addCriterion("mch_short_name in", values, "mchShortName");
            return (Criteria) this;
        }

        public Criteria andMchShortNameNotIn(List<String> values) {
            addCriterion("mch_short_name not in", values, "mchShortName");
            return (Criteria) this;
        }

        public Criteria andMchShortNameBetween(String value1, String value2) {
            addCriterion("mch_short_name between", value1, value2, "mchShortName");
            return (Criteria) this;
        }

        public Criteria andMchShortNameNotBetween(String value1, String value2) {
            addCriterion("mch_short_name not between", value1, value2, "mchShortName");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressIsNull() {
            addCriterion("register_address is null");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressIsNotNull() {
            addCriterion("register_address is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressEqualTo(String value) {
            addCriterion("register_address =", value, "registerAddress");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressNotEqualTo(String value) {
            addCriterion("register_address <>", value, "registerAddress");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressGreaterThan(String value) {
            addCriterion("register_address >", value, "registerAddress");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressGreaterThanOrEqualTo(String value) {
            addCriterion("register_address >=", value, "registerAddress");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressLessThan(String value) {
            addCriterion("register_address <", value, "registerAddress");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressLessThanOrEqualTo(String value) {
            addCriterion("register_address <=", value, "registerAddress");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressLike(String value) {
            addCriterion("register_address like", value, "registerAddress");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressNotLike(String value) {
            addCriterion("register_address not like", value, "registerAddress");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressIn(List<String> values) {
            addCriterion("register_address in", values, "registerAddress");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressNotIn(List<String> values) {
            addCriterion("register_address not in", values, "registerAddress");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressBetween(String value1, String value2) {
            addCriterion("register_address between", value1, value2, "registerAddress");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressNotBetween(String value1, String value2) {
            addCriterion("register_address not between", value1, value2, "registerAddress");
            return (Criteria) this;
        }

        public Criteria andBusinessProviceCodeIsNull() {
            addCriterion("business_provice_code is null");
            return (Criteria) this;
        }

        public Criteria andBusinessProviceCodeIsNotNull() {
            addCriterion("business_provice_code is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessProviceCodeEqualTo(String value) {
            addCriterion("business_provice_code =", value, "businessProviceCode");
            return (Criteria) this;
        }

        public Criteria andBusinessProviceCodeNotEqualTo(String value) {
            addCriterion("business_provice_code <>", value, "businessProviceCode");
            return (Criteria) this;
        }

        public Criteria andBusinessProviceCodeGreaterThan(String value) {
            addCriterion("business_provice_code >", value, "businessProviceCode");
            return (Criteria) this;
        }

        public Criteria andBusinessProviceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("business_provice_code >=", value, "businessProviceCode");
            return (Criteria) this;
        }

        public Criteria andBusinessProviceCodeLessThan(String value) {
            addCriterion("business_provice_code <", value, "businessProviceCode");
            return (Criteria) this;
        }

        public Criteria andBusinessProviceCodeLessThanOrEqualTo(String value) {
            addCriterion("business_provice_code <=", value, "businessProviceCode");
            return (Criteria) this;
        }

        public Criteria andBusinessProviceCodeLike(String value) {
            addCriterion("business_provice_code like", value, "businessProviceCode");
            return (Criteria) this;
        }

        public Criteria andBusinessProviceCodeNotLike(String value) {
            addCriterion("business_provice_code not like", value, "businessProviceCode");
            return (Criteria) this;
        }

        public Criteria andBusinessProviceCodeIn(List<String> values) {
            addCriterion("business_provice_code in", values, "businessProviceCode");
            return (Criteria) this;
        }

        public Criteria andBusinessProviceCodeNotIn(List<String> values) {
            addCriterion("business_provice_code not in", values, "businessProviceCode");
            return (Criteria) this;
        }

        public Criteria andBusinessProviceCodeBetween(String value1, String value2) {
            addCriterion("business_provice_code between", value1, value2, "businessProviceCode");
            return (Criteria) this;
        }

        public Criteria andBusinessProviceCodeNotBetween(String value1, String value2) {
            addCriterion("business_provice_code not between", value1, value2, "businessProviceCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCityCodeIsNull() {
            addCriterion("business_city_code is null");
            return (Criteria) this;
        }

        public Criteria andBusinessCityCodeIsNotNull() {
            addCriterion("business_city_code is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessCityCodeEqualTo(String value) {
            addCriterion("business_city_code =", value, "businessCityCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCityCodeNotEqualTo(String value) {
            addCriterion("business_city_code <>", value, "businessCityCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCityCodeGreaterThan(String value) {
            addCriterion("business_city_code >", value, "businessCityCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCityCodeGreaterThanOrEqualTo(String value) {
            addCriterion("business_city_code >=", value, "businessCityCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCityCodeLessThan(String value) {
            addCriterion("business_city_code <", value, "businessCityCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCityCodeLessThanOrEqualTo(String value) {
            addCriterion("business_city_code <=", value, "businessCityCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCityCodeLike(String value) {
            addCriterion("business_city_code like", value, "businessCityCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCityCodeNotLike(String value) {
            addCriterion("business_city_code not like", value, "businessCityCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCityCodeIn(List<String> values) {
            addCriterion("business_city_code in", values, "businessCityCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCityCodeNotIn(List<String> values) {
            addCriterion("business_city_code not in", values, "businessCityCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCityCodeBetween(String value1, String value2) {
            addCriterion("business_city_code between", value1, value2, "businessCityCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCityCodeNotBetween(String value1, String value2) {
            addCriterion("business_city_code not between", value1, value2, "businessCityCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCountyCodeIsNull() {
            addCriterion("business_county_code is null");
            return (Criteria) this;
        }

        public Criteria andBusinessCountyCodeIsNotNull() {
            addCriterion("business_county_code is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessCountyCodeEqualTo(String value) {
            addCriterion("business_county_code =", value, "businessCountyCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCountyCodeNotEqualTo(String value) {
            addCriterion("business_county_code <>", value, "businessCountyCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCountyCodeGreaterThan(String value) {
            addCriterion("business_county_code >", value, "businessCountyCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCountyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("business_county_code >=", value, "businessCountyCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCountyCodeLessThan(String value) {
            addCriterion("business_county_code <", value, "businessCountyCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCountyCodeLessThanOrEqualTo(String value) {
            addCriterion("business_county_code <=", value, "businessCountyCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCountyCodeLike(String value) {
            addCriterion("business_county_code like", value, "businessCountyCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCountyCodeNotLike(String value) {
            addCriterion("business_county_code not like", value, "businessCountyCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCountyCodeIn(List<String> values) {
            addCriterion("business_county_code in", values, "businessCountyCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCountyCodeNotIn(List<String> values) {
            addCriterion("business_county_code not in", values, "businessCountyCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCountyCodeBetween(String value1, String value2) {
            addCriterion("business_county_code between", value1, value2, "businessCountyCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCountyCodeNotBetween(String value1, String value2) {
            addCriterion("business_county_code not between", value1, value2, "businessCountyCode");
            return (Criteria) this;
        }

        public Criteria andBusinessAddressIsNull() {
            addCriterion("business_address is null");
            return (Criteria) this;
        }

        public Criteria andBusinessAddressIsNotNull() {
            addCriterion("business_address is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessAddressEqualTo(String value) {
            addCriterion("business_address =", value, "businessAddress");
            return (Criteria) this;
        }

        public Criteria andBusinessAddressNotEqualTo(String value) {
            addCriterion("business_address <>", value, "businessAddress");
            return (Criteria) this;
        }

        public Criteria andBusinessAddressGreaterThan(String value) {
            addCriterion("business_address >", value, "businessAddress");
            return (Criteria) this;
        }

        public Criteria andBusinessAddressGreaterThanOrEqualTo(String value) {
            addCriterion("business_address >=", value, "businessAddress");
            return (Criteria) this;
        }

        public Criteria andBusinessAddressLessThan(String value) {
            addCriterion("business_address <", value, "businessAddress");
            return (Criteria) this;
        }

        public Criteria andBusinessAddressLessThanOrEqualTo(String value) {
            addCriterion("business_address <=", value, "businessAddress");
            return (Criteria) this;
        }

        public Criteria andBusinessAddressLike(String value) {
            addCriterion("business_address like", value, "businessAddress");
            return (Criteria) this;
        }

        public Criteria andBusinessAddressNotLike(String value) {
            addCriterion("business_address not like", value, "businessAddress");
            return (Criteria) this;
        }

        public Criteria andBusinessAddressIn(List<String> values) {
            addCriterion("business_address in", values, "businessAddress");
            return (Criteria) this;
        }

        public Criteria andBusinessAddressNotIn(List<String> values) {
            addCriterion("business_address not in", values, "businessAddress");
            return (Criteria) this;
        }

        public Criteria andBusinessAddressBetween(String value1, String value2) {
            addCriterion("business_address between", value1, value2, "businessAddress");
            return (Criteria) this;
        }

        public Criteria andBusinessAddressNotBetween(String value1, String value2) {
            addCriterion("business_address not between", value1, value2, "businessAddress");
            return (Criteria) this;
        }

        public Criteria andBusinessAddressNameIsNull() {
            addCriterion("business_address_name is null");
            return (Criteria) this;
        }

        public Criteria andBusinessAddressNameIsNotNull() {
            addCriterion("business_address_name is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessAddressNameEqualTo(String value) {
            addCriterion("business_address_name =", value, "businessAddressName");
            return (Criteria) this;
        }

        public Criteria andBusinessAddressNameNotEqualTo(String value) {
            addCriterion("business_address_name <>", value, "businessAddressName");
            return (Criteria) this;
        }

        public Criteria andBusinessAddressNameGreaterThan(String value) {
            addCriterion("business_address_name >", value, "businessAddressName");
            return (Criteria) this;
        }

        public Criteria andBusinessAddressNameGreaterThanOrEqualTo(String value) {
            addCriterion("business_address_name >=", value, "businessAddressName");
            return (Criteria) this;
        }

        public Criteria andBusinessAddressNameLessThan(String value) {
            addCriterion("business_address_name <", value, "businessAddressName");
            return (Criteria) this;
        }

        public Criteria andBusinessAddressNameLessThanOrEqualTo(String value) {
            addCriterion("business_address_name <=", value, "businessAddressName");
            return (Criteria) this;
        }

        public Criteria andBusinessAddressNameLike(String value) {
            addCriterion("business_address_name like", value, "businessAddressName");
            return (Criteria) this;
        }

        public Criteria andBusinessAddressNameNotLike(String value) {
            addCriterion("business_address_name not like", value, "businessAddressName");
            return (Criteria) this;
        }

        public Criteria andBusinessAddressNameIn(List<String> values) {
            addCriterion("business_address_name in", values, "businessAddressName");
            return (Criteria) this;
        }

        public Criteria andBusinessAddressNameNotIn(List<String> values) {
            addCriterion("business_address_name not in", values, "businessAddressName");
            return (Criteria) this;
        }

        public Criteria andBusinessAddressNameBetween(String value1, String value2) {
            addCriterion("business_address_name between", value1, value2, "businessAddressName");
            return (Criteria) this;
        }

        public Criteria andBusinessAddressNameNotBetween(String value1, String value2) {
            addCriterion("business_address_name not between", value1, value2, "businessAddressName");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIsNull() {
            addCriterion("business_license is null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIsNotNull() {
            addCriterion("business_license is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseEqualTo(String value) {
            addCriterion("business_license =", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotEqualTo(String value) {
            addCriterion("business_license <>", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseGreaterThan(String value) {
            addCriterion("business_license >", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseGreaterThanOrEqualTo(String value) {
            addCriterion("business_license >=", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLessThan(String value) {
            addCriterion("business_license <", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLessThanOrEqualTo(String value) {
            addCriterion("business_license <=", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLike(String value) {
            addCriterion("business_license like", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotLike(String value) {
            addCriterion("business_license not like", value, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseIn(List<String> values) {
            addCriterion("business_license in", values, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotIn(List<String> values) {
            addCriterion("business_license not in", values, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseBetween(String value1, String value2) {
            addCriterion("business_license between", value1, value2, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseNotBetween(String value1, String value2) {
            addCriterion("business_license not between", value1, value2, "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessAmtIsNull() {
            addCriterion("business_amt is null");
            return (Criteria) this;
        }

        public Criteria andBusinessAmtIsNotNull() {
            addCriterion("business_amt is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessAmtEqualTo(String value) {
            addCriterion("business_amt =", value, "businessAmt");
            return (Criteria) this;
        }

        public Criteria andBusinessAmtNotEqualTo(String value) {
            addCriterion("business_amt <>", value, "businessAmt");
            return (Criteria) this;
        }

        public Criteria andBusinessAmtGreaterThan(String value) {
            addCriterion("business_amt >", value, "businessAmt");
            return (Criteria) this;
        }

        public Criteria andBusinessAmtGreaterThanOrEqualTo(String value) {
            addCriterion("business_amt >=", value, "businessAmt");
            return (Criteria) this;
        }

        public Criteria andBusinessAmtLessThan(String value) {
            addCriterion("business_amt <", value, "businessAmt");
            return (Criteria) this;
        }

        public Criteria andBusinessAmtLessThanOrEqualTo(String value) {
            addCriterion("business_amt <=", value, "businessAmt");
            return (Criteria) this;
        }

        public Criteria andBusinessAmtLike(String value) {
            addCriterion("business_amt like", value, "businessAmt");
            return (Criteria) this;
        }

        public Criteria andBusinessAmtNotLike(String value) {
            addCriterion("business_amt not like", value, "businessAmt");
            return (Criteria) this;
        }

        public Criteria andBusinessAmtIn(List<String> values) {
            addCriterion("business_amt in", values, "businessAmt");
            return (Criteria) this;
        }

        public Criteria andBusinessAmtNotIn(List<String> values) {
            addCriterion("business_amt not in", values, "businessAmt");
            return (Criteria) this;
        }

        public Criteria andBusinessAmtBetween(String value1, String value2) {
            addCriterion("business_amt between", value1, value2, "businessAmt");
            return (Criteria) this;
        }

        public Criteria andBusinessAmtNotBetween(String value1, String value2) {
            addCriterion("business_amt not between", value1, value2, "businessAmt");
            return (Criteria) this;
        }

        public Criteria andBusinessExpireStartIsNull() {
            addCriterion("business_expire_start is null");
            return (Criteria) this;
        }

        public Criteria andBusinessExpireStartIsNotNull() {
            addCriterion("business_expire_start is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessExpireStartEqualTo(String value) {
            addCriterion("business_expire_start =", value, "businessExpireStart");
            return (Criteria) this;
        }

        public Criteria andBusinessExpireStartNotEqualTo(String value) {
            addCriterion("business_expire_start <>", value, "businessExpireStart");
            return (Criteria) this;
        }

        public Criteria andBusinessExpireStartGreaterThan(String value) {
            addCriterion("business_expire_start >", value, "businessExpireStart");
            return (Criteria) this;
        }

        public Criteria andBusinessExpireStartGreaterThanOrEqualTo(String value) {
            addCriterion("business_expire_start >=", value, "businessExpireStart");
            return (Criteria) this;
        }

        public Criteria andBusinessExpireStartLessThan(String value) {
            addCriterion("business_expire_start <", value, "businessExpireStart");
            return (Criteria) this;
        }

        public Criteria andBusinessExpireStartLessThanOrEqualTo(String value) {
            addCriterion("business_expire_start <=", value, "businessExpireStart");
            return (Criteria) this;
        }

        public Criteria andBusinessExpireStartLike(String value) {
            addCriterion("business_expire_start like", value, "businessExpireStart");
            return (Criteria) this;
        }

        public Criteria andBusinessExpireStartNotLike(String value) {
            addCriterion("business_expire_start not like", value, "businessExpireStart");
            return (Criteria) this;
        }

        public Criteria andBusinessExpireStartIn(List<String> values) {
            addCriterion("business_expire_start in", values, "businessExpireStart");
            return (Criteria) this;
        }

        public Criteria andBusinessExpireStartNotIn(List<String> values) {
            addCriterion("business_expire_start not in", values, "businessExpireStart");
            return (Criteria) this;
        }

        public Criteria andBusinessExpireStartBetween(String value1, String value2) {
            addCriterion("business_expire_start between", value1, value2, "businessExpireStart");
            return (Criteria) this;
        }

        public Criteria andBusinessExpireStartNotBetween(String value1, String value2) {
            addCriterion("business_expire_start not between", value1, value2, "businessExpireStart");
            return (Criteria) this;
        }

        public Criteria andBusinessExpireEndIsNull() {
            addCriterion("business_expire_end is null");
            return (Criteria) this;
        }

        public Criteria andBusinessExpireEndIsNotNull() {
            addCriterion("business_expire_end is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessExpireEndEqualTo(String value) {
            addCriterion("business_expire_end =", value, "businessExpireEnd");
            return (Criteria) this;
        }

        public Criteria andBusinessExpireEndNotEqualTo(String value) {
            addCriterion("business_expire_end <>", value, "businessExpireEnd");
            return (Criteria) this;
        }

        public Criteria andBusinessExpireEndGreaterThan(String value) {
            addCriterion("business_expire_end >", value, "businessExpireEnd");
            return (Criteria) this;
        }

        public Criteria andBusinessExpireEndGreaterThanOrEqualTo(String value) {
            addCriterion("business_expire_end >=", value, "businessExpireEnd");
            return (Criteria) this;
        }

        public Criteria andBusinessExpireEndLessThan(String value) {
            addCriterion("business_expire_end <", value, "businessExpireEnd");
            return (Criteria) this;
        }

        public Criteria andBusinessExpireEndLessThanOrEqualTo(String value) {
            addCriterion("business_expire_end <=", value, "businessExpireEnd");
            return (Criteria) this;
        }

        public Criteria andBusinessExpireEndLike(String value) {
            addCriterion("business_expire_end like", value, "businessExpireEnd");
            return (Criteria) this;
        }

        public Criteria andBusinessExpireEndNotLike(String value) {
            addCriterion("business_expire_end not like", value, "businessExpireEnd");
            return (Criteria) this;
        }

        public Criteria andBusinessExpireEndIn(List<String> values) {
            addCriterion("business_expire_end in", values, "businessExpireEnd");
            return (Criteria) this;
        }

        public Criteria andBusinessExpireEndNotIn(List<String> values) {
            addCriterion("business_expire_end not in", values, "businessExpireEnd");
            return (Criteria) this;
        }

        public Criteria andBusinessExpireEndBetween(String value1, String value2) {
            addCriterion("business_expire_end between", value1, value2, "businessExpireEnd");
            return (Criteria) this;
        }

        public Criteria andBusinessExpireEndNotBetween(String value1, String value2) {
            addCriterion("business_expire_end not between", value1, value2, "businessExpireEnd");
            return (Criteria) this;
        }

        public Criteria andBusinessInfoIsNull() {
            addCriterion("business_info is null");
            return (Criteria) this;
        }

        public Criteria andBusinessInfoIsNotNull() {
            addCriterion("business_info is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessInfoEqualTo(String value) {
            addCriterion("business_info =", value, "businessInfo");
            return (Criteria) this;
        }

        public Criteria andBusinessInfoNotEqualTo(String value) {
            addCriterion("business_info <>", value, "businessInfo");
            return (Criteria) this;
        }

        public Criteria andBusinessInfoGreaterThan(String value) {
            addCriterion("business_info >", value, "businessInfo");
            return (Criteria) this;
        }

        public Criteria andBusinessInfoGreaterThanOrEqualTo(String value) {
            addCriterion("business_info >=", value, "businessInfo");
            return (Criteria) this;
        }

        public Criteria andBusinessInfoLessThan(String value) {
            addCriterion("business_info <", value, "businessInfo");
            return (Criteria) this;
        }

        public Criteria andBusinessInfoLessThanOrEqualTo(String value) {
            addCriterion("business_info <=", value, "businessInfo");
            return (Criteria) this;
        }

        public Criteria andBusinessInfoLike(String value) {
            addCriterion("business_info like", value, "businessInfo");
            return (Criteria) this;
        }

        public Criteria andBusinessInfoNotLike(String value) {
            addCriterion("business_info not like", value, "businessInfo");
            return (Criteria) this;
        }

        public Criteria andBusinessInfoIn(List<String> values) {
            addCriterion("business_info in", values, "businessInfo");
            return (Criteria) this;
        }

        public Criteria andBusinessInfoNotIn(List<String> values) {
            addCriterion("business_info not in", values, "businessInfo");
            return (Criteria) this;
        }

        public Criteria andBusinessInfoBetween(String value1, String value2) {
            addCriterion("business_info between", value1, value2, "businessInfo");
            return (Criteria) this;
        }

        public Criteria andBusinessInfoNotBetween(String value1, String value2) {
            addCriterion("business_info not between", value1, value2, "businessInfo");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCategoryIsNull() {
            addCriterion("enterprise_category is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCategoryIsNotNull() {
            addCriterion("enterprise_category is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCategoryEqualTo(String value) {
            addCriterion("enterprise_category =", value, "enterpriseCategory");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCategoryNotEqualTo(String value) {
            addCriterion("enterprise_category <>", value, "enterpriseCategory");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCategoryGreaterThan(String value) {
            addCriterion("enterprise_category >", value, "enterpriseCategory");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_category >=", value, "enterpriseCategory");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCategoryLessThan(String value) {
            addCriterion("enterprise_category <", value, "enterpriseCategory");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCategoryLessThanOrEqualTo(String value) {
            addCriterion("enterprise_category <=", value, "enterpriseCategory");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCategoryLike(String value) {
            addCriterion("enterprise_category like", value, "enterpriseCategory");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCategoryNotLike(String value) {
            addCriterion("enterprise_category not like", value, "enterpriseCategory");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCategoryIn(List<String> values) {
            addCriterion("enterprise_category in", values, "enterpriseCategory");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCategoryNotIn(List<String> values) {
            addCriterion("enterprise_category not in", values, "enterpriseCategory");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCategoryBetween(String value1, String value2) {
            addCriterion("enterprise_category between", value1, value2, "enterpriseCategory");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCategoryNotBetween(String value1, String value2) {
            addCriterion("enterprise_category not between", value1, value2, "enterpriseCategory");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScaleIsNull() {
            addCriterion("enterprise_scale is null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScaleIsNotNull() {
            addCriterion("enterprise_scale is not null");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScaleEqualTo(String value) {
            addCriterion("enterprise_scale =", value, "enterpriseScale");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScaleNotEqualTo(String value) {
            addCriterion("enterprise_scale <>", value, "enterpriseScale");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScaleGreaterThan(String value) {
            addCriterion("enterprise_scale >", value, "enterpriseScale");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScaleGreaterThanOrEqualTo(String value) {
            addCriterion("enterprise_scale >=", value, "enterpriseScale");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScaleLessThan(String value) {
            addCriterion("enterprise_scale <", value, "enterpriseScale");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScaleLessThanOrEqualTo(String value) {
            addCriterion("enterprise_scale <=", value, "enterpriseScale");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScaleLike(String value) {
            addCriterion("enterprise_scale like", value, "enterpriseScale");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScaleNotLike(String value) {
            addCriterion("enterprise_scale not like", value, "enterpriseScale");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScaleIn(List<String> values) {
            addCriterion("enterprise_scale in", values, "enterpriseScale");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScaleNotIn(List<String> values) {
            addCriterion("enterprise_scale not in", values, "enterpriseScale");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScaleBetween(String value1, String value2) {
            addCriterion("enterprise_scale between", value1, value2, "enterpriseScale");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScaleNotBetween(String value1, String value2) {
            addCriterion("enterprise_scale not between", value1, value2, "enterpriseScale");
            return (Criteria) this;
        }

        public Criteria andMccIsNull() {
            addCriterion("mcc is null");
            return (Criteria) this;
        }

        public Criteria andMccIsNotNull() {
            addCriterion("mcc is not null");
            return (Criteria) this;
        }

        public Criteria andMccEqualTo(String value) {
            addCriterion("mcc =", value, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccNotEqualTo(String value) {
            addCriterion("mcc <>", value, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccGreaterThan(String value) {
            addCriterion("mcc >", value, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccGreaterThanOrEqualTo(String value) {
            addCriterion("mcc >=", value, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccLessThan(String value) {
            addCriterion("mcc <", value, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccLessThanOrEqualTo(String value) {
            addCriterion("mcc <=", value, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccLike(String value) {
            addCriterion("mcc like", value, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccNotLike(String value) {
            addCriterion("mcc not like", value, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccIn(List<String> values) {
            addCriterion("mcc in", values, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccNotIn(List<String> values) {
            addCriterion("mcc not in", values, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccBetween(String value1, String value2) {
            addCriterion("mcc between", value1, value2, "mcc");
            return (Criteria) this;
        }

        public Criteria andMccNotBetween(String value1, String value2) {
            addCriterion("mcc not between", value1, value2, "mcc");
            return (Criteria) this;
        }

        public Criteria andLegalNameIsNull() {
            addCriterion("legal_name is null");
            return (Criteria) this;
        }

        public Criteria andLegalNameIsNotNull() {
            addCriterion("legal_name is not null");
            return (Criteria) this;
        }

        public Criteria andLegalNameEqualTo(String value) {
            addCriterion("legal_name =", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameNotEqualTo(String value) {
            addCriterion("legal_name <>", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameGreaterThan(String value) {
            addCriterion("legal_name >", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameGreaterThanOrEqualTo(String value) {
            addCriterion("legal_name >=", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameLessThan(String value) {
            addCriterion("legal_name <", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameLessThanOrEqualTo(String value) {
            addCriterion("legal_name <=", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameLike(String value) {
            addCriterion("legal_name like", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameNotLike(String value) {
            addCriterion("legal_name not like", value, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameIn(List<String> values) {
            addCriterion("legal_name in", values, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameNotIn(List<String> values) {
            addCriterion("legal_name not in", values, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameBetween(String value1, String value2) {
            addCriterion("legal_name between", value1, value2, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalNameNotBetween(String value1, String value2) {
            addCriterion("legal_name not between", value1, value2, "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeIsNull() {
            addCriterion("legal_cert_type is null");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeIsNotNull() {
            addCriterion("legal_cert_type is not null");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeEqualTo(String value) {
            addCriterion("legal_cert_type =", value, "legalCertType");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeNotEqualTo(String value) {
            addCriterion("legal_cert_type <>", value, "legalCertType");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeGreaterThan(String value) {
            addCriterion("legal_cert_type >", value, "legalCertType");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeGreaterThanOrEqualTo(String value) {
            addCriterion("legal_cert_type >=", value, "legalCertType");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeLessThan(String value) {
            addCriterion("legal_cert_type <", value, "legalCertType");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeLessThanOrEqualTo(String value) {
            addCriterion("legal_cert_type <=", value, "legalCertType");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeLike(String value) {
            addCriterion("legal_cert_type like", value, "legalCertType");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeNotLike(String value) {
            addCriterion("legal_cert_type not like", value, "legalCertType");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeIn(List<String> values) {
            addCriterion("legal_cert_type in", values, "legalCertType");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeNotIn(List<String> values) {
            addCriterion("legal_cert_type not in", values, "legalCertType");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeBetween(String value1, String value2) {
            addCriterion("legal_cert_type between", value1, value2, "legalCertType");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeNotBetween(String value1, String value2) {
            addCriterion("legal_cert_type not between", value1, value2, "legalCertType");
            return (Criteria) this;
        }

        public Criteria andLegalCertNoIsNull() {
            addCriterion("legal_cert_no is null");
            return (Criteria) this;
        }

        public Criteria andLegalCertNoIsNotNull() {
            addCriterion("legal_cert_no is not null");
            return (Criteria) this;
        }

        public Criteria andLegalCertNoEqualTo(String value) {
            addCriterion("legal_cert_no =", value, "legalCertNo");
            return (Criteria) this;
        }

        public Criteria andLegalCertNoNotEqualTo(String value) {
            addCriterion("legal_cert_no <>", value, "legalCertNo");
            return (Criteria) this;
        }

        public Criteria andLegalCertNoGreaterThan(String value) {
            addCriterion("legal_cert_no >", value, "legalCertNo");
            return (Criteria) this;
        }

        public Criteria andLegalCertNoGreaterThanOrEqualTo(String value) {
            addCriterion("legal_cert_no >=", value, "legalCertNo");
            return (Criteria) this;
        }

        public Criteria andLegalCertNoLessThan(String value) {
            addCriterion("legal_cert_no <", value, "legalCertNo");
            return (Criteria) this;
        }

        public Criteria andLegalCertNoLessThanOrEqualTo(String value) {
            addCriterion("legal_cert_no <=", value, "legalCertNo");
            return (Criteria) this;
        }

        public Criteria andLegalCertNoLike(String value) {
            addCriterion("legal_cert_no like", value, "legalCertNo");
            return (Criteria) this;
        }

        public Criteria andLegalCertNoNotLike(String value) {
            addCriterion("legal_cert_no not like", value, "legalCertNo");
            return (Criteria) this;
        }

        public Criteria andLegalCertNoIn(List<String> values) {
            addCriterion("legal_cert_no in", values, "legalCertNo");
            return (Criteria) this;
        }

        public Criteria andLegalCertNoNotIn(List<String> values) {
            addCriterion("legal_cert_no not in", values, "legalCertNo");
            return (Criteria) this;
        }

        public Criteria andLegalCertNoBetween(String value1, String value2) {
            addCriterion("legal_cert_no between", value1, value2, "legalCertNo");
            return (Criteria) this;
        }

        public Criteria andLegalCertNoNotBetween(String value1, String value2) {
            addCriterion("legal_cert_no not between", value1, value2, "legalCertNo");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneIsNull() {
            addCriterion("legal_phone is null");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneIsNotNull() {
            addCriterion("legal_phone is not null");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneEqualTo(String value) {
            addCriterion("legal_phone =", value, "legalPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneNotEqualTo(String value) {
            addCriterion("legal_phone <>", value, "legalPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneGreaterThan(String value) {
            addCriterion("legal_phone >", value, "legalPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("legal_phone >=", value, "legalPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneLessThan(String value) {
            addCriterion("legal_phone <", value, "legalPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneLessThanOrEqualTo(String value) {
            addCriterion("legal_phone <=", value, "legalPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneLike(String value) {
            addCriterion("legal_phone like", value, "legalPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneNotLike(String value) {
            addCriterion("legal_phone not like", value, "legalPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneIn(List<String> values) {
            addCriterion("legal_phone in", values, "legalPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneNotIn(List<String> values) {
            addCriterion("legal_phone not in", values, "legalPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneBetween(String value1, String value2) {
            addCriterion("legal_phone between", value1, value2, "legalPhone");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneNotBetween(String value1, String value2) {
            addCriterion("legal_phone not between", value1, value2, "legalPhone");
            return (Criteria) this;
        }

        public Criteria andLegalExpireStartIsNull() {
            addCriterion("legal_expire_start is null");
            return (Criteria) this;
        }

        public Criteria andLegalExpireStartIsNotNull() {
            addCriterion("legal_expire_start is not null");
            return (Criteria) this;
        }

        public Criteria andLegalExpireStartEqualTo(String value) {
            addCriterion("legal_expire_start =", value, "legalExpireStart");
            return (Criteria) this;
        }

        public Criteria andLegalExpireStartNotEqualTo(String value) {
            addCriterion("legal_expire_start <>", value, "legalExpireStart");
            return (Criteria) this;
        }

        public Criteria andLegalExpireStartGreaterThan(String value) {
            addCriterion("legal_expire_start >", value, "legalExpireStart");
            return (Criteria) this;
        }

        public Criteria andLegalExpireStartGreaterThanOrEqualTo(String value) {
            addCriterion("legal_expire_start >=", value, "legalExpireStart");
            return (Criteria) this;
        }

        public Criteria andLegalExpireStartLessThan(String value) {
            addCriterion("legal_expire_start <", value, "legalExpireStart");
            return (Criteria) this;
        }

        public Criteria andLegalExpireStartLessThanOrEqualTo(String value) {
            addCriterion("legal_expire_start <=", value, "legalExpireStart");
            return (Criteria) this;
        }

        public Criteria andLegalExpireStartLike(String value) {
            addCriterion("legal_expire_start like", value, "legalExpireStart");
            return (Criteria) this;
        }

        public Criteria andLegalExpireStartNotLike(String value) {
            addCriterion("legal_expire_start not like", value, "legalExpireStart");
            return (Criteria) this;
        }

        public Criteria andLegalExpireStartIn(List<String> values) {
            addCriterion("legal_expire_start in", values, "legalExpireStart");
            return (Criteria) this;
        }

        public Criteria andLegalExpireStartNotIn(List<String> values) {
            addCriterion("legal_expire_start not in", values, "legalExpireStart");
            return (Criteria) this;
        }

        public Criteria andLegalExpireStartBetween(String value1, String value2) {
            addCriterion("legal_expire_start between", value1, value2, "legalExpireStart");
            return (Criteria) this;
        }

        public Criteria andLegalExpireStartNotBetween(String value1, String value2) {
            addCriterion("legal_expire_start not between", value1, value2, "legalExpireStart");
            return (Criteria) this;
        }

        public Criteria andLegalExpireEndIsNull() {
            addCriterion("legal_expire_end is null");
            return (Criteria) this;
        }

        public Criteria andLegalExpireEndIsNotNull() {
            addCriterion("legal_expire_end is not null");
            return (Criteria) this;
        }

        public Criteria andLegalExpireEndEqualTo(String value) {
            addCriterion("legal_expire_end =", value, "legalExpireEnd");
            return (Criteria) this;
        }

        public Criteria andLegalExpireEndNotEqualTo(String value) {
            addCriterion("legal_expire_end <>", value, "legalExpireEnd");
            return (Criteria) this;
        }

        public Criteria andLegalExpireEndGreaterThan(String value) {
            addCriterion("legal_expire_end >", value, "legalExpireEnd");
            return (Criteria) this;
        }

        public Criteria andLegalExpireEndGreaterThanOrEqualTo(String value) {
            addCriterion("legal_expire_end >=", value, "legalExpireEnd");
            return (Criteria) this;
        }

        public Criteria andLegalExpireEndLessThan(String value) {
            addCriterion("legal_expire_end <", value, "legalExpireEnd");
            return (Criteria) this;
        }

        public Criteria andLegalExpireEndLessThanOrEqualTo(String value) {
            addCriterion("legal_expire_end <=", value, "legalExpireEnd");
            return (Criteria) this;
        }

        public Criteria andLegalExpireEndLike(String value) {
            addCriterion("legal_expire_end like", value, "legalExpireEnd");
            return (Criteria) this;
        }

        public Criteria andLegalExpireEndNotLike(String value) {
            addCriterion("legal_expire_end not like", value, "legalExpireEnd");
            return (Criteria) this;
        }

        public Criteria andLegalExpireEndIn(List<String> values) {
            addCriterion("legal_expire_end in", values, "legalExpireEnd");
            return (Criteria) this;
        }

        public Criteria andLegalExpireEndNotIn(List<String> values) {
            addCriterion("legal_expire_end not in", values, "legalExpireEnd");
            return (Criteria) this;
        }

        public Criteria andLegalExpireEndBetween(String value1, String value2) {
            addCriterion("legal_expire_end between", value1, value2, "legalExpireEnd");
            return (Criteria) this;
        }

        public Criteria andLegalExpireEndNotBetween(String value1, String value2) {
            addCriterion("legal_expire_end not between", value1, value2, "legalExpireEnd");
            return (Criteria) this;
        }

        public Criteria andLegalCertAddressIsNull() {
            addCriterion("legal_cert_address is null");
            return (Criteria) this;
        }

        public Criteria andLegalCertAddressIsNotNull() {
            addCriterion("legal_cert_address is not null");
            return (Criteria) this;
        }

        public Criteria andLegalCertAddressEqualTo(String value) {
            addCriterion("legal_cert_address =", value, "legalCertAddress");
            return (Criteria) this;
        }

        public Criteria andLegalCertAddressNotEqualTo(String value) {
            addCriterion("legal_cert_address <>", value, "legalCertAddress");
            return (Criteria) this;
        }

        public Criteria andLegalCertAddressGreaterThan(String value) {
            addCriterion("legal_cert_address >", value, "legalCertAddress");
            return (Criteria) this;
        }

        public Criteria andLegalCertAddressGreaterThanOrEqualTo(String value) {
            addCriterion("legal_cert_address >=", value, "legalCertAddress");
            return (Criteria) this;
        }

        public Criteria andLegalCertAddressLessThan(String value) {
            addCriterion("legal_cert_address <", value, "legalCertAddress");
            return (Criteria) this;
        }

        public Criteria andLegalCertAddressLessThanOrEqualTo(String value) {
            addCriterion("legal_cert_address <=", value, "legalCertAddress");
            return (Criteria) this;
        }

        public Criteria andLegalCertAddressLike(String value) {
            addCriterion("legal_cert_address like", value, "legalCertAddress");
            return (Criteria) this;
        }

        public Criteria andLegalCertAddressNotLike(String value) {
            addCriterion("legal_cert_address not like", value, "legalCertAddress");
            return (Criteria) this;
        }

        public Criteria andLegalCertAddressIn(List<String> values) {
            addCriterion("legal_cert_address in", values, "legalCertAddress");
            return (Criteria) this;
        }

        public Criteria andLegalCertAddressNotIn(List<String> values) {
            addCriterion("legal_cert_address not in", values, "legalCertAddress");
            return (Criteria) this;
        }

        public Criteria andLegalCertAddressBetween(String value1, String value2) {
            addCriterion("legal_cert_address between", value1, value2, "legalCertAddress");
            return (Criteria) this;
        }

        public Criteria andLegalCertAddressNotBetween(String value1, String value2) {
            addCriterion("legal_cert_address not between", value1, value2, "legalCertAddress");
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

        public Criteria andContactCertTypeIsNull() {
            addCriterion("contact_cert_type is null");
            return (Criteria) this;
        }

        public Criteria andContactCertTypeIsNotNull() {
            addCriterion("contact_cert_type is not null");
            return (Criteria) this;
        }

        public Criteria andContactCertTypeEqualTo(String value) {
            addCriterion("contact_cert_type =", value, "contactCertType");
            return (Criteria) this;
        }

        public Criteria andContactCertTypeNotEqualTo(String value) {
            addCriterion("contact_cert_type <>", value, "contactCertType");
            return (Criteria) this;
        }

        public Criteria andContactCertTypeGreaterThan(String value) {
            addCriterion("contact_cert_type >", value, "contactCertType");
            return (Criteria) this;
        }

        public Criteria andContactCertTypeGreaterThanOrEqualTo(String value) {
            addCriterion("contact_cert_type >=", value, "contactCertType");
            return (Criteria) this;
        }

        public Criteria andContactCertTypeLessThan(String value) {
            addCriterion("contact_cert_type <", value, "contactCertType");
            return (Criteria) this;
        }

        public Criteria andContactCertTypeLessThanOrEqualTo(String value) {
            addCriterion("contact_cert_type <=", value, "contactCertType");
            return (Criteria) this;
        }

        public Criteria andContactCertTypeLike(String value) {
            addCriterion("contact_cert_type like", value, "contactCertType");
            return (Criteria) this;
        }

        public Criteria andContactCertTypeNotLike(String value) {
            addCriterion("contact_cert_type not like", value, "contactCertType");
            return (Criteria) this;
        }

        public Criteria andContactCertTypeIn(List<String> values) {
            addCriterion("contact_cert_type in", values, "contactCertType");
            return (Criteria) this;
        }

        public Criteria andContactCertTypeNotIn(List<String> values) {
            addCriterion("contact_cert_type not in", values, "contactCertType");
            return (Criteria) this;
        }

        public Criteria andContactCertTypeBetween(String value1, String value2) {
            addCriterion("contact_cert_type between", value1, value2, "contactCertType");
            return (Criteria) this;
        }

        public Criteria andContactCertTypeNotBetween(String value1, String value2) {
            addCriterion("contact_cert_type not between", value1, value2, "contactCertType");
            return (Criteria) this;
        }

        public Criteria andContactCertNoIsNull() {
            addCriterion("contact_cert_no is null");
            return (Criteria) this;
        }

        public Criteria andContactCertNoIsNotNull() {
            addCriterion("contact_cert_no is not null");
            return (Criteria) this;
        }

        public Criteria andContactCertNoEqualTo(String value) {
            addCriterion("contact_cert_no =", value, "contactCertNo");
            return (Criteria) this;
        }

        public Criteria andContactCertNoNotEqualTo(String value) {
            addCriterion("contact_cert_no <>", value, "contactCertNo");
            return (Criteria) this;
        }

        public Criteria andContactCertNoGreaterThan(String value) {
            addCriterion("contact_cert_no >", value, "contactCertNo");
            return (Criteria) this;
        }

        public Criteria andContactCertNoGreaterThanOrEqualTo(String value) {
            addCriterion("contact_cert_no >=", value, "contactCertNo");
            return (Criteria) this;
        }

        public Criteria andContactCertNoLessThan(String value) {
            addCriterion("contact_cert_no <", value, "contactCertNo");
            return (Criteria) this;
        }

        public Criteria andContactCertNoLessThanOrEqualTo(String value) {
            addCriterion("contact_cert_no <=", value, "contactCertNo");
            return (Criteria) this;
        }

        public Criteria andContactCertNoLike(String value) {
            addCriterion("contact_cert_no like", value, "contactCertNo");
            return (Criteria) this;
        }

        public Criteria andContactCertNoNotLike(String value) {
            addCriterion("contact_cert_no not like", value, "contactCertNo");
            return (Criteria) this;
        }

        public Criteria andContactCertNoIn(List<String> values) {
            addCriterion("contact_cert_no in", values, "contactCertNo");
            return (Criteria) this;
        }

        public Criteria andContactCertNoNotIn(List<String> values) {
            addCriterion("contact_cert_no not in", values, "contactCertNo");
            return (Criteria) this;
        }

        public Criteria andContactCertNoBetween(String value1, String value2) {
            addCriterion("contact_cert_no between", value1, value2, "contactCertNo");
            return (Criteria) this;
        }

        public Criteria andContactCertNoNotBetween(String value1, String value2) {
            addCriterion("contact_cert_no not between", value1, value2, "contactCertNo");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIsNull() {
            addCriterion("contact_phone is null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIsNotNull() {
            addCriterion("contact_phone is not null");
            return (Criteria) this;
        }

        public Criteria andContactPhoneEqualTo(String value) {
            addCriterion("contact_phone =", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotEqualTo(String value) {
            addCriterion("contact_phone <>", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneGreaterThan(String value) {
            addCriterion("contact_phone >", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("contact_phone >=", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLessThan(String value) {
            addCriterion("contact_phone <", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLessThanOrEqualTo(String value) {
            addCriterion("contact_phone <=", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLike(String value) {
            addCriterion("contact_phone like", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotLike(String value) {
            addCriterion("contact_phone not like", value, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneIn(List<String> values) {
            addCriterion("contact_phone in", values, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotIn(List<String> values) {
            addCriterion("contact_phone not in", values, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneBetween(String value1, String value2) {
            addCriterion("contact_phone between", value1, value2, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactPhoneNotBetween(String value1, String value2) {
            addCriterion("contact_phone not between", value1, value2, "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactExpireStartIsNull() {
            addCriterion("contact_expire_start is null");
            return (Criteria) this;
        }

        public Criteria andContactExpireStartIsNotNull() {
            addCriterion("contact_expire_start is not null");
            return (Criteria) this;
        }

        public Criteria andContactExpireStartEqualTo(String value) {
            addCriterion("contact_expire_start =", value, "contactExpireStart");
            return (Criteria) this;
        }

        public Criteria andContactExpireStartNotEqualTo(String value) {
            addCriterion("contact_expire_start <>", value, "contactExpireStart");
            return (Criteria) this;
        }

        public Criteria andContactExpireStartGreaterThan(String value) {
            addCriterion("contact_expire_start >", value, "contactExpireStart");
            return (Criteria) this;
        }

        public Criteria andContactExpireStartGreaterThanOrEqualTo(String value) {
            addCriterion("contact_expire_start >=", value, "contactExpireStart");
            return (Criteria) this;
        }

        public Criteria andContactExpireStartLessThan(String value) {
            addCriterion("contact_expire_start <", value, "contactExpireStart");
            return (Criteria) this;
        }

        public Criteria andContactExpireStartLessThanOrEqualTo(String value) {
            addCriterion("contact_expire_start <=", value, "contactExpireStart");
            return (Criteria) this;
        }

        public Criteria andContactExpireStartLike(String value) {
            addCriterion("contact_expire_start like", value, "contactExpireStart");
            return (Criteria) this;
        }

        public Criteria andContactExpireStartNotLike(String value) {
            addCriterion("contact_expire_start not like", value, "contactExpireStart");
            return (Criteria) this;
        }

        public Criteria andContactExpireStartIn(List<String> values) {
            addCriterion("contact_expire_start in", values, "contactExpireStart");
            return (Criteria) this;
        }

        public Criteria andContactExpireStartNotIn(List<String> values) {
            addCriterion("contact_expire_start not in", values, "contactExpireStart");
            return (Criteria) this;
        }

        public Criteria andContactExpireStartBetween(String value1, String value2) {
            addCriterion("contact_expire_start between", value1, value2, "contactExpireStart");
            return (Criteria) this;
        }

        public Criteria andContactExpireStartNotBetween(String value1, String value2) {
            addCriterion("contact_expire_start not between", value1, value2, "contactExpireStart");
            return (Criteria) this;
        }

        public Criteria andContactExpireEndIsNull() {
            addCriterion("contact_expire_end is null");
            return (Criteria) this;
        }

        public Criteria andContactExpireEndIsNotNull() {
            addCriterion("contact_expire_end is not null");
            return (Criteria) this;
        }

        public Criteria andContactExpireEndEqualTo(String value) {
            addCriterion("contact_expire_end =", value, "contactExpireEnd");
            return (Criteria) this;
        }

        public Criteria andContactExpireEndNotEqualTo(String value) {
            addCriterion("contact_expire_end <>", value, "contactExpireEnd");
            return (Criteria) this;
        }

        public Criteria andContactExpireEndGreaterThan(String value) {
            addCriterion("contact_expire_end >", value, "contactExpireEnd");
            return (Criteria) this;
        }

        public Criteria andContactExpireEndGreaterThanOrEqualTo(String value) {
            addCriterion("contact_expire_end >=", value, "contactExpireEnd");
            return (Criteria) this;
        }

        public Criteria andContactExpireEndLessThan(String value) {
            addCriterion("contact_expire_end <", value, "contactExpireEnd");
            return (Criteria) this;
        }

        public Criteria andContactExpireEndLessThanOrEqualTo(String value) {
            addCriterion("contact_expire_end <=", value, "contactExpireEnd");
            return (Criteria) this;
        }

        public Criteria andContactExpireEndLike(String value) {
            addCriterion("contact_expire_end like", value, "contactExpireEnd");
            return (Criteria) this;
        }

        public Criteria andContactExpireEndNotLike(String value) {
            addCriterion("contact_expire_end not like", value, "contactExpireEnd");
            return (Criteria) this;
        }

        public Criteria andContactExpireEndIn(List<String> values) {
            addCriterion("contact_expire_end in", values, "contactExpireEnd");
            return (Criteria) this;
        }

        public Criteria andContactExpireEndNotIn(List<String> values) {
            addCriterion("contact_expire_end not in", values, "contactExpireEnd");
            return (Criteria) this;
        }

        public Criteria andContactExpireEndBetween(String value1, String value2) {
            addCriterion("contact_expire_end between", value1, value2, "contactExpireEnd");
            return (Criteria) this;
        }

        public Criteria andContactExpireEndNotBetween(String value1, String value2) {
            addCriterion("contact_expire_end not between", value1, value2, "contactExpireEnd");
            return (Criteria) this;
        }

        public Criteria andContactAddressIsNull() {
            addCriterion("contact_address is null");
            return (Criteria) this;
        }

        public Criteria andContactAddressIsNotNull() {
            addCriterion("contact_address is not null");
            return (Criteria) this;
        }

        public Criteria andContactAddressEqualTo(String value) {
            addCriterion("contact_address =", value, "contactAddress");
            return (Criteria) this;
        }

        public Criteria andContactAddressNotEqualTo(String value) {
            addCriterion("contact_address <>", value, "contactAddress");
            return (Criteria) this;
        }

        public Criteria andContactAddressGreaterThan(String value) {
            addCriterion("contact_address >", value, "contactAddress");
            return (Criteria) this;
        }

        public Criteria andContactAddressGreaterThanOrEqualTo(String value) {
            addCriterion("contact_address >=", value, "contactAddress");
            return (Criteria) this;
        }

        public Criteria andContactAddressLessThan(String value) {
            addCriterion("contact_address <", value, "contactAddress");
            return (Criteria) this;
        }

        public Criteria andContactAddressLessThanOrEqualTo(String value) {
            addCriterion("contact_address <=", value, "contactAddress");
            return (Criteria) this;
        }

        public Criteria andContactAddressLike(String value) {
            addCriterion("contact_address like", value, "contactAddress");
            return (Criteria) this;
        }

        public Criteria andContactAddressNotLike(String value) {
            addCriterion("contact_address not like", value, "contactAddress");
            return (Criteria) this;
        }

        public Criteria andContactAddressIn(List<String> values) {
            addCriterion("contact_address in", values, "contactAddress");
            return (Criteria) this;
        }

        public Criteria andContactAddressNotIn(List<String> values) {
            addCriterion("contact_address not in", values, "contactAddress");
            return (Criteria) this;
        }

        public Criteria andContactAddressBetween(String value1, String value2) {
            addCriterion("contact_address between", value1, value2, "contactAddress");
            return (Criteria) this;
        }

        public Criteria andContactAddressNotBetween(String value1, String value2) {
            addCriterion("contact_address not between", value1, value2, "contactAddress");
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

        public Criteria andPassTimeIsNull() {
            addCriterion("pass_time is null");
            return (Criteria) this;
        }

        public Criteria andPassTimeIsNotNull() {
            addCriterion("pass_time is not null");
            return (Criteria) this;
        }

        public Criteria andPassTimeEqualTo(String value) {
            addCriterion("pass_time =", value, "passTime");
            return (Criteria) this;
        }

        public Criteria andPassTimeNotEqualTo(String value) {
            addCriterion("pass_time <>", value, "passTime");
            return (Criteria) this;
        }

        public Criteria andPassTimeGreaterThan(String value) {
            addCriterion("pass_time >", value, "passTime");
            return (Criteria) this;
        }

        public Criteria andPassTimeGreaterThanOrEqualTo(String value) {
            addCriterion("pass_time >=", value, "passTime");
            return (Criteria) this;
        }

        public Criteria andPassTimeLessThan(String value) {
            addCriterion("pass_time <", value, "passTime");
            return (Criteria) this;
        }

        public Criteria andPassTimeLessThanOrEqualTo(String value) {
            addCriterion("pass_time <=", value, "passTime");
            return (Criteria) this;
        }

        public Criteria andPassTimeLike(String value) {
            addCriterion("pass_time like", value, "passTime");
            return (Criteria) this;
        }

        public Criteria andPassTimeNotLike(String value) {
            addCriterion("pass_time not like", value, "passTime");
            return (Criteria) this;
        }

        public Criteria andPassTimeIn(List<String> values) {
            addCriterion("pass_time in", values, "passTime");
            return (Criteria) this;
        }

        public Criteria andPassTimeNotIn(List<String> values) {
            addCriterion("pass_time not in", values, "passTime");
            return (Criteria) this;
        }

        public Criteria andPassTimeBetween(String value1, String value2) {
            addCriterion("pass_time between", value1, value2, "passTime");
            return (Criteria) this;
        }

        public Criteria andPassTimeNotBetween(String value1, String value2) {
            addCriterion("pass_time not between", value1, value2, "passTime");
            return (Criteria) this;
        }

        public Criteria andMchSourceIsNull() {
            addCriterion("mch_source is null");
            return (Criteria) this;
        }

        public Criteria andMchSourceIsNotNull() {
            addCriterion("mch_source is not null");
            return (Criteria) this;
        }

        public Criteria andMchSourceEqualTo(String value) {
            addCriterion("mch_source =", value, "mchSource");
            return (Criteria) this;
        }

        public Criteria andMchSourceNotEqualTo(String value) {
            addCriterion("mch_source <>", value, "mchSource");
            return (Criteria) this;
        }

        public Criteria andMchSourceGreaterThan(String value) {
            addCriterion("mch_source >", value, "mchSource");
            return (Criteria) this;
        }

        public Criteria andMchSourceGreaterThanOrEqualTo(String value) {
            addCriterion("mch_source >=", value, "mchSource");
            return (Criteria) this;
        }

        public Criteria andMchSourceLessThan(String value) {
            addCriterion("mch_source <", value, "mchSource");
            return (Criteria) this;
        }

        public Criteria andMchSourceLessThanOrEqualTo(String value) {
            addCriterion("mch_source <=", value, "mchSource");
            return (Criteria) this;
        }

        public Criteria andMchSourceLike(String value) {
            addCriterion("mch_source like", value, "mchSource");
            return (Criteria) this;
        }

        public Criteria andMchSourceNotLike(String value) {
            addCriterion("mch_source not like", value, "mchSource");
            return (Criteria) this;
        }

        public Criteria andMchSourceIn(List<String> values) {
            addCriterion("mch_source in", values, "mchSource");
            return (Criteria) this;
        }

        public Criteria andMchSourceNotIn(List<String> values) {
            addCriterion("mch_source not in", values, "mchSource");
            return (Criteria) this;
        }

        public Criteria andMchSourceBetween(String value1, String value2) {
            addCriterion("mch_source between", value1, value2, "mchSource");
            return (Criteria) this;
        }

        public Criteria andMchSourceNotBetween(String value1, String value2) {
            addCriterion("mch_source not between", value1, value2, "mchSource");
            return (Criteria) this;
        }

        public Criteria andSettleCycleIsNull() {
            addCriterion("settle_cycle is null");
            return (Criteria) this;
        }

        public Criteria andSettleCycleIsNotNull() {
            addCriterion("settle_cycle is not null");
            return (Criteria) this;
        }

        public Criteria andSettleCycleEqualTo(String value) {
            addCriterion("settle_cycle =", value, "settleCycle");
            return (Criteria) this;
        }

        public Criteria andSettleCycleNotEqualTo(String value) {
            addCriterion("settle_cycle <>", value, "settleCycle");
            return (Criteria) this;
        }

        public Criteria andSettleCycleGreaterThan(String value) {
            addCriterion("settle_cycle >", value, "settleCycle");
            return (Criteria) this;
        }

        public Criteria andSettleCycleGreaterThanOrEqualTo(String value) {
            addCriterion("settle_cycle >=", value, "settleCycle");
            return (Criteria) this;
        }

        public Criteria andSettleCycleLessThan(String value) {
            addCriterion("settle_cycle <", value, "settleCycle");
            return (Criteria) this;
        }

        public Criteria andSettleCycleLessThanOrEqualTo(String value) {
            addCriterion("settle_cycle <=", value, "settleCycle");
            return (Criteria) this;
        }

        public Criteria andSettleCycleLike(String value) {
            addCriterion("settle_cycle like", value, "settleCycle");
            return (Criteria) this;
        }

        public Criteria andSettleCycleNotLike(String value) {
            addCriterion("settle_cycle not like", value, "settleCycle");
            return (Criteria) this;
        }

        public Criteria andSettleCycleIn(List<String> values) {
            addCriterion("settle_cycle in", values, "settleCycle");
            return (Criteria) this;
        }

        public Criteria andSettleCycleNotIn(List<String> values) {
            addCriterion("settle_cycle not in", values, "settleCycle");
            return (Criteria) this;
        }

        public Criteria andSettleCycleBetween(String value1, String value2) {
            addCriterion("settle_cycle between", value1, value2, "settleCycle");
            return (Criteria) this;
        }

        public Criteria andSettleCycleNotBetween(String value1, String value2) {
            addCriterion("settle_cycle not between", value1, value2, "settleCycle");
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

        public Criteria andOutMchNoLikeInsensitive(String value) {
            addCriterion("upper(out_mch_no) like", value.toUpperCase(), "outMchNo");
            return (Criteria) this;
        }

        public Criteria andMchNoLikeInsensitive(String value) {
            addCriterion("upper(mch_no) like", value.toUpperCase(), "mchNo");
            return (Criteria) this;
        }

        public Criteria andMchNameLikeInsensitive(String value) {
            addCriterion("upper(mch_name) like", value.toUpperCase(), "mchName");
            return (Criteria) this;
        }

        public Criteria andMchStatusLikeInsensitive(String value) {
            addCriterion("upper(mch_status) like", value.toUpperCase(), "mchStatus");
            return (Criteria) this;
        }

        public Criteria andMchTypeLikeInsensitive(String value) {
            addCriterion("upper(mch_type) like", value.toUpperCase(), "mchType");
            return (Criteria) this;
        }

        public Criteria andMchShortNameLikeInsensitive(String value) {
            addCriterion("upper(mch_short_name) like", value.toUpperCase(), "mchShortName");
            return (Criteria) this;
        }

        public Criteria andRegisterAddressLikeInsensitive(String value) {
            addCriterion("upper(register_address) like", value.toUpperCase(), "registerAddress");
            return (Criteria) this;
        }

        public Criteria andBusinessProviceCodeLikeInsensitive(String value) {
            addCriterion("upper(business_provice_code) like", value.toUpperCase(), "businessProviceCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCityCodeLikeInsensitive(String value) {
            addCriterion("upper(business_city_code) like", value.toUpperCase(), "businessCityCode");
            return (Criteria) this;
        }

        public Criteria andBusinessCountyCodeLikeInsensitive(String value) {
            addCriterion("upper(business_county_code) like", value.toUpperCase(), "businessCountyCode");
            return (Criteria) this;
        }

        public Criteria andBusinessAddressLikeInsensitive(String value) {
            addCriterion("upper(business_address) like", value.toUpperCase(), "businessAddress");
            return (Criteria) this;
        }

        public Criteria andBusinessAddressNameLikeInsensitive(String value) {
            addCriterion("upper(business_address_name) like", value.toUpperCase(), "businessAddressName");
            return (Criteria) this;
        }

        public Criteria andBusinessLicenseLikeInsensitive(String value) {
            addCriterion("upper(business_license) like", value.toUpperCase(), "businessLicense");
            return (Criteria) this;
        }

        public Criteria andBusinessAmtLikeInsensitive(String value) {
            addCriterion("upper(business_amt) like", value.toUpperCase(), "businessAmt");
            return (Criteria) this;
        }

        public Criteria andBusinessExpireStartLikeInsensitive(String value) {
            addCriterion("upper(business_expire_start) like", value.toUpperCase(), "businessExpireStart");
            return (Criteria) this;
        }

        public Criteria andBusinessExpireEndLikeInsensitive(String value) {
            addCriterion("upper(business_expire_end) like", value.toUpperCase(), "businessExpireEnd");
            return (Criteria) this;
        }

        public Criteria andBusinessInfoLikeInsensitive(String value) {
            addCriterion("upper(business_info) like", value.toUpperCase(), "businessInfo");
            return (Criteria) this;
        }

        public Criteria andEnterpriseCategoryLikeInsensitive(String value) {
            addCriterion("upper(enterprise_category) like", value.toUpperCase(), "enterpriseCategory");
            return (Criteria) this;
        }

        public Criteria andEnterpriseScaleLikeInsensitive(String value) {
            addCriterion("upper(enterprise_scale) like", value.toUpperCase(), "enterpriseScale");
            return (Criteria) this;
        }

        public Criteria andMccLikeInsensitive(String value) {
            addCriterion("upper(mcc) like", value.toUpperCase(), "mcc");
            return (Criteria) this;
        }

        public Criteria andLegalNameLikeInsensitive(String value) {
            addCriterion("upper(legal_name) like", value.toUpperCase(), "legalName");
            return (Criteria) this;
        }

        public Criteria andLegalCertTypeLikeInsensitive(String value) {
            addCriterion("upper(legal_cert_type) like", value.toUpperCase(), "legalCertType");
            return (Criteria) this;
        }

        public Criteria andLegalCertNoLikeInsensitive(String value) {
            addCriterion("upper(legal_cert_no) like", value.toUpperCase(), "legalCertNo");
            return (Criteria) this;
        }

        public Criteria andLegalPhoneLikeInsensitive(String value) {
            addCriterion("upper(legal_phone) like", value.toUpperCase(), "legalPhone");
            return (Criteria) this;
        }

        public Criteria andLegalExpireStartLikeInsensitive(String value) {
            addCriterion("upper(legal_expire_start) like", value.toUpperCase(), "legalExpireStart");
            return (Criteria) this;
        }

        public Criteria andLegalExpireEndLikeInsensitive(String value) {
            addCriterion("upper(legal_expire_end) like", value.toUpperCase(), "legalExpireEnd");
            return (Criteria) this;
        }

        public Criteria andLegalCertAddressLikeInsensitive(String value) {
            addCriterion("upper(legal_cert_address) like", value.toUpperCase(), "legalCertAddress");
            return (Criteria) this;
        }

        public Criteria andContactNameLikeInsensitive(String value) {
            addCriterion("upper(contact_name) like", value.toUpperCase(), "contactName");
            return (Criteria) this;
        }

        public Criteria andContactCertTypeLikeInsensitive(String value) {
            addCriterion("upper(contact_cert_type) like", value.toUpperCase(), "contactCertType");
            return (Criteria) this;
        }

        public Criteria andContactCertNoLikeInsensitive(String value) {
            addCriterion("upper(contact_cert_no) like", value.toUpperCase(), "contactCertNo");
            return (Criteria) this;
        }

        public Criteria andContactPhoneLikeInsensitive(String value) {
            addCriterion("upper(contact_phone) like", value.toUpperCase(), "contactPhone");
            return (Criteria) this;
        }

        public Criteria andContactExpireStartLikeInsensitive(String value) {
            addCriterion("upper(contact_expire_start) like", value.toUpperCase(), "contactExpireStart");
            return (Criteria) this;
        }

        public Criteria andContactExpireEndLikeInsensitive(String value) {
            addCriterion("upper(contact_expire_end) like", value.toUpperCase(), "contactExpireEnd");
            return (Criteria) this;
        }

        public Criteria andContactAddressLikeInsensitive(String value) {
            addCriterion("upper(contact_address) like", value.toUpperCase(), "contactAddress");
            return (Criteria) this;
        }

        public Criteria andContactEmailLikeInsensitive(String value) {
            addCriterion("upper(contact_email) like", value.toUpperCase(), "contactEmail");
            return (Criteria) this;
        }

        public Criteria andRemarkLikeInsensitive(String value) {
            addCriterion("upper(remark) like", value.toUpperCase(), "remark");
            return (Criteria) this;
        }

        public Criteria andCheckRemarkLikeInsensitive(String value) {
            addCriterion("upper(check_remark) like", value.toUpperCase(), "checkRemark");
            return (Criteria) this;
        }

        public Criteria andPassTimeLikeInsensitive(String value) {
            addCriterion("upper(pass_time) like", value.toUpperCase(), "passTime");
            return (Criteria) this;
        }

        public Criteria andMchSourceLikeInsensitive(String value) {
            addCriterion("upper(mch_source) like", value.toUpperCase(), "mchSource");
            return (Criteria) this;
        }

        public Criteria andSettleCycleLikeInsensitive(String value) {
            addCriterion("upper(settle_cycle) like", value.toUpperCase(), "settleCycle");
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