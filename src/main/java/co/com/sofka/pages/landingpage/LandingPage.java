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
    @FindBy(xpath = "/html/body/div[4]/div[2]/div[1]/div[1]/ul/li[6]/a")
    private WebElement contactUsLink;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")
    private WebElement registerLink;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
    private WebElement loginLink;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
    private WebElement logoutLink;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")
    private WebElement emailUser;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[1]/div/span")
    private WebElement errorMessage;

    public void clickOnContactUs(){
        clickOnElement(contactUsLink);
    }

    public void clickOnRegister(){
        clickOnElement(registerLink);
    }

    public void clickOnLogin() {clickOnElement(loginLink);}

    public String logOutOptionIsPresent(){
        return getTextFromElement(logoutLink);
    }
    public String registerOptionIsNotPresent(){
        return getTextFromElement(emailUser);
    }

    public String loginUnsuccessful(){
        return getTextFromElement(errorMessage);
    }
}
