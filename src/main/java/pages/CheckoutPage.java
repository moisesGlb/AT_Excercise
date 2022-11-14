package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends PageObject {

    @FindBy(id = "checkoutButton")
    private WebElementFacade checkoutBtn;


    public void clickCheckoutBtn(){
        checkoutBtn.click();
    }

    public boolean checkoutPageDisplayed(){
        waitFor(ExpectedConditions.visibilityOf(checkoutBtn));
        return checkoutBtn.isVisible();
    }

    //--------------------------------------CONFIRMATION PAGE LOGIC-------------------------------------------\\

    @FindBy(xpath = "//h1[@class='confirmation']")
    private WebElementFacade confirmationPageTitle;

    public boolean confirmationPageTitleDisplayed(){
        waitFor(ExpectedConditions.visibilityOf(confirmationPageTitle));
        return confirmationPageTitle.isVisible();
    }
}
