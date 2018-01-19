package com.xtlh.springbootdemo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootdemoApplication {

	public static void main(String[] args) {
		
//		SpringApplication.run(SpringbootdemoApplication.class, args);

		SpringApplication app = new SpringApplication(SpringbootdemoApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);

	}
}
