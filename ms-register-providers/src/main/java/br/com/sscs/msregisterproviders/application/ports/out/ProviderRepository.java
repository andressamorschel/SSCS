package br.com.sscs.msregisterproviders.application.ports.out;

import br.com.sscs.msregisterproviders.domain.Provider;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProviderRepository {

    Provider createProvider(Provider provider);
    List<Provider> findAllProviders();
    Optional<Provider> findProviderById(String providerId);
    void deleteByProviderId(String providerId);
}
