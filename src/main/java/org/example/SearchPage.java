package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage extends AbstractPage{

    @FindBy(xpath = "//*[@id=\"page\"]/main/div[2]/div/div/form/div[1]/input")
    private WebElement fieldSearch;

    @FindBy(xpath = "//*[@id=\"page\"]/main/div[2]/div/div/form/div[1]/span/button")
    public WebElement buttonSearch;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void toSearch(String value){
        fieldSearch.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(buttonSearch));
        fieldSearch.sendKeys(value);
        buttonSearch.submit();
    }

    public void buttonSearch(int i) {
    }
}
