import PageObjects.ProductsDetailPage;
import PageObjects.ProductsListPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductsListTest extends BaseTest {

    // Test Data

    // Add to compare xPath's for testing products
    String xPathForFirstProduct = "//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/ul/li[2]/a";
    String xPathForSecondProduct = "//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/ul/li[2]/a";

    // Prices
    String SonyXPeriaPriceXPath = "//*[@id=\"top\"]/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/h2/a";
    String SonyXPeriaDetailPageXPath = "//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/h2/a";

    @Test //TC1
    public void itemsCanBeSortedByNameInProductsListPageTest() {
        ProductsListPage productsListPage = new ProductsListPage(driver);
        boolean areSortedProperly = productsListPage.header.goToMobileCategory().checkIfProductsAreSortedProperly("asc", "Name");
        Assertions.assertTrue(areSortedProperly, "Products are not sorted properly.");
    }

    @Test //TC2
    public void itemsCanBeSortedByPriceInProductsListPageTest() {
        ProductsListPage productsListPage = new ProductsListPage(driver);
        boolean areSortedProperly = productsListPage.header.goToMobileCategory().checkIfProductsAreSortedProperly("asc", "Price");
        Assertions.assertTrue(areSortedProperly, "Products are not sorted properly.");
    }

    @Test //TC3
    public void itemsCanBeAddToComparisonListInProductListPageTest() {
        int expectedNumbersOfProductsInComparisonList = 2;

        ProductsListPage productsListPage = new ProductsListPage(driver);
        int actualNumbersOfProductInComparisonList = productsListPage.header.goToMobileCategory().addProductsForComparison(xPathForFirstProduct, xPathForSecondProduct).checkNumbersOfProductsInComparisonList();
        Assertions.assertEquals(expectedNumbersOfProductsInComparisonList, actualNumbersOfProductInComparisonList, "Expected numbers of items in comparison list are invalid.");
    }

    @Test //TC3
    public void checkIfPricesAreEqualInProductListPageAndProductPage() {
        ProductsListPage productsListPage = new ProductsListPage(driver);
        ProductsDetailPage productsDetailPage = new ProductsDetailPage(driver);

        String productsListPagePrice = productsListPage.header.goToMobileCategory().getProductPrice(SonyXPeriaPriceXPath);
        productsListPage.goToProductDetailPage(SonyXPeriaDetailPageXPath);

        String productDetailPagePrice = productsDetailPage.getProductPrice();

        Assertions.assertEquals(productDetailPagePrice, productsListPagePrice,"Expected prices are invalid.");
    }
}



