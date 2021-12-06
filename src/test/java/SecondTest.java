import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class SecondTest {
    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //1.driver.get("https://the-internet.herokuapp.com/add_remove_elements//");
        //2.driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.get("https://catalog.onliner.by/superprice");
    }

    @Test
    public void firstTest() {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"content\"]/div/button"));
element.click();
WebElement delElement = driver.findElement(By.xpath("//*[@id=\"elements\"]/button"));
        Assert.assertEquals(delElement.getText(), "Delete");

    }
    @Test
    public void secondTest() {
        WebElement element2 = driver.findElement(By.xpath("//*[@id=\"dropdown\"]"));
        element2.click();
        WebElement listElement = driver.findElement(By.xpath("//*[@id=\"dropdown\"]/option[3]"));
        listElement.click();
        Assert.assertEquals(listElement.getText(), "Option 2");
    }
@Test
    public void thirdTest() {

        List<WebElement> list = driver.findElements(By.xpath("//ul[@class='b-main-navigation']/li"));
        list.forEach(item ->
                System.out.println(item.getText()));
    }
// нажать на каталог и вывести все элементы

    @Test
    public void forTest() {
    WebElement element3 = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div/header/div[2]/div/nav/ul[1]/li[1]/a[2]/span"));
  element3.click();
    List<WebElement> list = driver.findElements(By.xpath("//li[@class='catalog-navigation-classifier__item ']"));
        list.forEach(item ->
            System.out.println(item.getText()));
}
// войти в автобарахолку, найти мерседес, 13 номер, вывести в консоль ссылку на этот мерс
    @Test
    public void fiveTest() {
        WebElement element4 = driver.findElement(By.xpath("//ul[@class=\"b-main-navigation\"]/li[3]"));
        element4.click();
        WebElement element5 = driver.findElement(By.xpath("////*[@id=\"container\"]/div/div/div/div/div/div[2]/div/div/div[3]/div/div[2]/div[2]/div[2]/div[2]/div/div[2]/div[1]/div/div/div[1]/div/div[1]/div[2]"));
        element5.click();
        WebElement element6 = driver.findElement(By.xpath("//ul[@class=\"dropdown-style__list dropdown-style__list_brand\"]li[Mercedes-Benz]"));
        element6.click();


        Assert.assertEquals(element5.getText(), "Mercedes");

    }


}
