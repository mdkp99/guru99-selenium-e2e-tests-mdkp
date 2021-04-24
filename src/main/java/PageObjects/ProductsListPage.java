package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductsListPage extends BasePage {
    public HeaderPage header;

    private final By sortTypeLocator = By.cssSelector("select[title=\"Sort By\"]");
    private final By productNameLocator = By.cssSelector("[class=\"product-name\"]");
    private final By productPriceLocator = By.xpath("//*[@id=\"product-price-1\"]/span");
    private final By sortingDirectionLocator = By.cssSelector(".sort-by-switcher");
    private final By numberOfItemsInList = By.cssSelector("small");

    public ProductsListPage(WebDriver driver) {
        super(driver);
        header = new HeaderPage(driver);
    }

    // Method change type of sorting products. sortType: "Name", "Price", "Position"
    public ProductsListPage changeSortType(String sortType) {
        Select sortTypeSelect = new Select(driver.findElement(sortTypeLocator));
        sortTypeSelect.selectByVisibleText(sortType);
        return this;
    }

    // Method change type of sorting direction. direction: "asc", "desc"
    public ProductsListPage changeSortingDirection(String direction) {
        String type = driver.findElement(sortingDirectionLocator).getAttribute("Class");
        if (direction.equals("asc")) {
            if (type.equals("sort-by-switcher sort-by-switcher--desc")) {
                driver.findElement(sortingDirectionLocator).click();
            }
        }

        if (direction.equals("desc")) {
            if (type.equals("sort-by-switcher sort-by-switcher--asc")) {
                driver.findElement(sortingDirectionLocator).click();
            }
        }
        return this;
    }

    // Method return true if products are sorted properly. sortingDirection: "asc", "desc", sortBy: "Name", "Price", "Position"
    public boolean checkIfProductsAreSortedProperly(String sortingDirection, String sortBy) {
        if (sortBy.equals("Name")) {
            changeSortType(sortBy);
            changeSortingDirection(sortingDirection);

            List<WebElement> productsNameList = driver.findElements(productNameLocator);
            List<String> originalNameList = new ArrayList<>();

            for (WebElement productName : productsNameList) {
                // Saving products name in "originalList" list
                originalNameList.add(productName.getText());
            }

            // Copy original list to new temporary list
            List<String> tempNamesList = new ArrayList<>(originalNameList);

            // If products are sorted by asc then equals originalList with tempList and return true if lists are same
            if (sortingDirection.equals("asc")) {
                Collections.sort(tempNamesList);
                if (originalNameList.equals(tempNamesList)) return true;
            }

            // If products are sorted by desc then sort tempList by reverse order and return true if originalList and tempList are same
            if (sortingDirection.equals("desc")) {
                Collections.sort(tempNamesList, Collections.reverseOrder());
                if (originalNameList.equals(tempNamesList)) return true;
            }
        }

        if (sortBy.equals("Price")) {
            changeSortType(sortBy);
            changeSortingDirection(sortingDirection);

            List<WebElement> productsPricesList = driver.findElements(productPriceLocator);
            List<String> originalPricesList = new ArrayList<>();

            // Add products prices to "originalPricesList" if there is no discount price
            for (WebElement productPrice : productsPricesList) {
                // Check if exist any discount prices in products list
                if (!driver.findElement(productPriceLocator).getAttribute("id").contains("old-price")) {
                    originalPricesList.add(productPrice.getText());
                } else {
                    // do nothing

                    // Else add each product price to "originalPricesList" list
                }
            }

            List<String> tempPricesList = new ArrayList<>(originalPricesList);

            // If products are sorted by asc then equals originalList with tempList and return true if lists are same
            if (sortingDirection.equals("asc")) {
                Collections.sort(tempPricesList);
                System.out.println("tempPriceListAfterSort " + tempPricesList);
                if (originalPricesList.equals(tempPricesList)) return true;
            }

            // If products are sorted by desc then sort tempList by reverse order and return true if originalList and tempList are same
            if (sortingDirection.equals("desc")) {
                Collections.sort(tempPricesList, Collections.reverseOrder());
                if (originalPricesList.equals(tempPricesList)) return true;
            }

        }
/*

        if (sortBy.equals("Position")) {
            changeSortType("Position");
        }
*/

        return false;
    }

    // Method add two products with specific xpath to comparison list
    public ProductsListPage addProductsForComparison(String xPathForFirstProduct, String xPathForSecondProduct) {
        driver.findElement(By.xpath(xPathForFirstProduct)).click();
        driver.findElement(By.xpath(xPathForSecondProduct)).click();
        return this;
    }

    // Method return numbers of products in comparison list
    public int checkNumbersOfProductsInComparisonList() {
        String tempNumbersOfItems = driver.findElement(numberOfItemsInList).getText();
        String numbersOfItems = tempNumbersOfItems.replace("(", "").replace(")", "");
        return Integer.parseInt(numbersOfItems);
    }

    // Method return product price of received product id
    public String getProductPrice(int productID) {
        return driver.findElement(By.cssSelector("span[id=\"product-price-"+productID+"\"]")).getText();
    }

    // Method return ProductDetailPage of received product name
    public ProductsDetailPage goToProductDetailPage(String productName) {
        driver.findElements(By.cssSelector("a[title=\""+productName+"\"]"));
        return new ProductsDetailPage(driver);
    }
}
