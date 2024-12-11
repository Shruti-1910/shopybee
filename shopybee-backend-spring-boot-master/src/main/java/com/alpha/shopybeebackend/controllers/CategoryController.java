package com.alpha.shopybeebackend.controllers;

import com.alpha.shopybeebackend.models.Category;
import com.alpha.shopybeebackend.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/shopybee/category")
@RestController
public class CategoryController {
    private final CategoryService services;

    @Autowired
    public CategoryController(CategoryService services) {
        this.services = services;
    }

    @PostMapping("/create")
    public ResponseEntity<Category> create(@RequestBody  Category category){
        return new ResponseEntity<Category>(services.create(category), HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<Category>> getAll(){
        return new ResponseEntity<List<Category>>(services.getAll(),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id){
        return new ResponseEntity<String>(services.deleteById(id),HttpStatus.OK);
    }

}
