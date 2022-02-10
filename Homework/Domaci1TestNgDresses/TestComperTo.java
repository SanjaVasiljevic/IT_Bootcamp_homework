import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Dresses;
import java.io.IOException;
import java.time.Duration;


    public class TestComperTo {

    public static WebDriver driver;


    @BeforeClass
    public static void init() throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        setProperties();
    }

    public static void setProperties() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testCompareDresses() throws IOException, InterruptedException {

        driver.get("http://automationpractice.com/index.php?id_category=8&controller=category");
        driver.manage().window().maximize();
        System.out.println("Assert that the current url is correct");
        Assert.assertEquals(driver.getCurrentUrl(), "http://automationpractice.com/index.php?id_category=8&controller=category",
                "The url should be 'http://automationpractice.com/index.php?id_category=8&controller=category' ");
        System.out.println("The current url is correct");
        System.out.println();
        Dresses poredjenje = new Dresses(driver);

        System.out.println("Add 2 dresses for comparison");
        poredjenje.addDressesToComer();
        poredjenje.clickCompareButton();
        System.out.println();

        String firstDressName = poredjenje.getFirstDressName();
        String secondDressName = poredjenje.getSecondDressName();

        Assert.assertEquals(firstDressName, "Colorful Dress", "The first dress name should be 'Colorful Dress' ");
        Assert.assertEquals(secondDressName, "Short Dress", "The second dress name should be 'Short Dress' ");
        System.out.println("Both dress are added to compare");

        driver.close();
    }

}

