///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.eduza.member.webfront;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Scope;
//import org.springframework.core.env.Environment;
//import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
//import org.springframework.social.config.annotation.EnableSocial;
//import org.springframework.social.config.annotation.SocialConfigurerAdapter;
//import org.springframework.social.facebook.api.Facebook;
//import org.springframework.social.facebook.api.impl.FacebookTemplate;
//import org.springframework.social.facebook.connect.FacebookConnectionFactory;
//import org.springframework.web.client.RestTemplate;
//
///**
// *
// * @author jeasydev
// */
//@Configuration
//@EnableSocial
//public class SocialConfig extends SocialConfigurerAdapter {
//
////    @Bean
////    public Facebook facebook() {
////        return new FacebookTemplate(environment.getProperty("facebook.accessToken"));
////    }
//    @Configuration
//    public static class FacebookConfiguration extends SocialConfigurerAdapter {
//
//        @Override
//        public void addConnectionFactories(ConnectionFactoryConfigurer connectionFactoryConfigurer,
//                Environment environment) {
//            connectionFactoryConfigurer.addConnectionFactory(
//                    new FacebookConnectionFactory(
//                            environment.getRequiredProperty("spring.social.facebook.appId"),
//                            environment.getRequiredProperty("spring.social.facebook.appSecret")
//                    )
//            );
//        }
//
//    }
//
//    @Bean
//    @Scope(value = "request")
//    public Facebook facebookApp() {
//        // retrieve app access token
//        RestTemplate restTemplate = new RestTemplate();
//        String result = restTemplate.getForObject("https://graph.facebook.com/oauth/access_token?grant_type=client_credentials&client_id="
//                + environment.getProperty("spring.social.facebook.appId") + "&client_secret="
//                + environment.getProperty("spring.social.facebook.appSecret"), String.class);
//        String appAccessToken = result.replaceAll("access_token=", "");
//        FacebookTemplate fbt = new FacebookTemplate(appAccessToken);
//        fbt.setApiVersion(environment.getProperty("spring.social.facebook.apiVersion"));
//        return fbt;
//    }
////
////    @Bean
////    @Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
////    public ConnectionFactoryLocator connectionFactoryLocator() {
////        ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
////
////        registry.addConnectionFactory(new FacebookConnectionFactory(
////                environment.getProperty("spring.social.facebook.appId"),
////                environment.getProperty("spring.social.facebook.appSecret")));
////
//////        registry.addConnectionFactory(new TwitterConnectionFactory(
//////                environment.getProperty("twitter.consumerKey"),
//////                environment.getProperty("twitter.consumerSecret")));
////        return registry;
////    }
////
//    @Autowired
//    private Environment environment;
//}
