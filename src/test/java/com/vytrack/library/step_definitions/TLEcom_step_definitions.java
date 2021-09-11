package com.vytrack.library.step_definitions;

import com.vytrack.library.pages.AutomationPracticePage;
import com.vytrack.library.utilities.BrowserUtils;
import com.vytrack.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class TLEcom_step_definitions {
    AutomationPracticePage apPage= new AutomationPracticePage();

    @Given("Open this url  http:\\/\\/automationpractice.com\\/index.php")
    public void open_this_url_http_automationpractice_com_index_php() {
        Driver.getDriver().get("http://automationpractice.com/index.php");
    }
    @When("I Click on sign in link.")
    public void i_click_on_sign_in_link() {
        apPage.signIn.click();
    }

    @When("Enter {string} in Create and account section.")
    public void enter_in_create_and_account_section(String string) throws IOException, InterruptedException {
        BrowserUtils.waitForVisibility(apPage.emailBox,20);
        apPage.emailBox.sendKeys(string);
    }

    @Then("Click on Create an Account button.")
    public void click_on_create_an_account_button() {
        apPage.createAccButton.click();
    }
    @Then("Enter your Personal Information, Address and Contact info.")
    public void enter_your_personal_information_address_and_contact_info() throws IOException {
        BrowserUtils.waitForVisibility(apPage.MrOrMsBox,10);
        apPage.MrOrMsBox.click();
        apPage.firstName.sendKeys("gurhan");
        apPage.lastName.sendKeys("wick");
       // apPage.EmailName.sendKeys("gurhanwick@yahoo.com");
        apPage.password.sendKeys("aaple223");
        apPage.city.sendKeys("Ashburn");
        Select select = new Select(apPage.daysDropDown);
        select.selectByIndex(1);
        select = new Select(apPage.monthDropDown);
        select.selectByIndex(1);
        select = new Select(apPage.yearDropDown);
        select.selectByIndex(1);
       // apPage.firstNameAddress.sendKeys("gurhan");
        //apPage.lastNameAddress.sendKeys("wick");
        apPage.company.sendKeys("cybertek");
        apPage.HomeAddress.sendKeys("22345 Krusty Krab");
        select = new Select(apPage.stateSelect);
        select.selectByIndex(1);
        apPage.zipCode.sendKeys("20147");
        select = new Select(apPage.countrySelect);
        select.selectByIndex(1);
        apPage.phoneNumber.sendKeys("2223333443");
        apPage.alias.sendKeys("223345 Krusty Krab");
    }

    @Then("Click on Register button.")
    public void click_on_register_button() {
        apPage.submitAccount.click();
    }
    @Then("Validate that user is created.")
    public void validate_that_user_is_created() throws IOException {
        BrowserUtils.waitForVisibility(apPage.accCreatedText,10);
        Assert.assertEquals(apPage.accCreatedText.getText(),"Welcome to your account. Here you can manage all of your personal information and orders.");
    }

}
