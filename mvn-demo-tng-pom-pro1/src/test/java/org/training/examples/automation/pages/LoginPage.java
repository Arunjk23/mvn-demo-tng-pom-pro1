package org.training.examples.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.training.examples.automation.constants.GlobalConstants;

public class LoginPage {


    WebDriver driver;
    GlobalConstants globalConstants;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        globalConstants = new GlobalConstants();
    }

    By txtUserName = By.cssSelector("#txtUsername");
    By txtPassword = By.cssSelector("#txtPassword");
    By btnLogin = By.cssSelector("#btnLogin");


    /**
     * Description: Login method to enter credentials
     * @throws Exception
     */
    public void login() throws Exception {
        try {
            driver.findElement(txtUserName).sendKeys(globalConstants.userName);
            driver.findElement(txtPassword).sendKeys(globalConstants.passWord);
            driver.findElement(btnLogin).click();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


}
