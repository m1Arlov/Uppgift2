package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertTrue;

public class RegisterSteps {
    WebDriver driver;

    @Given("user opens registration page")
    public void openRegistrationPage() {
        driver = new ChromeDriver();
        driver.get("file:///C:/Users/mihaj/Downloads/Register%20Basketball%20(1)/Register.html");
    }

    @When("user enters valid registration details")
    public void enterValidDetails() {

        driver.findElement(By.id("dp"))
                .sendKeys("01/01/1990");

        driver.findElement(By.id("member_firstname"))
                .sendKeys("Test");

        driver.findElement(By.id("member_lastname"))
                .sendKeys("User");

        String email = "test" + System.currentTimeMillis() + "@mail.com";

        driver.findElement(By.id("member_emailaddress"))
                .sendKeys(email);

        driver.findElement(By.id("member_confirmemailaddress"))
                .sendKeys(email);

        driver.findElement(By.id("signupunlicenced_password"))
                .sendKeys("Password123");

        driver.findElement(By.id("signupunlicenced_confirmpassword"))
                .sendKeys("Password123");

        driver.findElement(
                By.cssSelector("label[for='signup_basketballrole_19']")
        ).click();
    }

    @When("user enters mismatching passwords")
    public void enterMismatchedPasswords() {

        System.out.println(
                driver.findElement(By.id("signup_basketballrole_19"))
                        .getAttribute("outerHTML")
        );
        driver.findElement(By.id("dp"))
                .sendKeys("01/01/1990");
        driver.findElement(By.id("member_firstname"))
                .sendKeys("Test");
        driver.findElement(By.id("member_lastname"))
                .sendKeys("User");
        String email = "test" + System.currentTimeMillis() + "@mail.com";
        driver.findElement(By.id("member_emailaddress"))
                .sendKeys(email);
        driver.findElement(By.id("member_confirmemailaddress"))
                .sendKeys(email);
        driver.findElement(By.id("signupunlicenced_password"))
                .sendKeys("Password123");
        driver.findElement(By.id("signupunlicenced_confirmpassword"))
                .sendKeys("WrongPassword");
        driver.findElement(
                By.cssSelector("label[for='signup_basketballrole_19']")
        ).click();
    }

    @When("accepts terms and conditions")
    public void acceptTerms() {

        System.out.println(
                driver.findElement(By.id("sign_up_25"))
                        .getAttribute("outerHTML")
        );
        driver.findElement(
                By.cssSelector("label[for='sign_up_25']")
        ).click();

        driver.findElement(
                By.cssSelector("label[for='sign_up_26']")
        ).click();

        driver.findElement(
                By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct']")
        ).click();    }

    @When("clicks create account")
    public void submitForm() {

        driver.findElement(
                        By.cssSelector("input[type='submit']"))
                .click();
    }

    @Then("account should be created successfully")
    public void verifySuccessfulRegistration() {

        assertTrue(
                driver.getCurrentUrl().contains("Success.html")
        );

        driver.quit();
    }

    @Then("password error should be shown")
    public void verifyPasswordMismatchError() {
        WebElement body = driver.findElement(By.tagName("body"));
        assertTrue(body.getText().toLowerCase().contains("password"));
        driver.quit();
    }

    @Then("terms error should be shown")
    public void verifyTermsError() {
        WebElement body = driver.findElement(By.tagName("body"));
        System.out.println("Current URL: " + driver.getCurrentUrl());
        System.out.println(body.getText());
        driver.quit();
    }
}