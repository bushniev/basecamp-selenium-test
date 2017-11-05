import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private static WebDriver driver;

    @BeforeClass
    public static void start()
    {
        driver = new ChromeDriver();
        driver.get("file:///D:/Download/calc.html");
    }

    @Before
    public void cleanup()
    {
        driver.findElement(By.xpath("//input[@value='C']")).click();
    }
    @Test
    public void add_test()
    {
        driver.findElement(By.xpath("//input[@value='1']")).click();
        driver.findElement(By.xpath("//input[@value='2']")).click();
        driver.findElement(By.xpath("//input[@value='+']")).click();
        driver.findElement(By.xpath("//input[@value='1']")).click();
        driver.findElement(By.xpath("//input[@value='5']")).click();
        driver.findElement(By.xpath("//input[@value='=']")).click();
        Assert.assertEquals("27", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    }
    @Test
    public void subtraction_test()
    {
        driver.findElement(By.xpath("//input[@value='2']")).click();
        driver.findElement(By.xpath("//input[@value='5']")).click();
        driver.findElement(By.xpath("//input[@value='-']")).click();
        driver.findElement(By.xpath("//input[@value='1']")).click();
        driver.findElement(By.xpath("//input[@value='0']")).click();
        driver.findElement(By.xpath("//input[@value='=']")).click();
        Assert.assertEquals("15", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    }
    @Test
    public void multiplication_test()
    {
        driver.findElement(By.xpath("//input[@value='1']")).click();
        driver.findElement(By.xpath("//input[@value='2']")).click();
        driver.findElement(By.xpath("//input[@value='x']")).click();
        driver.findElement(By.xpath("//input[@value='1']")).click();
        driver.findElement(By.xpath("//input[@value='1']")).click();
        driver.findElement(By.xpath("//input[@value='=']")).click();
        Assert.assertEquals("132", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    }
    @Test
    public void division_test()
    {
        driver.findElement(By.xpath("//input[@value='6']")).click();
        driver.findElement(By.xpath("//input[@value='0']")).click();
        driver.findElement(By.xpath("//input[@value='/']")).click();
        driver.findElement(By.xpath("//input[@value='1']")).click();
        driver.findElement(By.xpath("//input[@value='5']")).click();
        driver.findElement(By.xpath("//input[@value='=']")).click();
        Assert.assertEquals("4", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    }
    @AfterClass
    public static void stop()
    {
        driver.quit();

    }
}

