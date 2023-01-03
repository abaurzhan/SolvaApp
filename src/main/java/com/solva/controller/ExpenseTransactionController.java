package com.solva.controller;

import com.solva.domain.ExpenseTransaction;
import com.solva.domain.MonthLimit;
import com.solva.service.CRUDService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/e-tran")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExpenseTransactionController {

    CRUDService<ExpenseTransaction> service;

    @PostMapping
    public void save(@RequestBody ExpenseTransaction expenseTransaction) {
        service.save(expenseTransaction);
    }
}
