package tests;

import classes.LoginClass;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.ProductPage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

public class ProductTests extends LoginClass{
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
        SoftAssert sa=new SoftAssert();

       productPage= loginPage.signin(login.getJSONObject("validUser").getString("username")  , login.getJSONObject("validUser").getString("password"));
       String slbTitle=productPage.getSLBTitle();
        System.out.println(slbTitle);
       sa.assertEquals(slbTitle,stringss.get("product_page_slb_title_name"));

       String slbPrice= productPage.getSLBPrice();
        System.out.println(slbPrice);
       sa.assertEquals(slbPrice,stringss.get("product_page_slb_price"));

        productPage.pressSLBTitle();

    }
}
