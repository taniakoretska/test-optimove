package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CareersPage extends BasePage {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    private By cookieBanner = By.className("cookiebanner__close");
    private By openPositionButton = By.linkText("Explore Open Positions");
    private By officesDropdown = By.cssSelector(".select--job-locations .button");
    private String officeDropdownValue = "//div[@class='selectric-scroll']//li[contains(text(), %s)]";
    private By QAVacancyTitle = By.xpath("//div[@class='job-card']/descendant::a"
            + "[text()='QA Automation Engineer']");

    public CareersPage(WebDriver driver) {
        super(driver);
    }

    public void closeCookieBanner() {
        waitForElementToBeClickable(cookieBanner);
        driver.findElement(cookieBanner).click();
    }

    public CareersPage clickOnExploreOpenPositions() {
        WebElement element = driver.findElement(openPositionButton);
        js.executeScript("arguments[0].scrollIntoView;", element);
        element.click();
        return this;
    }

    public void fillOfficesDropdown(String value) {
        WebElement element = driver.findElement(officesDropdown);
        js.executeScript("arguments[0].scrollIntoView;", element);
        js.executeScript("arguments[0].click();", element);
        WebElement dropdownValue = driver.findElement(By.xpath(String.format(officeDropdownValue, value)));
        dropdownValue.click();
    }

    public boolean isQAAutomationVacancyPresent() {
        return isElementVisible(QAVacancyTitle);
    }
}
