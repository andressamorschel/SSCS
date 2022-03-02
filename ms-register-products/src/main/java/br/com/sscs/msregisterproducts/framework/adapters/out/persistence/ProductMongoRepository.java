package br.com.sscs.msregisterproducts.framework.adapters.out.persistence;

import br.com.sscs.msregisterproducts.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductMongoRepository extends MongoRepository<Product, String> {

    void deleteByProductId(String id);
    Optional<Product> findByProductId(String productId);
}
