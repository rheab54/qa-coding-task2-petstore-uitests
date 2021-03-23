package com.au.conformity.pages;

import com.au.conformity.util.HelperMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * POM class covers UI locators and functions for Login and SignIn pages
 *
 */
public class PetCatalogPage extends BasePage {
    @FindBy(css = "#SidebarContent > a:nth-child(1)")
    WebElement fish;

    @FindBy(css = "#SidebarContent > a:nth-child(4)")
    WebElement dogs;

    @FindBy(css = "#SidebarContent > a:nth-child(13)")
    WebElement birds;

    @FindBy(css = "#WelcomeContent")
    WebElement welcomeName;

    @FindBy(partialLinkText = "FI-SW-01")
    WebElement angelFish;

    @FindBy(partialLinkText = "EST-1")
    WebElement largeAngelFish;

    @FindBy(partialLinkText = "K9-BD-01")
    WebElement bulldog;

    @FindBy(partialLinkText = "AV-CB-01")
    WebElement parrot;

    @FindBy(partialLinkText = "Return to Main Menu")
    WebElement returnToMainMenu;

    @FindBy(className = "Button")
    WebElement addToCart;

    @FindBy(id = "Cart")
    WebElement cart;
    @FindBy(css = "#Cart > form > table > tbody > tr")
    List<WebElement> tableItems ;

    boolean flag ;


    public PetCatalogPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void addFishToCart()  {
        click(fish);
        click(angelFish);
        click(addToCart);

    }

    public void addDogToCart()  {
        click(dogs);
        click(bulldog);
        click(addToCart);

    }

    public void addBirdToCart() {
        click(birds);
        click(parrot);
        click(addToCart);

    }
    public void returnToMainMenu()  {
        click(returnToMainMenu);
    }


    public boolean verifyItemsIsAddedToCart(String nameOfItem){
        for (int i = 0; i < tableItems.size(); i++) {
            String temp= tableItems.get(i).getText();
            if(temp.contains(nameOfItem)){
                return true;
            }
        }
        return false;
    }
}
