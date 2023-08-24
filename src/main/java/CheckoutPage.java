import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@id='shopping_cart_container']")
    private WebElement checkOut;

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkOutInformation;

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement postalCodeField;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private WebElement productNames;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private WebElement productPrices;

    @FindBy(xpath = "//div[@class='summary_value_label' and text()='SauceCard #31337']")
    private WebElement orderCompleteLabel;

    @FindBy(xpath = "//button[@id='finish']")
    private WebElement finishButton;

    @FindBy(xpath = "//h2[@class='complete-header']")
    private WebElement completeHeader;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isCheckoutPageLoaded() {
        return checkOut.isDisplayed();
    }

    public boolean isCheckoutFinishLoaded() {
        return completeHeader.isDisplayed();
    }

    public void checkOut() {
        checkOut.click();
    }

    public void checkOutInformation() {
        checkOutInformation.click();
    }

    public void finish() { finishButton.click(); }

    public void enterShippingDetails(String firstName, String lastName, String postalCode) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        postalCodeField.sendKeys(postalCode);
        continueButton.click();
    }

    public boolean verifyOrderStatus(String productName, double productPrice) {
        // Perform condition to verify order status
        String priceText = productPrices.getText().replace("$", "");
        return productName.equals(productNames.getText()) && Double.toString(productPrice).equals(priceText) && orderCompleteLabel.isDisplayed();
    }
}
