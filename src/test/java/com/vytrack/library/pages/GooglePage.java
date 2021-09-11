package com.vytrack.library.pages;

import com.vytrack.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage extends BasePage{
    public GooglePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(name = "q")
    public WebElement searchBox;

    @FindBy(xpath = "//div[@class='wM6W7d']/span")
    public WebElement suggestionBoxNames;

}
