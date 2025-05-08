package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class PastebinHomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By codeInput = By.id("postform-text");
    private By syntaxHighlightingDropdown = By.id("select2-postform-format-container");
    private By syntaxOptionBash = By.xpath("//li[text()='Bash']");
    private By pasteExpirationDropdown = By.id("select2-postform-expiration-container");
    private By pasteExpiration10Min = By.xpath("//li[text()='10 Minutes']");
    private By pasteNameInput = By.id("postform-name");
    private By createPasteButton = By.xpath("//button[text()='Create New Paste']");

    public PastebinHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://pastebin.com/");
    }

    public void enterCode(String code) {
        driver.findElement(codeInput).sendKeys(code);
    }

    public void selectSyntaxHighlighting() {
        driver.findElement(syntaxHighlightingDropdown).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(syntaxOptionBash)).click();
    }

    public void selectPasteExpiration() {
        driver.findElement(pasteExpirationDropdown).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(pasteExpiration10Min)).click();
    }

    public void enterPasteName(String name) {
        driver.findElement(pasteNameInput).sendKeys(name);
    }

    public void createPaste() {
        driver.findElement(createPasteButton).click();
    }
}
