package bankApp.pageComponents;

import bankApp.utils.CommonUtils;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DashboardPage extends CommonUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(DashboardPage.class.getName());
    private LoginPage loginPage;
    private By addCustomerBtn = By.xpath("//button[normalize-space()='Add Customer']");
    private By openAccountBtn = By.xpath("//button[normalize-space()=='Open Account']");
    private By customersBtn = By.xpath("//button[normalize-space()='Customers']");
    private By firstName = By.xpath("//input[@placeholder='First Name']");
    private By lastName = By.xpath("//input[@placeholder='Last Name']");
    private By postCode = By.xpath("//input[@placeholder='Post Code']");
    private By addCustomerBtnOnForm = By.xpath("//button[@type='submit']");
    private By customerTab = By.xpath("//button[normalize-space()='Customers']");
    private By deleteCustomerBtn = By.xpath("//button[.='Delete']");
    private By searchCustomer = By.xpath("//input[@placeholder='Search Customer']");
    private By customerDropdown = By.id("userSelect");
    private By customerAccountDropdown = By.id("accountSelect");
    private By customerLoginBtn = By.xpath("//button[normalize-space()='Login']");
    private By accountStatment = By.xpath("//div[@class='center' and contains(normalize-space(),'Account Number')]");
    private By depositBtn = By.xpath("//button[normalize-space()='Deposit']");
    private By withDrawlBtn = By.xpath("//button[normalize-space()='Withdrawl']");
    private By amountTextbox  = By.xpath("//input[@placeholder='amount']");
    private By submitAmountBtn = By.xpath("//button[@type='submit']");

    public DashboardPage() {
        loginPage = new LoginPage();
    }

    /**
     * Click on Open bank button on dashboard page
     */
    public void clickOnOpenAccountBtn() {

        try {
            clickOnElement(openAccountBtn);
            LOGGER.info("Clicked on Open Account button on Dashboard page");
        } catch (Exception e) {
            LOGGER.error("Unable to click on Open Bank button on Dashboard page");
        }
    }

    /**
     * Click on Add Customer button on dashboard page
     */
    public void clickOnAddCustomersBtn() {

        try {
            clickOnElement(addCustomerBtn);
            LOGGER.info("Clicked on Add Customer button on dashboard page");
        } catch (Exception e) {
            LOGGER.error("Unable to click on Add Customer button on dashboard page");
        }
    }

    /**
     * Click on Customers button on dashboard page
     */
    public void clickOnCustomerBtn() {

        try {
            clickOnElement(customersBtn);
            LOGGER.info("Clicked on Customer button on dashboard page");
        } catch (Exception e) {
            LOGGER.error("Unable to click on Customer button on dashboard page");
        }
    }

    /**
     * Enter value in first name text field on add customer form
     */
    public void enterFirstNameOnAddCustomerForm(String firstNameValue) {

        try {
            enterTextOnElement(firstName,firstNameValue);
            LOGGER.info("Enter first name on Add Customer form: " + firstNameValue);
        } catch (Exception e) {
            LOGGER.error("Unable to add first name on Add customer form");
        }
    }

    /**
     * Enter value in last name text field on add customer form
     */
    public void enterLastNameOnAddCustomerForm(String lastNameValue) {

        try {
            enterTextOnElement(lastName,lastNameValue);
            LOGGER.info("Enter last name on Add Customer form: " + lastNameValue);
        } catch (Exception e) {
            LOGGER.error("Unable to add last name on Add customer form");
        }
    }

    /**
     * Enter value in post code text field on add customer form
     */
    public void enterPostCodeOnAddCustomerForm(String postCodeValue) {

        try {
            enterTextOnElement(postCode,postCodeValue);
            LOGGER.info("Enter post code on Add Customer form: " + postCodeValue);
        } catch (Exception e) {
            LOGGER.error("Unable to add post code on Add customer form");
        }
    }

    /**
     * Enter value in post code text field on add customer form
     */
    public void submitAddCustomerForm() {

        try {
            clickOnElement(addCustomerBtnOnForm);
            LOGGER.info("Clicked on Add Customer button on Add customer form");
        } catch (Exception e) {
            LOGGER.error("Unable to Add Customer button on Add customer form : " + e.getMessage() );
        }
    }

    /**
     * Click on Customers tab on Dashboard page
     */
    public void clickOnCustomersTab() {

        try {
            clickOnElement(customerTab);
            LOGGER.info("Clicked on Customers tab on Dashboard page");
        } catch (Exception e) {
            LOGGER.error("Unable to Customers tab on Dashboard Page: " + e.getMessage() );
        }
    }

    /**
     * Search Customers on customer tab on Dashboard page
     */
    public void searchCustomerOnCustomersTab(String value) {

        try {
            enterTextOnElement(searchCustomer,value);
            LOGGER.info("Search customers on Customers tab on Dashboard page");
        } catch (Exception e) {
            LOGGER.error("Unable to search customers on Customers tab on Dashboard Page: " + e.getMessage() );
        }
    }

    /**
     * Click on Delete btn on Customer Tabs on Dashboard page
     */
    public void clickOnDeleteBtn() {

        try {
            clickOnElement(deleteCustomerBtn);
            LOGGER.info("Clicked on Delete btn on Customers tab on Dashboard page");
        } catch (Exception e) {
            LOGGER.error("Unable to click on Delete btn customers on Customers tab on Dashboard Page: " + e.getMessage() );
        }
    }

    /**
     * Validate is Delete btn on Customer Tabs is Displayed on Dashboard page
     */
    public boolean isDeleteBtnDisplayed() {

        int size = getAllElement(deleteCustomerBtn).size();
        LOGGER.info("Count of all elements : " + size);
        return size > 0;
    }

    public boolean isCustomerAvailable(String name) {

        int size = getAllElement(By.xpath("//td[normalize-space()=\'"+name+"\']")).size();
        LOGGER.info("Check customer is exists count: " + size);
        return size > 0;
    }

    /**
     * Select Customer from the dropdown
     */
    public void selectCustomerFromDropdown(String customerName) {

        try {
            selectValueFromDropdownByText(customerDropdown,customerName);
            LOGGER.info("Select customer from dropdown: " + customerName);
        } catch (Exception e) {
            LOGGER.error("Unable to select customers on Customers tab on Dashboard Page: " + e.getMessage() );
        }
    }

    /**
     * Click on Login button
     */
    public void clickOnCustomerLoginButton() {

        try {
            clickOnElement(customerLoginBtn);
            LOGGER.info("Clicked on customer login button");
        } catch (Exception e) {
            LOGGER.error("Unable to click on customers login button: " + e.getMessage() );
        }
    }

    /**
     * Select Customer account from the dropdown
     */
    public void selectCustomerAccountFromDropdown(String accountNo) {

        try {
            selectValueFromDropdownByText(customerAccountDropdown,accountNo);
            LOGGER.info("select account from dropdown: " + accountNo);
        } catch (Exception e) {
            LOGGER.error("Unable to select customers on account: " + e.getMessage() );
        }
    }

    /**
     * Get Account balance
     */
    public String getAccountBalance() {

        String balance = getTextOfWebElement(accountStatment).split(",")[1].split(":")[1];
        LOGGER.info("Account Balance: " + balance);
        return balance;
    }

    /**
     * Click on Deposit button
     */
    public void clickOnDepositButton() {

        try {
            clickOnElement(depositBtn);
            LOGGER.info("Click on deposit button");
        } catch (Exception e) {
            LOGGER.error("Unable to click on Deposit btn" + e.getMessage() );
        }
    }

    /**
     * Click on Withdrawl button
     */
    public void clickOnWithdrawlButton() {

        try {
            clickOnElement(withDrawlBtn);
            LOGGER.info("Click on withdrawl button");
        } catch (Exception e) {
            LOGGER.error("Unable to click on Withdrawl btn" + e.getMessage() );
        }
    }

    /**
     * Enter amount in amount textbox
     */
    public void enterAmountInAmountTextbox(String amount) {

        try {
            enterTextOnElement(amountTextbox,amount);
            LOGGER.info("Enter amount in amount textbox : " + amount);
        } catch (Exception e) {
            LOGGER.error("Unable to enter amount" + e.getMessage() );
        }
    }

    public void submitAmountForm() {

        try {
            clickOnElement(submitAmountBtn);
            LOGGER.info("Click on submit button");
        } catch (Exception e) {
            LOGGER.error("Unable to submit button" + e.getMessage() );
        }
    }


}
