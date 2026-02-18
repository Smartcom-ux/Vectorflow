package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.reactivex.rxjava3.functions.Action;
import utils.ActionUtil;

public class OrderRescheduling {
	WebDriver driver;
	ActionUtil actionUtil = new ActionUtil(driver);

    @FindBy(xpath = "//img[@data-tooltip-id='navbar.listMenuParent.prodAndPlanningScheduling.title']\r\n"
    		+ "']")
    WebElement Mainmenu;
    
    @FindBy(xpath = "//div[contains(text(),'Order Rescheduling')]")
    WebElement OrderRescheduling;
    
    @FindBy(xpath = "//button[@id='Unschedule']")
    WebElement Unschedulebtn;
    

    @FindBy(xpath = "//button[@id='Overwrite Due Date']")
    WebElement Overwritebtn;
    
    
    public OrderRescheduling(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    
	public void Mainmenu() {
		   actionUtil.moveToElement(Mainmenu);
	}

	public void OrderRescheduling() {
		OrderRescheduling.click();
		
	}
	public void Unschedule() {
		Unschedulebtn.click();
		
	}
}
