package bankApp.stepDefinition;

import bankApp.utils.CommonUtils;
import io.cucumber.messages.types.Scenario;
import io.qameta.allure.Allure;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * This class is execute before start of execution of feature file
 * using @before and execute after end of execution of feature file
 */
public class Hook extends CommonUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(Hook.class);

    /**
     * This method is execute before start of execution of feature file.
     * using @BeforeClass.
     */

    public void setup() throws IOException {

        initializeDriver();
    }

    @Before
    public void before(Scenario scenario) {
        LOGGER.info("Starting : " + scenario.getName());
    }

    @After
    public void after(Scenario scenario) {
        String scenarioName = scenario.getName();
        LOGGER.info("Completed : " + scenarioName);
        Allure.addAttachment(scenarioName, new ByteArrayInputStream(((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES)));
    }
    /**
     * This method is execute after end of execution of feature file using @After.
     */
    @AfterClass
    public void quitDriver() {

        getDriver().quit();
    }
}
