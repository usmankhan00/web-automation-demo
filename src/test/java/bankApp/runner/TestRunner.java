package bankApp.runner;

import bankApp.stepDefinition.Hook;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.IOException;

/**
 * This is runner file where we can run the project.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features/",
        glue = "bankApp/stepDefinition",
        plugin = { "pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        tags = "@Smoke"
)

public class TestRunner {

    @BeforeClass
    public static void beforeClass() throws IOException {

        new Hook().setup();
    }

    @AfterClass
    public static void afterClass() throws IOException {

        new Hook().quitDriver();
    }

}
