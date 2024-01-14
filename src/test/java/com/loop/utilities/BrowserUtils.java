package com.loop.utilities;

import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.Set;

import static org.junit.Assert.assertTrue;


public class BrowserUtils {

    public static Scenario myScenario;

    /**
     * @author Jaad
     * Takes a screenshot at that specific scenario
     */

    public static void takeScreenshot(){
        try {
            myScenario.log("Current url is: " + Driver.getDriver().getCurrentUrl());
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            myScenario.attach(screenshot, "image/png", myScenario.getName());
        }catch (WebDriverException wbd){
            wbd.getMessage();
        } catch (ClassCastException cce){
            cce.getMessage();
        }
    }

    /**
     * validate if driver switched to expected URL and title
     *
     * @param driver
     * @param expectedUrl
     * @param expectedTitle
     * @author Jaad
     * implements assertion
     */

    public static void switchWindowAndValidate(WebDriver driver, String expectedUrl, String expectedTitle){
        expectedTitle = expectedTitle.toLowerCase();
        expectedUrl = expectedUrl.toLowerCase();
        Set <String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles){
            driver.switchTo().window(each);
            if(driver.getCurrentUrl().toLowerCase().contains(expectedUrl)){
                break;
            }
        }
        assertTrue(driver.getTitle().toLowerCase().contains(expectedTitle));
    }
    /**
     * switches to the new window by the exact title
     * returns to original window if the window with given title not found
     * @param driver
     * @param targetTitle
     *
     */
    public static void switchToWindow(WebDriver driver, String targetTitle){
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()){
            driver.switchTo().window(handle);
            if(driver.getTitle().contains(targetTitle)){
                return; //Ends the method and returns the method at the end
            }
        }
        driver.switchTo().window(origin);
    }

    /**
     * @param driver
     * @param expectedTitle
     *returns void, assertion is implemented
     * @author jaad
     */

    public static void validateTitle(WebDriver driver, String expectedTitle){
        assertTrue(driver.getTitle().contains(expectedTitle));
    }

    /**
     * Click any link from loop practice
     * @param nameOfPage
     * @author jaad
     */

    public static void loopLinkClick(String nameOfPage){
        WebElement element = Driver.getDriver().findElement(By.xpath("//a[.='" +nameOfPage+"']"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    /**
     * Moves the mouse to given element
     * @param element on which to hover
     * @author jaad
     */
    public static void hover(WebElement element){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    /**
     * Scrolls down to an element using javascript
     * @param element
     * @author jaad
     */

    public static void scrollToElement(WebElement element){
        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",element);
    }

    /**
     * Click on an element using JavaScript
     * @param element
     * @author jaad
     */
    public static void clickWithJS(WebElement element){
        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);",element);
        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    /**
     * Performs double click action on an element
     * @param element
     * @return void
     * @author jaad
     */

    public static void doubleClick(WebElement element){
        new Actions(Driver.getDriver()).doubleClick(element).build().perform();
    }

    /**
     * Wait for provided element to be visible on the page
     * @param element
     * @param timeToWaitInSec
     * @return element
     * @author jaad
     */
    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(timeToWaitInSec));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits for the provided elemen t to be invisible on the page
     * @param element
     * @param timeToWaitInSec
     * @return void
     * @author jaad
     */
    public static void waitForInvisibility(WebElement element, int timeToWaitInSec){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(timeToWaitInSec));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * Waits for provided element to be clickable
     * @param element
     * @param timeout
     * @return
     * @author jaad
     */

    public static WebElement waitForClickable(WebElement element, int timeout){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     *performs a pause
     * @param seconds
     * @author jaad
     */

    public static void justWait(int seconds){
        try{
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    // Method to take a screenshot and save it to a specified directory
    public static void takeScreenshotAndSave(String screenshotName) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        // Specify the directory where you want to save the screenshots
        String directoryPath = "C:\\Users\\quraa\\Documents\\CucumberScreenshots\\Docuport Login";

        // Create the directory if it doesn't exist
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Specify the path for the screenshot file
        Path targetPath = Path.of(directoryPath, screenshotName + ".png");

        try {
            // Copy the screenshot to the specified directory
            Files.copy(sourceFile.toPath(), targetPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }
}

