package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    @BeforeSuite
    public void setupSuite(){
        Configuration.baseUrl = "https://madrid.craigslist.org";
    }

    @BeforeMethod
    public void setupMethod(){
        open("/");
    }
}
