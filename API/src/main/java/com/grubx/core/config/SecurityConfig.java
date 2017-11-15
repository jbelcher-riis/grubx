package com.grubx.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.grubx.core.security.JwtAuthenticationEntryPoint;
import com.grubx.core.security.JwtAuthenticationTokenFilter;
import com.grubx.core.security.JwtTokenParser;

/**
 * Sets up and configures HttpSecurity
 *
 * @author jbelcher
 *
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
	httpSecurity //
		.csrf().disable() //
		.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and() //
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests() //
		.antMatchers(HttpMethod.POST, "/api/v1/auth").permitAll() //
		.antMatchers(HttpMethod.POST, "/api/v1/users").permitAll() //
		.antMatchers("**").authenticated(); //

	httpSecurity.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
    }

    /**
     * sets up JwtTokenParser as a Bean
     *
     * @return
     */
    @Bean
    public JwtTokenParser jwtTokenParser() {
	return new JwtTokenParser();
    }

    /**
     * sets up JwtAuthenticationTokenFilter as a Bean
     *
     * @return
     */
    @Bean
    public JwtAuthenticationTokenFilter authenticationTokenFilterBean() {
	return new JwtAuthenticationTokenFilter();
    }

}
