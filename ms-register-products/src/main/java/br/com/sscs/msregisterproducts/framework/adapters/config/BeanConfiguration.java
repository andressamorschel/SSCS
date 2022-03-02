package br.com.sscs.msregisterproducts.framework.adapters.config;

import br.com.sscs.msregisterproducts.MsRegisterProductsApplication;
import br.com.sscs.msregisterproducts.application.ports.out.ProductRepository;
import br.com.sscs.msregisterproducts.application.service.ProductServiceImpl;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@Configuration
@ComponentScan(basePackageClasses = MsRegisterProductsApplication.class)
public class BeanConfiguration {

    @Bean
    ProductServiceImpl productServiceImpl(ProductRepository productRepository) {
        return new ProductServiceImpl(productRepository);
    }
}
