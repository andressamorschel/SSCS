package br.com.sscs.msregisterproducts.framework.adapters.in.dto;

import br.com.sscs.msregisterproducts.framework.adapters.in.dto.enums.Address;
import lombok.Data;

@Data
public class ProviderResponse {

    private String providerId;

    private String name;

    private int ein;

    private String telephone;

    private Address address;

}
