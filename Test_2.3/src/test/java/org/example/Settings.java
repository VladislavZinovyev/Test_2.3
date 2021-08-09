package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class Settings<carArray> {

    public WebDriver driver;
    public Settings(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    // Локатор раскрытия списка марок
    @FindBy(xpath = "//div[text() = 'Показать все']")
    private static WebElement listOpen;

    // определение локатора марок
    @FindBy(xpath = "//div[@class='css-u4n5gw ebqjjri1']/div/div/div")
    private List<WebElement> car;

    // метод раскрытия списка марок
    public static void clickListOpen() {
        listOpen.click();
    }

    // выбор марок авто
    public String Searching(int i){
        String carNAme;
        carNAme = car.get(i).getAttribute("textContent") ;

        return carNAme;
    }
}
