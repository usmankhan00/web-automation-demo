package bankApp.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This is a singleton class which is used to read configuration from config.properties
 * file and use then throughout the framework with the help of its reference.
 */
public final class Config {

    private static final Logger LOGGER = LoggerFactory.getLogger(Config.class);

    private static String browserName;

    private String url;

    private String waitForElementTimeInSeconds;

    private boolean headless;

    private static Config config;

    /**
     * Constructor of singleton class used to initialize the config.properties values.
     */
    private Config() {

        this.url = readPropertiesFile().getProperty("url");

        this.waitForElementTimeInSeconds = readPropertiesFile().getProperty("waitForElementTimeInSeconds");

        this.browserName = readPropertiesFile().getProperty("browserName");

        this.headless = Boolean.parseBoolean(readPropertiesFile().getProperty("headless"));
    }

    /**
     * This function is used to return reference of config class.
     * @return object of config class created on runtime.
     */
    public static Config getInstance() {
        if (null == config) {
            config = new Config();
        }
        return config;
    }

    /**
     *@return url initialized in constructor.
     */
    public String getUrl() {
        return url;
    }

    /**
     *@return wait for element in seconds.
     */
    public String getWaitForElementTimeInSeconds() {
        return waitForElementTimeInSeconds;
    }

    /**
     *@return browser name.
     */
    public String getBrowser() {
        return browserName;
    }

    /**
     *@return browser headless.
     */
    public boolean getHeadless() {
        return headless;
    }

    /**
     * This method is used to read the config.properties file.
     *
     * @return Return the data we need from properties file.
     */
    public Properties readPropertiesFile() {
        FileInputStream fileInputStream;
        Properties prop = null;
        try {
            String filepath = System.getProperty("user.dir") + "/src/test/resources/config.properties";
            File fileName = new File(filepath);
            fileInputStream = new FileInputStream(fileName);
            prop = new Properties();
            prop.load(fileInputStream);
        } catch (IOException ioException) {
            LOGGER.error("Error while reading properties file", ioException);
        }
        return prop;
    }

}
