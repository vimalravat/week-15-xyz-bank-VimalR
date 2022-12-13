package com.xyzbank.testsuite;

import com.xyzbank.customlisteners.CustomListeners;
import com.xyzbank.pages.AccountPage;
import com.xyzbank.pages.BankManagerLoginPage;
import com.xyzbank.pages.CustomerLoginPage;
import com.xyzbank.pages.OpenAccountPage;
import com.xyzbank.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class BankTestPage extends BaseTest {
    BankManagerLoginPage bankManagerLoginPage;
    AccountPage accountPage;
    CustomerLoginPage customerLoginPage;
    OpenAccountPage openAccountPage;
    @BeforeMethod
    public void inIt(){
        bankManagerLoginPage = new BankManagerLoginPage();
        accountPage = new AccountPage();
        customerLoginPage = new CustomerLoginPage();
        openAccountPage = new OpenAccountPage();


    }

    @Test (groups = {"sanity","regression"})
    public void bankManagerShouldAddCustomerSuccessfully() {
        // click On "Bank Manager Login" Tab
        bankManagerLoginPage.clickOnBankManagerLogin();
        //	click On "Add Customer" Tab
        bankManagerLoginPage.clickOnAddCustomerTab();
        //	enter FirstName
        bankManagerLoginPage.enterFirstName("Harry");
        //	enter LastName
        bankManagerLoginPage.enterLastName("Potter");
        //	enter PostCode
        bankManagerLoginPage.enterPostCode("123456");
        //	click On "Add Customer" Button
        bankManagerLoginPage.clickOnAddCustomerSubmitTab();
        //	popup display verify message "Customer added successfully"
        String expectedText = "Customer added successfully with customer id :6";
        String actualText = bankManagerLoginPage.verifyTextFromPopUp();
        Assert.assertEquals(actualText, expectedText, "No such message found");
        //	click on "ok" button on popup.
        bankManagerLoginPage.acceptAlert();
    }

    @Test (groups = {"smoke","regression"})
    public void bankManagerShouldOpenAccountSuccessfully() {
        //click On "Bank Manager Login" Tab
        openAccountPage.clickOnBankManagerLogin();
        //	click On "Open Account" Tab
        openAccountPage.clickOnOpenAccountTab();
        //	Search customer that created in first test
        openAccountPage.clickAndSelectCustomerName();
        //	Select currency "Pound"
        openAccountPage.clickAndSelectCurrencyType();
        //	click on "process" button
        openAccountPage.clickOnProcessButtonTab();
        //	popup displayed
        //	verify message "Account created successfully"
        String expectedText = "Account created successfully with account Number :1016";
        String actualText = openAccountPage.verifyTextFromPopUp();
        Assert.assertEquals(actualText, expectedText, "No such message found");
        //	click on "ok" button on popup.
        openAccountPage.acceptAlert();
    }

    @Test (groups = {"regression"})
    public void customerShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        //click on "Customer Login" Tab
        customerLoginPage.clickOnCustomerLogin();
        //	search customer that you created.
        customerLoginPage.clickAndSelectCustomerName();
        //	click on "Login" Button
        customerLoginPage.clickOnCustomerLoginTab();
        Thread.sleep(1000);
        String expectedText1 = "Logout";
        String actualText1= customerLoginPage.verifyLogoutMessage();
        Assert.assertEquals(actualText1, expectedText1, "No such message found");
        //	click on "Logout"
        customerLoginPage.clickOnCustomerLogoutTab();
        //	verify "Your Name" text displayed.
        String expectedText = "Your Name :";
        String actualText = customerLoginPage.verifyCustomerNameIsDisplayed();
        Assert.assertEquals(actualText, expectedText, "No such message found");
    }

    @Test (groups = {"regression"})
    public void customerShouldDepositMoneySuccessfully() {
        //click on "Customer Login" Tab
        customerLoginPage.clickOnCustomerLogin();
        //	search customer that you created.
        customerLoginPage.clickAndSelectCustomerName();
        //	click on "Login" Button
        customerLoginPage.clickOnCustomerLoginTab();
        //	click on "Deposit" Tab
        accountPage.clickOnDepositTab();
        //	Enter amount 100
        accountPage.enterAmount("100");
        //	click on "Deposit" Button
        accountPage.clickOnSubmitDepositTab();
        //	verify message "Deposit Successful"
        String expectedText = "Deposit Successful";
        String actualText = accountPage.verifyDepositSuccessfullyTextMessage();
        Assert.assertEquals(actualText, expectedText, "No such message found");


    }

    @Test(groups = {"regression"})
    public void customerShouldWithdrawMoneySuccessfully() throws InterruptedException{
        customerLoginPage.clickOnCustomerLogin();
        openAccountPage.clickAndSelectCustomerName();
        customerLoginPage.clickOnCustomerLoginTab();
        Thread.sleep(1000);
        accountPage.userClickOnWithDrawl();
        Thread.sleep(3000);
        // accountPage.selectPoundSign();
        accountPage.userClickOnAmountToBeWithDrawn50();
        accountPage.userClickOnWithdrawButton();
        String ExpectedMessage = "Transaction successful";
        Assert.assertEquals(accountPage.verifyTransactionMessage(),ExpectedMessage,"No messageDisplayed");



    }

}
