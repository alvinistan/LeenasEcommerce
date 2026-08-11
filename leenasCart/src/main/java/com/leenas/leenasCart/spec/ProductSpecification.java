package com.leenas.leenasCart.spec;

import org.springframework.data.jpa.domain.Specification;

import com.leenas.leenasCart.entity.Product;

public class ProductSpecification {

	public static Specification<Product> hasCategory(String category) {
		return( root, query, cb) -> category == null ? null : cb.equal(root.get("category"),category);
	}
	
	public static Specification<Product> priceBetween(Double minPrice, Double maxPrice) {
		return(root,query,cb) -> {
			if(minPrice == null && maxPrice == null) return null;
			if(minPrice == null) return cb.lessThanOrEqualTo(root.get("price"), maxPrice);
			if(maxPrice == null) return cb.greaterThanOrEqualTo(root.get("price"), minPrice);
			return cb.between(root.get("price"), minPrice, maxPrice);
		};
	}
	
	public static Specification<Product> hasNameorDescriptionLike(String keyword) {
	    return (root, query, cb) -> {

	        if (keyword == null || keyword.trim().isEmpty()) {
	            return null;
	        }

	        String searchKeyword = "%" + keyword.toLowerCase() + "%";

	        return cb.or(
	                cb.like(
	                        cb.lower(root.get("name")),
	                        searchKeyword
	                ),
	                cb.like(
	                        cb.lower(root.get("description")),
	                        searchKeyword
	                )
	        );
	    };
	}
}
