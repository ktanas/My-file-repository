import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;



public class TestCase2 {

    FirefoxDriver driver;

    @Before
    public void Setup() {

        /* Initialization of Mozilla Firefox driver used for our automated test. If you prefer to use Google Chrome,
           it is possible to initialize ChromeDriver instead.

           In the line below, enter the path to the driver file on your computer.
        */
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\My_Windows_Username\\automated_tests\\My_Project\\src\\test\\java\\geckodriver.exe");
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        /* The automationpractice.com web page will be used for our automated tests. */
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void RunTest() throws InterruptedException {
        /* InterruptedException is needed do handle the 'sleep' calls, which make the program wait for a
           specific time after clicking on a button which moves to another page or executes some other important
           action. It is necessary to give time for the specific action to finish its process.
        */

        /* Find the "Sign in" button on the automationpractice.com page and click it */
        driver.findElement(By.cssSelector("[title=\"Log in to your customer account\"]")).click();
        Thread.sleep(5000);

        /* For this test case, enter a mail address which is already registered on automationpractice.com.
           Either run TestCase1 successfully, or create an user with the given email address manually on the
           automationpractice.com test page before running TestCase2.
        */
        driver.findElement(By.id("email_create")).sendKeys("xmfy32@testmail.com");


        /* Click on the "Create account" button, which is denoted by "SubmitCreate" identifier
          (identifier of a particular web element can be obtained by using "Inspect element" command in the browser).
        */
        driver.findElement(By.id("SubmitCreate")).click();
        Thread.sleep(5000);


        /* Verify that an error occurred and an alert message was generated. Check if the message which actually
           appeared is equal to the expected one.

           Like TestCase1, you can change the expected result and see that a comparison error will appear then.
        */
        boolean AlertIsDisplayed = driver.findElement(By.className("alert")).isDisplayed();
        String AlertMessage = driver.findElement(By.className("alert")).getText();

        Assert.assertTrue(AlertIsDisplayed);
        Assert.assertEquals("An account using this email address has already been registered. Please enter a valid password or request a new one.",AlertMessage);
    }

    @After
    public void Teardown() {
        driver.quit();
    }
}

