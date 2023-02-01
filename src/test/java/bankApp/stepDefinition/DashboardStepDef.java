package bankApp.stepDefinition;

import bankApp.pageComponents.DashboardPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DashboardStepDef extends DashboardPage {

    @When("I clicked on Add Customer")
    public void iClickedOnAddCustomerBtn() throws InterruptedException {

        clickOnAddCustomersBtn();
    }

    @And("I added the customer by entering First Name: {string}, Last Name: {string}, Post Code: {string}")
    public void iAddedTheCustomers(String firstName, String lastName, String postCode) {

        enterFirstNameOnAddCustomerForm(firstName);
        enterLastNameOnAddCustomerForm(lastName);
        enterPostCodeOnAddCustomerForm(postCode);
        submitAddCustomerForm();
        acceptTheAlert();
    }

    @When("I clicked on Customers Tab")
    public void iClickedOnCustomersTab() throws InterruptedException {

        clickOnCustomersTab();
    }

    @And("I searched the Customer {string}")
    public void iSearchedTheCustomer(String name) {

        searchCustomerOnCustomersTab(name);
    }

    @And("If {string} customer is present then I delete that customer")
    public void ifCustomerIsPresentDeleteThatCustomer(String name) {

        if(isCustomerAvailable(name)) {
            clickOnDeleteBtn();
        }
    }

    @Then("Customer {string} should deleted")
    public void customerShouldDeleted(String name) {

        Assert.assertTrue ("Customer " + name + "should deleted.", isCustomerAvailable(name));
    }

    @Then("Customer {string} should created")
    public void customerShouldCreated(String name) {

        Assert.assertTrue("Customer " + name + "should created.", isCustomerAvailable(name));
    }

    @When("I select the customer {string} from dropdown")
    public void iSelectTheCustomer(String name) {

        selectCustomerFromDropdown(name);
    }

    @And("I clicked on Customer Login button")
    public void iClickedOnCustomerLoginBtn() {

        clickOnCustomerLoginButton();
    }

    @And("I select the customer account {string} from dropdown")
    public void iClickedOnCustomerLoginBtn(String accountNo) {

        selectCustomerAccountFromDropdown(accountNo);
    }

    @And("I {string} {string}")
    public void iPerformedTransaction(String transactionType,String amount) {

        if(transactionType.equalsIgnoreCase("deposit")) {
            clickOnDepositButton();
            enterAmountInAmountTextbox(amount);
            submitAmountForm();
        } else if (transactionType.equalsIgnoreCase("withdrawl")) {
            clickOnWithdrawlButton();
            enterAmountInAmountTextbox(amount);
            submitAmountForm();
        }
    }

    @And("I validated the balance {string} on home page")
    public void iValidatedTheBalanceOnHomePage(String balance) {
        String value = getAccountBalance().trim();
        Assert.assertEquals(balance,value);
    }
}
