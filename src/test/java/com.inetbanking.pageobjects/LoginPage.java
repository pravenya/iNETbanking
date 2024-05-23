package com.inetbanking.pageobjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
    WebDriver ldriver;
    WebDriverWait wait;

    public LoginPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(name = "uid")
    WebElement txtUserName;
    @FindBy(name = "password")
    WebElement txtPassword;
    @FindBy(name = "btnLogin")
    WebElement btnLogin;
    @FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
    WebElement lnkLogout;

    public void setUserName(String uname) {
        txtUserName.sendKeys(uname);
    }
    public void setPassword(String pwd) {
        txtPassword.sendKeys(pwd);
    }
    public void ClickSubmit() {
        btnLogin.click();
    }
    public void ClickLogout() {
        lnkLogout.click();
    }

}
