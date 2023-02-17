package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Lesson3 {
    public static void main(String[] args) {
        io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.4italka.ru/");

        //Тест №1-логин при наличии тестовых данных
        WebElement buttonLogin = getWebElement(driver, "//*[@id=\"header\"]/div/div/div/div/div[2]/div[2]/div[1]/a/label/span/i");
        buttonLogin.click();
        WebElement fieldEmail = getWebElement(driver, "//*[@id=\"form_def\"]/div/div/div[2]/form/div[1]/input");
        fieldEmail.sendKeys("anj04233@nezid.com");
        WebElement buttonPassword = getWebElement(driver, "//*[@id=\"form_def\"]/div/div/div[2]/form/div[2]/input");
        buttonPassword.sendKeys("password");
        WebElement buttonEnter = getWebElement(driver, "//*[@id=\"form_def\"]/div/div/div[2]/form/div[3]/div[1]/button");
        buttonEnter.click();

        //Тест №2 - ищем книгу по заданным параметрам, смотрим вторую страницу поиска
        WebElement fieldSearch = getWebElement(driver, "//*[@id=\"page\"]/main/div[2]/div/div/form/div[1]/input");
        fieldSearch.sendKeys("Война и мир");
        WebElement buttonSearch = getWebElement(driver, "//*[@id=\"page\"]/main/div[2]/div/div/form/div[1]/span/button");
        buttonSearch.click();
        WebElement secondPage = getWebElement(driver, "//*[@id=\"page\"]/main/div[4]/div/div[4]/ul/li[2]/a");
        secondPage.click();

        //Тест №3 - ставим лайк книге из  из Топ-100
        WebElement top100 = getWebElement(driver, "//*[@id=\"header\"]/div/div/div/div/div[2]/div[1]/ul/li[3]/a");
        top100.click();
        WebElement bookLike = getWebElement(driver, "//*[@id=\"page\"]/main/div[5]/div[3]/div[1]/div/div[2]/div[1]/div/i");
        bookLike.click();

        //Тест №4 - добавляем в избранное
        WebElement fieldSearch2 = getWebElement(driver, "//*[@id=\"page\"]/main/div[2]/div/div/form/div[1]/input");
        fieldSearch2.click();
        fieldSearch2.sendKeys("Меч Без Имени");
        WebElement buttonSearch2 = getWebElement(driver, "//*[@id=\"page\"]/main/div[2]/div/div/form/div[1]/span/button");
        buttonSearch2.click();
        WebElement buttonBook1 = getWebElement(driver, "//*[@id=\"page\"]/main/div[4]/div/div[3]/div[1]");
        buttonBook1.click();
        WebElement buttonToWishList = getWebElement(driver, "//*[@id=\"addToFavourites\"]/a");
        buttonToWishList.click();

    }

    private static WebElement getWebElement(WebDriver driver, String way) {
        List<WebElement> buttonLogin = Collections.emptyList();
        try {
            buttonLogin = driver.findElements(By.xpath(way));
        } catch (NoSuchElementException e) {
            System.out.println(e.getSupportUrl());
        }

        if (buttonLogin.size() > 1) {
            throw new RuntimeException("Найдено более одного элемента на странице!");
        }
        return buttonLogin.get(0);
    }
}
