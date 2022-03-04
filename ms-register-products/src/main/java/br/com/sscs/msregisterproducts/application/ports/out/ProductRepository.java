package br.com.sscs.msregisterproducts.application.ports.out;

import br.com.sscs.msregisterproducts.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Product saveProduct(Product product);

    List<Product> findAllProducts();

    Optional<Product> findByProductId(String productId);

    void deleteByProductId(String productId);

}
