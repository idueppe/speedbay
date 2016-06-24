package io.crowdcode.speedbay.product.service;

import io.crowdcode.speedbay.product.model.Product;

import java.util.Collection;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public interface ProductService {
    Collection<Product> findAllProducts();

    Long registerProduct(String title, String description);

    Product findProduct(Long productId);
}
