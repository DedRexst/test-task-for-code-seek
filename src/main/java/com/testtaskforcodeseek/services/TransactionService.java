package com.testtaskforcodeseek.services;

import com.testtaskforcodeseek.dtos.requests.TransactDto;

public interface TransactionService {
    void transactPlayer(TransactDto transactDto);
}
