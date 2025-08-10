package com.tailorshop.workwage.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MonthlySummaryDTO {
    private Long employeeId;
    private String employeeName;
    private String month;
    private Double totalWage;
}
