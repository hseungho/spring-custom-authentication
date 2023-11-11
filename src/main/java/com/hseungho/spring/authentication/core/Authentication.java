package com.hseungho.spring.authentication.core;

import com.hseungho.spring.authentication.core.principal.User;

import java.security.Principal;
import java.util.Collection;

public interface Authentication extends Principal {

    Collection<UserRole> getAuthorities();

    User getPrincipal();

    boolean isAuthenticated();

    void setAuthentication(boolean isAuthentication);

}
