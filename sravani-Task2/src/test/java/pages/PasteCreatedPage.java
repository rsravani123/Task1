package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasteCreatedPage {
    private WebDriver driver;

    private By codeText = By.xpath("//textarea[@class='textarea']");
    private By syntax = By.xpath("//a[@class='btn -small h_800']");

    public PasteCreatedPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getCodeText() {
        return driver.findElement(codeText).getText();
    }

    public String getSyntax() {
        return driver.findElement(syntax).getText();
    }
}
