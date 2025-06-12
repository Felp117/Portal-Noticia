package br.com.portal.noticia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.portal.noticia"})
public class PortalNoticiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortalNoticiaApplication.class, args);
	}

}
