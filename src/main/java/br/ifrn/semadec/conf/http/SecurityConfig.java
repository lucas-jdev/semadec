package br.ifrn.semadec.conf.http;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        _disableCSRF(http);

        _disableFormSpringSecurity(http);

        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .and().headers().frameOptions().sameOrigin();

        _disableLogoutApplication(http);
    }

    private void _disableLogoutApplication(HttpSecurity http) throws Exception {
        http.logout().disable();
    }

    private void _disableFormSpringSecurity(HttpSecurity http) throws Exception {
        http.formLogin().disable();
    }

    private void _disableCSRF(HttpSecurity http) throws Exception {
        http.csrf()
                .disable();
    }

}
