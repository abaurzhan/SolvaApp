package com.solva.service.impl;

import com.solva.domain.MonthLimit;
import com.solva.repository.MonthLimitRepository;
import com.solva.service.CRUDService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MonthLimitServiceImpl implements CRUDService<MonthLimit> {

    MonthLimitRepository repository;

    @Override
    public void save(MonthLimit limit) {
        repository.save(limit);
    }
}
