package com.example.signeasy;

import com.example.signeasy.config.SwaggerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.example.signeasy")
@Import({SwaggerConfig.class})
public class SigneasyApplication {

	@Autowired
	private Environment environment;

	public static void main(String[] args) {

		SpringApplication.run(SigneasyApplication.class, args);
	}
}
