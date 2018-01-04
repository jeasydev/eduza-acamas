package com.eduza.member.webfront;
// Generated Jan 3, 2018 7:52:18 PM by Hibernate Tools 4.3.1

import com.eduza.member.jpa.pojo.UserProfile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.apache.log4j.Logger;

public class UserProfileFromForm implements java.io.Serializable {

    private static final Logger logger = Logger.getLogger(UserProfileFromForm.class);
    private Long id;
    @NotNull(message = "Please insert your username.")
    @Size(min = 5, max = 20, message = "Username must be between 5 - 20 charaters long.")
    @Pattern(regexp = "^[a-zA-Z0-0]+$", message = "Username must be alphanumberic with no spaces")
    private String username;

    @NotNull(message = "Please insert your password.")
    private String password;

    private String secretCode;

    @NotNull(message = "Please fill your firstname.")
    private String firstName;

    @NotNull(message = "Please fill your lasename.")
    private String lastName;

    private String displayName;

    @NotNull(message = "Please select your gender.")
    private String gender;

    //@NotNull(message = "Please select your email.")
    private String email;

    //@NotNull(message = "Please select your birthDate.")
    private Date birthDate;
    private boolean isEnabled;
    private boolean isValidated;

    public UserProfileFromForm() {
    }

    private Date dateStringToDate(String date) {
        try {
            return new SimpleDateFormat("MM/dd/yyyy HH:mm").parse(date);
        } catch (ParseException ex) {
            logger.fatal(ex);
        }
        return null;
    }

    public UserProfileFromForm(String username, String password, String secretCode, String firstName, String lastName, String email, String birthDate, boolean isEnabled, boolean isValidated) {
        this.username = username;
        this.password = password;
        this.secretCode = secretCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = dateStringToDate(birthDate);
        this.isEnabled = isEnabled;
        this.isValidated = isValidated;
    }

    public UserProfile toEntity() {
        return new UserProfile(username, password, secretCode, firstName, lastName, email, birthDate, isEnabled, isValidated);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecretCode() {
        return this.secretCode;
    }

    public void setSecretCode(String secretCode) {
        this.secretCode = secretCode;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = dateStringToDate(birthDate);
    }

    public boolean isIsEnabled() {
        return this.isEnabled;
    }

    public void setIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public boolean isIsValidated() {
        return this.isValidated;
    }

    public void setIsValidated(boolean isValidated) {
        this.isValidated = isValidated;
    }

}
