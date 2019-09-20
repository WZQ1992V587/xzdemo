package com.xz.swaggerdemo;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableSwagger2Doc
public class SwaggerdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerdemoApplication.class, args);
	}

}
