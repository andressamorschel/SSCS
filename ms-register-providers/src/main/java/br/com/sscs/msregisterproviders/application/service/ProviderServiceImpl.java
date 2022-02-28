package br.com.sscs.msregisterproviders.application.service;

import br.com.sscs.msregisterproviders.application.ports.in.ProviderService;
import br.com.sscs.msregisterproviders.application.ports.out.ProviderRepository;
import br.com.sscs.msregisterproviders.framework.adapters.in.dto.ProviderRequest;
import br.com.sscs.msregisterproviders.framework.adapters.in.dto.ProviderResponse;
import br.com.sscs.msregisterproviders.framework.adapters.in.exceptions.ProviderNotFoundException;
import br.com.sscs.msregisterproviders.framework.adapters.in.mapper.ProviderMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ProviderServiceImpl implements ProviderService {

    private final ProviderRepository providerRepository;
    private final ProviderMapper providerMapper;

    public ProviderServiceImpl(ProviderRepository providerRepository, ProviderMapper providerMapper) {
        this.providerRepository = providerRepository;
        this.providerMapper = providerMapper;
    }

    @Override
    public ProviderResponse createProvider(ProviderRequest request) {
        var provider = providerMapper.requestToEntity(request);
        provider.setCreatedOn(LocalDate.now());
        provider.setProviderId(UUID.randomUUID().toString());
        providerRepository.createProvider(provider);
        return providerMapper.entityToResponse(provider);
    }

    @Override
    public void deleteByProviderId(String providerId) {
        if (providerRepository.findProviderById(providerId).isEmpty()) {
            throw new ProviderNotFoundException(
                    String.format("provider not found with id: %b", providerId));
        }

        providerRepository.deleteByProviderId(providerId);
    }

    @Override
    public ProviderResponse updateProvider(UUID providerId, ProviderRequest request) {
        return null;
    }

    @Override
    public List<ProviderResponse> findAllProviders() {
        return providerMapper.entityToListResponse(providerRepository.findAllProviders());
    }

    @Override
    public Optional<ProviderResponse> findProvidersByProviderId() {
        return Optional.empty();
    }
}
