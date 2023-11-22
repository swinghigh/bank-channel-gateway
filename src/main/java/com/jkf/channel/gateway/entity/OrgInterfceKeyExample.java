package com.jkf.channel.gateway.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrgInterfceKeyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrgInterfceKeyExample() {
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

        public Criteria andOrgAppNoIsNull() {
            addCriterion("org_app_no is null");
            return (Criteria) this;
        }

        public Criteria andOrgAppNoIsNotNull() {
            addCriterion("org_app_no is not null");
            return (Criteria) this;
        }

        public Criteria andOrgAppNoEqualTo(String value) {
            addCriterion("org_app_no =", value, "orgAppNo");
            return (Criteria) this;
        }

        public Criteria andOrgAppNoNotEqualTo(String value) {
            addCriterion("org_app_no <>", value, "orgAppNo");
            return (Criteria) this;
        }

        public Criteria andOrgAppNoGreaterThan(String value) {
            addCriterion("org_app_no >", value, "orgAppNo");
            return (Criteria) this;
        }

        public Criteria andOrgAppNoGreaterThanOrEqualTo(String value) {
            addCriterion("org_app_no >=", value, "orgAppNo");
            return (Criteria) this;
        }

        public Criteria andOrgAppNoLessThan(String value) {
            addCriterion("org_app_no <", value, "orgAppNo");
            return (Criteria) this;
        }

        public Criteria andOrgAppNoLessThanOrEqualTo(String value) {
            addCriterion("org_app_no <=", value, "orgAppNo");
            return (Criteria) this;
        }

        public Criteria andOrgAppNoLike(String value) {
            addCriterion("org_app_no like", value, "orgAppNo");
            return (Criteria) this;
        }

        public Criteria andOrgAppNoNotLike(String value) {
            addCriterion("org_app_no not like", value, "orgAppNo");
            return (Criteria) this;
        }

        public Criteria andOrgAppNoIn(List<String> values) {
            addCriterion("org_app_no in", values, "orgAppNo");
            return (Criteria) this;
        }

        public Criteria andOrgAppNoNotIn(List<String> values) {
            addCriterion("org_app_no not in", values, "orgAppNo");
            return (Criteria) this;
        }

        public Criteria andOrgAppNoBetween(String value1, String value2) {
            addCriterion("org_app_no between", value1, value2, "orgAppNo");
            return (Criteria) this;
        }

        public Criteria andOrgAppNoNotBetween(String value1, String value2) {
            addCriterion("org_app_no not between", value1, value2, "orgAppNo");
            return (Criteria) this;
        }

        public Criteria andOrgAppNameIsNull() {
            addCriterion("org_app_name is null");
            return (Criteria) this;
        }

        public Criteria andOrgAppNameIsNotNull() {
            addCriterion("org_app_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrgAppNameEqualTo(String value) {
            addCriterion("org_app_name =", value, "orgAppName");
            return (Criteria) this;
        }

        public Criteria andOrgAppNameNotEqualTo(String value) {
            addCriterion("org_app_name <>", value, "orgAppName");
            return (Criteria) this;
        }

        public Criteria andOrgAppNameGreaterThan(String value) {
            addCriterion("org_app_name >", value, "orgAppName");
            return (Criteria) this;
        }

        public Criteria andOrgAppNameGreaterThanOrEqualTo(String value) {
            addCriterion("org_app_name >=", value, "orgAppName");
            return (Criteria) this;
        }

        public Criteria andOrgAppNameLessThan(String value) {
            addCriterion("org_app_name <", value, "orgAppName");
            return (Criteria) this;
        }

        public Criteria andOrgAppNameLessThanOrEqualTo(String value) {
            addCriterion("org_app_name <=", value, "orgAppName");
            return (Criteria) this;
        }

        public Criteria andOrgAppNameLike(String value) {
            addCriterion("org_app_name like", value, "orgAppName");
            return (Criteria) this;
        }

        public Criteria andOrgAppNameNotLike(String value) {
            addCriterion("org_app_name not like", value, "orgAppName");
            return (Criteria) this;
        }

        public Criteria andOrgAppNameIn(List<String> values) {
            addCriterion("org_app_name in", values, "orgAppName");
            return (Criteria) this;
        }

        public Criteria andOrgAppNameNotIn(List<String> values) {
            addCriterion("org_app_name not in", values, "orgAppName");
            return (Criteria) this;
        }

        public Criteria andOrgAppNameBetween(String value1, String value2) {
            addCriterion("org_app_name between", value1, value2, "orgAppName");
            return (Criteria) this;
        }

        public Criteria andOrgAppNameNotBetween(String value1, String value2) {
            addCriterion("org_app_name not between", value1, value2, "orgAppName");
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

        public Criteria andOrgPrivateKeyIsNull() {
            addCriterion("org_private_key is null");
            return (Criteria) this;
        }

        public Criteria andOrgPrivateKeyIsNotNull() {
            addCriterion("org_private_key is not null");
            return (Criteria) this;
        }

        public Criteria andOrgPrivateKeyEqualTo(String value) {
            addCriterion("org_private_key =", value, "orgPrivateKey");
            return (Criteria) this;
        }

        public Criteria andOrgPrivateKeyNotEqualTo(String value) {
            addCriterion("org_private_key <>", value, "orgPrivateKey");
            return (Criteria) this;
        }

        public Criteria andOrgPrivateKeyGreaterThan(String value) {
            addCriterion("org_private_key >", value, "orgPrivateKey");
            return (Criteria) this;
        }

        public Criteria andOrgPrivateKeyGreaterThanOrEqualTo(String value) {
            addCriterion("org_private_key >=", value, "orgPrivateKey");
            return (Criteria) this;
        }

        public Criteria andOrgPrivateKeyLessThan(String value) {
            addCriterion("org_private_key <", value, "orgPrivateKey");
            return (Criteria) this;
        }

        public Criteria andOrgPrivateKeyLessThanOrEqualTo(String value) {
            addCriterion("org_private_key <=", value, "orgPrivateKey");
            return (Criteria) this;
        }

        public Criteria andOrgPrivateKeyLike(String value) {
            addCriterion("org_private_key like", value, "orgPrivateKey");
            return (Criteria) this;
        }

        public Criteria andOrgPrivateKeyNotLike(String value) {
            addCriterion("org_private_key not like", value, "orgPrivateKey");
            return (Criteria) this;
        }

        public Criteria andOrgPrivateKeyIn(List<String> values) {
            addCriterion("org_private_key in", values, "orgPrivateKey");
            return (Criteria) this;
        }

        public Criteria andOrgPrivateKeyNotIn(List<String> values) {
            addCriterion("org_private_key not in", values, "orgPrivateKey");
            return (Criteria) this;
        }

        public Criteria andOrgPrivateKeyBetween(String value1, String value2) {
            addCriterion("org_private_key between", value1, value2, "orgPrivateKey");
            return (Criteria) this;
        }

        public Criteria andOrgPrivateKeyNotBetween(String value1, String value2) {
            addCriterion("org_private_key not between", value1, value2, "orgPrivateKey");
            return (Criteria) this;
        }

        public Criteria andOrgPublicKeyIsNull() {
            addCriterion("org_public_key is null");
            return (Criteria) this;
        }

        public Criteria andOrgPublicKeyIsNotNull() {
            addCriterion("org_public_key is not null");
            return (Criteria) this;
        }

        public Criteria andOrgPublicKeyEqualTo(String value) {
            addCriterion("org_public_key =", value, "orgPublicKey");
            return (Criteria) this;
        }

        public Criteria andOrgPublicKeyNotEqualTo(String value) {
            addCriterion("org_public_key <>", value, "orgPublicKey");
            return (Criteria) this;
        }

        public Criteria andOrgPublicKeyGreaterThan(String value) {
            addCriterion("org_public_key >", value, "orgPublicKey");
            return (Criteria) this;
        }

        public Criteria andOrgPublicKeyGreaterThanOrEqualTo(String value) {
            addCriterion("org_public_key >=", value, "orgPublicKey");
            return (Criteria) this;
        }

        public Criteria andOrgPublicKeyLessThan(String value) {
            addCriterion("org_public_key <", value, "orgPublicKey");
            return (Criteria) this;
        }

        public Criteria andOrgPublicKeyLessThanOrEqualTo(String value) {
            addCriterion("org_public_key <=", value, "orgPublicKey");
            return (Criteria) this;
        }

        public Criteria andOrgPublicKeyLike(String value) {
            addCriterion("org_public_key like", value, "orgPublicKey");
            return (Criteria) this;
        }

        public Criteria andOrgPublicKeyNotLike(String value) {
            addCriterion("org_public_key not like", value, "orgPublicKey");
            return (Criteria) this;
        }

        public Criteria andOrgPublicKeyIn(List<String> values) {
            addCriterion("org_public_key in", values, "orgPublicKey");
            return (Criteria) this;
        }

        public Criteria andOrgPublicKeyNotIn(List<String> values) {
            addCriterion("org_public_key not in", values, "orgPublicKey");
            return (Criteria) this;
        }

        public Criteria andOrgPublicKeyBetween(String value1, String value2) {
            addCriterion("org_public_key between", value1, value2, "orgPublicKey");
            return (Criteria) this;
        }

        public Criteria andOrgPublicKeyNotBetween(String value1, String value2) {
            addCriterion("org_public_key not between", value1, value2, "orgPublicKey");
            return (Criteria) this;
        }

        public Criteria andPlatPrivateKeyIsNull() {
            addCriterion("plat_private_key is null");
            return (Criteria) this;
        }

        public Criteria andPlatPrivateKeyIsNotNull() {
            addCriterion("plat_private_key is not null");
            return (Criteria) this;
        }

        public Criteria andPlatPrivateKeyEqualTo(String value) {
            addCriterion("plat_private_key =", value, "platPrivateKey");
            return (Criteria) this;
        }

        public Criteria andPlatPrivateKeyNotEqualTo(String value) {
            addCriterion("plat_private_key <>", value, "platPrivateKey");
            return (Criteria) this;
        }

        public Criteria andPlatPrivateKeyGreaterThan(String value) {
            addCriterion("plat_private_key >", value, "platPrivateKey");
            return (Criteria) this;
        }

        public Criteria andPlatPrivateKeyGreaterThanOrEqualTo(String value) {
            addCriterion("plat_private_key >=", value, "platPrivateKey");
            return (Criteria) this;
        }

        public Criteria andPlatPrivateKeyLessThan(String value) {
            addCriterion("plat_private_key <", value, "platPrivateKey");
            return (Criteria) this;
        }

        public Criteria andPlatPrivateKeyLessThanOrEqualTo(String value) {
            addCriterion("plat_private_key <=", value, "platPrivateKey");
            return (Criteria) this;
        }

        public Criteria andPlatPrivateKeyLike(String value) {
            addCriterion("plat_private_key like", value, "platPrivateKey");
            return (Criteria) this;
        }

        public Criteria andPlatPrivateKeyNotLike(String value) {
            addCriterion("plat_private_key not like", value, "platPrivateKey");
            return (Criteria) this;
        }

        public Criteria andPlatPrivateKeyIn(List<String> values) {
            addCriterion("plat_private_key in", values, "platPrivateKey");
            return (Criteria) this;
        }

        public Criteria andPlatPrivateKeyNotIn(List<String> values) {
            addCriterion("plat_private_key not in", values, "platPrivateKey");
            return (Criteria) this;
        }

        public Criteria andPlatPrivateKeyBetween(String value1, String value2) {
            addCriterion("plat_private_key between", value1, value2, "platPrivateKey");
            return (Criteria) this;
        }

        public Criteria andPlatPrivateKeyNotBetween(String value1, String value2) {
            addCriterion("plat_private_key not between", value1, value2, "platPrivateKey");
            return (Criteria) this;
        }

        public Criteria andPlatPublicKeyIsNull() {
            addCriterion("plat_public_key is null");
            return (Criteria) this;
        }

        public Criteria andPlatPublicKeyIsNotNull() {
            addCriterion("plat_public_key is not null");
            return (Criteria) this;
        }

        public Criteria andPlatPublicKeyEqualTo(String value) {
            addCriterion("plat_public_key =", value, "platPublicKey");
            return (Criteria) this;
        }

        public Criteria andPlatPublicKeyNotEqualTo(String value) {
            addCriterion("plat_public_key <>", value, "platPublicKey");
            return (Criteria) this;
        }

        public Criteria andPlatPublicKeyGreaterThan(String value) {
            addCriterion("plat_public_key >", value, "platPublicKey");
            return (Criteria) this;
        }

        public Criteria andPlatPublicKeyGreaterThanOrEqualTo(String value) {
            addCriterion("plat_public_key >=", value, "platPublicKey");
            return (Criteria) this;
        }

        public Criteria andPlatPublicKeyLessThan(String value) {
            addCriterion("plat_public_key <", value, "platPublicKey");
            return (Criteria) this;
        }

        public Criteria andPlatPublicKeyLessThanOrEqualTo(String value) {
            addCriterion("plat_public_key <=", value, "platPublicKey");
            return (Criteria) this;
        }

        public Criteria andPlatPublicKeyLike(String value) {
            addCriterion("plat_public_key like", value, "platPublicKey");
            return (Criteria) this;
        }

        public Criteria andPlatPublicKeyNotLike(String value) {
            addCriterion("plat_public_key not like", value, "platPublicKey");
            return (Criteria) this;
        }

        public Criteria andPlatPublicKeyIn(List<String> values) {
            addCriterion("plat_public_key in", values, "platPublicKey");
            return (Criteria) this;
        }

        public Criteria andPlatPublicKeyNotIn(List<String> values) {
            addCriterion("plat_public_key not in", values, "platPublicKey");
            return (Criteria) this;
        }

        public Criteria andPlatPublicKeyBetween(String value1, String value2) {
            addCriterion("plat_public_key between", value1, value2, "platPublicKey");
            return (Criteria) this;
        }

        public Criteria andPlatPublicKeyNotBetween(String value1, String value2) {
            addCriterion("plat_public_key not between", value1, value2, "platPublicKey");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlIsNull() {
            addCriterion("pay_notify_url is null");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlIsNotNull() {
            addCriterion("pay_notify_url is not null");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlEqualTo(String value) {
            addCriterion("pay_notify_url =", value, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlNotEqualTo(String value) {
            addCriterion("pay_notify_url <>", value, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlGreaterThan(String value) {
            addCriterion("pay_notify_url >", value, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlGreaterThanOrEqualTo(String value) {
            addCriterion("pay_notify_url >=", value, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlLessThan(String value) {
            addCriterion("pay_notify_url <", value, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlLessThanOrEqualTo(String value) {
            addCriterion("pay_notify_url <=", value, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlLike(String value) {
            addCriterion("pay_notify_url like", value, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlNotLike(String value) {
            addCriterion("pay_notify_url not like", value, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlIn(List<String> values) {
            addCriterion("pay_notify_url in", values, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlNotIn(List<String> values) {
            addCriterion("pay_notify_url not in", values, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlBetween(String value1, String value2) {
            addCriterion("pay_notify_url between", value1, value2, "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlNotBetween(String value1, String value2) {
            addCriterion("pay_notify_url not between", value1, value2, "payNotifyUrl");
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

        public Criteria andOrgAppNoLikeInsensitive(String value) {
            addCriterion("upper(org_app_no) like", value.toUpperCase(), "orgAppNo");
            return (Criteria) this;
        }

        public Criteria andOrgAppNameLikeInsensitive(String value) {
            addCriterion("upper(org_app_name) like", value.toUpperCase(), "orgAppName");
            return (Criteria) this;
        }

        public Criteria andOrgPrivateKeyLikeInsensitive(String value) {
            addCriterion("upper(org_private_key) like", value.toUpperCase(), "orgPrivateKey");
            return (Criteria) this;
        }

        public Criteria andOrgPublicKeyLikeInsensitive(String value) {
            addCriterion("upper(org_public_key) like", value.toUpperCase(), "orgPublicKey");
            return (Criteria) this;
        }

        public Criteria andPlatPrivateKeyLikeInsensitive(String value) {
            addCriterion("upper(plat_private_key) like", value.toUpperCase(), "platPrivateKey");
            return (Criteria) this;
        }

        public Criteria andPlatPublicKeyLikeInsensitive(String value) {
            addCriterion("upper(plat_public_key) like", value.toUpperCase(), "platPublicKey");
            return (Criteria) this;
        }

        public Criteria andPayNotifyUrlLikeInsensitive(String value) {
            addCriterion("upper(pay_notify_url) like", value.toUpperCase(), "payNotifyUrl");
            return (Criteria) this;
        }

        public Criteria andStatusLikeInsensitive(String value) {
            addCriterion("upper(`status`) like", value.toUpperCase(), "status");
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