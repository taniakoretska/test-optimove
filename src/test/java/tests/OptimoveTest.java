package tests;

import data.Data;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CareersPage;


public class OptimoveTest extends BaseTest {

    @Test(dataProvider = "data-provider", dataProviderClass = Data.class)
    public void verifyIfQAVacancyIsPresent(String data) {
        CareersPage careersPage = new CareersPage(driver);
        careersPage.closeCookieBanner();
        careersPage
            .clickOnExploreOpenPositions()
            .fillOfficesDropdown(data);
        boolean isQAVacancyPresent = careersPage.isQAAutomationVacancyPresent();

        Assert.assertTrue(isQAVacancyPresent, "There is no available QA Vacancy in Ukrainian office");

    }
}
