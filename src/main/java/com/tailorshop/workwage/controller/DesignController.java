package com.tailorshop.workwage.controller;

import com.tailorshop.workwage.entity.Design;
import com.tailorshop.workwage.service.DesignService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/designs")
public class DesignController {
    private final DesignService designService;

    public DesignController(DesignService designService)
    {
        this.designService = designService;
    }

    @PostMapping
    public ResponseEntity<Design> addDesign(@RequestBody Design design)
    {
        return new ResponseEntity<>(this.designService.addDesign(design), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Design>> getAllDesigns(){
        return ResponseEntity.ok(this.designService.getAllDesigns());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Design> updateDesign(@PathVariable Long id , @RequestBody Design updateDesign)
    {
        return ResponseEntity.ok(this.designService.updateDesign(id , updateDesign));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDesign(@PathVariable Long id)
    {
        this.designService.deleteDesign(id);
        return ResponseEntity.ok("Design deleted successfully");
    }
}
