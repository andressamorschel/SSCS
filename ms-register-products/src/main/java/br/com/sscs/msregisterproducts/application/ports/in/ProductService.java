package br.com.sscs.msregisterproducts.application.ports.in;

import br.com.sscs.msregisterproducts.framework.adapters.in.dto.ProductRequest;
import br.com.sscs.msregisterproducts.framework.adapters.in.dto.ProductResponse;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    ProductResponse saveProduct(ProductRequest request);

    List<ProductResponse> findAllProducts();

    Optional<ProductResponse> findByProductId(String productId);

    ProductResponse updateProduct(String productId, ProductRequest request);

    void deleteByProductId(String productId);
}
