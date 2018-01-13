package ru.itpark.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration // говорим, что класс является конфигурационным классом Spring-а
@ComponentScan(basePackages = "ru.itpark") // говорим спрингу, где следует искать компоненты
@EnableTransactionManagement
public class SpringConfig {

  // @Value - позволяет вытаскавать настройки из properties-файла
  @Value("${hibernate.dialect}")
  private String hibernateDialect;

  @Value("${hibernate.hbm2ddl.auto}")
  private String hibernateDdlAuto;

  @Value("${hibernate.show_sql}")
  private String hibernateShowSql;

  @Autowired
  @Qualifier(value = "driverManagerDataSource")
  private DataSource dataSource;

  @Bean
  @Scope(value = "prototype")
  public JdbcTemplate jdbcTemplate() {
    return new JdbcTemplate(dataSource);
  }

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    // создаем фабрику менеджеров сущностей
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    // говорим ей, какой datasource использовать
    em.setDataSource(dataSource);
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
