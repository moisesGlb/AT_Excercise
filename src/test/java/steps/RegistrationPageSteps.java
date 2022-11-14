package steps;

import io.cucumber.java.en.And;
import org.fluentlenium.core.annotation.Page;
import org.junit.Assert;
import pages.RegistrationPage;

public class RegistrationPageSteps {

    @Page
    RegistrationPage registrationPage;

    @And("the registration page should be displayed")
    public void theRegostrationPageShouldBeDisplayed(){
        Assert.assertTrue(registrationPage.registrationPageDisplayed());
    }

    @And("the customer complete the user required field {string}")
    public void theCustomerCompleteTheUserRequiredField(String email) {
        registrationPage.enterEmail2Register(email);
    }

    @And("the customer complete the {string} and repeat password required fields")
    public void theCustomerCompleteTheAndRepeatPasswordRequiredFields(String password) {
        registrationPage.enterPasswords(password);
    }

    @And("the customer select a required  security question")
    public void theCustomerSelectARequiredSecurityQuestion() {
        registrationPage.selectSecurityQuestion();
    }

    @And("the customer complete the {string} required field")
    public void theCustomerCompleteTheRequiredField(String security_answer) {
        registrationPage.enterSecurityAnswer(security_answer);
    }

    @And("the customer click on the register button")
    public void theCustomerClickOnTheRegisterButton() {
        registrationPage.clickRegisterButton();
    }
}
