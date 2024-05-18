package org.dev13pl.hackatonitonebackend.service;

import org.dev13pl.hackatonitonebackend.exception.NoDateProvidedException;
import org.dev13pl.hackatonitonebackend.model.AddTransactionRequest;
import org.dev13pl.hackatonitonebackend.model.Transaction;
import org.dev13pl.hackatonitonebackend.model.TransactionView;
import org.dev13pl.hackatonitonebackend.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository repository;

    public void addTransaction(AddTransactionRequest requestBody) {
        Transaction transaction = Transaction.builder()
                .userId(requestBody.getUserId())
                .sum(requestBody.getSum())
                .category(requestBody.getCategory())
                .date(requestBody.getDate())
                .build();

        repository.save(transaction);
    }

    public Optional<List<TransactionView>> getTransactions(String userId, Date date, Date startDate, Date endDate) {
        Optional<List<TransactionView>> transactions;

        if (date != null) {
            transactions = repository.findAllByUserIdAndDate(userId, date);
        } else if (startDate != null & endDate != null) {
            transactions = repository.findAllByUserIdAndDateGreaterThanEqualAndDateLessThanEqual(userId, startDate, endDate);
        } else {
            throw new NoDateProvidedException();
        }

        return transactions;
    }
}
