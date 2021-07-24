import Drivers.DriverFactory;
import Utilities.PropertyManager;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    protected RemoteWebDriver driver;

    public static final String baseURL = "http://live.demoguru99.com/";

    private final String browserType = PropertyManager.getInstance().getBrowserType();


    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DriverFactory driverFactory = new DriverFactory();
        driver = (RemoteWebDriver) driverFactory.create(browserType);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(baseURL);
    }

    @AfterMethod
    public void tearDownDriver() {
        driver.quit();
    }

    public BaseTest scrollPage(int pixels) {
        return this;
    }
}
