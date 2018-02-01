package ru.itpark.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.itpark.app.dto.UserDto;
import ru.itpark.app.forms.UpdateUserForm;
import ru.itpark.app.models.User;
import ru.itpark.app.services.ProfileService;

@Controller
public class ProfileController {

  @Autowired
  private ProfileService profileService;

  @GetMapping("/profile")
  public String getProfilePage(@ModelAttribute("model") ModelMap model,
      Authentication authentication) {
    UserDto user = profileService.getUserInformation(authentication);
    model.addAttribute("user", user);
    return "profile";
  }

  @PostMapping(value = "/profile/update")
  @ResponseStatus(value = HttpStatus.ACCEPTED)
  public void updateProfile(Authentication authentication,
                            UpdateUserForm form) {
    profileService.updateProfile(authentication, form);
  }
}
