import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

@Epic("Google apps")
@Feature("Play Store")
public class AppiumTest {

    public AndroidDriver<AndroidElement> driver;
    public FluentWait<WebDriver> wait;
    public DesiredCapabilities capabilities;


    @Test(groups = {"smoke","regression"})
    @Story("Fake smoke test")
    public void smokeTest() {
        System.out.println("Hello smoke!");
    }

    @Test(groups = {"regression"})
    @Story("Fake regression test")
    public void regressionTest() {
        System.out.println("Hello regression!");
    }

//    @Test
    public void testName(ITestContext context) throws MalformedURLException, InterruptedException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("BROWSER_NAME", "Android");
        capabilities.setCapability("VERSION", "6.0.1");
        capabilities.setCapability("deviceName", "Samsung 8");
        capabilities.setCapability("udid", "b3c49c51");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.android.vending");
        capabilities.setCapability("appActivity", "com.android.vending.AssetBrowserActivity");
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("newCommandTimeout", 90000);
        capabilities.setCapability("androidInstallTimeout", 90000);
        capabilities.setCapability("automationName", "UiAutomator2");

        this.driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4729/wd/hub"),capabilities);

        this.wait = new WebDriverWait(driver, 300)
                .ignoring(StaleElementReferenceException.class)
                .ignoring(NullPointerException.class)
                .ignoring(ClassCastException.class)
                .ignoring(NoSuchElementException.class);

        context.setAttribute("driver", this.driver);
        context.setAttribute("wait", this.wait);

        StoreStartPage storeStartPage = new StoreStartPage(context);
        storeStartPage.isDisplayed();

        Thread.sleep(1000);

    }

}
