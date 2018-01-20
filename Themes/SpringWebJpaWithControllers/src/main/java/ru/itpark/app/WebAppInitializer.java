package ru.itpark.app;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import ru.itpark.config.SpringConfig;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected Class<?>[] getRootConfigClasses() {
    return new Class[]{SpringConfig.class};
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class[]{SpringConfig.class};
  }

  @Override
  protected String[] getServletMappings() {
    return new String[]{"/"};
  }
}
