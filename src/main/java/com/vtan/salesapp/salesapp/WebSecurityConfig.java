package com.vtan.salesapp.salesapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//when the application run initially run the WebSecurityConfig class private
// UserDetailsService userDetailsService;
//but no userDetailsServic but there is the implemented class UserDetailsServiceImpl
@Configuration
@EnableWebSecurity
@Component
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //@Qualifier("userDetailsServiceImpl")
    //can not be create the instance like userDetailsService because already there is bean
    //name with a userDetailsService
    @Autowired
    //in the back end create the instance userDetailsServiceImpl using the class of UserDetailsServiceImpl
    @Qualifier("userDetailsServiceImpl")

    private UserDetailsService userDetailsService;
//bean factor is used for if we need create the object when the program is running
    //@Bean is used to create the object in the bean factor which is stored in  the memory

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
//this tiime we created the instance
// bCryptPasswordEncoder which is same name  of the bCryptPasswordEncoder method
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager createAuthManager() throws Exception{

        return authenticationManager();
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity security) throws Exception{
        security
                .authorizeRequests()
                .antMatchers("/employee").permitAll()
                //.antMatchers("/newemployee").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").defaultSuccessUrl("/dashboard", true)
                //.loginPage("/login").permitAll()
                .permitAll()
                .and()
                .logout()
                .permitAll();

    }

}
