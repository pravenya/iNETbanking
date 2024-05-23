package com.inetbanking.testcases;

import com.inetbanking.pageobjects.AddCustomerPage;
import com.inetbanking.pageobjects.LoginPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_AddCustomerTest_003 extends BaseClass{

    @Test
    public void addNewCustomer() throws InterruptedException, IOException {
        LoginPage lp = new LoginPage(driver);
        lp.setUserName(username);
        logger.info("username is provided");
        lp.setPassword(password);
        logger.info("password is provided");
        lp.ClickSubmit();

        Thread.sleep(4000);

        AddCustomerPage addcust= new AddCustomerPage(driver);
        addcust.clickAddNewCustomer();
        Thread.sleep(3000);
        logger.info("customer providing details");
        addcust.custName("Pravenya");
        addcust.custGender("female");
        addcust.custdob("1997","12","15");
        Thread.sleep(3000);
        addcust.custaddress("Canada");
        addcust.custcity("surrey");
        addcust.custstate("BC");
        addcust.custpinno("522007");
        addcust.custtelephoneno("984802363");

        String email=randomString()+"@gmail.com";
        addcust.custemailid(email);

        addcust.custpassword("abcdef");
        addcust.custsubmit();
        Thread.sleep(3000);

        logger.info("validation started");

        boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
        if(res==true){
            Assert.assertTrue(true);
            logger.info("Test case is passed");
        }
        else{
            captureScreen(driver,"AddNewCustomer");
            Assert.assertTrue(false);
            logger.warn("test case is failed");
        }
    }



}
