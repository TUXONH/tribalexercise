package com.tribal.repository.model;

import com.tribal.dto.CreditRequest;
import com.tribal.utils.FoundingType;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "CREDIT_LINE")
@Data
@Entity
public class CreditLine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private FoundingType.EnumFoundingTypes foundingTypes;
    @Column(length = 12, precision = 12, scale = 2)
    private BigDecimal cashBalance;
    @Column(length = 12, precision = 12, scale = 2)
    private BigDecimal monthlyRevenue;
    @Column(length = 12, precision = 12, scale = 2)
    private BigDecimal requestedCreditLine;
    private Boolean valid;
    private Date requestedDate;

    public Long getId() {
        return Id;
    }

    public Boolean getValid() {
        return valid;
    }

    protected CreditLine(FoundingType.EnumFoundingTypes foundingTypes, BigDecimal cashBalance, BigDecimal monthlyRevenue, BigDecimal requestedCreditLine) {
        this.foundingTypes = foundingTypes;
        this.cashBalance = cashBalance;
        this.monthlyRevenue = monthlyRevenue;
        this.requestedCreditLine = requestedCreditLine;
    }
    public CreditLine(CreditRequest creditRequest){
        this.foundingTypes = creditRequest.getFoundingType();
        this.cashBalance = creditRequest.getCashBalance();
        this.monthlyRevenue = creditRequest.getMonthlyRevenue();
        this.requestedCreditLine = creditRequest.getRequestedCreditLine();
        this.valid = false;
        this.requestedDate = new Date();
    }

    public CreditLine() { }
}
