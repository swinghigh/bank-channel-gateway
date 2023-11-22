package com.jkf.channel.gateway.entity;

import java.io.Serializable;

public class BankSubInfo implements Serializable {
    private String branchBankNumber;

    private String branchBankName;

    private String bankNumber;

    private String bankName;

    private String provinceCode;

    private String provinceName;

    private String cityCode;

    private String cityName;

    private String eyeName;

    private String eyeCode;

    private String customCode;

    private String eyeBankName;

    private static final long serialVersionUID = 1L;

    public String getBranchBankNumber() {
        return branchBankNumber;
    }

    public void setBranchBankNumber(String branchBankNumber) {
        this.branchBankNumber = branchBankNumber == null ? null : branchBankNumber.trim();
    }

    public String getBranchBankName() {
        return branchBankName;
    }

    public void setBranchBankName(String branchBankName) {
        this.branchBankName = branchBankName == null ? null : branchBankName.trim();
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber == null ? null : bankNumber.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode == null ? null : cityCode.trim();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public String getEyeName() {
        return eyeName;
    }

    public void setEyeName(String eyeName) {
        this.eyeName = eyeName == null ? null : eyeName.trim();
    }

    public String getEyeCode() {
        return eyeCode;
    }

    public void setEyeCode(String eyeCode) {
        this.eyeCode = eyeCode == null ? null : eyeCode.trim();
    }

    public String getCustomCode() {
        return customCode;
    }

    public void setCustomCode(String customCode) {
        this.customCode = customCode == null ? null : customCode.trim();
    }

    public String getEyeBankName() {
        return eyeBankName;
    }

    public void setEyeBankName(String eyeBankName) {
        this.eyeBankName = eyeBankName == null ? null : eyeBankName.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", branchBankNumber=").append(branchBankNumber);
        sb.append(", branchBankName=").append(branchBankName);
        sb.append(", bankNumber=").append(bankNumber);
        sb.append(", bankName=").append(bankName);
        sb.append(", provinceCode=").append(provinceCode);
        sb.append(", provinceName=").append(provinceName);
        sb.append(", cityCode=").append(cityCode);
        sb.append(", cityName=").append(cityName);
        sb.append(", eyeName=").append(eyeName);
        sb.append(", eyeCode=").append(eyeCode);
        sb.append(", customCode=").append(customCode);
        sb.append(", eyeBankName=").append(eyeBankName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}