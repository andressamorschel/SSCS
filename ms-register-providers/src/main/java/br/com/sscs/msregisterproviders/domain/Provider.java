package br.com.sscs.msregisterproviders.domain;

import br.com.sscs.msregisterproviders.domain.enums.Address;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@Document
@Data
public class Provider {

    @Id
    private String id;

    private UUID providerId;

    private String name;

    private int ein;

    private String telephone;

    private LocalDate createdOn;

    private Address address;


}
