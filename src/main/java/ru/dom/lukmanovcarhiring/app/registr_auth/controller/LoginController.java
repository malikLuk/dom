package ru.dom.lukmanovcarhiring.app.registr_auth.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

  @GetMapping("/login")
  public String login(Model model) {
    return "login";
  }

}
