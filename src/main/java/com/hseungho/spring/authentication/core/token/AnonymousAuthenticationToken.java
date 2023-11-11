package com.hseungho.spring.authentication.core.token;

import com.hseungho.spring.authentication.core.UserRole;
import com.hseungho.spring.authentication.core.principal.User;
import org.springframework.util.Assert;

import java.util.Collection;

public class AnonymousAuthenticationToken extends AbstractAuthenticationToken {

    private final User principal;

    public AnonymousAuthenticationToken(User principal, Collection<UserRole> authorities) {
        super(authorities);
        Assert.isTrue(principal != null, "principal cannot be null or empty");
        this.principal = principal;
        setAuthentication(true);
    }

    @Override
    public User getPrincipal() {
        return this.principal;
    }

    @Override
    public String toString() {
        return "AnonymousAuthenticationToken{" +
                "principal=" + principal +
                '}';
    }
}
