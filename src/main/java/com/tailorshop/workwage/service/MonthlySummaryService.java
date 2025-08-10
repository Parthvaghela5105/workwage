package com.tailorshop.workwage.service;

import com.tailorshop.workwage.dto.MonthlySummaryDTO;

import java.util.List;

public interface MonthlySummaryService {
    List<MonthlySummaryDTO> getSummaryForMonth(String month);
}
