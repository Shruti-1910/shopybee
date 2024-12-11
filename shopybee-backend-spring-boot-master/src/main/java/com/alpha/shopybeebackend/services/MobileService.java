package com.alpha.shopybeebackend.services;

import com.alpha.shopybeebackend.models.Mobile;
import com.alpha.shopybeebackend.respositories.MobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MobileService {
    private final MobileRepository repository;

    @Autowired
    public MobileService(MobileRepository repository) {
        this.repository = repository;
    }


    public List<Mobile> getAllByBrandId(int brandId){
        return repository.findAllByBrandId(brandId);
    }

    public Mobile create(Mobile mobile){
        return repository.save(mobile);
    }

    public Mobile update(Mobile mobile){
        return repository.save(mobile);
    }

}
