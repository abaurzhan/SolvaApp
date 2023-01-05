package com.solva.service.impl;

import com.solva.domain.Currency;
import com.solva.domain.ExpenseTransaction;
import com.solva.domain.MonthLimit;
import com.solva.dto.ExceedTransacationDTO;
import com.solva.dto.MonthLimitDTO;
import com.solva.repository.ExpenseTransactionRepository;
import com.solva.repository.MonthLimitRepository;
import com.solva.service.CRUDService;
import com.solva.service.ExpenseTransactionService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExpenseTransactionServiceImpl implements ExpenseTransactionService {

    ExpenseTransactionRepository expenseRepository;
    MonthLimitRepository monthLimitRepository;

    @Override
    public void save(ExpenseTransaction expenseTransaction) {
        if (!checkMonthLimit(expenseTransaction)) {
            expenseTransaction.setLimitExceeded(true);
        }

        expenseRepository.save(expenseTransaction);

    }

    private BigDecimal getMonthLimit() {
        int month = LocalDate.now().getMonth().getValue();
        return expenseRepository.calculateSumByCurrentMonth(month);
    }

    private boolean checkMonthLimit(ExpenseTransaction transaction) {
        BigDecimal sum = transaction.getSum();
        BigDecimal sumTransactionsInCurrentMonth = getMonthLimit();
        BigDecimal monthLimit = monthLimitRepository.findByMonth(transaction.getDateTime().getMonth()).getLimit();

        BigDecimal result = sum.add(sumTransactionsInCurrentMonth);
        return result.compareTo(monthLimit) < 0;

    }

    public List<ExceedTransacationDTO> findExceedTransactions(Currency currency) {
        List<ExceedTransacationDTO> list = new ArrayList<>();
        List<ExpenseTransaction> transactions = expenseRepository.findAllByLimitExceededTrueAndCurrency(currency);

        Map<Month, List<ExpenseTransaction>> map = transactions
                .stream()
                .collect(Collectors.groupingBy(tr -> tr.getDateTime().getMonth()));

        return map
                .entrySet()
                .stream()
                .map(entry -> {
                    MonthLimit monthLimit = monthLimitRepository.findByMonthAndCurrency(entry.getKey(), currency);
                    MonthLimitDTO monthLimitDTO = MonthLimitDTO.convertToMonthDTO(monthLimit);

                    return ExceedTransacationDTO.builder()
                            .monthLimitDTO(monthLimitDTO)
                            .transactions(entry.getValue())
                            .build();
                }).collect(Collectors.toList());

    }
}
