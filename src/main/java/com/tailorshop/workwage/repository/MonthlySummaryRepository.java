package com.tailorshop.workwage.repository;

import com.tailorshop.workwage.entity.MonthlySummary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MonthlySummaryRepository extends JpaRepository<MonthlySummary, Long> {
    List<MonthlySummary> findByMonth(String month);
}
