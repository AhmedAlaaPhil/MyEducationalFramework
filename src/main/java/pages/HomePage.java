package pages;

import Utilites.PageAssertion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    By pageAssertion = By.xpath("//input[@id =\"radio-one\"]");
    By createDocument = By.xpath("//a[text() ='Create a Document ']");
    String homePageUrl ="https://www.levelset.com/";
    WebDriver driver ;
    public HomePage (WebDriver driver){
        this.driver= driver;

    }


    public Boolean navigateToHomePage (int timeout , Boolean visibilityState){
        driver.get(homePageUrl);
        Boolean pageState = PageAssertion.assertVisibilityOfElement (pageAssertion , driver , timeout , visibilityState);
        return pageState;
    }




    public Boolean clickSelectDocumentPage (int timeout){


       return PageAssertion.assertElementToBeClickable(createDocument, driver  , timeout);

    }

}
