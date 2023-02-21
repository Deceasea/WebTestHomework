package org.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class ErrorTest extends AbstractTest {

    @Test
    void test() throws InterruptedException {
        getDriver().get("https://www.4italka.ru/");
        WebElement webElement = getDriver().findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div/div[2]/div[1]/ul/li[3]/a"));
        webElement.click();

        Wait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        Thread.sleep(10000);

        WebElement webElement2 = wait.until(driver -> driver.findElement(By.xpath("//*[@id=\"page\"]/main/div[2]/div/div/form/div[1]/input")));

        webElement2.click();
        webElement2.sendKeys("Похороните меня за плинтусом");
        webElement2.submit();
    }
}
