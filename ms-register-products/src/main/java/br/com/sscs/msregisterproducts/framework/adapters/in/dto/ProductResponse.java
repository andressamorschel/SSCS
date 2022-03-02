package br.com.sscs.msregisterproducts.framework.adapters.in.dto;

import lombok.Data;

@Data
public class ProductResponse {

    private String productId;

    private String name;

    private String brand;

    private float price;

}
