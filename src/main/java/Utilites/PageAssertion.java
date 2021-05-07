package Utilites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageAssertion {

    static WebDriverWait webDriverWait ;

    public static Boolean assertVisibilityOfElement(By aElement , WebDriver driver , int timeout , Boolean visibilityState ){



      webDriverWait = new WebDriverWait(driver , timeout);
      Boolean visibilityCurrentState = Boolean.FALSE;


      try{

          if (visibilityState){

              webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(aElement)));
          }else {

              webDriverWait.until(ExpectedConditions.invisibilityOf(driver.findElement(aElement)));

          }

          visibilityCurrentState = Boolean.TRUE;

      }catch (Exception e){

          visibilityCurrentState = Boolean.FALSE;
          SystemLogging.loggerAddSevere("Failed to find visibility of an Element" , e);


      } finally {
          return visibilityCurrentState;
      }



    }

    public static Boolean assertElementToBeClickable(By aElement , WebDriver driver , int timeout ){



        webDriverWait = new WebDriverWait(driver , timeout);
        Boolean clickableCurrentState = Boolean.FALSE;


        try{


                webDriverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(aElement)));


            clickableCurrentState = Boolean.TRUE;

        }catch (Exception e){

            clickableCurrentState = Boolean.FALSE;
            SystemLogging.loggerAddSevere("Failed to find clickable of an Element" , e);
        } finally {
            return clickableCurrentState;
        }



    }

    public static Boolean assertElementToBeSelected(By aElement , WebDriver driver , int timeout ){



        webDriverWait = new WebDriverWait(driver , timeout);
        Boolean selectionCurrentState = Boolean.FALSE;


        try{


            webDriverWait.until(ExpectedConditions.elementToBeSelected(driver.findElement(aElement)));


            selectionCurrentState = Boolean.TRUE;

        }catch (Exception e){

            selectionCurrentState = Boolean.FALSE;
            SystemLogging.loggerAddSevere("Failed to select Element" , e);
        } finally {
            return selectionCurrentState;
        }



    }


    public static WebElement findWebElementByXPath ( String locator  , WebDriver driver ){

        WebElement element = null;

        try {
            element = driver.findElement(By.xpath(locator));

        }catch (Exception e){
            SystemLogging.loggerAddSevere("Null element" , e);
            element = null;

        }


        return element;
    }



}
