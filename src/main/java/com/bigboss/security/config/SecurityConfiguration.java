package com.bigboss.security.config;

import com.bigboss.handler.LoginFailureHandler;
import com.bigboss.handler.LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Value(value = "${security.enabled}")
    private Boolean enabled;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        if (enabled) {
            http.authorizeRequests().anyRequest().authenticated();
        } else {
            http.authorizeRequests().anyRequest().permitAll();
        }
        http.csrf().disable()
                .formLogin().loginProcessingUrl("/auth/token/by-code").usernameParameter("code").passwordParameter("code")
                .successHandler(new LoginSuccessHandler()).failureHandler(new LoginFailureHandler());
    }
}
