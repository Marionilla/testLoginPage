package step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class LoginPage {
    private WebDriver driver;
    private String url = "https://www.saucedemo.com/";
    @FindBy(id = "user-name")
    private  WebElement usernameInput;
    @FindBy(id = "password")
    private  WebElement passwordInput;
    @FindBy(id = "login-button")
    private  WebElement loginButton;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void enterUserName(String username) {
        usernameInput.sendKeys(username);
    }
    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }
    public void clickLoginButton() {
        loginButton.click();
    }
    public void openLoginPage() {
        driver.get(url);
    }
}
