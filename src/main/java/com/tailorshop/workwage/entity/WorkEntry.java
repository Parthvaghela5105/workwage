package com.tailorshop.workwage.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "work_entries")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User employee;

    @ManyToOne
    @JoinColumn(name = "design_id")
    private Design design;

    private LocalDate workDate;

    private Integer quantity;

    private Double totalWage;
} 
