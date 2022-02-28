package br.com.sscs.msregisterproviders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsRegisterProvidersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsRegisterProvidersApplication.class, args);
	}

}
