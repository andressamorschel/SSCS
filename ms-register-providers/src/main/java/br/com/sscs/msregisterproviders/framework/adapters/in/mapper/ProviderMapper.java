package br.com.sscs.msregisterproviders.framework.adapters.in.mapper;

import br.com.sscs.msregisterproviders.domain.Provider;
import br.com.sscs.msregisterproviders.framework.adapters.in.dto.ProviderRequest;
import br.com.sscs.msregisterproviders.framework.adapters.in.dto.ProviderResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProviderMapper {

    private final ModelMapper modelMapper;

    public Provider requestToEntity(ProviderRequest request){
        return modelMapper.map(request, Provider.class);
    }

    public ProviderResponse entityToResponse(Provider provider){
        return modelMapper.map(provider, ProviderResponse.class);
    }

}
