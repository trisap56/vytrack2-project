package com.vytrack.library.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    /* Creating the private constructor so this class's object is not reachable from outside. */
    private Driver() {
    }

    /*   Making our driver instance private so that it is not reachable from outside of the class
       Also we are making it static so that we can use it in a static method.
       We want it to run before everything else */
    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    /*   Creating reusable utility method that will return same driver instance every time we call it. */
//    public static synchronized WebDriver getDriver(){   <--- first option

    public static WebDriver getDriver() {
        if (driverPool.get() == null) {

            synchronized (Driver.class) {

                String browserType = ConfigurationReader.getProperty("browser");

//            depending on browser type we return the right browser...
                switch (browserType) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driverPool.set(new ChromeDriver());
                        driverPool.get().manage().window().maximize();
                        driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                        driverPool.get().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driverPool.set(new FirefoxDriver());
                        driverPool.get().manage().window().maximize();
                        driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                        driverPool.get().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
                        break;
                    case "":
                }
            }
        }
        return driverPool.get();
    }

    /*
     This method makes sure we have some form of driver sesion or driver id has.
     Either null or not null it must exist.
      */
    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}
