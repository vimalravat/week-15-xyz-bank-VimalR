package com.xyzbank.pages;

import com.aventstack.extentreports.Status;
import com.xyzbank.customlisteners.CustomListeners;
import com.xyzbank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class OpenAccountPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement bankManagerLogin;

    public void clickOnBankManagerLogin() {
        CustomListeners.test.log(Status.PASS, "Click on bank manager login button ");
        clickOnElement(bankManagerLogin);
    }
    @CacheLookup
    @FindBy(xpath = "//button[@ng-click='openAccount()']")
    WebElement getOpenCustomerAccountTab;
    public void clickOnOpenAccountTab() {
        CustomListeners.test.log(Status.PASS, "Click on bank manager login button ");
        clickOnElement(getOpenCustomerAccountTab);
    }
    @CacheLookup
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement customerNameLookUp;

    public void clickAndSelectCustomerName() {
        CustomListeners.test.log(Status.PASS, "Click on bank manager login button ");

        selectByVisibleTextFromDropDown(customerNameLookUp, "Hermoine Granger");
    }
    @CacheLookup
    @FindBy(xpath = "//select[@id='currency']")
    WebElement currencyTypeLookUp;
    public void clickAndSelectCurrencyType() {
        CustomListeners.test.log(Status.PASS, "Click on bank manager login button ");

        selectByVisibleTextFromDropDown(currencyTypeLookUp, "Pound");
    }
    By processButtonTab= By.xpath("//button[contains(text(),'Process')]");
    public void clickOnProcessButtonTab() {
        CustomListeners.test.log(Status.PASS, "Click on bank manager login button ");

        clickOnElement(processButtonTab);
    }
    public String verifyTextFromPopUp(){
        return getTextFromAlert();
    }
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
}
