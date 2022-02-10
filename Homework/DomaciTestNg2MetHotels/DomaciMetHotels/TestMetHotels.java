package DomaciMetHotels;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.io.IOException;
import java.time.Duration;

public class TestMetHotels {

    public static WebDriver driver;

    @BeforeClass
    public void init() throws IOException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");

       driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.manage().window().maximize();
    }
   @AfterClass
    public void zatvoriWebDriver() throws IOException {
        driver.close();
        System.out.println("Web driver closed");
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
    }

    @Test
    public void testiranjeFunkcionalnostiMetHotels() throws InterruptedException {
        System.out.println("Go to https://it-255-dz-06-andjela-bojic3972.vercel.app/");
       driver.get("https://it-255-dz-06-andjela-bojic3972.vercel.app/");

        System.out.println("Assert that the current url is correct");
        Assert.assertEquals(driver.getCurrentUrl(), "https://it-255-dz-06-andjela-bojic3972.vercel.app/",
                "The current url should be equal to https://it-255-dz-06-andjela-bojic3972.vercel.app/");
        System.out.println("The current url is correct");
        System.out.println();

        MetHotelsPage page = new MetHotelsPage(driver);

        page.brisanje();

        page.dodajNovSmestaj();
        Thread.sleep(3000);
        Assert.assertTrue(driver.getPageSource().contains("Apartman de Lux"));

        page.dodajNovuSobu();
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.xpath("//h5[contains(text(),'Apartman de Lux')]"))
                .getText().contains("Dnevna -- 25m2"));
    }

}
