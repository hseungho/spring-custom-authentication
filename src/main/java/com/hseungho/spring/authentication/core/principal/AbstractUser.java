package com.hseungho.spring.authentication.core.principal;

import com.hseungho.spring.authentication.core.UserRole;

abstract class AbstractUser implements User {

    private final String userId;
    private final UserRole role;

    protected AbstractUser(String userId, UserRole role) {
        this.userId = userId;
        this.role = role;
    }

    @Override
    public String getUserId() {
        return this.userId;
    }

    @Override
    public UserRole getRole() {
        return this.role;
    }
}
