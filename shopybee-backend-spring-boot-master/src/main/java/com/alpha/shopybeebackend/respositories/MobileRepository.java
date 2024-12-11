package com.alpha.shopybeebackend.respositories;

import com.alpha.shopybeebackend.models.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MobileRepository extends JpaRepository<Mobile, Integer> {
    public List<Mobile> findAllByBrandId(int brandId);
}