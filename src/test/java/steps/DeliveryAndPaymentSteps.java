package steps;

import io.cucumber.java.en.And;
import org.fluentlenium.core.annotation.Page;
import pages.DeliveryAndPaymentPage;

public class DeliveryAndPaymentSteps {

    @Page
    DeliveryAndPaymentPage deliveryAndPaymentPage;

    @And("the user select a delivery speed {string}")
    public void theUserSelectADeliverySpeed(String velocity) {
        deliveryAndPaymentPage.selectShipingOptions(Integer.parseInt(velocity));
        deliveryAndPaymentPage.clickProceedDeliveryBtn();
    }
    @And("the user select the card to pay")
    public void theUserSelectTheCardToPay() {

        deliveryAndPaymentPage.selectCreditCardToPay();
    }

    @And("the user add a new card")
    public void theUserAddANewCard() {
        deliveryAndPaymentPage.addNewCreditCard();
    }
}
