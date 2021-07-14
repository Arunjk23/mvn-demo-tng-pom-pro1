package org.training.examples.automation.tests.home;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.training.examples.automation.base.TestBase;
import org.training.examples.automation.pages.HomePage;
import org.training.examples.automation.pages.LoginPage;

public class HomeHeaderUITest extends TestBase {

    public LoginPage loginPage;
    public HomePage homePage;

    @BeforeMethod
    public void initTest() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Test
    public void homepageHeaderUITest() throws Exception {

        try {

            //Perform Login
            loginPage.login();
            //Validate Marketplace button in the Home page Header UI
            Assert.assertTrue(homePage.verifyHomeHeaderUIElement("MarketPlace"),"MarketPlace button is not displayed");
            Reporter.log("MarketPlace button is displayed in the HomePage Header");
            //Validate HelpIcon in the Home page Header UI
            Assert.assertTrue(homePage.verifyHomeHeaderUIElement("HelpIcon"),"HelpIcon Image is not displayed");
            Reporter.log("HelpIcon Image is displayed in the HomePage Header");
            //Validate BellIcon in the Home Page Header UI
            Assert.assertTrue(homePage.verifyHomeHeaderUIElement("BellIcon"),"BellIcon Image is not displayed");
            Reporter.log("BellIcon Image is displayed in the HomePage Header");

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }



}
