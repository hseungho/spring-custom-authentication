package com.hseungho.spring.authentication.core.token;

import com.hseungho.spring.authentication.core.Authentication;
import com.hseungho.spring.authentication.core.UserRole;
import com.hseungho.spring.authentication.core.principal.AuthUser;

import java.util.Collection;
import java.util.List;

import static java.util.List.copyOf;

public abstract class AbstractAuthenticationToken implements Authentication {

    private final Collection<UserRole> authorities;

    private boolean isAuthenticated = false;

    public AbstractAuthenticationToken(Collection<UserRole> authorities) {
        if (authorities == null) {
            this.authorities = List.of(UserRole.ANONYMOUS);
            return;
        }
        this.authorities = copyOf(authorities);
    }

    @Override
    public String getName() {
        if (this.getPrincipal() != null &&
                this.getPrincipal() instanceof AuthUser authenticatedUser) {
            return authenticatedUser.getUserId();
        }
        return "";
    }

    @Override
    public Collection<UserRole> getAuthorities() {
        return this.authorities;
    }


    @Override
    public boolean isAuthenticated() {
        return this.isAuthenticated;
    }

    @Override
    public void setAuthentication(boolean isAuthentication) {
        this.isAuthenticated = isAuthentication;
    }
}
