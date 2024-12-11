package com.alpha.shopybeebackend.controllers;

import com.alpha.shopybeebackend.models.MobileCategory;
import com.alpha.shopybeebackend.services.MobileCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/shopybee/mobile-category")
@RestController
public class MobileCategoryController {
    private final MobileCategoryService service;

    @Autowired
    public MobileCategoryController(MobileCategoryService service) {
        this.service = service;
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<MobileCategory>> getAll(){
        return new ResponseEntity<List<MobileCategory>>(service.getAllCategories(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<MobileCategory> create(@RequestBody MobileCategory mobileCategory){
        return new ResponseEntity<MobileCategory>(service.create(mobileCategory),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<MobileCategory> update(@RequestBody MobileCategory mobileCategory){
        return new ResponseEntity<MobileCategory>(service.update(mobileCategory),HttpStatus.OK);
    }


}
