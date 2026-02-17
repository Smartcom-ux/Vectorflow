
	package utils;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;

	public class ActionUtil {

	   WebDriver driver;
	    Actions actions;

	    public ActionUtil(WebDriver driver) {
	        this.driver = driver;
	        this.actions = new Actions(driver);
	    }

	    public void moveToElement(WebElement element) {
	        actions.moveToElement(element).perform();
	    }

	    public void rightClick(WebElement element) {
	        actions.contextClick(element).perform();
	    }

	    public void doubleClick(WebElement element) {
	        actions.doubleClick(element).perform();
	    }

	    public void dragAndDrop(WebElement src, WebElement dst) {
	        actions.dragAndDrop(src, dst).perform();
	    }
	}


