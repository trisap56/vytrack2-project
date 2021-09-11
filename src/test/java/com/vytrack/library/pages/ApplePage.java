package com.vytrack.library.pages;

import com.vytrack.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ApplePage extends BasePage {

    public ApplePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@class='ac-gn-link ac-gn-link-mac']")
    public WebElement macHeader;

    @FindBy(xpath = "//a[@class='ac-gn-link ac-gn-link-ipad']")
    public WebElement ipadHeader;

    @FindBy(xpath = "//a[@class='ac-gn-link ac-gn-link-iphone']")
    public WebElement iphoneHeader;

    @FindBy(xpath = "//a[@class='ac-gn-link ac-gn-link-watch']")
    public WebElement watchHeader;

    @FindBy(xpath = "//a[@class='ac-gn-link ac-gn-link-tv']")
    public WebElement tvHeader;

    @FindBy(xpath = "//a[@class='ac-gn-link ac-gn-link-music']")
    public WebElement musicHeader;

    @FindBy(xpath = "//a[@class='ac-gn-link ac-gn-link-support']")
    public WebElement supportHeader;

    @FindBy(xpath = "//div/a")
    public List<WebElement> linkList;
}
