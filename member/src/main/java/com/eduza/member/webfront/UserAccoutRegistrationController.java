/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduza.member.webfront;

import com.eduza.member.jpa.api.UserProfileService;
import com.eduza.member.jpa.pojo.UserProfile;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author jeasydev
 */
@Controller
public class UserAccoutRegistrationController {
    
    private static final Logger logger = Logger.getLogger(UserAccoutRegistrationController.class);
    
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false);
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }
    
    @Autowired
    private UserProfileService userProfileService;
    
    @RequestMapping("/rf")
    public String regFormInputPage() {
        return "reg-form";
    }
//
//    @RequestMapping(value = "/r", method = RequestMethod.POST)
//    public String regFormInputPage(
//            @RequestParam(name = "username") String username,
//            @RequestParam(name = "password", required = false) String password,
//            @RequestParam(name = "passwordc", required = false) String passwordc,
//            @RequestParam(name = "firstname", required = false) String firstname,
//            @RequestParam(name = "lastname", required = false) String lastname,
//            @RequestParam(name = "email", required = false) String email
//    ) {
//        logger.info(username);
//        return "reg-success";
//    }

    @RequestMapping(value = "/r", method = RequestMethod.GET)
    public String createUserProfile(Model model) {
        model.addAttribute("userProfileFromForm", new UserProfileFromForm());
        return "reg-form";
    }
    
    @RequestMapping(value = "/r", method = RequestMethod.POST)
    public String addUserProfileFromForm(@Valid UserProfileFromForm userProfileFromForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.warn("Form Error : UserProfile");
            return "reg-form-edit";
        }
        //do save
        //return "redirect:/user/" + userProfile.getUsername();
        UserProfile userProfile = userProfileFromForm.toEntity();
        userProfile.setSecretCode("xxx");
        userProfile.setIsEnabled(true);
        userProfile.setIsEnabled(true);
        userProfile.setBirthDate(new Date());
        userProfile.setEmail(userProfile.getUsername());
        Long id = userProfileService.saveUserProfile(userProfile);
        logger.info("New UserDetailRecord : id = " + id);
        return "reg-success";// + userProfile.getUsername();
    }
    
    @RequestMapping(value = "/user/{username}", method = RequestMethod.POST)
    public String showUserProfile(@PathVariable String username, Model model) {
        return "/user/" + username + "/view";
    }
    
}
