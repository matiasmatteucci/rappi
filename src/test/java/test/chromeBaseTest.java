package test; /**
 * Created by Matias on 15/07/2015.
 * This is a base test class for the purpose of initializing and tearing down the driver.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;


@RunWith(BlockJUnit4ClassRunner.class)
public class chromeBaseTest {

    private static ChromeDriverService service;
    public WebDriver driver;


    @BeforeClass
    public static void createAndStartService() throws IOException {
        service = new ChromeDriverService.Builder()
  //                You can set up a local path for a specific instance of chromedriver here
  //              .usingDriverExecutable(new File("E:/chromedriver/chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        service.start();

    }

    @AfterClass
    public static void createAndStopService() {

        service.stop();
    }

    @Before
    public void createDriver() {
        driver = new RemoteWebDriver(service.getUrl(),
                DesiredCapabilities.chrome());


    }

    @After
    public void quitDriver(){

        driver.quit();

    }



}