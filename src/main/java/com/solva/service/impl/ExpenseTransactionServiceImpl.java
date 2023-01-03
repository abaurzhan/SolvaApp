package com.solva.service.impl;

import com.solva.domain.ExpenseTransaction;
import com.solva.domain.MonthLimit;
import com.solva.repository.ExpenseTransactionRepository;
import com.solva.repository.MonthLimitRepository;
import com.solva.service.CRUDService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

@Service
@Transactional
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExpenseTransactionServiceImpl implements CRUDService<ExpenseTransaction> {

    ExpenseTransactionRepository expenseRepository;
    MonthLimitRepository monthLimitRepository;

    @Override
    public void save(ExpenseTransaction expenseTransaction) {
        expenseRepository.save(expenseTransaction);
    }

    private BigDecimal getMonthLimit() {
        MonthLimit monthLimit = monthLimitRepository.findByMonth(LocalDate.now().getMonth());
        return monthLimit.getLimit();
    }

    private boolean checkMonthLimit(ExpenseTransaction transaction) {
        BigDecimal sum = transaction.getSum();
        BigDecimal monthLimit = getMonthLimit();

        return true;

    }


}
