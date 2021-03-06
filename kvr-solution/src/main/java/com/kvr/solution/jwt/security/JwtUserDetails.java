package com.kvr.solution.jwt.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "masteruser")
@Getter
@Setter
public class JwtUserDetails implements UserDetails {

  private static final long serialVersionUID = 5155720064139820502L;

  @Id
  private final Long id;
  private final String username;
  private final String password;
  //private final Collection<? extends GrantedAuthority> authorities;

  public JwtUserDetails(Long id, String username, String password) {
    this.id = id;
    this.username = username;
    this.password = password;

//    List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
//    authorities.add(new SimpleGrantedAuthority(role));
//
//    this.authorities = authorities;
  }

  @JsonIgnore
  public Long getId() {
    return id;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @JsonIgnore
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @JsonIgnore
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @JsonIgnore
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @JsonIgnore
  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

}


