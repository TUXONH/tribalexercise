package com.tribal.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;


import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

@Configuration
@EnableWebSecurity
public class BasicConfiguration extends WebSecurityConfigurerAdapter implements RequestMatcher {
    private final Pattern notAllowedMethods = Pattern.compile("^(GET|HEAD|TRACE|OPTIONS)$");
    private final RegexRequestMatcher unprotectedMatcher = new RegexRequestMatcher("/unprotected", null);

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.POST, "validCredit").permitAll();
    }

    @Override
    public boolean matches(HttpServletRequest request) {
        if (notAllowedMethods.matcher(request.getMethod()).matches()) {
            return false;
        }
        return !unprotectedMatcher.matches(request);
    }
}
