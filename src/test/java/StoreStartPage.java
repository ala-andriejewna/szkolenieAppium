import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.ITestContext;

public class StoreStartPage {

    public AndroidDriver<AndroidElement> driver;
    public FluentWait<WebDriver> wait;

    //@AndroidFindBy(xpath = "//*[contains(@resource-id, 'li_title')][@text='STRONA GŁÓWNA']")
    //private MobileElement mainPageButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id, 'title')][@text='GRY']")
    private MobileElement gamesButton;
//
//    @AndroidFindBy(xpath = "//android.widget.TextView[@text='FILMY']")
//    private MobileElement moviesButton;
//
//    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Nowe i zaktualizowane gry']")
//    private MobileElement newAndUpdatedGames;
//
//    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Polecane dla Ciebie']")
//    private MobileElement recommendedForYouLabel;




    public StoreStartPage(ITestContext context) {
        this.driver = (AndroidDriver<AndroidElement>)context.getAttribute("driver");
        this.wait = (FluentWait<WebDriver>)context.getAttribute("wait");
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isDisplayed() {
//        wait.until(ExpectedConditions.visibilityOf(mainPageButton));
        wait.until(ExpectedConditions.visibilityOf(gamesButton));
//        wait.until(ExpectedConditions.visibilityOf(moviesButton));
//        wait.until(ExpectedConditions.visibilityOf(newAndUpdatedGames));
//        wait.until(ExpectedConditions.visibilityOf(recommendedForYouLabel));
        return true;
    }
}
