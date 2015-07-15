package test;

import constants.gmailTestConstants;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

/**
 * Created by Matias on 12/06/2015.
 */
public class gmailTest {


    WebDriver driver = new FirefoxDriver();


    private void Login() throws Exception{
        // Visit site
        driver.get(gmailTestConstants.URL);


        WebElement usernameField = driver.findElement(By.cssSelector(gmailTestConstants.USERNAME_FIELD));
        WebElement nextButton = driver.findElement(By.cssSelector(gmailTestConstants.NEXT_BUTTON));


        usernameField.sendKeys(gmailTestConstants.USERNAME);
        nextButton.click();

        Thread.sleep(5000);

        WebElement passwordField = driver.findElement(By.cssSelector(gmailTestConstants.PASSWORD_FIELD));
        WebElement signInButton = driver.findElement(By.cssSelector(gmailTestConstants.SIGN_IN_BUTTON));

        passwordField.sendKeys(gmailTestConstants.PASSWORD);
        signInButton.click();

        Thread.sleep(30000);
    }
    private void composeAndSendEmail() throws Exception {
        WebElement composeButton = driver.findElement(By.cssSelector(gmailTestConstants.COMPOSE_BUTTON));

        composeButton.click();

        Thread.sleep(5000);

        WebElement toField = driver.findElement(By.cssSelector(gmailTestConstants.TO_FIELD));
        WebElement subjectField = driver.findElement(By.cssSelector(gmailTestConstants.SUBJECT_FIELD));
        WebElement body = driver.findElement(By.cssSelector(gmailTestConstants.BODY));
        WebElement sendButton = driver.findElement(By.cssSelector(gmailTestConstants.SEND_BUTTON));

        toField.sendKeys(gmailTestConstants.USERNAME);
        subjectField.sendKeys("Super Cool Subject");
        body.sendKeys("Body of email");
        sendButton.click();


        Thread.sleep(5000);
        driver.navigate().refresh();
        Thread.sleep(5000);

        assertThat("Email not found in page", driver.getPageSource(), containsString("Super Cool Subject"));
    }
    private void deleteEmail() throws Exception{

        Thread.sleep(5000);

        List<WebElement> emails = driver.findElements(By.cssSelector(gmailTestConstants.TEST_EMAIL));

        Actions action = new Actions(driver);
        action.contextClick(emails.get(0)).perform();

        WebElement deleteButton = driver.findElement(By.cssSelector(gmailTestConstants.CONTEXT_MENU_DELETE));
        deleteButton.click();

        Thread.sleep(1000);

    }

    @After
    public void quitDriver(){

        driver.quit();
    }


    @Test
    public void run() throws Exception{
        Login();
        composeAndSendEmail();
        deleteEmail();
    }

}
