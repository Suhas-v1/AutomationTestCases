package classes;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utilies.TestUtilies;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class LoginClass {
    protected static AppiumDriver driver;
    protected static Properties pros;
    private WebDriverWait wait;
    InputStream inputstream;

    public LoginClass(){

    }

    public void setDriver(AppiumDriver driverInstance){
        driver=driverInstance;
    }

    public void initElements(){
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }





    @Test
    public void runTest() {
        System.out.println();
    }

    //@Parameters({"platform", "deviceName", "automationName"})String platform, String deviceName, String automationName
    @BeforeClass
    public void beforeTest() throws IOException {
        try {
            pros = new Properties();
            String congFile = "/configuration.properties";
            inputstream = getClass().getResourceAsStream(congFile);
            pros.load(inputstream);

            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability("appium:automationName", pros.getProperty("androidAutomationName"));
            capabilities.setCapability("appium:deviceName", pros.getProperty("androidDeviceName"));
            capabilities.setCapability("appium:platform", pros.getProperty("platformName"));
            capabilities.setCapability("appium:appActivity", pros.getProperty("appActivity"));

            URL url = new URL("http://localhost:4723/wd/hub");

            driver = new AndroidDriver(url, capabilities);
            String sessionId = driver.getSessionId().toString();
            System.out.println(sessionId);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

    public void waitForVisibility(WebElement e) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtilies.Wait));
        wait.until(ExpectedConditions.visibilityOf(e));
    }

    public void click(WebElement e){
        waitForVisibility(e);
        e.click();
    }
    public void sendKeys(WebElement e, String text){
        waitForVisibility(e);
        e.sendKeys(text);
    }

    public String getAttribute(WebElement e , String attributes){
        waitForVisibility(e);
       return e.getAttribute(attributes);

    }
    @AfterTest
    public void afterTest(){

    }


    }


