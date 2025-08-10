package com.tailorshop.workwage.service.serviceImpl;

import com.tailorshop.workwage.entity.Design;
import com.tailorshop.workwage.entity.MonthlySummary;
import com.tailorshop.workwage.entity.User;
import com.tailorshop.workwage.entity.WorkEntry;
import com.tailorshop.workwage.repository.DesignRepository;
import com.tailorshop.workwage.repository.MonthlySummaryRepository;
import com.tailorshop.workwage.repository.UserRepository;
import com.tailorshop.workwage.repository.WorkEntryRepository;
import com.tailorshop.workwage.service.WorkEntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkEntryServiceImpl implements WorkEntryService {
    private final WorkEntryRepository workEntryRepo;
    private final DesignRepository designRepo;
    private final UserRepository userRepo;
    private final MonthlySummaryRepository monthlySummaryRepo;

    @Override
    public WorkEntry addWorkEntry(Long employeeId, Long designId, LocalDate workDate, Integer quantity) {
        Design design = designRepo.findById(designId)
                .orElseThrow(() -> new RuntimeException("Design not found"));

        User employee = userRepo.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        double wage = quantity * design.getFixedRate();

        WorkEntry entry = new WorkEntry();
        entry.setEmployee(employee);
        entry.setDesign(design);
        entry.setWorkDate(workDate);
        entry.setQuantity(quantity);
        entry.setTotalWage(wage);

        WorkEntry savedEntry = workEntryRepo.save(entry);

        String monthYear = workDate.getYear() + "-" + String.format("%02d", workDate.getMonthValue());

        MonthlySummary summary = monthlySummaryRepo.findByMonth(monthYear)
                .stream()
                .filter(s -> s.getEmployee().equals(employee))
                .findFirst()
                .orElseGet(() -> {
                    MonthlySummary newSummary = new MonthlySummary();
                    newSummary.setEmployee(employee);
                    newSummary.setMonth(monthYear);
                    newSummary.setTotalWage(0.0);
                    return newSummary;
                });

        summary.setTotalWage(summary.getTotalWage() + wage);
        monthlySummaryRepo.save(summary);

        return savedEntry;
    }

    @Override
    public List<WorkEntry> getAllEntries() {
        return this.workEntryRepo.findAll();
    }

    @Override
    public List<WorkEntry> getEntriesByEmployeeId(Long employeeId) {
        return this.workEntryRepo.findByEmployeeId(employeeId);
    }
}
