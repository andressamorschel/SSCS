package br.com.sscs.msregisterproducts.framework.adapters.in.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class ProductRequest {

    @JsonIgnore
    private String productId;

    private String name;

    private String brand;

    private float price;

    private String providerId;
}
