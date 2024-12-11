package com.alpha.shopybeebackend.services;

import com.alpha.shopybeebackend.exception.Address.NoAddressesFoundException;
import com.alpha.shopybeebackend.models.Address;
import com.alpha.shopybeebackend.respositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private final AddressRepository repository;

    @Autowired
    public AddressService(AddressRepository repository) {
        this.repository = repository;
    }

    public List<Address> getAddressesByUserId(int userId){
        List<Address> addresses = repository.findByUserId(userId);
        if(addresses.isEmpty()){
            throw new NoAddressesFoundException("No Address Found");
        }
        else{
            return  addresses;
        }
    }

    public Address create(Address address){
        return repository.save(address);
    }

    public String delete(int id){
        repository.deleteById(id);
        return "Success";
    }

    public Address update(Address address){
        return repository.save(address);
    }


}
