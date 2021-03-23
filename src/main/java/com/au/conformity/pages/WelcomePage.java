package com.au.conformity.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 *  class covers UI locators
 *
 */
public class WelcomePage extends BasePage {

    @FindBy(xpath = "//a[contains(text(),'Enter the Store')]")
    WebElement storeLink;

    @FindBy(css = "#Content > h2")
    WebElement welcomeText;

    @FindBy(xpath = "//a[contains(text(),'Sign')]")
    WebElement signIn;

    @FindBy(xpath = "//*[@id=\"MainImageContent\"]")
    WebElement mainImage;

    @FindBy(tagName = "img")
    List< WebElement > image_list ;

    public WelcomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
    boolean flag;

    public void clickToEnter(){
        click(storeLink);
    }


    public void clickSignIn(){
        click(signIn);
    }

    public boolean verifyIamOnWelcomePage() throws InterruptedException {
        flag = isElementDisplayed(welcomeText);
        return flag;
    }

    public String verifySplashIsDisplayed(){
       WebElement elements = mainImage.findElement(By.tagName("img"));
       return elements.getAttribute("src");
    }

    public boolean verifyAllPetImagesAreDisplayed(){
        System.out.println("Total Number of images found on page = " + image_list.size());
        ArrayList<String> brokenImages = new ArrayList<>();
        for (int i = 0; i < image_list.size(); i++) {
            if (image_list.get(i).getAttribute("naturalWidth").equals("0"))
            {
                System.out.println(image_list.get(i).getAttribute("outerHTML") + " is broken.");
                brokenImages.add(image_list.get(i).getAttribute("outerHTML"));

            }
        }
        flag= brokenImages.size()<=0;
        return flag;
    }

}
