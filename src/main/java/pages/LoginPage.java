package pages;

import base.BasePage;
import Models.LoginData;
import Data.TestData;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LoginPage extends BasePage
{

    //Locators
    private final By Username = By.id("ap_email");
    private final By Password = By.id("ap_password");
    private final By ContinueButton = By.id("continue");
    private final By SigninButton = By.id("auth-signin-button");
    private final By Litepricecurrency = By.id("currency-lite");
    private LoginData loginData;

//Methods to interact
    public LoginPage(WebDriver driver)
    {
        super(driver);
    }
    @Step("Select English as site language")
    public LoginPage clickenglishlanguagebutton()
    {
        if (gettext(language).equals("English"))
        {
            click(language);
        }
        return new LoginPage(driver);
    }

    @Step(dataProvider = "LoginData", dataProviderClass = TestData.class)
    public void Logintest()
    {
        filldata(Username, loginData.getUsername())
                .click(ContinueButton)
                .filldata(Password,loginData.getPassword())
                .click(SigninButton);
    }

    @Step("Login")
    public LoginPage login()
    {

        Logintest();
        return new LoginPage(driver);
    }

    @Step ("check lite package details for country")
    public LoginPage checklitepackagedetailsforcountries(String Expectedcountryname, String Expectedpackagetype, String price, String currency)
    {
        Allure.step("Validate country name");
        //Validate country name
        Assert.assertEquals (gettext(countryname),Expectedcountryname);
        Allure.step("Validate Package type");
        //Validate Package type
        Assert.assertEquals(gettext(Litepackage),Expectedpackagetype);
        Allure.step("Validate Package price & currency");
        //Validate Package price & currency
        Assert.assertEquals(gettext(Litepricecurrency),price +" "+ currency + "/month");
        return new LoginPage(driver);
    }

}
