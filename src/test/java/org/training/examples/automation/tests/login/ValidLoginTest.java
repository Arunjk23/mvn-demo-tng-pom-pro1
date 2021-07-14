package org.training.examples.automation.tests.login;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.training.examples.automation.base.TestBase;
import org.training.examples.automation.common.AppGeneric;
import org.training.examples.automation.pages.HomePage;
import org.training.examples.automation.pages.LoginPage;

public class ValidLoginTest extends TestBase {

    public LoginPage loginPage;
    public AppGeneric appGeneric;
    public HomePage homePage;

    @BeforeMethod
    public void initTest() {
        loginPage = new LoginPage(driver);
        appGeneric = new AppGeneric(driver);
        homePage = new HomePage(driver);
    }

    @Test
    public void validLoginTest() throws Exception {

        try {
            //Perform login
            loginPage.login();
            //Validate Login successful
            Assert.assertTrue(appGeneric.validatePageUrl("dashboard"),"Dashboard is not dispalyed and Login is not successful");
            Reporter.log("Dashboard Page is displayed after successful login");

            //Validate Logout
            homePage.logout();
            Assert.assertTrue(appGeneric.validatePageUrl("login"),"Login page is not displayed and Logout is not successful");
            Reporter.log("Login Page is displayed after successful logout");

        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

}
