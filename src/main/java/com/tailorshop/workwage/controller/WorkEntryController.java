package com.tailorshop.workwage.controller;

import com.tailorshop.workwage.dto.WorkEntryRequest;
import com.tailorshop.workwage.entity.MonthlySummary;
import com.tailorshop.workwage.entity.WorkEntry;
import com.tailorshop.workwage.service.WorkEntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/work")
@RequiredArgsConstructor
public class WorkEntryController {
    private final WorkEntryService workEntryService;

    @PostMapping
    public ResponseEntity<WorkEntry> addWork(@RequestBody WorkEntryRequest request){
        WorkEntry entry = this.workEntryService.addWorkEntry(
                request.getEmployeeId(),
                request.getDesignId(),
                request.getWorkDate(),
                request.getQuantity()
        );
        return new ResponseEntity<>(entry , HttpStatus.CREATED);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<List<WorkEntry>> getByEmployee(@PathVariable Long id){
        return ResponseEntity.ok(this.workEntryService.getEntriesByEmployeeId(id));
    }

    @GetMapping
    public ResponseEntity<List<WorkEntry>> getAllEntries(){
        return ResponseEntity.ok(this.workEntryService.getAllEntries());
    }

}
