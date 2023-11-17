package com.jkf.channel.gateway.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class AreaUnion implements Serializable {
    private String provNo;

    private String stateNm;

    private String cityNo;

    private String cityNm;

    private String countyNo;

    private String countyNm;

    private String unionArea;

    private String zoneCounty;

    private String zoneProv;

    private String zoneCity;

    private static final long serialVersionUID = 1L;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", provNo=").append(provNo);
        sb.append(", stateNm=").append(stateNm);
        sb.append(", cityNo=").append(cityNo);
        sb.append(", cityNm=").append(cityNm);
        sb.append(", countyNo=").append(countyNo);
        sb.append(", countyNm=").append(countyNm);
        sb.append(", unionArea=").append(unionArea);
        sb.append(", zoneCounty=").append(zoneCounty);
        sb.append(", zoneProv=").append(zoneProv);
        sb.append(", zoneCity=").append(zoneCity);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}