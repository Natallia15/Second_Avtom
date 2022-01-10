import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        //1 driver.get("https://the-internet.herokuapp.com/add_remove_elements//");
        //2 driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.get("https://catalog.onliner.by/superprice");
    }

    // открыть страницу и сравнить название делейт на кнопке
    @Test
    public void firstTest() {
        WebElement element = driver.findElement(By.xpath("//*[@id=\"content\"]/div/button"));
        element.click();
        WebElement delElement = driver.findElement(By.xpath("//*[@id=\"elements\"]/button"));
        Assert.assertEquals(delElement.getText(), "Delete");
    }


    // открыть список и нажать на второй элемент
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

    // войти в автобарахолку, найти мерседес, вывести в консоль ссылку на 32-й мерс

    @Test
    public void fiveTest() throws InterruptedException {
        driver.get("https://www.onliner.by/");
        WebElement avtobaraholkaElement = driver.findElement(By.xpath("//ul[@class=\"b-main-navigation\"]/li[3]"));
        avtobaraholkaElement.click();
        Thread.sleep(1000);
        WebElement markaElement = driver.findElement(By.xpath("(//div[@class='input-style__real'])[4]"));
        markaElement.click();
        WebElement mersIcon = driver.findElement(By.xpath("//li[@title='Mercedes-Benz']"));
        mersIcon.click();
        Thread.sleep(1000);
        List<WebElement> listMers = driver.findElements(By.xpath("//a[starts-with(@href,'/mercedes-benz')]"));
        String s = listMers.get(31).getAttribute("href");
        System.out.println(s);
        listMers.get(31).click();

        Assert.assertEquals(driver.getCurrentUrl(),s);

    }

    @Test
    public void sixTest() throws InterruptedException {
        driver.get("https://ab.onliner.by/mercedes-benz");
        List<WebElement> listMers = driver.findElements(By.xpath("//a[starts-with(@href,'/mercedes-benz')]"));
        System.out.println(listMers.size());
        listMers.get(31).click();
        Thread.sleep(1000);

    }


}