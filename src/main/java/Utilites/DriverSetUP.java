package Utilites;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverSetUP {
    private static WebDriver driver;

    public enum  driverTypes {
        Chrome ,
        FireFox  ,
        Edge ,
        IE
    }

    public static WebDriver setUP( driverTypes d){


        switch (d){
            case Chrome :    WebDriverManager.chromedriver().setup();
                                 driver = new ChromeDriver();
                                 break;
            case FireFox :   WebDriverManager.firefoxdriver().setup();
                             driver = new FirefoxDriver();
                break;
            case Edge :     WebDriverManager.edgedriver().setup();
                            driver = new EdgeDriver();
                           break;
            case IE:      WebDriverManager.iedriver().setup();
                           driver = new InternetExplorerDriver();
                                    break;
            default:

               System.out.println("Error Your Selected Driver is not In Our DataBase");

                break;




        }


        return driver;

    }

    public static void tearDown (WebDriver ddriver){

        ddriver.quit();

    }


}
