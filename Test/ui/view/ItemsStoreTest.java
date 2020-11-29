package ui.view;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ItemsStoreTest {
    private WebDriver driver;
    private String url = "http://localhost:8080/";

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Joram\\JavaProjects\\chromedriver_win32");
        driver = new ChromeDriver();

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void test_new_added_item_is_found() {
        driver.get(url + "AddPage.jsp");
        int rand =new Random().nextInt(999999);
        AddItem("Sword "+rand, "Weapon", rand, "a strong sword");
        driver.get(url + "Found.jsp");
        searchItem("Sword "+rand, "Weapon");
        assertEquals("Found", driver.getTitle());
        assertEquals("Je vroeg naar volgende gegevens: Sword "+rand+" Weapon ",
                driver.findElement(By.id("boodschap")).getText());

    }

    private void AddItem(String name, String type, int amount, String discription) {
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("type")).sendKeys(type);
        driver.findElement(By.id("amount")).sendKeys(amount + "");
        driver.findElement(By.id("discription")).sendKeys(discription);
        driver.findElement(By.id("Add item")).click();

    }

    private void searchItem(String name, String type) {
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("type")).sendKeys(type);
        driver.findElement(By.id("Search item")).click();
    }


}