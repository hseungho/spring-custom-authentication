package com.hseungho.spring.authentication.test.context.support;

import com.hseungho.spring.authentication.core.UserRole;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@WithAuthenticationContext(factory = WithHMockUserAuthenticationFactory.class)
public @interface WithHMockUser {

    String id() default "1";

    UserRole role() default UserRole.USER;

    @AliasFor(annotation = WithAuthenticationContext.class)
    HTestExecutionEvent setupBefore() default HTestExecutionEvent.TEST_METHOD;

}
