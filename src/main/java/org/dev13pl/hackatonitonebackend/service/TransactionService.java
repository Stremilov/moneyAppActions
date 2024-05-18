package org.dev13pl.hackatonitonebackend.service;

import org.dev13pl.hackatonitonebackend.model.AddTransactionRequest;
import org.dev13pl.hackatonitonebackend.model.Transaction;
import org.dev13pl.hackatonitonebackend.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;


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

    public List<Transaction> getTransactionsByDatesPeriod(Date startDate, Date endDate) {
//        return repository.findAllByDateGreaterThanEqualAndDateLessThanEqual(startDate, endDate)
//                .orElseThrow(() -> new RuntimeException("No transactions"));
        return repository.findAllByDate(startDate)
                .orElseThrow(() -> new RuntimeException("No transactions"));
    }
}
