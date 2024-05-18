package org.dev13pl.hackatonitonebackend.repository;

import org.dev13pl.hackatonitonebackend.model.Transaction;
import org.dev13pl.hackatonitonebackend.model.TransactionView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {
    Optional<List<TransactionView>> findAllByUserIdAndDateGreaterThanEqualAndDateLessThanEqual(String userId, Date startDate, Date endDate);
    Optional<List<TransactionView>> findAllByUserIdAndDate(String userId, Date date);
}
