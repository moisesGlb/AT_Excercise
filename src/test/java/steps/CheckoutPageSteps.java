package steps;

import io.cucumber.java.en.And;
import org.fluentlenium.core.annotation.Page;
import org.junit.Assert;
import pages.CheckoutPage;

public class CheckoutPageSteps {

    @Page
    CheckoutPage checkoutPage;

    @And("the checkout page is displayed")
    public void theCheckoutPageIsDisplayed() {
        Assert.assertTrue(checkoutPage.checkoutPageDisplayed());
    }

    @And("the user place the order and Pay")
    public void theUserPlaceTheOrderAndPay() {
        checkoutPage.clickCheckoutBtn();
    }

    @And("the confirmation page is displayed")
    public void theConfirmationPageIsDisplayed() {
        Assert.assertTrue(checkoutPage.confirmationPageTitleDisplayed());
    }
}
