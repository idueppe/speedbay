package io.crowdcode.speedbay.product.service;

import io.crowdcode.speedbay.product.model.Product;
import io.crowdcode.speedbay.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@Component
public class ProductServiceBean implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    public ProductServiceBean() {
    }

    @Override
    public Collection<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Long registerProduct(String name, String description) {
        Product product = new Product()
                .withId(System.currentTimeMillis())
                .withName(name)
                .withDescription(description);

        productRepository.save(product);

        return product.getId();
    }

    @Override
    public Product findProduct(Long productId) {
        return productRepository.findOne(productId);
    }
}
