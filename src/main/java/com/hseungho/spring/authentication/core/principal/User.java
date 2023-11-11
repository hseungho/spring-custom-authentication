package com.hseungho.spring.authentication.core.principal;


import com.hseungho.spring.authentication.core.UserRole;

public interface User {

    String getUserId();

    UserRole getRole();

}
