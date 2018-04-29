package ru.dom.lukmanovcarhiring.app.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import ru.dom.lukmanovcarhiring.configuration.security.CustomUser;

public class Utilities {

  public static CustomUser getUser() {
    CustomUser user = (CustomUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    return user;
  }

}
