package co.com.sofka.stepdefinition.login;

import co.com.sofka.pages.landingpage.LandingPage;
import co.com.sofka.pages.login.LoginPage;
import co.com.sofka.pages.register.RegisterPage;
import co.com.sofka.runner.login.LoginCucumberTest;
import co.com.sofka.setup.SetupWebUI;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class LoginStepDefinition extends SetupWebUI {

    private static final Logger LOGGER = Logger.getLogger(LoginCucumberTest.class);

    @Dado("que el cliente es un usuario registrado")
    public void queElClienteEsUnUsuarioRegistrado() {
        try {
            setUpLog4j();
            setUpWebDriver();
            generalSetUp();
            LandingPage landingPage = new LandingPage(driver,3);
            landingPage.clickOnRegister();
            RegisterPage registerPage = new RegisterPage(driver,3);
            registerPage.fillAllRegisterFields();
            registerPage.clickOnLogout();
        }catch (Exception e){
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(),e);
            quiteDriver();
        }
    }

    @Cuando("el cliente inicia sesion")
    public void elClienteIniciaSesion() {
        try{
            LandingPage landingPage = new LandingPage(driver,3);
            landingPage.clickOnLogin();
            LoginPage loginPage = new LoginPage(driver,3);
            loginPage.fillAllLoginFields();
        }catch (Exception e){
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(),e);
            quiteDriver();
        }
    }

    @Entonces("se muestra la opcion Log out en la LandingPage")
    public void seMuestraUnLaOpcionLogOutEnLaLandingPage() {
        try {
            LandingPage landingPage = new LandingPage(driver,3);
            Assertions.assertEquals("Log out", landingPage.logOutOptionIsPresent());
            Assertions.assertNotEquals("Register", landingPage.registerOptionIsNotPresent());
            quiteDriver();
        }catch (Exception e){
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(),e);
            quiteDriver();
        }
    }

    @Cuando("el cliente intenta iniciar sesion con datos erroneos")
    public void elClienteIntentaIniciarSesionConDatosErroneos() {
        try{
            LandingPage landingPage = new LandingPage(driver,3);
            landingPage.clickOnLogin();
            LoginPage loginPage = new LoginPage(driver,3);
            loginPage.fillAllLoginFieldsWithWrongData();
        }catch (Exception e){
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(),e);
            quiteDriver();
        }
    }

    @Entonces("se muestra un mensaje de error arriba de los campos")
    public void seMuestraUnMensajeDeErrorArribaDeLosCampos() {
        try {
            LandingPage landingPage = new LandingPage(driver,3);
            Assertions.assertEquals("Login was unsuccessful. Please correct the errors and try again.",
                    landingPage.loginUnsuccessful());
            quiteDriver();
        }catch (Exception e){
            Assertions.fail(e.getMessage(), e);
            LOGGER.error(e.getMessage(),e);
            quiteDriver();
        }
    }
}
