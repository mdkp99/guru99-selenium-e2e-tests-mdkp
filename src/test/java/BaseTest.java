import Drivers.DriverFactory;
import Utilities.PropertyManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public abstract class BaseTest {
    protected RemoteWebDriver driver;

    public static final String baseURL = "http://live.demoguru99.com/";

    private final String browserType = PropertyManager.getInstance().getBrowserType();


    @BeforeEach
    public void setUp() throws MalformedURLException {
        DriverFactory driverFactory = new DriverFactory();
        driver = (RemoteWebDriver) driverFactory.create(browserType);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(baseURL);
    }

    @AfterEach
    public void tearDownDriver() {
        driver.quit();
    }

    public BaseTest scrollPage(int pixels) {
        return this;
    }
}
