import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;



public class TestCase1 {

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

        /* Enter the email address for a new user which will be created by this test.
           Users have no names on this page, they are identified only by email address.

           Note that this is a public site, and people from all over the world can connect there, so it is possible
           that the email address entered for the test has already been created by somebody else (or possibly by
           one of our previous tests). In this case it is needed to choose another email address and hope that user
           with such an address has not been created on the automationpractice.com web page yet.
        */
        driver.findElement(By.id("email_create")).sendKeys("xmfy32@testmail.com");

        /* Click on the "Create account" button, which is denoted by "SubmitCreate" identifier
          (identifier of a particular web element can be obtained by using "Inspect element" command in the browser.
        */
        driver.findElement(By.id("SubmitCreate")).click();
        Thread.sleep(5000);


        /* Enter the created user's data.
           For purpose of this test, we will register a fictional person named John Peter Smith, born 7th March 1983,
           living in Chicago, Illinois, United States, at 32 Blue Street, on 3rd floor, and working for a company
           named "J&S Technologies Inc.".
        */

        /* This part of the test code corresponds to the "Your personal information" data. */
        driver.findElement(By.id("id_gender1")).click(); /* id_gender1 = 'Mr.', id_gender2 = 'Mrs.' */
        driver.findElement(By.id("customer_firstname")).sendKeys("John Peter");
        driver.findElement(By.id("customer_lastname")).sendKeys("Smith");

        /* According to rules of password creation on the automationpractice.com web page, the user's password must be
           at least 5 characters long (and it is the only constraint).
        */
        driver.findElement(By.id("passwd")).sendKeys("aBc88");

        /* Set the date of birth = 7th March 1983 */
        Select days = new Select(driver.findElement(By.id("days")));
        Select months = new Select(driver.findElement(By.id("months")));
        Select years = new Select(driver.findElement(By.id("years")));

        days.selectByValue("7");
        months.selectByIndex(3);
        years.selectByValue("1983");

        /* Test the "Sign up for our newsletter!" and "Receive special offers from our partners!" clickable fields.
           They are not compulsory, but our test will check them anyway.
        */
        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("optin")).click();


        /* This part of the test code corresponds to "Your address" window, where we will fill out the data now. */

        driver.findElement(By.id("company")).sendKeys("J&S Technologies Inc.");
        driver.findElement(By.id("address1")).sendKeys("32 Blue Street");
        driver.findElement(By.id("address2")).sendKeys("3rd floor");
        driver.findElement(By.id("city")).sendKeys("Chicago");
        driver.findElement(By.id("postcode")).sendKeys("12345");
        driver.findElement(By.id("other")).sendKeys("I am a new user.");
        driver.findElement(By.id("phone")).sendKeys("123456789");
        driver.findElement(By.id("phone_mobile")).sendKeys("234567890");

        /* Country and state are of selector type, like the date of birth */
        Select country = new Select(driver.findElement(By.id("id_country")));
        Select state = new Select(driver.findElement(By.id("id_state")));

        country.selectByVisibleText("United States");
        state.selectByVisibleText("Illinois");

        /* Finally, click on the registration button. to finish the user registration operation. */
        driver.findElement(By.id("submitAccount")).click();
        Thread.sleep(5000);

        /* Check the expected results. In case of user registration on the automationpractice.com site, a newly
           registered user is automatically logged on.
           So we will check that a web element, which denotes that the user is logged, is visible and it contains the
           "John Peter Smith" string.
         */
        boolean userIsLogged = driver.findElement(By.cssSelector("[title=\"View my customer account\"]")).isDisplayed();
        String loggedUserName = driver.findElement(By.cssSelector("[title=\"View my customer account\"]")).getText();

        Assert.assertTrue(userIsLogged);
        Assert.assertEquals("John Peter Smith",loggedUserName);

        /* If everything goes well - the actual results of the test match the expected ones, and no error occurred,
           the information that "Process finished with exit code 0" will appear in the debug window below.

           To prove that this test works well, you can change the expected data values and then re-run the test
           (remembering to change the email - because, if the user registration from previous
           test run was successful, user with this email already exists and an error will be raised before even
           reaching the form with user's data).
           For example, if you change the expected user's name to "John Paul Smith", the following message will
           appear in the debug window below:

           org.junit.ComparisonFailure:
           Expected :John Paul Smith
           Actual   :John Peter Smith
           <Click to see difference>
         */
    }

    @After
    public void Teardown() {
        driver.quit();
    }
}

