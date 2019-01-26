package com.weborders.tests.smoke_tests;

import com.weborders.pages.LoginPage;
import com.weborders.pages.OrderPage;
import com.weborders.pages.ViewAllOrdersPage;
import com.weborders.pages.ViewAllProductsPage;
import com.weborders.utilities.ApplicationConstants;
import com.weborders.utilities.ConfigurationReader;
import com.weborders.utilities.TestBase;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class PageHeadersTests extends TestBase {

    @Test
    public void pageHeadersTest(){
         //create new test/testcase in the report and give name "Page headers test"
        extentLogger= report.createTest("Page headers test");
       // use logger to log the steps
          extentLogger.info("Logging to the application");
        pages.login().login(ConfigurationReader.getProperty("username"),ConfigurationReader.getProperty("password"));

          extentLogger.info("Verifying header for all orders page");
        assertEquals(pages.viewAllOrders().header.getText(), ApplicationConstants.LIST_OF_ALL_ORDERS);
        extentLogger.info("Clicking on all products link");
        pages.viewAllOrders().viewAllProductsLink.click();

        extentLogger.info("Verfying header for all products page");
        assertEquals(pages.viewAllProducts().header.getText(), ApplicationConstants.LIST_OF_ALL_PRODUCTS);

        extentLogger.info("Clicking on order link");
        pages.viewAllProducts().orderLink.click();

         extentLogger.info("Verifying header for order page");
        assertEquals(pages.order().header.getText(), ApplicationConstants.ORDER);

        extentLogger.pass("Page Headers test");

//        LoginPage loginPage = new LoginPage();
//        ViewAllProductsPage viewAllProductsPage = new ViewAllProductsPage();
//        ViewAllOrdersPage viewAllOrdersPage = new ViewAllOrdersPage();
//        OrderPage orderPage = new OrderPage();
//
//        loginPage.login(ConfigurationReader.getProperty("username"),
//                ConfigurationReader.getProperty("password"));
//        assertEquals(viewAllOrdersPage.header.getText(), ApplicationConstants.LIST_OF_ALL_ORDERS);
//        viewAllOrdersPage.viewAllProductsLink.click();
//        assertEquals(viewAllProductsPage.header.getText(), ApplicationConstants.LIST_OF_ALL_PRODUCTS);
//        viewAllProductsPage.orderLink.click();
//        assertEquals(orderPage.header.getText(), ApplicationConstants.ORDER);
//

    }

}
