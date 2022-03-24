package br.com.sscs.msregisterproducts.framework.adapters.mapper;

import br.com.sscs.msregisterproducts.domain.Product;
import br.com.sscs.msregisterproducts.framework.adapters.in.dto.ProductRequest;
import br.com.sscs.msregisterproducts.framework.adapters.in.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductMapper {

    private final ModelMapper modelMapper;

    public Product requestToEntity(ProductRequest request){
        return modelMapper.map(request, Product.class);
    }

    public ProductResponse entityToResponse(Product product){
        return modelMapper.map(product, ProductResponse.class);
    }

    public List<ProductResponse> entityToListResponse(List<Product> products){
        return products.stream()
                .map(this::entityToResponse)
                .collect(Collectors.toList());
    }

    public ProductRequest entityToRequest(Product product){
        return modelMapper.map(product, ProductRequest.class);
    }
}
