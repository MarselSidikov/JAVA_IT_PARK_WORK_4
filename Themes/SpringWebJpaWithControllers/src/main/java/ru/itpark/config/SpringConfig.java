package ru.itpark.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration // говорим, что класс является конфигурационным классом Spring-а
@ComponentScan(basePackages = "ru.itpark") // говорим спрингу, где следует искать компоненты
@EnableJpaRepositories(basePackages = "ru.itpark.repository")
@EnableTransactionManagement
@PropertySource(value = "classpath:ru.itpark\\application.properties")
@EnableWebMvc
public class SpringConfig extends WebMvcConfigurerAdapter {

  // @Value - позволяет вытаскавать настройки из properties-файла
  @Value("${hibernate.dialect}")
  private String hibernateDialect;

  @Value("${hibernate.hbm2ddl.auto}")
  private String hibernateDdlAuto;

  @Value("${hibernate.show_sql}")
  private String hibernateShowSql;

  @Value("${datasource.url}")
  private String dbUrl;

  @Value("${datasource.user}")
  private String dbUser;

  @Value("${datasource.password}")
  private String dbPassword;

  @Value("${datasource.driver}")
  private String dbDriver;

  @Bean
  @Scope(value = "prototype")
  public JdbcTemplate jdbcTemplate() {
    return new JdbcTemplate(dataSource());
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    // создаем фабрику менеджеров сущностей
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    // говорим ей, какой datasource использовать
    em.setDataSource(dataSource());
    // говорим, какие настройки использовать
    em.setJpaProperties(hibernateProperties());
    // говорим, где искать проаннотированные модели
    em.setPackagesToScan(new String[] { "ru.itpark.models"});
    // говорим, что работаем с хибернейнтом
    JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    em.setJpaVendorAdapter(vendorAdapter);
    // помещаем фабрику в контейнер бинов спринга
    return em;
  }

  @Bean // бин для менеджера транзакций
  public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(emf);
    return transactionManager;
  }

  @Bean
  public ViewResolver viewResolver() {
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setPrefix("/jsp/");
    viewResolver.setSuffix(".jsp");
    return viewResolver;
  }

  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setUrl(dbUrl);
    dataSource.setUsername(dbUser);
    dataSource.setPassword(dbPassword);
    dataSource.setDriverClassName(dbDriver);
    return dataSource;
  }

  // просто метод который возвращает объект с настройками
  // для хибернейта
  public Properties hibernateProperties() {
    Properties properties = new Properties();
    properties.setProperty("hibernate.dialect", hibernateDialect);
    properties.setProperty("hibernate.hbm2ddl.auto", hibernateDdlAuto);
    properties.setProperty("hibernate.show_sql", hibernateShowSql);

    return properties;
  }
}
