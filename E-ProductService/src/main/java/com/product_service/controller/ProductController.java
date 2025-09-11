package com.product_service.controller;







import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.product_service.dto.ProductDTO;
import com.product_service.dto.ProductResponse;
import com.product_service.model.Product;
import com.product_service.services.ProductService;
//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	private ProductService service;
	@Autowired
	private ObjectMapper objectMapper;

	@PostMapping("/addProducts")

	public ResponseEntity<?> createProduct(@RequestPart("product") ProductDTO productDto,
			@RequestPart("image") MultipartFile image) throws IOException {

		return ResponseEntity.ok(service.saveProduct(image, productDto));

	}

	@GetMapping("/getProducts")
	public List<Map<String, Object>> getAllProducts() {
	    List<Product> products = service.getAllProducts();
	   
	    return products.stream().map(p -> {
	        Map<String, Object> map;
	        try {
	            map = objectMapper.convertValue(p, Map.class);
	        } catch (Exception e) {
	            System.err.println("Error converting product to map for product ID " + p.getId() + ": " + e.getMessage());
	            return null; // Skip this product, don’t throw globally!
	        }

	        String imageUrl = null;
	        if (p.getImagePath() != null) {
	            try {
	                byte[] imageBytes = Files.readAllBytes(Paths.get(p.getImagePath()));
	                // Could infer image MIME type, for now default to JPEG
	                imageUrl = "data:image/jpeg;base64," + Base64.getEncoder().encodeToString(imageBytes);
	            } catch (IOException e) {
	                System.err.println("Image not found for product ID " + p.getId() + ": " + e.getMessage());
	            }
	        }
	        map.put("imageUrl", imageUrl);
	        return map;
	    }).filter(Objects::nonNull).collect(Collectors.toList());
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
		try {
		service.deleteProduct(id);
		return ResponseEntity.ok().build();
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Id Not Found "+id);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable Long id, @RequestPart("product") ProductDTO dto,
			@RequestPart(value = "image", required = false) MultipartFile image) throws IOException {

		return ResponseEntity.ok(service.updateProduct(id, dto, image));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById(@PathVariable Long id) throws IOException   {
		Product product = service.getProductById(id);

		ProductResponse response = objectMapper.convertValue(product, ProductResponse.class);
         String fileName = new File(product.getImagePath()).getName(); // Extract file name
		String imageUrl = "http://localhost:8082/uploads/" + fileName;
		response.setImageUrl(imageUrl);
         
		return ResponseEntity.ok(response);
		
         
	}
	
	
}
