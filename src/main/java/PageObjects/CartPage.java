package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    // Locators list
    private static final By productsInCartLocator = By.cssSelector("h2[class=\"product-name\"]");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkIfProductWasAddedToCartProperly(String productName) {
        // Get list of items in cart
        List<WebElement> temporaryProductsList = driver.findElements(productsInCartLocator);
        List<String> finalProductsList = new ArrayList<>();
        for(WebElement product : temporaryProductsList){
            String name = product.getText();
            // Save products names in 'finalProductsList' list
            finalProductsList.add(name);
        }
        // Return true if 'finaProductsList' list contains given in method product name
        return finalProductsList.contains(productName);
    }
}
