package br.com.sscs.msregisterproducts.application.service;

import br.com.sscs.msregisterproducts.application.ports.in.ProductService;
import br.com.sscs.msregisterproducts.application.ports.out.ProductRepository;
import br.com.sscs.msregisterproducts.framework.adapters.client.ProductFeignClient;
import br.com.sscs.msregisterproducts.framework.adapters.in.dto.ProductRequest;
import br.com.sscs.msregisterproducts.framework.adapters.in.dto.ProductResponse;
import br.com.sscs.msregisterproducts.framework.adapters.in.exceptions.ProductNotFoundException;
import br.com.sscs.msregisterproducts.framework.adapters.in.exceptions.ProviderNotFoundException;
import br.com.sscs.msregisterproducts.framework.adapters.mapper.ProductMapper;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductFeignClient productFeignClient;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper, ProductFeignClient productFeignClient) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.productFeignClient = productFeignClient;
    }

    @Override
    public ProductResponse saveProduct(ProductRequest request) {
        var product = productMapper.requestToEntity(request);
        log.info("product {}", product);

        var providerExist = productFeignClient
                .findProviderById(product.getProviderId());

        log.info("providerExist {}", providerExist);
        if (providerExist.isEmpty()) {
            throw new ProviderNotFoundException("provider not found with id" + request.getProviderId());
        }

        product.setCreatedOn(LocalDate.now());
        product.setProductId(UUID.randomUUID().toString());

        productRepository.saveProduct(product);
        log.info("product {}", product);
        return productMapper.entityToResponse(product);
    }

    @Override
    public List<ProductResponse> findAllProducts() {
        return productMapper.entityToListResponse(productRepository.findAllProducts());
    }

    @Override
    public Optional<ProductResponse> findByProductId(String productId) {
        var product = productRepository.findByProductId(productId);

        if (product.isEmpty()) {
            throw new ProductNotFoundException("product not with id:" + productId);
        }

        return Optional.of(productMapper.entityToResponse(product.get()));
    }

    @Override
    public ProductResponse updateProduct(String productId, ProductRequest request) {
        return null;
    }

    @Override
    public void deleteByProductId(String productId) {
        var product = findByProductId(productId);

        if (product.isEmpty()) {
            throw new ProductNotFoundException("product not with id:" + productId);
        }

        productRepository.deleteByProductId(productId);
    }
}
