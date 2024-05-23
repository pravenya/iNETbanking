package com.inetbanking.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCustomerPage {

    WebDriver ldriver;
    WebDriverWait wait;

    public AddCustomerPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }
//web elements finding
    @FindBy(how= How.XPATH, using="/html/body/div[3]/div/ul/li[2]/a")

    WebElement lnkAddNewCustomer;
    @FindBy(how= How.XPATH, using="/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input")
    @CacheLookup
    WebElement txtCustomerName;
    @FindBy(how= How.XPATH, using="/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]")
    @CacheLookup
    WebElement rGender;
    @FindBy(how= How.NAME, using="dob")
    @CacheLookup
    WebElement txtdob;
    @FindBy(how= How.NAME, using="addr")
    @CacheLookup
    WebElement txtaddress;
    @FindBy(how= How.NAME, using="city")
    @CacheLookup
    WebElement txtcity;
    @FindBy(how= How.NAME, using="state")
    @CacheLookup
    WebElement txtstate;
    @FindBy(how= How.NAME, using="pinno")
    @CacheLookup
    WebElement txtpinno;
    @FindBy(how= How.NAME, using="telephoneno")
    @CacheLookup
    WebElement txttelephoneno;
    @FindBy(how= How.NAME, using="emailid")
    @CacheLookup
    WebElement txtemailid;
    @FindBy(how= How.NAME, using="password")
    @CacheLookup
    WebElement txtpassword;
    @FindBy(how= How.NAME, using="sub")
    @CacheLookup
    WebElement btnSubmit;

    //implementation methods for webelements
    public void clickAddNewCustomer(){
        lnkAddNewCustomer.click();
    }
    public void custName(String cname){
        txtCustomerName.sendKeys(cname);
    }
    public void custGender(String cgender){
        rGender.click();
    }
    public void custdob(String yyyy,String mm,String dd){
        txtdob.sendKeys(yyyy);
        txtdob.sendKeys(Keys.ARROW_RIGHT);
        txtdob.sendKeys(mm);
        txtdob.sendKeys(Keys.ARROW_RIGHT);
        txtdob.sendKeys(dd);

    }
    public void custaddress(String cadress){
        txtaddress.sendKeys(cadress);
    }
    public void custcity(String ccity){
        txtcity.sendKeys(ccity);
    }
    public void custstate(String cstate){
        txtstate.sendKeys(cstate);
    }
    public void custpinno(String cpino){
        txtpinno.sendKeys(String.valueOf(cpino));
    }
    public void custtelephoneno(String ctelephoneno){
        txttelephoneno.sendKeys(ctelephoneno);
    }
    public void custemailid(String cemailid){
        txtemailid.sendKeys(cemailid);
    }
    public void custpassword(String cpassword){
        txtpassword.sendKeys(cpassword);
    }
    public void custsubmit(){
        btnSubmit.click();
    }


}
