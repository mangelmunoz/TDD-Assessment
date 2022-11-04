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
        driver.get("http://localhost:3000/home");
        driver.manage().window().maximize();
    }

    @AfterMethod
    void tearOutMethod(){ driver.quit(); }

    @Test
    void testSearchForFlights_givenOriginAndDestinationAndDate_returnsResult() throws InterruptedException {
        WebElement selectorOrigin = driver.findElement(By.xpath("//*[text()=\"Selecciona origen...\"]/parent::*"));
        selectorOrigin.sendKeys("VALENCIA");

        WebElement selectorDestination = driver.findElement(By.xpath("//*[text()=\"Selecciona destino...\"]/parent::*"));
        selectorDestination.sendKeys("CORDOBA");

        WebElement selectorOptionCalendar = driver.findElement(By.xpath("//*[text()=\"Seleccionar fecha...\"]/parent::*"));
        selectorOptionCalendar.sendKeys("Si");

        WebElement selectorCalendar = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/div[5]/div/div[2]/div/div/div/div[2]/button[8]/abbr/parent::*"));
        selectorCalendar.click();

        driver.findElement(By.xpath("//*[text()=\"Buscar vuelos\"]")).click();

        Thread.sleep(1000);

        Assert.assertNotNull(driver.findElement(By.className("flightNameDiv")));
    }

    @Test
    void testSearchForFlights_givenOriginAndDate_returnsResult() throws InterruptedException {
        WebElement selectorOrigin = driver.findElement(By.xpath("//*[text()=\"Selecciona origen...\"]/parent::*"));
        selectorOrigin.sendKeys("VALENCIA");

        WebElement selectorOptionCalendar = driver.findElement(By.xpath("//*[text()=\"Seleccionar fecha...\"]/parent::*"));
        selectorOptionCalendar.sendKeys("Si");

        WebElement selectorCalendar = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/form/div[5]/div/div[2]/div/div/div/div[2]/button[8]/abbr/parent::*"));
        selectorCalendar.click();

        driver.findElement(By.xpath("//*[text()=\"Buscar vuelos\"]")).click();

        Thread.sleep(1000);

        Assert.assertNotNull(driver.findElement(By.className("flightNameDiv")));
    }

    @Test
    void testSearchForFlights_givenOriginAndDestination_returnsResult() throws InterruptedException {
        WebElement selectorOrigin = driver.findElement(By.xpath("//*[text()=\"Selecciona origen...\"]/parent::*"));
        selectorOrigin.sendKeys("VALENCIA");

        WebElement selectorDestination = driver.findElement(By.xpath("//*[text()=\"Selecciona destino...\"]/parent::*"));
        selectorDestination.sendKeys("CORDOBA");

        driver.findElement(By.xpath("//*[text()=\"Buscar vuelos\"]")).click();

        Thread.sleep(1000);

        Assert.assertNotNull(driver.findElement(By.className("flightNameDiv")));
    }

    @Test
    void bookAFlight_givenOriginAndDestination_returnsResult() throws InterruptedException{

        testSearchForFlights_givenOriginAndDestination_returnsResult();

        driver.findElement(By.xpath("//*[text()=\"Reservar vuelo\"]")).click();

        Thread.sleep(1000);

        WebElement inputName = driver.findElement(By.id("inputName"));
        inputName.sendKeys("Test");

        WebElement firstSurname = driver.findElement(By.id("firstSurname"));
        firstSurname.sendKeys("Test");

        WebElement secondSurname = driver.findElement(By.id("secondSurname"));
        secondSurname.sendKeys("Test");

        WebElement inputNationality = driver.findElement(By.id("inputNationality"));
        inputNationality.sendKeys("Test");

        WebElement inputIdentification = driver.findElement(By.id("inputIdentification"));
        inputIdentification.sendKeys("Test");

        WebElement inputYears = driver.findElement(By.id("inputYears"));
        inputYears.sendKeys("20");

        WebElement luggage = driver.findElement(By.id("luggage"));
        luggage.click();

        Thread.sleep(5000);

    }

}
