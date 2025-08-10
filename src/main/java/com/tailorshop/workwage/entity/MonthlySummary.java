package com.tailorshop.workwage.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "monthly_summary")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonthlySummary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id" , nullable = false)
    private User employee;

    @Column(nullable = false)
    private String month;

    @Column(nullable = false)
    private Double totalWage;
}
