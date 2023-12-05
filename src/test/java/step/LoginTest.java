package step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private String browser;
    private int threadCount;
    @BeforeMethod
    public void setUp() {
        threadCount = Integer.parseInt(ConfigReader.getThreadCount());
        System.out.println(threadCount + "!!!!!!");
        browser = ConfigReader.getBrowser();
        System.out.println(browser);
        driver = WebDriverSingleton.getDriver();
        loginPage = new LoginPage(driver);
        loginPage.openLoginPage();
        // ConfigReader.openLoginPage();
    }
    @Test
    public void successfulLogin() {
        loginPage.enterUserName("error_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }
    @Test
    public void unsuccessfullLoginTest() {
        loginPage.enterUserName("another_user");
        loginPage.enterPassword("another_password");
        loginPage.clickLoginButton();
    }

    @AfterMethod
    public void tearDown() {
        WebDriverSingleton.quitDriver();
    }
}
