package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsDetailPage extends BasePage {

    private static final By productPriceLocator = By.cssSelector(".price");
    private static final By quantityLocator = By.cssSelector("#qty");
    private static final By addToCartButtonLocator = By.cssSelector("button[class=\"button\"]");
    private static final By productNameLocator = By.cssSelector("span[class=\"h1 selectorgadget_rejected\"]");
    private static final By addNewReviewLocator = By.xpath("//*[@id=\"product_addtocart_form\"]/div[3]/div[3]/div/p/a[2]");
    private static final By thoughtsTextareaLocator = By.cssSelector("textarea[id=\"review_field\"]");
    private static final By summaryTextareaLocator = By.cssSelector("input[id=\"summary_field\"]");
    private static final By nicknameTextareaLocator = By.cssSelector("input[id=\"nickname_field\"]");
    private static final By submitReviewLocator = By.cssSelector("button[title=\"Submit Review\"]");

    public ProductsDetailPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 10);
    }

    // Method return product price in product detail page
    public String getProductPrice() {
        return driver.findElement(productPriceLocator).getText();
    }

    // Method add product to cart in product detail page
    public CartPage addProductToCart(String quantity) {
        driver.findElement(quantityLocator).sendKeys(quantity);
        driver.findElement(addToCartButtonLocator).click();
        return new CartPage(driver);
    }

    // Method return product name in product detail page
    public String getProductName() {
        return driver.findElement(productNameLocator).getText();
    }

    // Method add new review for product as not logged in user. rate: (1-5)
    public ProductsDetailPage addProductReview(int rate, String thoughts, String summary, String nickname) {
        driver.findElement(addNewReviewLocator).click();
        switch (rate) {
            case 1 -> driver.findElement(By.cssSelector("input[id=\"Quality 1_1\"]")).click();
            case 2 -> driver.findElement(By.cssSelector("input[id=\"Quality 1_2\"]")).click();
            case 3 -> driver.findElement(By.cssSelector("input[id=\"Quality 1_3\"]")).click();
            case 4 -> driver.findElement(By.cssSelector("input[id=\"Quality 1_4\"]")).click();
            case 5 -> driver.findElement(By.cssSelector("input[id=\"Quality 1_5\"]")).click();
        }
        driver.findElement(thoughtsTextareaLocator).sendKeys(thoughts);
        driver.findElement(summaryTextareaLocator).sendKeys(summary);
        driver.findElement(nicknameTextareaLocator).sendKeys(nickname);
        driver.findElement(submitReviewLocator).click();
        return this;
    }

/*
    public boolean checkIfReviewAddedCorrectly() {
        driver.findElement(successAddedReviewTextLocator).getText();
    }
*/

    // Method check if review has been added correctly by wait for "Your review has been accepted for moderation." text

}
