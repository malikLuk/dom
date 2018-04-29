package ru.dom.lukmanovcarhiring.configuration.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.io.Serializable;
import java.util.Collection;

public class CustomUser extends User implements Serializable{

  private static final long serialVersionUID = 5472777629671779288L;

  private final Long id;

  public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities, Long id) {
    super(username, password, authorities);
    this.id = id;
  }

  public CustomUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, Long id) {
    super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    this.id = id;
  }

  public Long getId() {
    return id;
  }

}
