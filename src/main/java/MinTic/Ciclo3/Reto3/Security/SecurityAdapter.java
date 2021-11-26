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
        http.authorizeRequests(a -> a
                .antMatchers("/**","/error","/webjars/**").permitAll()
                .anyRequest().authenticated()              
            ).exceptionHandling(e -> e
                    .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))                    
            ).oauth2Login();
        
        http.cors().and().csrf().disable();
        
    }
    
    
}


//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.antMatcher("/privado").authorizeRequests()
//                .antMatchers(new String[]{"/**", "/sin-restriccion", "/saludo", "/webjars/**"}).permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .oauth2Login();
//        http.cors().and().csrf().disable();
//
//    }
