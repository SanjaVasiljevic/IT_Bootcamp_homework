package pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Dresses {

    private WebDriver driver;

    public Dresses(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/ul[1]/li[3]/a[1]")
    WebElement summerDresses;

    @FindBy(xpath ="//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img")
    WebElement dress1;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[3]/div[2]/a")
    WebElement addToCompare1;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[1]/img")
    WebElement dress2;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[2]/div/div[3]/div[2]/a")
    WebElement addToCompare2;

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/div[2]/div[2]/form[1]")
    WebElement compareButton;

    @FindBy(xpath = "//*[@id=\"product_comparison\"]/tbody/tr[2]/td[2]")
    WebElement firstDressName;
    @FindBy(xpath = "//*[@id=\"product_comparison\"]/tbody/tr[2]/td[3]")
    WebElement secondDressName;

    public void addDressesToComer() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dress1);
        summerDresses.click();
        Actions action= new Actions(driver);
        action.moveToElement(dress1);
        action.moveToElement(addToCompare1);
        action.click().build().perform();
        Thread.sleep(3000);
        action.moveToElement(dress2);
        action.moveToElement(addToCompare2);
        action.click().build().perform();
        Thread.sleep(3000);



    }
    public void clickCompareButton() {

        compareButton.click();
    }

    public String getFirstDressName () {
        return dress1.getText();
    }

    public String getSecondDressName () {
        return dress2.getText();
    }
}
