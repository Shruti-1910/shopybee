package com.alpha.shopybeebackend.controllers;

import com.alpha.shopybeebackend.models.Address;
import com.alpha.shopybeebackend.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("shopybee/address")
@RestController
public class AddressController {

    private final AddressService services;

    @Autowired
    public AddressController(AddressService services) {
        this.services = services;
    }


    @GetMapping("/get-by-user-id/{userId}")
    public ResponseEntity<List<Address>> getAddressesByUserId(@PathVariable int userId){
        return new ResponseEntity<List<Address>>(services.getAddressesByUserId(userId), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Address> create(@RequestBody Address address){
        return new ResponseEntity<Address>(services.create(address),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        return new ResponseEntity<String>(services.delete(id),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Address> update(@RequestBody Address address){
        return new ResponseEntity<Address>(services.update(address),HttpStatus.OK);
    }

}
