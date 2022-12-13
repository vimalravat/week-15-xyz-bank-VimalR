package com.xyzbank.pages;

import com.aventstack.extentreports.Status;
import com.xyzbank.customlisteners.CustomListeners;
import com.xyzbank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CustomerLoginPage extends Utility {
    //click on "Customer Login" Tab
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Customer Login')]")
    WebElement customerLogin;
    public void clickOnCustomerLogin() {
        CustomListeners.test.log(Status.PASS, "Click on Customer Login Tab");
        clickOnElement(customerLogin);
    }

    //	search customer that you created.
    @CacheLookup
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement customerNameLookUp;
    public void clickAndSelectCustomerName() {
        CustomListeners.test.log(Status.PASS, "Click on Add Customer Tab");
        selectByVisibleTextFromDropDown(customerNameLookUp, "Hermoine Granger");
    }

    //	click on "Login" Button
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement customerLoginTab;
    public void clickOnCustomerLoginTab() {
        CustomListeners.test.log(Status.PASS, "Click on Add Customer Tab");
        clickOnElement(customerLoginTab);
    }

    //	verify "Logout" Tab displayed.
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    WebElement customerLogoutTab;
    public String verifyLogoutMessage(){
        return getTextFromElement(customerLogoutTab);
    }

    public void clickOnCustomerLogoutTab() {
        CustomListeners.test.log(Status.PASS, "Click on Customer logout Tab");
        clickOnElement(customerLogoutTab);
    }


    //	verify "Your Name" text displayed.
    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'Your Name :')]")
    WebElement customerNameOnPage;
    public String verifyCustomerNameIsDisplayed(){
         return getTextFromElement(customerNameOnPage);
           }

}
