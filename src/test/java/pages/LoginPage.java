package pages;

import classes.LoginClass;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage  {
    LoginClass base;

    public LoginPage() {
        base =new LoginClass();
        PageFactory.initElements(new AppiumFieldDecorator(base.getDriver()), this);
    }

    @AndroidFindBy  (accessibility = "test-Username") private WebElement userTextField;
    @AndroidFindBy (accessibility = "test-Password") private WebElement passWordField;
    @AndroidFindBy (accessibility = "test-LOGIN") private WebElement loginButton;
    @AndroidFindBy (xpath = "//android.widget.TextView[@text=\"Username and password do not match any user in this service.\"]") private WebElement errText;

    public LoginPage enterUserName(String username){
      base.sendKeys(userTextField, username);
         return this;
    }

    public LoginPage enterPassWord(String password){
        base.sendKeys(passWordField, password);
        return this;
    }

    public ProductPage pressLoginButton(){
         base.click(loginButton);
         return new ProductPage();
    }

    public String getErrText(){
      return  base.getAttribute(errText,"text");
    }

    public ProductPage signin(String usname, String pasword){
        enterUserName(usname);
        enterPassWord(pasword);
        return pressLoginButton();
    }

}
