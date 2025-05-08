package tests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PastebinHomePage;
import pages.PasteCreatedPage;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class CreatePasteTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void testCreatePaste() {
        String code = """
                git config --global user.name  "New Sheriff in Town"
                
                git reset $(git commit-tree HEAD^{tree} -m "Legacy code")
                
                git push origin master --force""";
        String title = "how to gain dominance among developers";

        PastebinHomePage homePage = new PastebinHomePage(driver);
        homePage.open();
        homePage.enterCode(code);
        homePage.selectSyntaxHighlighting();
        homePage.selectPasteExpiration();
        homePage.enterPasteName(title);
        homePage.createPaste();

        PasteCreatedPage createdPage = new PasteCreatedPage(driver);

        assertTrue(createdPage.getPageTitle().contains(title));
        assertEquals("Bash", createdPage.getSyntax());
        assertEquals(code.trim(), createdPage.getCodeText().trim());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
