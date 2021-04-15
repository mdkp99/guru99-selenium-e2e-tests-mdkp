package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


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

    public void logOut() {
        wait.until(ExpectedConditions.elementToBeClickable(accountButtonLocator)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(logOutLocator)).click();
    }

    public LoginPage goToLoginPage() {
        wait.until(ExpectedConditions.elementToBeClickable(accountButtonLocator)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButtonLocator)).click();
        return new LoginPage(driver);
    }

    public ProductsListPage goToMobileCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(mobileCategoryLocator)).click();
        return new ProductsListPage(driver);
    }

    public ProductsListPage goToTvCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(tvCategoryLocator))).click();
        return new ProductsListPage(driver);
    }
}
