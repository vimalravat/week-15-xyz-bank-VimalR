package com.xyzbank.pages;

import com.aventstack.extentreports.Status;
import com.xyzbank.customlisteners.CustomListeners;
import com.xyzbank.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[@ng-click='deposit()']")
    WebElement depositTab;
     public void clickOnDepositTab() {
        CustomListeners.test.log(Status.PASS, "Click on bank manager login button ");
        clickOnElement(depositTab);
    }
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement amountTab;

    public void enterAmount(String amount){
        CustomListeners.test.log(Status.PASS, "Enter amount"+ amount);
               sendTextToElement(amountTab, amount);
    }
    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitDepositTab;
     public void clickOnSubmitDepositTab() {
        CustomListeners.test.log(Status.PASS, "Click on submit button ");
        clickOnElement(submitDepositTab);
    }
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Deposit Successful')]")
    WebElement depositSuccessfullyText;

    public String verifyDepositSuccessfullyTextMessage(){
        CustomListeners.test.log(Status.PASS, "verify deposit ");
        return getTextFromElement(depositSuccessfullyText);
    }
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Deposit Successful')]")
    WebElement withdrawalTab;


    public void clickOnWithdrawalTab() {
        CustomListeners.test.log(Status.PASS, "click on withdrawal ");
        clickOnElement(withdrawalTab);
    }
    By withdrawalAmountTab= By.xpath("//input[@placeholder='amount']");
    public void enterWithdrawalAmount(String amount){
        CustomListeners.test.log(Status.PASS, "Enter amount"+ amount);
        sendTextToElement(withdrawalAmountTab, amount);
    }
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Deposit Successful')]")
    WebElement withdrawTab;

    public void clickOnWithdrawTransactionTab() {
        CustomListeners.test.log(Status.PASS, "click on withdrawal submit ");
        clickOnElement(withdrawTab);
    }
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Deposit Successful')]")
    WebElement withdrawalSuccessfullyText;

    public String verifyWithdrawalSuccessfullyTextMessage(){
        return getTextFromElement(withdrawalSuccessfullyText);
    }
    @CacheLookup
    @FindBy(xpath = "//div[@class='borderM box padT20 ng-scope']/div[3]/button[2]")
    WebElement clickOnDeposit;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement clickOnAmount ;

    @CacheLookup
    @FindBy(xpath = "//form[@role='form']/button")
    WebElement clickOnDepositButton ;
    @CacheLookup
    @FindBy(xpath = "//span[text()='Deposit Successful']")
    WebElement verifyDepositSuccessFull ;
    @CacheLookup
    @FindBy(xpath = "//div[@class='borderM box padT20 ng-scope']/div[3]/button[3]")
    WebElement clickOnWithDrawl ;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement clickOnWithdrawButton ;

    @CacheLookup
    @FindBy(xpath = "//span[text()='Transaction successful']")
    WebElement verifyTransactionMessage ;

    @CacheLookup
    @FindBy(xpath = "//select[@id='accountSelect']")
    WebElement selctPoumdSign ;



    public void userClickOnDeposit(){

        clickOnElement(clickOnDeposit);

    }
    public void userClickOnAmountToBeDepositedAndAdded100(){
        clickOnElement(clickOnAmount);
        sendTextToElement(clickOnAmount,"100");
    }

    public void userClickOnDepositButton(){
        clickOnElement(clickOnDepositButton);
    }
    // By verifyDepositSuccessFull = By.xpath("//span[text()='Deposit Successful']");
    public String userVerifyDepositSuccessFull(){
        return getTextFromElement(verifyDepositSuccessFull);
    }
    //   By clickOnWithDrawl = By.xpath("//div[@class='borderM box padT20 ng-scope']/div[3]/button[3]");
    public void userClickOnWithDrawl(){
        clickOnElement(clickOnWithDrawl);
    }
    By withdrawAmount = By.xpath("//input[@placeholder='amount']");
    public void
    userClickOnAmountToBeWithDrawn50(){
        clickOnElement(clickOnAmount);
        sendTextToElement(clickOnAmount,"50");
    }

    // By clickOnWithdrawButton = By.xpath("//button[@type='submit']");
    public void userClickOnWithdrawButton(){
        clickOnElement(clickOnWithdrawButton);
    }


    //  By verifyTransactionMessage = By.xpath("//span[text()='Transaction successful']");
    public String verifyTransactionMessage(){
        return getTextFromElement(verifyTransactionMessage);

    }
    // By selctPoumdSign =By.xpath("//select[@id='accountSelect']");
    public void selectPoundSign(){
        clickOnElement(selctPoumdSign);
        selectByIndexFromDropDown(selctPoumdSign,1);
        clickOnElement(selctPoumdSign);
    }

}
