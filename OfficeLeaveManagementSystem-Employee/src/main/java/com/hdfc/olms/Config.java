package com.hdfc.olms;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
/**
 *@author Bharath Kumar
 *@created 12-Apr-2023
*
 */
@EnableWebSecurity
public class Config extends WebSecurityConfigurerAdapter {
  
    // Adding the roles
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("bharath@gmail.com").password("bharath").roles("USER").and()
                .withUser("praveen@gmail.com").password("praveen").roles("USER").and()
                .withUser("naveen@gmail.com").password("naveen").roles("USER").and()
                .withUser("ajay@gmail.com").password("ajay").roles("USER").and()
                .withUser("venkat@gmail.com").password("venkat").roles("USER").and()
                .withUser("sai@gmail.com").password("sai").roles("USER").and()
                .withUser("hasini@gmail.com").password("hasini").roles("USER").and()
                .withUser("vijay@gmail.com").password("vijay").roles("USER").and()
                .withUser("swathi@gmail.com").password("swathi").roles("USER");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	super.configure(http);
        http.csrf().disable();
    }
    
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}