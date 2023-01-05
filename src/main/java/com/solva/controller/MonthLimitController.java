package com.solva.controller;

import com.solva.domain.MonthLimit;
import com.solva.service.CRUDService;
import com.solva.service.MonthLimitService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("/m-limit")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MonthLimitController {

    MonthLimitService service;

    @PostMapping
    public void save(@RequestBody MonthLimit limit) {
        service.save(limit);
    }

    @PutMapping
    public void update(@RequestBody MonthLimit limit) {
        Month month = limit.getMonth();
        Month currentMonth = LocalDate.now().getMonth();
        if (month != currentMonth) {
            throw new IllegalArgumentException("Month is not current");
        }
        service.save(limit);
    }

    @GetMapping("/all")
    public List<MonthLimit> findAll() {
        return service.findAll();
    }

}
