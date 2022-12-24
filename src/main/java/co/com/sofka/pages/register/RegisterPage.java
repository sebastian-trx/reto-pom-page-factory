package co.com.sofka.pages.register;

import co.com.sofka.common.PageActions;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends PageActions {

    private static Logger LOGGER = Logger.getLogger(RegisterPage.class);

    public RegisterPage(WebDriver driver, int seconds) {
        super(driver, seconds);
        pageFactoryInitElement(driver,this);
    }

    @CacheLookup
    @FindBy(id = "gender-male")
    private WebElement genderMale;

    @CacheLookup
    @FindBy(id = "gender-female")
    private WebElement genderFemale;

    @CacheLookup
    @FindBy(id = "FirstName")
    private WebElement firstName;

    @CacheLookup
    @FindBy(id = "LastName")
    private WebElement lastName;

    @CacheLookup
    @FindBy(id = "Email")
    private WebElement email;

    @CacheLookup
    @FindBy(id = "Password")
    private WebElement password;

    @CacheLookup
    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPassword;

    @CacheLookup
    @FindBy(id = "register-button")
    private WebElement registerButton;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]")
    private WebElement successMessage;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[2]/div[2]/div[3]/span[2]/span")
    private WebElement warningMessage;

    public void fillAllRegisterFields(){
        try{
            scrollOn(genderMale);
            clickOnElement(genderMale);
            scrollOn(firstName);
            typeOnTextField(firstName, "sebas2");
            scrollOn(lastName);
            typeOnTextField(lastName, "torres2");
            scrollOn(email);
            typeOnTextField(email, "sebas2@yopmail.com");
            scrollOn(password);
            typeOnTextField(password, "password2");
            scrollOn(confirmPassword);
            typeOnTextField(confirmPassword, "password2");
            scrollOn(registerButton);
            clickOnElement(registerButton);
        }catch (Exception e) {
            LOGGER.error("Error al llenar los campos del registro");
        }
    }

    public void fillAllRegisterFieldsExceptLastName(){
        try{
            scrollOn(genderMale);
            clickOnElement(genderMale);
            scrollOn(firstName);
            typeOnTextField(firstName, "sebas3");
            scrollOn(email);
            typeOnTextField(email, "sebas3@yopmail.com");
            scrollOn(password);
            typeOnTextField(password, "password3");
            scrollOn(confirmPassword);
            typeOnTextField(confirmPassword, "password3");
            scrollOn(registerButton);
            clickOnElement(registerButton);
        }catch (Exception e) {
            LOGGER.error("Error al llenar los campos del registro");
        }
    }

    public String getSuccessMessageText(){
        return getTextFromElement(successMessage);
    }

    public String warningMessage(){
        return getTextFromElement(warningMessage);
    }
}
