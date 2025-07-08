package pages;

import classes.LoginClass;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SettingPage extends LoginClass {
    LoginClass base;

    public SettingPage() {
        base =new LoginClass();
        PageFactory.initElements(new AppiumFieldDecorator(base.getDriver()), this);
    }
    @AndroidFindBy(accessibility = "test-LOGOUT") private WebElement logoutBtn;


    public LoginPage pressSettingBtn() {
        click(logoutBtn);
        return new LoginPage();
    }

}
