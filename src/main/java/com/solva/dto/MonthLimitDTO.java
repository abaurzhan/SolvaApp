package com.solva.dto;

import com.solva.domain.Currency;
import com.solva.domain.MonthLimit;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.Month;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MonthLimitDTO {

    BigDecimal limit;

    Currency currency;

    Month month;

    public static MonthLimitDTO convertToMonthDTO(MonthLimit monthLimit) {
       return MonthLimitDTO.builder()
                .currency(monthLimit.getCurrency())
                .month(monthLimit.getMonth())
                .limit(monthLimit.getLimit())
                .build();
    }
}
