package br.com.sscs.msregisterproviders.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
@Data
public class Provider {

    @Id
    private String id;

    private String providerId;

    private String name;

    private int ein;

    private String telephone;

    private LocalDate createdOn;

    private Address address;


}
