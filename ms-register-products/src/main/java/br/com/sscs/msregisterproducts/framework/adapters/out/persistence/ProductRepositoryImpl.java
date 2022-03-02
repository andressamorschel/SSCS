package br.com.sscs.msregisterproducts.framework.adapters.out.persistence;

import br.com.sscs.msregisterproducts.application.ports.out.ProductRepository;
import br.com.sscs.msregisterproducts.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryImpl implements ProductRepository {

    @Autowired
    private ProductMongoRepository mongoRepository;


    @Override
    public Product saveProduct(Product product) {
        return mongoRepository.save(product);
    }

    @Override
    public List<Product> findAllProducts() {
        return mongoRepository.findAll();
    }

    @Override
    public Optional<Product> findByProductId(String productId) {
        return mongoRepository.findByProductId(productId);
    }

    @Override
    public void deleteByProductId(String productId) {
        mongoRepository.deleteByProductId(productId);
    }
}
