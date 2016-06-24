package io.crowdcode.speedbay.product.fixture;

import io.crowdcode.speedbay.product.model.Product;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public class ProductFixture {

    public static Product defaultProduct(Long id) {
        return new Product()
                .withId(id)
                .withName("title")
                .withDescription("description");
    }

    public static Long uuid() {
        return System.currentTimeMillis();
    }

}
