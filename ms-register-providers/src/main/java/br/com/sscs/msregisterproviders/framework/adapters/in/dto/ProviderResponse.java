package br.com.sscs.msregisterproviders.framework.adapters.in.dto;

import br.com.sscs.msregisterproviders.domain.enums.Address;
import lombok.Data;

import java.util.UUID;

@Data
public class ProviderResponse {

    private String providerId;

    private String name;

    private int ein;

    private String telephone;

    private Address address;
}
