package org.dev13pl.hackatonitonebackend.repository;

import org.dev13pl.hackatonitonebackend.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {
    Optional<List<Transaction>> findAllByDateGreaterThanEqualAndDateLessThanEqual(Date startDate, Date endDate);
    Optional<List<Transaction>> findAllByDate(Date date);
}
