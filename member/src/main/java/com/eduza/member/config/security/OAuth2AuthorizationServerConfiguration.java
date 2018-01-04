/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduza.member.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 *
 * @author jeasydev
 */
@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @SuppressWarnings("FieldMayBeFinal")
    private static String REALM = "MY_OAUTH_REALM";

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private UserApprovalHandler userApprovalHandler;

    @Autowired
    @Qualifier("authenticationManagerBean")
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

        clients.inMemory()
                .withClient("app_user") //เดิม my-trusted-client
                .secret("app_pass")// secret
                .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
                //.authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
                //.redirectUris("http://localhost:9000/auth-code-server/callback")
                //.scopes("read", "write", "trust")
                .scopes("read_profile", "read_contacts")
                //.accessTokenValiditySeconds(120)//Access token is only valid for 2 minutes.
                .accessTokenValiditySeconds(11999999)
                .refreshTokenValiditySeconds(11999999);//Refresh token is only valid for 10 minutes.
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore).userApprovalHandler(userApprovalHandler)
                .authenticationManager(authenticationManager);

        //ปกติ oAuth จะยอมให้ใช้แค่ POST เท่านั้น หากใช้ get จะเจอ method not allow
        endpoints.allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);

    }
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints.tokenStore(tokenStore()).authenticationManager(authenticationManager);
//        endpoints.allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST)
//    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer.realm(REALM + "/client");
    }

}
