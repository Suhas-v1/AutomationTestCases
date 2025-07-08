package tests;

import classes.LoginClass;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.json.JSONObject;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.ProductPage;

import java.io.*;
import java.net.URL;
import java.util.stream.Collectors;

public class LoginTests extends LoginClass {
    LoginPage loginPage;
    ProductPage productPage;
    LoginClass loginClass;
    InputStream datais;
    JSONObject login;

    @BeforeClass
    public void beforeClass() throws IOException {
        loginClass = new LoginClass();
        try {
            URL fileURL = getClass().getClassLoader().getResource("login.json");
            System.out.println("File URL: " + fileURL);

            datais = fileURL.openStream();
            String jsonText = new BufferedReader(new InputStreamReader(datais))
                    .lines().collect(Collectors.joining("\n"));

            // Parse JSON
            login = new JSONObject(jsonText);
        }
        catch (Exception e){
            e.printStackTrace();
            throw e;
        }
        finally {
            if (datais !=null){
                datais.close();
            }
        }
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
    public void invalidUserName() {
        loginPage.enterUserName(login.getJSONObject("invalidUser").getString("username"));
        loginPage.enterPassWord(login.getJSONObject("invalidUser").getString("password"));
        loginPage.pressLoginButton();

        String actualText = loginPage.getErrText();
        String expectedText = stringss.get("err_text_username_passsword");
        System.out.println("----Invalid username Test case started----");
        System.out.println("Actual err text :"+stringss.get("err_text_username_passsword") +"Expected Text :Username and password do not match any user in this service.");

        Assert.assertEquals(actualText, expectedText);
    }
    @Test
    public void invalidpassword(){
        loginPage.enterUserName(login.getJSONObject("invalidPassword").getString("username"));
        loginPage.enterPassWord(login.getJSONObject("invalidPassword").getString("password"));
        loginPage.pressLoginButton();

        String actualText= loginPage.getErrText();
        String expectedText=stringss.get("err_text_username_passsword");

        System.out.println("----Invalid Password Test case started----");
        System.out.println("Actual err text :"+loginPage.getErrText() +"Expected Text : Username and password do not match any user in this service.");

        Assert.assertEquals(actualText, expectedText);
    }

    @Test
    public void productPage(){
        loginPage.enterUserName(login.getJSONObject("validUser").getString("username"));
        loginPage.enterPassWord(login.getJSONObject("validUser").getString("password"));
        productPage= loginPage.pressLoginButton();

        String productactualText=stringss.get("product_title_name");
        String expectedText="PRODUCTS";

        System.out.println("----Product page Test case started----");
       // System.out.println("Actual text :"+productPage.gettitle() +"Expected Text :PRODUCTS ");

        Assert.assertEquals(productactualText, expectedText);
    }

    @Test
    public void productAddToCart(){

    }


}
