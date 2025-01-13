package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CartPage extends BasePage
{

    //Locators
    private final By Cartcontainer = By.id("nav-cart-count");
    private final By Proceedtobuy = By.id("sc-buy-box-ptc-button");
    private final By PrimeMessage = By.id("prime-updp-container");
    private final By NoPrime = By.id("prime-interstitial-nothanks-button");


//Methods to interact
    public CartPage(WebDriver driver)
    {
        super(driver);
    }

    public int actualCartCount() {
        // Get the text of the cart container which should have the cart count
        String cartCountText = bot.gettext(Cartcontainer);

        // Parse the text to an integer
        int cartCount = Integer.parseInt(cartCountText);

        // Return the cart count
        return cartCount;
    }
    @Step("Proceed to buy")
    public CartPage proceedtocheckout() {
        bot.click(Proceedtobuy);
        //Refuse Prime membership if exist
        if (bot.isElementPresent(PrimeMessage)) {
            // Click the "No Thanks" button to dismiss the message
            bot.clickElementUsingJavaScript(NoPrime);
        }
        return new CartPage(driver);
    }



}
