/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduza.member.webfront;

import java.util.UUID;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import static org.springframework.security.oauth2.common.util.OAuth2Utils.STATE;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author jeasydev
 */
@Controller
@RequestMapping("/fb")
public class FacebookController {

    @Autowired
    FacebookService facebookService;

    //@Autowired
    // Facebook fb;
    @Value("${spring.social.facebook.appId}")
    String facebookAppId;
    @Value("${spring.social.facebook.appSecret}")
    String facebookSecret;
    @Value("${spring.social.facebook.apiVersion}")
    String facebookApiVersion;
    
    @RequestMapping("")
    public String index() {
        return "facebookConnect";
    }

    @RequestMapping("/auth")
    public String startAuthentication(HttpSession session)
            throws Exception {
        // fb.socialContextOperations().;
        String state = UUID.randomUUID().toString();
        session.setAttribute(STATE, state);

        OAuth2Operations oauthOperations = new FacebookConnectionFactory(facebookAppId, facebookSecret).getOAuthOperations();
        OAuth2Parameters params = new OAuth2Parameters();
        params.setRedirectUri("http://localhost:8080/member/fb/auth/callback");
        params.setState(state);

        String authorizeUrl = oauthOperations.buildAuthorizeUrl(
                GrantType.AUTHORIZATION_CODE, params);
        return "facebookConnected";//new RedirectView(authorizeUrl);
    }

    @RequestMapping("/auth/callback")
    public RedirectView callBack(@RequestParam("code") String code,
            @RequestParam("state") String state,
            HttpSession session) {
        String stateFromSession = (String) session.getAttribute(STATE);
        session.removeAttribute(STATE);
        if (!state.equals(stateFromSession)) {
            return new RedirectView("/login");
        }

        AccessGrant accessGrant = getAccessGrant(code);

        String facebookUserId = getFacebookUserId(accessGrant);
        session.setAttribute("facebookUserId", facebookUserId);
        return new RedirectView("/logged-in");
    }

    private AccessGrant getAccessGrant(String authorizationCode) {
        OAuth2Operations oauthOperations = new FacebookConnectionFactory(facebookAppId, facebookSecret).getOAuthOperations();
        return oauthOperations.exchangeForAccess(authorizationCode, "http://localhost:8080/member/fb/auth/callback", null);
    }

    private String getFacebookUserId(AccessGrant accessGrant) {
        Connection<Facebook> connection = new FacebookConnectionFactory(facebookAppId, facebookSecret).createConnection(accessGrant);
        ConnectionKey connectionKey = connection.getKey();
        return connectionKey.getProviderUserId();
    }

    //@GetMapping("/createFacebookAuthorization")
    @GetMapping("/c")
    public String createFacebookAuthorization() {
        return facebookService.createFacebookAuthorizationURL();
    }

    @GetMapping("/facebook")
    public void createFacebookAccessToken(@RequestParam("code") String code) {
        facebookService.createFacebookAccessToken(code);
    }

    @GetMapping("/getName")
    public String getNameResponse() {
        return facebookService.getName();
    }
//    public String helloFacebook(Model model) {
//        if (!facebook.isAuthorized()) {
//            return "redirect:/connect/facebook";
//        }
//
//        model.addAttribute(facebook.userOperations().getUserProfile());
//        PagedList homeFeed = facebook.feedOperations().getHomeFeed();
//        model.addAttribute("feed", homeFeed);
//
//        return "feeds";
//    }
}
