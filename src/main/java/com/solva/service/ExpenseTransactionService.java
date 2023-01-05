package com.solva.service;

import com.solva.domain.Currency;
import com.solva.domain.ExpenseTransaction;
import com.solva.dto.ExceedTransacationDTO;

import java.util.List;

public interface ExpenseTransactionService extends CRUDService<ExpenseTransaction> {
    public List<ExceedTransacationDTO> findExceedTransactions(Currency currency);
}
