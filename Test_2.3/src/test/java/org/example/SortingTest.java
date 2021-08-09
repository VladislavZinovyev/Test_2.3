package org.example;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;

public class SortingTest {

    public static FilterSettings filterSettings;
    public static Settings settings;
    public static WebDriver driver;


    @BeforeClass
    public static void setup() {

        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        filterSettings = new FilterSettings(driver);
        settings = new Settings(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfProperties.getProperty("web_page"));
        ;
    }


    @Test
    public void sortingTest() {

       // выбор региона
        FilterSettings.clickChoosingArea();
        FilterSettings.clickPrimorye();
        FilterSettings.clickAllCity();

        // раскрываем выпадающий список
        settings.clickListOpen();



        // заполняем массив
        String[] carArray = new String[119];
        for (int i = 0; i < 119; i++) {
            carArray[i] = settings.Searching(i);
        }

        // вывод названий столбцов
        System.out.println("| Фирма | Количество объявлений |" + "\n");

        // функция сортировки
        String temp = "";
        for (int i = 0; i < 119; i++) {

            for (int j = i + 1; j < 119; j++) {

                int indexIn = carArray[i].lastIndexOf(" ");
                String countInput = carArray[i].substring(indexIn + 1);
                boolean checkLack1 = countInput.isEmpty();
                if (checkLack1 == true) { countInput = "0"; }

                int indexEx = carArray[j].lastIndexOf(" ");
                String countExist = carArray[j].substring(indexEx + 1);
                boolean checkLack2 = countExist.isEmpty();
                if (checkLack2 == true) { countExist = "0"; }

                if (Integer.parseInt(countInput) < Integer.parseInt(countExist)) {
                    temp = carArray[i];
                    carArray[i] = carArray[j];
                    carArray[j] = temp;
                }
            }

            // Вывод топ 20 фирм
            if (i<20) {
                int n = carArray[i].lastIndexOf(" ");
                String forPrintCount = carArray[i].substring(n + 1);
                String forPrintName = carArray[i].substring(0, n);
                System.out.println("|" + forPrintName + "|" + forPrintCount + "|" + "\n");
            }
        }
    }
        @AfterClass
        public static void tearDown () {

            // закрываем браузер
             driver.quit();
        }
    }
