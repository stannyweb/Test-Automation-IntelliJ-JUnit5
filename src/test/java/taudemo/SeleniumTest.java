package taudemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;


@TestInstance(PER_CLASS)
public class SeleniumTest {
    private static WebDriver driver;

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();


    }

    @AfterAll
    public static void afterAll() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void openPageAndCheckTitle() {
        String expectedTitle = "Example Domain";
        driver.get("http://www.example.com");

        Assertions.assertEquals(expectedTitle, driver.getTitle());

    }
}
