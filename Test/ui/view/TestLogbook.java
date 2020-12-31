package ui.view;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import static org.junit.Assert.assertTrue;

public class TestLogbook {

    private WebDriver driver;
    private String url = "http://localhost:8080/r0810957_Web2_Project_HTML_war_exploded/";

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Joram\\JavaProjects\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }



    @Test
    public void Test_visited_overview_page_added_to_logbook(){
        driver.get(url+"?command=overview");
        driver.get(url+"?command=logBook");
        assertTrue(containsTDwithValue(driver,"Checked the overview"));
        assertTrue(containsTDwithValue(driver,"Checked the logbook"));

    }

    @Test
    public void Test_visited_logbook_is_added_to_logbook(){
        driver.get(url+"?command=logBook");
        assertTrue(containsTDwithValue(driver,"Checked the logbook"));
    }

    @Test
    public void Test_added_item_is_added_to_logbook_when_adding_an_item() {
        driver.get(url+"AddPage.jsp");
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

        driver.get(url+"?command=logBook");
        assertTrue(containsTDwithValue(driver,"Added an item"));
        assertTrue(containsTDwithValue(driver,"Checked the logbook"));
    }

    @Test
    public void Test_search_item_added_to_logbook_when_an_item_is_looked_for() {

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

        driver.get(url+"?command=logBook");
        assertTrue(containsTDwithValue(driver,"Looked for an item"));
        assertTrue(containsTDwithValue(driver,"Checked the logbook"));

    }

    @Test
    public void Test_edited_item_is_shown_in_logbook_after_editing_item() {

        driver.get(url+ "AddPage.jsp");
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


        driver.get(url + "Servlet?command=edit&name=Bronze%20sword&type=sword&amount=10&discription=10");

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

        driver.get(url+"?command=logBook");
        assertTrue(containsTDwithValue(driver,"Edited an item"));
        assertTrue(containsTDwithValue(driver,"Checked the logbook"));

    }


    private boolean containsTDwithValue(WebDriver driver, String value) {
        List<WebElement> tds = driver.findElements(By.tagName("td"));
        for (WebElement td : tds) {
            if (td.getText().equals(value))
                return true;
        }
        return false;
    }
}
