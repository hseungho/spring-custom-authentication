package com.hseungho.spring.authentication.web.configurer;

import com.hseungho.spring.authentication.web.aspect.UserAuthorizeAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AuthenticationAspectConfiguration {

    @Bean
    public UserAuthorizeAspect userAuthorizeAspect() {
        return new UserAuthorizeAspect();
    }

}
