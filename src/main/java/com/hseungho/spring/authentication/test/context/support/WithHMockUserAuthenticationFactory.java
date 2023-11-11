package com.hseungho.spring.authentication.test.context.support;

import com.hseungho.spring.authentication.core.Authentication;
import com.hseungho.spring.authentication.core.UserRole;
import com.hseungho.spring.authentication.core.context.AuthenticationContext;
import com.hseungho.spring.authentication.core.context.AuthenticationContextHolder;
import com.hseungho.spring.authentication.core.context.AuthenticationContextHolderStrategy;
import com.hseungho.spring.authentication.core.token.AuthenticationTokenUtils;

public class WithHMockUserAuthenticationFactory implements WithAuthenticationContextFactory<WithHMockUser> {

    private final AuthenticationContextHolderStrategy strategy = AuthenticationContextHolder
            .getContextHolderStrategy();

    @Override
    public AuthenticationContext createAuthenticationContext(WithHMockUser withUser) {
        String userId = withUser.id();
        UserRole role = withUser.role();
        Authentication authentication = AuthenticationTokenUtils.getAuthentication(userId, role);

        AuthenticationContext context = strategy.createEmptyContext();
        context.setAuthentication(authentication);

        return context;
    }
}
