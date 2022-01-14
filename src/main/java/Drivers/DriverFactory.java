package Drivers;

import Utilities.PropertyManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * This class is responsible for managing drivers such as chromedriver or geckodriver.
 */

public class
DriverFactory {
    WebDriver driver;

    private final String hubUrl = PropertyManager.getInstance().getHubUrl();

    public WebDriver create(String browserType) throws MalformedURLException {

        return switch (browserType) {
            case "CHROME" -> getChromeDriver();
            case "FIREFOX" -> getFirefoxDriver();
            default -> throw new IllegalArgumentException("Provided browser does not exist");
        };
    }

    private WebDriver getChromeDriver() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        driver = new RemoteWebDriver(new URL(hubUrl), options);
        return driver;
    }

    private WebDriver getFirefoxDriver() throws MalformedURLException {
        FirefoxOptions options = new FirefoxOptions();
        driver = new RemoteWebDriver(new URL(hubUrl), options);
        return driver;
    }
}
