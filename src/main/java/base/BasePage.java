package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public abstract class BasePage
{
    protected WebDriver driver;
    public WebDriverWait wait ;

    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));

    }

    public void click(By locator)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).click();
    }

    public WebElement waitForElementToBeClickable(By locator)
    {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void clickElementUsingJavaScript(By locator)
    {
        WebElement element = waitForElementToBeClickable(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
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
