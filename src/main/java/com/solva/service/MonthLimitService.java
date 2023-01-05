package com.solva.service;

import com.solva.domain.MonthLimit;

import java.util.List;

public interface MonthLimitService extends CRUDService<MonthLimit> {
    List<MonthLimit> findAll();
}
