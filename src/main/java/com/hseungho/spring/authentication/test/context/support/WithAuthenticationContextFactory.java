package com.hseungho.spring.authentication.test.context.support;

import com.hseungho.spring.authentication.core.context.AuthenticationContext;

import java.lang.annotation.Annotation;

public interface WithAuthenticationContextFactory<A extends Annotation> {

    AuthenticationContext createAuthenticationContext(A annotation);

}
