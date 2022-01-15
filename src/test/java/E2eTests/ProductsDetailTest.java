package E2eTests;

import PageObjects.ProductsDetailPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ProductsDetailTest extends BaseTest {

    // Test Data
    private static final String productDetailURL = "http://live.techpanda.org/index.php/mobile/iphone.html";


    /**
     * This method is responsible for following test:
     * Verify that items can be added to card from product detail page.
     */
    @Test //TC1
    public void itemCanBeAddedToCartFromProductDetailPageTest() {
        ProductsDetailPage productsDetailPage = new ProductsDetailPage(driver);

        driver.get(productDetailURL);
        String productName = productsDetailPage.getProductName();

        boolean productAddedProperly = productsDetailPage.addProductToCart("2").checkIfProductWasAddedToCartProperly(productName);
        Assert.assertTrue(productAddedProperly, "Product was not added properly to card.");
    }

    /**
     * This method is responsible for following test:
     * User can add new review for product.
     */
    @Test //TC2
    public void userCanAddNewReviewForProductTest() {
        ProductsDetailPage productsDetailPage = new ProductsDetailPage(driver);

        driver.get(productDetailURL);
        productsDetailPage.addProductReview(5,"Test","Test","TestUser");

    }

}
