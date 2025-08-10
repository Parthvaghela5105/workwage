package com.tailorshop.workwage.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "designs")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Design {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long designId;

    private String designName;

    private Double fixedRate;
}
