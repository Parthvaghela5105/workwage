package com.tailorshop.workwage.service.serviceImpl;

import com.tailorshop.workwage.entity.Design;
import com.tailorshop.workwage.repository.DesignRepository;
import com.tailorshop.workwage.service.DesignService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesignServiceImpl implements DesignService {
    private final DesignRepository designRepository;

    public DesignServiceImpl(DesignRepository designRepository)
    {
        this.designRepository= designRepository;
    }

    @Override
    public Design addDesign(Design design) {
        if (designRepository.existsByDesignName(design.getDesignName())) {
            throw new RuntimeException("Design already exists");
        }
        return this.designRepository.save(design);
    }

    @Override
    public List<Design> getAllDesigns() {
        return this.designRepository.findAll();
    }

    @Override
    public Design updateDesign(Long id, Design upadtedDesign) {
        Design design = this.designRepository.findById(id).orElseThrow(() -> new RuntimeException("Design Not Found"));

        design.setDesignName(upadtedDesign.getDesignName());
        design.setFixedRate(upadtedDesign.getFixedRate());

        return designRepository.save(design);
    }

    @Override
    public void deleteDesign(Long id) {
        if(!this.designRepository.existsById(id))
        {
            throw new RuntimeException("Design not found");
        }
        this.designRepository.deleteById(id);
    }
}
