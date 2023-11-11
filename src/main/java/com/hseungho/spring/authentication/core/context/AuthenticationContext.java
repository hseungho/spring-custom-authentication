package com.hseungho.spring.authentication.core.context;

import com.hseungho.spring.authentication.core.Authentication;

public interface AuthenticationContext {

    Authentication getAuthentication();

    void setAuthentication(Authentication authentication);

}
