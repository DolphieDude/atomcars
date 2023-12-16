package com.atomcars.repository;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan({
        "com.atomcars.entity",
        "com.atomcars.repository",
        "com.atomcars.service"
})
public class RepositoryTestConfig {
}
