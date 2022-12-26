package co.com.sofka.common;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class PageActions {

    private static final Logger LOGGER = Logger.getLogger(PageActions.class);

    protected WebDriver driver;

    public PageActions(WebDriver driver, int seconds) {
        try{
            if(driver == null) LOGGER.error("NO HAY WEBDRIVER");

            this.driver = driver;
            webDriverImplicitWait(driver,seconds);

        }catch (Exception e){
            LOGGER.error(e.getMessage(),e);
        }
    }

    //Init POM with Page Factory
    protected void pageFactoryInitElement(WebDriver driver, Object page) {
        PageFactory.initElements(driver, page);
    }

    //Implicit wait.
    private void webDriverImplicitWait(WebDriver driver, int seconds){
        try{
            driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
        } catch (Exception e){
            LOGGER.error(e.getMessage(), e);
        }
    }

    //Click on Element
    public void clickOnElement(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
        }
    }

    //type on text field
    protected void typeOnTextField(WebElement element, String value) {
        try {
            element.clear();
            element.sendKeys(value);
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
        }
    }

    //Scroll On Element
    protected void scrollOn(WebElement element) {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
        }
    }

    //Get text from element
    protected String getTextFromElement(WebElement element) {
        try {
            return element.getText();
        } catch (Exception e) {
            LOGGER.warn(e.getMessage(), e);
            driver.quit();
            return "";
        }
    }
}
