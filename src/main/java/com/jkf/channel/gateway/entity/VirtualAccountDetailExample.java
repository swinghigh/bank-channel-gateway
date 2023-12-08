package com.jkf.channel.gateway.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VirtualAccountDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VirtualAccountDetailExample() {
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

        public Criteria andIsAddIsNull() {
            addCriterion("is_add is null");
            return (Criteria) this;
        }

        public Criteria andIsAddIsNotNull() {
            addCriterion("is_add is not null");
            return (Criteria) this;
        }

        public Criteria andIsAddEqualTo(String value) {
            addCriterion("is_add =", value, "isAdd");
            return (Criteria) this;
        }

        public Criteria andIsAddNotEqualTo(String value) {
            addCriterion("is_add <>", value, "isAdd");
            return (Criteria) this;
        }

        public Criteria andIsAddGreaterThan(String value) {
            addCriterion("is_add >", value, "isAdd");
            return (Criteria) this;
        }

        public Criteria andIsAddGreaterThanOrEqualTo(String value) {
            addCriterion("is_add >=", value, "isAdd");
            return (Criteria) this;
        }

        public Criteria andIsAddLessThan(String value) {
            addCriterion("is_add <", value, "isAdd");
            return (Criteria) this;
        }

        public Criteria andIsAddLessThanOrEqualTo(String value) {
            addCriterion("is_add <=", value, "isAdd");
            return (Criteria) this;
        }

        public Criteria andIsAddLike(String value) {
            addCriterion("is_add like", value, "isAdd");
            return (Criteria) this;
        }

        public Criteria andIsAddNotLike(String value) {
            addCriterion("is_add not like", value, "isAdd");
            return (Criteria) this;
        }

        public Criteria andIsAddIn(List<String> values) {
            addCriterion("is_add in", values, "isAdd");
            return (Criteria) this;
        }

        public Criteria andIsAddNotIn(List<String> values) {
            addCriterion("is_add not in", values, "isAdd");
            return (Criteria) this;
        }

        public Criteria andIsAddBetween(String value1, String value2) {
            addCriterion("is_add between", value1, value2, "isAdd");
            return (Criteria) this;
        }

        public Criteria andIsAddNotBetween(String value1, String value2) {
            addCriterion("is_add not between", value1, value2, "isAdd");
            return (Criteria) this;
        }

        public Criteria andActTypeIsNull() {
            addCriterion("act_type is null");
            return (Criteria) this;
        }

        public Criteria andActTypeIsNotNull() {
            addCriterion("act_type is not null");
            return (Criteria) this;
        }

        public Criteria andActTypeEqualTo(String value) {
            addCriterion("act_type =", value, "actType");
            return (Criteria) this;
        }

        public Criteria andActTypeNotEqualTo(String value) {
            addCriterion("act_type <>", value, "actType");
            return (Criteria) this;
        }

        public Criteria andActTypeGreaterThan(String value) {
            addCriterion("act_type >", value, "actType");
            return (Criteria) this;
        }

        public Criteria andActTypeGreaterThanOrEqualTo(String value) {
            addCriterion("act_type >=", value, "actType");
            return (Criteria) this;
        }

        public Criteria andActTypeLessThan(String value) {
            addCriterion("act_type <", value, "actType");
            return (Criteria) this;
        }

        public Criteria andActTypeLessThanOrEqualTo(String value) {
            addCriterion("act_type <=", value, "actType");
            return (Criteria) this;
        }

        public Criteria andActTypeLike(String value) {
            addCriterion("act_type like", value, "actType");
            return (Criteria) this;
        }

        public Criteria andActTypeNotLike(String value) {
            addCriterion("act_type not like", value, "actType");
            return (Criteria) this;
        }

        public Criteria andActTypeIn(List<String> values) {
            addCriterion("act_type in", values, "actType");
            return (Criteria) this;
        }

        public Criteria andActTypeNotIn(List<String> values) {
            addCriterion("act_type not in", values, "actType");
            return (Criteria) this;
        }

        public Criteria andActTypeBetween(String value1, String value2) {
            addCriterion("act_type between", value1, value2, "actType");
            return (Criteria) this;
        }

        public Criteria andActTypeNotBetween(String value1, String value2) {
            addCriterion("act_type not between", value1, value2, "actType");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(String value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(String value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(String value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(String value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(String value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(String value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLike(String value) {
            addCriterion("amount like", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotLike(String value) {
            addCriterion("amount not like", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<String> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<String> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(String value1, String value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(String value1, String value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andChargeIsNull() {
            addCriterion("charge is null");
            return (Criteria) this;
        }

        public Criteria andChargeIsNotNull() {
            addCriterion("charge is not null");
            return (Criteria) this;
        }

        public Criteria andChargeEqualTo(String value) {
            addCriterion("charge =", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeNotEqualTo(String value) {
            addCriterion("charge <>", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeGreaterThan(String value) {
            addCriterion("charge >", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeGreaterThanOrEqualTo(String value) {
            addCriterion("charge >=", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeLessThan(String value) {
            addCriterion("charge <", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeLessThanOrEqualTo(String value) {
            addCriterion("charge <=", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeLike(String value) {
            addCriterion("charge like", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeNotLike(String value) {
            addCriterion("charge not like", value, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeIn(List<String> values) {
            addCriterion("charge in", values, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeNotIn(List<String> values) {
            addCriterion("charge not in", values, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeBetween(String value1, String value2) {
            addCriterion("charge between", value1, value2, "charge");
            return (Criteria) this;
        }

        public Criteria andChargeNotBetween(String value1, String value2) {
            addCriterion("charge not between", value1, value2, "charge");
            return (Criteria) this;
        }

        public Criteria andFinalAmountIsNull() {
            addCriterion("final_amount is null");
            return (Criteria) this;
        }

        public Criteria andFinalAmountIsNotNull() {
            addCriterion("final_amount is not null");
            return (Criteria) this;
        }

        public Criteria andFinalAmountEqualTo(String value) {
            addCriterion("final_amount =", value, "finalAmount");
            return (Criteria) this;
        }

        public Criteria andFinalAmountNotEqualTo(String value) {
            addCriterion("final_amount <>", value, "finalAmount");
            return (Criteria) this;
        }

        public Criteria andFinalAmountGreaterThan(String value) {
            addCriterion("final_amount >", value, "finalAmount");
            return (Criteria) this;
        }

        public Criteria andFinalAmountGreaterThanOrEqualTo(String value) {
            addCriterion("final_amount >=", value, "finalAmount");
            return (Criteria) this;
        }

        public Criteria andFinalAmountLessThan(String value) {
            addCriterion("final_amount <", value, "finalAmount");
            return (Criteria) this;
        }

        public Criteria andFinalAmountLessThanOrEqualTo(String value) {
            addCriterion("final_amount <=", value, "finalAmount");
            return (Criteria) this;
        }

        public Criteria andFinalAmountLike(String value) {
            addCriterion("final_amount like", value, "finalAmount");
            return (Criteria) this;
        }

        public Criteria andFinalAmountNotLike(String value) {
            addCriterion("final_amount not like", value, "finalAmount");
            return (Criteria) this;
        }

        public Criteria andFinalAmountIn(List<String> values) {
            addCriterion("final_amount in", values, "finalAmount");
            return (Criteria) this;
        }

        public Criteria andFinalAmountNotIn(List<String> values) {
            addCriterion("final_amount not in", values, "finalAmount");
            return (Criteria) this;
        }

        public Criteria andFinalAmountBetween(String value1, String value2) {
            addCriterion("final_amount between", value1, value2, "finalAmount");
            return (Criteria) this;
        }

        public Criteria andFinalAmountNotBetween(String value1, String value2) {
            addCriterion("final_amount not between", value1, value2, "finalAmount");
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

        public Criteria andActDateIsNull() {
            addCriterion("act_date is null");
            return (Criteria) this;
        }

        public Criteria andActDateIsNotNull() {
            addCriterion("act_date is not null");
            return (Criteria) this;
        }

        public Criteria andActDateEqualTo(String value) {
            addCriterion("act_date =", value, "actDate");
            return (Criteria) this;
        }

        public Criteria andActDateNotEqualTo(String value) {
            addCriterion("act_date <>", value, "actDate");
            return (Criteria) this;
        }

        public Criteria andActDateGreaterThan(String value) {
            addCriterion("act_date >", value, "actDate");
            return (Criteria) this;
        }

        public Criteria andActDateGreaterThanOrEqualTo(String value) {
            addCriterion("act_date >=", value, "actDate");
            return (Criteria) this;
        }

        public Criteria andActDateLessThan(String value) {
            addCriterion("act_date <", value, "actDate");
            return (Criteria) this;
        }

        public Criteria andActDateLessThanOrEqualTo(String value) {
            addCriterion("act_date <=", value, "actDate");
            return (Criteria) this;
        }

        public Criteria andActDateLike(String value) {
            addCriterion("act_date like", value, "actDate");
            return (Criteria) this;
        }

        public Criteria andActDateNotLike(String value) {
            addCriterion("act_date not like", value, "actDate");
            return (Criteria) this;
        }

        public Criteria andActDateIn(List<String> values) {
            addCriterion("act_date in", values, "actDate");
            return (Criteria) this;
        }

        public Criteria andActDateNotIn(List<String> values) {
            addCriterion("act_date not in", values, "actDate");
            return (Criteria) this;
        }

        public Criteria andActDateBetween(String value1, String value2) {
            addCriterion("act_date between", value1, value2, "actDate");
            return (Criteria) this;
        }

        public Criteria andActDateNotBetween(String value1, String value2) {
            addCriterion("act_date not between", value1, value2, "actDate");
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

        public Criteria andAddBlanceIsNull() {
            addCriterion("add_blance is null");
            return (Criteria) this;
        }

        public Criteria andAddBlanceIsNotNull() {
            addCriterion("add_blance is not null");
            return (Criteria) this;
        }

        public Criteria andAddBlanceEqualTo(String value) {
            addCriterion("add_blance =", value, "addBlance");
            return (Criteria) this;
        }

        public Criteria andAddBlanceNotEqualTo(String value) {
            addCriterion("add_blance <>", value, "addBlance");
            return (Criteria) this;
        }

        public Criteria andAddBlanceGreaterThan(String value) {
            addCriterion("add_blance >", value, "addBlance");
            return (Criteria) this;
        }

        public Criteria andAddBlanceGreaterThanOrEqualTo(String value) {
            addCriterion("add_blance >=", value, "addBlance");
            return (Criteria) this;
        }

        public Criteria andAddBlanceLessThan(String value) {
            addCriterion("add_blance <", value, "addBlance");
            return (Criteria) this;
        }

        public Criteria andAddBlanceLessThanOrEqualTo(String value) {
            addCriterion("add_blance <=", value, "addBlance");
            return (Criteria) this;
        }

        public Criteria andAddBlanceLike(String value) {
            addCriterion("add_blance like", value, "addBlance");
            return (Criteria) this;
        }

        public Criteria andAddBlanceNotLike(String value) {
            addCriterion("add_blance not like", value, "addBlance");
            return (Criteria) this;
        }

        public Criteria andAddBlanceIn(List<String> values) {
            addCriterion("add_blance in", values, "addBlance");
            return (Criteria) this;
        }

        public Criteria andAddBlanceNotIn(List<String> values) {
            addCriterion("add_blance not in", values, "addBlance");
            return (Criteria) this;
        }

        public Criteria andAddBlanceBetween(String value1, String value2) {
            addCriterion("add_blance between", value1, value2, "addBlance");
            return (Criteria) this;
        }

        public Criteria andAddBlanceNotBetween(String value1, String value2) {
            addCriterion("add_blance not between", value1, value2, "addBlance");
            return (Criteria) this;
        }

        public Criteria andAddNameIsNull() {
            addCriterion("add_name is null");
            return (Criteria) this;
        }

        public Criteria andAddNameIsNotNull() {
            addCriterion("add_name is not null");
            return (Criteria) this;
        }

        public Criteria andAddNameEqualTo(String value) {
            addCriterion("add_name =", value, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameNotEqualTo(String value) {
            addCriterion("add_name <>", value, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameGreaterThan(String value) {
            addCriterion("add_name >", value, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameGreaterThanOrEqualTo(String value) {
            addCriterion("add_name >=", value, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameLessThan(String value) {
            addCriterion("add_name <", value, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameLessThanOrEqualTo(String value) {
            addCriterion("add_name <=", value, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameLike(String value) {
            addCriterion("add_name like", value, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameNotLike(String value) {
            addCriterion("add_name not like", value, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameIn(List<String> values) {
            addCriterion("add_name in", values, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameNotIn(List<String> values) {
            addCriterion("add_name not in", values, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameBetween(String value1, String value2) {
            addCriterion("add_name between", value1, value2, "addName");
            return (Criteria) this;
        }

        public Criteria andAddNameNotBetween(String value1, String value2) {
            addCriterion("add_name not between", value1, value2, "addName");
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

        public Criteria andIsAddLikeInsensitive(String value) {
            addCriterion("upper(is_add) like", value.toUpperCase(), "isAdd");
            return (Criteria) this;
        }

        public Criteria andActTypeLikeInsensitive(String value) {
            addCriterion("upper(act_type) like", value.toUpperCase(), "actType");
            return (Criteria) this;
        }

        public Criteria andAmountLikeInsensitive(String value) {
            addCriterion("upper(amount) like", value.toUpperCase(), "amount");
            return (Criteria) this;
        }

        public Criteria andChargeLikeInsensitive(String value) {
            addCriterion("upper(charge) like", value.toUpperCase(), "charge");
            return (Criteria) this;
        }

        public Criteria andFinalAmountLikeInsensitive(String value) {
            addCriterion("upper(final_amount) like", value.toUpperCase(), "finalAmount");
            return (Criteria) this;
        }

        public Criteria andRemarkLikeInsensitive(String value) {
            addCriterion("upper(remark) like", value.toUpperCase(), "remark");
            return (Criteria) this;
        }

        public Criteria andActDateLikeInsensitive(String value) {
            addCriterion("upper(act_date) like", value.toUpperCase(), "actDate");
            return (Criteria) this;
        }

        public Criteria andSerialLikeInsensitive(String value) {
            addCriterion("upper(serial) like", value.toUpperCase(), "serial");
            return (Criteria) this;
        }

        public Criteria andAddBlanceLikeInsensitive(String value) {
            addCriterion("upper(add_blance) like", value.toUpperCase(), "addBlance");
            return (Criteria) this;
        }

        public Criteria andAddNameLikeInsensitive(String value) {
            addCriterion("upper(add_name) like", value.toUpperCase(), "addName");
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