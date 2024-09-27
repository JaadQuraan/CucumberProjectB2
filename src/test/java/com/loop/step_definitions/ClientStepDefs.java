package com.loop.step_definitions;

import com.loop.pages.ClientPage;
import com.loop.pages.DocuportBasePage;
import com.loop.pages.LoginPage;
import com.loop.utilities.BrowserUtils;
import com.loop.utilities.DocuportConstants;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;

import static org.assertj.core.api.SoftAssertionsProvider.assertSoftly;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ClientStepDefs {

    ClientPage clientPage = new ClientPage();
    LoginPage loginPage = new LoginPage();
    private Logger LOG = LogManager.getLogger();
    private SoftAssertions softAssertions = new SoftAssertions();


    @Then("user validates {string} text is displayed")
    public void user_validates_text_is_displayed(String text) {
        //assertTrue(loginPage.getElement(text).isDisplayed());
        String actual = loginPage.getElementText(text);
        // assertEquals("Actual text: " + actual + " does NOT match expected: " + text, actual, text);
        softAssertions.assertThat(actual).isEqualTo(text);

    }
    @Then("user clicks {string} button")
    public void user_clicks_button(String button) {
      //  BrowserUtils.waitForInvisibility(clientPage.continueButton, DocuportConstants.large);
        DocuportBasePage.clickButton(button);
    }
    @Then("user validates all soft assertions")
    public void user_validates_all_soft_assertions() {
        softAssertions.assertAll();
    }
}
