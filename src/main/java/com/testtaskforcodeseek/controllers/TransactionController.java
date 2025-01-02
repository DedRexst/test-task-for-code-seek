package com.testtaskforcodeseek.controllers;

import com.testtaskforcodeseek.dtos.requests.TransactDto;
import com.testtaskforcodeseek.services.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transaction")
@RequiredArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;
    @PatchMapping
    public void transactPlayer(@Valid @RequestBody TransactDto transactDto){
        transactionService.transactPlayer(transactDto);
    }
}
