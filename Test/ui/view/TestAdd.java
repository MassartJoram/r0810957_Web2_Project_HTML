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

public class TestAdd {

    private WebDriver driver;
    private String url = "http://localhost:8080/r0810957_Web2_Project_HTML_war_exploded/";

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Joram\\JavaProjects\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url + "AddPage.jsp");

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void Test_Form_is_shown_again_when_all_fields_are_empty_with_error_message(){
        WebElement name = driver.findElement(By.id("name"));
        name.clear();
        name.sendKeys("");

        WebElement type = driver.findElement(By.id("type"));
        type.clear();
        type.sendKeys("");

        WebElement amount = driver.findElement(By.id("amount"));
        amount.clear();
        amount.sendKeys("");

        WebElement discription = driver.findElement(By.id("discription"));
        discription.clear();
        discription.sendKeys("");

        driver.findElement(By.id("ButtonAdd")).click();

        assertEquals("Add Items" , driver.getTitle());
        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebelementWithText(lis , "fill in a name!"));
        assertTrue(containsWebelementWithText(lis , "fill in a type!"));
        assertTrue(containsWebelementWithText(lis , "Fill an amount in!"));
        assertTrue(containsWebelementWithText(lis , "fill in a discription!"));

    }

    @Test
    public void Test_Form_is_shown_again_when_name_field_is_empty_with_error_message(){
        WebElement name = driver.findElement(By.id("name"));
        name.clear();
        name.sendKeys("");

        WebElement type = driver.findElement(By.id("type"));
        type.clear();
        type.sendKeys("Sword");

        WebElement amount = driver.findElement(By.id("amount"));
        amount.clear();
        amount.sendKeys("10");

        WebElement discription = driver.findElement(By.id("discription"));
        discription.clear();
        discription.sendKeys("This is a sword");

        driver.findElement(By.id("ButtonAdd")).click();

        assertEquals("Add Items" , driver.getTitle());
        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebelementWithText(lis , "fill in a name!"));
        assertEquals("Sword", driver.findElement(By.id("type")).getAttribute("value"));
        assertEquals("10", driver.findElement(By.id("amount")).getAttribute("value"));

    }

    @Test
    public void Test_Form_is_shown_again_when_type_field_is_empty_with_error_message(){
        WebElement name = driver.findElement(By.id("name"));
        name.clear();
        name.sendKeys("Bronze sword");

        WebElement type = driver.findElement(By.id("type"));
        type.clear();
        type.sendKeys("");

        WebElement amount = driver.findElement(By.id("amount"));
        amount.clear();
        amount.sendKeys("10");

        WebElement discription = driver.findElement(By.id("discription"));
        discription.clear();
        discription.sendKeys("This is a sword");

        driver.findElement(By.id("ButtonAdd")).click();

        assertEquals("Add Items" , driver.getTitle());
        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebelementWithText(lis , "fill in a type!"));
        assertEquals("Bronze sword", driver.findElement(By.id("name")).getAttribute("value"));
        assertEquals("10", driver.findElement(By.id("amount")).getAttribute("value"));

    }

    @Test
    public void Test_Form_is_shown_again_when_amount_field_is_empty_with_error_message(){
        WebElement name = driver.findElement(By.id("name"));
        name.clear();
        name.sendKeys("Bronze sword");

        WebElement type = driver.findElement(By.id("type"));
        type.clear();
        type.sendKeys("Sword");

        WebElement amount = driver.findElement(By.id("amount"));
        amount.clear();
        amount.sendKeys("");

        WebElement discription = driver.findElement(By.id("discription"));
        discription.clear();
        discription.sendKeys("This is a sword");

        driver.findElement(By.id("ButtonAdd")).click();

        assertEquals("Add Items" , driver.getTitle());
        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebelementWithText(lis , "Fill an amount in!"));
        assertEquals("Sword", driver.findElement(By.id("type")).getAttribute("value"));
        assertEquals("Bronze sword", driver.findElement(By.id("name")).getAttribute("value"));

    }

    @Test
    public void Test_Form_is_shown_again_when_discription_field_is_empty_with_error_message(){
        WebElement name = driver.findElement(By.id("name"));
        name.clear();
        name.sendKeys("Bronze sword");

        WebElement type = driver.findElement(By.id("type"));
        type.clear();
        type.sendKeys("Sword");

        WebElement amount = driver.findElement(By.id("amount"));
        amount.clear();
        amount.sendKeys("10");

        WebElement discription = driver.findElement(By.id("discription"));
        discription.clear();
        discription.sendKeys("");

        driver.findElement(By.id("ButtonAdd")).click();

        assertEquals("Add Items" , driver.getTitle());
        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebelementWithText(lis , "fill in a discription!"));
        assertEquals("Bronze sword", driver.findElement(By.id("name")).getAttribute("value"));
        assertEquals("Sword", driver.findElement(By.id("type")).getAttribute("value"));
        assertEquals("10", driver.findElement(By.id("amount")).getAttribute("value"));
    }

    @Test
    public void Test_overview_is_shown_when_all_fields_are_filled_in_and_submitted(){
        WebElement name = driver.findElement(By.id("name"));
        name.clear();
        name.sendKeys("Bronze sword");

        WebElement type = driver.findElement(By.id("type"));
        type.clear();
        type.sendKeys("Sword");

        WebElement amount = driver.findElement(By.id("amount"));
        amount.clear();
        amount.sendKeys("10");

        WebElement discription = driver.findElement(By.id("discription"));
        discription.clear();
        discription.sendKeys("This is a sword");

        driver.findElement(By.id("ButtonAdd")).click();

        assertEquals("Overview" , driver.getTitle());
        ArrayList<WebElement> table = (ArrayList<WebElement>) driver.findElements(By.tagName("td"));
        assertTrue(containsWebelementWithText(table , "Bronze sword"));
    }

    @Test
    public void link_SearchItem_is_marked_as_actual() {
        driver.get(url+"?command=findItem");
        WebElement link = driver.findElement(By.id("actual"));
        assertEquals("Search item", link.getText());
    }

    @Test
    public void link_logbook_is_marked_as_actual() {
        driver.get(url+"Servlet?command=logBook");
        WebElement link = driver.findElement(By.id("actual"));
        assertEquals("Logbook",link.getText());
    }

    @Test
    public void link_overview_is_marked_as_actual() {
        driver.get(url+"Servlet?command=overview");
        WebElement link = driver.findElement(By.id("actual"));
        assertEquals("Overview",link.getText());
    }

    @Test
    public void link_AddPage_is_marked_as_actual() {
        driver.get(url+"Servlet?command=addItem");
        WebElement link = driver.findElement(By.id("actual"));
        assertEquals("Add item",link.getText());
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
