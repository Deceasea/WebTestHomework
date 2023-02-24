package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.utils.CustomEventListener;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.time.Duration;

public class AbstractTest {
    static WebDriver webDriver;

    @BeforeAll
    static void setDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        options.setPageLoadTimeout(Duration.ofSeconds(10));

        webDriver = new ChromeDriver(options);
        EventFiringWebDriver driver = new EventFiringWebDriver(webDriver);
        driver.register(new CustomEventListener());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @BeforeEach
    void initMainPage() {
        Assertions.assertDoesNotThrow(() -> getWebDriver().navigate().to("https://www.4italka.ru/"),
                "Страница не доступна");
        Assertions.assertTrue(true);
    }

//    @BeforeEach
//    public void setUp() {
//        EventFiringWebDriver driver = new EventFiringWebDriver(webDriver);
//        driver.register(new CustomEventListener());
//    }

    @AfterAll
    public static void exit() {
        if (webDriver != null) webDriver.quit();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}

