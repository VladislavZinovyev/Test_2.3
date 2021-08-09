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

   // @FindBy(xpath = "//input[@placeholder='Марка']")
   // private static WebElement listOpen;

    // определение локатора  марки из выпадающего списка
    //  @FindBy(xpath = "//div[@class='eexvxqb0 css-12mzdf e1m504pf0'][1]//div[@class='css-d9w586 e1x0dvi10']")
   // private List<WebElement> avto;

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
