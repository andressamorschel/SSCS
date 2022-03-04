package br.com.sscs.msregisterproducts.framework.adapters.out.client;

import br.com.sscs.msregisterproducts.framework.adapters.in.dto.ProviderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Component
@FeignClient(name = "ms-register-products", url = "localhost:8080", path = "/providers")
public interface ProductFeignClient {

    @GetMapping(value = "/{providerId}")
    Optional<ProviderResponse> findProviderById(@PathVariable String providerId);

}
