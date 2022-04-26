package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Find username field and sending valid username

        sendTextToElement(By.xpath("//input[@name='username']"), "vitton@ymail.com");

        //Find password field and sending valid password

        sendTextToElement(By.xpath("//input[@name='password']"), "123456");

        //Find login button and click on it
        clickOnElement(By.xpath("//input[@value='Log In']"));

        //This is from requirement
        String expectedMessage = "Accounts Overview";

        //actual message
        String actualMessage = getTextFromElement(By.xpath("//h1[text()='Accounts Overview']"));

        Assert.assertEquals("Not navigate to login page",expectedMessage, actualMessage);
    }
    @Test
    public void verifyTheErrorMessage(){
        //Find username field and sending invalid username
        sendTextToElement(By.xpath("//input[@name='username']"), "ram@gmail.com");

        //Find password field and sending invalid password
        sendTextToElement(By.xpath("//input[@name='password']"), "123");

        //Find login button and click on it
        clickOnElement(By.xpath("//input[@value='Log In']"));

        //This is from requirement
        String expectedMessage = "The username and password could not be verified.";

        //actual message
//
        String actualMessage = getTextFromElement(By.xpath("//p[text()='The username and password could not be verified.']"));

        Assert.assertEquals("Not navigate to login page",expectedMessage, actualMessage);
    }
    @Test
    public void userShouldLogOutSuccessfully(){
        //Find username field and sending valid username

        sendTextToElement(By.xpath("//input[@name='username']"), "vitton@ymail.com");

        //Find password field and sending valid password

        sendTextToElement(By.xpath("//input[@name='password']"), "123456");

        //Find login button and click on it
        clickOnElement(By.xpath("//input[@value='Log In']"));

        //Find logout button and click on it
        clickOnElement(By.xpath("//a[text()='Log Out']"));

        //This is from requirement
        String expectedMessage = "Customer Login";

        //actual message
        String actualMessage = getTextFromElement(By.xpath("//div[@id='leftPanel']//h2[text()='Customer Login']"));

        Assert.assertEquals("Not navigate to login page",expectedMessage, actualMessage);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
