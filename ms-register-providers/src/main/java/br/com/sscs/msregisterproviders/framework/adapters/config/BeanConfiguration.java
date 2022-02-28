package br.com.sscs.msregisterproviders.framework.adapters.config;

import br.com.sscs.msregisterproviders.MsRegisterProvidersApplication;
import br.com.sscs.msregisterproviders.application.service.ProviderServiceImpl;
import br.com.sscs.msregisterproviders.application.ports.out.ProviderRepository;
import br.com.sscs.msregisterproviders.framework.adapters.in.mapper.ProviderMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = MsRegisterProvidersApplication.class)
public class BeanConfiguration {

    @Bean
    ProviderServiceImpl providerServiceImpl(ProviderRepository providerRepository,
                                            ProviderMapper providerMapper) {
        return new ProviderServiceImpl(providerRepository, providerMapper);
    }
}
