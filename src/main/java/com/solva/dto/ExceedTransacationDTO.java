package com.solva.dto;

import com.solva.domain.ExpenseTransaction;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExceedTransacationDTO {
    MonthLimitDTO monthLimitDTO;

    List<ExpenseTransaction> transactions;
}
