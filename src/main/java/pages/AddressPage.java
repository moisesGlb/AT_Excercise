package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.util.List;

import static resources.Utilities.clickWithRetryOnSomeElement;

public class AddressPage extends PageObject {

    @FindBy(xpath = "//h1")
    private WebElementFacade title;

    @FindBy(xpath = "//button[@aria-label='Add a new address']")
    private WebElementFacade btnNewAddress;

    @FindBy(xpath = "//mat-row")
    private List<WebElementFacade> radioBtnAddress;

    @FindBy(xpath = "//button[@aria-label='Proceed to payment selection']")
    private WebElementFacade proceed2PaymentBtn;

    public boolean titleDisplayed(){
        waitFor(ExpectedConditions.visibilityOf(title));
        return title.isVisible();
    }

    public void clickNewAddressBtn(){
        waitFor(ExpectedConditions.visibilityOf(btnNewAddress));
        btnNewAddress.click();
    }

    public void clickBtnProceed2Payment(){
        clickWithRetryOnSomeElement(proceed2PaymentBtn);
        //proceed2PaymentBtn.click();
    }

    public void selectAddress(){
        waitFor(ExpectedConditions.elementToBeClickable(radioBtnAddress.get(0)));
        radioBtnAddress.get(0).click();
    }

    //------------------------------------ Add New Address Page ----------------------------------------\\

    @FindBy(xpath = "//input[@placeholder='Please provide a country.']")
    private WebElementFacade inputCountry;

    @FindBy(xpath = "//input[@placeholder='Please provide a name.']")
    private WebElementFacade inputName;

    @FindBy(xpath = "//input[@placeholder='Please provide a mobile number.']")
    private WebElementFacade inputMobileNumber;

    @FindBy(xpath = "//input[@placeholder='Please provide a ZIP code.']")
    private WebElementFacade inputZIP;

    @FindBy(xpath = "//textarea")
    private WebElementFacade inputAddress;

    @FindBy(xpath = "//input[@placeholder='Please provide a city.']")
    private WebElementFacade inputCity;

    @FindBy(xpath = "//input[@placeholder='Please provide a state.']")
    private WebElementFacade inputState;

    @FindBy(id = "submitButton")
    private WebElementFacade submitAddressBtn;

    public void addNewAddress(){
        waitFor(ExpectedConditions.visibilityOf(inputCountry));
        inputCountry.sendKeys("United States");
        inputName.sendKeys("Test");
        inputMobileNumber.sendKeys("1800801920");
        inputZIP.sendKeys("33101");
        inputAddress.sendKeys("Av test 1234");
        inputCity.sendKeys("Miami FL");
        inputState.sendKeys("Florida");
        submitAddressBtn.click();
    }

    //------------------------------------ Add New Address Page ----------------------------------------\\
}
