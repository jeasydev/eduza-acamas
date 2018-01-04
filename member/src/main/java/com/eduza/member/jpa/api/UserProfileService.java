/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduza.member.jpa.api;

import java.util.List;

/**
 *
 * @author jeasydev
 */
public interface UserProfileService {

    UserProfileEntity findById(Long id);

    Long saveUserProfile(UserProfileEntity userProfile);

    void updateUserProfile(UserProfileEntity userProfile);

    void deleteUserProfileById(Long id);

    List<UserProfileEntity> findAllUserProfiles();

}
