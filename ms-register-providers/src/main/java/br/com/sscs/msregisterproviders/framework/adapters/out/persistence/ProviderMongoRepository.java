package br.com.sscs.msregisterproviders.framework.adapters.out.persistence;

import br.com.sscs.msregisterproviders.domain.Provider;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProviderMongoRepository extends MongoRepository<Provider, String> {

    Optional<Provider> findByProviderId(String providerId);
    void deleteByProviderId(String providerId);

}
