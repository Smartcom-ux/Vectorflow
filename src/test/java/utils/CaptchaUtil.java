package utils;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CaptchaUtil {

    public static String readCaptcha(WebDriver driver, WebElement captchaElement) {
        String result = "";
        try {
            // Take screenshot of captcha element
            File src = captchaElement.getScreenshotAs(OutputType.FILE);
            String imgPath = System.getProperty("user.dir") + File.separator + "captcha.png";
            Files.copy(src.toPath(), Paths.get(imgPath), StandardCopyOption.REPLACE_EXISTING);

            // OCR using Tess4J
            ITesseract tesseract = new Tesseract();
            tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata"); // Update if needed
            tesseract.setLanguage("eng");
            tesseract.setTessVariable("tessedit_char_whitelist",
                    "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz");

            result = tesseract.doOCR(new File(imgPath));

            // Clean up result
            result = result.replaceAll("\\s+", "");
            System.out.println("Detected Captcha: " + result);

        } catch (TesseractException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
