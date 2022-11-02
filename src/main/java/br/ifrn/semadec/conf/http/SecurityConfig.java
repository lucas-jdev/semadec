package br.ifrn.semadec.conf.http;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*
* configuration of the security of the application
* Spring security configuration 
*/
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        _authorizeEndpoints(http);

        _disableCSRF(http);

        _disableFormSpringSecurity(http);

        _disableLogoutApplication(http);
    }

    private void _disableLogoutApplication(HttpSecurity http) throws Exception {
        http.logout().disable();
    }

    private void _disableFormSpringSecurity(HttpSecurity http) throws Exception {
        http.formLogin().disable();
    }

    private void _disableCSRF(HttpSecurity http) throws Exception {
        http.csrf().disable();
    }

    private void _authorizeEndpoints(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/graphql").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();
    }

}
