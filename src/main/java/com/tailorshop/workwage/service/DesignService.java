package com.tailorshop.workwage.service;

import com.tailorshop.workwage.entity.Design;

import java.util.List;

public interface DesignService {
    Design addDesign(Design design);
    List<Design> getAllDesigns();
    Design updateDesign(Long id ,Design upadtedDesign);
    void deleteDesign(Long id);
}
