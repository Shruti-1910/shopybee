package com.alpha.shopybeebackend.respositories;

import com.alpha.shopybeebackend.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
    public List<Address> findByUserId(int userId);
}