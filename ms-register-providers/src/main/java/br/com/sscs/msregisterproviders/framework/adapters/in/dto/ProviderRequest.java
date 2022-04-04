package br.com.sscs.msregisterproviders.framework.adapters.in.dto;

import br.com.sscs.msregisterproviders.domain.Address;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ProviderRequest {

    @JsonIgnore
    private String providerId;

    @NotBlank
    private String name;

    @NotBlank
    private int ein;

    @NotNull
    @Size(max = 11)
    private String telephone;

    @NotNull
    private Address address;

}
