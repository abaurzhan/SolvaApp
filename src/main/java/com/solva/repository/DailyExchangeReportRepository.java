package com.solva.repository;

import com.solva.domain.DailyExchangeReport;
import com.solva.domain.MonthLimit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyExchangeReportRepository extends JpaRepository<DailyExchangeReport, Integer> {
}
