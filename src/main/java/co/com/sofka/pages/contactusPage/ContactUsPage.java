package co.com.sofka.pages.contactusPage;

import co.com.sofka.common.PageActions;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageActions {

    private static Logger LOGGER = Logger.getLogger(ContactUsPage.class);

    public ContactUsPage(WebDriver driver, int seconds) {
        super(driver, seconds);
        pageFactoryInitElement(driver,this);
    }

    @CacheLookup
    @FindBy(id = "FullName")
    private WebElement nameField;

    @CacheLookup
    @FindBy(id = "Email")
    private WebElement emailField;

    @CacheLookup
    @FindBy(id = "Enquiry")
    private WebElement messageField;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div/div[3]/form/div[3]/input")
    private WebElement sendButton;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div/div[3]/div")
    private WebElement successMessage;

    public void fillAllContactFields() {
        try {
            scrollOn(nameField);
            typeOnTextField(nameField, "sebastian");
            scrollOn(emailField);
            typeOnTextField(emailField, "sebastian@yopmail.com");
            scrollOn(messageField);
            typeOnTextField(messageField, "prueba 1");
            clickOnElement(sendButton);
        } catch (Exception e) {
            LOGGER.error("Error al llenar los campos de contacto");
        }
    }

    public String getSuccessMessageText() {
        return getTextFromElement(successMessage);
    }

}
