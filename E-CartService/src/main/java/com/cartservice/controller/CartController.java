package com.cartservice.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cartservice.dto.CartDto;
import com.cartservice.model.Cart;
import com.cartservice.repository.CartRepository;
import com.cartservice.services.CartService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/api/cart")
//@CrossOrigin(origins = "http://localhost:4200") // allow Angular frontend
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private CartRepository cartRepository;

    // ✅ Add product to user's cart (check user via Feign)
    @PostMapping("/add/{userId}")
    public Cart addToCart(@PathVariable Long userId, @RequestBody CartDto dto) {
        return cartService.addToCart(userId, dto);
    }

    // ✅ Get all cart items for a user
    @GetMapping("/{userId}")
    public List<Map<String, Object>> getCart(@PathVariable Long userId) {
        List<Cart> carts = cartService.getCartByUser(userId);

        return carts.stream().map(c -> {
            try {
                Map<String, Object> map = objectMapper.convertValue(c, Map.class);

                // 📷 Convert imagePath → Base64 string
                try {
                    byte[] imageBytes = Files.readAllBytes(Paths.get(c.getImagePath()));
                    String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                    map.put("imageUrl", "data:image/jpeg;base64," + base64Image);
                } catch (IOException e) {
                    map.put("imageUrl", null);
                }

                return map;
            } catch (Exception e) {
                throw new RuntimeException("Error converting cart to map", e);
            }
        }).collect(Collectors.toList());
    }

    // ✅ Remove item from cart
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, String>> removeItem(@PathVariable Long id) {
        cartService.removeFromCart(id);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Item removed successfully");
        return ResponseEntity.ok(response);
    }

    // ✅ (Optional) Get raw cart items without image conversion
    @GetMapping("/{userId}/items")
    public List<Cart> getCartItems(@PathVariable Long userId) {
        return cartService.getCartByUser(userId);
    }
//    @PutMapping("/update/{cartItemId}")
//    public Cart updateQuantity(@PathVariable Long cartItemId, @RequestParam int quantity) {
//        return cartService.updateQuantity(cartItemId, quantity);
//    }
    @PutMapping("/update/{cartId}/{quantity}")
    public ResponseEntity<Cart> updateQuantity(
            @PathVariable Long cartId,
            @PathVariable int quantity) {

        Cart updatedCart = cartService.updateQuantity(cartId, quantity);
        return ResponseEntity.ok(updatedCart);
    }
}
