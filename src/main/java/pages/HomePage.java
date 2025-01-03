package pages;
import base.BasePage;
import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.qameta.allure.Step;


public class HomePage extends BasePage
{

    //Locators
    private final By SigninPage = By.id("nav-link-accountList");
    private final By Allmenu = By.id("nav-hamburger-menu");
    private final By ExpandCategorylist = By.className("nav-sprite hmenu-arrow-more");
    private final By VideoGamesCategory = By.id("16");
    private final By AllVideoGames = By.xpath("//a[@href='/-/en/gp/browse.html?node=18022560031&ref_=nav_em_vg_all_0_2_16_2']");
    private final By FreeShippingCheck = By.id("apb-browse-refinements-checkbox_0");
    private final By NewCondition = By.xpath("//a[@href='/-/en/s?rh=n%3A18022560031%2Cp_n_condition-type%3A28071525031&dc&qid=1735896407&rnid=28071523031&ref=sr_nr_p_n_condition-type_0']");
    private final By SortMenu = By.id("s-result-sort-select");
    private final By SortByPrice = By.id("s-result-sort-select_2");


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
    public HomePage OpenleftsideAllmenu()
    {
        click(Allmenu);
        return new HomePage(driver);
    }
    @Step("Select all Video Games Category")
    public HomePage selectallvideogamescategory()
    {

        click(ExpandCategorylist)
                .click(VideoGamesCategory)
                .click(AllVideoGames);
        return new HomePage(driver);
    }

    @Step ("Filter By free shipping and new condition")
    public HomePage filterbyfreeshippingandnewcondition()
    {
        click(FreeShippingCheck).click(NewCondition);
        return new HomePage(driver);
    }

    @Step ("sort by price high to low")
    public HomePage sortbypricehightolow()
    {
        click(SortMenu).click(SortByPrice);

        return new HomePage(driver);
    }


}
