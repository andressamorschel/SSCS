package br.com.sscs.msregisterproducts.framework.adapters.in;

import br.com.sscs.msregisterproducts.application.ports.in.ProductService;
import br.com.sscs.msregisterproducts.framework.adapters.in.dto.ProductRequest;
import br.com.sscs.msregisterproducts.framework.adapters.in.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductResponse> findAllProducts() {
        return productService.findAllProducts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse saveProduct(@RequestBody ProductRequest productRequest) {
        return productService.saveProduct(productRequest);
    }

    @PutMapping("/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public ProductResponse updateProduct(@PathVariable String productId, @RequestBody ProductRequest productRequest) {
        return productService.updateProduct(productId, productRequest);
    }

    @GetMapping("/{productId}")
    public Optional<ProductResponse> findByProductId(@PathVariable String productId) {
        return productService.findByProductId(productId);
    }

    @DeleteMapping("/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable String productId) {
        productService.deleteByProductId(productId);
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<ProductResponse> updatePartialProduct(@PathVariable String productId,
                                                                @RequestBody Map<String, Object> fields) {
        return ResponseEntity.ok(productService.updatePartialProduct(productId, fields));
    }

}
