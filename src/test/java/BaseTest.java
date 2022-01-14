import Drivers.DriverFactory;
import Utilities.PropertyManager;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

/**
 * Default test class serving for initialization @BeforeMethod and @AfterMethod
 */
public abstract class BaseTest {
    protected RemoteWebDriver driver;

    private static final String baseURL = "http://live.techpanda.org";
    private static final String browserType = PropertyManager.getInstance().getBrowserType();


    /**
     * This method is performed before all tests.
     * @throws MalformedURLException
     */
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DriverFactory driverFactory = new DriverFactory();
        driver = (RemoteWebDriver) driverFactory.create(browserType);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(baseURL);
    }

    /**
     * This method is performed after all tests.
     */
    @AfterMethod
    public void tearDownDriver() {
        driver.quit();
    }

    public BaseTest scrollPage(int pixels) {
        return this;
    }
}
