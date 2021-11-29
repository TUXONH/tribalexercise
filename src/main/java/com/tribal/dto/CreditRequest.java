package com.tribal.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public class CreditRequest {
    private FoundingTypes foundingType;
    private BigDecimal cashBalance;
    private BigDecimal monthlyRevenue;
    private BigInteger requestedCreditLine;

    public FoundingTypes getFoundingType() {
        return foundingType;
    }

    public void setFoundingType(FoundingTypes foundingType) {
        this.foundingType = foundingType;
    }

    public BigDecimal getCashBalance() {
        return cashBalance;
    }

    public void setCashBalance(BigDecimal cashBalance) {
        this.cashBalance = cashBalance;
    }

    public BigDecimal getMonthlyRevenue() {
        return monthlyRevenue;
    }

    public void setMonthlyRevenue(BigDecimal monthlyRevenue) {
        this.monthlyRevenue = monthlyRevenue;
    }

    public BigInteger getRequestedCreditLine() {
        return requestedCreditLine;
    }

    public void setRequestedCreditLine(BigInteger requestedCreditLine) {
        this.requestedCreditLine = requestedCreditLine;
    }

    public enum FoundingTypes {
        STARTUP,
        SME
    }
}
