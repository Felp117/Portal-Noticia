package br.com.portalNoticia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.portalNoticia"})
public class PortalNoticiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortalNoticiaApplication.class, args);
	}

}
