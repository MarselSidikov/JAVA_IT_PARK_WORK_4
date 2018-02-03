package ru.itpark.vk.client;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>();
    converters.add(new MappingJackson2HttpMessageConverter());

    RestTemplate template = new RestTemplate(converters);

    Response response = template.getForObject("https://api.vk.com/method/friends.get?user_id=72440542&fields=nickname,domain,sex,bdate,city,country",
        Response.class);

    System.out.println(response);
  }
}
