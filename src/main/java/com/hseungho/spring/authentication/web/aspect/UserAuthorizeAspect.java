package com.hseungho.spring.authentication.web.aspect;

import com.hseungho.spring.authentication.annotation.UserAuthorize;
import com.hseungho.spring.authentication.core.Authentication;
import com.hseungho.spring.authentication.core.UserRole;
import com.hseungho.spring.authentication.core.context.AuthenticationContextHolder;
import com.hseungho.spring.authentication.exception.AuthenticationError;
import com.hseungho.spring.authentication.exception.AuthenticationException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Aspect
public class UserAuthorizeAspect {

    @Before("@annotation(com.hseungho.spring.authentication.annotation.UserAuthorize)")
    public void invoke(final JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        UserAuthorize preAuthorize = method.getAnnotation(UserAuthorize.class);

        Authentication authentication = AuthenticationContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication.getPrincipal() == null || !authentication.isAuthenticated()) {
            throw new AuthenticationException(AuthenticationError.UNAUTHORIZED, "You are an unauthorized user.");
        }

        if (!hasAnyRoles(preAuthorize, authentication.getAuthorities())) {
            throw new AuthenticationException(AuthenticationError.FORBIDDEN, "You cannot access this API.");
        }
    }

    private Set<UserRole> getPreAuthoritySet(UserAuthorize preAuthorize) {
        Set<UserRole> roleSet = new HashSet<>(Arrays.asList(preAuthorize.roles()));
        roleSet.add(preAuthorize.role());
        roleSet.add(UserRole.ADMIN);
        return roleSet;
    }

    private boolean hasAnyRoles(UserAuthorize preAuthorize, Collection<UserRole> authorities) {
        Set<UserRole> roleSet = getPreAuthoritySet(preAuthorize);
        for (UserRole role : authorities) {
            if (roleSet.contains(role)) {
                return true;
            }
        }
        return false;
    }
}
