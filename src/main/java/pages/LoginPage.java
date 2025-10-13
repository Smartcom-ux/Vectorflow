package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CaptchaUtil;

public class LoginPage {
    WebDriver driver;

    @FindBy(xpath = "//input[@name='email']")
    WebElement usernameTxt;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordTxt;

    @FindBy(id = "canv")
    WebElement captchaElement;

    @FindBy(xpath = "//input[@placeholder='Enter the text here']")
    WebElement captchaTxt;

    @FindBy(xpath = "//span[contains(.,'Submit')]")
    WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password, String expectedResult) {
        // Always clear before entering
        usernameTxt.clear();
        passwordTxt.clear();
        captchaTxt.clear();

        usernameTxt.sendKeys(username);
        passwordTxt.sendKeys(password);

        // Handle captcha differently for Success
        if (expectedResult.equalsIgnoreCase("Success")) {
            try {
                Thread.sleep(2000); // small wait so captcha stabilizes
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Read captcha
        String captcha = CaptchaUtil.readCaptcha(driver, captchaElement);
        captchaTxt.sendKeys(captcha);

        loginBtn.click();
    }
}

