package test;

import org.testng.SkipException;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.LoginPage;
import pages.OrderRescheduling;

public class TC_002OrderreScheduling extends BaseClass {

    @Test
    public void OrderRescheduling() throws Exception {
// Now perform the real functionality
        OrderRescheduling od = new OrderRescheduling(driver);
        od.Mainmenu();
        od.OrderRescheduling();
        od.Unschedule();
    }
}
