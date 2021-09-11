package com.vytrack.library.step_definitions;

import com.vytrack.library.pages.GooglePage;
import com.vytrack.library.utilities.BrowserUtils;
import com.vytrack.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class TLGoogle_step_definitions {
    GooglePage google = new GooglePage();

    @Given("I open URL - http:\\/\\/www.google.com")
    public void i_open_url_http_www_google_com() {
        Driver.getDriver().get("www.google.com");
    }

    @When("I Enter keyword {string} in search bar")
    public void i_enter_keyword_in_search_bar(String string) {
        google.searchBox.sendKeys(string);
    }

    @When("Wait for ajax suggestion box to appear")
    public void wait_for_ajax_suggestion_box_to_appear() throws IOException {
        BrowserUtils.waitForVisibility(google.suggestionBoxNames,20);
    }

    @Then("I Get\\/store all the options of suggestion box in a list")
    public void i_get_store_all_the_options_of_suggestion_box_in_a_list() {
        List<WebElement> allOptions = new ArrayList<>();
        allOptions.add(google.suggestionBoxNames);


        for (WebElement list : allOptions) {
            System.out.println(list.getText());
        }
    }



}
