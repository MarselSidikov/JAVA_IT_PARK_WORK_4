package ru.itpark.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.itpark.repository.UsersRepository;

@Controller
public class UsersFreemarkerController {

  @Autowired
  private UsersRepository usersRepository;

  @RequestMapping(value = "/ftl/users", method = RequestMethod.GET)
  public String getUsers(@ModelAttribute("model")ModelMap model) {
    model.addAttribute("users", usersRepository.findAll());
    return "users_page";
  }
}
