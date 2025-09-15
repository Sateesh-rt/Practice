package com.cartservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cartservice.model.Cart;


public interface CartRepository extends JpaRepository<Cart, Long> {
	List<Cart> findByUserId(Long userId);
	Cart findByUserIdAndProductName(Long userId, String productName);

//	List<Cart> findByUserId(Long userId);
//	Optional<Cart> findByUserIdAndProductName(Long userId, String productName);
//	List<Cart> findByUser(User user);
	
	

}
