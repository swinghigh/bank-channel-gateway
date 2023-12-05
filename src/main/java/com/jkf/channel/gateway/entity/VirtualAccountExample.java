package com.jkf.channel.gateway.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VirtualAccountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VirtualAccountExample() {
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

        public Criteria andVirtualNameIsNull() {
            addCriterion("virtual_name is null");
            return (Criteria) this;
        }

        public Criteria andVirtualNameIsNotNull() {
            addCriterion("virtual_name is not null");
            return (Criteria) this;
        }

        public Criteria andVirtualNameEqualTo(String value) {
            addCriterion("virtual_name =", value, "virtualName");
            return (Criteria) this;
        }

        public Criteria andVirtualNameNotEqualTo(String value) {
            addCriterion("virtual_name <>", value, "virtualName");
            return (Criteria) this;
        }

        public Criteria andVirtualNameGreaterThan(String value) {
            addCriterion("virtual_name >", value, "virtualName");
            return (Criteria) this;
        }

        public Criteria andVirtualNameGreaterThanOrEqualTo(String value) {
            addCriterion("virtual_name >=", value, "virtualName");
            return (Criteria) this;
        }

        public Criteria andVirtualNameLessThan(String value) {
            addCriterion("virtual_name <", value, "virtualName");
            return (Criteria) this;
        }

        public Criteria andVirtualNameLessThanOrEqualTo(String value) {
            addCriterion("virtual_name <=", value, "virtualName");
            return (Criteria) this;
        }

        public Criteria andVirtualNameLike(String value) {
            addCriterion("virtual_name like", value, "virtualName");
            return (Criteria) this;
        }

        public Criteria andVirtualNameNotLike(String value) {
            addCriterion("virtual_name not like", value, "virtualName");
            return (Criteria) this;
        }

        public Criteria andVirtualNameIn(List<String> values) {
            addCriterion("virtual_name in", values, "virtualName");
            return (Criteria) this;
        }

        public Criteria andVirtualNameNotIn(List<String> values) {
            addCriterion("virtual_name not in", values, "virtualName");
            return (Criteria) this;
        }

        public Criteria andVirtualNameBetween(String value1, String value2) {
            addCriterion("virtual_name between", value1, value2, "virtualName");
            return (Criteria) this;
        }

        public Criteria andVirtualNameNotBetween(String value1, String value2) {
            addCriterion("virtual_name not between", value1, value2, "virtualName");
            return (Criteria) this;
        }

        public Criteria andVirtualAccountTypeIsNull() {
            addCriterion("virtual_account_type is null");
            return (Criteria) this;
        }

        public Criteria andVirtualAccountTypeIsNotNull() {
            addCriterion("virtual_account_type is not null");
            return (Criteria) this;
        }

        public Criteria andVirtualAccountTypeEqualTo(String value) {
            addCriterion("virtual_account_type =", value, "virtualAccountType");
            return (Criteria) this;
        }

        public Criteria andVirtualAccountTypeNotEqualTo(String value) {
            addCriterion("virtual_account_type <>", value, "virtualAccountType");
            return (Criteria) this;
        }

        public Criteria andVirtualAccountTypeGreaterThan(String value) {
            addCriterion("virtual_account_type >", value, "virtualAccountType");
            return (Criteria) this;
        }

        public Criteria andVirtualAccountTypeGreaterThanOrEqualTo(String value) {
            addCriterion("virtual_account_type >=", value, "virtualAccountType");
            return (Criteria) this;
        }

        public Criteria andVirtualAccountTypeLessThan(String value) {
            addCriterion("virtual_account_type <", value, "virtualAccountType");
            return (Criteria) this;
        }

        public Criteria andVirtualAccountTypeLessThanOrEqualTo(String value) {
            addCriterion("virtual_account_type <=", value, "virtualAccountType");
            return (Criteria) this;
        }

        public Criteria andVirtualAccountTypeLike(String value) {
            addCriterion("virtual_account_type like", value, "virtualAccountType");
            return (Criteria) this;
        }

        public Criteria andVirtualAccountTypeNotLike(String value) {
            addCriterion("virtual_account_type not like", value, "virtualAccountType");
            return (Criteria) this;
        }

        public Criteria andVirtualAccountTypeIn(List<String> values) {
            addCriterion("virtual_account_type in", values, "virtualAccountType");
            return (Criteria) this;
        }

        public Criteria andVirtualAccountTypeNotIn(List<String> values) {
            addCriterion("virtual_account_type not in", values, "virtualAccountType");
            return (Criteria) this;
        }

        public Criteria andVirtualAccountTypeBetween(String value1, String value2) {
            addCriterion("virtual_account_type between", value1, value2, "virtualAccountType");
            return (Criteria) this;
        }

        public Criteria andVirtualAccountTypeNotBetween(String value1, String value2) {
            addCriterion("virtual_account_type not between", value1, value2, "virtualAccountType");
            return (Criteria) this;
        }

        public Criteria andUseAmountIsNull() {
            addCriterion("use_amount is null");
            return (Criteria) this;
        }

        public Criteria andUseAmountIsNotNull() {
            addCriterion("use_amount is not null");
            return (Criteria) this;
        }

        public Criteria andUseAmountEqualTo(String value) {
            addCriterion("use_amount =", value, "useAmount");
            return (Criteria) this;
        }

        public Criteria andUseAmountNotEqualTo(String value) {
            addCriterion("use_amount <>", value, "useAmount");
            return (Criteria) this;
        }

        public Criteria andUseAmountGreaterThan(String value) {
            addCriterion("use_amount >", value, "useAmount");
            return (Criteria) this;
        }

        public Criteria andUseAmountGreaterThanOrEqualTo(String value) {
            addCriterion("use_amount >=", value, "useAmount");
            return (Criteria) this;
        }

        public Criteria andUseAmountLessThan(String value) {
            addCriterion("use_amount <", value, "useAmount");
            return (Criteria) this;
        }

        public Criteria andUseAmountLessThanOrEqualTo(String value) {
            addCriterion("use_amount <=", value, "useAmount");
            return (Criteria) this;
        }

        public Criteria andUseAmountLike(String value) {
            addCriterion("use_amount like", value, "useAmount");
            return (Criteria) this;
        }

        public Criteria andUseAmountNotLike(String value) {
            addCriterion("use_amount not like", value, "useAmount");
            return (Criteria) this;
        }

        public Criteria andUseAmountIn(List<String> values) {
            addCriterion("use_amount in", values, "useAmount");
            return (Criteria) this;
        }

        public Criteria andUseAmountNotIn(List<String> values) {
            addCriterion("use_amount not in", values, "useAmount");
            return (Criteria) this;
        }

        public Criteria andUseAmountBetween(String value1, String value2) {
            addCriterion("use_amount between", value1, value2, "useAmount");
            return (Criteria) this;
        }

        public Criteria andUseAmountNotBetween(String value1, String value2) {
            addCriterion("use_amount not between", value1, value2, "useAmount");
            return (Criteria) this;
        }

        public Criteria andDisUseAmountIsNull() {
            addCriterion("dis_use_amount is null");
            return (Criteria) this;
        }

        public Criteria andDisUseAmountIsNotNull() {
            addCriterion("dis_use_amount is not null");
            return (Criteria) this;
        }

        public Criteria andDisUseAmountEqualTo(String value) {
            addCriterion("dis_use_amount =", value, "disUseAmount");
            return (Criteria) this;
        }

        public Criteria andDisUseAmountNotEqualTo(String value) {
            addCriterion("dis_use_amount <>", value, "disUseAmount");
            return (Criteria) this;
        }

        public Criteria andDisUseAmountGreaterThan(String value) {
            addCriterion("dis_use_amount >", value, "disUseAmount");
            return (Criteria) this;
        }

        public Criteria andDisUseAmountGreaterThanOrEqualTo(String value) {
            addCriterion("dis_use_amount >=", value, "disUseAmount");
            return (Criteria) this;
        }

        public Criteria andDisUseAmountLessThan(String value) {
            addCriterion("dis_use_amount <", value, "disUseAmount");
            return (Criteria) this;
        }

        public Criteria andDisUseAmountLessThanOrEqualTo(String value) {
            addCriterion("dis_use_amount <=", value, "disUseAmount");
            return (Criteria) this;
        }

        public Criteria andDisUseAmountLike(String value) {
            addCriterion("dis_use_amount like", value, "disUseAmount");
            return (Criteria) this;
        }

        public Criteria andDisUseAmountNotLike(String value) {
            addCriterion("dis_use_amount not like", value, "disUseAmount");
            return (Criteria) this;
        }

        public Criteria andDisUseAmountIn(List<String> values) {
            addCriterion("dis_use_amount in", values, "disUseAmount");
            return (Criteria) this;
        }

        public Criteria andDisUseAmountNotIn(List<String> values) {
            addCriterion("dis_use_amount not in", values, "disUseAmount");
            return (Criteria) this;
        }

        public Criteria andDisUseAmountBetween(String value1, String value2) {
            addCriterion("dis_use_amount between", value1, value2, "disUseAmount");
            return (Criteria) this;
        }

        public Criteria andDisUseAmountNotBetween(String value1, String value2) {
            addCriterion("dis_use_amount not between", value1, value2, "disUseAmount");
            return (Criteria) this;
        }

        public Criteria andFreezeAmountIsNull() {
            addCriterion("freeze_amount is null");
            return (Criteria) this;
        }

        public Criteria andFreezeAmountIsNotNull() {
            addCriterion("freeze_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFreezeAmountEqualTo(String value) {
            addCriterion("freeze_amount =", value, "freezeAmount");
            return (Criteria) this;
        }

        public Criteria andFreezeAmountNotEqualTo(String value) {
            addCriterion("freeze_amount <>", value, "freezeAmount");
            return (Criteria) this;
        }

        public Criteria andFreezeAmountGreaterThan(String value) {
            addCriterion("freeze_amount >", value, "freezeAmount");
            return (Criteria) this;
        }

        public Criteria andFreezeAmountGreaterThanOrEqualTo(String value) {
            addCriterion("freeze_amount >=", value, "freezeAmount");
            return (Criteria) this;
        }

        public Criteria andFreezeAmountLessThan(String value) {
            addCriterion("freeze_amount <", value, "freezeAmount");
            return (Criteria) this;
        }

        public Criteria andFreezeAmountLessThanOrEqualTo(String value) {
            addCriterion("freeze_amount <=", value, "freezeAmount");
            return (Criteria) this;
        }

        public Criteria andFreezeAmountLike(String value) {
            addCriterion("freeze_amount like", value, "freezeAmount");
            return (Criteria) this;
        }

        public Criteria andFreezeAmountNotLike(String value) {
            addCriterion("freeze_amount not like", value, "freezeAmount");
            return (Criteria) this;
        }

        public Criteria andFreezeAmountIn(List<String> values) {
            addCriterion("freeze_amount in", values, "freezeAmount");
            return (Criteria) this;
        }

        public Criteria andFreezeAmountNotIn(List<String> values) {
            addCriterion("freeze_amount not in", values, "freezeAmount");
            return (Criteria) this;
        }

        public Criteria andFreezeAmountBetween(String value1, String value2) {
            addCriterion("freeze_amount between", value1, value2, "freezeAmount");
            return (Criteria) this;
        }

        public Criteria andFreezeAmountNotBetween(String value1, String value2) {
            addCriterion("freeze_amount not between", value1, value2, "freezeAmount");
            return (Criteria) this;
        }

        public Criteria andEncryAmountIsNull() {
            addCriterion("encry_amount is null");
            return (Criteria) this;
        }

        public Criteria andEncryAmountIsNotNull() {
            addCriterion("encry_amount is not null");
            return (Criteria) this;
        }

        public Criteria andEncryAmountEqualTo(String value) {
            addCriterion("encry_amount =", value, "encryAmount");
            return (Criteria) this;
        }

        public Criteria andEncryAmountNotEqualTo(String value) {
            addCriterion("encry_amount <>", value, "encryAmount");
            return (Criteria) this;
        }

        public Criteria andEncryAmountGreaterThan(String value) {
            addCriterion("encry_amount >", value, "encryAmount");
            return (Criteria) this;
        }

        public Criteria andEncryAmountGreaterThanOrEqualTo(String value) {
            addCriterion("encry_amount >=", value, "encryAmount");
            return (Criteria) this;
        }

        public Criteria andEncryAmountLessThan(String value) {
            addCriterion("encry_amount <", value, "encryAmount");
            return (Criteria) this;
        }

        public Criteria andEncryAmountLessThanOrEqualTo(String value) {
            addCriterion("encry_amount <=", value, "encryAmount");
            return (Criteria) this;
        }

        public Criteria andEncryAmountLike(String value) {
            addCriterion("encry_amount like", value, "encryAmount");
            return (Criteria) this;
        }

        public Criteria andEncryAmountNotLike(String value) {
            addCriterion("encry_amount not like", value, "encryAmount");
            return (Criteria) this;
        }

        public Criteria andEncryAmountIn(List<String> values) {
            addCriterion("encry_amount in", values, "encryAmount");
            return (Criteria) this;
        }

        public Criteria andEncryAmountNotIn(List<String> values) {
            addCriterion("encry_amount not in", values, "encryAmount");
            return (Criteria) this;
        }

        public Criteria andEncryAmountBetween(String value1, String value2) {
            addCriterion("encry_amount between", value1, value2, "encryAmount");
            return (Criteria) this;
        }

        public Criteria andEncryAmountNotBetween(String value1, String value2) {
            addCriterion("encry_amount not between", value1, value2, "encryAmount");
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

        public Criteria andPwdIsNull() {
            addCriterion("pwd is null");
            return (Criteria) this;
        }

        public Criteria andPwdIsNotNull() {
            addCriterion("pwd is not null");
            return (Criteria) this;
        }

        public Criteria andPwdEqualTo(String value) {
            addCriterion("pwd =", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotEqualTo(String value) {
            addCriterion("pwd <>", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdGreaterThan(String value) {
            addCriterion("pwd >", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdGreaterThanOrEqualTo(String value) {
            addCriterion("pwd >=", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLessThan(String value) {
            addCriterion("pwd <", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLessThanOrEqualTo(String value) {
            addCriterion("pwd <=", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdLike(String value) {
            addCriterion("pwd like", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotLike(String value) {
            addCriterion("pwd not like", value, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdIn(List<String> values) {
            addCriterion("pwd in", values, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotIn(List<String> values) {
            addCriterion("pwd not in", values, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdBetween(String value1, String value2) {
            addCriterion("pwd between", value1, value2, "pwd");
            return (Criteria) this;
        }

        public Criteria andPwdNotBetween(String value1, String value2) {
            addCriterion("pwd not between", value1, value2, "pwd");
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

        public Criteria andVirtualNoLikeInsensitive(String value) {
            addCriterion("upper(virtual_no) like", value.toUpperCase(), "virtualNo");
            return (Criteria) this;
        }

        public Criteria andVirtualNameLikeInsensitive(String value) {
            addCriterion("upper(virtual_name) like", value.toUpperCase(), "virtualName");
            return (Criteria) this;
        }

        public Criteria andVirtualAccountTypeLikeInsensitive(String value) {
            addCriterion("upper(virtual_account_type) like", value.toUpperCase(), "virtualAccountType");
            return (Criteria) this;
        }

        public Criteria andUseAmountLikeInsensitive(String value) {
            addCriterion("upper(use_amount) like", value.toUpperCase(), "useAmount");
            return (Criteria) this;
        }

        public Criteria andDisUseAmountLikeInsensitive(String value) {
            addCriterion("upper(dis_use_amount) like", value.toUpperCase(), "disUseAmount");
            return (Criteria) this;
        }

        public Criteria andFreezeAmountLikeInsensitive(String value) {
            addCriterion("upper(freeze_amount) like", value.toUpperCase(), "freezeAmount");
            return (Criteria) this;
        }

        public Criteria andEncryAmountLikeInsensitive(String value) {
            addCriterion("upper(encry_amount) like", value.toUpperCase(), "encryAmount");
            return (Criteria) this;
        }

        public Criteria andStatusLikeInsensitive(String value) {
            addCriterion("upper(`status`) like", value.toUpperCase(), "status");
            return (Criteria) this;
        }

        public Criteria andPwdLikeInsensitive(String value) {
            addCriterion("upper(pwd) like", value.toUpperCase(), "pwd");
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