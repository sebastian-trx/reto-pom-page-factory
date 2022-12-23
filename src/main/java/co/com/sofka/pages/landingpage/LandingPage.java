package co.com.sofka.pages.landingpage;

import co.com.sofka.common.PageActions;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends PageActions {
    private static final Logger LOGGER = Logger.getLogger(LandingPage.class);

    public LandingPage(WebDriver driver, int seconds) {
        super(driver, seconds);
        pageFactoryInitElement(driver,this);
    }

    @CacheLookup
    @FindBy(name = "username")
    private WebElement name;

    /*@CacheLookup
    @FindBy(name = "password")
    private WebElement password;*/

    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div[2]/div[1]/div[1]/ul/li[6]/a")
    private WebElement contactUsLink;

    public void clickOnContactUs(){
        clickOnElement(contactUsLink);
    }
}
