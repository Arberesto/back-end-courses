package it.sevenbits.practice7.config;

import it.sevenbits.practice7.core.Repository.ItemsRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {
    @Bean
    public ItemsRepository ItemsRepository() {
        return new ItemsRepository();
    }
}