package com.vytrack.library.step_definitions;

import com.vytrack.library.pages.ApplePage;
import com.vytrack.library.utilities.BrowserUtils;
import com.vytrack.library.utilities.ConfigurationReader;
import com.vytrack.library.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Apple_step_definitions {
    ApplePage applePage = new ApplePage();
    WebDriver driver = Driver.getDriver();

    @Given("I am on apple url")
    public void i_am_on_apple_url() {
        driver.get(ConfigurationReader.getProperty("url3"));
    }

//    @When("I Click to all of the headers one by one")
//    public void i_click_to_all_of_the_headers_one_by_one() {
//        System.out.println("amount of links = " + applePage.linkList.size());
//        applePage.iphoneHeader.click();
//        System.out.println("Title = " + driver.getTitle());
//        applePage.macHeader.click();
//        System.out.println("Title = " + driver.getTitle());
//        applePage.musicHeader.click();
//        System.out.println("Title = " + driver.getTitle());
//        applePage.ipadHeader.click();
//        System.out.println("Title = " + driver.getTitle());
//        applePage.supportHeader.click();
//        System.out.println("Title = " + driver.getTitle());
//        applePage.tvHeader.click();
//        System.out.println("Title = " + driver.getTitle());
//        applePage.watchHeader.click();
//        System.out.println("Title = " + driver.getTitle());
//    }

    @When("I Click to all of the headers one by one")
    public void i_click_to_all_of_the_one_by_one() throws IOException {
        BrowserUtils.waitForClickability(applePage.iphoneHeader,10);
        applePage.iphoneHeader.click();
    }
    @Then("Print out total number of links in each page")
    public void print_out_total_number_of_links_in_each_page() {
        System.out.println("amount of links = " + applePage.linkList.size());
    }
    @When("While on each page I Print out how many link is missing textTOTAL")
    public void i_print_out_how_many_link_is_missing_text_total() {
        List<WebElement> empty = new ArrayList<>();
        for(int i = 0; i < applePage.linkList.size(); i++) {
            if (applePage.linkList.get(i).getText().equals(null) ||applePage.linkList.get(i).getText().equals("")){
                empty.add(applePage.linkList.get(i));
            }
            System.out.println("links missing text = " + empty.size());
        }
    }
    @Then("I Print out how many link has textTOTAL")
    public void i_print_out_how_many_link_has_text_total() {
        List<WebElement> empty = new ArrayList<>();
        for(int i = 0; i < applePage.linkList.size(); i++) {
            if (!applePage.linkList.get(i).getText().equals(null) ||!applePage.linkList.get(i).getText().equals("")){
                empty.add(applePage.linkList.get(i));
            }
            System.out.println("links with text = " + empty.size());
        }
    }



}
