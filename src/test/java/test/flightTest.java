package test;

import constants.flightTestConstants;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.matchers.JUnitMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;


public class flightTest extends chromeBaseTest {


    private void Login() throws Exception {

        System.out.println("Starting Login");

        // Visit site
        driver.get(flightTestConstants.URL);


        // Find username and password elements by css
        WebElement userName = driver.findElement(By.cssSelector(flightTestConstants.USERNAME_PROMPT));
        WebElement password = driver.findElement(By.cssSelector(flightTestConstants.PASSWORD_PROMPT));
        WebElement signInButton = driver.findElement(By.cssSelector(flightTestConstants.LOGIN_BUTTON));


        // Enter user credentials
        userName.sendKeys(flightTestConstants.USERNAME);
        password.sendKeys(flightTestConstants.PASSWORD);


        // Click on sigh in and wait
        signInButton.click();

        //Verify that we're on the correct page
        verifyURL("/mercuryreservation.php");
    }

    private void selectFlight() throws Exception{
        System.out.println("Starting selectFlight");
        //Find elements by css
        Select selectTo = new Select(driver.findElement(By.cssSelector(flightTestConstants.DESTINATION_DROPDOWN)));
        WebElement firstClassRadial = driver.findElement(By.cssSelector(flightTestConstants.SERVICE_CLASS_FIRST));
        WebElement findFlightsContinueButton = driver.findElement(By.cssSelector(flightTestConstants.FLIGHT_FINDER_CONTINUE_BUTTON));


        //Open the dropdown and select destination "London"
        selectTo.selectByVisibleText(flightTestConstants.DESTINATION_VALUE);
        //Select First Class
        firstClassRadial.click();
        //Click on Continue and wait
        findFlightsContinueButton.click();

        //Verify that we're on the correct page
        verifyURL("/mercuryreservation2.php");

        //Find elements by css
        WebElement firstListSecondFlight = driver.findElement(By.cssSelector(flightTestConstants.FIRST_LIST_SECOND_FLIGHT));
        WebElement secondListThirdFlight = driver.findElement(By.cssSelector(flightTestConstants.SECOND_LIST_THIRD_FLIGHT));
        WebElement selectFlightContinueButton = driver.findElement(By.cssSelector(flightTestConstants.SELECT_FLIGHT_CONTINUE_BUTTON));

        //Select the flight specifications
        firstListSecondFlight.click();
        secondListThirdFlight.click();
        //Click on continue and wait
        selectFlightContinueButton.click();

        //Verify that we're on the correct page
        verifyURL("/mercurypurchase.php");


    }

    private void completePassengerData() throws Exception{
        System.out.println("Starting completePassengerData");
        //Find elements by css
        WebElement creditCardNumber = driver.findElement(By.cssSelector(flightTestConstants.CARD_NUMBER));
        WebElement ccFirstName = driver.findElement(By.cssSelector(flightTestConstants.CC_FIRST_NAME));
        WebElement ccMiddleName = driver.findElement(By.cssSelector(flightTestConstants.CC_MIDDLE_NAME));
        WebElement ccLastName = driver.findElement(By.cssSelector(flightTestConstants.CC_LAST_NAME));
        WebElement securePurchaseButton = driver.findElement(By.cssSelector(flightTestConstants.SECURE_PURCHASE_BUTTON));
        Select expirationMonth = new Select(driver.findElement(By.cssSelector(flightTestConstants.EXPIRATION_MONTH)));
        Select expirationYear = new Select(driver.findElement(By.cssSelector(flightTestConstants.EXPIRATION_YEAR)));

        //Complete Passenger data
        creditCardNumber.sendKeys("123456789");
        expirationMonth.selectByVisibleText("12");
        expirationYear.selectByVisibleText("2005");
        ccFirstName.sendKeys("Michael");
        ccMiddleName.sendKeys("David");
        ccLastName.sendKeys("Rosenberg");

        //Click on Secure Purchase button and wait
        securePurchaseButton.click();

        //Verify that we're on the correct page
        verifyURL("/mercurypurchase2.php");

    }

    private void verifyTextExistsInPage(String value) throws AssertionError {
        System.out.println("verifying text");
        assertThat("String not found on the page", driver.getPageSource(), containsString(value));
    }

    private void verifyURL(String value){
        System.out.println("verifying URL");
        assertThat("Unexpected URL", driver.getCurrentUrl(), containsString(value));
    }


    @Test
    public void run() throws Exception{
        Login();
        selectFlight();
        completePassengerData();
        verifyTextExistsInPage("Your \n" + "        itinerary has been booked!");

    }


}
