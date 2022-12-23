package co.com.sofka.setup;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class SetupWebUI {
    private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";

    private static final String WEBDRIVER_CHROME_DRIVER_PATH = "src/test/resources/webdrivers/chromedriver.exe";

    private static final String DEMO_QA_URL = "https://demowebshop.tricentis.com/";

    protected WebDriver driver;

    protected void setUpWebDriver() {
        System.setProperty(WEBDRIVER_CHROME_DRIVER,WEBDRIVER_CHROME_DRIVER_PATH);
    }

    protected void generalSetUp(){
        driver = new ChromeDriver();
        driver.get(DEMO_QA_URL);
        driver.manage().window().maximize();
    }

    protected void setUpLog4j(){
        PropertyConfigurator.configure(SetupWebUI.class.getClassLoader().getResource("log4j.properties"));
    }

    protected void quiteDriver(){
        driver.quit();
    }
}
