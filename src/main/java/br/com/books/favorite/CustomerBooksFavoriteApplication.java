package br.com.books.favorite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableRedisRepositories
@EnableCaching
public class CustomerBooksFavoriteApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerBooksFavoriteApplication.class, args);
	}

	@Bean("bookRestTemplate")
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}

