package com.solva.service.impl;

import com.solva.domain.MonthLimit;
import com.solva.repository.MonthLimitRepository;
import com.solva.service.CRUDService;
import com.solva.service.MonthLimitService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MonthLimitServiceImpl implements MonthLimitService {

    MonthLimitRepository repository;

    @Override
    public void save(MonthLimit limit) {
        repository.save(limit);
    }

    @Override
    public List<MonthLimit> findAll() {
        return repository.findAll();
    }
}
