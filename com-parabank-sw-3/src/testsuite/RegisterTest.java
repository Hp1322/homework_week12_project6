package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class RegisterTest extends Utility {
    String baseUrl = "https://parabank.parasoft.com/parabank/index.htm";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void verifyThatSigningUpPageDisplay(){
        //Find register link and click on it
        clickOnElement(By.xpath("//a[text()='Register']"));
        //This is from requirement
        String expectedMessage = "Signing up is easy!";

        //actualmessage
        String actualMessage = getTextFromElement(By.xpath("//h1[text()='Signing up is easy!']"));

        Assert.assertEquals("not able to navigate register page", expectedMessage, actualMessage);

    }
   @Test
    public void userSholdRegisterAccountSuccessfully(){
       //Find register link and click on it
       clickOnElement(By.xpath("//a[text()='Register']"));
       //Find firstname field element
//       firstName.sendKeys("hello");
       sendTextToElement(By.xpath("//input[@name='customer.firstName']"), "hello");

       //Find last name field element and sending lastname
       sendTextToElement(By.xpath("//input[@name='customer.lastName']"), "good");

       //Find address field element and sending address
       sendTextToElement(By.xpath("//input[@id='customer.address.street']"), "morning");

       //Find city field element and sending city name
       sendTextToElement(By.xpath("//input[@id='customer.address.city']"), "welcome");

       //Find state field element and sending state name
      sendTextToElement(By.xpath("//input[@id='customer.address.state']"), "great");

       //Find Zip code field element and sending zip code
       sendTextToElement(By.xpath("//input[@id='customer.address.zipCode']"), "done");

       //Find phone field element and sending phone numeber
       sendTextToElement(By.xpath("//input[@name='customer.phoneNumber']"), "123456");

       //Find SSN field element and sending ssn numeber
       sendTextToElement(By.xpath("//input[@name='customer.ssn']"), "88");

       //Find username field element and sending user name
       sendTextToElement(By.xpath("//input[@name='customer.username']"), "vitton@ymail.com");

       //Find password field element and sending password
       sendTextToElement(By.xpath("//input[@name='customer.password']"), "123456");

       //Find confirm field element and sending confirm password
       sendTextToElement(By.xpath("//input[@name='repeatedPassword']"), "123456");

       //Find register button and click on it
       clickOnElement(By.xpath("//input[@value='Register']"));

       //This is from requirement
       String expectedMessage = "Your account was created successfully. You are now logged in.";

       //actualmessage
       String actualMessage = getTextFromElement(By.xpath("//p[contains(text(),'Your account was created successfully. You are now')]"));

       Assert.assertEquals("not able to navigate register page", expectedMessage, actualMessage);
   }
   @After
    public void tearDown(){
        closeBrowser();
   }
}
