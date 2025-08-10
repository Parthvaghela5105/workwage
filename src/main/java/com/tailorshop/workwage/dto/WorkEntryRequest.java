package com.tailorshop.workwage.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class WorkEntryRequest {
    private Long employeeId;
    private Long designId;
    private LocalDate workDate;
    private Integer quantity;
}
