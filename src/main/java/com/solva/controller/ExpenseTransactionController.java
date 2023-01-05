package com.solva.controller;

import com.solva.domain.Currency;
import com.solva.domain.ExpenseTransaction;
import com.solva.domain.MonthLimit;
import com.solva.dto.ExceedTransacationDTO;
import com.solva.service.CRUDService;
import com.solva.service.ExpenseTransactionService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/e-tran")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExpenseTransactionController {

    ExpenseTransactionService service;

    @PostMapping
    public void save(@RequestBody ExpenseTransaction expenseTransaction) {
        service.save(expenseTransaction);
    }

    @GetMapping("exceed/{currency}")
    public List<ExceedTransacationDTO> findExceedTransactions(@PathVariable Currency currency){
        return service.findExceedTransactions(currency);
    }
}
