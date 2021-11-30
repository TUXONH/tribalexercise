package com.tribal.repository.repositories;

import com.tribal.repository.jpa.CreditLineJpa;
import com.tribal.repository.model.CreditLine;
import com.tribal.repository.port.CreditLinePort;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class CreditLineRepository implements CreditLinePort {
    private final CreditLineJpa creditLineJpa;

    public CreditLineRepository(CreditLineJpa creditLineJpa) {
        this.creditLineJpa = creditLineJpa;
    }

    @Override
    public Optional<CreditLine> findCreditLineByRequestedDateBetween(Date lastDate, Date firstDate) {
        return creditLineJpa.findCreditLineByRequestedDateBetween(lastDate, firstDate);
    }

    @Override
    public List<CreditLine> findAllByRequestedDateBetween(Date lastDate, Date firstDate) {
        return creditLineJpa.findAllByRequestedDateBetween(lastDate, firstDate);
    }

    @Override
    public Optional<CreditLine> findByRequestedCreditLineAndValidIsTrue(BigDecimal creditLine) {
        return creditLineJpa.findByRequestedCreditLineAndValidIsTrue(creditLine);
    }

    @Override
    public List<CreditLine> findAllByRequestedCreditLineAndValid(BigDecimal creditLine, boolean valid) {
        return creditLineJpa.findAllByRequestedCreditLineAndValid(creditLine, valid);
    }

    @Override
    public <S extends CreditLine> S save(S entity) {
        return creditLineJpa.save(entity);
    }

    @Override
    public <S extends CreditLine> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<CreditLine> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<CreditLine> findAll() {
        return null;
    }

    @Override
    public Iterable<CreditLine> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(CreditLine entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends CreditLine> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
