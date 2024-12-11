package com.alpha.shopybeebackend.services;

import com.alpha.shopybeebackend.models.Cart;
import com.alpha.shopybeebackend.models.CartIem;
import com.alpha.shopybeebackend.models.Category;
import com.alpha.shopybeebackend.models.Mobile;
import com.alpha.shopybeebackend.respositories.CartRepository;
import com.alpha.shopybeebackend.respositories.CategoryRepository;
import com.alpha.shopybeebackend.respositories.MobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    private final CartRepository repository;
    private final CategoryRepository categoryRepository;

    private final MobileRepository mobileRepository;
    @Autowired
    public CartService(CartRepository repository, CategoryRepository categoryRepository, MobileRepository mobileRepository) {
        this.repository = repository;
        this.categoryRepository = categoryRepository;
        this.mobileRepository = mobileRepository;
    }

    public List<Cart> getCartItems(int userId){
        return repository.findAllByUserId(userId);
    }

    public Cart addToCart(Cart cart){
        return repository.save(cart);
    }

    public String removeFromCart(int cartId){
        repository.deleteById(cartId);
        return "Success";
    }

    public Cart updateCart(Cart cart){
        return repository.save(cart);
    }

    public CartIem getCartItem(int categoryId,int brandId,int productId){
        Category category = categoryRepository.findById(categoryId).orElseThrow();
        CartIem cartIem;
        switch (category.getName()){
            case "Mobiles":
                Mobile mobile = mobileRepository.findById(productId).orElseThrow();
                cartIem = new CartIem(mobile.getProductId(),mobile.getName(),mobile.getMainImage(),mobile.getPrice(),
                        mobile.getDiscount());
                break;
            default:
                return new CartIem();
        }
        return cartIem;
    }

}
