package pages;

import classes.LoginClass;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginPage extends LoginClass {
    @AndroidFindBy  (accessibility = "test-Username") private WebElement userTextField;
    @AndroidFindBy (accessibility = "test-Password") private WebElement passWordField;
    @AndroidFindBy (accessibility = "test-LOGIN") private WebElement loginButton;
    @AndroidFindBy (xpath = "//android.widget.TextView[@text=\"Username and password do not match any user in this service.\"]") private WebElement errText;

    public LoginPage enterUserName(String username){
         sendKeys(userTextField, username);
         return this;
    }

    public LoginPage enterPassWord(String password){
        sendKeys(passWordField, password);
        return this;
    }

    public ProductPage pressLoginButton(){
         click(loginButton);
         return new ProductPage();
    }

    public String getErrText(){
      return  getAttribute(errText,"text");
    }

}
