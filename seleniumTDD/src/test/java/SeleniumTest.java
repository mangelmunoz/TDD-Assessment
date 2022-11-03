import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SeleniumTest {

    WebDriver driver;

    @BeforeClass
    void setUpClass(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    void setUpMethod(){
        driver = new ChromeDriver();
        driver.get("http://localhost:3000");
        driver.manage().window().maximize();
    }

    @AfterMethod
    void tearOutMethod(){ driver.quit(); }

    @Test
    void testSearchForFlights() throws InterruptedException {
        WebElement selectorOrigin = driver.findElement(By.xpath("//*[text()=\"Selecciona origen...\"]/parent::*"));
        selectorOrigin.sendKeys("VALENCIA");

        WebElement selectorDestination = driver.findElement(By.xpath("//*[text()=\"Selecciona destino...\"]/parent::*"));
        selectorDestination.sendKeys("CORDOBA");

        WebElement selectorOptionCalendar = driver.findElement(By.xpath("//*[text()=\"Seleccionar fecha...\"]/parent::*"));
        selectorOptionCalendar.sendKeys("Si");

        WebElement selectorCalendar = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/div[5]/div/div[2]/div/div/div/div[2]/button[8]/abbr/parent::*"));
        selectorCalendar.click();

        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/input")).click();

        Thread.sleep(5000);

    }
}
