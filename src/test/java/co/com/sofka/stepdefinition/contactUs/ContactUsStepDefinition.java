package co.com.sofka.stepdefinition.contactUs;

import co.com.sofka.pages.contactusPage.ContactUsPage;
import co.com.sofka.pages.landingpage.LandingPage;
import co.com.sofka.runner.contactUs.ContactUsCucumberTest;
import co.com.sofka.setup.SetupWebUI;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class ContactUsStepDefinition extends SetupWebUI {

    private static final Logger LOGGER = Logger.getLogger(ContactUsCucumberTest.class);

    @Dado("que el cliente entra a la pagina de contactUs")
    public void queElClienteEntraALaPaginaDeContactUs() {
        try {
            setUpLog4j();
            setUpWebDriver();
            generalSetUp();
            LandingPage landingPage = new LandingPage(driver,3);
            landingPage.clickOnContactUs();
        }catch (Exception e){
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(),e);
            quiteDriver();
        }
    }
    @Cuando("diligencia correctamente todos los campos")
    public void diligenciaCorrectamenteTodosLosCampos() {
        try{
            ContactUsPage contactUsPage = new ContactUsPage(driver, 3);
            contactUsPage.fillAllContactFields();
        }catch (Exception e){
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(),e);
            quiteDriver();
        }
    }
    @Entonces("se muestra un mensaje diciendo que la consulta ha sido enviada")
    public void seMuestraUnMensajeDiciendoQueLaConsultaHaSidoEnviada() {
        try {
            ContactUsPage contactUsPage = new ContactUsPage(driver, 3);
            Assertions.assertEquals("Your enquiry has been successfully sent to the store owner.",contactUsPage.getSuccessMessageText());
            quiteDriver();
        }catch (Exception e){
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(),e);
            quiteDriver();
        }
    }
}




