package pages;

import io.cucumber.java.en.Given;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.ui.ExpectedConditions;
import resources.GlobalConfig;

import java.util.List;

public class HomePage extends PageObject {

    @FindBy(id = "mat-dialog-0")
    private WebElementFacade welcomeMsg;
    @FindBy(xpath = "//div[@id='cdk-overlay-1']//button[2]")
    private WebElementFacade closeWelcomeMsgBtn;

    @FindBy(xpath = "//app-search-result//div[@class='heading mat-elevation-z6']//div[@class='ng-star-inserted']")
    private WebElementFacade searchResultsTitle;

    @FindBy(xpath = "//button[@class='mat-focus-indicator mat-button mat-button-base']")
    private WebElementFacade ForceReloadButton;

    @FindBy(xpath = "//div/a[@role='button']")
    private WebElementFacade cookieBtn;

    //Navigation Bar Locators
    @FindBy(id = "navbarAccount")
    private WebElementFacade accountBtn;

    @FindBy(id = "navbarLoginButton")
    private WebElementFacade loginBtn;

    @FindBy(xpath = "//button[@aria-label='Show the shopping cart']")
    private WebElementFacade ShopCartBtn;

    //End Navigation Bar Locators

    @FindBy(xpath = "//div[@class='mat-grid-tile-content']//div[@class='item-name']")
    private List<WebElementFacade> itemNames;

    @FindBy(xpath = "//div[@class='mat-grid-tile-content']//div[@class='item-price']")
    private List<WebElementFacade> itemPrices;

    @FindBy(xpath = "//div[@class='mat-grid-tile-content']//button")
    private List<WebElementFacade> btnAdd2Basket;

    //Navigation Bar Method

    public void getHomePage(){
        getDriver().get(GlobalConfig.MAIN_URL);
        closeWelcomeMsg();;
    }

    public void geRegistrationPage(){
        getDriver().get(GlobalConfig.REGISTRATION_URL);
        closeWelcomeMsg();
    }
    public void getForgotPasswordPage(){
        getDriver().get(GlobalConfig.FORGOT_PASS_URL);
        closeWelcomeMsg();
    }

    public void closeWelcomeMsg(){
        waitFor(ExpectedConditions.visibilityOf(welcomeMsg));
        if(closeWelcomeMsgBtn.isClickable()){
            closeWelcomeMsgBtn.click();
        }
        waitFor(ExpectedConditions.visibilityOf(cookieBtn));
        cookieBtn.click();
    }

    //Navigation Bar

    public void clickAccountBtn(){
        accountBtn.click();
    }

    public void clickLoginBtn(){
        waitFor(ExpectedConditions.visibilityOf(loginBtn));
        loginBtn.click();
    }

    // Home Page Methods

    public String getSearchTitle(){
        waitFor(ExpectedConditions.visibilityOf(searchResultsTitle));
        return searchResultsTitle.getText();
    }

    public void clickAdd2BasketBtn(int index){
        if (index>0 && index <= btnAdd2Basket.size()){
            btnAdd2Basket.get(index).click();
        }
    }

    public void clickBasketBtn(){
        ShopCartBtn.click();
    }


}
