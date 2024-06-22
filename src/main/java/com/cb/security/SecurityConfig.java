package com.cb.security;

import com.cb.filter.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Autowired
    private CustomAuthenticationProvider customAuthenticationProvider;

    @Autowired
    private AuthEntryPoint authEntryPoint;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        http
                .csrf(csrf -> csrf.disable()) // 禁用 CSRF
                .exceptionHandling(exceptionHandling -> exceptionHandling // 使用新的异常处理配置
                        .authenticationEntryPoint(authEntryPoint) // 配置认证入口点
                )
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(
                                "/api/auth/**",
                                "/webjars/**", //swagger2
                                "/v3/**", //swagger2
                                "/doc.**" //swagger2
                        ).permitAll() // 允许"/user/**"和"/doc.**"路径的访问
                        .anyRequest().authenticated() // 其他任何请求需要认证

                )
                .httpBasic(withDefaults()); // 使用默认的 HTTP Basic 认证
//                .rememberMe(withDefaults()); // 使用默认的记住我功能
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class); // 添加JwtRequestFilter
        return http.build(); // 构建并返回SecurityFilterChain
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .authenticationProvider(customAuthenticationProvider)
                .build();
    }

}
