package com.nt.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication//(scanBasePackages = {"com.nt.dao","com.nt.controller","com.nt.service"})
@ComponentScan({"com.nt.dao","com.nt.controller","com.nt.service"})
@EntityScan({"com.nt.entity"})
@EnableJpaRepositories("com.nt.dao")
public class Proj09MiniProjectContactAppWithH2DatabaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(Proj09MiniProjectContactAppWithH2DatabaseApplication.class, args);
	}

}
