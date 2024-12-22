package site.kgbmeu.kgb_movie;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.oauth2Login()
                .loginPage("/login")
                .userInfoEndpoint()
                .userService(customOAuth2UserService);
    }
}

