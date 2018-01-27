package ru.itpark.app.security.details;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.itpark.app.models.State;
import ru.itpark.app.models.User;

import java.util.Collection;
import java.util.Collections;

// UserDetails - интерфейс Spring Security,
// который описывает объект авторизации
public class UserDetailsImpl implements UserDetails {
  // объект-модель. Наш UserDetailsImpl является
  // оберткой над этим объектом
  private User user;

  public UserDetailsImpl(User user) {
    this.user = user;
  }

  // метод, который поможет Spring-у понять
  // роль пользователя
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    // создаем объект аутентификации с ролью пользователя
    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(user.getRole().toString());
    return Collections.singletonList(grantedAuthority);
  }

  @Override
  public String getPassword() {
    return user.getHashPassword();
  }

  @Override
  public String getUsername() {
    return user.getEmail();
  }

  // методы проверки аккаунта
  @Override
  public boolean isAccountNonExpired() {
    return user.getState().equals(State.CONFIRMED);
  }

  @Override
  public boolean isAccountNonLocked() {
    return !user.getState().equals(State.BANNED);
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return user.getState().equals(State.CONFIRMED);
  }

  @Override
  public boolean isEnabled() {
    return user.getState().equals(State.CONFIRMED);
  }
}
