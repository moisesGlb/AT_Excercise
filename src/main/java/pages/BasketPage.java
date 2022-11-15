package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static resources.Utilities.clickWithRetryOnSomeElement;

import java.util.List;

public class BasketPage extends PageObject {

    @FindBy(xpath = "//h1")
    private WebElementFacade basketTitle;

    @FindBy(id = "checkoutButton")
    private WebElementFacade checkoutBtn;

    @FindBy(id = "price")
    private WebElementFacade priceTag;

    @FindBy(xpath = "//mat-row/mat-cell[2]")
    private List<WebElementFacade> productsName;

    @FindBy(xpath = "//button[@class='mat-focus-indicator mat-icon-button mat-button-base ng-star-inserted']")
    private List<WebElementFacade> quantityButtons;

    @FindBy(xpath = "//mat-row/mat-cell[3]/span[1]")
    private List<WebElementFacade> productQuantity;

    @FindBy(xpath = "//mat-row/mat-cell[4]")
    private List<WebElementFacade> priceList;

    @FindBy(xpath = "//mat-row/mat-cell[5]/button")
    private List<WebElementFacade> deleteButtonList;

    public String getBasketTitle(){
        waitFor(ExpectedConditions.visibilityOf(basketTitle));
        return basketTitle.getText();
    }

    public void increaseProdQuantity(String productName, int quantity){
        for (int i = 0; i<productsName.size(); i++){
            if (productsName.get(i).getText().equalsIgnoreCase(productName)){
                int actualQuantity = Integer.parseInt(productQuantity.get(i).getText());
                if (actualQuantity<quantity){
                    for (int j=0;j<quantity;j++){
                        if (i>0) quantityButtons.get((i*2)).click(); //multiplicas el indice del producto por 2 y le sumas 1 para obtener el indice del boton +
                        else quantityButtons.get((1)).click(); // al ser la primera opcion obtenemos el producto
                    }
                }
            }
        }
    }

    public void decreaseProdQuantity(String productName, int quantity){
        for (int i = 0; i<productsName.size(); i++){
            if (productsName.get(i).getText().equalsIgnoreCase(productName)){
                int actualQuantity = Integer.parseInt(productQuantity.get(i).getText());
                if (actualQuantity>quantity){
                    for (int j=0;j<quantity;j++){
                        if (i>0) quantityButtons.get((i*2-1)).click(); //multiplicas el indice del titulo del producto por 2 para obtener el indice del boton + y le restas uno para obtener el del boton -
                        else quantityButtons.get((0)).click(); // al ser la primera opcion sabemos el indice del boton
                    }
                }
            }
        }
    }

    public void deleteProductFromBasket(String productName){
        for (int i = 0; i<productsName.size(); i++){
            if (productsName.get(i).getText().equalsIgnoreCase(productName)){
                deleteButtonList.get(i).click();
            }
        }
    }

    public void clickCheckoutBtn(){

        clickWithRetryOnSomeElement(checkoutBtn,2500);
        //checkoutBtn.click();
    }

}
