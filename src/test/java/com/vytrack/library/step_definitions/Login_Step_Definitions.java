package com.vytrack.library.step_definitions;

import com.vytrack.library.pages.LoginPage;
import com.vytrack.library.utilities.BrowserUtils;
import com.vytrack.library.utilities.ConfigurationReader;
import com.vytrack.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.io.IOException;

public class Login_Step_Definitions {
    LoginPage loginPage = new LoginPage();


    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }
    @When("i enter valid {string} and {string}")
    public void i_enter_valid_and(String username, String password) {
        loginPage.usernameBox.sendKeys(username);
        loginPage.passwordBox.sendKeys(password + Keys.ENTER);
    }
    @Then("i sign in successfully and see dashboard logo")
    public void i_sign_in_successfully_and_see_dashboard_logo() throws IOException {
        BrowserUtils.waitForVisibility(loginPage.homeHeader,10);
       Assert.assertTrue(loginPage.homeHeader.isDisplayed());
    }
}
