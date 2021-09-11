package com.vytrack.library.pages;

import com.vytrack.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='prependedInput']")
    public WebElement usernameBox;

    @FindBy(xpath = "//input[@id='prependedInput2']")
    public WebElement passwordBox;

    @FindBy(xpath = "//h1[@class='oro-subtitle']")
    public WebElement homeHeader;


}
