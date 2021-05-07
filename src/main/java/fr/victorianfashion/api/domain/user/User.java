package fr.victorianfashion.api.domain.user;

import java.util.Objects;

@EntityUser
// User root
public class User {

  private final String username;
  private final String password;
  private final String firstName;
  private final String lastName;
  private final String email;
  private final String phone;
  private Long id;

  public User(
      String username,
      String password,
      String firstName,
      String lastName,
      String email,
      String phone) {
    this.username = username;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phone = phone;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone() {
    return phone;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof User)) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(getUsername(), user.getUsername())
        && Objects.equals(getPassword(), user.getPassword())
        && Objects.equals(getFirstName(), user.getFirstName())
        && Objects.equals(getLastName(), user.getLastName())
        && Objects.equals(getEmail(), user.getEmail())
        && Objects.equals(getPhone(), user.getPhone())
        && Objects.equals(getId(), user.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        getUsername(),
        getPassword(),
        getFirstName(),
        getLastName(),
        getEmail(),
        getPhone(),
        getId());
  }

  @Override
  public String toString() {
    return "User{"
        + "username='"
        + username
        + '\''
        + ", password='"
        + password
        + '\''
        + ", firstName='"
        + firstName
        + '\''
        + ", lastName='"
        + lastName
        + '\''
        + ", email='"
        + email
        + '\''
        + ", phone='"
        + phone
        + '\''
        + ", id="
        + id
        + '}';
  }
}
