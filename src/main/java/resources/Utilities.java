package resources;

import net.serenitybdd.core.pages.WebElementFacade;

public class Utilities {

    public static void clickWithRetryOnSomeElement(WebElementFacade element, int milis){
        element.click();
        try {
            Thread.sleep(milis);
            element.click();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void waitAndTryOnSomeElement(WebElementFacade element, int time){
        try {
            Thread.sleep(time);
            element.click();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
