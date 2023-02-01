package bankApp.pageComponents;

import bankApp.utils.CommonUtils;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is used to Login.
 */
public class LoginPage extends CommonUtils {
    private static final Logger logger = LoggerFactory.getLogger(LoginPage.class);

    private By homeBtn = By.xpath("//button[.='Home']");
    private By customerLoginBtn = By.xpath("//button[.='Customer Login']");
    private By bankManagerLogin = By.xpath("//button[.='Bank Manager Login']");

    /**
     * Click on Home button on login page
     */
    public void clickOnHomeBtn() {

        try {
            clickOnElement(homeBtn);
            logger.info("Clicked on Home button on Login page");
        } catch (Exception e) {
            logger.error("Unable to click on Home button on Login page");
        }
    }

    /**
     * Click on Customer Login button on login page
     */
    public void clickOnCustomerLoginBtn() {

        try {
            clickOnElement(customerLoginBtn);
            logger.info("Clicked on Customer login button on Login page");
        } catch (Exception e) {
            logger.error("Unable to click on Customer login button on Login page");
        }
    }

    /**
     * Click on Bank Manager Login button on login page
     */
    public void clickOnBankManagerLoginBtn() {

        try {
            clickOnElement(bankManagerLogin);
            logger.info("Clicked on Bank login button on Login page");
        } catch (Exception e) {
            logger.error("Unable to click on Bank login button on Login page");
        }
    }
}
