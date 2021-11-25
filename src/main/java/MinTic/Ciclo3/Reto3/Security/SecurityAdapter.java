/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MinTic.Ciclo3.Reto3.Security;

import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gadoj
 */
@RestController
public class SecurityAdapter extends WebSecurityConfigurerAdapter {
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/").authorizeRequests()
                .antMatchers(new String[]{"/**", "/sin-restriccion", "/saludo"}).permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login();
        http.cors().and().csrf().disable();

    }
}



