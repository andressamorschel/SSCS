package br.com.sscs.msregisterproviders.application.service;

import br.com.sscs.msregisterproviders.application.ports.in.ProviderService;
import br.com.sscs.msregisterproviders.application.ports.out.ProviderRepository;
import br.com.sscs.msregisterproviders.domain.Provider;
import br.com.sscs.msregisterproviders.framework.adapters.in.dto.ProviderRequest;
import br.com.sscs.msregisterproviders.framework.adapters.in.dto.ProviderResponse;
import br.com.sscs.msregisterproviders.framework.adapters.in.exceptions.ProviderNotFoundException;
import br.com.sscs.msregisterproviders.framework.adapters.in.mapper.ProviderMapper;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
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
        providerRepository.saveProvider(provider);
        return providerMapper.entityToResponse(provider);
    }

    @Override
    public void deleteByProviderId(String providerId) {
        if (providerRepository.findByProviderId(providerId).isEmpty()) {
            throw new ProviderNotFoundException(
                    String.format("provider not found with id: %b", providerId));
        }

        providerRepository.deleteByProviderId(providerId);
    }

    @Override
    public Provider updateProvider(String providerId, ProviderRequest request) {
        var provider = providerRepository.findByProviderId(providerId);
        request.setProviderId(providerId);

        provider.get().setProviderId(request.getProviderId());
        provider.get().setName(request.getName());
        provider.get().setEin(request.getEin());
        provider.get().setAddress(request.getAddress());
        provider.get().setTelephone(request.getTelephone());
        
        return providerRepository.saveProvider(provider.get());
    }

    @Override
    public List<ProviderResponse> findAllProviders() {
        return providerMapper.entityToListResponse(providerRepository.findAllProviders());
    }

    @Override
    public Optional<ProviderResponse> findByProviderId(String providerId) {
        var provider = providerRepository.findByProviderId(providerId);

        if (provider.isEmpty()) {
            throw new ProviderNotFoundException("provider not found");
        }

        return Optional.of(providerMapper.entityToResponse(provider.get()));
    }
}
