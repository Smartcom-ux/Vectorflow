package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

    // Method to capture screenshot
    public static String captureScreenshot(WebDriver driver, String screenshotName) {
        // timestamp for unique screenshot name
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filePath = System.getProperty("user.dir") + "/test-output/screenshots/" 
                          + screenshotName + "_" + timestamp + ".png";

        try {
            // Take screenshot
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File dest = new File(filePath);
            FileUtils.copyFile(src, dest);
            System.out.println("📸 Screenshot captured: " + filePath);
        } catch (IOException e) {
            System.out.println("❌ Failed to capture screenshot: " + e.getMessage());
        }
        return filePath;
    }
}
