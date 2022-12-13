package com.xyzbank.pages;

import com.aventstack.extentreports.Status;
import com.xyzbank.customlisteners.CustomListeners;
import com.xyzbank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class BankManagerLoginPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Bank Manager Login')]")
    WebElement bankManagerLogin;

    public void clickOnBankManagerLogin() {
        CustomListeners.test.log(Status.PASS, "Click on bank manager login button ");
        clickOnElement(bankManagerLogin);
    }

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Add Customer')]")
    WebElement addCustomer;

    public void clickOnAddCustomerTab() {
        CustomListeners.test.log(Status.PASS, "Click on Add Customer Tab");
        clickOnElement(addCustomer);
    }

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstNameField;

    public void enterFirstName(String firstName) {
        CustomListeners.test.log(Status.PASS, "Enter first name"+ firstName);
        sendTextToElement(firstNameField, firstName);
    }
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastNameField;
    public void enterLastName(String lastName) {
        CustomListeners.test.log(Status.PASS, "Enter last name"+ lastName);
        sendTextToElement(lastNameField, lastName);
    }
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postCodeField;
    public void enterPostCode(String postCode) {
        CustomListeners.test.log(Status.PASS, "Enter post code"+ postCode);
        sendTextToElement(postCodeField, postCode);
    }
    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement addCustomerSubmitTab;

    public void clickOnAddCustomerSubmitTab() {
        CustomListeners.test.log(Status.PASS, " click On Add Customer");
        clickOnElement(addCustomerSubmitTab);
    }

    public String verifyTextFromPopUp() {
        return getTextFromAlert();
    }

    public void acceptAlert() {
        CustomListeners.test.log(Status.PASS, " Accept alert");
        driver.switchTo().alert().accept();
    }

}
