package com.vytrack.library.pages;

import com.vytrack.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.jvm.hotspot.debugger.Page;

public class AutomationPracticePage extends BasePage{

    public AutomationPracticePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@title='Log in to your customer account']")
    public WebElement signIn;

    @FindBy(xpath = "//input[@name='email_create']")
    public WebElement emailBox;

    @FindBy(id = "SubmitCreate")
    public WebElement createAccButton;

    @FindBy(xpath = "//input[@id='id_gender1']")
    public WebElement MrOrMsBox;

    @FindBy(xpath = "//input[@id='customer_firstname']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@id='customer_lastname']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement EmailName;

    @FindBy(xpath = "//input[@id='passwd']")
    public WebElement password;

    @FindBy(xpath = "//select[@id='days']")
    public WebElement daysDropDown;

    @FindBy(xpath = "//select[@id='months']")
    public WebElement monthDropDown;

    @FindBy(xpath = "//select[@id='years']")
    public WebElement yearDropDown;

    @FindBy(xpath = "//input[@id='firstname']")
    public WebElement firstNameAddress;

    @FindBy(xpath = "//input[@id='lastname']")
    public WebElement lastNameAddress;

    @FindBy(xpath = "//input[@id='company']")
    public WebElement company;

    @FindBy(xpath = "//input[@id='address1']")
    public WebElement HomeAddress;

    @FindBy(xpath = "//input[@id='city']")
    public WebElement city;

    @FindBy(xpath = "//input[@id='postcode']")
    public WebElement zipCode;

    @FindBy(id = "id_state")
    public WebElement stateSelect;

    @FindBy(xpath = "//select[@id='id_country']")
    public WebElement countrySelect;

    @FindBy(xpath = "//input[@id='phone_mobile']")
    public WebElement phoneNumber;

    @FindBy(xpath = "//input[@id='alias']")
    public WebElement alias;

    @FindBy(xpath = "//button[@id='submitAccount']")
    public WebElement submitAccount;

    @FindBy(xpath = "//p[@class='info-account']")
    public WebElement accCreatedText;
}
