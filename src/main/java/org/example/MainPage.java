package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div/div[2]/div[1]/ul/li[1]/a")
    private WebElement avtory;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div/div[2]/div[1]/ul/li[2]/a")
    private WebElement oProekte;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div/div[2]/div[1]/ul/li[3]/a")
    private WebElement top100;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div/div[2]/div[1]/ul/li[4]/a")
    private WebElement seichasChitaut;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div/div[2]/div[1]/ul/li[5]/a")
    private WebElement mnePovezet;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div/div[2]/div[2]/div[1]/a/label/span")
    private WebElement logIn;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage clickavtory() {
        avtory.click();
        return this;
    }

    public MainPage clickoProekte() {
        oProekte.click();
        return this;
    }

    public MainPage clicktop100() {
        top100.click();
        return this;
    }

    public MainPage clickseichasChitaut() {
        seichasChitaut.click();
        return this;
    }

    public MainPage clickmnePovezet() {
        mnePovezet.click();
        return this;
    }

    public MainPage clicklogIn() {
        logIn.click();
        return this;
    }
}


