package tests;

import org.testng.annotations.Test;
import pageObjects.HomePage;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SmokeTests extends BaseTest {

    public static final String pageTitle = "craigslist: madrid trabajos, apartamentos, ventas, servicios, comunidad y eventos";
    public static final String pageUrl = "https://madrid.craigslist.org/";

    @Test
    public void openMainPageTest() {
        assertTrue(url().contains(pageUrl));
        assertEquals(title(), pageTitle);
    }

    @Test
    public void switchToEnglishTest() {
        new HomePage().switchToEnglish();
    }

}
