package DomaciDataProvaiderTextBox;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextBoxPage {

    public WebDriver driver;
    public WebDriverWait webDriverWait;

    @FindBy(id = "userName")
    WebElement userName;
    @FindBy(id = "userEmail")
    WebElement email;
    @FindBy(id = "currentAddress")
    WebElement currentAddress;
    @FindBy(id = "permanentAddress")
    WebElement permAddress;
   @FindBy(xpath = "//button[@id='submit']")
    WebElement submit;

    public TextBoxPage(WebDriver driver,WebDriverWait webDriverWait) {
        this.driver = driver;
        this.webDriverWait = webDriverWait;
        PageFactory.initElements(this.driver, this);
    }

    public void inputFullName(String name) {
        this.userName.sendKeys(name);
    }

    public void inputEmail(String email) {
        this.email.sendKeys(email);
    }

    public void inputCurrentAddress(String currentAddress) {
        this.currentAddress.sendKeys(currentAddress);
    }

    public void inputPermAddress(String permAddress) {
        this.permAddress.sendKeys(permAddress);
    }


    public void clickSubmit() {
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("arguments[0].scrollIntoView()", submit);
        this.submit.click();
    }

    public WebElement outPut() {
        return this.driver.findElement(By.id("output"));
    }
}

