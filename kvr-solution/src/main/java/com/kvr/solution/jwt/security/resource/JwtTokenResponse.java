package com.kvr.solution.jwt.security.resource;

import java.io.Serializable;

public class JwtTokenResponse implements Serializable {

  private static final long serialVersionUID = 8317676219297719109L;

  private final String token;
  
  private final Long masterUserId;

    public JwtTokenResponse(String token, Long masterUserId) {
        this.token = token;
        this.masterUserId = masterUserId;
    }

    public String getToken() {
        return this.token;
    }
    
    public Long getMasterUserId() {
        return this.masterUserId;
    }
}