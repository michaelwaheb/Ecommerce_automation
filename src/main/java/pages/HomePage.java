package pages;
import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class HomePage extends BasePage {

    //Locators
    private final By SigninPage = By.id("nav-link-accountList");
    private final By Allmenu = By.id("nav-hamburger-menu");
    private final By ExpandCategorylist = By.cssSelector(".hmenu-item.hmenu-compressed-btn");
    private final By VideoGamesCategory = By.xpath("//a[@class=\"hmenu-item\" and @data-menu-id=\"16\"]/div[text()=\"Video Games\"]");
    private final By AllVideoGames = By.xpath("//a[@class=\"hmenu-item\" and text()=\"All Video Games\"]");
    private final By FreeShippingCheck = By.cssSelector(".a-icon.a-icon-checkbox");
    private final By NewCondition = By.xpath("//span[@class=\"a-size-base a-color-base\" and text()=\"New\"]");
    private final By SortMenu = By.xpath("//span[@class=\"a-dropdown-label\" and text()=\"Sort by:\"]");
    private final By SortByPriceHighToLow = By.id("s-result-sort-select_2");
    private final By ProductPrice = By.xpath("//div[@class='sg-col-20-of-24 s-result-item s-asin sg-col-0-of-12 sg-col-16-of-20 sg-col s-widget-spacing-small sg-col-12-of-16']//span[@class='a-price-whole']");
    private final By AddToCartButton = By.id("add-to-cart-button");
    private final By WarrantyMessage = By.id("attach-warranty-header");
    private final By NoWarranty = By.id("attachSiNoCoverage");
    private final By cart = By.id("nav-cart-count-container");

//Methods to interact

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Sign in Page")
    public HomePage OpenSigninPage() {
        click(SigninPage);
        return new HomePage(driver);
    }

    @Step("Open cart Page")
    public HomePage OpenCartPage() {
        click(cart);
        return new HomePage(driver);
    }

    @Step("Open left side All menu")
    public HomePage OpenleftSideAllMenu() {
        click(Allmenu);
        return new HomePage(driver);
    }

    @Step("Select all Video Games Category")
    public HomePage SelectAllVideoGamesCategory() {

        click(ExpandCategorylist);
        click(VideoGamesCategory);
        clickElementUsingJavaScript(AllVideoGames);
        return new HomePage(driver);
    }

    @Step("Filter By free shipping ")
    public HomePage FilterByFreeShipping() {
        click(FreeShippingCheck);
        return new HomePage(driver);
    }

    @Step("Filter By new condition")
    public HomePage FilterByNewCondition() {
        clickElementUsingJavaScript(NewCondition);
        return new HomePage(driver);
    }

    @Step("open the sort menu")
    public HomePage OpenTheSortMenu() {
        clickElementUsingJavaScript(SortMenu);
        return new HomePage(driver);
    }

    @Step("sort by price high to low")
    public HomePage SortByPriceHighToLow() {
        clickElementUsingJavaScript(SortByPriceHighToLow);
        return new HomePage(driver);
    }

    @Step("Add products priced under a specified amount to the cart")
    public HomePage addProductsUnderPriceToCart(int maxPrice) {


        List<WebElement> prices = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ProductPrice));

        //Loop through prices, check condition, and add to cart if condition is met
        for (int i = 0; i < prices.size(); i++) {
            WebElement itemPrice = prices.get(i);
            String priceText = itemPrice.getText().replaceAll("[^0-9]", ""); // Remove any non-numeric characters
            double price = Double.parseDouble(priceText);
            if (price < maxPrice) {
                itemPrice.click(); // Click the product
                //clickElementUsingJavaScript(AddToCartButton);// Add to cart
                click(AddToCartButton);
                //addToCartButton.click();
                if (isElementPresent(WarrantyMessage))
                {
                    clickElementUsingJavaScript(NoWarranty);// Click the "No Thanks" button to dismiss the message
                }
                simpleWait(1);
                // Navigate back to the results page by clicking back twice
                driver.navigate().back();
                simpleWait(1);
                driver.navigate().back();

                // Refresh the list of price elements after navigating back
                prices = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ProductPrice));
            }
        }

        return this;
    }
}
