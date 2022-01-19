package pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class HomePage extends BasePage {
    public static final SelenideElement changeLanguageCombo = $("#chlang");
    public static final SelenideElement switchToEnglishLink = $(By.linkText("english"));

    public static final SelenideElement housingHeaderLink = $("[data-alltitle='all housing']");


    public void switchToEnglish(){
        switchToEnglishLink.click();
        changeLanguageCombo.should(text("english"));
    }

    public HousingPage openHousing(){
        switchToEnglish();
        housingHeaderLink.click();
        return new HousingPage();
    }
}
