package sda.pl.zdjavapol96.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import sda.pl.zdjavapol96.service.UserAppService;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final UserAppService userAppService;


    public SecurityConfiguration(UserAppService userAppService) {
        this.userAppService = userAppService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .headers()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST).authenticated()
                .antMatchers().authenticated()
                .and()
                .formLogin()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
