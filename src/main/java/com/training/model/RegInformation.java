package com.training.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RegInformation {

    private String lastName;
    private String firstName;
    private String middleName;
    private String fullName;
    private String nickName;
    private String comment;
    private UserGroup userGroup;
    private String homePhone;
    private String mobilePhoneFirst;
    private String mobilePhoneSecond;
    private String email;
    private String skype;
    private List<UserAddress> userAddress = new ArrayList<>();
    private Date entryDate;
    private Date lastChangeDate;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(UserGroup userGroup) {
        this.userGroup = userGroup;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getMobilePhoneFirst() {
        return mobilePhoneFirst;
    }

    public void setMobilePhoneFirst(String mobilePhoneFirst) {
        this.mobilePhoneFirst = mobilePhoneFirst;
    }

    public String getMobilePhoneSecond() {
        return mobilePhoneSecond;
    }

    public void setMobilePhoneSecond(String mobilePhoneSecond) {
        this.mobilePhoneSecond = mobilePhoneSecond;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public List<UserAddress> getUserAddress() {
        return userAddress;
    }

    public void addUserAddress(UserAddress userAddress) {
        this.userAddress.add(userAddress);
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }
}
