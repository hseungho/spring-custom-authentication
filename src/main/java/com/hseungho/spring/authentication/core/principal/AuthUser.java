package com.hseungho.spring.authentication.core.principal;

import com.hseungho.spring.authentication.core.UserRole;

import java.util.Objects;

public class AuthUser extends AbstractUser {

    private AuthUser() {
        super("", UserRole.USER);
    }

    public AuthUser(String userId, UserRole role) {
        super(userId, role);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        AuthUser principal = (AuthUser) obj;
        if (principal.getUserId() == null
                || principal.getUserId().isBlank()
                || principal.getRole() == null) {
            return false;
        }
        if (!this.getUserId().equals(principal.getUserId())
                || this.getRole() != principal.getRole()) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getUserId(), this.getRole());
    }

    @Override
    public String toString() {
        return "AuthUser {" +
                "userId='" + this.getUserId() + '\'' +
                ", role=" + this.getRole() +
                '}';
    }
}
