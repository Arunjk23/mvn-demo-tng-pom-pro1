package org.training.examples.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage (WebDriver driver) {
        this.driver = driver;
    }

    By btnSubscriber = By.cssSelector("#Subscriber_link");
    By lnkWelcome   = By.cssSelector("#welcome");
    By lnkLogout = By.linkText("Logout");
    By btnMarketPlace = By.cssSelector("#MP_link");
    By imgHelpIcon = By.xpath("//*[@data-icon='question-circle']");
    By imgBellIcon = By.xpath("//*[@data-icon='bell']");


    /**
     * Description: This method is used to validate existence of HomePage Header UI Elements
     * @param elementName
     * @return
     * @throws Exception
     */
    public boolean verifyHomeHeaderUIElement(String elementName) throws Exception {
        boolean retVal = false;
        try {

            switch (elementName.toUpperCase()){
                case "HELPICON":
                    retVal = driver.findElement(imgHelpIcon).isDisplayed();
                    break;
                case "BELLICON":
                    retVal = driver.findElement(imgBellIcon).isDisplayed();
                    break;
                case "MARKETPLACE":
                    retVal = driver.findElement(btnMarketPlace).isDisplayed();
                    break;
                default:
                    break;
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return retVal;
    }



    /**
     * Description: logout of the application
     * @throws Exception
     */
    public void logout () throws  Exception {
        try {
            driver.findElement(lnkWelcome).click();
            driver.findElement(lnkLogout).click();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }



}
