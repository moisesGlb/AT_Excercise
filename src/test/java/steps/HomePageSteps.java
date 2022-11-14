package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fluentlenium.core.annotation.Page;
import org.junit.Assert;
import pages.HomePage;

public class HomePageSteps {

    @Page
    HomePage homePage;

    @Given("a customer navigates to the home page of OWASP Juice Shop")
    public void aCustomerNavigatesToTheHomePageOfOWASPJuiceShop(){
        homePage.getHomePage();
    }

    @When("the customer navigates to the login page")
    public void theCustomerNavigatesToTheLoginPage() {
        homePage.clickAccountBtn();
        homePage.clickLoginBtn();
    }

    @Then("the Home Page should be displayed")
    public void theHomePageShouldBeDisplayed() {
        Assert.assertEquals("All Products",homePage.getSearchTitle());
    }

    @And("the customer goes to the basket")
    public void theCustomerGoesToTheBasket() {
        homePage.clickBasketBtn();
    }

    @Given("a customer navigates to the registration page of OWASP Juice Shop")
    public void aCustomerNavigatesToTheRegistrationPageOfOWASPJuiceShop() {
        homePage.geRegistrationPage();
    }

    @Given("a customer navigates to the Forgot Password page of OWASP Juice Shop")
    public void aCustomerNavigatesToTheForgotPasswordPageOfOWASPJuiceShop() {
        homePage.getForgotPasswordPage();
    }

    @Given("a customer that add a product to the basket {string}")
    public void aCustomerThatAddAProductToTheBasket(String index) {
        homePage.clickAdd2BasketBtn(Integer.parseInt(index)); //Clickea un elemento random para el test de la primera pagina
    }
}
