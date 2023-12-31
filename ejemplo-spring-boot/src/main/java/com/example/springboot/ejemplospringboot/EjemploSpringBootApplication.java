package com.example.springboot.ejemplospringboot;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan("com.example.springboot")
@EnableJpaRepositories("com.example.springboot.repository")
@EntityScan("com.example.springboot.entity")
public class EjemploSpringBootApplication {
	 @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
	public static void main(String[] args) {
		SpringApplication.run(EjemploSpringBootApplication.class, args);
	}
}



