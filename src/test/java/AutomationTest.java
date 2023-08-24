import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AutomationTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CheckoutPage checkoutPage;

    @BeforeTest
    public void setup() {
        // Set up ChromeDriver Path
        System.setProperty("webdriver.chrome.driver","path/to/chromedriver");

        // Initialize ChromeDriver Instance
        driver = new ChromeDriver();

        // Initialize Page Objects
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        checkoutPage = new CheckoutPage(driver);

        // Open the URL
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void loginAndPurchaseTest() {
        // login using valid credentials
        loginPage.login("standard_user", "secret_sauce");

        // Verify successful login
        Assert.assertTrue(productsPage.isLoggedIn(), "Login is successful.");

        // Sort products by highest price
        productsPage.sortByHighestPrice();

        // Verify products are sorted correctly
        Assert.assertTrue(productsPage.isSortedByHighestPrice(),"Products are sorted by highest price.");

        // Select and open first product
        String productName = productsPage.getProductName();
        double productPrice = productsPage.getProductPrice();
        productsPage.selectFirstProduct();

        // Buy the product
        productsPage.buyProduct();

        // Checkout the product
        checkoutPage.checkOut();

        // Verify successful checkout
        Assert.assertTrue(checkoutPage.isCheckoutPageLoaded(), "Checkout page is loaded.");

        // Verify and enter required details on Checkout page
        checkoutPage.checkOutInformation();
        checkoutPage.enterShippingDetails("Name", "Address", "Zip");

        // Verify the order status and capture the screen
        boolean orderStatus = checkoutPage.verifyOrderStatus(productName, productPrice);
        Utils.captureScreenshot(driver, "order_status");

        // Assert the order status
        Assert.assertTrue(orderStatus, "Order is successfully completed.");
        checkoutPage.finish();

        // Verify successful complete order
        Assert.assertTrue(checkoutPage.isCheckoutFinishLoaded(), "Order is successfully completed.");
        Utils.captureScreenshot(driver, "order_complete");

    }

    @AfterTest
    public void teardown(){
        // Close the browser
        driver.quit();
    }
}
