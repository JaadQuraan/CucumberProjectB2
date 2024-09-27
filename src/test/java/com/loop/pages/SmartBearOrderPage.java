package com.loop.pages;

import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartBearOrderPage extends SmartBearBasePage{

    @FindBy(xpath = "//select[@name='ctl00$MainContent$fmwOrder$ddlProduct']")
    public WebElement selectProduct;

    @FindBy(xpath = "//input[@name='ctl00$MainContent$fmwOrder$txtQuantity']")
    public WebElement quantity;

    @FindBy(xpath = "//input[@name='ctl00$MainContent$fmwOrder$txtUnitPrice']")
    public WebElement pricePerUnit;
    @FindBy(xpath = "//input[@name='ctl00$MainContent$fmwOrder$txtDiscount']")
    public WebElement discount;
    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_txtTotal']")
    public WebElement totalPrice;
    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_txtName']")
    public WebElement customerName;
    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox2']")
    public WebElement street;
    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox3']")
    public WebElement city;
    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox4']")
    public WebElement state;
    @FindBy(xpath = "//input[@value='American Express']")
    public WebElement americanExpressButton;

    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox6']")
    public WebElement cardNumber;
    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox5']")
    public WebElement zipCode;
    @FindBy(xpath = "//input[@id='ctl00_MainContent_fmwOrder_TextBox1']")
    public WebElement expirationDate;
    @FindBy(xpath = "//a[@id='ctl00_MainContent_fmwOrder_InsertButton']")
    public WebElement processButton;

    @FindBy(xpath = "//strong[contains(text(),'New order')]")
    public WebElement successMessage;



    public SmartBearOrderPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
