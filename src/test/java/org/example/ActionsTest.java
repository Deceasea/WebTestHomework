package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionsTest extends AbstractTest {
    @Test
    void myActionTest1() throws InterruptedException {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("https://www.4italka.ru/"));
        Assertions.assertTrue(getDriver().getTitle().contains("Читалка.Ру - читать книги онлайн"), "Страница недоступна");

        Actions search = new Actions(getDriver());
        search.click(getDriver().findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div/div[2]/div[1]/ul/li[1]/a")))
                .pause(1000L).build().perform();
        search.sendKeys(getDriver().findElement(By.xpath("//*[@id=\"page\"]/main/div[4]/div/div[3]/div/div/form/div/input")), "Акунин")
                .pause(1000L).build().perform();
        search.click(getDriver().findElement(By.xpath("//*[@id=\"page\"]/main/div[4]/div/div[3]/div/div/form/div/span/button")))
                .build()
                .perform();

        Thread.sleep(1000);
    }

    @Test
    void myActionTest2() throws InterruptedException {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("https://www.4italka.ru/"));
        Assertions.assertTrue(getDriver().getTitle().contains("Читалка.Ру - читать книги онлайн"), "Страница недоступна");

        Actions search = new Actions(getDriver());
        search.click(getDriver().findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div/div[2]/div[1]/ul/li[2]/a")))
                .pause(1000L).build().perform();
        search.click(getDriver().findElement(By.xpath("//*[@id=\"page\"]/main/div[3]/div/div[2]/p[2]/a/span")))
                .pause(1000L).build().perform();
        search.click(getDriver().findElement(By.xpath("//*[@id=\"page\"]/main/div[3]/div/div[2]/div/form/div[3]/div[1]/input"))).pause(1000L).build().perform();
        search.sendKeys(getDriver().findElement(By.xpath("//*[@id=\"page\"]/main/div[3]/div/div[2]/div/form/div[3]/div[1]/input")), "Ирина")
                .build()
                .perform();

        Thread.sleep(1000);
    }

    //Негативная проверка
    @Test
    void myActionTest3() throws InterruptedException {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("https://www.4italka.ru/"));
        Assertions.assertTrue(getDriver().getTitle().contains("Читалка.Ру - читать книги онлайн"), "Страница недоступна");

        Actions search = new Actions(getDriver());
        search.click(getDriver().findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div/div[2]/div[1]/ul/li[2]/a")))
                .pause(1000L).build().perform();
        search.click(getDriver().findElement(By.xpath("//*[@id=\"page\"]/main/div[3]/div/div[2]/p[2]/a/span")))
                .pause(1000L).build().perform();
        search.click(getDriver().findElement(By.xpath("//*[@id=\"page\"]/main/div[3]/div/div[2]/div/form/div[3]/div[1]/input"))).pause(1000L).build().perform();
        search.sendKeys(getDriver().findElement(By.xpath("//*[@id=\"page\"]/main/div[3]/div/div[2]/div/form/div[3]/div[1]/input")), " ");
        search.click(getDriver().findElement(By.xpath("//*[@id=\"page\"]/main/div[3]/div/div[2]/div/form/div[3]/div[2]/input"))).pause(1000L).build().perform();
        search.sendKeys(getDriver().findElement(By.xpath("//*[@id=\"page\"]/main/div[3]/div/div[2]/div/form/div[3]/div[2]/input")), "00000");
        search.click(getDriver().findElement(By.xpath("//*[@id=\"page\"]/main/div[3]/div/div[2]/div/form/div[3]/div[6]/span/button")))
                .pause(1000L)
                .build()
                .perform();

        Thread.sleep(1000);
    }

    @Test
    void myActionTest4() throws InterruptedException {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("https://www.4italka.ru/"));
        Assertions.assertTrue(getDriver().getTitle().contains("Читалка.Ру - читать книги онлайн"), "Страница недоступна");

        Actions search = new Actions(getDriver());
        search.click(getDriver().findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div/div[1]/div[2]/div/a")))
                .pause(1000L).build().perform();
        search.click(getDriver().findElement(By.xpath("//*[@id=\"page\"]/main/div[5]/div/div/div[1]/div/div/ul/li[1]/a")))
                .pause(1000L).build().perform();
        search.click(getDriver().findElement(By.xpath("//*[@id=\"page\"]/main/div[2]/div/div/form/div[1]/input"))).pause(1000L).build().perform();
        search.sendKeys(getDriver().findElement(By.xpath("//*[@id=\"page\"]/main/div[2]/div/div/form/div[1]/input")), "Функция");
        search.click(getDriver().findElement(By.xpath("//*[@id=\"page\"]/main/div[2]/div/div/form/div[1]/span/button")))
                .pause(1000L)
                .build()
                .perform();

        Thread.sleep(1000);
    }
}
