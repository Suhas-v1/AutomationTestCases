package tests;

import classes.LoginClass;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.ProductPage;

public class LoginTests extends LoginClass {
    LoginPage loginPage;
    ProductPage productPage;
    LoginClass loginClass;


    @BeforeClass
    public void beforeClass(){
        loginClass=new LoginClass();
    }

    @AfterClass
    public void afterClass(){
    }

    @BeforeMethod
    public void beforeMethod(){
        loginPage=new LoginPage();

    }

    @AfterMethod
    public void afterMethod(){
    }

    @Test
    public void invalidUserName(){
        loginPage.enterUserName("invalidusername");
        loginPage.enterPassWord("secret_sauce");
        loginPage.pressLoginButton();

        String actualText= loginPage.getErrText();
        String expectedText="Username and password do not match any user in this service.";

        Assert.assertEquals(actualText, expectedText);
    }
    @Test
    public void invalidpassword(){
        loginPage.enterUserName("standard_user");
        loginPage.enterPassWord("invalidpassword");
        loginPage.pressLoginButton();

        String actualText= loginPage.getErrText();
        String expectedText="Username and password do not match any user in this service.";

        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void productPage(){
        loginPage.enterUserName("standard_user");
        loginPage.enterPassWord("secret_sauce");
        productPage= loginPage.pressLoginButton();

        String productactualText= productPage.gettitle();
        String expectedText="PRODUCTS";

        Assert.assertEquals(productactualText, expectedText);
    }


}
