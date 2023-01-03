package com.solva.repository;

import com.solva.domain.MonthLimit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Month;

public interface MonthLimitRepository extends JpaRepository<MonthLimit, Integer> {
    MonthLimit findByMonth(Month month);
}
