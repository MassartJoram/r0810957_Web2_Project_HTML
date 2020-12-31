package ui.view;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSearch {

    private WebDriver driver;
    private String url = "http://localhost:8080/r0810957_Web2_Project_HTML_war_exploded/";

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Joram\\JavaProjects\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url + "SearchItem.jsp");

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void Test_Search_Form_is_shown_again_when_all_fields_are_empty_with_error_message(){
        WebElement name = driver.findElement(By.id("name"));
        name.clear();
        name.sendKeys("");

        WebElement type = driver.findElement(By.id("type"));
        type.clear();
        type.sendKeys("");


        driver.findElement(By.id("search")).click();

        assertEquals("Search Items" , driver.getTitle());
        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebelementWithText(lis , "fill in a name!"));
        assertTrue(containsWebelementWithText(lis , "fill in a type!"));
    }

    @Test
    public void Test_Form_is_shown_again_when_name_field_is_empty_with_error_message(){
        WebElement name = driver.findElement(By.id("name"));
        name.clear();
        name.sendKeys("");

        WebElement type = driver.findElement(By.id("type"));
        type.clear();
        type.sendKeys("Sword");


        driver.findElement(By.id("search")).click();

        assertEquals("Search Items" , driver.getTitle());
        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebelementWithText(lis , "fill in a name!"));
    }

    @Test
    public void Test_Form_is_shown_again_when_type_field_is_empty_with_error_message(){
        WebElement name = driver.findElement(By.id("name"));
        name.clear();
        name.sendKeys("Bronze sword");

        WebElement type = driver.findElement(By.id("type"));
        type.clear();
        type.sendKeys("");


        driver.findElement(By.id("search")).click();

        assertEquals("Search Items" , driver.getTitle());
        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebelementWithText(lis , "fill in a type!"));
    }

    @Test
    public void Test_Item_not_found_page_is_shown_after_submitting(){
        WebElement name = driver.findElement(By.id("name"));
        name.clear();
        name.sendKeys("Not");

        WebElement type = driver.findElement(By.id("type"));
        type.clear();
        type.sendKeys("Found");


        driver.findElement(By.id("search")).click();

        assertEquals("NotFound" , driver.getTitle());
    }

    @Test
    public void Test_Item_found_page_is_shown_after_submitting(){

        driver.get(url + "AddPage.jsp");
        WebElement nameAdd = driver.findElement(By.id("name"));
        nameAdd.clear();
        nameAdd.sendKeys("Bronze sword");

        WebElement typeAdd = driver.findElement(By.id("type"));
        typeAdd.clear();
        typeAdd.sendKeys("Sword");

        WebElement amount = driver.findElement(By.id("amount"));
        amount.clear();
        amount.sendKeys("10");

        WebElement discription = driver.findElement(By.id("discription"));
        discription.clear();
        discription.sendKeys("This is a sword");

        driver.findElement(By.id("ButtonAdd")).click();

        driver.get(url + "SearchItem.jsp");
        WebElement name = driver.findElement(By.id("name"));
        name.clear();
        name.sendKeys("Bronze sword");

        WebElement type = driver.findElement(By.id("type"));
        type.clear();
        type.sendKeys("Sword");


        driver.findElement(By.id("search")).click();

        assertEquals("Found" , driver.getTitle());
        ArrayList<WebElement> table = (ArrayList<WebElement>) driver.findElements(By.tagName("p"));
        assertTrue(containsWebelementWithText(table , "You looked for : Bronze sword , Sword"));
    }

    private boolean containsWebelementWithText(ArrayList<WebElement> elements , String text){
        for (int i = 0; i < elements.size(); i++) {
            if(elements.get(i).getText().equals(text)){
                return true;
            }

        }
        return false;
    }
}
