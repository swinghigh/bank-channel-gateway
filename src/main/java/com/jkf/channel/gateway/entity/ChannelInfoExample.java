package com.jkf.channel.gateway.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChannelInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChannelInfoExample() {
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

        public Criteria andChannelNoIsNull() {
            addCriterion("channel_no is null");
            return (Criteria) this;
        }

        public Criteria andChannelNoIsNotNull() {
            addCriterion("channel_no is not null");
            return (Criteria) this;
        }

        public Criteria andChannelNoEqualTo(String value) {
            addCriterion("channel_no =", value, "channelNo");
            return (Criteria) this;
        }

        public Criteria andChannelNoNotEqualTo(String value) {
            addCriterion("channel_no <>", value, "channelNo");
            return (Criteria) this;
        }

        public Criteria andChannelNoGreaterThan(String value) {
            addCriterion("channel_no >", value, "channelNo");
            return (Criteria) this;
        }

        public Criteria andChannelNoGreaterThanOrEqualTo(String value) {
            addCriterion("channel_no >=", value, "channelNo");
            return (Criteria) this;
        }

        public Criteria andChannelNoLessThan(String value) {
            addCriterion("channel_no <", value, "channelNo");
            return (Criteria) this;
        }

        public Criteria andChannelNoLessThanOrEqualTo(String value) {
            addCriterion("channel_no <=", value, "channelNo");
            return (Criteria) this;
        }

        public Criteria andChannelNoLike(String value) {
            addCriterion("channel_no like", value, "channelNo");
            return (Criteria) this;
        }

        public Criteria andChannelNoNotLike(String value) {
            addCriterion("channel_no not like", value, "channelNo");
            return (Criteria) this;
        }

        public Criteria andChannelNoIn(List<String> values) {
            addCriterion("channel_no in", values, "channelNo");
            return (Criteria) this;
        }

        public Criteria andChannelNoNotIn(List<String> values) {
            addCriterion("channel_no not in", values, "channelNo");
            return (Criteria) this;
        }

        public Criteria andChannelNoBetween(String value1, String value2) {
            addCriterion("channel_no between", value1, value2, "channelNo");
            return (Criteria) this;
        }

        public Criteria andChannelNoNotBetween(String value1, String value2) {
            addCriterion("channel_no not between", value1, value2, "channelNo");
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

        public Criteria andChannelcompanyNoIsNull() {
            addCriterion("channelcompany_no is null");
            return (Criteria) this;
        }

        public Criteria andChannelcompanyNoIsNotNull() {
            addCriterion("channelcompany_no is not null");
            return (Criteria) this;
        }

        public Criteria andChannelcompanyNoEqualTo(String value) {
            addCriterion("channelcompany_no =", value, "channelcompanyNo");
            return (Criteria) this;
        }

        public Criteria andChannelcompanyNoNotEqualTo(String value) {
            addCriterion("channelcompany_no <>", value, "channelcompanyNo");
            return (Criteria) this;
        }

        public Criteria andChannelcompanyNoGreaterThan(String value) {
            addCriterion("channelcompany_no >", value, "channelcompanyNo");
            return (Criteria) this;
        }

        public Criteria andChannelcompanyNoGreaterThanOrEqualTo(String value) {
            addCriterion("channelcompany_no >=", value, "channelcompanyNo");
            return (Criteria) this;
        }

        public Criteria andChannelcompanyNoLessThan(String value) {
            addCriterion("channelcompany_no <", value, "channelcompanyNo");
            return (Criteria) this;
        }

        public Criteria andChannelcompanyNoLessThanOrEqualTo(String value) {
            addCriterion("channelcompany_no <=", value, "channelcompanyNo");
            return (Criteria) this;
        }

        public Criteria andChannelcompanyNoLike(String value) {
            addCriterion("channelcompany_no like", value, "channelcompanyNo");
            return (Criteria) this;
        }

        public Criteria andChannelcompanyNoNotLike(String value) {
            addCriterion("channelcompany_no not like", value, "channelcompanyNo");
            return (Criteria) this;
        }

        public Criteria andChannelcompanyNoIn(List<String> values) {
            addCriterion("channelcompany_no in", values, "channelcompanyNo");
            return (Criteria) this;
        }

        public Criteria andChannelcompanyNoNotIn(List<String> values) {
            addCriterion("channelcompany_no not in", values, "channelcompanyNo");
            return (Criteria) this;
        }

        public Criteria andChannelcompanyNoBetween(String value1, String value2) {
            addCriterion("channelcompany_no between", value1, value2, "channelcompanyNo");
            return (Criteria) this;
        }

        public Criteria andChannelcompanyNoNotBetween(String value1, String value2) {
            addCriterion("channelcompany_no not between", value1, value2, "channelcompanyNo");
            return (Criteria) this;
        }

        public Criteria andChannelCompanyNameIsNull() {
            addCriterion("channel_company_name is null");
            return (Criteria) this;
        }

        public Criteria andChannelCompanyNameIsNotNull() {
            addCriterion("channel_company_name is not null");
            return (Criteria) this;
        }

        public Criteria andChannelCompanyNameEqualTo(String value) {
            addCriterion("channel_company_name =", value, "channelCompanyName");
            return (Criteria) this;
        }

        public Criteria andChannelCompanyNameNotEqualTo(String value) {
            addCriterion("channel_company_name <>", value, "channelCompanyName");
            return (Criteria) this;
        }

        public Criteria andChannelCompanyNameGreaterThan(String value) {
            addCriterion("channel_company_name >", value, "channelCompanyName");
            return (Criteria) this;
        }

        public Criteria andChannelCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("channel_company_name >=", value, "channelCompanyName");
            return (Criteria) this;
        }

        public Criteria andChannelCompanyNameLessThan(String value) {
            addCriterion("channel_company_name <", value, "channelCompanyName");
            return (Criteria) this;
        }

        public Criteria andChannelCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("channel_company_name <=", value, "channelCompanyName");
            return (Criteria) this;
        }

        public Criteria andChannelCompanyNameLike(String value) {
            addCriterion("channel_company_name like", value, "channelCompanyName");
            return (Criteria) this;
        }

        public Criteria andChannelCompanyNameNotLike(String value) {
            addCriterion("channel_company_name not like", value, "channelCompanyName");
            return (Criteria) this;
        }

        public Criteria andChannelCompanyNameIn(List<String> values) {
            addCriterion("channel_company_name in", values, "channelCompanyName");
            return (Criteria) this;
        }

        public Criteria andChannelCompanyNameNotIn(List<String> values) {
            addCriterion("channel_company_name not in", values, "channelCompanyName");
            return (Criteria) this;
        }

        public Criteria andChannelCompanyNameBetween(String value1, String value2) {
            addCriterion("channel_company_name between", value1, value2, "channelCompanyName");
            return (Criteria) this;
        }

        public Criteria andChannelCompanyNameNotBetween(String value1, String value2) {
            addCriterion("channel_company_name not between", value1, value2, "channelCompanyName");
            return (Criteria) this;
        }

        public Criteria andChannelContactIsNull() {
            addCriterion("channel_contact is null");
            return (Criteria) this;
        }

        public Criteria andChannelContactIsNotNull() {
            addCriterion("channel_contact is not null");
            return (Criteria) this;
        }

        public Criteria andChannelContactEqualTo(String value) {
            addCriterion("channel_contact =", value, "channelContact");
            return (Criteria) this;
        }

        public Criteria andChannelContactNotEqualTo(String value) {
            addCriterion("channel_contact <>", value, "channelContact");
            return (Criteria) this;
        }

        public Criteria andChannelContactGreaterThan(String value) {
            addCriterion("channel_contact >", value, "channelContact");
            return (Criteria) this;
        }

        public Criteria andChannelContactGreaterThanOrEqualTo(String value) {
            addCriterion("channel_contact >=", value, "channelContact");
            return (Criteria) this;
        }

        public Criteria andChannelContactLessThan(String value) {
            addCriterion("channel_contact <", value, "channelContact");
            return (Criteria) this;
        }

        public Criteria andChannelContactLessThanOrEqualTo(String value) {
            addCriterion("channel_contact <=", value, "channelContact");
            return (Criteria) this;
        }

        public Criteria andChannelContactLike(String value) {
            addCriterion("channel_contact like", value, "channelContact");
            return (Criteria) this;
        }

        public Criteria andChannelContactNotLike(String value) {
            addCriterion("channel_contact not like", value, "channelContact");
            return (Criteria) this;
        }

        public Criteria andChannelContactIn(List<String> values) {
            addCriterion("channel_contact in", values, "channelContact");
            return (Criteria) this;
        }

        public Criteria andChannelContactNotIn(List<String> values) {
            addCriterion("channel_contact not in", values, "channelContact");
            return (Criteria) this;
        }

        public Criteria andChannelContactBetween(String value1, String value2) {
            addCriterion("channel_contact between", value1, value2, "channelContact");
            return (Criteria) this;
        }

        public Criteria andChannelContactNotBetween(String value1, String value2) {
            addCriterion("channel_contact not between", value1, value2, "channelContact");
            return (Criteria) this;
        }

        public Criteria andChannelPrivateKeyIsNull() {
            addCriterion("channel_private_key is null");
            return (Criteria) this;
        }

        public Criteria andChannelPrivateKeyIsNotNull() {
            addCriterion("channel_private_key is not null");
            return (Criteria) this;
        }

        public Criteria andChannelPrivateKeyEqualTo(String value) {
            addCriterion("channel_private_key =", value, "channelPrivateKey");
            return (Criteria) this;
        }

        public Criteria andChannelPrivateKeyNotEqualTo(String value) {
            addCriterion("channel_private_key <>", value, "channelPrivateKey");
            return (Criteria) this;
        }

        public Criteria andChannelPrivateKeyGreaterThan(String value) {
            addCriterion("channel_private_key >", value, "channelPrivateKey");
            return (Criteria) this;
        }

        public Criteria andChannelPrivateKeyGreaterThanOrEqualTo(String value) {
            addCriterion("channel_private_key >=", value, "channelPrivateKey");
            return (Criteria) this;
        }

        public Criteria andChannelPrivateKeyLessThan(String value) {
            addCriterion("channel_private_key <", value, "channelPrivateKey");
            return (Criteria) this;
        }

        public Criteria andChannelPrivateKeyLessThanOrEqualTo(String value) {
            addCriterion("channel_private_key <=", value, "channelPrivateKey");
            return (Criteria) this;
        }

        public Criteria andChannelPrivateKeyLike(String value) {
            addCriterion("channel_private_key like", value, "channelPrivateKey");
            return (Criteria) this;
        }

        public Criteria andChannelPrivateKeyNotLike(String value) {
            addCriterion("channel_private_key not like", value, "channelPrivateKey");
            return (Criteria) this;
        }

        public Criteria andChannelPrivateKeyIn(List<String> values) {
            addCriterion("channel_private_key in", values, "channelPrivateKey");
            return (Criteria) this;
        }

        public Criteria andChannelPrivateKeyNotIn(List<String> values) {
            addCriterion("channel_private_key not in", values, "channelPrivateKey");
            return (Criteria) this;
        }

        public Criteria andChannelPrivateKeyBetween(String value1, String value2) {
            addCriterion("channel_private_key between", value1, value2, "channelPrivateKey");
            return (Criteria) this;
        }

        public Criteria andChannelPrivateKeyNotBetween(String value1, String value2) {
            addCriterion("channel_private_key not between", value1, value2, "channelPrivateKey");
            return (Criteria) this;
        }

        public Criteria andChannelPublicKeyIsNull() {
            addCriterion("channel_public_key is null");
            return (Criteria) this;
        }

        public Criteria andChannelPublicKeyIsNotNull() {
            addCriterion("channel_public_key is not null");
            return (Criteria) this;
        }

        public Criteria andChannelPublicKeyEqualTo(String value) {
            addCriterion("channel_public_key =", value, "channelPublicKey");
            return (Criteria) this;
        }

        public Criteria andChannelPublicKeyNotEqualTo(String value) {
            addCriterion("channel_public_key <>", value, "channelPublicKey");
            return (Criteria) this;
        }

        public Criteria andChannelPublicKeyGreaterThan(String value) {
            addCriterion("channel_public_key >", value, "channelPublicKey");
            return (Criteria) this;
        }

        public Criteria andChannelPublicKeyGreaterThanOrEqualTo(String value) {
            addCriterion("channel_public_key >=", value, "channelPublicKey");
            return (Criteria) this;
        }

        public Criteria andChannelPublicKeyLessThan(String value) {
            addCriterion("channel_public_key <", value, "channelPublicKey");
            return (Criteria) this;
        }

        public Criteria andChannelPublicKeyLessThanOrEqualTo(String value) {
            addCriterion("channel_public_key <=", value, "channelPublicKey");
            return (Criteria) this;
        }

        public Criteria andChannelPublicKeyLike(String value) {
            addCriterion("channel_public_key like", value, "channelPublicKey");
            return (Criteria) this;
        }

        public Criteria andChannelPublicKeyNotLike(String value) {
            addCriterion("channel_public_key not like", value, "channelPublicKey");
            return (Criteria) this;
        }

        public Criteria andChannelPublicKeyIn(List<String> values) {
            addCriterion("channel_public_key in", values, "channelPublicKey");
            return (Criteria) this;
        }

        public Criteria andChannelPublicKeyNotIn(List<String> values) {
            addCriterion("channel_public_key not in", values, "channelPublicKey");
            return (Criteria) this;
        }

        public Criteria andChannelPublicKeyBetween(String value1, String value2) {
            addCriterion("channel_public_key between", value1, value2, "channelPublicKey");
            return (Criteria) this;
        }

        public Criteria andChannelPublicKeyNotBetween(String value1, String value2) {
            addCriterion("channel_public_key not between", value1, value2, "channelPublicKey");
            return (Criteria) this;
        }

        public Criteria andChannelCompanyPublicKeyIsNull() {
            addCriterion("channel_company_public_key is null");
            return (Criteria) this;
        }

        public Criteria andChannelCompanyPublicKeyIsNotNull() {
            addCriterion("channel_company_public_key is not null");
            return (Criteria) this;
        }

        public Criteria andChannelCompanyPublicKeyEqualTo(String value) {
            addCriterion("channel_company_public_key =", value, "channelCompanyPublicKey");
            return (Criteria) this;
        }

        public Criteria andChannelCompanyPublicKeyNotEqualTo(String value) {
            addCriterion("channel_company_public_key <>", value, "channelCompanyPublicKey");
            return (Criteria) this;
        }

        public Criteria andChannelCompanyPublicKeyGreaterThan(String value) {
            addCriterion("channel_company_public_key >", value, "channelCompanyPublicKey");
            return (Criteria) this;
        }

        public Criteria andChannelCompanyPublicKeyGreaterThanOrEqualTo(String value) {
            addCriterion("channel_company_public_key >=", value, "channelCompanyPublicKey");
            return (Criteria) this;
        }

        public Criteria andChannelCompanyPublicKeyLessThan(String value) {
            addCriterion("channel_company_public_key <", value, "channelCompanyPublicKey");
            return (Criteria) this;
        }

        public Criteria andChannelCompanyPublicKeyLessThanOrEqualTo(String value) {
            addCriterion("channel_company_public_key <=", value, "channelCompanyPublicKey");
            return (Criteria) this;
        }

        public Criteria andChannelCompanyPublicKeyLike(String value) {
            addCriterion("channel_company_public_key like", value, "channelCompanyPublicKey");
            return (Criteria) this;
        }

        public Criteria andChannelCompanyPublicKeyNotLike(String value) {
            addCriterion("channel_company_public_key not like", value, "channelCompanyPublicKey");
            return (Criteria) this;
        }

        public Criteria andChannelCompanyPublicKeyIn(List<String> values) {
            addCriterion("channel_company_public_key in", values, "channelCompanyPublicKey");
            return (Criteria) this;
        }

        public Criteria andChannelCompanyPublicKeyNotIn(List<String> values) {
            addCriterion("channel_company_public_key not in", values, "channelCompanyPublicKey");
            return (Criteria) this;
        }

        public Criteria andChannelCompanyPublicKeyBetween(String value1, String value2) {
            addCriterion("channel_company_public_key between", value1, value2, "channelCompanyPublicKey");
            return (Criteria) this;
        }

        public Criteria andChannelCompanyPublicKeyNotBetween(String value1, String value2) {
            addCriterion("channel_company_public_key not between", value1, value2, "channelCompanyPublicKey");
            return (Criteria) this;
        }

        public Criteria andChannelSaltKeyIsNull() {
            addCriterion("channel_salt_key is null");
            return (Criteria) this;
        }

        public Criteria andChannelSaltKeyIsNotNull() {
            addCriterion("channel_salt_key is not null");
            return (Criteria) this;
        }

        public Criteria andChannelSaltKeyEqualTo(String value) {
            addCriterion("channel_salt_key =", value, "channelSaltKey");
            return (Criteria) this;
        }

        public Criteria andChannelSaltKeyNotEqualTo(String value) {
            addCriterion("channel_salt_key <>", value, "channelSaltKey");
            return (Criteria) this;
        }

        public Criteria andChannelSaltKeyGreaterThan(String value) {
            addCriterion("channel_salt_key >", value, "channelSaltKey");
            return (Criteria) this;
        }

        public Criteria andChannelSaltKeyGreaterThanOrEqualTo(String value) {
            addCriterion("channel_salt_key >=", value, "channelSaltKey");
            return (Criteria) this;
        }

        public Criteria andChannelSaltKeyLessThan(String value) {
            addCriterion("channel_salt_key <", value, "channelSaltKey");
            return (Criteria) this;
        }

        public Criteria andChannelSaltKeyLessThanOrEqualTo(String value) {
            addCriterion("channel_salt_key <=", value, "channelSaltKey");
            return (Criteria) this;
        }

        public Criteria andChannelSaltKeyLike(String value) {
            addCriterion("channel_salt_key like", value, "channelSaltKey");
            return (Criteria) this;
        }

        public Criteria andChannelSaltKeyNotLike(String value) {
            addCriterion("channel_salt_key not like", value, "channelSaltKey");
            return (Criteria) this;
        }

        public Criteria andChannelSaltKeyIn(List<String> values) {
            addCriterion("channel_salt_key in", values, "channelSaltKey");
            return (Criteria) this;
        }

        public Criteria andChannelSaltKeyNotIn(List<String> values) {
            addCriterion("channel_salt_key not in", values, "channelSaltKey");
            return (Criteria) this;
        }

        public Criteria andChannelSaltKeyBetween(String value1, String value2) {
            addCriterion("channel_salt_key between", value1, value2, "channelSaltKey");
            return (Criteria) this;
        }

        public Criteria andChannelSaltKeyNotBetween(String value1, String value2) {
            addCriterion("channel_salt_key not between", value1, value2, "channelSaltKey");
            return (Criteria) this;
        }

        public Criteria andChannelStatusIsNull() {
            addCriterion("channel_status is null");
            return (Criteria) this;
        }

        public Criteria andChannelStatusIsNotNull() {
            addCriterion("channel_status is not null");
            return (Criteria) this;
        }

        public Criteria andChannelStatusEqualTo(String value) {
            addCriterion("channel_status =", value, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusNotEqualTo(String value) {
            addCriterion("channel_status <>", value, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusGreaterThan(String value) {
            addCriterion("channel_status >", value, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusGreaterThanOrEqualTo(String value) {
            addCriterion("channel_status >=", value, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusLessThan(String value) {
            addCriterion("channel_status <", value, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusLessThanOrEqualTo(String value) {
            addCriterion("channel_status <=", value, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusLike(String value) {
            addCriterion("channel_status like", value, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusNotLike(String value) {
            addCriterion("channel_status not like", value, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusIn(List<String> values) {
            addCriterion("channel_status in", values, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusNotIn(List<String> values) {
            addCriterion("channel_status not in", values, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusBetween(String value1, String value2) {
            addCriterion("channel_status between", value1, value2, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelStatusNotBetween(String value1, String value2) {
            addCriterion("channel_status not between", value1, value2, "channelStatus");
            return (Criteria) this;
        }

        public Criteria andChannelOrderIsNull() {
            addCriterion("channel_order is null");
            return (Criteria) this;
        }

        public Criteria andChannelOrderIsNotNull() {
            addCriterion("channel_order is not null");
            return (Criteria) this;
        }

        public Criteria andChannelOrderEqualTo(Integer value) {
            addCriterion("channel_order =", value, "channelOrder");
            return (Criteria) this;
        }

        public Criteria andChannelOrderNotEqualTo(Integer value) {
            addCriterion("channel_order <>", value, "channelOrder");
            return (Criteria) this;
        }

        public Criteria andChannelOrderGreaterThan(Integer value) {
            addCriterion("channel_order >", value, "channelOrder");
            return (Criteria) this;
        }

        public Criteria andChannelOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("channel_order >=", value, "channelOrder");
            return (Criteria) this;
        }

        public Criteria andChannelOrderLessThan(Integer value) {
            addCriterion("channel_order <", value, "channelOrder");
            return (Criteria) this;
        }

        public Criteria andChannelOrderLessThanOrEqualTo(Integer value) {
            addCriterion("channel_order <=", value, "channelOrder");
            return (Criteria) this;
        }

        public Criteria andChannelOrderIn(List<Integer> values) {
            addCriterion("channel_order in", values, "channelOrder");
            return (Criteria) this;
        }

        public Criteria andChannelOrderNotIn(List<Integer> values) {
            addCriterion("channel_order not in", values, "channelOrder");
            return (Criteria) this;
        }

        public Criteria andChannelOrderBetween(Integer value1, Integer value2) {
            addCriterion("channel_order between", value1, value2, "channelOrder");
            return (Criteria) this;
        }

        public Criteria andChannelOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("channel_order not between", value1, value2, "channelOrder");
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

        public Criteria andChannelNoLikeInsensitive(String value) {
            addCriterion("upper(channel_no) like", value.toUpperCase(), "channelNo");
            return (Criteria) this;
        }

        public Criteria andChannelNameLikeInsensitive(String value) {
            addCriterion("upper(channel_name) like", value.toUpperCase(), "channelName");
            return (Criteria) this;
        }

        public Criteria andChannelcompanyNoLikeInsensitive(String value) {
            addCriterion("upper(channelcompany_no) like", value.toUpperCase(), "channelcompanyNo");
            return (Criteria) this;
        }

        public Criteria andChannelCompanyNameLikeInsensitive(String value) {
            addCriterion("upper(channel_company_name) like", value.toUpperCase(), "channelCompanyName");
            return (Criteria) this;
        }

        public Criteria andChannelContactLikeInsensitive(String value) {
            addCriterion("upper(channel_contact) like", value.toUpperCase(), "channelContact");
            return (Criteria) this;
        }

        public Criteria andChannelPrivateKeyLikeInsensitive(String value) {
            addCriterion("upper(channel_private_key) like", value.toUpperCase(), "channelPrivateKey");
            return (Criteria) this;
        }

        public Criteria andChannelPublicKeyLikeInsensitive(String value) {
            addCriterion("upper(channel_public_key) like", value.toUpperCase(), "channelPublicKey");
            return (Criteria) this;
        }

        public Criteria andChannelCompanyPublicKeyLikeInsensitive(String value) {
            addCriterion("upper(channel_company_public_key) like", value.toUpperCase(), "channelCompanyPublicKey");
            return (Criteria) this;
        }

        public Criteria andChannelSaltKeyLikeInsensitive(String value) {
            addCriterion("upper(channel_salt_key) like", value.toUpperCase(), "channelSaltKey");
            return (Criteria) this;
        }

        public Criteria andChannelStatusLikeInsensitive(String value) {
            addCriterion("upper(channel_status) like", value.toUpperCase(), "channelStatus");
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