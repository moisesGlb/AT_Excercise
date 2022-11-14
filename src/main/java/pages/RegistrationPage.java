package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static resources.Utilities.waitAndTryOnSomeElement;

public class RegistrationPage extends PageObject {

    @FindBy(xpath = "//h1")
    private WebElementFacade registrationPageTitle;

    @FindBy(xpath = "//input[@id='emailControl']")
    private WebElementFacade emailInput;

    @FindBy(xpath = "//input[@id='passwordControl']")
    private WebElementFacade passwordInput;

    @FindBy(xpath = "//input[@id='repeatPasswordControl']")
    private WebElementFacade repeatPasswordInput;

    @FindBy(name = "securityQuestion")
    private WebElementFacade securityQuestionDropdown;

    @FindBy(id = "securityAnswerControl")
    private WebElementFacade sequrityQuestionAnswer;

    @FindBy(xpath = "//mat-option[2]")
    private WebElementFacade sequrityQuestion2;

    @FindBy(id = "registerButton")
    private WebElementFacade registerBtn;

    @FindBy(xpath = "//*[@id='alreadyACustomerLink']/a")
    private WebElementFacade AlreadyACustomerLink;

    public boolean registrationPageDisplayed(){
        waitFor(ExpectedConditions.visibilityOf(registrationPageTitle));
        return registrationPageTitle.isVisible();
    }

    public void enterEmail2Register(String email){
        waitFor(ExpectedConditions.visibilityOf(emailInput));
        emailInput.sendKeys(email);
    }

    public void enterPasswords(String password){
        waitFor(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.sendKeys(password);
        repeatPasswordInput.sendKeys(password);
    }

    public void selectSecurityQuestion(){
        securityQuestionDropdown.click();
        waitFor(ExpectedConditions.visibilityOf(sequrityQuestion2));
        if (sequrityQuestion2.isClickable())
            sequrityQuestion2.click();
    }

    public void enterSecurityAnswer(String answer){
        waitFor(ExpectedConditions.visibilityOf(sequrityQuestionAnswer));
        sequrityQuestionAnswer.sendKeys(answer);
    }

    public void clickRegisterButton(){
        waitAndTryOnSomeElement(registerBtn,2000);
    }

    public void clickAlreadyACustomer(){
        waitFor(ExpectedConditions.visibilityOf(AlreadyACustomerLink));
        AlreadyACustomerLink.click();
    }
}
