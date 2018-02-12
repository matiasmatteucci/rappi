package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class chromeBaseTest {

    private static ChromeDriverService service;
    public WebDriver driver;


    @BeforeClass
    public static void createAndStartService() throws IOException {

        System.setProperty("webdriver.chrome.driver", "bin/chromedriver");

        service = new ChromeDriverService.Builder()
                .usingAnyFreePort()
                .build();
        service.start();

    }

    @AfterClass
    public void createAndStopService() {

          service.stop();
    }

    @BeforeMethod
    public void createDriver() {
        System.out.println("creating chrome driver");
        driver = new RemoteWebDriver(service.getUrl(),
                DesiredCapabilities.chrome());

        //explicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @AfterMethod
    public void quitDriver() {
        System.out.println("tearing down chrome driver");

        driver.quit();


    }
}
