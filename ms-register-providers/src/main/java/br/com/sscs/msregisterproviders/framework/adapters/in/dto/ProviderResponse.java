package br.com.sscs.msregisterproviders.framework.adapters.in.dto;

import br.com.sscs.msregisterproviders.domain.enums.Address;
import lombok.Builder;
import lombok.Data;

@Data
public class ProviderResponse {

    private String providerId;

    private String name;

    private int ein;

    private String telephone;

    private Address address;
}
