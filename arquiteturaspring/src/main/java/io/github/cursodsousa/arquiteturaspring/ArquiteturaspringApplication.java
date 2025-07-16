package io.github.cursodsousa.arquiteturaspring;

import org.springframework.boot.Banner;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ArquiteturaspringApplication {

	public static void main(String[] args) {
//		SpringApplication.run(ArquiteturaspringApplication.class, args);
		
		StringApplicationBuilder builder = new StringApplicationBuilder(Application.class);
		builder.bannerMode(Banner.Mode.OFF);
		builder.run(args);
	}

}
