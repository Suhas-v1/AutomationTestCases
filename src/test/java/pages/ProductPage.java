package pages;

import classes.LoginClass;
import classes.MenuPage;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends MenuPage {

    LoginClass base;
    public ProductPage() {
        base=new LoginClass();
        PageFactory.initElements(new AppiumFieldDecorator(base.getDriver()), this);
    }

                             //android.widget.TextView[@content-desc="test-Item title" and @text="Sauce Labs Backpack"]
    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView[2]") private WebElement productTitleText;
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"test-Item title\" and @text=\"Sauce Labs Backpack\"]") private WebElement SLBttile;
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"test-Price\" and @text=\"$29.99\"]") private WebElement SLBPrice;


    public String gettitle(){
       return base.getAttribute(productTitleText, "text");
    }

    public String getSLBTitle(){
        return getText(SLBttile);
    }

    public String getSLBPrice(){
        return getText(SLBPrice);
    }


    public ProductDetailsPage pressSLBTitle(){
        click(SLBttile);
        return new ProductDetailsPage();
    }


}
