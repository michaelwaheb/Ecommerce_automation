package pages;
import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.Step;


public class HomePage extends BasePage
{

    //Locators
    private final By SigninPage = By.id("nav-link-accountList");
    private final By Allmenu = By.id("nav-hamburger-menu");
    private final By ExpandCategorylist = By.cssSelector(".hmenu-item.hmenu-compressed-btn");
    private final By VideoGamesCategory = By.xpath("//a[@class=\"hmenu-item\" and @data-menu-id=\"16\"]/div[text()=\"Video Games\"]");
    private final By AllVideoGames = By.xpath("//a[@class=\"hmenu-item\" and text()=\"All Video Games\"]");
    private final By FreeShippingCheck = By.cssSelector(".a-icon.a-icon-checkbox");
    private final By NewCondition = By.xpath("//span[@class=\"a-size-base a-color-base\" and text()=\"New\"]");
    private final By SortMenu = By.xpath("//span[@class=\"a-dropdown-label\" and text()=\"Sort by:\"]");
    private final By SortByPriceHighToLow = By.id("s-result-sort-select_2");


//Methods to interact

    public HomePage(WebDriver driver)
    {
        super(driver);
    }

    @Step("Open Sign in Page")
    public HomePage OpenSigninPage()
    {
        click(SigninPage);
        return new HomePage(driver);
    }

    @Step("Open left side All menu")
    public HomePage OpenleftSideAllMenu()
    {
        click(Allmenu);
        return new HomePage(driver);
    }
    @Step("Select all Video Games Category")
    public HomePage SelectAllVideoGamesCategory()
    {

        click(ExpandCategorylist);
        click(VideoGamesCategory);
        clickElementUsingJavaScript(AllVideoGames);
        return new HomePage(driver);
    }

    @Step ("Filter By free shipping ")
    public HomePage FilterByFreeShipping()
    {
        click(FreeShippingCheck);
        return new HomePage(driver);
    }
    @Step ("Filter By new condition")
    public HomePage FilterByNewCondition()
    {
       clickElementUsingJavaScript(NewCondition);
       return new HomePage(driver);
    }
    @Step ("open the sort menu")
    public HomePage OpenTheSortMenu()
    {
        clickElementUsingJavaScript(SortMenu);
        return new HomePage(driver);
    }
    @Step ("sort by price high to low")
    public HomePage SortByPriceHighToLow()
    {
        clickElementUsingJavaScript(SortByPriceHighToLow);
        return new HomePage(driver);
    }


}
