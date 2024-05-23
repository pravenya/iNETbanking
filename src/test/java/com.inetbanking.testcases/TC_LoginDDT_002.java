package com.inetbanking.testcases;

import com.inetbanking.pageobjects.LoginPage;
import com.inetbanking.utilities.XLUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginDDT_002 extends BaseClass{
    @Test(dataProvider="LoginData")
    public void loginDDT(String usr,String pwd){
        LoginPage lp=new LoginPage(driver);
        lp.setUserName(usr);
        logger.info("user name provided");
        lp.setPassword(pwd);
        logger.info("password provided");
        lp.ClickSubmit();  // making login test object and calling all methods

        if(isAlertPresent()==true){   // faliure condition case if alert is there login incorrect
            driver.switchTo().alert().accept(); // if alert present then accept and close it
            driver.switchTo().defaultContent(); // go back to login page for correct credentials
            Assert.assertTrue(false);
            logger.warn("login failed");
        }
        else{
            Assert.assertTrue(true);  // login success as no alert is there , now we need to logout now to go back to previous page
            logger.info("login success");
            lp.ClickLogout(); // click on logout
            driver.switchTo().alert().accept();//close the logout alert
            driver.switchTo().defaultContent();// go back to to the login page
        }
    }

    public boolean isAlertPresent(){  // user defined method to check whether alert is present in the webpage or not
        try {
            driver.switchTo().alert();
            return true;   // means alert present
        }catch (NoAlertPresentException e){
            return false;  // means no alert
        }
    }
    @DataProvider(name="LoginData")
    Object[][] getData() throws IOException {
        String path= ".\\src\\test\\java\\com\\inetbanking\\testdata\\LoginData.xlsx";

        int rownum= XLUtils.getRowCount(path,"Sheet1");
        int colcount=XLUtils.getCellCount(path,"Sheet1",1);

        String logindata[][]=new String[rownum][colcount];

        for(int i=1;i<=rownum;i++){
            for(int j=0;j<colcount;j++){
                logindata[i-1][j]= XLUtils.getCellData(path,"sheet1",i,j);//passing 1,0 indexes of excel to 0,0 in two dimension array
            }
        }
        return  logindata;
    }
}
