package com.jkf.channel.gateway.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AgentInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AgentInfoExample() {
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

        public Criteria andPAgentIdIsNull() {
            addCriterion("p_agent_id is null");
            return (Criteria) this;
        }

        public Criteria andPAgentIdIsNotNull() {
            addCriterion("p_agent_id is not null");
            return (Criteria) this;
        }

        public Criteria andPAgentIdEqualTo(Long value) {
            addCriterion("p_agent_id =", value, "pAgentId");
            return (Criteria) this;
        }

        public Criteria andPAgentIdNotEqualTo(Long value) {
            addCriterion("p_agent_id <>", value, "pAgentId");
            return (Criteria) this;
        }

        public Criteria andPAgentIdGreaterThan(Long value) {
            addCriterion("p_agent_id >", value, "pAgentId");
            return (Criteria) this;
        }

        public Criteria andPAgentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("p_agent_id >=", value, "pAgentId");
            return (Criteria) this;
        }

        public Criteria andPAgentIdLessThan(Long value) {
            addCriterion("p_agent_id <", value, "pAgentId");
            return (Criteria) this;
        }

        public Criteria andPAgentIdLessThanOrEqualTo(Long value) {
            addCriterion("p_agent_id <=", value, "pAgentId");
            return (Criteria) this;
        }

        public Criteria andPAgentIdIn(List<Long> values) {
            addCriterion("p_agent_id in", values, "pAgentId");
            return (Criteria) this;
        }

        public Criteria andPAgentIdNotIn(List<Long> values) {
            addCriterion("p_agent_id not in", values, "pAgentId");
            return (Criteria) this;
        }

        public Criteria andPAgentIdBetween(Long value1, Long value2) {
            addCriterion("p_agent_id between", value1, value2, "pAgentId");
            return (Criteria) this;
        }

        public Criteria andPAgentIdNotBetween(Long value1, Long value2) {
            addCriterion("p_agent_id not between", value1, value2, "pAgentId");
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

        public Criteria andOutAgentNoIsNull() {
            addCriterion("out_agent_no is null");
            return (Criteria) this;
        }

        public Criteria andOutAgentNoIsNotNull() {
            addCriterion("out_agent_no is not null");
            return (Criteria) this;
        }

        public Criteria andOutAgentNoEqualTo(String value) {
            addCriterion("out_agent_no =", value, "outAgentNo");
            return (Criteria) this;
        }

        public Criteria andOutAgentNoNotEqualTo(String value) {
            addCriterion("out_agent_no <>", value, "outAgentNo");
            return (Criteria) this;
        }

        public Criteria andOutAgentNoGreaterThan(String value) {
            addCriterion("out_agent_no >", value, "outAgentNo");
            return (Criteria) this;
        }

        public Criteria andOutAgentNoGreaterThanOrEqualTo(String value) {
            addCriterion("out_agent_no >=", value, "outAgentNo");
            return (Criteria) this;
        }

        public Criteria andOutAgentNoLessThan(String value) {
            addCriterion("out_agent_no <", value, "outAgentNo");
            return (Criteria) this;
        }

        public Criteria andOutAgentNoLessThanOrEqualTo(String value) {
            addCriterion("out_agent_no <=", value, "outAgentNo");
            return (Criteria) this;
        }

        public Criteria andOutAgentNoLike(String value) {
            addCriterion("out_agent_no like", value, "outAgentNo");
            return (Criteria) this;
        }

        public Criteria andOutAgentNoNotLike(String value) {
            addCriterion("out_agent_no not like", value, "outAgentNo");
            return (Criteria) this;
        }

        public Criteria andOutAgentNoIn(List<String> values) {
            addCriterion("out_agent_no in", values, "outAgentNo");
            return (Criteria) this;
        }

        public Criteria andOutAgentNoNotIn(List<String> values) {
            addCriterion("out_agent_no not in", values, "outAgentNo");
            return (Criteria) this;
        }

        public Criteria andOutAgentNoBetween(String value1, String value2) {
            addCriterion("out_agent_no between", value1, value2, "outAgentNo");
            return (Criteria) this;
        }

        public Criteria andOutAgentNoNotBetween(String value1, String value2) {
            addCriterion("out_agent_no not between", value1, value2, "outAgentNo");
            return (Criteria) this;
        }

        public Criteria andAgentNoIsNull() {
            addCriterion("agent_no is null");
            return (Criteria) this;
        }

        public Criteria andAgentNoIsNotNull() {
            addCriterion("agent_no is not null");
            return (Criteria) this;
        }

        public Criteria andAgentNoEqualTo(String value) {
            addCriterion("agent_no =", value, "agentNo");
            return (Criteria) this;
        }

        public Criteria andAgentNoNotEqualTo(String value) {
            addCriterion("agent_no <>", value, "agentNo");
            return (Criteria) this;
        }

        public Criteria andAgentNoGreaterThan(String value) {
            addCriterion("agent_no >", value, "agentNo");
            return (Criteria) this;
        }

        public Criteria andAgentNoGreaterThanOrEqualTo(String value) {
            addCriterion("agent_no >=", value, "agentNo");
            return (Criteria) this;
        }

        public Criteria andAgentNoLessThan(String value) {
            addCriterion("agent_no <", value, "agentNo");
            return (Criteria) this;
        }

        public Criteria andAgentNoLessThanOrEqualTo(String value) {
            addCriterion("agent_no <=", value, "agentNo");
            return (Criteria) this;
        }

        public Criteria andAgentNoLike(String value) {
            addCriterion("agent_no like", value, "agentNo");
            return (Criteria) this;
        }

        public Criteria andAgentNoNotLike(String value) {
            addCriterion("agent_no not like", value, "agentNo");
            return (Criteria) this;
        }

        public Criteria andAgentNoIn(List<String> values) {
            addCriterion("agent_no in", values, "agentNo");
            return (Criteria) this;
        }

        public Criteria andAgentNoNotIn(List<String> values) {
            addCriterion("agent_no not in", values, "agentNo");
            return (Criteria) this;
        }

        public Criteria andAgentNoBetween(String value1, String value2) {
            addCriterion("agent_no between", value1, value2, "agentNo");
            return (Criteria) this;
        }

        public Criteria andAgentNoNotBetween(String value1, String value2) {
            addCriterion("agent_no not between", value1, value2, "agentNo");
            return (Criteria) this;
        }

        public Criteria andAgentNameIsNull() {
            addCriterion("agent_name is null");
            return (Criteria) this;
        }

        public Criteria andAgentNameIsNotNull() {
            addCriterion("agent_name is not null");
            return (Criteria) this;
        }

        public Criteria andAgentNameEqualTo(String value) {
            addCriterion("agent_name =", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameNotEqualTo(String value) {
            addCriterion("agent_name <>", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameGreaterThan(String value) {
            addCriterion("agent_name >", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameGreaterThanOrEqualTo(String value) {
            addCriterion("agent_name >=", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameLessThan(String value) {
            addCriterion("agent_name <", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameLessThanOrEqualTo(String value) {
            addCriterion("agent_name <=", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameLike(String value) {
            addCriterion("agent_name like", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameNotLike(String value) {
            addCriterion("agent_name not like", value, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameIn(List<String> values) {
            addCriterion("agent_name in", values, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameNotIn(List<String> values) {
            addCriterion("agent_name not in", values, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameBetween(String value1, String value2) {
            addCriterion("agent_name between", value1, value2, "agentName");
            return (Criteria) this;
        }

        public Criteria andAgentNameNotBetween(String value1, String value2) {
            addCriterion("agent_name not between", value1, value2, "agentName");
            return (Criteria) this;
        }

        public Criteria andProviceCodeIsNull() {
            addCriterion("provice_code is null");
            return (Criteria) this;
        }

        public Criteria andProviceCodeIsNotNull() {
            addCriterion("provice_code is not null");
            return (Criteria) this;
        }

        public Criteria andProviceCodeEqualTo(String value) {
            addCriterion("provice_code =", value, "proviceCode");
            return (Criteria) this;
        }

        public Criteria andProviceCodeNotEqualTo(String value) {
            addCriterion("provice_code <>", value, "proviceCode");
            return (Criteria) this;
        }

        public Criteria andProviceCodeGreaterThan(String value) {
            addCriterion("provice_code >", value, "proviceCode");
            return (Criteria) this;
        }

        public Criteria andProviceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("provice_code >=", value, "proviceCode");
            return (Criteria) this;
        }

        public Criteria andProviceCodeLessThan(String value) {
            addCriterion("provice_code <", value, "proviceCode");
            return (Criteria) this;
        }

        public Criteria andProviceCodeLessThanOrEqualTo(String value) {
            addCriterion("provice_code <=", value, "proviceCode");
            return (Criteria) this;
        }

        public Criteria andProviceCodeLike(String value) {
            addCriterion("provice_code like", value, "proviceCode");
            return (Criteria) this;
        }

        public Criteria andProviceCodeNotLike(String value) {
            addCriterion("provice_code not like", value, "proviceCode");
            return (Criteria) this;
        }

        public Criteria andProviceCodeIn(List<String> values) {
            addCriterion("provice_code in", values, "proviceCode");
            return (Criteria) this;
        }

        public Criteria andProviceCodeNotIn(List<String> values) {
            addCriterion("provice_code not in", values, "proviceCode");
            return (Criteria) this;
        }

        public Criteria andProviceCodeBetween(String value1, String value2) {
            addCriterion("provice_code between", value1, value2, "proviceCode");
            return (Criteria) this;
        }

        public Criteria andProviceCodeNotBetween(String value1, String value2) {
            addCriterion("provice_code not between", value1, value2, "proviceCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeIsNull() {
            addCriterion("city_code is null");
            return (Criteria) this;
        }

        public Criteria andCityCodeIsNotNull() {
            addCriterion("city_code is not null");
            return (Criteria) this;
        }

        public Criteria andCityCodeEqualTo(String value) {
            addCriterion("city_code =", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotEqualTo(String value) {
            addCriterion("city_code <>", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThan(String value) {
            addCriterion("city_code >", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThanOrEqualTo(String value) {
            addCriterion("city_code >=", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThan(String value) {
            addCriterion("city_code <", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThanOrEqualTo(String value) {
            addCriterion("city_code <=", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLike(String value) {
            addCriterion("city_code like", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotLike(String value) {
            addCriterion("city_code not like", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeIn(List<String> values) {
            addCriterion("city_code in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotIn(List<String> values) {
            addCriterion("city_code not in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeBetween(String value1, String value2) {
            addCriterion("city_code between", value1, value2, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotBetween(String value1, String value2) {
            addCriterion("city_code not between", value1, value2, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeIsNull() {
            addCriterion("country_code is null");
            return (Criteria) this;
        }

        public Criteria andCountryCodeIsNotNull() {
            addCriterion("country_code is not null");
            return (Criteria) this;
        }

        public Criteria andCountryCodeEqualTo(String value) {
            addCriterion("country_code =", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeNotEqualTo(String value) {
            addCriterion("country_code <>", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeGreaterThan(String value) {
            addCriterion("country_code >", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeGreaterThanOrEqualTo(String value) {
            addCriterion("country_code >=", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeLessThan(String value) {
            addCriterion("country_code <", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeLessThanOrEqualTo(String value) {
            addCriterion("country_code <=", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeLike(String value) {
            addCriterion("country_code like", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeNotLike(String value) {
            addCriterion("country_code not like", value, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeIn(List<String> values) {
            addCriterion("country_code in", values, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeNotIn(List<String> values) {
            addCriterion("country_code not in", values, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeBetween(String value1, String value2) {
            addCriterion("country_code between", value1, value2, "countryCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeNotBetween(String value1, String value2) {
            addCriterion("country_code not between", value1, value2, "countryCode");
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

        public Criteria andAgentTypeIsNull() {
            addCriterion("agent_type is null");
            return (Criteria) this;
        }

        public Criteria andAgentTypeIsNotNull() {
            addCriterion("agent_type is not null");
            return (Criteria) this;
        }

        public Criteria andAgentTypeEqualTo(String value) {
            addCriterion("agent_type =", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeNotEqualTo(String value) {
            addCriterion("agent_type <>", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeGreaterThan(String value) {
            addCriterion("agent_type >", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeGreaterThanOrEqualTo(String value) {
            addCriterion("agent_type >=", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeLessThan(String value) {
            addCriterion("agent_type <", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeLessThanOrEqualTo(String value) {
            addCriterion("agent_type <=", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeLike(String value) {
            addCriterion("agent_type like", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeNotLike(String value) {
            addCriterion("agent_type not like", value, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeIn(List<String> values) {
            addCriterion("agent_type in", values, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeNotIn(List<String> values) {
            addCriterion("agent_type not in", values, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeBetween(String value1, String value2) {
            addCriterion("agent_type between", value1, value2, "agentType");
            return (Criteria) this;
        }

        public Criteria andAgentTypeNotBetween(String value1, String value2) {
            addCriterion("agent_type not between", value1, value2, "agentType");
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

        public Criteria andAgentNatureIsNull() {
            addCriterion("agent_nature is null");
            return (Criteria) this;
        }

        public Criteria andAgentNatureIsNotNull() {
            addCriterion("agent_nature is not null");
            return (Criteria) this;
        }

        public Criteria andAgentNatureEqualTo(String value) {
            addCriterion("agent_nature =", value, "agentNature");
            return (Criteria) this;
        }

        public Criteria andAgentNatureNotEqualTo(String value) {
            addCriterion("agent_nature <>", value, "agentNature");
            return (Criteria) this;
        }

        public Criteria andAgentNatureGreaterThan(String value) {
            addCriterion("agent_nature >", value, "agentNature");
            return (Criteria) this;
        }

        public Criteria andAgentNatureGreaterThanOrEqualTo(String value) {
            addCriterion("agent_nature >=", value, "agentNature");
            return (Criteria) this;
        }

        public Criteria andAgentNatureLessThan(String value) {
            addCriterion("agent_nature <", value, "agentNature");
            return (Criteria) this;
        }

        public Criteria andAgentNatureLessThanOrEqualTo(String value) {
            addCriterion("agent_nature <=", value, "agentNature");
            return (Criteria) this;
        }

        public Criteria andAgentNatureLike(String value) {
            addCriterion("agent_nature like", value, "agentNature");
            return (Criteria) this;
        }

        public Criteria andAgentNatureNotLike(String value) {
            addCriterion("agent_nature not like", value, "agentNature");
            return (Criteria) this;
        }

        public Criteria andAgentNatureIn(List<String> values) {
            addCriterion("agent_nature in", values, "agentNature");
            return (Criteria) this;
        }

        public Criteria andAgentNatureNotIn(List<String> values) {
            addCriterion("agent_nature not in", values, "agentNature");
            return (Criteria) this;
        }

        public Criteria andAgentNatureBetween(String value1, String value2) {
            addCriterion("agent_nature between", value1, value2, "agentNature");
            return (Criteria) this;
        }

        public Criteria andAgentNatureNotBetween(String value1, String value2) {
            addCriterion("agent_nature not between", value1, value2, "agentNature");
            return (Criteria) this;
        }

        public Criteria andAgentLevelIsNull() {
            addCriterion("agent_level is null");
            return (Criteria) this;
        }

        public Criteria andAgentLevelIsNotNull() {
            addCriterion("agent_level is not null");
            return (Criteria) this;
        }

        public Criteria andAgentLevelEqualTo(String value) {
            addCriterion("agent_level =", value, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelNotEqualTo(String value) {
            addCriterion("agent_level <>", value, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelGreaterThan(String value) {
            addCriterion("agent_level >", value, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelGreaterThanOrEqualTo(String value) {
            addCriterion("agent_level >=", value, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelLessThan(String value) {
            addCriterion("agent_level <", value, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelLessThanOrEqualTo(String value) {
            addCriterion("agent_level <=", value, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelLike(String value) {
            addCriterion("agent_level like", value, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelNotLike(String value) {
            addCriterion("agent_level not like", value, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelIn(List<String> values) {
            addCriterion("agent_level in", values, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelNotIn(List<String> values) {
            addCriterion("agent_level not in", values, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelBetween(String value1, String value2) {
            addCriterion("agent_level between", value1, value2, "agentLevel");
            return (Criteria) this;
        }

        public Criteria andAgentLevelNotBetween(String value1, String value2) {
            addCriterion("agent_level not between", value1, value2, "agentLevel");
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

        public Criteria andOutAgentNoLikeInsensitive(String value) {
            addCriterion("upper(out_agent_no) like", value.toUpperCase(), "outAgentNo");
            return (Criteria) this;
        }

        public Criteria andAgentNoLikeInsensitive(String value) {
            addCriterion("upper(agent_no) like", value.toUpperCase(), "agentNo");
            return (Criteria) this;
        }

        public Criteria andAgentNameLikeInsensitive(String value) {
            addCriterion("upper(agent_name) like", value.toUpperCase(), "agentName");
            return (Criteria) this;
        }

        public Criteria andProviceCodeLikeInsensitive(String value) {
            addCriterion("upper(provice_code) like", value.toUpperCase(), "proviceCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLikeInsensitive(String value) {
            addCriterion("upper(city_code) like", value.toUpperCase(), "cityCode");
            return (Criteria) this;
        }

        public Criteria andCountryCodeLikeInsensitive(String value) {
            addCriterion("upper(country_code) like", value.toUpperCase(), "countryCode");
            return (Criteria) this;
        }

        public Criteria andAddressLikeInsensitive(String value) {
            addCriterion("upper(address) like", value.toUpperCase(), "address");
            return (Criteria) this;
        }

        public Criteria andAgentTypeLikeInsensitive(String value) {
            addCriterion("upper(agent_type) like", value.toUpperCase(), "agentType");
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

        public Criteria andContactEmailLikeInsensitive(String value) {
            addCriterion("upper(contact_email) like", value.toUpperCase(), "contactEmail");
            return (Criteria) this;
        }

        public Criteria andStatusLikeInsensitive(String value) {
            addCriterion("upper(`status`) like", value.toUpperCase(), "status");
            return (Criteria) this;
        }

        public Criteria andCheckRemarkLikeInsensitive(String value) {
            addCriterion("upper(check_remark) like", value.toUpperCase(), "checkRemark");
            return (Criteria) this;
        }

        public Criteria andAgentNatureLikeInsensitive(String value) {
            addCriterion("upper(agent_nature) like", value.toUpperCase(), "agentNature");
            return (Criteria) this;
        }

        public Criteria andAgentLevelLikeInsensitive(String value) {
            addCriterion("upper(agent_level) like", value.toUpperCase(), "agentLevel");
            return (Criteria) this;
        }

        public Criteria andVirtualNoLikeInsensitive(String value) {
            addCriterion("upper(virtual_no) like", value.toUpperCase(), "virtualNo");
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