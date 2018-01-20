package ru.itpark.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.itpark.models.User;
import ru.itpark.repository.UsersRepository;

@Controller
public class UsersController {

  @Autowired
  private UsersRepository usersRepository;

  @RequestMapping(value = "/users", method = RequestMethod.GET)
  //@GetMapping(value = "/users")
  public ModelAndView getUsersPage() {
    ModelAndView modelAndView = new ModelAndView("users_page");
    modelAndView.addObject("users", usersRepository.findAll());
    return modelAndView;
  }

  @RequestMapping(value = "/users", method = RequestMethod.POST)
  public ModelAndView addUser(@ModelAttribute User user) {
    usersRepository.save(user);
    return new ModelAndView("redirect:/users");
  }

  @RequestMapping(value = "/users/for_delete", method = RequestMethod.GET)
  public ModelAndView deleteUser(@RequestParam("id") Long id) {
    usersRepository.delete(id);
    return new ModelAndView("redirect:/users");
  }
}
