package br.com.sscs.msregisterproviders.framework.adapters.in;

import br.com.sscs.msregisterproviders.application.ports.in.ProviderService;
import br.com.sscs.msregisterproviders.framework.adapters.in.dto.ProviderRequest;
import br.com.sscs.msregisterproviders.framework.adapters.in.dto.ProviderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/providers")
@RestController
@RequiredArgsConstructor
public class ProviderController {

    private final ProviderService providerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProviderResponse createProvider(@RequestBody ProviderRequest request) {
        return providerService.createProvider(request);
    }

    @DeleteMapping("/{providerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteByProviderId(@PathVariable String providerId) {
        providerService.deleteByProviderId(providerId);
    }

    @GetMapping
    public List<ProviderResponse> findAllProviders() {
        return providerService.findAllProviders();
    }

    @GetMapping("/{providerId}")
    public Optional<ProviderResponse> findByProviderId(@PathVariable String providerId) {
        return providerService.findByProviderId(providerId);
    }

    @PutMapping("/{providerId}")
    ResponseEntity<ProviderResponse> updateProvider(@PathVariable String providerId, @RequestBody ProviderRequest request) {
        var provider = providerService.updateProvider(providerId, request);
        return ResponseEntity.ok(provider);
    }

}
