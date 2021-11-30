package com.tribal.repository.jpa;

import com.tribal.repository.model.CreditLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface CreditLineJpa extends JpaRepository<CreditLine, Long> {
    Optional<CreditLine> findCreditLineByRequestedDateBetween(Date lastDate, Date firstDate);

    List<CreditLine> findAllByRequestedDateBetween(Date lastDate, Date firstDate);

    Optional<CreditLine> findByRequestedCreditLineAndValidIsTrue(BigDecimal creditLine);

    List<CreditLine> findAllByRequestedCreditLineAndValid(BigDecimal creditLine, boolean valid);
}
