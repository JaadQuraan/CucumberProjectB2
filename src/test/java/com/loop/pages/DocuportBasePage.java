package com.loop.pages;

import com.loop.utilities.BrowserUtils;
import com.loop.utilities.DocuportConstants;
import com.loop.utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedWriter;
import java.time.Duration;

public class DocuportBasePage {

    private static final Logger LOG = LogManager.getLogger();

    @FindBy(xpath = "//span[.='Home']")
    public static WebElement home;
    @FindBy(xpath = "//span[.=' Continue ']")
    public static WebElement continueButton;


    public String getElementText(String text) {
        String xpath = "//*[normalize-space()='" + text + "']";
        return Driver.getDriver().findElement(By.xpath(xpath)).getText();
    }

    public WebElement getElement(String text) {
        String xpath = "//*[normalize-space()='" + text + "']";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    public static void clickButton(String button) {
        switch (button.toLowerCase()) {
            case "continue":
//              //  BrowserUtils.justWait(2);
//                BrowserUtils.waitForVisibility(continueButton,DocuportConstants.large);
//                BrowserUtils.waitForClickable(continueButton,DocuportConstants.large);
//                BrowserUtils.clickWithJS(continueButton);
                break;
            case "home":
                // Re-locate the element
              //  BrowserUtils.justWait(1);
                WebElement homeButton = Driver.getDriver().findElement(By.xpath("//span[.='Home']"));
                BrowserUtils.waitForVisibility(home,DocuportConstants.large);
                BrowserUtils.waitForClickable(home, DocuportConstants.large).click();
                //BrowserUtils.clickWithJS(home);
                // Alternatively, you can try clicking with JavaScript if the normal click fails
                // BrowserUtils.clickWithJS(homeButton);
                break;
            case "invitations":
                WebElement invitationButton = Driver.getDriver().findElement(By.xpath("//span[.='Invitations']"));
                BrowserUtils.waitForVisibility(invitationButton, 10);
                BrowserUtils.clickWithJS(invitationButton);
                //invitationButton.click();
                break;
            case "leads":
                WebElement leadsButton = Driver.getDriver().findElement(By.xpath("//span[.='Leads']"));
                BrowserUtils.waitForVisibility(leadsButton, 10);
                // BrowserUtils.waitForClickable(leadsButton,DocuportConstants.large).click();
                BrowserUtils.clickWithJS(leadsButton);
                break;
            case "users":
                try {
                    WebElement usersButton = Driver.getDriver().findElement(By.xpath("//span[.='Users']"));
                    BrowserUtils.waitForVisibility(usersButton, 10);
             //       BrowserUtils.waitForClickable(usersButton,DocuportConstants.large).click();
                    BrowserUtils.clickWithJS(usersButton);
                } catch (TimeoutException e) {
                    System.out.println("Timeout exception occurred while waiting for the Users button to be visible.");
                    // Handle the exception as needed, such as logging or retrying the action
                }
                break;
            default:
                LOG.error("No such " + button + "exists");
                throw new IllegalArgumentException();
        }

    }
}