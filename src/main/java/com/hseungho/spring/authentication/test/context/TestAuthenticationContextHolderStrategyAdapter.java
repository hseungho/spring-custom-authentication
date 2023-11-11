package com.hseungho.spring.authentication.test.context;

import com.hseungho.spring.authentication.core.context.AuthenticationContext;
import com.hseungho.spring.authentication.core.context.AuthenticationContextHolder;
import com.hseungho.spring.authentication.core.context.AuthenticationContextHolderStrategy;

public class TestAuthenticationContextHolderStrategyAdapter implements AuthenticationContextHolderStrategy {
    @Override
    public void clearContext() {
        TestAuthenticationContextHolder.clearContext();
    }

    @Override
    public AuthenticationContext getContext() {
        return TestAuthenticationContextHolder.getContext();
    }

    @Override
    public void setContext(AuthenticationContext context) {
        TestAuthenticationContextHolder.setContext(context);
    }

    @Override
    public AuthenticationContext createEmptyContext() {
        return AuthenticationContextHolder.createEmptyContext();
    }
}
