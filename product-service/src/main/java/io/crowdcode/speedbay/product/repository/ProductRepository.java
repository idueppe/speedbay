package io.crowdcode.speedbay.product.repository;

import io.crowdcode.speedbay.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Ingo Düppe (Crowdcode)
 */
public interface ProductRepository extends JpaRepository<Product, Long>{

//    Optional<Product> findByUuid(String uuid);
}
