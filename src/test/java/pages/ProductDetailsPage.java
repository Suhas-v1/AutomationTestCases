package pages;

import classes.LoginClass;
import classes.MenuPage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {

        LoginClass base;
        public ProductDetailsPage() {
            base=new LoginClass();
            PageFactory.initElements(new AppiumFieldDecorator(base.getDriver()), this);
        }


        @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sauce Labs Backpack\"]\n") private WebElement SLBTitle;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.\"]") private WebElement SLBText;
        @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"BACK TO PRODUCTS\"]") private WebElement backToProdBnt;

        public String getSLBTitle(){
            return base.getText(SLBTitle);
        }
        public String getSLBDes(){
            return base.getText(SLBText);
        }

        public ProductPage getProductpage(){
            return new ProductPage();
        }

}
