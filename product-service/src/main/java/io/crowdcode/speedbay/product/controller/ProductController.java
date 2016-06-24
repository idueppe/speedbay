package io.crowdcode.speedbay.product.controller;

import io.crowdcode.speedbay.product.model.Product;
import io.crowdcode.speedbay.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ingo Düppe (Crowdcode)
 */
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;


    @RequestMapping(method = RequestMethod.GET)
    public List<Product> productList() {
        return new ArrayList(productService.findAllProducts());
    }


    @RequestMapping(path = "/{productId}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable Long productId) {
        return productService.findProduct(productId);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> createProduct(@RequestBody Product product, UriComponentsBuilder uriBuilder) {
        Long productId = productService.registerProduct(product.getName(), product.getDescription());

        URI uri = uriBuilder.path("/{productId}").buildAndExpand(productId).toUri();

        return ResponseEntity.created(uri).body(null);
    }



}
