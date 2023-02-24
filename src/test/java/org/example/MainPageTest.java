package org.example;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainPageTest extends AbstractTest{

    @Test
    @Description("Проверка работы кнопок навигации")
    @Step("авторы-ОПроекте-Топ100-Сейчас читают-Мне Повезет!-Логин")
    void mainMenuNavigateTest(){
        MainPage mainPage = new MainPage(getWebDriver());
        mainPage
                .clickavtory()
                .clickoProekte()
                .clicktop100()
                .clickseichasChitaut()
                .clickmnePovezet()
                .clicklogIn();
        Assertions.assertEquals("https://www.4italka.ru/random-book.htm",getWebDriver().getCurrentUrl());
    }

    @Test
    @Description("Проверка работы логина")
    void mainMenuLogInTest(){
        MainPage mainMenu = new MainPage(getWebDriver());
        mainMenu.clicklogIn();
        Assertions.assertEquals("https://www.4italka.ru/",getWebDriver().getCurrentUrl());
    }

    @Test
    @Description("Проверка поиска по фамилии Автора, работы строки и кнопки поиска")
    void searchTest() throws MyException {
        SearchPage searchPage = new SearchPage(webDriver);
        Assertions.assertDoesNotThrow(() ->searchPage.toSearch("Акунин"));
        Assertions.assertTrue(webDriver.getCurrentUrl().contains("https://www.4italka.ru/"));
        Assertions.assertDoesNotThrow(() ->searchPage.buttonSearch(9));

    }
}
