package Base;

import DomaciDataProvaiderTextBox.TextBoxPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import pages.PracticeAutomatio.LogInPage;
import pages.PracticeAutomatio.LogOutPage;
import pages.PracticeAutomatio.PracticePage;
import pages.PracticeAutomatio.SidebarPage;

import java.io.IOException;
import java.time.Duration;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait webDriverWait;
    public SidebarPage sidebarPage;
    public PracticePage practicePage;
    public LogInPage logInPage;
    public LogOutPage logOutPage;
    public TextBoxPage textBoxPage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        sidebarPage = new SidebarPage(driver,webDriverWait);
        practicePage=new PracticePage(driver,webDriverWait);
        logInPage=new LogInPage(driver,webDriverWait);
        logOutPage=new LogOutPage(driver,webDriverWait);
        textBoxPage=new TextBoxPage(driver, webDriverWait);
    }

    @AfterClass
    public void tearDown() throws IOException {
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");

    }
}
