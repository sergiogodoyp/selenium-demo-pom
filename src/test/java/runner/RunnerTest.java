package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "html:target/build/cucumber-html-report", "pretty:target/build/cucumber-pretty.txt"
        , "json:target/build/cucumber.json", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm" },
        features = {"src/test/resources/feature/"},
        stepNotifications = true,
        publish = true,
        glue = {"baufest.com.stepdefinition"},
        tags = "@Prueba"

)
public class RunnerTest {
}
