package com.tailorshop.workwage.service.serviceImpl;

import com.tailorshop.workwage.dto.MonthlySummaryDTO;
import com.tailorshop.workwage.repository.MonthlySummaryRepository;
import com.tailorshop.workwage.service.MonthlySummaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MonthlySummaryServiceImpl implements MonthlySummaryService {
    private final MonthlySummaryRepository monthlySummaryRepo;

    @Override
    public List<MonthlySummaryDTO> getSummaryForMonth(String month) {
        return monthlySummaryRepo.findByMonth(month)
                .stream()
                .map(summary -> new MonthlySummaryDTO(
                        summary.getEmployee().getUserId(),
                        summary.getEmployee().getUsername(),
                        summary.getMonth(),
                        summary.getTotalWage()
                ))
                .toList();
    }
}
