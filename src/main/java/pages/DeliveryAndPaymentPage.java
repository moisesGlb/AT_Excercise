package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static resources.Utilities.waitAndTryOnSomeElement;

public class DeliveryAndPaymentPage extends PageObject {

    @FindBy(xpath = "//mat-row")
    private List<WebElementFacade> shipingOptions;

    @FindBy(xpath = "//button[@aria-label='Proceed to delivery method selection']")
    private WebElementFacade proceedDeliveryMethodBtn;

    public void selectShipingOptions(int option){
        if (option > 3 || option < 0) shipingOptions.get(2).click();
        else shipingOptions.get(option).click();
    }

    public void clickProceedDeliveryBtn(){
        proceedDeliveryMethodBtn.click();
    }

    //-------------------------------------------- Payment Page Logic-----------------------------------------------\\

    @FindBy(xpath = "(//mat-expansion-panel-header)[1]")
    private WebElementFacade addNewCardExpansionPanel;

    @FindBy(xpath = "(//mat-expansion-panel)[1]//input[@type='text']")
    private WebElementFacade creditCardName;

    @FindBy(xpath = "(//mat-expansion-panel)[1]//input[@type='number']")
    private WebElementFacade creditCardNumber;

    @FindBy(xpath = "(//select)[1]")
    private WebElementFacade expirationMonthSelect;

    @FindBy(xpath = "(//select)[2]")
    private WebElementFacade expirationYearSelect;

    @FindBy(id = "submitButton")
    private WebElementFacade submitCreitCardInfoBtn;

    @FindBy(xpath = "(//mat-radio-button)[1]")
    private WebElementFacade availableCreditCards;

    @FindBy(xpath = "//button[@aria-label='Proceed to review']")
    private WebElementFacade continueBtn;


    public void addNewCreditCard(){
        waitFor(ExpectedConditions.visibilityOf(addNewCardExpansionPanel));
        addNewCardExpansionPanel.click();
        creditCardName.sendKeys("Test Credit Card");
        creditCardNumber.sendKeys("1234567891123456");
        expirationMonthSelect.selectByVisibleText("10");
        expirationYearSelect.selectByVisibleText("2080");
        submitCreitCardInfoBtn.click();
    }

    public void selectCreditCardToPay(){
        //waitFor(ExpectedConditions.elementToBeClickable(availableCreditCards));
        waitAndTryOnSomeElement(availableCreditCards,1000);
        continueBtn.click();
    }

}
