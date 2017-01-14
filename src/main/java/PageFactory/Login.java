package PageFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by almogood on 2017-01-10.
 */
public class Login {

    WebDriver driver;

    @FindBy(id = "com.almog.gymglish:id/textView")
    WebElement LoginPageTitle;

    @FindBy(id = "com.almog.gymglish:id/user_nameET")
    WebElement LoginPageUserName;

    @FindBy(id = "com.almog.gymglish:id/passwordET")
    WebElement LoginPagePassword;

    @FindBy(id = "com.almog.gymglish:id/submit_btn")
    WebElement LoginPageSubmitBtn;

    public static final String EXPECTED_LOGIN_PAGE_TITLE = "Please SET User Name and Password";


    public Login (WebDriver driver) {
        this.driver = driver;
        // This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    // Set user name in EditText

    public void setUserName(String strUserName) {
        LoginPageUserName.sendKeys(strUserName);
    }

    // set password in EditText

    public void setPassword(String strPassword) {
        LoginPagePassword.sendKeys(strPassword);
    }

    // click on login button

    public void clickLogin() {
        LoginPageSubmitBtn.click();
    }

    // Get the title of Login Page

    public String getLoginTitle() {
        return LoginPageTitle.getText().toString();
    }
    
    // This method will be exposed in test case to login
    
    public void loginToGymglish(String strUserName, String strPassword) {
        
        this.setUserName(strUserName);
        this.setPassword(strPassword);
        this.clickLogin();
    }

}
