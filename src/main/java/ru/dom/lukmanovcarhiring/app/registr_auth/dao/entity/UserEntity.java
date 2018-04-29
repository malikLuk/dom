package ru.dom.lukmanovcarhiring.app.registr_auth.dao.entity;

import ru.dom.lukmanovcarhiring.common.dao.entity.CommonEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class UserEntity extends CommonEntity {

  @Column(name = "S_FIRST_NAME", unique=true)
  private String firstName;

  @Column(name = "S_LAST_NAME")
  private String lastName;

  @Column(name = "S_PASSWORD")
  private String password;

  @Column(name = "S_ROLE")
  private String role;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }
}
