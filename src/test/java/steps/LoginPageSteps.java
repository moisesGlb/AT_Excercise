package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.fluentlenium.core.annotation.Page;
import org.junit.Assert;
import pages.LoginPage;

public class LoginPageSteps {

    @Page
    LoginPage loginPage;

    @And("the customer input the password {string}")
    public void theCustomerInputThePassword(String pass) {
        loginPage.enterPass(pass);
    }

    @And("the customer input the user {string}")
    public void theCustomerInputTheUser(String email) {
        loginPage.enterEmail(email);
    }

    @And("the customer click on the Login button")
    public void theCustomerClickOnTheLoginButton() {
        loginPage.clickLoginBtn();
    }

    @Then("the error message is displayed and contains the text {string}")
    public void theErrorMessageIsDisplayedAndContainsTheText(String error) {
        Assert.assertEquals(error,loginPage.getErrorMessage());
    }

    @And("the customer click on Forgot Your Password link")
    public void theCustomerClickOnForgotYourPasswordLink() {
        loginPage.clickForgotYourPassLink();
    }

    //----------------------- Forgot Password Logic -----------------------\\

    @And("The customer answer the security question: {string}")
    public void theCustomerAnswerThe(String answer) {
        loginPage.enterSequrityAnser(answer);
    }

    @And("the customer enter the {string}")
    public void theCustomerEnterThe(String newPassword) {
        loginPage.enterNewPassword(newPassword);
    }

    @And("the customer click on the change Button")
    public void theCustomerClickOnTheChangeButton() {
        loginPage.clickChangePassBtn();
    }

    @And("the customer click on Not yet a customer link")
    public void theCustomerClickOnNotYetACustomerLink() {
        loginPage.clickRegisterLink();
    }
}
