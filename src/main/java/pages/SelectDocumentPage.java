package pages;

import Utilites.PageAssertion;
import Utilites.SystemLogging;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static Utilites.PageAssertion.findWebElementByXPath;

public class SelectDocumentPage {
    static By pageAssertion = By.xpath("//div/label[text() = 'Send a Document']");
    private String pageURL = "https://app.levelset.com/wizard/SelectDocument/?_ga=2.15754623.87461020." +
            "1613554071-1563237621.1613554071";
    static WebDriver driver ;
    public SelectDocumentPage (WebDriver driver){
        this.driver= driver;

    }
    public Boolean navigateToSelectDocumentPage (int timeout , Boolean invisibilystate){

        driver.get(pageURL);
        return assertSelectPageLoaded(timeout , invisibilystate);

    }
    public static Boolean assertSelectPageLoaded(int timeout , Boolean pageState){
       return  PageAssertion.assertVisibilityOfElement(pageAssertion , driver , timeout , pageState);

    }

    public WebElement assertPrice(String name){

        WebElement element;

        element =  findWebElementByXPath("//div[@class = 'product-title-container card-header']//div[text()='"
                +name+"']//following-sibling::div//span[text() = 'Free' or /span[text() = 'Free']]" , driver);
           return element;

    }



}
