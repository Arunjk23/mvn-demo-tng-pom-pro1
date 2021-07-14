package org.training.examples.automation.common;

import org.openqa.selenium.WebDriver;

public class AppGeneric {

    public WebDriver driver;

    public AppGeneric(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Description: Validate current page url
     * @param pageName
     * @return
     */

    public boolean validatePageUrl(String pageName) throws Exception{
        boolean retVal = false;
        try {
            if(driver.getCurrentUrl().contains(pageName)) {
                retVal = true;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        return retVal;

    }

}
