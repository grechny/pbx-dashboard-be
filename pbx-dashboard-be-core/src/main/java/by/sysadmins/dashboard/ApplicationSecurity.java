package by.sysadmins.dashboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import by.sysadmins.dashboard.security.RestAuthenticationEntryPoint;
import by.sysadmins.dashboard.security.RestAuthenticationFailureHandler;
import by.sysadmins.dashboard.security.RestAuthenticationSuccessHandler;
import by.sysadmins.dashboard.security.RestLogoutHandler;
import by.sysadmins.dashboard.security.RestLogoutSuccessHandler;
import by.sysadmins.dashboard.security.RestUserDetailsService;
import by.sysadmins.dashboard.security.RestUsernamePasswordAuthenticationFilter;
import by.sysadmins.dashboard.services.PasswordEncryptService;

@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private RestAuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    private RestAuthenticationFailureHandler authenticationFailureHandler;
    @Autowired
    private RestAuthenticationSuccessHandler authenticationSuccessHandler;
    @Autowired
    private RestLogoutHandler logoutHandler;
    @Autowired
    private RestLogoutSuccessHandler logoutSuccessHandler;
    @Autowired
    private RestUserDetailsService userDetailsService;
    @Autowired
    private RestUsernamePasswordAuthenticationFilter restUsernamePasswordAuthenticationFilter;
    @Autowired
    private PasswordEncryptService passwordEncryptService;

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncryptService.getPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/api/user/password").permitAll()
                .antMatchers("/api/**").authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint)
                .and()
                .logout()
                .logoutUrl("/api/user/logout")
                .invalidateHttpSession(true)
                .addLogoutHandler(logoutHandler)
                .deleteCookies("JSESSIONID")
                .logoutSuccessHandler(logoutSuccessHandler)
                .and()
                .csrf().disable();

        restUsernamePasswordAuthenticationFilter.setAuthenticationManager(this.authenticationManager());
        restUsernamePasswordAuthenticationFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler);
        restUsernamePasswordAuthenticationFilter.setAuthenticationFailureHandler(authenticationFailureHandler);
        restUsernamePasswordAuthenticationFilter.setRequiresAuthenticationRequestMatcher(
                new AntPathRequestMatcher("/api/user/login", "POST"));
        http.addFilterBefore(restUsernamePasswordAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
