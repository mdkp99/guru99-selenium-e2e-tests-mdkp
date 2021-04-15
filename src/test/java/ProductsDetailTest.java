import PageObjects.ProductsDetailPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductsDetailTest extends BaseTest {

    // Test Data
    private static final String productDetailURL = "http://live.demoguru99.com/index.php/mobile/iphone.html";


    @Test //TC1
    public void itemCanBeAddedToCartFromProductDetailPageTest() {
        ProductsDetailPage productsDetailPage = new ProductsDetailPage(driver);
        String expectedURL = "http://live.demoguru99.com/index.php/checkout/cart/";

        driver.get(productDetailURL);
        String productName = productsDetailPage.getProductName();

        boolean productAddedProperly = productsDetailPage.addProductToCart("2").checkIfProductWasAddedToCartProperly(productName);
        Assertions.assertTrue(productAddedProperly, "Product was not added properly to card.");
    }

    @Test //TC2
    public void userCanAddNewReviewForProductTest() {
        ProductsDetailPage productsDetailPage = new ProductsDetailPage(driver);

        driver.get(productDetailURL);
        productsDetailPage.addProductReview(5,"Test","Test","TestUser");

    }

}
