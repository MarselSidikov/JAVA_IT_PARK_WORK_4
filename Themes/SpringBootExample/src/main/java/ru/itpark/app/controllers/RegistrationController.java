package ru.itpark.app.controllers;

import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.itpark.app.forms.RegistrationForm;
import ru.itpark.app.repositories.UsersRepository;
import ru.itpark.app.services.RegistrationService;

import java.util.Optional;

@Controller
public class RegistrationController {

  @Autowired
  private RegistrationService service;

  @GetMapping("/signUp")
  public String getSignUpPage() {
    return "sign_up";
  }

  @GetMapping("/signIn")
  public String getSignInPage(@ModelAttribute("model") ModelMap model,
                              @RequestParam(value = "error", required = false) String error) {
    if (error != null) {
      model.addAttribute("error", true);
    }
    return "sign_in";
  }

  @PostMapping("/signUp")
  public String registrationUser(@ModelAttribute RegistrationForm form) {
    service.registrationUser(form);
    return "success_sign_up";
  }

  @GetMapping("/confirm/{confirm-string}")
  public String getConfirmPage(@PathVariable("confirm-string") String confirmString,
                               @ModelAttribute("model") ModelMap model) {
    boolean confirmResult = service.confirmUser(confirmString);
    model.addAttribute("confirmResult", confirmResult);
    return "confirm_result";
  }
}
