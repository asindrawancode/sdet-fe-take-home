import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductsPage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@class='app_logo']")
    private WebElement welcomeMessage;
    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private List<WebElement> productNames;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private List<WebElement> productPrices;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement sortByDropdown;

    @FindBy(xpath = "//button[contains(text(), 'Add to cart')]")
    private WebElement addToCartButton;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isLoggedIn() {
        return welcomeMessage.isDisplayed();
    }

    public void sortByHighestPrice() {
        Select sortDropdown = new Select(sortByDropdown);
        sortDropdown.selectByValue("hilo");
    }

    public boolean isSortedByHighestPrice() {
        List<Double> prices = new ArrayList<>();
        for (WebElement priceElement : productPrices) {
            String priceText = priceElement.getText().replace("$", "");
            double price = Double.parseDouble(priceText);
            prices.add(price);
        }
        List<Double> sortedPrices = new ArrayList<>(prices);
        Collections.sort(sortedPrices, Collections.reverseOrder());
        return prices.equals(sortedPrices);
    }

    public void selectFirstProduct() { productNames.get(0).click(); }

    public String getProductName() {return productNames.get(0).getText(); }

    public double getProductPrice () {
        String priceText = productPrices.get(0).getText().replace("$", "");
        return Double.parseDouble(priceText);
    }

    public void buyProduct() { addToCartButton.click(); }







}
