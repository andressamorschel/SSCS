package br.com.sscs.msregisterproviders.application.ports.in;

import br.com.sscs.msregisterproviders.framework.adapters.in.dto.ProviderRequest;
import br.com.sscs.msregisterproviders.framework.adapters.in.dto.ProviderResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProviderService {

    ProviderResponse createProvider(ProviderRequest request);
    void deleteByProviderId(String providerId);
    ProviderResponse updateProvider(UUID providerId, ProviderRequest request);
    List<ProviderResponse> findAllProviders();
    Optional<ProviderResponse> findByProviderId(String providerId);
}
