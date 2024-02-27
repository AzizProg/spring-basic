package com.example.consumingrestfulservice;

import com.example.consumingrestfulservice.entity.Joke;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumingRestfulServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumingRestfulServiceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		return  builder.build();
	}

	@Bean
	public CommandLineRunner commandLineRunner(RestTemplate restTemplate) throws Exception{
		return args -> {
			Joke joke = restTemplate.getForObject("https://official-joke-api.appspot.com/random_joke",Joke.class);

            if (joke != null)
            	System.out.println(joke.toString());
		};
	}
}
