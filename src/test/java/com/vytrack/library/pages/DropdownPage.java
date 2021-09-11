package com.vytrack.library.pages;

import com.vytrack.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DropdownPage extends BasePage{

    public DropdownPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "dropdown")
    public WebElement simpleDropdown;

    @FindBy(id = "state")
    public WebElement stateDropdown;
}
