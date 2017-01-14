package PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by almogood on 2017-01-10.
 */
public class ListPage {

    WebDriver driver;
     @FindBy(id = "android:id/text1")
    WebElement firstListElement;

    public static final String EXPECTED_LIST_PAGE_FIRST_ITME = "www.gymglish.com";

    public ListPage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    // Get the text of the first item in the list

    public String getListFirstItem() {
        return firstListElement.getText().toString();
    }
}
