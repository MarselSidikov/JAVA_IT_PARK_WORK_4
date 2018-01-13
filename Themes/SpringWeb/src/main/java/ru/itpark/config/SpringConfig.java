package ru.itpark.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "ru.itpark")
public class SpringConfig {

  @Autowired
  @Qualifier(value = "driverManagerDataSource")
  private DataSource dataSource;

  @Bean
  @Scope(value = "prototype")
  public JdbcTemplate jdbcTemplate() {
    return new JdbcTemplate(dataSource);
  }
}
