package DomaciDataProvaiderTextBox;


import Base.BasePage;
import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestTextBox extends BasePage {
        Faker faker;

        @DataProvider(name = "textBox")
        public Object[][] textBox() {
            faker = new Faker();

            return new Object[][] {
                    {faker.name().fullName(), faker.internet().emailAddress(), faker.address().fullAddress(), faker.address().fullAddress()},
                    {faker.name().fullName(), faker.internet().emailAddress(),faker.address().fullAddress(), faker.address().fullAddress()},
                    {faker.name().fullName(), faker.internet().emailAddress(),faker.address().fullAddress(), faker.address().fullAddress()},
                    {faker.name().fullName(), faker.internet().emailAddress(),faker.address().fullAddress(), faker.address().fullAddress()}
            };
        }


        @Test(dataProvider = "textBox")
        public void testTextBox(String name, String email, String currAddress, String permAddress)  {
            driver.navigate().to("https://demoqa.com/text-box");

            TextBoxPage textForm = new TextBoxPage(driver,webDriverWait);
            textForm.inputFullName(name);
            textForm.inputEmail(email);
            textForm.inputCurrentAddress(currAddress);
            textForm.inputPermAddress(permAddress);
            textForm.clickSubmit();

            Assert.assertTrue(textForm.outPut().isDisplayed());
            System.out.println("Out put is displayed");
        }
    }

