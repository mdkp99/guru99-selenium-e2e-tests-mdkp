package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class is responsible for containing methods related with Header Page.
 */
public class HeaderPage extends BasePage {
    WebDriverWait wait;

    private final By accountButtonLocator = By.cssSelector("a.skip-link.skip-account");
    private final By loginButtonLocator = By.cssSelector("a[title=\"Log In\"]");
    private final By logOutLocator = By.cssSelector("a[title=\"Log Out\"]");
    private final By mobileCategoryLocator = By.xpath("//*[@id=\"nav\"]/ol/li[1]/a"); // fix this locator
    private final By tvCategoryLocator = By.cssSelector("li[class=\"level0 nav-2 last\"]");

    public HeaderPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 10);
    }

    /**
     * This method is responsible for logging out user.
     */
    public void logOut() {
        wait.until(ExpectedConditions.elementToBeClickable(accountButtonLocator)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(logOutLocator)).click();
    }

    /**
     * This method is responsible for clicking on Login Button to go to Login Page.
     * @return
     */
    public LoginPage goToLoginPage() {
        wait.until(ExpectedConditions.elementToBeClickable(accountButtonLocator)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButtonLocator)).click();
        return new LoginPage(driver);
    }

    /**
     * this method is responsible to clicking on "Mobile" category on navbar.
     * @return
     */
    public ProductsListPage goToMobileCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(mobileCategoryLocator)).click();
        return new ProductsListPage(driver);
    }

    /**
     * This method is responsible for clicking "TV" category on navbar.
     * @return
     */
    public ProductsListPage goToTvCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(tvCategoryLocator))).click();
        return new ProductsListPage(driver);
    }
}
