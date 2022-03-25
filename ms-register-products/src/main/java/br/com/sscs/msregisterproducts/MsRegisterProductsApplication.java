package br.com.sscs.msregisterproducts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsRegisterProductsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsRegisterProductsApplication.class, args);
    }

}
