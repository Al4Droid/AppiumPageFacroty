package TestCases;

import PageFactory.ListPage;
import PageFactory.Login;
import Utils.ExcelSheetLibrary;
import jxl.read.biff.BiffException;
import org.apache.http.auth.MalformedChallengeException;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.appium.java_client.MobileElement;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by almogood on 2017-01-10.
 */
public class TestLogin {

    static WebDriver driver ;

    Login objLogin;

    ListPage objListPage;
    @BeforeClass
    public static void setUp() {

        // setup desired capabilities and pass android app-activity and package to appium

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("BROWSER_NAME", "Android");
        capabilities.setCapability("VERSION", "5.1.1");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformName", "Android");

        capabilities.setCapability("appPackage", "com.almog.gymglish");
        capabilities.setCapability("appActivity", "com.almog.gymglish.MainActivity");
        try {
            driver= null;
            driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            System.out.println("fail to connect to remoteWebDriver check the URL ");
            e.printStackTrace();
        }

    }


    @Test
    public void testLogin ()throws BiffException, IOException  {
        // verify login page title

        objLogin = new Login(driver);
        String loginPageTitle = objLogin.getLoginTitle().toLowerCase();

        System.out.println("The expected "+objLogin.EXPECTED_LOGIN_PAGE_TITLE.toLowerCase());
        System.out.println("The actual "+loginPageTitle);
        Assert.assertTrue(objLogin.EXPECTED_LOGIN_PAGE_TITLE.toLowerCase().contentEquals(loginPageTitle.toLowerCase()));

        // login to application

        ExcelSheetLibrary excel = new ExcelSheetLibrary("/Users/almogood/Automation/LoginData.xls");

        //CalcAppPage calPage = new CalcAppPage(driver);
        // (excel.ReadCell(excel.GetCell("Number1"), 1),

        //String userName = excel.ReadCell(excel.GetCell("userName"), 1);
        String userName = excel.ReadCell(0, 1);
        System.out.println("The userName from XLS: "+userName);
        //String password = excel.ReadCell(excel.GetCell("Password"), 1);
        String password = excel.ReadCell(1, 1);
        System.out.println("The Password from XLS: "+password);

        objLogin.loginToGymglish("Almog","almog");

        // go to home page

        objListPage = new ListPage(driver);
      //  MobileElement homePage = (MobileElement) (new WebDriverWait(driver, 2)
              //  .until(ExpectedConditions.presenceOfElementLocated(By.name("android:id/text1")))) ;

      //  WebDriverWait wait = new WebDriverWait(driver, 2);
       // wait.until(ExpectedConditions.);

        System.out.println("The expected " + objListPage.EXPECTED_LIST_PAGE_FIRST_ITME);


        System.out.println("The actual " + objListPage.getListFirstItem().toLowerCase());

      //  Assert.assertEquals(homePage.getText(), objListPage.EXPECTED_LIST_PAGE_FIRST_ITME);

        System.out.println("The expected "+objListPage.EXPECTED_LIST_PAGE_FIRST_ITME);
        System.out.println("The actual "+objListPage.getListFirstItem().toLowerCase());

        Assert.assertTrue(objListPage.EXPECTED_LIST_PAGE_FIRST_ITME.toLowerCase().contentEquals(objListPage.getListFirstItem().toLowerCase()));

    }

}
