package com.Cosmoslots.ENUM;

import org.openqa.selenium.By;

public enum XPathEnum {
    USER_DROPDOWN("//div[contains(@class,'userDropDownBlock')]"),
    PROFILE_LINK("//a[text()='Profile']"),
    DOB("//label[text()='Date of Birth']//parent::div"),
    SELECT_DOB("//bs-datepicker-container[@aria-label='calendar']//following::span[contains(text(),'10')]"),
    SAVE_BUTTON("//button[normalize-space()='Save']"),
    KYC_VERIFICATION_BUTTON("(//button[normalize-space()='KYC verification'])[1]"),
    START_KYC_VERIFICATION_BUTTON("//button[contains(text(),'START KYC VERIFICATION')]"),
    START_PHOTO_KYC_VERIFICATION_BUTTON("//button[contains(text(),'START PHOTO VERIFICATION')]"),
    VERIFICATION("//BUTTON[contains(text(),'VERIFICATION')]"),
    ERROR_MESSAGE_DOB("//div[contains(text(),'birth date')]"),
    ERROR_MESSAGE_STATE("//div[contains(text(),'state')]"),
    ERROR_MESSAGE_COUNTRY("//div[contains(text(),'country')]"),
    COUNTRY("(//ng-select[@formcontrolname=\"countryId\"]//parent::div)[1]"),
    COUNTRY_SElECT("//span[text()='India']"),
    STATE("(//ng-select[@formcontrolname=\"stateId\"]//parent::div)[1]"),
    STATE_SElECT("//span[text()='Goa']"),
    STATE_CLEAR("(//label[text()='State']//following::span[@title=\"Clear all\"])[1]"),
    COUNTRY_CLEAR("(//label[text()='Country']//following::span[@title=\"Clear all\"])[1]");
	
		
    private final String xpath;

    XPathEnum(String xpath) {
        this.xpath = xpath;
    }

    public By getBy() {
        return By.xpath(xpath);
    }
    
    
}

