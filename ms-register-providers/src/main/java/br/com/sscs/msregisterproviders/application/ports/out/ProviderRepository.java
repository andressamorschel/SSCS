package br.com.sscs.msregisterproviders.application.ports.out;

import br.com.sscs.msregisterproviders.domain.Provider;

import java.util.List;
import java.util.Optional;

public interface ProviderRepository {

    Provider saveProvider(Provider provider);

    List<Provider> findAllProviders();

    Optional<Provider> findByProviderId(String providerId);

    void deleteByProviderId(String providerId);
}
