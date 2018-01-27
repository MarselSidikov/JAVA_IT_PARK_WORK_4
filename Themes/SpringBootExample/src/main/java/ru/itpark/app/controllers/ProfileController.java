package ru.itpark.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.itpark.app.models.User;
import ru.itpark.app.services.ProfileService;

@Controller
public class ProfileController {

  @Autowired
  private ProfileService profileService;

  @GetMapping("/profile")
  public String getProfilePage(@ModelAttribute("model") ModelMap model,
      Authentication authentication) {
    User user = profileService.getUserInformation(authentication);
    model.addAttribute("user", user);
    return "profile";
  }
}
