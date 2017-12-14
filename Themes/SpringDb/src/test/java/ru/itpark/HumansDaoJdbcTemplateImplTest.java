package ru.itpark;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class HumansDaoJdbcTemplateImplTest {

  HumansDaoJdbcTemplateImpl humansDao;

  @Before
  public void setUp() throws Exception {
    ApplicationContext context = new ClassPathXmlApplicationContext("test_context.xml");
    humansDao = context.getBean(HumansDaoJdbcTemplateImpl.class);
  }

  @Test
  public void find() throws Exception {
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