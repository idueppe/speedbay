package io.crowdcode.speedbay.product.service;

import io.crowdcode.speedbay.product.model.Product;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Component
public class ProductService {

    private Map<Long, Product> products;

    public ProductService() {
        this.products = new HashMap<>();
    }

    public Collection<Product> findAllProducts() {
        return products.values();
    }

    public Long registerProduct(String name, String description) {
        Product product = new Product()
                .withId(System.currentTimeMillis())
                .withName(name)
                .withDescription(description);

        products.put(product.getId(), product);
        return product.getId();
    }

    public Product findProduct(Long productId) {
        return products.get(productId);
    }
}
