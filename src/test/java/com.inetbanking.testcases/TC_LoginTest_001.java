package com.inetbanking.testcases;

import com.inetbanking.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginTest_001 extends BaseClass {

    @Test
    public void loginTest() throws IOException {

        logger.info("URl is opened");

        LoginPage lp = new LoginPage(driver);
        lp.setUserName(username);
        logger.info("username is entered");

        lp.setPassword(password);
        logger.info("password is entered");

        lp.ClickSubmit();

        String actualTitle = driver.getTitle();
        String expectedTitle = "Guru99 Bank Manager HomePage";
        if (actualTitle.equals(expectedTitle)) {
            Assert.assertTrue(true);
            logger.info("login test is passed");
        } else {
            captureScreen(driver,"loginTest");
            Assert.assertFalse(false);
            logger.info("login test is Failed");
        }
    }
    }


