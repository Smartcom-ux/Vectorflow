package test;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import utils.ScreenshotUtil;

public class TC_001loginTest extends BaseClass {

    @Test(dataProvider = "loginData", dataProviderClass = utils.DataProviders.class)
    public void login(String username, String password, String expectedResult) throws Exception {

        LoginPage lp = new LoginPage(driver);
        lp.login(username, password, expectedResult);

        if (expectedResult.equalsIgnoreCase("Success")) {
            System.out.println("Login Successful: " + username);

        } else {
            System.out.println("Login failed with: " + username);
        }
        ScreenshotUtil.captureScreenshot(driver, "loginTest_Failed");
    }
}

