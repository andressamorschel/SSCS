package br.com.sscs.msregisterproviders.framework.adapters.in.mapper;

import br.com.sscs.msregisterproviders.domain.Provider;
import br.com.sscs.msregisterproviders.framework.adapters.in.dto.ProviderRequest;
import br.com.sscs.msregisterproviders.framework.adapters.in.dto.ProviderResponse;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProviderMapper {

    private final ModelMapper modelMapper;

    public Provider requestToEntity(ProviderRequest request) {
        return modelMapper.map(request, Provider.class);
    }

    public ProviderResponse entityToResponse(Provider provider) {
        return modelMapper.map(provider, ProviderResponse.class);
    }

    public List<ProviderResponse> entityToListResponse(List<Provider> providers) {
        return providers.stream()
                .map(this::entityToResponse)
                .collect(Collectors.toList());
    }

    public ProviderResponse requestToResponse(ProviderRequest request) {
        return modelMapper.map(request, ProviderResponse.class);
    }

    public Optional<Provider> requestToOptionalEntity(ProviderRequest request) {
        var response = modelMapper.map(request, Provider.class);
        return Optional.of(response);
    }

    public Provider responseToEntity(ProviderResponse response) {
        return modelMapper.map(response, Provider.class);
    }

}
