package tests;

import base.BaseTest;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;
import Data.TestData;
import Models.LoginData;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;

public class AddItemstocartTest extends BaseTest
{
//    @Test
//    public  void openSigninPage()
//    {
//        new pages.HomePage(driver).OpenSigninPage();
//    }
//    @Test(dependsOnMethods = "openSigninPage", dataProvider = "LoginData", dataProviderClass = TestData.class)
//    public  void performLogin(LoginData loginData)
//  {
//      new pages.LoginPage(driver).enterusername(loginData.getUsername())
//              .enterpassword(loginData.getPassword())
//              .clicksigninbutton();
//  }
    @Test
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
        // Perform assertion to make sure that all products is already added to carts
        Assert.assertEquals(actualCartCount, expectedCartCount, "The number of items in the cart does not match the expected count.");
        new pages.HomePage(driver).openCartPage();
        new CartPage(driver).proceedtocheckout();
    }
    @Test(dependsOnMethods = "addItemsToCartAndProceedToCheckout",dataProvider = "AddressData", dataProviderClass = TestData.class)
    public void addNewAddressAndChoosePaymentMethod (String fullName,String mobileNumber,String streetName,String buildingNumber,String citytxt,String districttxt)
    {
        new CheckoutPage(driver)
                .noPrimemembership()
                .addNewAddress()
                .fillAddressForm(fullName,mobileNumber,streetName,buildingNumber,citytxt,districttxt);

    }


}
