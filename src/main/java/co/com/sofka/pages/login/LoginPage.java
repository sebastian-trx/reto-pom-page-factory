package co.com.sofka.pages.login;

import co.com.sofka.common.PageActions;
import co.com.sofka.util.EmailGeneration;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageActions {

    private static Logger LOGGER =Logger.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver, int seconds) {
        super(driver, seconds);
        pageFactoryInitElement(driver,this);
    }

    @CacheLookup
    @FindBy(id = "Email")
    private WebElement email;

    @CacheLookup
    @FindBy(id = "Password")
    private WebElement password;

    @CacheLookup
    @FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")
    private WebElement login;


    public void fillAllLoginFields(){
        try{
            scrollOn(email);
            typeOnTextField(email, EmailGeneration.getEmail());
            scrollOn(password);
            typeOnTextField(password,"password4");
            scrollOn(login);
            clickOnElement(login);
        }catch (Exception e){
            LOGGER.error("Error al llenar los campos de log in");
        }


    }
    public void fillAllLoginFieldsWithWrongData(){
        try{
            scrollOn(email);
            typeOnTextField(email, "wrongEmail@asd.com");
            scrollOn(password);
            typeOnTextField(password,"wrongPassword");
            scrollOn(login);
            clickOnElement(login);
        }catch (Exception e){
            LOGGER.error("Error al llenar los campos de log in con data erronea");
        }

    }

}
