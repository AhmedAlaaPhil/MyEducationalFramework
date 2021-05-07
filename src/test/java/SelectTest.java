import Utilites.DriverSetUP;
import Utilites.SystemLogging;
import com.google.gson.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HomePage;
import pages.SelectDocumentPage;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SelectTest {

    private WebDriver driver;
    HomePage homePage ;
    SelectDocumentPage selectDocumentPage ;
    @Parameters("browser")
    @BeforeTest
    public void homeInit (@Optional("Chrome") String browser){

        SystemLogging.loggerInit();

        if(browser.equals("Chrome")){
        driver = DriverSetUP.setUP(DriverSetUP.driverTypes.Chrome);}
        else if (browser.equals("FireFox")){

            driver = DriverSetUP.setUP(DriverSetUP.driverTypes.FireFox);

        }else {

            driver = DriverSetUP.setUP(DriverSetUP.driverTypes.Chrome);

        }
        homePage = new HomePage(driver);
       if (homePage.navigateToHomePage(30 , Boolean.TRUE)){

       if(homePage.clickSelectDocumentPage(30)){

           selectDocumentPage = new SelectDocumentPage(driver);
           selectDocumentPage.navigateToSelectDocumentPage(30 , Boolean.TRUE);
       } else {

           Assert.fail();

       }


       }else {

           Assert.fail();


       }


    }
    @DataProvider
    public Object [] selectDocumentDataProvider (){
        Object[] docNames = new Object[4];
        docNames[0] = "20-Day Preliminary Notice";
        docNames[1] = "Notice of Intent to Lien";
        docNames[2] = "Lien / Bond Claim";

        docNames[3] = "Lien Waiver";

        return docNames;
    }

    @Test(dataProvider = "selectDocumentDataProvider")
    public void selecetFreeTest(String docNames){

        SystemLogging.loggerAddInfo(docNames+" test");
        Assert.assertNotNull(selectDocumentPage.assertPrice(docNames));

    }
    @Test
    public void jsonTest () throws IOException, ParseException {

        readJson();

    }

    @SuppressWarnings("unchecked")
    public void readWriteJSON() throws InterruptedException, IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        try  {
            FileReader reader = new FileReader("D:\\SW_EN\\ITI SW Testing and QA\\Automation\\src\\main\\java\\Data\\JasonData.json");
//Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONArray dataList = (JSONArray) obj;
            System.out.println(dataList); //This prints the entire json file
            for(int i=0;i<dataList.size();i++) {
                JSONObject data = (JSONObject) dataList.get(i);
                System.out.println(data+""+i);//This prints every block - one json object
                JSONObject data1 = (JSONObject) data.get("data");
                System.out.println(data1); //This prints each data in the block
                String testData = (String) data1.get("testData");
                Assert.assertNotNull(selectDocumentPage.assertPrice(testData));





            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void readJson () throws IOException, ParseException {

        String fileName = "D:\\SW_EN\\ITI SW Testing and QA\\Automation\\src\\main\\java\\Data\\JasonData.json";
        String data;
            FileReader reader = new FileReader(fileName);
            JSONParser jsonParser = new JSONParser();
            Object obj = jsonParser.parse(reader);
            JSONArray dataList = (JSONArray) obj;
            for(Object jObject : dataList){
               JSONObject myData = (JSONObject) jObject;
                data = (String) myData.get("testData");
                System.out.println(data);
                Assert.assertNotNull(selectDocumentPage.assertPrice(data));
            }




    }
    @AfterClass
    public void endOfTest (){

        SystemLogging.loggerAddInfo("end of test");
        DriverSetUP.tearDown(driver);
    }
}
