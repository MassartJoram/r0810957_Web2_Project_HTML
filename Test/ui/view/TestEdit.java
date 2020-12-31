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

public class TestEdit {

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
    public void Test_Form_edit_after_submitting_with_error_message_no_fields_filled_in(){

        WebElement nameAdd = driver.findElement(By.id("name"));
        nameAdd.clear();
        nameAdd.sendKeys("Bronze sword");

        WebElement typeAdd = driver.findElement(By.id("type"));
        typeAdd.clear();
        typeAdd.sendKeys("Sword");

        WebElement amountAdd = driver.findElement(By.id("amount"));
        amountAdd.clear();
        amountAdd.sendKeys("10");

        WebElement discriptionAdd = driver.findElement(By.id("discription"));
        discriptionAdd.clear();
        discriptionAdd.sendKeys("10");

        driver.findElement(By.id("ButtonAdd")).click();


        driver.get(url +"Servlet?command=edit&name=Bronze%20sword&type=sword&amount=10&discription=10");

        WebElement type = driver.findElement(By.id("type"));
        type.clear();
        type.sendKeys("");

        WebElement amount = driver.findElement(By.id("amount"));
        amount.clear();
        amount.sendKeys("");

        WebElement discription = driver.findElement(By.id("discription"));
        discription.clear();
        discription.sendKeys("");



        driver.findElement(By.id("buttonEdit")).click();

        assertEquals("Edit Items" , driver.getTitle());
        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebelementWithText(lis , "Fill an amount in!"));
        assertTrue(containsWebelementWithText(lis , "fill in a type!"));
        assertTrue(containsWebelementWithText(lis , "fill in a discription!"));
    }

    @Test
    public void Test_Form_edit_after_submitting_with_error_message_type_field_not_filled_in(){

        WebElement nameAdd = driver.findElement(By.id("name"));
        nameAdd.clear();
        nameAdd.sendKeys("Bronze sword");

        WebElement typeAdd = driver.findElement(By.id("type"));
        typeAdd.clear();
        typeAdd.sendKeys("Sword");

        WebElement amountAdd = driver.findElement(By.id("amount"));
        amountAdd.clear();
        amountAdd.sendKeys("10");

        WebElement discriptionAdd = driver.findElement(By.id("discription"));
        discriptionAdd.clear();
        discriptionAdd.sendKeys("10");

        driver.findElement(By.id("ButtonAdd")).click();


        driver.get(url +"Servlet?command=edit&name=Bronze%20sword&type=sword&amount=10&discription=10");

        WebElement type = driver.findElement(By.id("type"));
        type.clear();
        type.sendKeys("");

        WebElement amount = driver.findElement(By.id("amount"));
        amount.clear();
        amount.sendKeys("15");

        WebElement discription = driver.findElement(By.id("discription"));
        discription.clear();
        discription.sendKeys("This is an old sword");



        driver.findElement(By.id("buttonEdit")).click();

        assertEquals("Edit Items" , driver.getTitle());
        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebelementWithText(lis , "fill in a type!"));
    }

    @Test
    public void Test_Form_edit_after_submitting_with_error_message_amount_field_not_filled_in(){

        WebElement nameAdd = driver.findElement(By.id("name"));
        nameAdd.clear();
        nameAdd.sendKeys("Bronze sword");

        WebElement typeAdd = driver.findElement(By.id("type"));
        typeAdd.clear();
        typeAdd.sendKeys("Sword");

        WebElement amountAdd = driver.findElement(By.id("amount"));
        amountAdd.clear();
        amountAdd.sendKeys("10");

        WebElement discriptionAdd = driver.findElement(By.id("discription"));
        discriptionAdd.clear();
        discriptionAdd.sendKeys("10");

        driver.findElement(By.id("ButtonAdd")).click();


        driver.get(url +"Servlet?command=edit&name=Bronze%20sword&type=sword&amount=10&discription=10");

        WebElement type = driver.findElement(By.id("type"));
        type.clear();
        type.sendKeys("Blade");

        WebElement amount = driver.findElement(By.id("amount"));
        amount.clear();
        amount.sendKeys("");

        WebElement discription = driver.findElement(By.id("discription"));
        discription.clear();
        discription.sendKeys("This is an old sword");



        driver.findElement(By.id("buttonEdit")).click();

        assertEquals("Edit Items" , driver.getTitle());
        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebelementWithText(lis , "Fill an amount in!"));
    }

    @Test
    public void Test_Form_edit_after_submitting_with_error_message_discription_field_not_filled_in(){

        WebElement nameAdd = driver.findElement(By.id("name"));
        nameAdd.clear();
        nameAdd.sendKeys("Bronze sword");

        WebElement typeAdd = driver.findElement(By.id("type"));
        typeAdd.clear();
        typeAdd.sendKeys("Sword");

        WebElement amountAdd = driver.findElement(By.id("amount"));
        amountAdd.clear();
        amountAdd.sendKeys("10");

        WebElement discriptionAdd = driver.findElement(By.id("discription"));
        discriptionAdd.clear();
        discriptionAdd.sendKeys("10");

        driver.findElement(By.id("ButtonAdd")).click();


        driver.get(url +"Servlet?command=edit&name=Bronze%20sword&type=sword&amount=10&discription=10");

        WebElement type = driver.findElement(By.id("type"));
        type.clear();
        type.sendKeys("Blade");

        WebElement amount = driver.findElement(By.id("amount"));
        amount.clear();
        amount.sendKeys("15");

        WebElement discription = driver.findElement(By.id("discription"));
        discription.clear();
        discription.sendKeys("");



        driver.findElement(By.id("buttonEdit")).click();

        assertEquals("Edit Items" , driver.getTitle());
        ArrayList<WebElement> lis = (ArrayList<WebElement>) driver.findElements(By.tagName("li"));
        assertTrue(containsWebelementWithText(lis , "fill in a discription!"));
    }

    @Test
    public void Test_show_overview_with_edited_values_after_submitting(){

        WebElement nameAdd = driver.findElement(By.id("name"));
        nameAdd.clear();
        nameAdd.sendKeys("Bronze sword");

        WebElement typeAdd = driver.findElement(By.id("type"));
        typeAdd.clear();
        typeAdd.sendKeys("Sword");

        WebElement amountAdd = driver.findElement(By.id("amount"));
        amountAdd.clear();
        amountAdd.sendKeys("10");

        WebElement discriptionAdd = driver.findElement(By.id("discription"));
        discriptionAdd.clear();
        discriptionAdd.sendKeys("10");

        driver.findElement(By.id("ButtonAdd")).click();


        driver.get(url +"Servlet?command=edit&name=Bronze%20sword&type=sword&amount=10&discription=10");

        WebElement type = driver.findElement(By.id("type"));
        type.clear();
        type.sendKeys("Blade");

        WebElement amount = driver.findElement(By.id("amount"));
        amount.clear();
        amount.sendKeys("15");

        WebElement discription = driver.findElement(By.id("discription"));
        discription.clear();
        discription.sendKeys("This is an old sword");



        driver.findElement(By.id("buttonEdit")).click();

        assertEquals("Overview" , driver.getTitle());
        ArrayList<WebElement> table = (ArrayList<WebElement>) driver.findElements(By.tagName("td"));
        assertTrue(containsWebelementWithText(table , "Blade"));
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
