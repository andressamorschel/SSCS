package br.com.sscs.msregisterproviders.application.ports.in;

import br.com.sscs.msregisterproviders.framework.adapters.in.dto.ProviderRequest;
import br.com.sscs.msregisterproviders.framework.adapters.in.dto.ProviderResponse;

import java.util.List;
import java.util.Optional;

public interface ProviderService {

    ProviderResponse createProvider(ProviderRequest request);

    ProviderResponse updateProvider(String providerId, ProviderRequest request);

    List<ProviderResponse> findAllProviders();

    Optional<ProviderResponse> findByProviderId(String providerId);

    void disableProvider(String providerId);
}
