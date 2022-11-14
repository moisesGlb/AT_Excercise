package steps;

import io.cucumber.java.en.And;
import org.fluentlenium.core.annotation.Page;
import org.junit.Assert;
import pages.AddressPage;

public class AddressPageSteps {

    @Page
    AddressPage addressPage;

    @And("the address page should be displayed")
    public void theAddressPageShouldBeDisplayed(){
        Assert.assertTrue(addressPage.titleDisplayed());
    }

    @And("the user click on add new address")
    public void theUserClickOnAddNewAddress() {
        addressPage.clickNewAddressBtn();
    }

    @And("the user add a new address")
    public void theUserAddANewAddress() {
        addressPage.addNewAddress();
    }

    @And("the user select the new address")
    public void theUserSelectTheNewAddress() {
        addressPage.selectAddress();
        addressPage.clickBtnProceed2Payment();
    }


}
