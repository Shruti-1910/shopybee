package com.alpha.shopybeebackend.respositories;

import com.alpha.shopybeebackend.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {
    public List<Cart> findAllByUserId(int user_id);
}