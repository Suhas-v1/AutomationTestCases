package classes;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import pages.SettingPage;

public class MenuPage  extends LoginClass {
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView")
    private WebElement settingIcon;


    public SettingPage pressSettingBtn() {
        click(settingIcon);
        return new SettingPage();
    }
}
