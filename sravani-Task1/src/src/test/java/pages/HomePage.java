package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://pastebin.com");
    }

    public void enterCode(String code) {
        driver.findElement(By.id("postform-text")).sendKeys(code);
    }

    public void selectExpiration(String expiration) {
        driver.findElement(By.cssSelector("span.select2-selection__rendered")).click();
        // Wait for the dropdown option to be visible before clicking
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='" + expiration + "']")))
                .click();
    }

    public void enterTitle(String title) {
        driver.findElement(By.name("PostForm[name]")).sendKeys(title);
    }

    public void submit() {
        driver.findElement(By.xpath("//button[text()='Create New Paste']")).click();
    }
}
