package com.solva.repository;

import com.solva.domain.ExpenseTransaction;
import com.solva.domain.MonthLimit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface ExpenseTransactionRepository extends JpaRepository<ExpenseTransaction, Integer> {
    @Query("SELECT sum(et.sum) FROM expenseTransaction et WHERE MONTH (date_time) = :month")
    BigDecimal calculateSumByCurrentMonth(@Param("month") int month);
}