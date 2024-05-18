package org.dev13pl.hackatonitonebackend.controller;

import org.dev13pl.hackatonitonebackend.exception.NoDateProvidedException;
import org.dev13pl.hackatonitonebackend.model.AddTransactionRequest;
import org.dev13pl.hackatonitonebackend.model.MessageResponse;
import org.dev13pl.hackatonitonebackend.model.TransactionView;
import org.dev13pl.hackatonitonebackend.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @ExceptionHandler(NoDateProvidedException.class)
    ResponseEntity<MessageResponse> handleNoDateProvidedException(NoDateProvidedException ex) {
        MessageResponse response = new MessageResponse(ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    void addTransaction(@RequestBody AddTransactionRequest body) {
        transactionService.addTransaction(body);
        ResponseEntity.ok().build();
    }

    @GetMapping
    ResponseEntity<Optional<List<TransactionView>>> getTransactions(@RequestParam String userId,
                                                                   @RequestParam(required = false) Date date,
                                                                   @RequestParam(required = false) Date startDate,
                                                                   @RequestParam(required = false) Date endDate) {
        return ResponseEntity.ok(transactionService.getTransactions(userId, date, startDate, endDate));
    }
}
