package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;

import pages.LoginPage;
import utils.ScreenshotUtil;
public class TC_001loginTest extends BaseClass{
	private static final Logger logger = LogManager.getLogger(TC_001loginTest.class);
	@Test(dataProvider = "loginData", dataProviderClass = utils.DataProviders.class)
	public void login(String username, String password, String expectedResult) throws Exception {
	    LoginPage lp = new LoginPage(driver);
	    lp.login(username, password, expectedResult);

	    if (expectedResult.equalsIgnoreCase("Success")) {
	        System.out.println(" Login successful with " + username);
	        System.out.println(" Login Test Completed");
	       
	    } else {
	        System.out.println(" Login failed with " + username);
	    }
	    ScreenshotUtil.captureScreenshot(driver, "loginTest_Failed");
       
	}
}