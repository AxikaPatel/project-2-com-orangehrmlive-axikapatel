package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest
{
    String baseURL = " https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp()
    {
        openBrowser(baseURL);
    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully()
    {
        //click on the ‘Forgot your password’ link
        WebElement ForgotPassword = driver.findElement(By.xpath("//p[text()='Forgot your password? ']"));
        ForgotPassword.click();

        String expectedMessage = "Reset Password";

        // Verify the text ‘Forgot Your Password?’
        WebElement actualTextElement = driver.findElement(By.xpath("//h6[text()='Reset Password']"));
        String actualMessage = actualTextElement.getText();

        //Checking actual and expected result
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @After
    public void tearDown()
    {
        closeBrowser();
    }

}
