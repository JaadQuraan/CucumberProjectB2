package com.loop.pages;

import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartBearLoginPage extends SmartBearBasePage{

    @FindBy(xpath = "//input[@id='ctl00_MainContent_password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//input[@name='ctl00$MainContent$username']")
    public WebElement usernameBox;
    @FindBy(xpath = "//input[@type='submit']")
    public WebElement loginButton;

    public SmartBearLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
