package com.ShoppingWebsiteApplication.security;

import com.ShoppingWebsiteApplication.security.filter.JwtRequestFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfigure extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .headers().frameOptions().disable()
                .authorizeRequests().antMatchers("/api/public/authenticate").permitAll()
                .antMatchers("/user/create").permitAll()
                .antMatchers("/user/update/{userId}").permitAll()
                .antMatchers("/user/delete/{userId}").permitAll()
                .antMatchers("/user/delete/name/{userName}").permitAll()
                .antMatchers("/user/get/status/{userName}").permitAll()
                .antMatchers("/user/get/id/{userName}").permitAll()
                .antMatchers("/user/getAll").permitAll()
                .antMatchers("/item/create").permitAll()
                .antMatchers("/item/get/{itemId}").permitAll()
                .antMatchers("/item/get/price/{itemId}").permitAll()

                .antMatchers("/item/delete/{itemId}").permitAll()
                .antMatchers("/item/update/{itemId}").permitAll()
                .antMatchers("/item/update/quantity/{itemId}").permitAll()
                .antMatchers("/item/getAll").permitAll()
                .antMatchers("/order/create").permitAll()
                .antMatchers("/order/get/{orderId}").permitAll()
                .antMatchers("/order/getAll").permitAll()
                .antMatchers("/order/getAll/userName/{userName}").permitAll()
                .antMatchers("/order/update/shippingAddress/{orderId}").permitAll()
                .antMatchers("/order/update/status/{orderId}").permitAll()

                .antMatchers("/order/delete/{orderId}").permitAll()
                .antMatchers("/order/delete/name/{userName}").permitAll()
                .antMatchers("/orderItems/create").permitAll()
                .antMatchers("/orderItems/create/one").permitAll()

                .antMatchers("/orderItems/delete/{orderItemsId}").permitAll()
                .antMatchers("/orderItems/delete/{orderId}/{ItemsId}").permitAll()
                .antMatchers("/orderItems/delete/userName/{userName}").permitAll()
                .antMatchers("/orderItems/delete/user/{userName}").permitAll()
                .antMatchers("/orderItems/update/quantity/{orderId}/{ItemsId}").permitAll()
                .antMatchers("/orderItems/decrease/quantity/{orderId}/{ItemsId}").permitAll()
                .antMatchers("/orderItems/get/quantity/{orderId}/{ItemId}").permitAll()
                .antMatchers("/orderItems/get/quantity/item/{userName}/{ItemId}").permitAll()
                .antMatchers("/orderItems/delete/allItems/{orderId}").permitAll()
                .antMatchers("/orderItems/getAll/{orderId}").permitAll()
                .antMatchers("/orderItems/getAllTry/{orderId}").permitAll()
                .antMatchers("/orderItems/getAll/ordersItems").permitAll()
                .antMatchers("/orderItems/getAll/orderIds").permitAll()
                .antMatchers("/userItems/create").permitAll()
                .antMatchers("/userItems/delete/{userName}/{ItemId}").permitAll()
                .antMatchers("/userItems/delete/name/{userName}").permitAll()
                .antMatchers("/userItems/getAll/{userName}").permitAll()
                .antMatchers("/userItems/getAll/{userId}").permitAll()
                .antMatchers("/userItems/getAll/userNames").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}

