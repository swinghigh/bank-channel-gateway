package com.jkf.channel.gateway.entity;

import java.util.ArrayList;
import java.util.List;

public class AreaUnionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AreaUnionExample() {
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

        public Criteria andProvNoIsNull() {
            addCriterion("PROV_NO is null");
            return (Criteria) this;
        }

        public Criteria andProvNoIsNotNull() {
            addCriterion("PROV_NO is not null");
            return (Criteria) this;
        }

        public Criteria andProvNoEqualTo(String value) {
            addCriterion("PROV_NO =", value, "provNo");
            return (Criteria) this;
        }

        public Criteria andProvNoNotEqualTo(String value) {
            addCriterion("PROV_NO <>", value, "provNo");
            return (Criteria) this;
        }

        public Criteria andProvNoGreaterThan(String value) {
            addCriterion("PROV_NO >", value, "provNo");
            return (Criteria) this;
        }

        public Criteria andProvNoGreaterThanOrEqualTo(String value) {
            addCriterion("PROV_NO >=", value, "provNo");
            return (Criteria) this;
        }

        public Criteria andProvNoLessThan(String value) {
            addCriterion("PROV_NO <", value, "provNo");
            return (Criteria) this;
        }

        public Criteria andProvNoLessThanOrEqualTo(String value) {
            addCriterion("PROV_NO <=", value, "provNo");
            return (Criteria) this;
        }

        public Criteria andProvNoLike(String value) {
            addCriterion("PROV_NO like", value, "provNo");
            return (Criteria) this;
        }

        public Criteria andProvNoNotLike(String value) {
            addCriterion("PROV_NO not like", value, "provNo");
            return (Criteria) this;
        }

        public Criteria andProvNoIn(List<String> values) {
            addCriterion("PROV_NO in", values, "provNo");
            return (Criteria) this;
        }

        public Criteria andProvNoNotIn(List<String> values) {
            addCriterion("PROV_NO not in", values, "provNo");
            return (Criteria) this;
        }

        public Criteria andProvNoBetween(String value1, String value2) {
            addCriterion("PROV_NO between", value1, value2, "provNo");
            return (Criteria) this;
        }

        public Criteria andProvNoNotBetween(String value1, String value2) {
            addCriterion("PROV_NO not between", value1, value2, "provNo");
            return (Criteria) this;
        }

        public Criteria andStateNmIsNull() {
            addCriterion("STATE_NM is null");
            return (Criteria) this;
        }

        public Criteria andStateNmIsNotNull() {
            addCriterion("STATE_NM is not null");
            return (Criteria) this;
        }

        public Criteria andStateNmEqualTo(String value) {
            addCriterion("STATE_NM =", value, "stateNm");
            return (Criteria) this;
        }

        public Criteria andStateNmNotEqualTo(String value) {
            addCriterion("STATE_NM <>", value, "stateNm");
            return (Criteria) this;
        }

        public Criteria andStateNmGreaterThan(String value) {
            addCriterion("STATE_NM >", value, "stateNm");
            return (Criteria) this;
        }

        public Criteria andStateNmGreaterThanOrEqualTo(String value) {
            addCriterion("STATE_NM >=", value, "stateNm");
            return (Criteria) this;
        }

        public Criteria andStateNmLessThan(String value) {
            addCriterion("STATE_NM <", value, "stateNm");
            return (Criteria) this;
        }

        public Criteria andStateNmLessThanOrEqualTo(String value) {
            addCriterion("STATE_NM <=", value, "stateNm");
            return (Criteria) this;
        }

        public Criteria andStateNmLike(String value) {
            addCriterion("STATE_NM like", value, "stateNm");
            return (Criteria) this;
        }

        public Criteria andStateNmNotLike(String value) {
            addCriterion("STATE_NM not like", value, "stateNm");
            return (Criteria) this;
        }

        public Criteria andStateNmIn(List<String> values) {
            addCriterion("STATE_NM in", values, "stateNm");
            return (Criteria) this;
        }

        public Criteria andStateNmNotIn(List<String> values) {
            addCriterion("STATE_NM not in", values, "stateNm");
            return (Criteria) this;
        }

        public Criteria andStateNmBetween(String value1, String value2) {
            addCriterion("STATE_NM between", value1, value2, "stateNm");
            return (Criteria) this;
        }

        public Criteria andStateNmNotBetween(String value1, String value2) {
            addCriterion("STATE_NM not between", value1, value2, "stateNm");
            return (Criteria) this;
        }

        public Criteria andCityNoIsNull() {
            addCriterion("CITY_NO is null");
            return (Criteria) this;
        }

        public Criteria andCityNoIsNotNull() {
            addCriterion("CITY_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCityNoEqualTo(String value) {
            addCriterion("CITY_NO =", value, "cityNo");
            return (Criteria) this;
        }

        public Criteria andCityNoNotEqualTo(String value) {
            addCriterion("CITY_NO <>", value, "cityNo");
            return (Criteria) this;
        }

        public Criteria andCityNoGreaterThan(String value) {
            addCriterion("CITY_NO >", value, "cityNo");
            return (Criteria) this;
        }

        public Criteria andCityNoGreaterThanOrEqualTo(String value) {
            addCriterion("CITY_NO >=", value, "cityNo");
            return (Criteria) this;
        }

        public Criteria andCityNoLessThan(String value) {
            addCriterion("CITY_NO <", value, "cityNo");
            return (Criteria) this;
        }

        public Criteria andCityNoLessThanOrEqualTo(String value) {
            addCriterion("CITY_NO <=", value, "cityNo");
            return (Criteria) this;
        }

        public Criteria andCityNoLike(String value) {
            addCriterion("CITY_NO like", value, "cityNo");
            return (Criteria) this;
        }

        public Criteria andCityNoNotLike(String value) {
            addCriterion("CITY_NO not like", value, "cityNo");
            return (Criteria) this;
        }

        public Criteria andCityNoIn(List<String> values) {
            addCriterion("CITY_NO in", values, "cityNo");
            return (Criteria) this;
        }

        public Criteria andCityNoNotIn(List<String> values) {
            addCriterion("CITY_NO not in", values, "cityNo");
            return (Criteria) this;
        }

        public Criteria andCityNoBetween(String value1, String value2) {
            addCriterion("CITY_NO between", value1, value2, "cityNo");
            return (Criteria) this;
        }

        public Criteria andCityNoNotBetween(String value1, String value2) {
            addCriterion("CITY_NO not between", value1, value2, "cityNo");
            return (Criteria) this;
        }

        public Criteria andCityNmIsNull() {
            addCriterion("CITY_NM is null");
            return (Criteria) this;
        }

        public Criteria andCityNmIsNotNull() {
            addCriterion("CITY_NM is not null");
            return (Criteria) this;
        }

        public Criteria andCityNmEqualTo(String value) {
            addCriterion("CITY_NM =", value, "cityNm");
            return (Criteria) this;
        }

        public Criteria andCityNmNotEqualTo(String value) {
            addCriterion("CITY_NM <>", value, "cityNm");
            return (Criteria) this;
        }

        public Criteria andCityNmGreaterThan(String value) {
            addCriterion("CITY_NM >", value, "cityNm");
            return (Criteria) this;
        }

        public Criteria andCityNmGreaterThanOrEqualTo(String value) {
            addCriterion("CITY_NM >=", value, "cityNm");
            return (Criteria) this;
        }

        public Criteria andCityNmLessThan(String value) {
            addCriterion("CITY_NM <", value, "cityNm");
            return (Criteria) this;
        }

        public Criteria andCityNmLessThanOrEqualTo(String value) {
            addCriterion("CITY_NM <=", value, "cityNm");
            return (Criteria) this;
        }

        public Criteria andCityNmLike(String value) {
            addCriterion("CITY_NM like", value, "cityNm");
            return (Criteria) this;
        }

        public Criteria andCityNmNotLike(String value) {
            addCriterion("CITY_NM not like", value, "cityNm");
            return (Criteria) this;
        }

        public Criteria andCityNmIn(List<String> values) {
            addCriterion("CITY_NM in", values, "cityNm");
            return (Criteria) this;
        }

        public Criteria andCityNmNotIn(List<String> values) {
            addCriterion("CITY_NM not in", values, "cityNm");
            return (Criteria) this;
        }

        public Criteria andCityNmBetween(String value1, String value2) {
            addCriterion("CITY_NM between", value1, value2, "cityNm");
            return (Criteria) this;
        }

        public Criteria andCityNmNotBetween(String value1, String value2) {
            addCriterion("CITY_NM not between", value1, value2, "cityNm");
            return (Criteria) this;
        }

        public Criteria andCountyNoIsNull() {
            addCriterion("COUNTY_NO is null");
            return (Criteria) this;
        }

        public Criteria andCountyNoIsNotNull() {
            addCriterion("COUNTY_NO is not null");
            return (Criteria) this;
        }

        public Criteria andCountyNoEqualTo(String value) {
            addCriterion("COUNTY_NO =", value, "countyNo");
            return (Criteria) this;
        }

        public Criteria andCountyNoNotEqualTo(String value) {
            addCriterion("COUNTY_NO <>", value, "countyNo");
            return (Criteria) this;
        }

        public Criteria andCountyNoGreaterThan(String value) {
            addCriterion("COUNTY_NO >", value, "countyNo");
            return (Criteria) this;
        }

        public Criteria andCountyNoGreaterThanOrEqualTo(String value) {
            addCriterion("COUNTY_NO >=", value, "countyNo");
            return (Criteria) this;
        }

        public Criteria andCountyNoLessThan(String value) {
            addCriterion("COUNTY_NO <", value, "countyNo");
            return (Criteria) this;
        }

        public Criteria andCountyNoLessThanOrEqualTo(String value) {
            addCriterion("COUNTY_NO <=", value, "countyNo");
            return (Criteria) this;
        }

        public Criteria andCountyNoLike(String value) {
            addCriterion("COUNTY_NO like", value, "countyNo");
            return (Criteria) this;
        }

        public Criteria andCountyNoNotLike(String value) {
            addCriterion("COUNTY_NO not like", value, "countyNo");
            return (Criteria) this;
        }

        public Criteria andCountyNoIn(List<String> values) {
            addCriterion("COUNTY_NO in", values, "countyNo");
            return (Criteria) this;
        }

        public Criteria andCountyNoNotIn(List<String> values) {
            addCriterion("COUNTY_NO not in", values, "countyNo");
            return (Criteria) this;
        }

        public Criteria andCountyNoBetween(String value1, String value2) {
            addCriterion("COUNTY_NO between", value1, value2, "countyNo");
            return (Criteria) this;
        }

        public Criteria andCountyNoNotBetween(String value1, String value2) {
            addCriterion("COUNTY_NO not between", value1, value2, "countyNo");
            return (Criteria) this;
        }

        public Criteria andCountyNmIsNull() {
            addCriterion("COUNTY_NM is null");
            return (Criteria) this;
        }

        public Criteria andCountyNmIsNotNull() {
            addCriterion("COUNTY_NM is not null");
            return (Criteria) this;
        }

        public Criteria andCountyNmEqualTo(String value) {
            addCriterion("COUNTY_NM =", value, "countyNm");
            return (Criteria) this;
        }

        public Criteria andCountyNmNotEqualTo(String value) {
            addCriterion("COUNTY_NM <>", value, "countyNm");
            return (Criteria) this;
        }

        public Criteria andCountyNmGreaterThan(String value) {
            addCriterion("COUNTY_NM >", value, "countyNm");
            return (Criteria) this;
        }

        public Criteria andCountyNmGreaterThanOrEqualTo(String value) {
            addCriterion("COUNTY_NM >=", value, "countyNm");
            return (Criteria) this;
        }

        public Criteria andCountyNmLessThan(String value) {
            addCriterion("COUNTY_NM <", value, "countyNm");
            return (Criteria) this;
        }

        public Criteria andCountyNmLessThanOrEqualTo(String value) {
            addCriterion("COUNTY_NM <=", value, "countyNm");
            return (Criteria) this;
        }

        public Criteria andCountyNmLike(String value) {
            addCriterion("COUNTY_NM like", value, "countyNm");
            return (Criteria) this;
        }

        public Criteria andCountyNmNotLike(String value) {
            addCriterion("COUNTY_NM not like", value, "countyNm");
            return (Criteria) this;
        }

        public Criteria andCountyNmIn(List<String> values) {
            addCriterion("COUNTY_NM in", values, "countyNm");
            return (Criteria) this;
        }

        public Criteria andCountyNmNotIn(List<String> values) {
            addCriterion("COUNTY_NM not in", values, "countyNm");
            return (Criteria) this;
        }

        public Criteria andCountyNmBetween(String value1, String value2) {
            addCriterion("COUNTY_NM between", value1, value2, "countyNm");
            return (Criteria) this;
        }

        public Criteria andCountyNmNotBetween(String value1, String value2) {
            addCriterion("COUNTY_NM not between", value1, value2, "countyNm");
            return (Criteria) this;
        }

        public Criteria andUnionAreaIsNull() {
            addCriterion("UNION_AREA is null");
            return (Criteria) this;
        }

        public Criteria andUnionAreaIsNotNull() {
            addCriterion("UNION_AREA is not null");
            return (Criteria) this;
        }

        public Criteria andUnionAreaEqualTo(String value) {
            addCriterion("UNION_AREA =", value, "unionArea");
            return (Criteria) this;
        }

        public Criteria andUnionAreaNotEqualTo(String value) {
            addCriterion("UNION_AREA <>", value, "unionArea");
            return (Criteria) this;
        }

        public Criteria andUnionAreaGreaterThan(String value) {
            addCriterion("UNION_AREA >", value, "unionArea");
            return (Criteria) this;
        }

        public Criteria andUnionAreaGreaterThanOrEqualTo(String value) {
            addCriterion("UNION_AREA >=", value, "unionArea");
            return (Criteria) this;
        }

        public Criteria andUnionAreaLessThan(String value) {
            addCriterion("UNION_AREA <", value, "unionArea");
            return (Criteria) this;
        }

        public Criteria andUnionAreaLessThanOrEqualTo(String value) {
            addCriterion("UNION_AREA <=", value, "unionArea");
            return (Criteria) this;
        }

        public Criteria andUnionAreaLike(String value) {
            addCriterion("UNION_AREA like", value, "unionArea");
            return (Criteria) this;
        }

        public Criteria andUnionAreaNotLike(String value) {
            addCriterion("UNION_AREA not like", value, "unionArea");
            return (Criteria) this;
        }

        public Criteria andUnionAreaIn(List<String> values) {
            addCriterion("UNION_AREA in", values, "unionArea");
            return (Criteria) this;
        }

        public Criteria andUnionAreaNotIn(List<String> values) {
            addCriterion("UNION_AREA not in", values, "unionArea");
            return (Criteria) this;
        }

        public Criteria andUnionAreaBetween(String value1, String value2) {
            addCriterion("UNION_AREA between", value1, value2, "unionArea");
            return (Criteria) this;
        }

        public Criteria andUnionAreaNotBetween(String value1, String value2) {
            addCriterion("UNION_AREA not between", value1, value2, "unionArea");
            return (Criteria) this;
        }

        public Criteria andZoneCountyIsNull() {
            addCriterion("ZONE_COUNTY is null");
            return (Criteria) this;
        }

        public Criteria andZoneCountyIsNotNull() {
            addCriterion("ZONE_COUNTY is not null");
            return (Criteria) this;
        }

        public Criteria andZoneCountyEqualTo(String value) {
            addCriterion("ZONE_COUNTY =", value, "zoneCounty");
            return (Criteria) this;
        }

        public Criteria andZoneCountyNotEqualTo(String value) {
            addCriterion("ZONE_COUNTY <>", value, "zoneCounty");
            return (Criteria) this;
        }

        public Criteria andZoneCountyGreaterThan(String value) {
            addCriterion("ZONE_COUNTY >", value, "zoneCounty");
            return (Criteria) this;
        }

        public Criteria andZoneCountyGreaterThanOrEqualTo(String value) {
            addCriterion("ZONE_COUNTY >=", value, "zoneCounty");
            return (Criteria) this;
        }

        public Criteria andZoneCountyLessThan(String value) {
            addCriterion("ZONE_COUNTY <", value, "zoneCounty");
            return (Criteria) this;
        }

        public Criteria andZoneCountyLessThanOrEqualTo(String value) {
            addCriterion("ZONE_COUNTY <=", value, "zoneCounty");
            return (Criteria) this;
        }

        public Criteria andZoneCountyLike(String value) {
            addCriterion("ZONE_COUNTY like", value, "zoneCounty");
            return (Criteria) this;
        }

        public Criteria andZoneCountyNotLike(String value) {
            addCriterion("ZONE_COUNTY not like", value, "zoneCounty");
            return (Criteria) this;
        }

        public Criteria andZoneCountyIn(List<String> values) {
            addCriterion("ZONE_COUNTY in", values, "zoneCounty");
            return (Criteria) this;
        }

        public Criteria andZoneCountyNotIn(List<String> values) {
            addCriterion("ZONE_COUNTY not in", values, "zoneCounty");
            return (Criteria) this;
        }

        public Criteria andZoneCountyBetween(String value1, String value2) {
            addCriterion("ZONE_COUNTY between", value1, value2, "zoneCounty");
            return (Criteria) this;
        }

        public Criteria andZoneCountyNotBetween(String value1, String value2) {
            addCriterion("ZONE_COUNTY not between", value1, value2, "zoneCounty");
            return (Criteria) this;
        }

        public Criteria andZoneProvIsNull() {
            addCriterion("ZONE_PROV is null");
            return (Criteria) this;
        }

        public Criteria andZoneProvIsNotNull() {
            addCriterion("ZONE_PROV is not null");
            return (Criteria) this;
        }

        public Criteria andZoneProvEqualTo(String value) {
            addCriterion("ZONE_PROV =", value, "zoneProv");
            return (Criteria) this;
        }

        public Criteria andZoneProvNotEqualTo(String value) {
            addCriterion("ZONE_PROV <>", value, "zoneProv");
            return (Criteria) this;
        }

        public Criteria andZoneProvGreaterThan(String value) {
            addCriterion("ZONE_PROV >", value, "zoneProv");
            return (Criteria) this;
        }

        public Criteria andZoneProvGreaterThanOrEqualTo(String value) {
            addCriterion("ZONE_PROV >=", value, "zoneProv");
            return (Criteria) this;
        }

        public Criteria andZoneProvLessThan(String value) {
            addCriterion("ZONE_PROV <", value, "zoneProv");
            return (Criteria) this;
        }

        public Criteria andZoneProvLessThanOrEqualTo(String value) {
            addCriterion("ZONE_PROV <=", value, "zoneProv");
            return (Criteria) this;
        }

        public Criteria andZoneProvLike(String value) {
            addCriterion("ZONE_PROV like", value, "zoneProv");
            return (Criteria) this;
        }

        public Criteria andZoneProvNotLike(String value) {
            addCriterion("ZONE_PROV not like", value, "zoneProv");
            return (Criteria) this;
        }

        public Criteria andZoneProvIn(List<String> values) {
            addCriterion("ZONE_PROV in", values, "zoneProv");
            return (Criteria) this;
        }

        public Criteria andZoneProvNotIn(List<String> values) {
            addCriterion("ZONE_PROV not in", values, "zoneProv");
            return (Criteria) this;
        }

        public Criteria andZoneProvBetween(String value1, String value2) {
            addCriterion("ZONE_PROV between", value1, value2, "zoneProv");
            return (Criteria) this;
        }

        public Criteria andZoneProvNotBetween(String value1, String value2) {
            addCriterion("ZONE_PROV not between", value1, value2, "zoneProv");
            return (Criteria) this;
        }

        public Criteria andZoneCityIsNull() {
            addCriterion("ZONE_CITY is null");
            return (Criteria) this;
        }

        public Criteria andZoneCityIsNotNull() {
            addCriterion("ZONE_CITY is not null");
            return (Criteria) this;
        }

        public Criteria andZoneCityEqualTo(String value) {
            addCriterion("ZONE_CITY =", value, "zoneCity");
            return (Criteria) this;
        }

        public Criteria andZoneCityNotEqualTo(String value) {
            addCriterion("ZONE_CITY <>", value, "zoneCity");
            return (Criteria) this;
        }

        public Criteria andZoneCityGreaterThan(String value) {
            addCriterion("ZONE_CITY >", value, "zoneCity");
            return (Criteria) this;
        }

        public Criteria andZoneCityGreaterThanOrEqualTo(String value) {
            addCriterion("ZONE_CITY >=", value, "zoneCity");
            return (Criteria) this;
        }

        public Criteria andZoneCityLessThan(String value) {
            addCriterion("ZONE_CITY <", value, "zoneCity");
            return (Criteria) this;
        }

        public Criteria andZoneCityLessThanOrEqualTo(String value) {
            addCriterion("ZONE_CITY <=", value, "zoneCity");
            return (Criteria) this;
        }

        public Criteria andZoneCityLike(String value) {
            addCriterion("ZONE_CITY like", value, "zoneCity");
            return (Criteria) this;
        }

        public Criteria andZoneCityNotLike(String value) {
            addCriterion("ZONE_CITY not like", value, "zoneCity");
            return (Criteria) this;
        }

        public Criteria andZoneCityIn(List<String> values) {
            addCriterion("ZONE_CITY in", values, "zoneCity");
            return (Criteria) this;
        }

        public Criteria andZoneCityNotIn(List<String> values) {
            addCriterion("ZONE_CITY not in", values, "zoneCity");
            return (Criteria) this;
        }

        public Criteria andZoneCityBetween(String value1, String value2) {
            addCriterion("ZONE_CITY between", value1, value2, "zoneCity");
            return (Criteria) this;
        }

        public Criteria andZoneCityNotBetween(String value1, String value2) {
            addCriterion("ZONE_CITY not between", value1, value2, "zoneCity");
            return (Criteria) this;
        }

        public Criteria andProvNoLikeInsensitive(String value) {
            addCriterion("upper(PROV_NO) like", value.toUpperCase(), "provNo");
            return (Criteria) this;
        }

        public Criteria andStateNmLikeInsensitive(String value) {
            addCriterion("upper(STATE_NM) like", value.toUpperCase(), "stateNm");
            return (Criteria) this;
        }

        public Criteria andCityNoLikeInsensitive(String value) {
            addCriterion("upper(CITY_NO) like", value.toUpperCase(), "cityNo");
            return (Criteria) this;
        }

        public Criteria andCityNmLikeInsensitive(String value) {
            addCriterion("upper(CITY_NM) like", value.toUpperCase(), "cityNm");
            return (Criteria) this;
        }

        public Criteria andCountyNoLikeInsensitive(String value) {
            addCriterion("upper(COUNTY_NO) like", value.toUpperCase(), "countyNo");
            return (Criteria) this;
        }

        public Criteria andCountyNmLikeInsensitive(String value) {
            addCriterion("upper(COUNTY_NM) like", value.toUpperCase(), "countyNm");
            return (Criteria) this;
        }

        public Criteria andUnionAreaLikeInsensitive(String value) {
            addCriterion("upper(UNION_AREA) like", value.toUpperCase(), "unionArea");
            return (Criteria) this;
        }

        public Criteria andZoneCountyLikeInsensitive(String value) {
            addCriterion("upper(ZONE_COUNTY) like", value.toUpperCase(), "zoneCounty");
            return (Criteria) this;
        }

        public Criteria andZoneProvLikeInsensitive(String value) {
            addCriterion("upper(ZONE_PROV) like", value.toUpperCase(), "zoneProv");
            return (Criteria) this;
        }

        public Criteria andZoneCityLikeInsensitive(String value) {
            addCriterion("upper(ZONE_CITY) like", value.toUpperCase(), "zoneCity");
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