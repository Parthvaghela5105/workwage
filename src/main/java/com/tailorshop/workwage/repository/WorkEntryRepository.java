package com.tailorshop.workwage.repository;

import com.tailorshop.workwage.entity.WorkEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface WorkEntryRepository extends JpaRepository<WorkEntry, Long> {
    @Query("SELECT e FROM WorkEntry e WHERE e.employee.userId = :employeeId")
    List<WorkEntry> findByEmployeeId(@Param("employeeId") Long employeeId);
    List<WorkEntry> findByWorkDate(LocalDate date);
}
