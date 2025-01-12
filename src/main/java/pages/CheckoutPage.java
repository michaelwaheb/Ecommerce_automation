package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    //Locators
    private final By FullName = By.id("address-ui-widgets-enterAddressFullName");
    private final By MobileNumber = By.id("address-ui-widgets-enterAddressPhoneNumber");
    private final By StreetName = By.id("address-ui-widgets-enterAddressLine1");
    private final By BuildingNumber = By.id("address-ui-widgets-enter-building-name-or-number");
    private final By Citytxt = By.id("address-ui-widgets-enterAddressCity");
    //private final By CityDropdowlistchoice = By.id("address-ui-widgets-autoCompleteResult-0");
    private final By Districttxt = By.id("address-ui-widgets-enterAddressDistrictOrCounty");
    private final By Autocompletechoice = By.id("address-ui-widgets-autoCompleteResult-0");
    private final By SaveAddressDetails = By.cssSelector("a-button-input");
    private final By AddNewAddress = By.id("add-new-address-desktop-sasp-tango-link");
    private final By ChangeAddress = By.cssSelector(".a-link-normal.expand-panel-button.celwidget");
    private final By PrimeMessage = By.id("prime-updp-container");
    private final By NoPrime = By.id("prime-interstitial-nothanks-button");

//Methods to interact

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Step("Refuse Prime membership")
    public CheckoutPage noPrimemembership() {
        //Refuse Warranty message
        if (bot.isElementPresent(PrimeMessage)) {
            // Click the "No Thanks" button to dismiss the message
            bot.clickElementUsingJavaScript(NoPrime);
        }
        return new CheckoutPage(driver);
    }

    @Step("Add New Address")
    public CheckoutPage addNewAddress() {
        bot.click(ChangeAddress);
        bot.click(AddNewAddress);

        return new CheckoutPage(driver);
    }
    @Step("Fill Address Form")
    public CheckoutPage fillAddressForm(String fullName,String mobileNumber,String streetName,String buildingNumber,String citytxt,String districttxt)
    {
        bot.filldata(FullName,fullName);
        bot.filldata(MobileNumber,mobileNumber);
        bot.filldata(StreetName,streetName);
        bot.filldata(BuildingNumber,buildingNumber);
        bot.filldata(Citytxt,citytxt);
        bot.clickElementUsingJavaScript(Autocompletechoice);
        bot.filldata(Districttxt,districttxt);
        bot.clickElementUsingJavaScript(Autocompletechoice);

        return new CheckoutPage(driver);
    }
    @Step("Save Address")
    public CheckoutPage saveAddress() {
        bot.click(SaveAddressDetails);
        return new CheckoutPage(driver);
    }


}