package co.com.sofka.stepdefinition.register;


import co.com.sofka.pages.landingpage.LandingPage;
import co.com.sofka.pages.register.RegisterPage;
import co.com.sofka.runner.register.RegisterCucumberTest;
import co.com.sofka.setup.SetupWebUI;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class RegisterStepDefinition extends SetupWebUI {

    private static final Logger LOGGER = Logger.getLogger(RegisterCucumberTest.class);

    @Dado("que el cliente entra a la pagina de registro")
    public void queElClienteEntraALaPaginaDeRegistro() {
        try {
            setUpLog4j();
            setUpWebDriver();
            generalSetUp();
            LandingPage landingPage = new LandingPage(driver,3);
            landingPage.clickOnRegister();
        }catch (Exception e){
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(),e);
            quiteDriver();
        }
    }

    @Cuando("diligencia correctamente todos los campos")
    public void diligenciaCorrectamenteTodosLosCampos() {
        try{
            RegisterPage registerPage = new RegisterPage(driver, 3);
            registerPage.fillAllRegisterFields();
        }catch (Exception e){
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(),e);
            quiteDriver();
        }
    }

    @Entonces("se muestra el mensaje {string}")
    public void seMuestraElMensaje(String mensaje) {
        try {
            RegisterPage registerPage = new RegisterPage(driver, 3);
            Assertions.assertEquals(mensaje,registerPage.getSuccessMessageText());
            quiteDriver();
        }catch (Exception e){
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(),e);
            quiteDriver();
        }
    }

    @Cuando("llena todos los campos excepto Last name")
    public void llenaTodosLosCamposExceptoLastName() {
        try{
            RegisterPage registerPage = new RegisterPage(driver, 3);
            registerPage.fillAllRegisterFieldsExceptLastName();
        }catch (Exception e){
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(),e);
            quiteDriver();
        }
    }

    @Entonces("se muestra un mensaje junto al campo Last name")
    public void seMuestraUnMensajeJuntoAlCampoLastName() {
        try {
            RegisterPage registerPage = new RegisterPage(driver, 3);
            Assertions.assertEquals("Last name is required.",registerPage.warningMessage());
            quiteDriver();
        }catch (Exception e){
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(),e);
            quiteDriver();
        }
    }
}
