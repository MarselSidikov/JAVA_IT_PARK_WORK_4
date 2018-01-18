package ru.itpark.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import ru.itpark.models.User;
import ru.itpark.repository.UsersRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.List;

public class UsersController implements Controller{

  @Autowired
  UsersRepository usersRepository;

  @Override
  public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
    ModelAndView modelAndView = new ModelAndView("users_page");
    modelAndView.addObject("users", usersRepository.findAll());
    return modelAndView;
  }
}
