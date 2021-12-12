package com.trunghoang.restaurant.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories({"com.trunghoang.restaurant.repositories"})
public class DatabaseConfig {
}
