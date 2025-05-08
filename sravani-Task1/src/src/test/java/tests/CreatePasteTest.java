package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

public class CreatePasteTest {

    @Test
    public void testCreatePaste() {
        // Set up the Chrome driver
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        // Open the Pastebin website
        driver.get("https://pastebin.com/");

        // Add wait to ensure elements are visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Wait until the "10 Minutes" element is visible
            WebElement tenMinutesElement = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[text()='10 Minutes']"))
            );

            // Assert that the "10 Minutes" element is displayed
            Assertions.assertTrue(tenMinutesElement.isDisplayed(), "The '10 Minutes' element should be visible.");

            // Additional actions if needed (e.g., creating a paste, filling out forms)
            // For example:
            // WebElement pasteText = driver.findElement(By.id("pastebox"));
            // pasteText.sendKeys("Some text for the paste");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser after the test is done
            driver.quit();
        }
    }
}
