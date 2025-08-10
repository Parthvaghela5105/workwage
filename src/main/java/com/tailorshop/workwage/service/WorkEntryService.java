package com.tailorshop.workwage.service;

import com.tailorshop.workwage.entity.MonthlySummary;
import com.tailorshop.workwage.entity.WorkEntry;

import java.time.LocalDate;
import java.util.List;

public interface WorkEntryService {
    WorkEntry addWorkEntry(Long employeeId , Long designId , LocalDate workDate , Integer quantity);
    List<WorkEntry> getAllEntries();
    List<WorkEntry> getEntriesByEmployeeId(Long employeeId);
}
