package co.com.sofka.runner.contactUs;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //snippets = CucumberOptions.SnippetType.CAMELCASE,
        //publish = true,
        features = {"src/test/resources/features/contactUs/contactUs.feature"},
        glue = {"co.com.sofka.stepdefinition.contactUs"}
        //tags = "@regresion",
        //plugin = {"pretty", "html:target/contactUsReporte.html"}

)
public class ContactUsCucumberTest {

}
