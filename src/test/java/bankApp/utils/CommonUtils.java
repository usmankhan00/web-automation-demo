package bankApp.utils;

import bankApp.config.Config;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is used when we have same method execute in all project.
 */
public class CommonUtils {

    private static Logger logger = LoggerFactory.getLogger(CommonUtils.class);

    /**
     * Webdriver declared.
     */
    private static WebDriver driver;

    /**
     * Webdriver wait declared.
     */
    private static WebDriverWait webDriverWait;

    /**
     * Action variable declared.
     */
    private static Actions action;

    private static Long waitForElement;

    /**
     * Public Constructor.
     */
    public CommonUtils() {

        waitForElement = Long.valueOf(Config.getInstance().getWaitForElementTimeInSeconds());
    }

    /**
     * This method is used when we need to do wait in script.
     *
     * @param milliSecond We need to enter duration of wait in milliseconds.
     */
    public static void waits(long milliSecond) {
        try {
            Thread.sleep(milliSecond);
        } catch (InterruptedException ex) {
            logger.error(ex.getMessage());
        }
    }

    /**
     * This method is used when we need to wait until element is present.
     *
     * @param seconds We need to enter duration of wait in seconds for element to
     *                appear.
     * @param obj     We need to specify the element that we are waiting.
     */
    public static void waitUntilElementPresent(long seconds, By obj) {
        webDriverWait = new WebDriverWait(driver, seconds);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(obj));
    }

    /**
     * This method is used when we need to wait until element is present with
     * respect to xpath.
     *
     * @param seconds We need to enter duration of wait in seconds for element to
     *                appear.
     * @param obj     We need to specify the xpath of element that we are waiting.
     */
    public static void waitUntilElementPresentByXpath(long seconds, String obj) {
        webDriverWait = new WebDriverWait(driver, seconds);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(obj)));
    }

    /**
     * This method is used when we need to wait until element is clickable.
     *
     * @param seconds We need to enter duration of wait in seconds for element to
     *                be clickable.
     * @param obj     We need to specify the element that we are waiting.
     */
    public static void waitUntilElementClickable(long seconds, By obj) {
        webDriverWait = new WebDriverWait(driver, seconds);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(obj));
    }

    /**
     * This method is used to click on any WebElement.
     *
     * @param webElement This is the WebElement on which click action has to be performed.
     */
    public static void clickOnElement(By webElement) {
        waitUntilElementClickable(waitForElement, webElement);
        driver.findElement(webElement).click();
    }

    /**
     * This method is used to type any text on any WebElement.
     *
     * @param webElement This is the WebElement on which text has to be typed.
     * @param inputText  This is the text which has to be typed on WebElement.
     */
    public static void enterTextOnElement(By webElement, String inputText) {
        waitUntilElementClickable(waitForElement, webElement);
        driver.findElement(webElement).clear();
        driver.findElement(webElement).sendKeys(inputText);
    }

    /**
     * This method is used to press Enter on any WebElement.
     * @param webElement This WebElement on which enter action has to be performed.
     */
    public static void pressEnterOnElement(By webElement) {
        waitUntilElementClickable(waitForElement, webElement);
        driver.findElement(webElement).sendKeys(Keys.ENTER);
    }

    /**
     * This method is used to get all WebElements.
     * @param webElement This WebElement on which enter action has to be performed.
     */
    public static List<WebElement> getAllElement(By webElement) {
        webDriverWait = new WebDriverWait(driver, waitForElement);
        try {
            webDriverWait.until(ExpectedConditions.numberOfElementsToBeMoreThan(webElement,0));
            return webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(webElement));
        } catch (Exception e) {
            return webDriverWait.until(ExpectedConditions.numberOfElementsToBe(webElement,0));
        }
    }

    /**
     * This method is used to select value from drowdown
     * @param webElement This WebElement on which enter action has to be performed.
     * @param text This text will be selected from dropdown
     */
    public static void selectValueFromDropdownByText(By webElement, String text) {
        webDriverWait = new WebDriverWait(driver, waitForElement);
        waitUntilElementClickable(waitForElement, webElement);
        Select dropdown = new Select(driver.findElement(webElement));
        dropdown.selectByVisibleText(text);
    }

    /**
     * This method is used to accept the alert.
     */
    public static void acceptTheAlert() {
        webDriverWait = new WebDriverWait(driver, waitForElement);
        Alert alert = webDriverWait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    /**
     * This method is used to initialize driver based on the browser.
     *
     * @return It will return the initialized driver.
     * @throws IOException Exception will thrown if there is any issue in create folder.
     */
    public WebDriver initializeDriver() throws IOException {

        ChromeOptions options = new ChromeOptions();
        String browser = Config.getInstance().getBrowser();
        boolean headless = Config.getInstance().getHeadless();
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            if(headless) {
                options.addArguments("--headless");
            }
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);
            driver.manage().deleteAllCookies();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            if(headless) {
                options.addArguments("--headless");
            }
            options.addArguments("start-maximized");
            driver = new FirefoxDriver(options);
            driver.manage().deleteAllCookies();
        }
        return driver;
    }

    /**
     * @return This method will return the initialized driver.
     */
    public static WebDriver getDriver() {
        return driver;
    }

    /**
     * This method is used to double-click on any WebElement.
     *
     * @param webElement This is the WebElement on which double-click action has to be performed.
     */
    public static void doubleClickOnElement(By webElement) {
        waitUntilElementPresent(waitForElement, webElement);
        action = new Actions(driver);
        action.doubleClick(driver.findElement(webElement)).perform();
    }

    /**
     * This method is used to get the text of any web element.
     * 
     * @param webElement This is the locator of web element.
     * @return This is the text of web element.
     */
    public static String getTextOfWebElement(By webElement) {
        waitUntilElementClickable(waitForElement,webElement);
        return getDriver().findElement(webElement).getText();
    }

    /**
     * This method is used to validate if the element is displayed or not on any page.
     * @param locator This is the locator of web element.
     * @return true if element is displayed.
     */
    public static boolean isElementDisplayed(By locator) {
        try {
            return getDriver().findElement(locator).isDisplayed();
        } catch (NoSuchElementException exception) {
            logger.info("Element is not displayed: {}", exception.getMessage());
            return false;
        }
    }

    /**
     * This method is used to switch to any tab.
     * @param tab is the index of the tab to be switched.
     */
    public void switchToTab(int tab) {
        ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(tab));
    }

    /**
     * This method is used to scroll to a WebElement.
     * @param locator of WebElement.
     */
    public static void scrollToElement(By locator) {
        action = new Actions(getDriver());
        action.moveToElement(driver.findElement(locator)).perform();
    }

    /**
     * This method is used to maximize the window.
     */
    public static void maximizeWindow() {
        getDriver().manage().window().maximize();
    }

    /**
     * This method is used to navigate to any page.
     * @param url page to be opened
     */
    public static void navigateToPage(String url) {
        try {
            driver.get(url);
        } catch (Exception e) {
            logger.error("Unable to navigate to page: " + e.getMessage());
        }
    }
}
