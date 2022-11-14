package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.ui.ExpectedConditions;
import resources.GlobalConfig;

public class LoginPage extends PageObject {

    @FindBy(id = "email")
    private WebElementFacade emailInput;

    @FindBy(id = "password")
    private WebElementFacade passwordInput;

    @FindBy(id = "loginButton")
    private WebElementFacade loginBtn;

    @FindBy(xpath = "//div[@class='error ng-star-inserted']")
    private WebElementFacade errorMessage;

    //@FindBy(xpath = "//div[@id='newCustomerLink']/a")
    @FindBy(xpath = "(//a)[10]")
    private WebElementFacade registerPageLink;

    //@FindBy(xpath = "//a[@href='#/forgot-password']")
    @FindBy(xpath = "(//a)[9]")
    private WebElementFacade forgotYourPassLink;

    //----------------------- Forgot Password Locators -----------------------\\

    //the email shares the same uniqueID that the one in the login page, we reuse the email web element defined above

    @FindBy(id = "securityAnswer")
    private WebElementFacade sequrityQuestionInput;

    @FindBy(id = "newPassword")
    private WebElementFacade newPasswordInput;

    @FindBy(id = "newPasswordRepeat")
    private WebElementFacade repeatNewPasswordInput;

    @FindBy(id = "resetButton")
    private WebElementFacade changePasswordBtn;

    //----------------------- ------------------------- -----------------------\\
    public void enterEmail(String email){
        waitFor(ExpectedConditions.visibilityOf(emailInput));
        emailInput.sendKeys(email);
    }

    public void enterPass(String password){
        passwordInput.sendKeys(password);
    }

    public void clickLoginBtn(){
        loginBtn.click();
    }

    public String getErrorMessage(){
        waitFor(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }

    public void clickForgotYourPassLink(){
        waitFor(ExpectedConditions.elementToBeClickable(forgotYourPassLink));
        forgotYourPassLink.click();
    }

    public void clickRegisterLink() {
        waitFor(ExpectedConditions.elementToBeClickable(registerPageLink));
        registerPageLink.click();
    }

    //----------------------- Forgot Password Methods -----------------------\\

    public void enterSequrityAnser(String answer){
        sequrityQuestionInput.sendKeys(answer);
    }

    public void enterNewPassword(String password){
        newPasswordInput.sendKeys(password);
        repeatNewPasswordInput.sendKeys(password);
    }

    public void clickChangePassBtn(){
        waitFor(ExpectedConditions.elementToBeClickable(changePasswordBtn));
        changePasswordBtn.click();
    }


}