import PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    // Test Data for Login Page
    private static final String validEmail = "peter.modulesgarden@gmail.com";
    private static final String invalidEmail = "test@noexist.com";
    private static final String validPassword = "1234Test.";
    private static final String invalidPass = "InvalidPassword!";
    private static final String invalidPassLessThanSixChar = "test";


    @Test //TC1
    public void enterIncorrectPasswordTest() {
        String expectedErrorMessage = "Invalid login or password.";

        LoginPage loginPage = new LoginPage(driver);
        String actualErrorMessage = loginPage.header.goToLoginPage().inputLoginData(validEmail, invalidPass).getErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "Expected error message is invalid.");
    }

    @Test //TC2
    public void enterIncorrectEmailAddressTest() {
        String expectedErrorMessage = "Invalid login or password.";

        LoginPage loginPage = new LoginPage(driver);
        String actualErrorMessage = loginPage.header.goToLoginPage().inputLoginData(invalidEmail, validPassword).getErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "Expected error message is invalid.");
    }

    @Test //TC3
    public void enterValidPasswordAndEmailTest() {
        LoginPage loginPage = new LoginPage(driver);
        String actualDashboardMessageText = loginPage.header.goToLoginPage().inputLoginData(validEmail, validPassword).getDashboardMessage();
        Assert.assertTrue(actualDashboardMessageText.contains(validEmail), "Expected dashboard message text is invalid.");
    }

    @Test //TC4
    public void noEnteredLoginDataTest() {
        String expectedValidationMessage = "This is a required field.";

        LoginPage loginPage = new LoginPage(driver);
        String actualValidationMessage = loginPage.header.goToLoginPage().inputLoginData("", "").getValidationAdvice();
        Assert.assertEquals(expectedValidationMessage, actualValidationMessage, "Expected validation message is invalid.");
    }

    @Test //TC5
    public void passwordWithLessThanSixCharactersTest() {
        String expectedValidationMessage = "Please enter 6 or more characters without leading or trailing spaces.";

        LoginPage loginPage = new LoginPage(driver);
        String actualValidationMessage = loginPage.header.goToLoginPage().inputLoginData(validEmail, invalidPassLessThanSixChar).getValidationAdvice();
        Assert.assertEquals(expectedValidationMessage, actualValidationMessage, "Expected validation message is invalid.");
    }
}
