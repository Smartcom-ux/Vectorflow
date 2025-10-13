package base;

	import java.io.File;
	import java.time.Duration;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

	public class BaseClass {

	    public static WebDriver driver;

	    @BeforeClass
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

	    @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	        	
	        	//System.out.println("⚠️ Skipping driver.quit() for debugging...");
	            driver.quit();
	        }
	    }
	}



