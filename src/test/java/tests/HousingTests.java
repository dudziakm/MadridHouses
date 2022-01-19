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

    public final HomePage homePage = new HomePage();
    public final HousingPage housingPage = new HousingPage();

    @BeforeMethod
    public void beforeMethod() {
        homePage.openHousing();
    }

    @Test
    public void openHousingPageTest() {
        assertTrue(housingPage.isPageVisible());
    }

    @Test
    public void checkDefaultSortingTest() {
        List<String> sortingOptions = new ArrayList<>(Arrays.asList("upcoming",
                "newest",
                "price ↑ ",
                "price ↓ "
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

        List<String> sortingOptions = new ArrayList<>(Arrays.asList("upcoming",
                "newest",
                "relevant",
                "price ↑ ",
                "price ↓ "
        ));

        assertTrue(housingPage.isPageVisible());

        housingPage.searchFor(query);

        housingPage.openSortingList();
        for (String sortingOption : sortingOptions) {
            housingPage.checkSortingOptionAvailable(sortingOption);
        }
    }

    @Test
    public void checkSwitchingBetweenSortingTest() {
        final String query = "house";

        List<String> sortingOptions = new ArrayList<>(Arrays.asList("upcoming",
                "newest",
                "relevant",
                "price ↑ ",
                "price ↓ "
        ));

        assertTrue(housingPage.isPageVisible());

        housingPage.searchFor(query);

        housingPage.openSortingList();
        for (String sortingOption : sortingOptions) {
            housingPage.checkSortingOptionAvailable(sortingOption);
        }
    }

}
