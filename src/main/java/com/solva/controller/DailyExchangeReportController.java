package com.solva.controller;

import com.solva.domain.Currency;
import com.solva.domain.DailyExchangeReport;
import com.solva.service.CRUDService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/dayli")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DailyExchangeReportController {

    public static final String API_KEY = "e2e48f3edfb14265b49fb12a51d92307";

    final
    CRUDService<DailyExchangeReport> service;

    RestTemplate restTemplate;

    public DailyExchangeReportController(CRUDService<DailyExchangeReport> service,
                                         RestTemplateBuilder restTemplateBuilder) {
        this.service = service;
        this.restTemplate = restTemplateBuilder.build();
    }

    @GetMapping("/{currency}")
    public void saveDayliReport(@PathVariable Currency currency) {
        String symbol = currency.name().replace("_", "/");
        String url = "https://api.twelvedata.com/eod?symbol=" + symbol + "&apikey=" + API_KEY;
        DailyExchangeReport report = this.restTemplate.getForObject(url, DailyExchangeReport.class);
        service.save(report);
    }


}
