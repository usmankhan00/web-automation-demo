package bankApp.stepDefinition;

import bankApp.config.Config;
import bankApp.pageComponents.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static bankApp.utils.CommonUtils.navigateToPage;

public class LoginStepDef extends LoginPage {

    @Given("I Login as a Bank Manager")
    public void iLoginAsBankManager() {
        navigateToPage(Config.getInstance().getUrl());
        clickOnBankManagerLoginBtn();
    }

    @Given("I Login as a Customer")
    public void iLoginAsCustomer() {
        navigateToPage(Config.getInstance().getUrl());
        clickOnCustomerLoginBtn();
    }

    @When("I clicked on Home button")
    public void iClickedOnHomeBtn() {
        clickOnHomeBtn();
    }
}
