package pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class HousingPage extends BasePage{

    public static final SelenideElement housingHeaderLink = $(By.linkText("housing"));

    public static final SelenideElement sortingCombo = $(".dropdown-item.mode.sel a");
    public static final SelenideElement sortingComboList = $(".dropdown-list.dropdown-show");

    public static final SelenideElement searchInput = $("#query");
    public static final SelenideElement submitSearchButton = $(".searchbtn");

    public static final SelenideElement sortPriceAsc = $("[data-selection='priceasc']");
    public static final SelenideElement sortPriceDesc = $("[data-selection='pricedsc']");

    public boolean isPageVisible(){
        return housingHeaderLink.isDisplayed();
    }

    public void openSortingList(){
        sortingCombo.click();
        sortingComboList.should(visible);
    }

    public void checkSortingOptionAvailable(String option){
        sortingComboList.should(text(option));
    }

    public void checkSortingOptionChosen(String option){
        sortingCombo.should(text(option));
    }

    public void searchFor(String query){
        searchInput.should(visible);
        searchInput.setValue(query);
        submitSearchButton.click();

        searchInput.should(value(query));
    }

    public void sortByPriceDescending(){
        openSortingList();
        sortPriceDesc.click();

        checkSortingOptionChosen("price ↓");
    }

    public void sortByPriceAscending(){
        openSortingList();
        sortPriceAsc.click();

        checkSortingOptionChosen("price ↑");
    }
}
