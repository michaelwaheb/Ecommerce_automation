package Data;
import Models.LoginData;
import org.testng.annotations.DataProvider;

public class TestData {
    //packages data details for 3 countries
    @DataProvider(name = "LoginData")
    public Object[][] providelogindata() {
        return new Object[][]{
                {new LoginData("mrw2000@hotmail.com", "2011861(m)")}
        };


    }
}
