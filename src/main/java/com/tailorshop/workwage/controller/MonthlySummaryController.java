package com.tailorshop.workwage.controller;

import com.tailorshop.workwage.dto.MonthlySummaryDTO;
import com.tailorshop.workwage.service.serviceImpl.MonthlySummaryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/summary")
@RequiredArgsConstructor
public class MonthlySummaryController {
    private final MonthlySummaryServiceImpl monthlySummaryService;

    @GetMapping("/{month}")
    public ResponseEntity<List<MonthlySummaryDTO>> getSummary(@PathVariable String month){
        return ResponseEntity.ok(this.monthlySummaryService.getSummaryForMonth(month));
    }
}
