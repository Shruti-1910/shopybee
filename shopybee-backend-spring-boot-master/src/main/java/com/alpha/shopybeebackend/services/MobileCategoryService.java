package com.alpha.shopybeebackend.services;

import com.alpha.shopybeebackend.exception.Address.NoAddressesFoundException;
import com.alpha.shopybeebackend.models.MobileCategory;
import com.alpha.shopybeebackend.respositories.MobileCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MobileCategoryService {
    private final MobileCategoryRepository repository;

    @Autowired
    public MobileCategoryService(MobileCategoryRepository repository) {
        this.repository = repository;
    }

    public List<MobileCategory> getAllCategories(){
        return repository.findAll();
    }

    public MobileCategory create(MobileCategory mobileCategory){
        return repository.save(mobileCategory);
    }

    public String deleteById(int id){
        repository.deleteById(id);
        return "Success";
    }

    public MobileCategory update(MobileCategory mobileCategory){
        if(repository.existsById(mobileCategory.getCategoryId())){
            return repository.save(mobileCategory);
        }
        else {
            throw new NoAddressesFoundException("Category not found");
        }
    }
}
