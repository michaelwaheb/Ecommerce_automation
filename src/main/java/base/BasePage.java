package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import pages.HomePage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BasePage
{
    protected WebDriver driver;

    public BasePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public BasePage click(By locator)
    {
        driver.findElement(locator).click();
        return new BasePage(driver);
    }
    //public BasePage gettext(By locator)
    //{
        //driver.findElement(locator).getText();
        //return new BasePage(driver);
    //}
    public BasePage filldata (By locator,String data)
    {
        driver.findElement(locator).sendKeys(data);
        return new BasePage(driver);
    }



}
