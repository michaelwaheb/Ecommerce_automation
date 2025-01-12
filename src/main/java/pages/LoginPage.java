package pages;

import models.LoginData;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage
{

    //Locators
    private final By Username = By.xpath("//input[@id=\"ap_email_login\" and @type=\"email\" and @name=\"email\"]");
    private final By Password = By.xpath("//input[@id=\"ap_password\" and @type=\"password\" and @name=\"password\"]");
    private final By ContinueButton = By.id("continue");
    private final By SigninButton = By.id("auth-signin-button");

//Methods to interact
    public LoginPage(WebDriver driver)
    {
        super(driver);
    }

    @Step("Enter username")

    public LoginPage enterusername(String username)
    {
        bot.filldata(Username, username);
        bot.click(ContinueButton);
        return new LoginPage(driver);
    }
    @Step("Enter password")
    public LoginPage enterpassword(String password)
    {
        bot.filldata(Password,password);
        return new LoginPage(driver);
    }

    @Step("Enter password")
    public LoginPage clicksigninbutton()
    {
        bot.click(SigninButton);
        return new LoginPage(driver);
    }


}
