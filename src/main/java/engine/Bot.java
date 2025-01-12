package engine;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.WebDriver;

public class Bot
{
    private final WebDriver driver;
    private final Wait<WebDriver> wait;
    public Bot(WebDriver driver, Wait<WebDriver> wait)
    {
        this.driver = driver;
        this.wait = wait;
    }

    public void click(By locator)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).click();
    }

    //public WebElement waitForElementToBeClickable(By locator)
    //{
    //  return wait.until(ExpectedConditions.elementToBeClickable(locator));
    //}
    public void clickElementUsingJavaScript(By locator)
    {
        WebElement elemnet = wait.until(ExpectedConditions.elementToBeClickable(locator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", elemnet);
    }
    public String gettext(By locator)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).getText();


    }
    public void filldata (By locator,String data)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(data);
    }

    public boolean isElementPresent(By locator) {
        try
        {
            driver.findElement(locator);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    public void simpleWait(int waitTimeInSeconds) {
        try {
            Thread.sleep(waitTimeInSeconds * 1000); // Convert seconds to milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
