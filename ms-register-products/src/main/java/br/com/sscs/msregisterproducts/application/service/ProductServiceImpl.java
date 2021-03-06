package br.com.sscs.msregisterproducts.application.service;

import br.com.sscs.msregisterproducts.application.ports.in.ProductService;
import br.com.sscs.msregisterproducts.application.ports.out.ProductRepository;
import br.com.sscs.msregisterproducts.domain.Product;
import br.com.sscs.msregisterproducts.framework.adapters.in.dto.ProductRequest;
import br.com.sscs.msregisterproducts.framework.adapters.in.dto.ProductResponse;
import br.com.sscs.msregisterproducts.framework.adapters.in.exceptions.ProductNotFoundException;
import br.com.sscs.msregisterproducts.framework.adapters.in.exceptions.ProviderNotFoundException;
import br.com.sscs.msregisterproducts.framework.adapters.mapper.ProductMapper;
import br.com.sscs.msregisterproducts.framework.adapters.out.client.ProductFeignClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductFeignClient productFeignClient;
    private final ObjectMapper objectMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper,
                              ProductFeignClient productFeignClient, ObjectMapper objectMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.productFeignClient = productFeignClient;
        this.objectMapper = objectMapper;
    }

    @Override
    public ProductResponse saveProduct(ProductRequest request) {
        var providerExist = productFeignClient
                .findProviderById(request.getProviderId());

        if (providerExist.isEmpty()) {
            throw new ProviderNotFoundException(String.format("provider not found with id: %s",
                    request.getProviderId()));
        }

        var product = Product.builder()
                .productId(UUID.randomUUID().toString())
                .brand(request.getBrand())
                .createdOn(LocalDate.now())
                .name(request.getName())
                .price(request.getPrice())
                .providerId(request.getProviderId())
                .build();

        productRepository.saveProduct(product);
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
            throw new ProductNotFoundException(String.format("product not with id: %s", productId));
        }

        return Optional.of(productMapper.entityToResponse(product.get()));
    }

    @Override
    public ProductResponse updateProduct(String productId, ProductRequest request) {
        var product = productRepository.findByProductId(productId);
        request.setProductId(productId);

        product.get().setProviderId(request.getProviderId());
        product.get().setName(request.getName());
        product.get().setBrand(request.getBrand());
        product.get().setPrice(request.getPrice());

        productRepository.saveProduct(product.get());
        return productMapper.entityToResponse(product.get());
    }

    @Override
    public void deleteByProductId(String productId) {
        var product = findByProductId(productId);

        if (product.isEmpty()) {
            throw new ProductNotFoundException("product not with id:" + productId);
        }

        productRepository.deleteByProductId(productId);
    }

    @Override
    public ProductResponse updatePartialProduct(String productId, Map<String, Object> fields) {
        var product = productRepository.findByProductId(productId);

        if (product.isEmpty()) {
            throw new ProductNotFoundException("product not with id:" + productId);
        }

        merge(fields, product.get());
        return updateProduct(productId, productMapper.entityToRequest(product.get()));
    }

    private void merge(Map<String, Object> sourceData, Product productDestiny) {
        Product productOrigin = objectMapper.convertValue(sourceData, Product.class);

        sourceData.forEach((nameProperty, valueProperty) -> {
            Field field = ReflectionUtils.findField(Product.class, nameProperty);
            field.setAccessible(true);
            Object newValue = ReflectionUtils.getField(field, productOrigin);

            ReflectionUtils.setField(field, productDestiny, newValue);
        });
    }
}
