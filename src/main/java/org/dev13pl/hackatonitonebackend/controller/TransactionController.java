package org.dev13pl.hackatonitonebackend.controller;

import org.dev13pl.hackatonitonebackend.model.AddTransactionRequest;
import org.dev13pl.hackatonitonebackend.model.Transaction;
import org.dev13pl.hackatonitonebackend.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;


@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping
    void addTransaction(@RequestBody AddTransactionRequest body) {
        transactionService.addTransaction(body);
        ResponseEntity.ok().build();
    }

    @GetMapping
    ResponseEntity<List<Transaction>> getTransactionsByDatesPeriod(@RequestParam Date startDate, @RequestParam Date endDate) {
        return ResponseEntity.ok(transactionService.getTransactionsByDatesPeriod(startDate, endDate));
    }
}
