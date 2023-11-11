package com.hseungho.spring.authentication.web.filter;

import com.hseungho.spring.authentication.core.Authentication;
import com.hseungho.spring.authentication.core.UserRole;
import com.hseungho.spring.authentication.core.context.AuthenticationContextHolder;
import com.hseungho.spring.authentication.core.token.AuthenticationTokenUtils;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;

import java.io.IOException;
import java.util.Optional;

public class AuthenticationFilter implements Filter {

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {
        try {
            String userId = getUserId((HttpServletRequest) request);
            Optional<UserRole> role = getRoleOrNull((HttpServletRequest) request);

            Authentication authentication = AuthenticationTokenUtils.getAuthentication(userId, role);
            AuthenticationContextHolder.getContext().setAuthentication(authentication);

            chain.doFilter(request, response);
        } finally {
            AuthenticationContextHolder.clearContext();
        }
    }

    private String getUserId(HttpServletRequest request) {
        return request.getHeader(HttpHeaders.AUTHORIZATION);
    }

    private Optional<UserRole> getRoleOrNull(HttpServletRequest request) {
        return UserRole.from(request.getHeader("X-Role"));
    }

}
