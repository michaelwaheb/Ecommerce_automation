package resources;
import models.LoginData;
import models.AddressData;
import org.testng.annotations.DataProvider;

public class TestData {
    //Login Data
    @DataProvider(name = "LoginData")
    public Object[][] providelogindata() {
        return new Object[][]{
                {new LoginData("mrw2000@hotmail.com", "2011861(m)")}
        };
    }

    //Address details
    @DataProvider(name = "AddressData")
    public Object[][] Addressdetails() {
        return new Object[][]{
                {new AddressData("Michael", "1223669950", "Ramsis", "Medical tower", "Cairo", "Cairo")}
        };


    }
}


