package com.leenas.leenasCart.seed;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.leenas.leenasCart.entity.Product;
import com.leenas.leenasCart.repository.ProductRepository;

@Component
public class ProductSeeder implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		if (productRepository.count() == 0) {
			List<Product> demoProducts = List.of(
					new Product(null, "Apple iPhone 16", 799.00, "Smartphone with A16 Chip", 4.8, "Apple Store", 10),

					new Product(null, "Samsung Galaxy S25", 899.00, "Flagship Android Smartphone", 4.7, "Samsung", 15),

					new Product(null, "Google Pixel 10", 749.00, "Pure Android Experience", 4.6, "Google", 20),

					new Product(null, "OnePlus 13", 699.00, "Fast Performance with Snapdragon", 4.5, "OnePlus", 18),

					new Product(null, "Xiaomi 15 Pro", 649.00, "High-end Smartphone with Leica Camera", 4.4, "Xiaomi",
							25),

					new Product(null, "Sony WH-1000XM6", 399.00, "Noise Cancelling Wireless Headphones", 4.9, "Sony",
							30),

					new Product(null, "Apple MacBook Air M4", 1299.00, "Lightweight Laptop with Apple M4 Chip", 4.9,
							"Apple", 8),

					new Product(null, "Dell XPS 15", 1599.00, "Premium Windows Laptop", 4.7, "Dell", 6),

					new Product(null, "Apple Watch Series 11", 499.00, "Advanced Smartwatch with Health Tracking", 4.8,
							"Apple", 12),

					new Product(null, "Samsung Galaxy Tab S11", 699.00, "Premium Android Tablet", 4.6, "Samsung", 14));
			
			productRepository.saveAll(demoProducts);
			System.out.println("Seeded Demo Products");
		}else {
			System.out.println("Products Already Existing don't neet to Seed...");
		}

	}

}
