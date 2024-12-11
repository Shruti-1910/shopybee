package com.alpha.shopybeebackend.controllers;

import com.alpha.shopybeebackend.models.Mobile;
import com.alpha.shopybeebackend.services.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/shopybee/mobiles")
@RestController
public class MobileController {

    private final MobileService service;

    @Autowired
    public MobileController(MobileService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<Mobile> create(@RequestBody Mobile mobile){
        return new ResponseEntity<Mobile>(service.create(mobile), HttpStatus.OK);
    }

    @GetMapping("/getAll/{brandId}")
    public ResponseEntity<List<Mobile>> getAll(@PathVariable int brandId){
        return new ResponseEntity<List<Mobile>>(service.getAllByBrandId(brandId),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Mobile> update(@RequestBody Mobile mobile){
        return new ResponseEntity<Mobile>(service.update(mobile),HttpStatus.OK);
    }
}
