package com.au.conformity.pages;

import com.au.conformity.util.HelperMethods;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * POM class covers UI locators and functions for Login and SignIn pages
 *
 */
public class LoginSignInPage extends BasePage {

    @FindBy(how = How.NAME, using = "username")
    WebElement username;

    @FindBy(how = How.NAME, using = "repeatedPassword")
    WebElement repeatedPassword;

    @FindBy(how = How.NAME, using = "password")
    WebElement password;

    @FindBy(how = How.NAME, using = "signon")
    WebElement signon;

    @FindBy(how = How.NAME, using = "account.firstName")
    WebElement firstName;

    @FindBy(how = How.NAME, using = "account.lastName")
    WebElement lastName;

    @FindBy(how = How.NAME, using = "account.email")
    WebElement email;

    @FindBy(how = How.NAME, using = "account.phone")
    WebElement phone;

    @FindBy(how = How.NAME, using = "account.address2")
    WebElement address2;

    @FindBy(how = How.NAME, using = "account.address1")
    WebElement address1;

    @FindBy(how = How.NAME, using = "account.city")
    WebElement city;

    @FindBy(how = How.NAME, using = "account.state")
    WebElement state;


    @FindBy(how = How.NAME, using = "account.country")
    WebElement country;

    @FindBy(how = How.NAME, using = "account.zip")
    WebElement zip;

    @FindBy(how = How.NAME, using = "newAccount")
    WebElement saveAccount;

    @FindBy(how = How.PARTIAL_LINK_TEXT, using = "Register")
    WebElement register;

    @FindBy(xpath = "//a[contains(text(),'Sign')]")
    WebElement signIn;

    @FindBy(css = "#WelcomeContent")
    WebElement welcomeName;

    @FindBy(partialLinkText = "My Account")
    WebElement myAccountLink;

    boolean flag ;
    String passwordGen;
    String userGen;

    public LoginSignInPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickToRegister(){
        click(register);
    }
    public void enterUsername(){
        userGen=HelperMethods.generateUserNamePassword();
        sendText(username, userGen);
    }


    public void enterLoginDetails() throws InterruptedException {
        sendText(username, userGen);
        sendText(password, passwordGen);
        clickLogin();
    }


    public void enterUserLoginDetails() throws InterruptedException {
        sendText(username, "Test1234");
        sendText(password, "Test123");
        clickLogin();
    }

    public void clickSignIn(){
        click(signIn);
    }


    public void enterPassword(){
        passwordGen =HelperMethods.generateUserNamePassword();
        sendText(password,passwordGen);

    }
    public void clickLogin(){
       click(signon);
    }

    public void enterRepeatedPassword(){
        sendText(repeatedPassword,passwordGen);
    }
    public void clickRegister(){
        click(register);
    }

    public void clickSaveAccount(){
        click(saveAccount);
    }


    public void registerUser() throws InterruptedException {
        clickRegister();
        addRegistrationDetails();
        clickSignIn();
        enterLoginDetails();
    }

    public boolean welcomeFirstNameIsDisplayed(String firstName)  {
        String name = getText(welcomeName);
        flag = name.contains(firstName);
        return flag;
    }

    public boolean myAccountIsDisplayed()  {
        flag =myAccountLink.isDisplayed();
         return flag;
    }


    // Hard coded values , could have achieved better with data files etc..
    public void addRegistrationDetails()  {
        enterUsername();
        enterPassword();
        enterRepeatedPassword();
        sendText(firstName,"Rhea");
        sendText(lastName,"Basu");
        sendText(email,"rheabasu54@gmail.com");
        sendText(phone,"0433875311");
        sendText(address1,"abc temp");
        sendText(address2,"near school");
        sendText(city,"Sydney");
        sendText(state,"NSW");
        sendText(country,"Australia");
        sendText(zip,"2065");
        clickSaveAccount();


    }

}
