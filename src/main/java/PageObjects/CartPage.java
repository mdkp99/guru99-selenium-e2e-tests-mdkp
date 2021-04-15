package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {

    public static final By successMessageLocator = By.cssSelector("li[class=\"selectorgadget_selected\"]");

    public CartPage(WebDriver driver) {
        super(driver);
        WebDriverWait wait = new WebDriverWait(driver, 10);
    }

    public boolean checkIfProductWasAddedToCartProperly(String productName) {
        String expectedMessageText = productName + " was added to your shopping cart.";
        String actualMessageText = driver.findElement(successMessageLocator).getText();
        return expectedMessageText.equals(actualMessageText);
    }
}
