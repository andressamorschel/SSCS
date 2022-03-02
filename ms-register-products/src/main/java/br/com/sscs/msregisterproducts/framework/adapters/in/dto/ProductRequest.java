package br.com.sscs.msregisterproducts.framework.adapters.in.dto;

import lombok.Data;

@Data
public class ProductRequest {

    private String name;

    private String brand;

    private float price;
}
