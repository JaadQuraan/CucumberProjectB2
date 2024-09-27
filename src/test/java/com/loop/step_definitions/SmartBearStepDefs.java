package com.loop.step_definitions;

import com.loop.pages.SmartBearLoginPage;
import com.loop.pages.SmartBearOrderPage;
import com.loop.pages.SmartBearViewAllOrdersPage;
import com.loop.utilities.BrowserUtils;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.DocuportConstants;
import com.loop.utilities.Driver;
import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class SmartBearStepDefs {

    SmartBearLoginPage smartBearLoginPage = new SmartBearLoginPage();
    SmartBearOrderPage smartBearOrderPage = new SmartBearOrderPage();

    SmartBearViewAllOrdersPage smartBearViewAllOrdersPage = new SmartBearViewAllOrdersPage();

    @Given("user login to SmartBear")
    public void userIsOnSmartBearLoginPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("smart.bear"));
        BrowserUtils.waitForClickable(smartBearLoginPage.usernameBox, DocuportConstants.large)
                .sendKeys(ConfigurationReader.getProperty("smart.username"));
        smartBearLoginPage.passwordBox.sendKeys(ConfigurationReader.getProperty("smart.password"));
        BrowserUtils.waitForClickable(smartBearLoginPage.loginButton,DocuportConstants.large).click();
        smartBearLoginPage.order.click();
    }
    @Given("user is already logged in and navigated to order page")
    public void user_is_already_logged_in_and_navigated_to_order_page() {
        System.out.println("User is on order page");
    }
    @When("user selects product type {string}")
    public void user_selects_product_type(String productType) { //Family Album
        BrowserUtils.waitForClickable(smartBearOrderPage.selectProduct,DocuportConstants.large);
        Select productTypeDropdown = new Select(smartBearOrderPage.selectProduct);
        productTypeDropdown.selectByVisibleText(productType);
    }
    @When("user enters quantity {int}")
    public void user_enters_quantity(Integer quantity) { // 2
        BrowserUtils.waitForClickable(smartBearOrderPage.quantity,DocuportConstants.large).clear();
        smartBearOrderPage.quantity.click();
        smartBearOrderPage.quantity.sendKeys(quantity.toString() + Keys.ENTER);
    }
    @When("user enters customer name {string}")
    public void user_enters_customer_name(String name) { //Chuck Norris

        smartBearOrderPage.customerName.sendKeys(name);
    }
    @When("user enters street {string}")
    public void user_enters_street(String street) { // 1100 Long way dr
        smartBearOrderPage.street.sendKeys(street);

    }
    @When("user enters city {string}")
    public void user_enters_city(String city) { //Chantilly
        smartBearOrderPage.city.sendKeys(city);
    }
    @When("user enters state {string}")
    public void user_enters_state(String state) { //Virginia
        smartBearOrderPage.state.sendKeys(state);
    }
    @When("user enters zip {string}")
    public void user_enters_zip(String zip) { //22011
        smartBearOrderPage.zipCode.sendKeys(zip);
    }
    @When("user selects credit card type {string}")
    public void user_selects_credit_card_type(String string) { // American Express
        BrowserUtils.waitForClickable(smartBearOrderPage.americanExpressButton,DocuportConstants.large).click();
    }
    @When("user enters credit card number {string}")
    public void user_enters_credit_card_number(String cardNum) { // 1111222233334444
        smartBearOrderPage.cardNumber.sendKeys(cardNum);
    }
    @When("user enters expiration date {string}")
    public void user_enters_expiration_date(String expiration) { // 12/25
        smartBearOrderPage.expirationDate.sendKeys(expiration);
    }
    @When("user clicks process order button and verifies success message")
    public void user_enters_process_order_button() {
        BrowserUtils.waitForClickable(smartBearOrderPage.processButton,DocuportConstants.large).click();
      //  BrowserUtils.takeScreenshot();
        assertEquals("The new order was NOT added", smartBearOrderPage.successMessage.getText(),ConfigurationReader.getProperty("smart.success"));

    }
    @Then("user should see {string} in the first row of the table")
    public void user_should_see_in_the_first_row_of_the_table(String name) { // Chuck Norris

        BrowserUtils.waitForClickable(smartBearOrderPage.viewAllOrders,DocuportConstants.large).click();
       // BrowserUtils.takeScreenshot();
        assertEquals("The actual name" + smartBearViewAllOrdersPage.firstRowName.getText() + "does NOT match the expected name: " + name, smartBearViewAllOrdersPage.firstRowName.getText(),name);

    }


}
