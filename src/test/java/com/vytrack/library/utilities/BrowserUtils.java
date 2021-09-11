package com.vytrack.library.utilities;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

import static org.junit.Assert.assertTrue;

public class BrowserUtils {
    public static void selectOptions(WebElement element, String visibleText){
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }

    public static void sleep(int second) {

        second *= 1000;

        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {

        }
    }


    /*
     * switches to new window by the exact title
     * returns to original window if windows with given title not found
     */
    public static void switchToWindow(String targetTitle) throws IOException {
        String origin = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }

    public static void hover(WebElement element) throws IOException {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    /**
     * return a list of string from a list of web elements
     *
     * @param list
     * @return
     */
    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }

    public static List<String> getElementsText(By locator) throws IOException {

        List<WebElement> elems = Driver.getDriver().findElements(locator);
        List<String> elemTexts = new ArrayList<>();

        for (WebElement el : elems) {
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }

    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) throws IOException {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibility(By locator, int timeout) throws IOException {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickability(WebElement element, int timeout) throws IOException {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForClickability(By locator, int timeout) throws IOException {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeOutInSeconds + " seconds");
        }
    }

    public static WebElement fluentWait(final WebElement webElement, int timeinsec) throws IOException {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(Driver.getDriver())
                .withTimeout(Duration.ofSeconds(timeinsec))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        WebElement element = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return webElement;
            }
        });
        return element;
    }

    /**
     * Verifies whether the element matching the provided locator is displayed on page
     * fails if the element matching the provided locator is not found or not displayed
     *
     * @param by
     */
    public static void verifyElementDisplayed(By by) throws NoSuchElementException, IOException {
        assertTrue("Element not visible: " + by, Driver.getDriver().findElement(by).isDisplayed());
    }

    /**
     * Verifies whether the element is displayed on page
     * fails if the element is not found or not displayed
     *
     * @param element
     */
    public static void verifyElementDisplayed(WebElement element) {
        try {
            assertTrue("Element not visible: " + element, element.isDisplayed());
        } catch (NoSuchElementException e) {
            Assert.fail("Element not found: " + element);

        }
    }


    /**
     * Waits for element to be not stale
     *
     * @param element
     */
    public void waitForStaleElement(WebElement element) {
        int y = 0;
        while (y <= 15) {
            if (y == 1)
                try {
                    element.isDisplayed();
                    break;
                } catch (StaleElementReferenceException st) {
                    y++;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } catch (WebDriverException we) {
                    y++;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }
    }

    /**
     * Selects a random value from a dropdown list and returns the selected Web Element
     *
     * @param select
     * @return
     */
    public WebElement selectRandomTextFromDropdown(Select select) {
        Random random = new Random();
        List<WebElement> weblist = select.getOptions();
        int optionIndex = 1 + random.nextInt(weblist.size() - 1);
        select.selectByIndex(optionIndex);
        return select.getFirstSelectedOption();
    }

    /**
     * Clicks on an element using JavaScript
     *
     * @param element
     */
    public void clickWithJS(WebElement element) throws IOException {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }


    /**
     * Scrolls down to an element using JavaScript
     *
     * @param element
     */
    public void scrollToElement(WebElement element) throws IOException {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Performs double click action on an element
     *
     * @param element
     */
    public void doubleClick(WebElement element) throws IOException {
        new Actions(Driver.getDriver()).doubleClick(element).build().perform();
    }

    /**
     * Changes the HTML attribute of a Web Element to the given value using JavaScript
     *
     * @param element
     * @param attributeName
     * @param attributeValue
     */
    public void setAttribute(WebElement element, String attributeName, String attributeValue) throws IOException {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", element, attributeName, attributeValue);
    }

    /**
     * @param element
     * @param check
     */
    public void selectCheckBox(WebElement element, boolean check) {
        if (check) {
            if (!element.isSelected()) {
                element.click();
            }
        } else {
            if (element.isSelected()) {
                element.click();
            }
        }
    }


    public static int[] stringToIntArray(String date){
        String[] strings = date.split("-");
        int[] intArr = new int[strings.length];

        for (int i = 0; i < strings.length; i++) {
            intArr[i] = Integer.parseInt(strings[i]);
        }
        return intArr;
    }

    public static String generateStringNumber(int digits){
        int result = 0;
        int i = 0;
        Random random = new Random();
        while(i < digits){
            result = result * 10 + random.nextInt(9);
            i++;
        }
        return String.valueOf(result);
    }

    public static String generateDate(){
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        builder.append(20).append(random.nextInt(3)).append(random.nextInt(10)).append('-');
        builder.append(random.nextInt(2));
        if(Character.getNumericValue(builder.charAt(5) ) == 1) builder.append(random.nextInt(3));
        else builder.append(random.nextInt(9));
        builder.append('-');
        int comparison = Character.getNumericValue(builder.charAt(5))*10 + Character.getNumericValue(builder.charAt(6));
        int value = 0;
        switch(comparison) {
            case 1: case 3: case 5:
            case 7: case 8: case 10:
            case 12: value = random.nextInt(31) + 1;
                break;
            case 4: case 6: case 9: case 11:
                value = random.nextInt(29)+1; break;
            case 2: value = random.nextInt(27)+1; break;
        }
        if(value<10) builder.append(0).append(value);
        else builder.append(value);
        return new String(builder);
    }
}
