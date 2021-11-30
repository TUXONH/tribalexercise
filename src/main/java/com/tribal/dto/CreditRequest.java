package com.tribal.dto;

import com.tribal.utils.FoundingType;

import java.math.BigDecimal;
import java.util.Date;

public class CreditRequest {
    private FoundingType.EnumFoundingTypes foundingType;
    private BigDecimal cashBalance;
    private BigDecimal monthlyRevenue;
    private BigDecimal requestedCreditLine;
    private Date requestedDate;
    private Boolean valid;

    public FoundingType.EnumFoundingTypes getFoundingType() {
        return foundingType;
    }
    public BigDecimal getCashBalance() {
        return cashBalance;
    }
    public BigDecimal getMonthlyRevenue() {
        return monthlyRevenue;
    }
    public BigDecimal getRequestedCreditLine() {
        return requestedCreditLine;
    }
    public Date requestedDate() { return requestedDate; }
    public Boolean getValid() {
        return valid;
    }

}
