package com.alpha.shopybeebackend.controllers;

import com.alpha.shopybeebackend.models.Cart;
import com.alpha.shopybeebackend.models.CartIem;
import com.alpha.shopybeebackend.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/shopybee/cart")
@RestController
public class CartController {
    private final CartService service;

    @Autowired
    public CartController(CartService service) {
        this.service = service;
    }

    @GetMapping("/get-cart-items-by-user-id/{userId}")
    public ResponseEntity<List<Cart>> getCartItems(@PathVariable int userId){
        return new ResponseEntity<List<Cart>>(service.getCartItems(userId),HttpStatus.OK);
    }

    @PostMapping("/add-to-cart")
    public ResponseEntity<Cart> addToCart(@RequestBody Cart cart){
        return new ResponseEntity<Cart>(service.addToCart(cart),HttpStatus.OK);
    }

    @DeleteMapping("/remove-from-cart/{cartId}")
    public ResponseEntity<String> removeFromCart(@PathVariable int cartId){
        return new ResponseEntity<String>(service.removeFromCart(cartId),HttpStatus.OK);
    }

    @PutMapping("/update-cart")
    public ResponseEntity<Cart> updateCart(@RequestBody Cart cart){
        return new ResponseEntity<Cart>(service.updateCart(cart),HttpStatus.OK);
    }

    @GetMapping("/get-cart-item/{categoryId}/{brandId}/{productId}")
    public ResponseEntity<CartIem> getCartItem(@PathVariable int categoryId,@PathVariable int brandId, @PathVariable int productId){
        return new ResponseEntity<CartIem>(service.getCartItem(categoryId,brandId,productId),HttpStatus.OK);
    }
}
