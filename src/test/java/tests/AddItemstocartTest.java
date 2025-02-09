package tests;

import io.qameta.allure.Allure;
import models.LoginData;
import models.AddressData;
import org.testng.Assert;
import org.testng.annotations.Test;
import resources.TestData;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;

public class AddItemstocartTest extends BaseTest
{
    @Test(dataProvider = "LoginData", dataProviderClass = TestData.class)
    public  void signIn(LoginData loginData)
  {
      new pages.HomePage(driver).openSigninPage();
      new pages.LoginPage(driver).enterusername(loginData.getUsername())
              .enterpassword(loginData.getPassword())
              .clicksigninbutton();
  }
    @Test(dependsOnMethods = "signIn")
    public void chooseVideoGamesCategory()
    {
        new pages.HomePage(driver)
                .openleftSideAllMenu()
                .selectAllVideoGamesCategory();
    }
    @Test(dependsOnMethods = "chooseVideoGamesCategory")
    public void filterAndSortTheResults()
    {
        new pages.HomePage(driver)
                .filterByFreeShipping()
                .filterByNewCondition()
                .openTheSortMenu()
                .sortByPriceHighToLow();
    }

    @Test(dependsOnMethods = "filterAndSortTheResults")
    public void addItemsToCartAndProceedToCheckout()
    {
        HomePage homePage = new HomePage(driver);
        CartPage cart = new CartPage(driver);
        int expectedCartCount = homePage.addProductsUnderPriceToCart(15000);
        driver.navigate().refresh();
        int actualCartCount = cart.actualCartCount();
        Allure.step("Assertion to make sure that all products is already added to carts");
        Assert.assertEquals(actualCartCount, expectedCartCount, "The number of items in the cart does not match the expected count.");
        homePage.openCartPage();
        cart.proceedtocheckout();
    }
    @Test(dependsOnMethods = "addItemsToCartAndProceedToCheckout",dataProvider = "AddressData", dataProviderClass = TestData.class)
    public void addNewAddressAndChoosePaymentMethod (AddressData addressData)
    {
        new CheckoutPage(driver)
                .addNewAddress()
                .fillAddressForm(
                        addressData.getFullName(),
                        addressData.getMobileNumber(),
                        addressData.getStreetName(),
                        addressData.getBuildingNumber(),
                        addressData.getCityTxt(),
                        addressData.getDistrictTxt())
                .saveAddress()
                .chooseCashPaymentMethod();

    }


}
