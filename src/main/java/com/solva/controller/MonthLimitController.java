package com.solva.controller;

import com.solva.domain.MonthLimit;
import com.solva.service.CRUDService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/m-limit")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MonthLimitController {

    CRUDService<MonthLimit> service;

    @PostMapping
    public void save(@RequestBody MonthLimit limit) {
        service.save(limit);
    }
}