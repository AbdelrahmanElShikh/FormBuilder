package com.abdelrahman.formapplication.model;

public class Beneficiary {
    private Integer accountCurrencyCode;
    private String accountNumber;
    private String address;
    private Integer cityId;
    private Integer countryId;
    private String name;
    private String phoneNumber;
    private String relation;
    private String swiftCode;

    /**
     * No args constructor for use in serialization
     */
    public Beneficiary() {
    }

    public Beneficiary(Integer accountCurrencyCode, String accountNumber, String address, Integer cityId,
                       Integer countryId, String name, String phoneNumber, String relation, String swiftCode) {
        this.accountCurrencyCode = accountCurrencyCode;
        this.accountNumber = accountNumber;
        this.address = address;
        this.cityId = cityId;
        this.countryId = countryId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.relation = relation;
        this.swiftCode = swiftCode;
    }

    public Integer getAccountCurrencyCode() {
        return accountCurrencyCode;
    }

    public void setAccountCurrencyCode(Integer accountCurrencyCode) {
        this.accountCurrencyCode = accountCurrencyCode;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }
}
