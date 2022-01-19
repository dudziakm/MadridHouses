package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.HousingPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class HousingTests extends BaseTest {

    final HomePage homePage = new HomePage();
    final HousingPage housingPage = new HousingPage();

    final String sortingAscending = "price ↑";
    final String sortingDescending = "price ↓";
    final String sortingNewest = "newest";
    final String sortingUpcoming = "upcoming";
    final String sortingRelevant = "relevant";

    @BeforeMethod
    public void beforeMethod() {
        homePage.openHousing();
    }

    @Test
    public void openHousingPageTest() {
        assertTrue(housingPage.isPageVisible());
    }

    @Test
    public void checkSortingTest() {
        assertTrue(housingPage.isPageVisible());

        housingPage.sortByPriceAscending();
        housingPage.checkSortingOptionChosen(sortingAscending);

        housingPage.sortByPriceDescending();
        housingPage.checkSortingOptionChosen(sortingDescending);
    }

    @Test
    public void checkDefaultSortingTest() {
        List<String> sortingOptions = new ArrayList<>(Arrays.asList(sortingUpcoming,
                sortingNewest,
                sortingAscending,
                sortingDescending
        ));

        assertTrue(housingPage.isPageVisible());

        housingPage.openSortingList();
        for (String sortingOption : sortingOptions) {
            housingPage.checkSortingOptionAvailable(sortingOption);
        }
    }

    @Test
    public void checkSortingAfterSearchingTest() {
        final String query = "house";

        List<String> sortingOptions = new ArrayList<>(Arrays.asList(sortingUpcoming,
                sortingNewest,
                sortingRelevant,
                sortingAscending,
                sortingDescending
        ));

        assertTrue(housingPage.isPageVisible());

        housingPage.searchFor(query);

        housingPage.openSortingList();
        for (String sortingOption : sortingOptions) {
            housingPage.checkSortingOptionAvailable(sortingOption);
        }
    }
}
