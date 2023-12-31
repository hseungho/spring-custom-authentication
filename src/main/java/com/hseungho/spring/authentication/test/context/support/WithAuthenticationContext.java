package com.hseungho.spring.authentication.test.context.support;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface WithAuthenticationContext {

    Class<? extends WithAuthenticationContextFactory<? extends Annotation>> factory();

    HTestExecutionEvent setupBefore() default HTestExecutionEvent.TEST_METHOD;

}
