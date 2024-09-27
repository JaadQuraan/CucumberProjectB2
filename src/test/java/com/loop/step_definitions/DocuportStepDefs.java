package com.loop.step_definitions;

import com.loop.pages.HomePage;
import com.loop.pages.LeadsPage;
import com.loop.pages.LoginPage;
import com.loop.utilities.BrowserUtils;
import com.loop.utilities.DocuportConstants;
import com.loop.utilities.Driver;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class DocuportStepDefs {


    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    LeadsPage leadsPage = new LeadsPage();

    @Then("rows per page shows by default {int}")
    public void rows_per_page_shows_by_default(Integer defaultRowsPerPage) {
        System.out.println(Driver.getDriver().getCurrentUrl());
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.textToBePresentInElement(Driver.getDriver().findElement(By.tagName("h1")), "leads"));
        Integer actualRowsPerPage = leadsPage.getRowsPerPageAmount();
        System.out.println(actualRowsPerPage);
        defaultRowsPerPage = 10;
        BrowserUtils.takeScreenshot();
        //assertEquals(defaultRowsPerPage,leadsPage.getRowsPerPageAmount()); //Gets current amount
        assertThat(leadsPage.getRowsPerPageAmount()).isEqualTo(defaultRowsPerPage).as("Actual does not match expected");
    }
    @Then("change rows per page to {int}")
    public void change_rows_per_page_to(Integer expectedRowsPerPage) {
        expectedRowsPerPage = 5;
        BrowserUtils.waitForClickable(leadsPage.rowsPerPageAmount, DocuportConstants.large).click();
        BrowserUtils.waitForVisibility(leadsPage.rowsPerPageList.get(0),DocuportConstants.large);
        leadsPage.changeRowsPerPageAmount(expectedRowsPerPage);
        BrowserUtils.takeScreenshot();
        assertEquals(expectedRowsPerPage,leadsPage.getRowsPerPageAmount()); //Validate rows per page was changed
    }

    @Then("rows per page shows by default {int} at {string}")
    public void rows_per_page_shows_by_default_at(Integer expectedNumberOfRows, String headerText) {
        //System.out.println(Driver.getDriver().getCurrentUrl());
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
       // wait.until(ExpectedConditions.textToBePresentInElement(Driver.getDriver().findElement(By.tagName("h1")), headerText));
        Integer actualRowsPerPage = leadsPage.getRowsPerPageAmount();
       // System.out.println(actualRowsPerPage);
        expectedNumberOfRows = 10;
        BrowserUtils.takeScreenshot();
        //assertEquals(defaultRowsPerPage,leadsPage.getRowsPerPageAmount()); //Gets current amount
        assertThat(leadsPage.getRowsPerPageAmount()).isEqualTo(expectedNumberOfRows).as("Actual does not match expected");
    }
}
