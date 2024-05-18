package org.dev13pl.hackatonitonebackend.model;

import lombok.Builder;

import java.sql.Date;

@Builder
public class TransactionResponse {
    private Integer sum;
    private String category;
    private Date date;
}
