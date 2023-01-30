package com.ivelite.fokchongdev.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;

@Slf4j
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication()
        .withUser("hello")
        .password("$2a$12$8wznqiZojsfLlbrj.PlZfOtK3HIjmHyy5xK1Z84qakUbtqW8UxZ5O")
        .roles("admin");
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/js/**", "css/**", "images/**");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.cors().and().csrf().disable();
    http.authorizeRequests()
        .antMatchers("/", "/v1/fookchong/projects/**")
        .permitAll()
        .antMatchers(HttpMethod.OPTIONS)
        .authenticated()
        .anyRequest()
        .authenticated()
        .and()
        .formLogin()
        .loginProcessingUrl("/doLogin")
        .permitAll()
        .successHandler(
            ((request, response, authentication) -> {
              response.setContentType("application/json;charset=utf-8");
              PrintWriter out = response.getWriter();
              out.write(new ObjectMapper().writeValueAsString(authentication.getPrincipal()));
              out.flush();
              out.close();
            }))
        .and()
        .logout()
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "POST"))
        .permitAll()
        .logoutSuccessHandler(
            ((request, response, authentication) -> {
              response.setContentType("application/json;charset=utf-8");
              PrintWriter out = response.getWriter();
              out.write("Logout");
              out.flush();
              out.close();
            }))
        .deleteCookies("JSESSIONID")
        .and()
        .exceptionHandling()
        .authenticationEntryPoint(
            (req, resp, authException) -> {
              resp.setContentType("application/json;charset=utf-8");
              log.error("{}", authException);
              PrintWriter out = resp.getWriter();
              out.write("Please Login First: " + authException.getStackTrace());
              out.flush();
              out.close();
            })
        .and()
        .httpBasic();
  }
}
