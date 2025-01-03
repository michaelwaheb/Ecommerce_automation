package pages;

import base.BasePage;
import Models.LoginData;
import Data.TestData;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class LoginPage extends BasePage
{

    //Locators
    private final By Username = By.id("ap_email");
    private final By Password = By.id("ap_password");
    private final By ContinueButton = By.id("continue");
    private final By SigninButton = By.id("auth-signin-button");
    private LoginData loginData;

//Methods to interact
    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    @Step("Enter username")
    //@Test(dataProvider = "LoginData", dataProviderClass = TestData.class)
    public LoginPage enterusername(String username)
    {
        filldata(Username, username)
                .click(ContinueButton);
        return new LoginPage(driver);
    }
    @Step("Enter password")
    public LoginPage enterpassword(String password)
    {
        filldata(Password,password);
        return new LoginPage(driver);
    }

    @Step("Enter password")
    public LoginPage clicksigninbutton()
    {
        click(SigninButton);
        return new LoginPage(driver);
    }


}
