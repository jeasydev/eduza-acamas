/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduza.member.jpa.api;

import com.eduza.member.jpa.pojo.UserProfile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jeasydev
 */
public interface UserProfileEntity {

    public Long getId();

    public void setId(Long id);

    public String getUsername();

    public void setUsername(String username);

    public String getPassword();

    public void setPassword(String password);

    public String getSecretCode();

    public void setSecretCode(String secretCode);

    public String getFirstName();

    public void setFirstName(String firstName);

    public String getMidName();

    public void setMidName(String midName);

    public String getLastName();

    public void setLastName(String lastName);

    public String getDisplayName();

    public void setDisplayName(String displayName);

    public String getGender();

    public void setGender(String gender);

    public String getEmail();

    public void setEmail(String email);

    public Date getBirthDate();

    public void setBirthDate(Date birthDate);

    public Date getRegistedDath();

    public void setRegistedDath(Date registedDath);

    public boolean isIsEnabled();

    public void setIsEnabled(boolean isEnabled);

    public boolean isIsValidated();

    public void setIsValidated(boolean isValidated);

    public Date getLastAccessDatetime();

    public void setLastAccessDatetime(Date lastAccessDatetime);

    public String getLanguageCode();

    public void setLanguageCode(String languageCode);

    public String getCountryCode();

    public void setCountryCode(String countryCode);
}
