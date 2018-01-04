/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduza.member.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenStoreUserApprovalHandler;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 *
 * @author jeasydev
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

//    	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//	  auth.inMemoryAuthentication().withUser("mkyong").password("123456").roles("USER");
//	  auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
//	  auth.inMemoryAuthentication().withUser("dba").password("123456").roles("DBA");
//	}
    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("bill").password("abc123").roles("ADMIN").and()
                .withUser("bob").password("abc123").roles("USER").and()
                .withUser("user").password("password").roles("USER").and()
                .withUser("admin").password("password").roles("USER", "ADMIN");
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("user").password("password").roles("USER").and()
//                .withUser("admin").password("password").roles("USER", "ADMIN");
//
//    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //form Login ใช้อันนี้
        http.formLogin().and().authorizeRequests().antMatchers("/a/**").hasRole("USER").anyRequest().permitAll();

        // oAuth2 ใช้อันนี้
//        http
//                .csrf().disable() //  ต้องปิด เพราะจะให้ข้างนอกมาใช้
//                .anonymous().disable()
//                .authorizeRequests()
//                .antMatchers("/oauth/token").permitAll();//oauth/token - URI not found- 404 บน JBoss ต้อง map เป็ฯ /* ไม่ใช่ / กับ servletMapping
    }
    /**
     * *
     * เพิ่มเข้ามาใส่ในการ config oAuth2.0
     *
     *
     */
    @Autowired
    private ClientDetailsService clientDetailsService;

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }

    @Bean
    @Autowired
    public TokenStoreUserApprovalHandler userApprovalHandler(TokenStore tokenStore
    ) {
        TokenStoreUserApprovalHandler handler = new TokenStoreUserApprovalHandler();
        handler.setTokenStore(tokenStore);
        handler.setRequestFactory(new DefaultOAuth2RequestFactory(clientDetailsService));
        handler.setClientDetailsService(clientDetailsService);
        return handler;
    }

    @Bean
    @Autowired
    public ApprovalStore approvalStore(TokenStore tokenStore) throws Exception {
        TokenApprovalStore store = new TokenApprovalStore();
        store.setTokenStore(tokenStore);
        return store;
    }
}
