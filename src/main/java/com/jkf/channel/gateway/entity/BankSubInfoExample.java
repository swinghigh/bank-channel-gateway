package com.jkf.channel.gateway.entity;

import java.util.ArrayList;
import java.util.List;

public class BankSubInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BankSubInfoExample() {
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

        public Criteria andBranchBankNumberIsNull() {
            addCriterion("BRANCH_BANK_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andBranchBankNumberIsNotNull() {
            addCriterion("BRANCH_BANK_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andBranchBankNumberEqualTo(String value) {
            addCriterion("BRANCH_BANK_NUMBER =", value, "branchBankNumber");
            return (Criteria) this;
        }

        public Criteria andBranchBankNumberNotEqualTo(String value) {
            addCriterion("BRANCH_BANK_NUMBER <>", value, "branchBankNumber");
            return (Criteria) this;
        }

        public Criteria andBranchBankNumberGreaterThan(String value) {
            addCriterion("BRANCH_BANK_NUMBER >", value, "branchBankNumber");
            return (Criteria) this;
        }

        public Criteria andBranchBankNumberGreaterThanOrEqualTo(String value) {
            addCriterion("BRANCH_BANK_NUMBER >=", value, "branchBankNumber");
            return (Criteria) this;
        }

        public Criteria andBranchBankNumberLessThan(String value) {
            addCriterion("BRANCH_BANK_NUMBER <", value, "branchBankNumber");
            return (Criteria) this;
        }

        public Criteria andBranchBankNumberLessThanOrEqualTo(String value) {
            addCriterion("BRANCH_BANK_NUMBER <=", value, "branchBankNumber");
            return (Criteria) this;
        }

        public Criteria andBranchBankNumberLike(String value) {
            addCriterion("BRANCH_BANK_NUMBER like", value, "branchBankNumber");
            return (Criteria) this;
        }

        public Criteria andBranchBankNumberNotLike(String value) {
            addCriterion("BRANCH_BANK_NUMBER not like", value, "branchBankNumber");
            return (Criteria) this;
        }

        public Criteria andBranchBankNumberIn(List<String> values) {
            addCriterion("BRANCH_BANK_NUMBER in", values, "branchBankNumber");
            return (Criteria) this;
        }

        public Criteria andBranchBankNumberNotIn(List<String> values) {
            addCriterion("BRANCH_BANK_NUMBER not in", values, "branchBankNumber");
            return (Criteria) this;
        }

        public Criteria andBranchBankNumberBetween(String value1, String value2) {
            addCriterion("BRANCH_BANK_NUMBER between", value1, value2, "branchBankNumber");
            return (Criteria) this;
        }

        public Criteria andBranchBankNumberNotBetween(String value1, String value2) {
            addCriterion("BRANCH_BANK_NUMBER not between", value1, value2, "branchBankNumber");
            return (Criteria) this;
        }

        public Criteria andBranchBankNameIsNull() {
            addCriterion("BRANCH_BANK_NAME is null");
            return (Criteria) this;
        }

        public Criteria andBranchBankNameIsNotNull() {
            addCriterion("BRANCH_BANK_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andBranchBankNameEqualTo(String value) {
            addCriterion("BRANCH_BANK_NAME =", value, "branchBankName");
            return (Criteria) this;
        }

        public Criteria andBranchBankNameNotEqualTo(String value) {
            addCriterion("BRANCH_BANK_NAME <>", value, "branchBankName");
            return (Criteria) this;
        }

        public Criteria andBranchBankNameGreaterThan(String value) {
            addCriterion("BRANCH_BANK_NAME >", value, "branchBankName");
            return (Criteria) this;
        }

        public Criteria andBranchBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("BRANCH_BANK_NAME >=", value, "branchBankName");
            return (Criteria) this;
        }

        public Criteria andBranchBankNameLessThan(String value) {
            addCriterion("BRANCH_BANK_NAME <", value, "branchBankName");
            return (Criteria) this;
        }

        public Criteria andBranchBankNameLessThanOrEqualTo(String value) {
            addCriterion("BRANCH_BANK_NAME <=", value, "branchBankName");
            return (Criteria) this;
        }

        public Criteria andBranchBankNameLike(String value) {
            addCriterion("BRANCH_BANK_NAME like", value, "branchBankName");
            return (Criteria) this;
        }

        public Criteria andBranchBankNameNotLike(String value) {
            addCriterion("BRANCH_BANK_NAME not like", value, "branchBankName");
            return (Criteria) this;
        }

        public Criteria andBranchBankNameIn(List<String> values) {
            addCriterion("BRANCH_BANK_NAME in", values, "branchBankName");
            return (Criteria) this;
        }

        public Criteria andBranchBankNameNotIn(List<String> values) {
            addCriterion("BRANCH_BANK_NAME not in", values, "branchBankName");
            return (Criteria) this;
        }

        public Criteria andBranchBankNameBetween(String value1, String value2) {
            addCriterion("BRANCH_BANK_NAME between", value1, value2, "branchBankName");
            return (Criteria) this;
        }

        public Criteria andBranchBankNameNotBetween(String value1, String value2) {
            addCriterion("BRANCH_BANK_NAME not between", value1, value2, "branchBankName");
            return (Criteria) this;
        }

        public Criteria andBankNumberIsNull() {
            addCriterion("BANK_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andBankNumberIsNotNull() {
            addCriterion("BANK_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andBankNumberEqualTo(String value) {
            addCriterion("BANK_NUMBER =", value, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberNotEqualTo(String value) {
            addCriterion("BANK_NUMBER <>", value, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberGreaterThan(String value) {
            addCriterion("BANK_NUMBER >", value, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberGreaterThanOrEqualTo(String value) {
            addCriterion("BANK_NUMBER >=", value, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberLessThan(String value) {
            addCriterion("BANK_NUMBER <", value, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberLessThanOrEqualTo(String value) {
            addCriterion("BANK_NUMBER <=", value, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberLike(String value) {
            addCriterion("BANK_NUMBER like", value, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberNotLike(String value) {
            addCriterion("BANK_NUMBER not like", value, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberIn(List<String> values) {
            addCriterion("BANK_NUMBER in", values, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberNotIn(List<String> values) {
            addCriterion("BANK_NUMBER not in", values, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberBetween(String value1, String value2) {
            addCriterion("BANK_NUMBER between", value1, value2, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNumberNotBetween(String value1, String value2) {
            addCriterion("BANK_NUMBER not between", value1, value2, "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNull() {
            addCriterion("BANK_NAME is null");
            return (Criteria) this;
        }

        public Criteria andBankNameIsNotNull() {
            addCriterion("BANK_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andBankNameEqualTo(String value) {
            addCriterion("BANK_NAME =", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotEqualTo(String value) {
            addCriterion("BANK_NAME <>", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThan(String value) {
            addCriterion("BANK_NAME >", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("BANK_NAME >=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThan(String value) {
            addCriterion("BANK_NAME <", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLessThanOrEqualTo(String value) {
            addCriterion("BANK_NAME <=", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameLike(String value) {
            addCriterion("BANK_NAME like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotLike(String value) {
            addCriterion("BANK_NAME not like", value, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameIn(List<String> values) {
            addCriterion("BANK_NAME in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotIn(List<String> values) {
            addCriterion("BANK_NAME not in", values, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameBetween(String value1, String value2) {
            addCriterion("BANK_NAME between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andBankNameNotBetween(String value1, String value2) {
            addCriterion("BANK_NAME not between", value1, value2, "bankName");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIsNull() {
            addCriterion("PROVINCE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIsNotNull() {
            addCriterion("PROVINCE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeEqualTo(String value) {
            addCriterion("PROVINCE_CODE =", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotEqualTo(String value) {
            addCriterion("PROVINCE_CODE <>", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThan(String value) {
            addCriterion("PROVINCE_CODE >", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeGreaterThanOrEqualTo(String value) {
            addCriterion("PROVINCE_CODE >=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThan(String value) {
            addCriterion("PROVINCE_CODE <", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLessThanOrEqualTo(String value) {
            addCriterion("PROVINCE_CODE <=", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLike(String value) {
            addCriterion("PROVINCE_CODE like", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotLike(String value) {
            addCriterion("PROVINCE_CODE not like", value, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeIn(List<String> values) {
            addCriterion("PROVINCE_CODE in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotIn(List<String> values) {
            addCriterion("PROVINCE_CODE not in", values, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeBetween(String value1, String value2) {
            addCriterion("PROVINCE_CODE between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeNotBetween(String value1, String value2) {
            addCriterion("PROVINCE_CODE not between", value1, value2, "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceNameIsNull() {
            addCriterion("PROVINCE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andProvinceNameIsNotNull() {
            addCriterion("PROVINCE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceNameEqualTo(String value) {
            addCriterion("PROVINCE_NAME =", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotEqualTo(String value) {
            addCriterion("PROVINCE_NAME <>", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameGreaterThan(String value) {
            addCriterion("PROVINCE_NAME >", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameGreaterThanOrEqualTo(String value) {
            addCriterion("PROVINCE_NAME >=", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameLessThan(String value) {
            addCriterion("PROVINCE_NAME <", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameLessThanOrEqualTo(String value) {
            addCriterion("PROVINCE_NAME <=", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameLike(String value) {
            addCriterion("PROVINCE_NAME like", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotLike(String value) {
            addCriterion("PROVINCE_NAME not like", value, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameIn(List<String> values) {
            addCriterion("PROVINCE_NAME in", values, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotIn(List<String> values) {
            addCriterion("PROVINCE_NAME not in", values, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameBetween(String value1, String value2) {
            addCriterion("PROVINCE_NAME between", value1, value2, "provinceName");
            return (Criteria) this;
        }

        public Criteria andProvinceNameNotBetween(String value1, String value2) {
            addCriterion("PROVINCE_NAME not between", value1, value2, "provinceName");
            return (Criteria) this;
        }

        public Criteria andCityCodeIsNull() {
            addCriterion("CITY_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCityCodeIsNotNull() {
            addCriterion("CITY_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCityCodeEqualTo(String value) {
            addCriterion("CITY_CODE =", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotEqualTo(String value) {
            addCriterion("CITY_CODE <>", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThan(String value) {
            addCriterion("CITY_CODE >", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CITY_CODE >=", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThan(String value) {
            addCriterion("CITY_CODE <", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLessThanOrEqualTo(String value) {
            addCriterion("CITY_CODE <=", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeLike(String value) {
            addCriterion("CITY_CODE like", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotLike(String value) {
            addCriterion("CITY_CODE not like", value, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeIn(List<String> values) {
            addCriterion("CITY_CODE in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotIn(List<String> values) {
            addCriterion("CITY_CODE not in", values, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeBetween(String value1, String value2) {
            addCriterion("CITY_CODE between", value1, value2, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityCodeNotBetween(String value1, String value2) {
            addCriterion("CITY_CODE not between", value1, value2, "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityNameIsNull() {
            addCriterion("CITY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCityNameIsNotNull() {
            addCriterion("CITY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCityNameEqualTo(String value) {
            addCriterion("CITY_NAME =", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotEqualTo(String value) {
            addCriterion("CITY_NAME <>", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameGreaterThan(String value) {
            addCriterion("CITY_NAME >", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameGreaterThanOrEqualTo(String value) {
            addCriterion("CITY_NAME >=", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLessThan(String value) {
            addCriterion("CITY_NAME <", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLessThanOrEqualTo(String value) {
            addCriterion("CITY_NAME <=", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLike(String value) {
            addCriterion("CITY_NAME like", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotLike(String value) {
            addCriterion("CITY_NAME not like", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameIn(List<String> values) {
            addCriterion("CITY_NAME in", values, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotIn(List<String> values) {
            addCriterion("CITY_NAME not in", values, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameBetween(String value1, String value2) {
            addCriterion("CITY_NAME between", value1, value2, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotBetween(String value1, String value2) {
            addCriterion("CITY_NAME not between", value1, value2, "cityName");
            return (Criteria) this;
        }

        public Criteria andEyeNameIsNull() {
            addCriterion("EYE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andEyeNameIsNotNull() {
            addCriterion("EYE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andEyeNameEqualTo(String value) {
            addCriterion("EYE_NAME =", value, "eyeName");
            return (Criteria) this;
        }

        public Criteria andEyeNameNotEqualTo(String value) {
            addCriterion("EYE_NAME <>", value, "eyeName");
            return (Criteria) this;
        }

        public Criteria andEyeNameGreaterThan(String value) {
            addCriterion("EYE_NAME >", value, "eyeName");
            return (Criteria) this;
        }

        public Criteria andEyeNameGreaterThanOrEqualTo(String value) {
            addCriterion("EYE_NAME >=", value, "eyeName");
            return (Criteria) this;
        }

        public Criteria andEyeNameLessThan(String value) {
            addCriterion("EYE_NAME <", value, "eyeName");
            return (Criteria) this;
        }

        public Criteria andEyeNameLessThanOrEqualTo(String value) {
            addCriterion("EYE_NAME <=", value, "eyeName");
            return (Criteria) this;
        }

        public Criteria andEyeNameLike(String value) {
            addCriterion("EYE_NAME like", value, "eyeName");
            return (Criteria) this;
        }

        public Criteria andEyeNameNotLike(String value) {
            addCriterion("EYE_NAME not like", value, "eyeName");
            return (Criteria) this;
        }

        public Criteria andEyeNameIn(List<String> values) {
            addCriterion("EYE_NAME in", values, "eyeName");
            return (Criteria) this;
        }

        public Criteria andEyeNameNotIn(List<String> values) {
            addCriterion("EYE_NAME not in", values, "eyeName");
            return (Criteria) this;
        }

        public Criteria andEyeNameBetween(String value1, String value2) {
            addCriterion("EYE_NAME between", value1, value2, "eyeName");
            return (Criteria) this;
        }

        public Criteria andEyeNameNotBetween(String value1, String value2) {
            addCriterion("EYE_NAME not between", value1, value2, "eyeName");
            return (Criteria) this;
        }

        public Criteria andEyeCodeIsNull() {
            addCriterion("EYE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andEyeCodeIsNotNull() {
            addCriterion("EYE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andEyeCodeEqualTo(String value) {
            addCriterion("EYE_CODE =", value, "eyeCode");
            return (Criteria) this;
        }

        public Criteria andEyeCodeNotEqualTo(String value) {
            addCriterion("EYE_CODE <>", value, "eyeCode");
            return (Criteria) this;
        }

        public Criteria andEyeCodeGreaterThan(String value) {
            addCriterion("EYE_CODE >", value, "eyeCode");
            return (Criteria) this;
        }

        public Criteria andEyeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("EYE_CODE >=", value, "eyeCode");
            return (Criteria) this;
        }

        public Criteria andEyeCodeLessThan(String value) {
            addCriterion("EYE_CODE <", value, "eyeCode");
            return (Criteria) this;
        }

        public Criteria andEyeCodeLessThanOrEqualTo(String value) {
            addCriterion("EYE_CODE <=", value, "eyeCode");
            return (Criteria) this;
        }

        public Criteria andEyeCodeLike(String value) {
            addCriterion("EYE_CODE like", value, "eyeCode");
            return (Criteria) this;
        }

        public Criteria andEyeCodeNotLike(String value) {
            addCriterion("EYE_CODE not like", value, "eyeCode");
            return (Criteria) this;
        }

        public Criteria andEyeCodeIn(List<String> values) {
            addCriterion("EYE_CODE in", values, "eyeCode");
            return (Criteria) this;
        }

        public Criteria andEyeCodeNotIn(List<String> values) {
            addCriterion("EYE_CODE not in", values, "eyeCode");
            return (Criteria) this;
        }

        public Criteria andEyeCodeBetween(String value1, String value2) {
            addCriterion("EYE_CODE between", value1, value2, "eyeCode");
            return (Criteria) this;
        }

        public Criteria andEyeCodeNotBetween(String value1, String value2) {
            addCriterion("EYE_CODE not between", value1, value2, "eyeCode");
            return (Criteria) this;
        }

        public Criteria andCustomCodeIsNull() {
            addCriterion("CUSTOM_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCustomCodeIsNotNull() {
            addCriterion("CUSTOM_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCustomCodeEqualTo(String value) {
            addCriterion("CUSTOM_CODE =", value, "customCode");
            return (Criteria) this;
        }

        public Criteria andCustomCodeNotEqualTo(String value) {
            addCriterion("CUSTOM_CODE <>", value, "customCode");
            return (Criteria) this;
        }

        public Criteria andCustomCodeGreaterThan(String value) {
            addCriterion("CUSTOM_CODE >", value, "customCode");
            return (Criteria) this;
        }

        public Criteria andCustomCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CUSTOM_CODE >=", value, "customCode");
            return (Criteria) this;
        }

        public Criteria andCustomCodeLessThan(String value) {
            addCriterion("CUSTOM_CODE <", value, "customCode");
            return (Criteria) this;
        }

        public Criteria andCustomCodeLessThanOrEqualTo(String value) {
            addCriterion("CUSTOM_CODE <=", value, "customCode");
            return (Criteria) this;
        }

        public Criteria andCustomCodeLike(String value) {
            addCriterion("CUSTOM_CODE like", value, "customCode");
            return (Criteria) this;
        }

        public Criteria andCustomCodeNotLike(String value) {
            addCriterion("CUSTOM_CODE not like", value, "customCode");
            return (Criteria) this;
        }

        public Criteria andCustomCodeIn(List<String> values) {
            addCriterion("CUSTOM_CODE in", values, "customCode");
            return (Criteria) this;
        }

        public Criteria andCustomCodeNotIn(List<String> values) {
            addCriterion("CUSTOM_CODE not in", values, "customCode");
            return (Criteria) this;
        }

        public Criteria andCustomCodeBetween(String value1, String value2) {
            addCriterion("CUSTOM_CODE between", value1, value2, "customCode");
            return (Criteria) this;
        }

        public Criteria andCustomCodeNotBetween(String value1, String value2) {
            addCriterion("CUSTOM_CODE not between", value1, value2, "customCode");
            return (Criteria) this;
        }

        public Criteria andEyeBankNameIsNull() {
            addCriterion("EYE_BANK_NAME is null");
            return (Criteria) this;
        }

        public Criteria andEyeBankNameIsNotNull() {
            addCriterion("EYE_BANK_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andEyeBankNameEqualTo(String value) {
            addCriterion("EYE_BANK_NAME =", value, "eyeBankName");
            return (Criteria) this;
        }

        public Criteria andEyeBankNameNotEqualTo(String value) {
            addCriterion("EYE_BANK_NAME <>", value, "eyeBankName");
            return (Criteria) this;
        }

        public Criteria andEyeBankNameGreaterThan(String value) {
            addCriterion("EYE_BANK_NAME >", value, "eyeBankName");
            return (Criteria) this;
        }

        public Criteria andEyeBankNameGreaterThanOrEqualTo(String value) {
            addCriterion("EYE_BANK_NAME >=", value, "eyeBankName");
            return (Criteria) this;
        }

        public Criteria andEyeBankNameLessThan(String value) {
            addCriterion("EYE_BANK_NAME <", value, "eyeBankName");
            return (Criteria) this;
        }

        public Criteria andEyeBankNameLessThanOrEqualTo(String value) {
            addCriterion("EYE_BANK_NAME <=", value, "eyeBankName");
            return (Criteria) this;
        }

        public Criteria andEyeBankNameLike(String value) {
            addCriterion("EYE_BANK_NAME like", value, "eyeBankName");
            return (Criteria) this;
        }

        public Criteria andEyeBankNameNotLike(String value) {
            addCriterion("EYE_BANK_NAME not like", value, "eyeBankName");
            return (Criteria) this;
        }

        public Criteria andEyeBankNameIn(List<String> values) {
            addCriterion("EYE_BANK_NAME in", values, "eyeBankName");
            return (Criteria) this;
        }

        public Criteria andEyeBankNameNotIn(List<String> values) {
            addCriterion("EYE_BANK_NAME not in", values, "eyeBankName");
            return (Criteria) this;
        }

        public Criteria andEyeBankNameBetween(String value1, String value2) {
            addCriterion("EYE_BANK_NAME between", value1, value2, "eyeBankName");
            return (Criteria) this;
        }

        public Criteria andEyeBankNameNotBetween(String value1, String value2) {
            addCriterion("EYE_BANK_NAME not between", value1, value2, "eyeBankName");
            return (Criteria) this;
        }

        public Criteria andBranchBankNumberLikeInsensitive(String value) {
            addCriterion("upper(BRANCH_BANK_NUMBER) like", value.toUpperCase(), "branchBankNumber");
            return (Criteria) this;
        }

        public Criteria andBranchBankNameLikeInsensitive(String value) {
            addCriterion("upper(BRANCH_BANK_NAME) like", value.toUpperCase(), "branchBankName");
            return (Criteria) this;
        }

        public Criteria andBankNumberLikeInsensitive(String value) {
            addCriterion("upper(BANK_NUMBER) like", value.toUpperCase(), "bankNumber");
            return (Criteria) this;
        }

        public Criteria andBankNameLikeInsensitive(String value) {
            addCriterion("upper(BANK_NAME) like", value.toUpperCase(), "bankName");
            return (Criteria) this;
        }

        public Criteria andProvinceCodeLikeInsensitive(String value) {
            addCriterion("upper(PROVINCE_CODE) like", value.toUpperCase(), "provinceCode");
            return (Criteria) this;
        }

        public Criteria andProvinceNameLikeInsensitive(String value) {
            addCriterion("upper(PROVINCE_NAME) like", value.toUpperCase(), "provinceName");
            return (Criteria) this;
        }

        public Criteria andCityCodeLikeInsensitive(String value) {
            addCriterion("upper(CITY_CODE) like", value.toUpperCase(), "cityCode");
            return (Criteria) this;
        }

        public Criteria andCityNameLikeInsensitive(String value) {
            addCriterion("upper(CITY_NAME) like", value.toUpperCase(), "cityName");
            return (Criteria) this;
        }

        public Criteria andEyeNameLikeInsensitive(String value) {
            addCriterion("upper(EYE_NAME) like", value.toUpperCase(), "eyeName");
            return (Criteria) this;
        }

        public Criteria andEyeCodeLikeInsensitive(String value) {
            addCriterion("upper(EYE_CODE) like", value.toUpperCase(), "eyeCode");
            return (Criteria) this;
        }

        public Criteria andCustomCodeLikeInsensitive(String value) {
            addCriterion("upper(CUSTOM_CODE) like", value.toUpperCase(), "customCode");
            return (Criteria) this;
        }

        public Criteria andEyeBankNameLikeInsensitive(String value) {
            addCriterion("upper(EYE_BANK_NAME) like", value.toUpperCase(), "eyeBankName");
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