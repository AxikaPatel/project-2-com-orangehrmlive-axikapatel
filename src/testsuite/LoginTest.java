package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest
{
    String baseURL = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp(){
        openBrowser(baseURL);
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials()
    {
        //Enter  username
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys("Admin");

        //Enter “admin123 password
        WebElement password= driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        // Click on ‘LOGIN’ button
        WebElement loginbutton = driver.findElement(By.xpath("//div[@class='oxd-form-actions orangehrm-login-action']"));
        loginbutton.click();

        String expectedMessage = "Dashboard";

        //Verify the ‘Welcome’ text is display
        WebElement actualTextElement = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
        String actualMessage = actualTextElement.getText();

        //checking actual and expected result
        Assert.assertEquals(actualMessage,expectedMessage);

    }

    @After
    public void teardown(){
        closeBrowser();
    }


}
