package com.alpha.shopybeebackend.services;

import com.alpha.shopybeebackend.models.Category;
import com.alpha.shopybeebackend.respositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository repository;

    @Autowired
    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public Category create(Category category){
        if(repository.existsByName(category.getName())){
            System.out.println("Throw already exist exception");
        }
            return repository.save(category);
    }

    public List<Category> getAll(){
        return repository.findAll();
    }

    public String deleteById(int id){
        repository.deleteById(id);
        return "Success";
    }
}
