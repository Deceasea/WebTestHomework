package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainPageTest extends AbstractTest{

    @Test
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
    void mainMenuLogInTest(){
        MainPage mainMenu = new MainPage(getWebDriver());
        mainMenu.clicklogIn();
        Assertions.assertEquals("https://www.4italka.ru/",getWebDriver().getCurrentUrl());
    }

    @Test
    void searchTest(){
        SearchPage searchPage = new SearchPage(getWebDriver());
        searchPage.toSearch("Акунин");
        Assertions.assertTrue(getWebDriver().getCurrentUrl().contains("https://www.4italka.ru/"));
        Assertions.assertDoesNotThrow(() ->searchPage.buttonSearch(9));

    }
}
