package pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CartPage extends BasePage
{

    //Locators
    private final By Cartcontainer = By.id("nav-cart-count");
    private final By Proceedtobuy = By.id("sc-buy-box-ptc-button");

//Methods to interact
    public CartPage(WebDriver driver)
    {
        super(driver);
    }

    public int actualCartCount() {
        // Get the text of the cart container which should have the cart count
        String cartCountText = gettext(Cartcontainer);

        // Parse the text to an integer
        int cartCount = Integer.parseInt(cartCountText);

        // Return the cart count
        return cartCount;
    }
    @Step("Proceed to buy")
    public CartPage proceedtocheckout() {
        clickElementUsingJavaScript(Proceedtobuy);
        return new CartPage(driver);
    }


}
