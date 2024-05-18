package org.dev13pl.hackatonitonebackend.model;

import java.sql.Date;

public interface TransactionView {
    Integer getSum();
    String getCategory();
    Date getDate();
}
