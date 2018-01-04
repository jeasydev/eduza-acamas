/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduza.member.jpa.impl;

import com.eduza.member.jpa.api.UserProfileEntity;
import com.eduza.member.jpa.api.UserProfileRepository;
import com.eduza.member.jpa.api.UserProfileService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jeasydev
 */
@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    private UserProfileRepository userProfileDAO;

    /**
     * เสร็จ
     *
     * @param id
     * @return
     */
    @Override
    public UserProfileEntity findById(Long id) {
        return userProfileDAO.findById(id);
    }

    /**
     * *
     * เสร็จ
     *
     * @param userProfile
     * @return
     */
    @Override
    public Long saveUserProfile(UserProfileEntity userProfile) {
        return userProfileDAO.saveUserProfile(userProfile);
    }

    @Override
    public void updateUserProfile(UserProfileEntity userProfile) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteUserProfileById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UserProfileEntity> findAllUserProfiles() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
