import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPageTest extends BasePageTest {
    private String login = "hhjkkkll";
    private String login = "hfjf";
public static final By loginInput = By.xpath(".//input[@id='login']");
    public static final By passwordInput = By.xpath(".//input[@id='password']");
    public static final By loginButton = By.xpath(".//input[@id='submit']");
    LoginPageTest(WebDriver driver) {
        super(driver);
    }
}
