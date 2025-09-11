package com.cartservice.services;

import com.cartservice.client.UserClient;
import com.cartservice.dto.CartDto;
import com.cartservice.model.Cart;
import com.cartservice.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserClient userClient; // 👈 Feign client

    public Cart addToCart(Long userId, CartDto dto) {
        // ✅ check user existence using Feign
        if (!userClient.userExists(userId)) {
            throw new RuntimeException("User not found with id: " + userId);
        }

        Cart cart = new Cart();
        cart.setUserId(userId);
        cart.setProductName(dto.getProductName());
        cart.setPrice(dto.getPrice());
        cart.setQuantity(dto.getQuantity());
        cart.setImagePath(dto.getImagePath());
        cart.setTotal(dto.getPrice() * dto.getQuantity());

        return cartRepository.save(cart);
    }

    public List<Cart> getCartByUser(Long userId) {
        return cartRepository.findByUserId(userId);
    }

    public void removeFromCart(Long cartId) {
        cartRepository.deleteById(cartId);
    }
}
