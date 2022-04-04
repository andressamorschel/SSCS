package br.com.sscs.msregisterproviders.framework.adapters.in.dto;

import br.com.sscs.msregisterproviders.domain.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProviderResponse {

    private String providerId;

    private String name;

    private int ein;

    private String telephone;

    private Address address;

    private boolean activated;
}
