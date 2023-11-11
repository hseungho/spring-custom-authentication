package com.hseungho.spring.authentication.annotation;

import com.hseungho.spring.authentication.core.UserRole;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UserAuthorize {

    UserRole role() default UserRole.USER;

    UserRole[] roles() default { UserRole.USER };

}
