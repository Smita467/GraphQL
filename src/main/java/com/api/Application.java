package com.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.api.repository.UserDeviceRepository;
import com.api.resolver.Mutation;
import com.api.resolver.Query;



@EnableJpaAuditing
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

   
    @Bean
    public Query query(UserDeviceRepository userRepository){
        return new Query(userRepository);
    }

    @Bean
    public Mutation mutation(UserDeviceRepository userRepository){
        return new Mutation(userRepository);
    }
    


}