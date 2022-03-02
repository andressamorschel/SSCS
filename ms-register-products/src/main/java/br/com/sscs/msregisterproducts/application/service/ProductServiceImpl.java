package br.com.sscs.msregisterproducts.application.service;

import br.com.sscs.msregisterproducts.application.ports.out.ProductRepository;
import br.com.sscs.msregisterproducts.domain.Product;

import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductRepository {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return null;
    }

    @Override
    public List<Product> findAllProducts() {
        return null;
    }

    @Override
    public Optional<Product> findByProductId(String productId) {
        return Optional.empty();
    }

    @Override
    public void deleteByProductId(String productId) {

    }
}
