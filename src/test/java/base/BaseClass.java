package base;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

    public static WebDriver driver;

    @BeforeSuite
    public void setUp() {

        String projectPath = System.getProperty("user.dir");

        String driverPath = projectPath + File.separator + "src" + File.separator + "main"
                + File.separator + "java" + File.separator + "driver"
                + File.separator + "chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", driverPath);

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://lab1.vectorflow.app/login");

        System.out.println("✅ Browser launched successfully");
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            System.out.println("❌ Closing browser...");
            driver.quit();
        }
    }
}
