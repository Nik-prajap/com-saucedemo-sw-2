package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowserForSetUp(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() throws InterruptedException {

        driver.findElement(By.id("user-name")).sendKeys("standard_user");   // enter username in Username Field
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys("secret_sauce");  // enter password in Password Field
        Thread.sleep(2000);
        driver.findElement(By.id("login-button")).click();  // Click on login Button
        Thread.sleep(2000);

        // Verify the text "PRODUCTS"
        String expectedText = "Products";
        WebElement actualText = driver.findElement(By.className("title"));
        String actualTest = actualText.getText();
        Assert.assertEquals(expectedText,actualTest);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() throws InterruptedException {

        driver.findElement(By.id("user-name")).sendKeys("standard_user");   // enter username in UserName field
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys("secret_sauce");  // enter password in Password field
        Thread.sleep(2000);
        driver.findElement(By.name("login-button")).click();  // click on login button
        Thread.sleep(2000);

        // verify that six products are displayed on page
        List<WebElement> productsDisplayed =  driver.findElements(By.xpath("//div[@class='inventory_list']"));
        int number = productsDisplayed.size();
        Assert.assertTrue("Expected number of products displayed here is 6" , true);

    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
