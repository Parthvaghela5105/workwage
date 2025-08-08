package com.tailorshop.workwage.repository;

import com.tailorshop.workwage.entity.Design;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesignRepository extends JpaRepository<Design, Long> {
    boolean existsByDesignName(String name);
}
