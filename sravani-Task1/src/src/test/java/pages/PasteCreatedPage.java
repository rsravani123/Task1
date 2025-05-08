package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasteCreatedPage {
    private WebDriver driver;

    public PasteCreatedPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getPasteContent() {
        return driver.findElement(By.cssSelector("div.info-top + div")).getText();
    }
}
