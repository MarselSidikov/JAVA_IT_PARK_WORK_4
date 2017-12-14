package ru.itpark;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

public class HumansDaoJdbcImplTest {

  private HumansDaoJdbcImpl humansDao;

  @Before
  public void setUp() {
    EmbeddedDatabase database = new EmbeddedDatabaseBuilder()
        .setType(EmbeddedDatabaseType.HSQL)
        .addScript("schema.sql")
        .addScript("data.sql")
        .build();
    humansDao = new HumansDaoJdbcImpl(database);
  }

  @Test
  public void findOneTest() {
    Human actual = humansDao.find(2L);
    Human expected = Human.builder()
        .id(2L)
        .age(19)
        .citizen("Россия")
        .name("Андрей")
        .build();

    Assert.assertEquals(expected, actual);
  }
}