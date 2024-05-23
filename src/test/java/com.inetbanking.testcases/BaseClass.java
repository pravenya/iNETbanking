package com.inetbanking.testcases;


import com.inetbanking.utilities.ReadConfig;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;


public class BaseClass {
    ReadConfig readconfig = new ReadConfig();
    public String baseURL = readconfig.getApplicationURL();
    public String username = readconfig.getUsername();
    public String password = readconfig.getPassword();
    public static WebDriver driver;
    public static Logger logger;
    WebDriverWait wait;

    @Parameters("browser")
    @BeforeClass
    public void setup(String br) {
        //System.out.println("./Drivers\\chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
        //Logger logger= Logger.getLogger("ebanking"); now iam making loggger public so it will be used allover
        logger = Logger.getLogger(BaseClass.class);
        PropertyConfigurator.configure("log4j.properties");

        if(br.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
            driver = new ChromeDriver();
        }
        else if(br.equals("firefox")){
            System.setProperty("webdriver.chrome.driver", readconfig.getFirefoxPath());
            driver = new FirefoxDriver();
        }
        else if(br.equals("ie")){
            System.setProperty("webdriver.chrome.driver", readconfig.getIEPath());
            driver = new InternetExplorerDriver();
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(baseURL);

    }
    public String captureScreen(WebDriver driver, String tname) throws IOException {
           // TakesScreenshot ts = (TakesScreenshot) driver;
            //File source = ts.getScreenshotAs(OutputType.FILE);
            //File target = new File(".\\ScreenShots");
           // FileUtils.copyFile(source, target);
            System.out.println("Screen shot taken ");
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dir = System.getProperty("user.dir") + "\\ScreenShots\\";
        File directory = new File(dir);
        if (!directory.exists()) {
            directory.mkdir();
        }
        String destination = dir + tname + dateName + ".png";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        return destination;
    }

    public String randomString(){
        String generatedString= RandomStringUtils.randomAlphabetic(8);
        return(generatedString);
    }
    public String randomNumber(){
        String generatedString2= RandomStringUtils.randomNumeric(5);
        return(generatedString2);
    }

   @AfterClass
     public void teardown() {
        driver.quit();
  }

}
