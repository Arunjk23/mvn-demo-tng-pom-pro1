package org.training.examples.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.training.examples.automation.constants.GlobalConstants;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;
    GlobalConstants globalConstants;

    @BeforeMethod
    @Parameters({"browser"})
    public void initSetup(String targetBrowser) throws Exception {
        System.out.println("target Browser: "+targetBrowser);
        globalConstants = new GlobalConstants();
        if (targetBrowser.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", globalConstants.chromeDriverPath);
            driver = new ChromeDriver();
        } else if(targetBrowser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", globalConstants.fireFoxDriverPath);
            driver = new FirefoxDriver();
        }  else if(targetBrowser.equalsIgnoreCase("edge")){
                System.setProperty("webdriver.edge.driver", globalConstants.edgeDriverPath);
                driver = new EdgeDriver();
        }
        driver.get(globalConstants.appURL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }


}
