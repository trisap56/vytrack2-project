package com.vytrack.library.step_definitions;

import com.vytrack.library.pages.DropdownPage;
import com.vytrack.library.utilities.BrowserUtils;
import com.vytrack.library.utilities.ConfigurationReader;
import com.vytrack.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class Dropdown_step_definitions {
    DropdownPage dropdownPage = new DropdownPage();

    @Given("I am on correct url")
    public void i_am_on_http_practice_cybertekschool_com_dropdown() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url2"));
    }
    @Then("verify that “Simple dropdown” default selected value is as expected: “Please select an option”")
    public void verify_that_simple_dropdown_default_selected_value_is_as_expected_please_select_an_option() throws IOException {
        BrowserUtils.waitForVisibility(dropdownPage.simpleDropdown,10);
        Select select = new Select(dropdownPage.simpleDropdown);
        String actualValue = select.getFirstSelectedOption().getText();
        String expectedValue = "Please select an option";
        Assert.assertEquals(expectedValue,actualValue);
    }
    @Then("verify that “State selection” default selected value is as expected: “Select a State”")
    public void verify_that_state_selection_default_selected_value_is_as_expected_select_a_state() throws IOException {
        Select select = new Select(dropdownPage.stateDropdown);
        String actualValue = select.getFirstSelectedOption().getText();
        String expectedValue = "Select a State";
        BrowserUtils.waitForVisibility(dropdownPage.stateDropdown,10);
        Assert.assertEquals(actualValue,expectedValue);
    }

}
