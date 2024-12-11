package com.alpha.shopybeebackend.respositories;

import com.alpha.shopybeebackend.models.MobileCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobileCategoryRepository extends JpaRepository<MobileCategory, Integer> {



}