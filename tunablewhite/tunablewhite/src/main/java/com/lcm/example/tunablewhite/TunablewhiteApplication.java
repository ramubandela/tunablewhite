package com.lcm.example.tunablewhite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
//@SpringBootApplication(scanBasePackage={"com.lcm"})
//@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@EnableAsync
@EnableScheduling
public class TunablewhiteApplication {

	private static final Logger log = LoggerFactory.getLogger(TunablewhiteApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TunablewhiteApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@Bean("getrestTemplate")
	public RestTemplate getrestTemplate(){
		return new RestTemplate();
	}
}
