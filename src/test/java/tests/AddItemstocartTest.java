package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import Data.TestData;
import Models.LoginData;

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
                .OpenleftSideAllMenu()
                .SelectAllVideoGamesCategory();
    }
    @Test(dependsOnMethods = "chooseVideoGamesCategory")
    public void filterAndSortTheResults()
    {
        new pages.HomePage(driver)
                .FilterByFreeShipping()
                .FilterByNewCondition()
                .OpenTheSortMenu()
                .SortByPriceHighToLow();
    }

    @Test(dependsOnMethods = "filterAndSortTheResults")
    public void addToCart()
    {
        new pages.HomePage(driver)
                 .addProductsUnderPriceToCart(15000).OpenCartPage();
    }
    //@Test(dependsOnMethods = "chooseAllVideoGamesCategory")
    //public void chooseAllVideoGamesCategory()
    //{
      //  new pages.HomePage(driver).OpenleftsideAllmenu().selectallvideogamescategory();
    //}
//    AllureLifecycle lifecycle = Allure.getLifecycle();
//
//    //Test case to validate lite package with price and currency for three countries
//    @Test  (dataProvider = "LiteSubscriptionData", dataProviderClass = TestData.class)
//    @Story("Validate lite package for countries")
//    @Parameters({"expected country name", "countryid","Expected package type","price","currency"})
//    public  void Validatelitepackageforcountries(String expectedcountryname,String countryid,String Expectedpackagetype,String price,String currency)
//    {
//    //change test names
//        lifecycle.updateTestCase(testResult -> testResult.setName("Validate lite package for " + expectedcountryname));
//
//    new pages.HomePage(driver)
//            .clickenglishlanguagebutton()
//            .opencountriespopup()
//            .selectcountry(countryid)
//            .checklitepackagedetailsforcountries(expectedcountryname,Expectedpackagetype,price,currency);
//    }
//
//    //Test case to validate classic package with price and currency for three countries
//    @Test (dataProvider = "ClassicSubscriptionData", dataProviderClass = TestData.class)
//    @Story("Validate classic package for countries")
//    @Parameters({"expected country name", "countryid","Expected package type","price","currency"})
//    public  void Validateclassicpackageforcountries(String expectedcountryname,String countryid,String Expectedpackagetype,String price,String currency)
//    {
//        //change tests names
//        lifecycle.updateTestCase(testResult -> testResult.setName("Validate classic package for " + expectedcountryname));
//
//
//        new pages.HomePage(driver)
//                .clickenglishlanguagebutton()
//                .opencountriespopup()
//                .selectcountry(countryid)
//                .checkclassicpackagedetailsforcountries(expectedcountryname,Expectedpackagetype,price,currency);
//    }
//
//    //Test case to validate premium package with price and currency for three countries
//    @Test (dataProvider = "PremiumSubscriptionData", dataProviderClass = TestData.class)
//    @Story("Validate premium package for countries")
//    @Parameters({"expected country name", "countryid","Expected package type","price","currency"})
//    public  void ValidatePremiumpackageforcountries(String expectedcountryname,String countryid,String Expectedpackagetype,String price,String currency)
//    {
//        //change tests names
//        lifecycle.updateTestCase(testResult -> testResult.setName("Validate premium package for " + expectedcountryname));
//
//        new pages.HomePage(driver)
//                .clickenglishlanguagebutton()
//                .opencountriespopup()
//                .selectcountry(countryid)
//                .checkPremiumpackagedetailsforcountries(expectedcountryname,Expectedpackagetype,price,currency);
//    }

}
