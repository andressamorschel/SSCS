package br.com.sscs.msregisterproviders.framework.adapters.out.persistence;

import br.com.sscs.msregisterproviders.application.ports.out.ProviderRepository;
import br.com.sscs.msregisterproviders.domain.Provider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ProviderRepositoryImpl implements ProviderRepository {

    @Autowired
    ProviderMongoRepository providerMongoRepository;

    @Override
    public Provider createProvider(Provider provider) {
        return providerMongoRepository.insert(provider);
    }

    @Override
    public List<Provider> findAllProviders() {
        return providerMongoRepository.findAll();
    }

    @Override
    public Optional<Provider> findProvidersById(UUID providerId) {
        return providerMongoRepository.findByProviderId(providerId);
    }

    @Override
    public void deleteProvider(UUID providerId) {
        providerMongoRepository.deleteById(providerId.toString());
    }


}
