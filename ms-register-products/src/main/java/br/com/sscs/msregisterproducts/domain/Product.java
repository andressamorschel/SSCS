package br.com.sscs.msregisterproducts.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
@Data
public class Product {

    @Id
    private String id;

    private String productId;

    private String name;

    private String brand;

    private float price;

    private LocalDate createdOn;

}
