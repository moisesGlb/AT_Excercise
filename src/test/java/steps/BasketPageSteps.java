package steps;

import io.cucumber.java.en.And;
import org.fluentlenium.core.annotation.Page;
import pages.BasketPage;

public class BasketPageSteps {

    @Page
    BasketPage basketPage;

    @And("the customer click on the checkout button")
    public void theCustomerClickOnTheCheckoutButton() {
        basketPage.clickCheckoutBtn();
    }

    @And("the customer modify the product quantity {string}")
    public void theCustomerModifyTheProductQuantity(String producName) {
        basketPage.increaseProdQuantity(producName,1);
    }


    @And("the customer decrease the product quantity {string}")
    public void theCustomerDecreaseTheProductQuantity(String productName) {
        basketPage.decreaseProdQuantity(productName,1);
    }
}
