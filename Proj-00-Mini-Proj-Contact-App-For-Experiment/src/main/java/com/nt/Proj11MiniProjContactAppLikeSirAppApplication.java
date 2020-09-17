package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@ComponentScan({"com.nt.dao","com.nt.service","com.nt.controller"})
//@EntityScan({"com.nt.model","com.nt.entity"}) //All these three are required when our main method class is not present in the root folder like this one com.nt and the other components are present in the con.nt.*
//@EnableJpaRepositories("com.nt.dao")
public class Proj11MiniProjContactAppLikeSirAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(Proj11MiniProjContactAppLikeSirAppApplication.class, args);
	}

}
